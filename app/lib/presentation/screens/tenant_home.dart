import 'package:aadhaar_address_update/presentation/screens/login.dart';
import 'package:aadhaar_address_update/presentation/screens/profile.dart';
import 'package:aadhaar_address_update/presentation/widgets/tenant/notifications.dart';
import 'package:aadhaar_address_update/presentation/widgets/tenant/request.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class TenantHomeScreen extends StatefulWidget {
  const TenantHomeScreen({Key? key}) : super(key: key);

  @override
  State<TenantHomeScreen> createState() => _TenantHomeScreenState();
}

class _TenantHomeScreenState extends State<TenantHomeScreen> {
  int _selectedIndex = 0;
  static const TextStyle optionStyle =
      TextStyle(fontSize: 30, fontWeight: FontWeight.bold);
  static const List<Widget> _widgetOptions = <Widget>[
    TenantRequest(),
    TenantNotificationsWidget(),
    ProfilePage(),
  ];

  static const List<String> _appBarTitleOptions = <String>[
    'Request Landlord for Address',
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
      //   appBar: AppBar(
      //     title: Text(
      //       _appBarTitleOptions.elementAt(_selectedIndex),
      //     ),
      //     actions: [
      //       IconButton(
      //         onPressed: () {
      //           Navigator.pushReplacement(
      //             context,
      //             MaterialPageRoute(
      //               builder: (context) => LoginScreen(),
      //             ),
      //           );
      //         },
      //         icon: const Icon(
      //           Icons.logout,
      //         ),
      //       )
      //     ],
      //   ),
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
            icon: Icon(Icons.request_page),
            label: 'Request',
          ),
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
