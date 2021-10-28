import 'dart:convert';

import 'package:aadhaar_address_update/data/ekyc_model.dart';
import 'package:aadhaar_address_update/data/otp_model.dart';
import 'package:aadhaar_address_update/utils/api_endpoints.dart';
import 'package:dio/dio.dart';
import 'dart:developer' as developer;

class APIClient {
  Future<OtpAPI> getOtp(String uid) async {
    try {
      var response = await Dio().post(otpURI + '/' + uid);
      if (response.data['err'] == null) {
        return OtpAPI.fromJson(response.data);
      }
      throw "wrong UID";
    } on DioError catch (e) {
      var error = json.decode(e.response.toString());
      throw error;
    }
  }

  Future<EkycAPI> ekycVerify(String uid, String txn, String otp) async {
    try {
      var response =
          await Dio().post(ekycURI + '/' + uid + '/' + txn + '/' + otp);
      if (response.data['err'] == null) {
        return EkycAPI.fromJson(response.data);
      }
      throw "OTP Entered was Incorreect!";
    } on DioError catch (e) {
      developer.log(e.toString());
      var error = json.decode(e.response.toString());
      throw error;
    }
  }
}
