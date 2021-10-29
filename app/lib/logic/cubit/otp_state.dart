part of 'otp_cubit.dart';

@immutable
abstract class OtpState {}

class OtpInitialState extends OtpState {}

class OtpLoadingState extends OtpState {}

class OtpRecievedState extends OtpState {
  String txn;
  Null err;

  OtpRecievedState({
    required this.txn,
    required this.err,
  });
}

class OtpFailureState extends OtpState {
  String err;
  OtpFailureState({
    required this.err,
  });
}

class EkycLoadingState extends OtpState {}

class EkycRecievedState extends OtpState {
//   String txn;
//   Null err;
//   String ret;

//   EkycRecievedState({
//     required this.txn,
//     required this.err,
//     required this.ret,
//   });
}

class EkycFailureState extends OtpState {
  String err;
  EkycFailureState({
    required this.err,
  });
}
