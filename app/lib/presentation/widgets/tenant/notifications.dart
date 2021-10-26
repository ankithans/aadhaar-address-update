import 'package:flutter/material.dart';

class TenantNotifications extends StatefulWidget {
  const TenantNotifications({Key? key}) : super(key: key);

  @override
  _TenantNotificationsState createState() => _TenantNotificationsState();
}

class _TenantNotificationsState extends State<TenantNotifications> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ListView.builder(
        itemCount: 6,
        itemBuilder: (context, index) {
          return Container();
        },
      ),
    );
  }
}
