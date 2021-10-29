class EkycAPI {
  EkycAPI({
    required this.status,
    required this.eKycString,
    this.errCode,
  });
  late final String status;
  late final String eKycString;
  late final Null errCode;

  EkycAPI.fromJson(Map<String, dynamic> json) {
    status = json['status'];
    eKycString = json['eKycString'];
    errCode = null;
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['status'] = status;
    _data['eKycString'] = eKycString;
    _data['errCode'] = errCode;
    return _data;
  }
}
