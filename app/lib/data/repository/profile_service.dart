import 'dart:convert';
import 'dart:developer';

import 'package:aadhaar_address_update/data/models/aadhaar/ekyc_poa.dart';
import 'package:aadhaar_address_update/data/models/aadhaar/ekyc_poi.dart';
import 'package:shared_preferences/shared_preferences.dart';

class Profile {
  EkycPoi ekycPoi;
  EkycPoa ekycPoa;
  Profile({required this.ekycPoa, required this.ekycPoi});
}

class ProfileService {
  static late EkycPoi _ekycPoi;
  static late EkycPoa _ekycPoa;
  static Future<Profile> getProfile() async {
    try {
      final SharedPreferences _sharedPreferences =
          await SharedPreferences.getInstance();
      log(_sharedPreferences.getString("poi").toString(), name: "POI");
      log(_sharedPreferences.getString("poa").toString(), name: "POA");
      _ekycPoi = EkycPoi.fromJson(
          jsonDecode(_sharedPreferences.getString("poi") ?? "{}")
              as Map<String, dynamic>);
      _ekycPoa = EkycPoa.fromJson(
          jsonDecode(_sharedPreferences.getString("poa") ?? "{}")
              as Map<String, dynamic>);
      log(_ekycPoa.toString(), name: "POA");
      log(_ekycPoi.toString(), name: "POI");
      return Profile(ekycPoa: _ekycPoa, ekycPoi: _ekycPoi);
    } catch (e) {
      rethrow;
    }
  }
}
