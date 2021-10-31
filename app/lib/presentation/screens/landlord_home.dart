import 'package:aadhaar_address_update/presentation/screens/login.dart';
import 'package:aadhaar_address_update/presentation/screens/profile.dart';
import 'package:aadhaar_address_update/presentation/widgets/landlord/notifcations.dart';
import 'package:aadhaar_address_update/presentation/widgets/tenant/notifications.dart';
import 'package:aadhaar_address_update/presentation/widgets/tenant/request.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class LandlordHomeScreen extends StatefulWidget {
  const LandlordHomeScreen({Key? key}) : super(key: key);

  @override
  State<LandlordHomeScreen> createState() => _LandlordHomeScreenState();
}

class _LandlordHomeScreenState extends State<LandlordHomeScreen> {
  int _selectedIndex = 0;
  static const TextStyle optionStyle =
      TextStyle(fontSize: 30, fontWeight: FontWeight.bold);
  static const List<Widget> _widgetOptions = <Widget>[
    LandlordNotifications(),
    ProfilePage(),
  ];

  static const List<String> _appBarTitleOptions = <String>[
    'Notifications',
    'Profile'
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      bottomNavigationBar: BottomNavigationBar(
        selectedLabelStyle: GoogleFonts.montserrat(
          fontSize: 13,
        ),
        unselectedLabelStyle: GoogleFonts.montserrat(
          fontSize: 13,
        ),
        fixedColor: const Color(0xffF2A413),
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.notifications),
            label: 'Notifications',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person),
            label: 'Profile',
          ),
        ],
        currentIndex: _selectedIndex,
        onTap: _onItemTapped,
      ),
      body: Center(
        child: _widgetOptions.elementAt(_selectedIndex),
      ),
    );
  }
}
