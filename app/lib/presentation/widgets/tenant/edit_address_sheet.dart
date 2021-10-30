import 'package:aadhaar_address_update/data/models/tenant/tenant_notifcations.dart';
import 'package:aadhaar_address_update/logic/cubit/tenant_notifcations_cubit.dart';
import 'package:aadhaar_address_update/presentation/widgets/common/elevated_button.dart';
import 'package:aadhaar_address_update/presentation/widgets/common/text_form_field.dart';
import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:google_fonts/google_fonts.dart';

class EditAddressSheet extends StatefulWidget {
  bool buttonDisable;
  TextEditingController houseAddressTextController;
  TextEditingController landmarkAddressTextController;
  TextEditingController districtAddressTextController;
  TextEditingController stateAddressTextController;
  TextEditingController pincodeAddressTextController;
  TextEditingController countryAddressTextController;
  TenantNotifications requestNotifications;
  int index;

  EditAddressSheet({
    Key? key,
    required this.buttonDisable,
    required this.houseAddressTextController,
    required this.landmarkAddressTextController,
    required this.districtAddressTextController,
    required this.stateAddressTextController,
    required this.pincodeAddressTextController,
    required this.countryAddressTextController,
    required this.requestNotifications,
    required this.index,
  }) : super(key: key);

  @override
  _EditAddressSheetState createState() => _EditAddressSheetState();
}

class _EditAddressSheetState extends State<EditAddressSheet> {
  @override
  Widget build(BuildContext context) {
    return Container(
      padding: MediaQuery.of(context).viewInsets,
      // height:
      //     displayHeight(context) * 0.78,
      child: Padding(
        padding: EdgeInsets.symmetric(
          horizontal: displayWidth(context) * 0.06,
          vertical: displayHeight(context) * 0.04,
        ),
        child: SingleChildScrollView(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              SingleChildScrollView(
                child: Form(
                  child: Column(
                    children: [
                      CustomTextFormField(
                        title: 'H.No or Flat',
                        hintText: 'H.No or Flat',
                        textEditingController:
                            widget.houseAddressTextController,
                        disable: widget.requestNotifications.data[widget.index]
                                .status ==
                            3,
                      ),
                      CustomTextFormField(
                          title: 'Landmark',
                          hintText: 'Landmark',
                          textEditingController:
                              widget.landmarkAddressTextController,
                          disable: widget.requestNotifications
                                  .data[widget.index].status ==
                              3),
                      CustomTextFormField(
                        title: 'District',
                        hintText: 'district',
                        textEditingController:
                            widget.districtAddressTextController,
                        disable: true,
                      ),
                      CustomTextFormField(
                        title: 'State',
                        hintText: 'state',
                        textEditingController:
                            widget.stateAddressTextController,
                        disable: true,
                      ),
                      CustomTextFormField(
                        title: 'Country',
                        hintText: 'country',
                        textEditingController:
                            widget.countryAddressTextController,
                        disable: true,
                      ),
                      CustomTextFormField(
                        title: 'Pincode',
                        hintText: 'pincode',
                        textEditingController:
                            widget.pincodeAddressTextController,
                        disable: true,
                      ),
                    ],
                  ),
                ),
              ),
              SizedBox(
                height: displayHeight(context) * 0.02,
              ),
              CustomElevatedButton(
                title: Text('Verify and Submit Address',
                    style: GoogleFonts.montserrat(
                      fontWeight: FontWeight.w500,
                    )),
                onPressed: () {
                  BlocProvider.of<TenantNotifcationsCubit>(context)
                      .tenantAcceptAddress(
                    widget.countryAddressTextController.text,
                    widget.districtAddressTextController.text,
                    widget.houseAddressTextController.text,
                    widget.landmarkAddressTextController.text,
                    widget.landmarkAddressTextController.text,
                    widget.pincodeAddressTextController.text,
                    widget.stateAddressTextController.text,
                    'vtc',
                    'street',
                  );
                },
                disable:
                    widget.requestNotifications.data[widget.index].status == 3,
              ),
              SizedBox(
                height: displayHeight(context) * 0.01,
              ),
              CustomElevatedButton(
                color: Colors.red,
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
                disable:
                    widget.requestNotifications.data[widget.index].status == 3,
              ),
            ],
          ),
        ),
      ),
    );
  }
}
