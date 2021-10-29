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

class TenantNotificationsWidget extends StatefulWidget {
  const TenantNotificationsWidget({Key? key}) : super(key: key);

  @override
  _TenantNotificationsWidgetState createState() =>
      _TenantNotificationsWidgetState();
}

class _TenantNotificationsWidgetState extends State<TenantNotificationsWidget> {
  bool disable = false;
  bool buttonDisable = false;
  final relationTextController = TextEditingController();
  final messageTextController = TextEditingController();
  final houseAddressTextController = TextEditingController();
  final landmarkAddressTextController = TextEditingController();
  final districtAddressTextController = TextEditingController();
  final stateAddressTextController = TextEditingController();
  final countryAddressTextController = TextEditingController();
  final pincodeAddressTextController = TextEditingController();

  @override
  void initState() {
    super.initState();
    BlocProvider.of<TenantNotifcationsCubit>(context).getTenantNotifications();
  }

  bool isLoading = false;
  TenantNotifications requestNotifications =
      TenantNotifications(status: "", data: []);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: EdgeInsets.symmetric(
          horizontal: displayWidth(context) * 0.07,
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
            SizedBox(
              height: displayHeight(context) * 0.02,
            ),
            BlocConsumer<TenantNotifcationsCubit, TenantNotifcationsState>(
              listener: (tenentNotificationsContext, state) {
                if (state is TenantNotificationsLoading) {
                  isLoading = true;
                }
                if (state is TenantNotificationsLoaded) {
                  isLoading = false;
                  requestNotifications = state.tenantNotifications;
                }
                if (state is TenantNotificationsFailure) {
                  isLoading = false;
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(
                      content: Text(state.err),
                    ),
                  );
                }
              },
              builder: (context, state) {
                return state is TenantNotificationsLoading
                    ? Center(
                        heightFactor: displayHeight(context) * 0.024,
                        child: const SpinKitThreeBounce(
                          color: Color(0xffF2A413),
                          size: 30.0,
                        ),
                      )
                    : SizedBox(
                        height: displayHeight(context) * 0.77,
                        child: ListView.builder(
                          physics: const BouncingScrollPhysics(),
                          itemCount: requestNotifications.data.isEmpty
                              ? 0
                              : requestNotifications.data.length,
                          itemBuilder: (context, index) {
                            return TextButton(
                              style: TextButton.styleFrom(
                                padding: EdgeInsets.zero,
                              ),
                              onPressed: () {
                                if (requestNotifications.data[index].status ==
                                    0) {
                                  relationTextController.text =
                                      requestNotifications.data[index].relation;
                                  messageTextController.text =
                                      requestNotifications.data[index].reason;
                                  showModalBottomSheet<void>(
                                    isScrollControlled: true,
                                    shape: const RoundedRectangleBorder(
                                      borderRadius: BorderRadius.only(
                                        topLeft: Radius.circular(20),
                                        topRight: Radius.circular(20),
                                      ),
                                    ),
                                    context: context,
                                    builder: (BuildContext context) {
                                      return StatefulBuilder(
                                        builder: (BuildContext context,
                                            StateSetter setState) {
                                          return SizedBox(
                                            height:
                                                displayHeight(context) * 0.65,
                                            child: Padding(
                                              padding: EdgeInsets.symmetric(
                                                horizontal:
                                                    displayWidth(context) *
                                                        0.06,
                                                vertical:
                                                    displayHeight(context) *
                                                        0.04,
                                              ),
                                              child: Column(
                                                crossAxisAlignment:
                                                    CrossAxisAlignment.start,
                                                children: [
                                                  Form(
                                                    child: Column(
                                                      children: [
                                                        CustomTextFormField(
                                                            title: 'Relation',
                                                            hintText:
                                                                'relation',
                                                            textEditingController:
                                                                relationTextController,
                                                            disable: disable),
                                                        DescriptionCustomTextFormField(
                                                            title:
                                                                'Your Message',
                                                            hintText: 'message',
                                                            textEditingController:
                                                                messageTextController,
                                                            disable: disable),
                                                      ],
                                                    ),
                                                  ),
                                                  SizedBox(
                                                    height:
                                                        displayHeight(context) *
                                                            0.02,
                                                  ),
                                                  CustomElevatedButton(
                                                    title: Text('Save Details',
                                                        style: GoogleFonts
                                                            .montserrat(
                                                          fontWeight:
                                                              FontWeight.w500,
                                                        )),
                                                    onPressed: () {},
                                                    disable: buttonDisable,
                                                  ),
                                                  SizedBox(
                                                    height:
                                                        displayHeight(context) *
                                                            0.01,
                                                  ),
                                                  CustomElevatedButton(
                                                    color:
                                                        const Color(0xffF20505),
                                                    title: Text(
                                                        'Delete Request',
                                                        style: GoogleFonts
                                                            .montserrat(
                                                          fontWeight:
                                                              FontWeight.w500,
                                                        )),
                                                    onPressed: () {},
                                                    disable: buttonDisable,
                                                  ),
                                                ],
                                              ),
                                            ),
                                          );
                                        },
                                      );
                                    },
                                  );
                                } else if (requestNotifications
                                        .data[index].status ==
                                    1) {
                                  //   landlordAddressTextController.text =
                                  //       requestNotifications
                                  //           .data[index].landlordAddress;
                                  showModalBottomSheet<void>(
                                    isScrollControlled: true,
                                    shape: const RoundedRectangleBorder(
                                      borderRadius: BorderRadius.only(
                                        topLeft: Radius.circular(20),
                                        topRight: Radius.circular(20),
                                      ),
                                    ),
                                    context: context,
                                    builder: (BuildContext context) {
                                      return StatefulBuilder(
                                        builder: (BuildContext context,
                                            StateSetter setState) {
                                          return SizedBox(
                                            height:
                                                displayHeight(context) * 0.78,
                                            child: Padding(
                                              padding: EdgeInsets.symmetric(
                                                horizontal:
                                                    displayWidth(context) *
                                                        0.06,
                                                vertical:
                                                    displayHeight(context) *
                                                        0.04,
                                              ),
                                              child: Column(
                                                crossAxisAlignment:
                                                    CrossAxisAlignment.start,
                                                children: [
                                                  Form(
                                                    child: Column(
                                                      children: [
                                                        CustomTextFormField(
                                                          title: 'H.No or Flat',
                                                          hintText:
                                                              'H.No or Flat',
                                                          textEditingController:
                                                              houseAddressTextController,
                                                          disable: false,
                                                        ),
                                                        CustomTextFormField(
                                                          title: 'Landmark',
                                                          hintText: 'Landmark',
                                                          textEditingController:
                                                              landmarkAddressTextController,
                                                          disable: false,
                                                        ),
                                                        CustomTextFormField(
                                                          title: 'District',
                                                          hintText: 'district',
                                                          textEditingController:
                                                              districtAddressTextController,
                                                          disable: true,
                                                        ),
                                                        CustomTextFormField(
                                                          title: 'State',
                                                          hintText: 'state',
                                                          textEditingController:
                                                              stateAddressTextController,
                                                          disable: true,
                                                        ),
                                                        CustomTextFormField(
                                                          title: 'Pincode',
                                                          hintText: 'pincode',
                                                          textEditingController:
                                                              pincodeAddressTextController,
                                                          disable: true,
                                                        ),
                                                      ],
                                                    ),
                                                  ),
                                                  SizedBox(
                                                    height:
                                                        displayHeight(context) *
                                                            0.02,
                                                  ),
                                                  CustomElevatedButton(
                                                    title: Text(
                                                        'Verify and Submit Address',
                                                        style: GoogleFonts
                                                            .montserrat(
                                                          fontWeight:
                                                              FontWeight.w500,
                                                        )),
                                                    onPressed: () {},
                                                    disable: buttonDisable,
                                                  ),
                                                  SizedBox(
                                                    height:
                                                        displayHeight(context) *
                                                            0.01,
                                                  ),
                                                  CustomElevatedButton(
                                                    color: Colors.red,
                                                    title: Text(
                                                        'Delete Request',
                                                        style: GoogleFonts
                                                            .montserrat(
                                                          fontWeight:
                                                              FontWeight.w500,
                                                        )),
                                                    onPressed: () {},
                                                    disable: buttonDisable,
                                                  ),
                                                ],
                                              ),
                                            ),
                                          );
                                        },
                                      );
                                    },
                                  );
                                } else {
                                  ScaffoldMessenger.of(context).showSnackBar(
                                    const SnackBar(
                                      content: Text(
                                        'Sorry! Your request has been rejected by Landlord',
                                      ),
                                    ),
                                  );
                                }
                              },
                              child: Container(
                                decoration: BoxDecoration(
                                  borderRadius: const BorderRadius.all(
                                      Radius.circular(5)),
                                  color:
                                      requestNotifications.data[index].status ==
                                              1
                                          ? Colors.green
                                          : requestNotifications
                                                      .data[index].status ==
                                                  2
                                              ? Colors.red
                                              : const Color(0xffF2A413),
                                ),
                                padding: const EdgeInsets.only(
                                  top: 10,
                                  left: 10,
                                  bottom: 10,
                                  // right: 5,
                                ),
                                margin: EdgeInsets.only(
                                  bottom: displayHeight(context) * 0.015,
                                ),
                                child: Row(
                                  mainAxisAlignment:
                                      MainAxisAlignment.spaceBetween,
                                  children: [
                                    Column(
                                      crossAxisAlignment:
                                          CrossAxisAlignment.start,
                                      children: [
                                        Text(
                                          requestNotifications
                                              .data[index].relation,
                                          style: GoogleFonts.montserrat(
                                            color: Colors.white,
                                            fontSize: 13,
                                            fontWeight: FontWeight.w600,
                                          ),
                                        ),
                                        SizedBox(
                                          height: displayHeight(context) * 0.01,
                                        ),
                                        SizedBox(
                                          width: displayWidth(context) * 0.52,
                                          child: Text(
                                            requestNotifications
                                                .data[index].reason,
                                            style: GoogleFonts.montserrat(
                                              color: Colors.white,
                                              fontSize: 12,
                                              fontWeight: FontWeight.w300,
                                            ),
                                          ),
                                        ),
                                      ],
                                    ),
                                    Transform(
                                      transform: Matrix4.identity()
                                        ..scale(0.78),
                                      child: Chip(
                                        label: Text(
                                          requestNotifications
                                                      .data[index].status ==
                                                  0
                                              ? 'In Progress'
                                              : requestNotifications
                                                          .data[index].status ==
                                                      1
                                                  ? 'Approved'
                                                  : 'Rejected',
                                          overflow: TextOverflow.ellipsis,
                                          style: GoogleFonts.montserrat(
                                            color: Colors.white,
                                          ),
                                        ),
                                        backgroundColor:
                                            const Color(0xFFa3bdc4),
                                      ),
                                    ),
                                  ],
                                ),
                              ),
                            );
                          },
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
