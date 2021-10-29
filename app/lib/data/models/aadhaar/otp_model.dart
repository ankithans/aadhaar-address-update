class OtpAPI {
  OtpAPI({
    required this.status,
    this.errCode,
  });
  late final String status;
  late final Null errCode;

  OtpAPI.fromJson(Map<String, dynamic> json) {
    status = json['status'];
    errCode = null;
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['status'] = status;
    _data['errCode'] = errCode;
    return _data;
  }
}
