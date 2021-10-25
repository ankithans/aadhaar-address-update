from bson.objectid import ObjectId
import motor.motor_asyncio
from decouple import config

MONGO_URI = config("MONGO_URI")
client = motor.motor_asyncio.AsyncIOMotorClient(MONGO_URI)
database = client.students
student_collection = database.get_collection("students_collection")

def student_helper(student):
    return {
        "id": str(student["_id"]),
        "fullname": student["fullname"],
        "email": student["email"],
        "course_of_Study": student["course_of_Study"],
        "year": student["year"],
        "GPA": student["gpa"],
    }


# Retrieves all the students in the database
async def retrieve_students():
    students = []
    async for student in student_collection.find():
        students.append(student_helper(student))
    return students


# Add a new student to database
async def add_student(student_data: dict) -> dict:
    student = await student_collection.insert_one(student_data)
    new_student = await student_collection.find_one({"_id": student.inserted_id})
    return student_helper(new_student)


# Retrive a student with matching id
async def retrieve_student(id: str) -> dict:
    student = await student_collection.find_one({"_id": ObjectId(id)})
    if student:
        return student_helper(student)


# Update a student with maching ID
async def update_student(id: str, data: dict):
    if len(data) < 1:
        return False
    student = await student_collection.find_one({"_id": ObjectId(id)})
    if student:
        updated_student = await student_collection.update_one(
            {"_id": ObjectId(id)}, {"$set": data}
        )
        if updated_student:
            return True
        return False


# Delete a student from database
async def delete_student(id: str):
    student = await student_collection.find_one({"_id": ObjectId(id)})
    if student:
        await student_collection.delete_one({"_id": ObjectId(id)})
        return True 