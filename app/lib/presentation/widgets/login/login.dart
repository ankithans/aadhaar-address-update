import 'package:aadhaar_address_update/presentation/screens/home.dart';
import 'package:aadhaar_address_update/presentation/screens/landlord_home.dart';
import 'package:aadhaar_address_update/presentation/screens/tenant_home.dart';
import 'package:aadhaar_address_update/presentation/widgets/common/text_form_field.dart';
import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:flutter/material.dart';

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
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Column(
        children: [
          Padding(
            padding: EdgeInsets.symmetric(
              horizontal: displayWidth(context) * 0.05,
              vertical: displayHeight(context) * 0.1,
            ),
            child: Form(
              key: _formKey,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  CustomTextFormField(
                    hintText: 'UID/Phone Number',
                    textEditingController: uidTextController,
                  ),
                  verify
                      ? Column(
                          children: [
                            CustomTextFormField(
                              hintText: 'Enter OTP',
                              textEditingController: otpTextController,
                            ),
                          ],
                        )
                      : const SizedBox(),
                  Padding(
                    padding: EdgeInsets.symmetric(
                      vertical: displayHeight(context) * 0.01,
                      horizontal: displayWidth(context) * 0.03,
                    ),
                    child: ElevatedButton(
                      onPressed: onPressed,
                      child: Text(verify ? 'Submit' : 'Verify'),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}
