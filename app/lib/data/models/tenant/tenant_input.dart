class TenantInput {
  TenantInput({
    required this.address,
    required this.phone,
    required this.fcm,
    required this.uid,
  });
  late final String address;
  late final int phone;
  late final String fcm;
  late final String uid;

  TenantInput.fromJson(Map<String, dynamic> json) {
    address = json['address'];
    phone = json['phone'];
    fcm = json['fcm'];
    uid = json['uid'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['address'] = address;
    _data['phone'] = phone;
    _data['fcm'] = fcm;
    _data['uid'] = uid;
    return _data;
  }
}
