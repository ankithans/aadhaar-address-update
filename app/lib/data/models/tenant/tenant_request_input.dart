class TenantRequestInput {
  TenantRequestInput({
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
  late final String tenantUid;
  late final String landlordUid;
  late final int landlordNo;
  late final int status;
  late final String landlordAddress;
  late final String created;
  late final String relation;
  late final String reason;
  late final String updated;

  TenantRequestInput.fromJson(Map<String, dynamic> json) {
    tenantUid = json['tenant_uid'];
    landlordUid = json['landlord_uid'];
    landlordNo = json['landlord_no'];
    status = json['status'];
    landlordAddress = json['landlord_address'];
    created = json['created'];
    relation = json['relation'];
    reason = json['reason'];
    updated = json['updated'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['tenant_uid'] = tenantUid;
    _data['landlord_uid'] = landlordUid;
    _data['landlord_no'] = landlordNo;
    _data['status'] = status;
    _data['landlord_address'] = landlordAddress;
    _data['created'] = created;
    _data['relation'] = relation;
    _data['reason'] = reason;
    _data['updated'] = updated;
    return _data;
  }
}
