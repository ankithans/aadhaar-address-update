part of 'otp_cubit.dart';

@immutable
abstract class OtpState {}

class OtpInitialState extends OtpState {}

class OtpLoadingState extends OtpState {}

class OtpRecievedState extends OtpState {
  String txn;
  Null err;
  String ret;

  OtpRecievedState({
    required this.txn,
    required this.err,
    required this.ret,
  });
}

class OtpFailureState extends OtpState {
  String err;
  OtpFailureState({
    required this.err,
  });
}
