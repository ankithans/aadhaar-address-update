import 'package:aadhaar_address_update/data/models/aadhaar/ekyc_model.dart';
import 'package:aadhaar_address_update/data/models/aadhaar/otp_model.dart';
import 'package:aadhaar_address_update/data/models/tenant/tenant_input.dart';
import 'package:aadhaar_address_update/data/models/tenant/tenant_login.dart';
import 'package:aadhaar_address_update/data/repository/api_client.dart';
import 'package:bloc/bloc.dart';
import 'package:meta/meta.dart';
import 'package:shared_preferences/shared_preferences.dart';

part 'otp_state.dart';

class OtpCubit extends Cubit<OtpState> {
  OtpCubit(
    this.apiClient,
  ) : super(OtpInitialState());

  final APIClient apiClient;

  sendOtp(String uid) async {
    emit(OtpLoadingState());
    try {
      OtpAPI otpAPI = await apiClient.getOtp(uid);
      emit(OtpRecievedState(txn: otpAPI.txn, err: otpAPI.err, ret: otpAPI.ret));
    } catch (e) {
      emit(OtpFailureState(err: e.toString()));
    }
  }

  sentOtpToEkyc(String uid, String txn, String otp, bool tenant) async {
    emit(EkycLoadingState());
    try {
      EkycAPI ekycAPI = await apiClient.ekycVerify(uid, txn, otp);

      SharedPreferences prefs = await SharedPreferences.getInstance();
      String fcm = prefs.getString('fcm').toString();
      // Tenant login in database
      String address = ekycAPI.kycRes.uidData.poa.house +
          " " +
          ekycAPI.kycRes.uidData.poa.loc +
          " " +
          ekycAPI.kycRes.uidData.poa.dist +
          " " +
          ekycAPI.kycRes.uidData.poa.country +
          " " +
          ekycAPI.kycRes.uidData.poa.pc.toString();
      TenantInput tenantInput = TenantInput(
        address: address,
        phone: ekycAPI.kycRes.uidData.poi.phone,
        fcm: fcm,
        uid: uid,
      );

      if (tenant) {
        TenantLogin tenantLogin = await apiClient.tenantLogin(tenantInput);
        prefs.setString("tenantUID", uid);
      } else {
        TenantLogin tenantLogin = await apiClient.landlordLogin(tenantInput);
        prefs.setString("landlordUID", uid);
      }

      emit(EkycRecievedState());
    } catch (e) {
      emit(EkycFailureState(err: e.toString()));
    }
  }
}
