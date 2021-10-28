import 'package:aadhaar_address_update/utils/size_helpers.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class LandlordNotifications extends StatefulWidget {
  const LandlordNotifications({Key? key}) : super(key: key);

  @override
  _LandlordNotificationsState createState() => _LandlordNotificationsState();
}

class _LandlordNotificationsState extends State<LandlordNotifications> {
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
            SizedBox(
              height: displayHeight(context) * 0.77,
              child: ListView.builder(
                physics: const BouncingScrollPhysics(),
                itemCount: 20,
                itemBuilder: (context, index) {
                  return Container();
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
