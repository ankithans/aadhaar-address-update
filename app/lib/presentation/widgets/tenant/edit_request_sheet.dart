import 'package:aadhaar_address_update/data/models/tenant/tenant_notifcations.dart';
import 'package:aadhaar_address_update/logic/cubit/tenant_notifcations_cubit.dart';
import 'package:aadhaar_address_update/presentation/widgets/common/description_text_form_field.dart';
import 'package:aadhaar_address_update/presentation/widgets/common/elevated_button.dart';
import 'package:aadhaar_address_update/presentation/widgets/common/text_form_field.dart';
import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';
import 'package:google_fonts/google_fonts.dart';

class EditRequestSheet extends StatefulWidget {
  int index;
  bool disable;
  bool isLoadingSheet;
  bool buttonDisable;
  TextEditingController relationTextController;
  TextEditingController messageTextController;
  TenantNotifications requestNotifications;

  EditRequestSheet({
    Key? key,
    required this.index,
    required this.disable,
    required this.isLoadingSheet,
    required this.buttonDisable,
    required this.relationTextController,
    required this.messageTextController,
    required this.requestNotifications,
  }) : super(key: key);

  @override
  _EditRequestSheetState createState() => _EditRequestSheetState();
}

class _EditRequestSheetState extends State<EditRequestSheet> {
  @override
  Widget build(BuildContext context) {
    return Container(
      padding: MediaQuery.of(context).viewInsets,
      // height:
      //     displayHeight(context) * 0.65,
      child: Padding(
        padding: EdgeInsets.symmetric(
          horizontal: displayWidth(context) * 0.06,
          vertical: displayHeight(context) * 0.04,
        ),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Form(
              child: Column(
                children: [
                  CustomTextFormField(
                    title: 'Relation',
                    hintText: 'relation',
                    textEditingController: widget.relationTextController,
                    disable: widget.disable,
                  ),
                  DescriptionCustomTextFormField(
                    title: 'Your Message',
                    hintText: 'message',
                    textEditingController: widget.messageTextController,
                    disable: widget.disable,
                  ),
                ],
              ),
            ),
            SizedBox(
              height: displayHeight(context) * 0.02,
            ),
            CustomElevatedButton(
              title: widget.isLoadingSheet
                  ? const SpinKitThreeBounce(
                      color: Colors.white,
                      size: 20.0,
                    )
                  : Text('Save Details',
                      style: GoogleFonts.montserrat(
                        fontWeight: FontWeight.w500,
                      )),
              onPressed: () {
                // setState1(() {
                //   widget.isLoadingSheet = true;
                // });

                BlocProvider.of<TenantNotifcationsCubit>(context)
                    .tenantUpdateRequest(
                  widget.requestNotifications.data[widget.index].id,
                  widget.messageTextController.text,
                  widget.relationTextController.text,
                );
              },
              disable: widget.buttonDisable,
            ),
            SizedBox(
              height: displayHeight(context) * 0.01,
            ),
            CustomElevatedButton(
              color: const Color(0xffF20505),
              title: Text('Delete Request',
                  style: GoogleFonts.montserrat(
                    fontWeight: FontWeight.w500,
                  )),
              onPressed: () {
                BlocProvider.of<TenantNotifcationsCubit>(context)
                    .deleteTenantRequest(
                  widget.requestNotifications.data[widget.index].id,
                );
              },
              disable: widget.buttonDisable,
            ),
          ],
        ),
      ),
    );
  }
}
