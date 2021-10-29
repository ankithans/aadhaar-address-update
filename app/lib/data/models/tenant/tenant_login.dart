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
  late final Address1 address;
  late final String fcm;
  late final int phone;

  Data.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    address = Address1.fromJson(json['address']);
    fcm = json['fcm'];
    phone = json['phone'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['id'] = id;
    _data['address'] = address.toJson();
    _data['fcm'] = fcm;
    _data['phone'] = phone;
    return _data;
  }
}

class Address1 {
  Address1({
    required this.co,
    required this.country,
    required this.dist,
    required this.house,
    required this.lm,
    required this.loc,
    required this.pc,
    required this.state,
    required this.vtc,
  });
  late final String co;
  late final String country;
  late final String dist;
  late final String house;
  late final String lm;
  late final String loc;
  late final String pc;
  late final String state;
  late final String vtc;

  Address1.fromJson(Map<String, dynamic> json) {
    co = json['co'];
    country = json['country'];
    dist = json['dist'];
    house = json['house'];
    lm = json['lm'];
    loc = json['loc'];
    pc = json['pc'];
    state = json['state'];
    vtc = json['vtc'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['co'] = co;
    _data['country'] = country;
    _data['dist'] = dist;
    _data['house'] = house;
    _data['lm'] = lm;
    _data['loc'] = loc;
    _data['pc'] = pc;
    _data['state'] = state;
    _data['vtc'] = vtc;
    return _data;
  }
}
