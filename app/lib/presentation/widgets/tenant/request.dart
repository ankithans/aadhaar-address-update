import 'package:aadhaar_address_update/presentation/widgets/common/text_form_field.dart';
import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:flutter/material.dart';

class TenantRequest extends StatefulWidget {
  const TenantRequest({Key? key}) : super(key: key);

  @override
  _TenantRequestState createState() => _TenantRequestState();
}

class _TenantRequestState extends State<TenantRequest> {
  final _formKey = GlobalKey<FormState>();

  final uidTextController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          children: [
            Form(
              key: _formKey,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  CustomTextFormField(
                    hintText: 'UID/Phone Number of Landlord',
                    textEditingController: uidTextController,
                  ),
                  Padding(
                    padding: EdgeInsets.symmetric(
                      vertical: displayHeight(context) * 0.01,
                      horizontal: displayWidth(context) * 0.03,
                    ),
                    child: ElevatedButton(
                      onPressed: () {
                        if (_formKey.currentState!.validate()) {
                          setState(() {});
                        }
                      },
                      child: const Text('Submit'),
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
