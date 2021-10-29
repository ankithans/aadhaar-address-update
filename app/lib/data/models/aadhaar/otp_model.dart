class OtpAPI {
  OtpAPI({
    required this.txn,
    this.err,
    required this.code,
    required this.ts,
    required this.ret,
    this.actn,
  });
  late final String txn;
  late final Null err;
  late final String code;
  late final String ts;
  late final String ret;
  late final Null actn;

  OtpAPI.fromJson(Map<String, dynamic> json) {
    txn = json['txn'];
    err = null;
    code = json['code'];
    ts = json['ts'];
    ret = json['ret'];
    actn = null;
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['txn'] = txn;
    _data['err'] = err;
    _data['code'] = code;
    _data['ts'] = ts;
    _data['ret'] = ret;
    _data['actn'] = actn;
    return _data;
  }
}
