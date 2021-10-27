import 'package:aadhaar_address_update/presentation/widgets/common/description_text_form_field.dart';
import 'package:aadhaar_address_update/presentation/widgets/common/elevated_button.dart';
import 'package:aadhaar_address_update/presentation/widgets/common/text_form_field.dart';
import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class TenantRequest extends StatefulWidget {
  const TenantRequest({Key? key}) : super(key: key);

  @override
  _TenantRequestState createState() => _TenantRequestState();
}

class _TenantRequestState extends State<TenantRequest> {
  final _formKey = GlobalKey<FormState>();

  final uidTextController = TextEditingController();
  final relationTextController = TextEditingController();
  final reasonTextController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        physics: const BouncingScrollPhysics(),
        child: Padding(
          padding: EdgeInsets.symmetric(
            horizontal: displayWidth(context) * 0.08,
          ),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              SizedBox(
                height: displayHeight(context) * 0.07,
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        "Request for Address",
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
              SizedBox(
                height: displayHeight(context) * 0.07,
              ),
              Form(
                key: _formKey,
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    CustomTextFormField(
                      title: 'UID/Phone Number of Landlord',
                      hintText: 'xxxx-xxxx-xxxx',
                      textEditingController: uidTextController,
                    ),
                    CustomTextFormField(
                      title: 'Relation with above person?',
                      hintText: 'friend',
                      textEditingController: relationTextController,
                    ),
                    DescriptionCustomTextFormField(
                      title: 'Why do you want his/her address?',
                      hintText: 'reason for the request...',
                      textEditingController: reasonTextController,
                    ),
                    SizedBox(
                      height: displayHeight(context) * 0.01,
                    ),
                    CustomElevatedButton(
                      title: 'submit',
                      onPressed: () {
                        if (_formKey.currentState!.validate()) {
                          setState(() {});
                        }
                      },
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
