import 'package:aadhaar_address_update/data/ekyc_model.dart';
import 'package:aadhaar_address_update/data/otp_model.dart';
import 'package:aadhaar_address_update/data/repository/api_client.dart';
import 'package:bloc/bloc.dart';
import 'package:meta/meta.dart';

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

  sentOtpToEkyc(String uid, String txn, String otp) async {
    emit(EkycLoadingState());
    try {
      EkycAPI ekycAPI = await apiClient.ekycVerify(uid, txn, otp);
      emit(EkycRecievedState());
    } catch (e) {
      emit(EkycFailureState(err: e.toString()));
    }
  }
}