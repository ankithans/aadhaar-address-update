import 'package:aadhaar_address_update/data/repository/api_client.dart';
import 'package:aadhaar_address_update/logic/cubit/otp_cubit.dart';
import 'package:aadhaar_address_update/presentation/screens/landlord_home.dart';
import 'package:aadhaar_address_update/presentation/screens/login.dart';
import 'package:aadhaar_address_update/presentation/screens/tenant_home.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  APIClient apiClient = APIClient();

  MyApp({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MultiBlocProvider(
      providers: [
        BlocProvider<OtpCubit>(
          create: (otpCubitContext) => OtpCubit(apiClient),
        ),
      ],
      child: MaterialApp(
        title: 'Address Update',
        theme: ThemeData(
          primarySwatch: Colors.blue,
        ),
        home: const LoginScreen(),
      ),
    );
  }
}
