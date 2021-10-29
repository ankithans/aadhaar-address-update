import 'package:aadhaar_address_update/data/models/tenant/tenant_notifcations.dart';
import 'package:aadhaar_address_update/logic/cubit/tenant_notifcations_cubit.dart';
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
  List<Color> colors = [
    const Color(0xff006400),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF20505),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
    const Color(0xffF2A413),
  ];

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
                              : requestNotifications.data.length - 1,
                          itemBuilder: (context, index) {
                            return Container(
                              decoration: BoxDecoration(
                                borderRadius:
                                    const BorderRadius.all(Radius.circular(5)),
                                color:
                                    requestNotifications.data[index].status == 1
                                        ? const Color(0xffF20505)
                                        : requestNotifications
                                                    .data[index].status ==
                                                2
                                            ? const Color(0xffF20505)
                                            : const Color(0xffF2A413),
                              ),
                              padding: const EdgeInsets.all(10),
                              margin: EdgeInsets.only(
                                bottom: displayHeight(context) * 0.015,
                              ),
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(
                                    requestNotifications.data[index].relation,
                                    style: GoogleFonts.montserrat(
                                      color: Colors.white,
                                      fontSize: 13,
                                      fontWeight: FontWeight.w600,
                                    ),
                                  ),
                                  SizedBox(
                                    height: displayHeight(context) * 0.01,
                                  ),
                                  Text(
                                    requestNotifications.data[index].reason,
                                    style: GoogleFonts.montserrat(
                                      color: Colors.white,
                                      fontSize: 12,
                                      fontWeight: FontWeight.w300,
                                    ),
                                  ),
                                ],
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
