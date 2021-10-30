import 'dart:developer';

import 'package:aadhaar_address_update/data/models/tenant/tenant_notifcations.dart';
import 'package:aadhaar_address_update/logic/cubit/tenant_notifcations_cubit.dart';
import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';
import 'package:google_fonts/google_fonts.dart';

class LandlordNotifications extends StatefulWidget {
  const LandlordNotifications({Key? key}) : super(key: key);

  @override
  _LandlordNotificationsState createState() => _LandlordNotificationsState();
}

class _LandlordNotificationsState extends State<LandlordNotifications> {
  @override
  void initState() {
    BlocProvider.of<TenantNotifcationsCubit>(context)
        .getLandlordNotifications();
    super.initState();
  }

  TenantNotifications requestNotifications =
      TenantNotifications(status: "", data: []);
  bool isLoading = false;
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
                              onPressed: () async {
                                log(
                                    requestNotifications.data[index].status
                                        .toString(),
                                    name: "Status");
                                if (requestNotifications.data[index].status !=
                                    0) {
                                  return;
                                } else {
                                  await showModalBottomSheet(
                                      context: context,
                                      builder: (context) {
                                        return Container(
                                          decoration: const BoxDecoration(
                                              borderRadius:
                                                  BorderRadius.vertical(
                                                      top: Radius.circular(
                                                          50.0))),
                                          height: 100,
                                          child: Row(
                                            mainAxisAlignment:
                                                MainAxisAlignment.spaceEvenly,
                                            children: <Widget>[
                                              Text("Accept Request?",
                                                  style: GoogleFonts.montserrat(
                                                      fontWeight:
                                                          FontWeight.bold)),
                                              ElevatedButton(
                                                onPressed: () {
                                                  log(
                                                      requestNotifications
                                                          .data[index]
                                                          .toString(),
                                                      name:
                                                          "Request Notifications");
                                                  BlocProvider.of<
                                                              TenantNotifcationsCubit>(
                                                          context)
                                                      .updateStatus(
                                                          status: true,
                                                          data:
                                                              requestNotifications
                                                                  .data[index]);
                                                  Navigator.pop(context);
                                                },
                                                child: const Icon(Icons.check,
                                                    color: Colors.white),
                                                style: ElevatedButton.styleFrom(
                                                    shape: const CircleBorder(),
                                                    primary: const Color(
                                                        0xffF2A413)),
                                              ),
                                              IconButton(
                                                  onPressed: () {
                                                    BlocProvider.of<
                                                                TenantNotifcationsCubit>(
                                                            context)
                                                        .updateStatus(
                                                            status: false,
                                                            data:
                                                                requestNotifications
                                                                        .data[
                                                                    index]);
                                                    Navigator.pop(context);
                                                  },
                                                  icon: const Icon(Icons.close,
                                                      color: Color(0xffF2A413)))
                                            ],
                                          ),
                                        );
                                      });
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
                                              : requestNotifications
                                                          .data[index].status ==
                                                      3
                                                  ? Colors.green
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
                                                      : requestNotifications
                                                                  .data[index]
                                                                  .status ==
                                                              3
                                                          ? 'Completed'
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
                                    // SizedBox(
                                    //   height: displayHeight(context) * 0.01,
                                    // ),
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
