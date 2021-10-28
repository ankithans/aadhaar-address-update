import 'dart:convert';
import 'package:aadhaar_address_update/data/models/ekyc_model.dart';
import 'package:aadhaar_address_update/data/models/otp_model.dart';
import 'package:aadhaar_address_update/data/models/tenant_input.dart';
import 'package:aadhaar_address_update/data/models/tenant_login.dart';
import 'package:aadhaar_address_update/utils/api_endpoints.dart';
import 'package:dio/dio.dart';

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
      var error = json.decode(e.response.toString());
      throw error;
    }
  }

  Future<TenantLogin> tenantLogin(TenantInput tenantInput) async {
    try {
      var response =
          await Dio().post(restURI + 'tenants/login', data: tenantInput);

      return TenantLogin.fromJson(response.data);
    } on DioError catch (e) {
      var error = json.decode(e.response.toString());
      throw error;
    }
  }

  Future<TenantLogin> landlordLogin(TenantInput tenantInput) async {
    try {
      var response =
          await Dio().post(restURI + 'landlords/login', data: tenantInput);

      return TenantLogin.fromJson(response.data);
    } on DioError catch (e) {
      var error = json.decode(e.response.toString());
      throw error;
    }
  }
}
