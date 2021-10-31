class TenantNotifications {
  TenantNotifications({
    required this.status,
    required this.data,
  });
  late final String status;
  late final List<Data> data;

  TenantNotifications.fromJson(Map<String, dynamic> json) {
    status = json['status'];
    data = List.from(json['data']).map((e) => Data.fromJson(e)).toList();
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['status'] = status;
    _data['data'] = data.map((e) => e.toJson()).toList();
    return _data;
  }
}

class Data {
  Data({
    required this.id,
    required this.tenantUid,
    required this.landlordUid,
    required this.landlordNo,
    required this.status,
    required this.landlordAddress,
    required this.created,
    required this.relation,
    required this.reason,
    required this.updated,
  });
  late final String id;
  late final String tenantUid;
  late final String landlordUid;
  late final int landlordNo;
  late final int status;
  late final LandlordAddress landlordAddress;
  late final String created;
  late final String relation;
  late final String reason;
  late final String updated;

  Data.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    tenantUid = json['tenant_uid'];
    landlordUid = json['landlord_uid'];
    landlordNo = json['landlord_no'];
    status = json['status'];
    landlordAddress = LandlordAddress.fromJson(json['landlord_address']);
    created = json['created'];
    relation = json['relation'];
    reason = json['reason'];
    updated = json['updated'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['id'] = id;
    _data['tenant_uid'] = tenantUid;
    _data['landlord_uid'] = landlordUid;
    _data['landlord_no'] = landlordNo;
    _data['status'] = status;
    _data['landlord_address'] = landlordAddress.toJson();
    _data['created'] = created;
    _data['relation'] = relation;
    _data['reason'] = reason;
    _data['updated'] = updated;
    return _data;
  }
}

class LandlordAddress {
  LandlordAddress({
    required this.co,
    required this.country,
    required this.dist,
    required this.house,
    required this.lm,
    required this.loc,
    required this.pc,
    required this.state,
    required this.vtc,
    required this.street,
  });
  late final String co;
  late final String country;
  late final String dist;
  late final String house;
  late final lm;
  late final String loc;
  late final String pc;
  late final String state;
  late final String vtc;
  late final street;

  LandlordAddress.fromJson(Map<String, dynamic> json) {
    co = json['co'] ?? "";
    country = json['country'] ?? "";
    dist = json['dist'] ?? "";
    house = json['house'] ?? "";
    lm = json['lm'] ?? "";
    loc = json['loc'] ?? "";
    pc = json['pc'] ?? "";
    state = json['state'] ?? "";
    vtc = json['vtc'] ?? "";
    street = json['street'] ?? "";
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
    _data['street'] = street;
    return _data;
  }
}
