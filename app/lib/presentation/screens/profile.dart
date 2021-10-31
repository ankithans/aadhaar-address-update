import 'package:aadhaar_address_update/data/repository/profile_service.dart';
import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:flutter/material.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';
import 'package:google_fonts/google_fonts.dart';

class ProfilePage extends StatefulWidget {
  const ProfilePage({Key? key}) : super(key: key);

  @override
  _ProfilePageState createState() => _ProfilePageState();
}

class _ProfilePageState extends State<ProfilePage> {
  final Future<Profile> _profile = ProfileService.getProfile();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: FutureBuilder<Profile>(
          future: _profile,
          builder: (context, snapshot) {
            if (snapshot.hasError) {
              return Center(
                child: Text(
                  "Error in fetching profile",
                  style: GoogleFonts.montserrat(),
                ),
              );
            }
            return snapshot.connectionState == ConnectionState.done
                ? SingleChildScrollView(
                    physics:
                        const ScrollPhysics(parent: BouncingScrollPhysics()),
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.start,
                      children: [
                        SizedBox(
                          height: displayHeight(context) * 0.07,
                        ),
                        Padding(
                          padding: EdgeInsets.symmetric(
                            horizontal: displayWidth(context) * 0.07,
                          ),
                          child: Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: [
                              Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(
                                    "Notifications",
                                    style: GoogleFonts.montserrat(
                                      fontSize: 18,
                                      fontWeight: FontWeight.w600,
                                    ),
                                  ),
                                  SizedBox(
                                    height: displayHeight(context) * 0.01,
                                  ),
                                  Text(
                                    "Hello, welcome back to your account",
                                    style: GoogleFonts.montserrat(
                                      fontSize: 12,
                                      fontWeight: FontWeight.w300,
                                    ),
                                  ),
                                ],
                              ),
                              Image.network(
                                "https://upload.wikimedia.org/wikipedia/en/thumb/c/cf/Aadhaar_Logo.svg/1200px-Aadhaar_Logo.svg.png",
                                height: displayHeight(context) * 0.05,
                              ),
                            ],
                          ),
                        ),
                        SizedBox(
                          height: displayHeight(context) * 0.07,
                        ),
                        Padding(
                          padding:
                              const EdgeInsets.fromLTRB(15.0, 0.0, 15.0, 0.0),
                          child: ListTile(
                            title: Text(
                              "Name",
                              style: GoogleFonts.montserrat(),
                            ),
                            trailing: Text(
                              snapshot.data!.ekycPoi.name,
                              style: GoogleFonts.montserrat()
                                  .copyWith(fontSize: 18.0),
                            ),
                          ),
                        ),
                        Padding(
                          padding:
                              const EdgeInsets.fromLTRB(15.0, 0.0, 15.0, 0.0),
                          child: ListTile(
                            title: Text(
                              "Phone",
                              style: GoogleFonts.montserrat(),
                            ),
                            trailing: Text(
                              snapshot.data!.ekycPoi.phone,
                              style: GoogleFonts.montserrat()
                                  .copyWith(fontSize: 18.0),
                            ),
                          ),
                        ),
                        Padding(
                          padding:
                              const EdgeInsets.fromLTRB(15.0, 0.0, 15.0, 0.0),
                          child: ListTile(
                            title: Text(
                              "Date of Birth",
                              style: GoogleFonts.montserrat(),
                            ),
                            trailing: Text(
                              snapshot.data!.ekycPoi.dob,
                              style: GoogleFonts.montserrat()
                                  .copyWith(fontSize: 18.0),
                            ),
                          ),
                        ),
                        Padding(
                          padding:
                              const EdgeInsets.fromLTRB(15.0, 0.0, 15.0, 0.0),
                          child: ListTile(
                            title: Text(
                              "Gender",
                              style: GoogleFonts.montserrat(),
                            ),
                            trailing: Text(
                              snapshot.data!.ekycPoi.gender,
                              style: GoogleFonts.montserrat()
                                  .copyWith(fontSize: 18.0),
                            ),
                          ),
                        ),
                        Padding(
                          padding: const EdgeInsets.all(30.0),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                "Address",
                                style: GoogleFonts.montserrat()
                                    .copyWith(fontSize: 18),
                              ),
                              const SizedBox(
                                height: 10.0,
                              ),
                              Text(
                                snapshot.data!.ekycPoa
                                    .toJson()
                                    .keys
                                    .map((e) =>
                                        snapshot.data!.ekycPoa.toJson()[e])
                                    .join(", "),
                                style: GoogleFonts.montserrat().copyWith(
                                  fontSize: 18.0,
                                ),
                              ),
                            ],
                          ),
                        ),
                      ],
                    ),
                  )
                : Center(
                    heightFactor: displayHeight(context) * 0.024,
                    child: const SpinKitThreeBounce(
                      color: Color(0xffF2A413),
                      size: 30.0,
                    ),
                  );
          }),
    );
  }
}
