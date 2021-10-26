import 'package:aadhaar_address_update/presentation/widgets/elevated_button.dart';
import 'package:aadhaar_address_update/presentation/widgets/login/login.dart';
import 'package:aadhaar_address_update/presentation/widgets/text_form_field.dart';
import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:flutter/material.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  _LoginScreenState createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Login to your Aadhaar'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.end,
          children: [
            CustomElevatedButton(
              title: 'Login as Tenant',
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => const LoginPage(
                      title: 'Login as Tenant',
                    ),
                  ),
                );
              },
            ),
            CustomElevatedButton(
              title: 'Login as Landlord',
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => const LoginPage(
                      title: 'Login as Landlord',
                    ),
                  ),
                );
              },
            ),
          ],
        ),
      ),
    );
  }
}
