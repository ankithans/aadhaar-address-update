import 'package:aadhaar_address_update/presentation/screens/landlord_home.dart';
import 'package:aadhaar_address_update/presentation/screens/tenant_home.dart';
import 'package:aadhaar_address_update/presentation/widgets/common/elevated_button.dart';
import 'package:aadhaar_address_update/presentation/widgets/common/text_form_field.dart';
import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class LoginPage extends StatefulWidget {
  final String title;
  final String identify;

  const LoginPage({
    Key? key,
    required this.title,
    required this.identify,
  }) : super(key: key);

  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final _formKey = GlobalKey<FormState>();
  final uidTextController = TextEditingController();
  final otpTextController = TextEditingController();

  bool verify = false;

  onPressed() async {
    if (verify && _formKey.currentState!.validate()) {
      Navigator.pop(context);
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(
          builder: (context) => widget.identify == 't'
              ? const TenantHomeScreen()
              : const LandLordHomeScreen(),
        ),
      );
    } else {
      if (_formKey.currentState!.validate()) {
        setState(() {
          verify = true;
        });
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
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
                      "Login " + widget.title,
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
              height: displayHeight(context) * 0.06,
            ),
            Form(
              key: _formKey,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  CustomTextFormField(
                    title: 'UID/Phone Number',
                    hintText: 'xxxx-xxxx-xxxx',
                    textEditingController: uidTextController,
                  ),
                  verify
                      ? Column(
                          children: [
                            CustomTextFormField(
                              title: 'OTP',
                              hintText: 'xxxxxx',
                              textEditingController: otpTextController,
                            ),
                          ],
                        )
                      : const SizedBox(),
                  Padding(
                    padding: EdgeInsets.symmetric(
                      vertical: displayHeight(context) * 0.01,
                    ),
                    child: CustomElevatedButton(
                      title: verify ? 'submit' : 'verify',
                      onPressed: onPressed,
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(
              height: displayHeight(context) * 0.01,
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  "By logging in you agree to the",
                  style: GoogleFonts.montserrat(
                    fontSize: 9,
                    fontWeight: FontWeight.w300,
                  ),
                ),
                Text(
                  " terms and conditions",
                  style: GoogleFonts.montserrat(
                    fontSize: 9,
                    fontWeight: FontWeight.w300,
                    color: Colors.blue,
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
