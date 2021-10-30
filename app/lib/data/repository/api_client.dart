import 'dart:convert';
import 'dart:developer';
import 'package:aadhaar_address_update/data/models/aadhaar/ekyc_model.dart';
import 'package:aadhaar_address_update/data/models/aadhaar/ekyc_poa.dart';
import 'package:aadhaar_address_update/data/models/aadhaar/ekyc_poi.dart';
import 'package:aadhaar_address_update/data/models/aadhaar/ekyc_xml_to_json.dart';
import 'package:aadhaar_address_update/data/models/aadhaar/otp_model.dart';
import 'package:aadhaar_address_update/data/models/tenant/tenant_accept_address_input.dart';
import 'package:aadhaar_address_update/data/models/tenant/tenant_input.dart';
import 'package:aadhaar_address_update/data/models/tenant/tenant_login.dart';
import 'package:aadhaar_address_update/data/models/tenant/tenant_notifcations.dart';
import 'package:aadhaar_address_update/data/models/tenant/tenant_request.dart';
import 'package:aadhaar_address_update/data/models/tenant/tenant_request_input.dart';
import 'package:aadhaar_address_update/data/models/tenant/tenant_request_update_input.dart';

import 'package:aadhaar_address_update/utils/api_endpoints.dart';
import 'package:dio/dio.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:xml2json/xml2json.dart';

class APIClient {
  Future<OtpAPI> getOtp(String uid, String txn) async {
    try {
      var response = await Dio().post(
        otpURI,
        data: {"uid": uid, "txnId": txn},
      );
      print(response.data);
      if (response.data['errCode'] == null) {
        return OtpAPI.fromJson(response.data);
      }
      throw "wrong UID";
    } on DioError catch (e) {
      var error = json.decode(e.response.toString());
      throw error;
    }
  }

  Future<EkycPoa> ekycVerify(String uid, String txn, String otp) async {
    try {
      var response = await Dio().post(ekycURI, data: {
        "uid": uid,
        "txnId": txn,
        "otp": otp,
      });
      if (response.data['errCode'] == null) {
        // print(response.data);
        final Xml2Json xml2Json = Xml2Json();

        xml2Json.parse(response.data['eKycString']);

        var jsondata = xml2Json.toGData();

        var abc = jsonDecode(jsondata);
        print(abc['KycRes']['UidData']);

        print(abc['KycRes']['UidData']['Poi']);
        print(abc['KycRes']['UidData']['Poa']);

        EkycPoi ekycPoi = EkycPoi.fromJson(abc['KycRes']['UidData']['Poi']);
        EkycPoa ekycPoa = EkycPoa.fromJson(abc['KycRes']['UidData']['Poa']);

        SharedPreferences prefs = await SharedPreferences.getInstance();
        prefs.setString('phone', ekycPoi.phone.toString());

        return ekycPoa;
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

  Future<TenantRequest> tenantRequest(
      TenantRequestInput tenantRequestInput) async {
    try {
      var response =
          await Dio().post(restURI + 'requests/', data: tenantRequestInput);
      print(response.data);
      return TenantRequest.fromJson(response.data);
    } on DioError catch (e) {
      var error = json.decode(e.response.toString());
      throw error;
    }
  }

  Future<TenantNotifications> tenantNotifications(String uid) async {
    try {
      var response = await Dio().get(restURI + 'requests/tenant/' + uid);
      print(response.data);
      return TenantNotifications.fromJson(response.data);
    } on DioError catch (e) {
      var error = json.decode(e.response.toString());
      throw error;
    }
  }

  Future<TenantNotifications> landlordNotifications(String uid) async {
    try {
      var response = await Dio().get(restURI + 'requests/landlord/' + uid);
      return TenantNotifications.fromJson(response.data);
    } on DioError catch (e) {
      var error = json.decode(e.response.toString());
      throw error;
    }
  }

  tenantRequestUpdate(TenantRequestUpdateInput tenantRequestUpdateInput) async {
    try {
      var response = await Dio()
          .put(restURI + 'requests/', data: tenantRequestUpdateInput);
      print(response.data);
    } on DioError catch (e) {
      var error = json.decode(e.response.toString());
      throw error;
    }
  }

  Future<bool> updateStatus(
      {required String id, required String uid, required bool status}) async {
    try {
      var response = await Dio().post(updateURI, data: {
        "id": id,
        "landlord_uid": uid,
        "approval_status": status,
        "updated": "${DateTime.now().toIso8601String()}Z"
      });
      if (response.statusCode == 200) {
        log(response.data.toString(), name: "Update Status");
        return true;
      } else {
        log(response.data.toString(), name: "Update Status");
        log(response.statusCode.toString(), name: "Update Status");
        log(response.statusMessage.toString(), name: "Update Status");
        return true;
      }
    } catch (e) {
      log(e.toString(), name: "Update Status");
      return false;
    }
  }

  tenantRequestDelete(String requestId, String uid) async {
    try {
      var response = await Dio().delete(restURI + 'requests/', data: {
        "request_id": requestId,
        "tenant_uid": uid,
      });
      print(response.data);
    } on DioError catch (e) {
      var error = json.decode(e.response.toString());
      throw error;
    }
  }

  tenantAcceptAddress(TenantAcceptAddressInput tenantAcceptAddressInput) async {
    try {
      var response = await Dio().post(
        restURI + 'tenants/accept_address',
        data: tenantAcceptAddressInput,
      );
      print(response.data);
    } on DioError catch (e) {
      var error = json.decode(e.response.toString());
      throw error;
    }
  }
}
