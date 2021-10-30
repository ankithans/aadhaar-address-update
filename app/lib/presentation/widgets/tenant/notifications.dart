import 'package:aadhaar_address_update/data/models/tenant/tenant_notifcations.dart';
import 'package:aadhaar_address_update/logic/cubit/tenant_notifcations_cubit.dart';
import 'package:aadhaar_address_update/presentation/widgets/tenant/edit_address_sheet.dart';
import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';
import 'package:google_fonts/google_fonts.dart';

import 'edit_request_sheet.dart';

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
  bool isLoadingSheet = false;
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

                if (state is TenantNotificationUpdateLoading) {
                  isLoadingSheet = true;
                }
                if (state is TenantNotificationUpdateLoaded) {
                  isLoadingSheet = false;
                  Navigator.pop(context);
                  Future.delayed(const Duration(seconds: 1), () {
                    BlocProvider.of<TenantNotifcationsCubit>(context)
                        .getTenantNotifications();
                  });
                }
                if (state is TenantNotificationUpdateFailure) {
                  isLoadingSheet = false;
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(
                      content: Text(state.err),
                    ),
                  );
                }

                if (state is TenantNotificationDeleteLoading) {
                  isLoadingSheet = true;
                }
                if (state is TenantNotificationDeleteLoaded) {
                  isLoadingSheet = false;
                  Navigator.pop(context);
                  BlocProvider.of<TenantNotifcationsCubit>(context)
                      .getTenantNotifications();
                }
                if (state is TenantNotificationDeleteFailure) {
                  isLoadingSheet = false;
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
                                            StateSetter setState1) {
                                          return EditRequestSheet(
                                              index: index,
                                              disable: disable,
                                              isLoadingSheet: isLoadingSheet,
                                              buttonDisable: buttonDisable,
                                              relationTextController:
                                                  relationTextController,
                                              messageTextController:
                                                  messageTextController,
                                              requestNotifications:
                                                  requestNotifications);
                                        },
                                      );
                                    },
                                  );
                                } else if (requestNotifications
                                        .data[index].status ==
                                    1) {
                                  houseAddressTextController.text =
                                      requestNotifications
                                          .data[index].landlordAddress.house;
                                  landmarkAddressTextController.text =
                                      requestNotifications
                                          .data[index].landlordAddress.lm;
                                  districtAddressTextController.text =
                                      requestNotifications
                                          .data[index].landlordAddress.dist;
                                  stateAddressTextController.text =
                                      requestNotifications
                                          .data[index].landlordAddress.state;
                                  countryAddressTextController.text =
                                      requestNotifications
                                          .data[index].landlordAddress.country;
                                  pincodeAddressTextController.text =
                                      requestNotifications
                                          .data[index].landlordAddress.pc;
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
                                          return EditAddressSheet(
                                            buttonDisable: buttonDisable,
                                            houseAddressTextController:
                                                houseAddressTextController,
                                            landmarkAddressTextController:
                                                landmarkAddressTextController,
                                            districtAddressTextController:
                                                districtAddressTextController,
                                            stateAddressTextController:
                                                stateAddressTextController,
                                            pincodeAddressTextController:
                                                pincodeAddressTextController,
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
                                  top: 5,
                                  left: 12,
                                  bottom: 10,
                                ),
                                margin: EdgeInsets.only(
                                  bottom: displayHeight(context) * 0.015,
                                ),
                                child: Column(
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    Row(
                                      crossAxisAlignment:
                                          CrossAxisAlignment.center,
                                      mainAxisAlignment:
                                          MainAxisAlignment.spaceBetween,
                                      children: [
                                        Text(
                                          requestNotifications
                                              .data[index].relation,
                                          style: GoogleFonts.montserrat(
                                            color: Colors.white,
                                            fontSize: 14,
                                            fontWeight: FontWeight.w600,
                                          ),
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
                                                              .data[index]
                                                              .status ==
                                                          1
                                                      ? 'Approved'
                                                      : 'Rejected',
                                              overflow: TextOverflow.ellipsis,
                                              style: GoogleFonts.montserrat(
                                                color: Colors.white,
                                                fontWeight: FontWeight.w500,
                                              ),
                                            ),
                                            backgroundColor: Colors.grey,
                                          ),
                                        ),
                                      ],
                                    ),
                                    SizedBox(
                                      width: displayWidth(context), // * 0.52,
                                      child: Text(
                                        requestNotifications.data[index].reason,
                                        style: GoogleFonts.montserrat(
                                          color: Colors.white,
                                          fontSize: 12,
                                          fontWeight: FontWeight.w300,
                                        ),
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
