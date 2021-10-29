import 'package:aadhaar_address_update/logic/cubit/tenant_request_cubit.dart';
import 'package:aadhaar_address_update/presentation/widgets/common/description_text_form_field.dart';
import 'package:aadhaar_address_update/presentation/widgets/common/elevated_button.dart';
import 'package:aadhaar_address_update/presentation/widgets/common/text_form_field.dart';
import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:awesome_dialog/awesome_dialog.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';
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

  bool isLoading = false;
  bool verifyDisable = false;

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
              BlocConsumer<TenantRequestCubit, TenantRequestState>(
                listener: (tenentCubitContext, state) {
                  if (state is TenantRequestLoading) {
                    isLoading = true;
                    verifyDisable = true;
                  }
                  if (state is TenantRequestSuccess) {
                    isLoading = false;
                    verifyDisable = false;

                    // show tick dialogue
                    AwesomeDialog(
                      autoHide: const Duration(milliseconds: 5000),
                      buttonsTextStyle: GoogleFonts.montserrat(),
                      context: context,
                      dialogType: DialogType.SUCCES,
                      animType: AnimType.SCALE,
                      body: Center(
                        child: Column(
                          children: [
                            Text(
                              'Request Successfull',
                              style: GoogleFonts.montserrat(
                                fontSize: 16,
                                fontWeight: FontWeight.w600,
                              ),
                            ),
                            SizedBox(
                              height: displayHeight(context) * 0.01,
                            ),
                            Row(
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                SizedBox(
                                  width: displayWidth(context) * 0.07,
                                ),
                                SizedBox(
                                  width: displayWidth(context) * 0.65,
                                  child: Text(
                                    'We have sent a notification to Landlord regarding your request. Soon you will be recieving update on your request.',
                                    style: GoogleFonts.montserrat(
                                      fontSize: 12,
                                      //   fontWeight: FontWeight.w600,
                                    ),
                                  ),
                                ),
                                SizedBox(
                                  width: displayWidth(context) * 0.005,
                                ),
                              ],
                            ),
                            // SizedBox(
                            //   height: displayHeight(context) * 0.01,
                            // ),
                          ],
                        ),
                      ),
                      btnOkOnPress: () {},
                    ).show();

                    uidTextController.clear();
                    relationTextController.clear();
                    reasonTextController.clear();
                  }
                  if (state is TenantRequestFailure) {
                    isLoading = false;
                    verifyDisable = false;
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(
                        content: Text(state.err),
                      ),
                    );
                  }
                },
                builder: (context, state) {
                  return Form(
                    key: _formKey,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        CustomTextFormField(
                          disable: verifyDisable,
                          title: 'UID/Phone Number of Landlord',
                          hintText: 'xxxx-xxxx-xxxx',
                          textEditingController: uidTextController,
                        ),
                        CustomTextFormField(
                          disable: verifyDisable,
                          title: 'Relation with above person?',
                          hintText: 'friend',
                          textEditingController: relationTextController,
                        ),
                        DescriptionCustomTextFormField(
                          disable: verifyDisable,
                          title: 'Why do you want his/her address?',
                          hintText: 'reason for the request...',
                          textEditingController: reasonTextController,
                        ),
                        SizedBox(
                          height: displayHeight(context) * 0.01,
                        ),
                        CustomElevatedButton(
                          disable: verifyDisable,
                          title: isLoading
                              ? const SpinKitThreeBounce(
                                  color: Colors.white,
                                  size: 20.0,
                                )
                              : Text(
                                  'submit',
                                  style: GoogleFonts.montserrat(
                                    fontWeight: FontWeight.w500,
                                  ),
                                ),
                          onPressed: () {
                            if (_formKey.currentState!.validate()) {
                              BlocProvider.of<TenantRequestCubit>(context)
                                  .submitRequestForm(
                                uidTextController.text,
                                relationTextController.text,
                                reasonTextController.text,
                              );
                            }
                          },
                        ),
                      ],
                    ),
                  );
                },
              ),
            ],
          ),
        ),
      ),
    );
  }
}
