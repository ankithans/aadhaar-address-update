class TenantLogin {
  TenantLogin({
    required this.status,
    required this.data,
  });
  late final String status;
  late final Data data;

  TenantLogin.fromJson(Map<String, dynamic> json) {
    status = json['status'];
    data = Data.fromJson(json['data']);
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['status'] = status;
    _data['data'] = data.toJson();
    return _data;
  }
}

class Data {
  Data({
    required this.id,
    required this.address,
    required this.fcm,
    required this.phone,
  });
  late final String id;
  late final String address;
  late final String fcm;
  late final int phone;

  Data.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    address = json['address'];
    fcm = json['fcm'];
    phone = json['phone'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['id'] = id;
    _data['address'] = address;
    _data['fcm'] = fcm;
    _data['phone'] = phone;
    return _data;
  }
}
