class TenantRequestUpdateInput {
  TenantRequestUpdateInput({
    required this.tenantUid,
    required this.requestId,
    required this.reason,
    required this.relation,
    required this.updated,
  });
  late final String tenantUid;
  late final String requestId;
  late final String reason;
  late final String relation;
  late final String updated;

  TenantRequestUpdateInput.fromJson(Map<String, dynamic> json) {
    tenantUid = json['tenant_uid'];
    requestId = json['request_id'];
    reason = json['reason'];
    relation = json['relation'];
    updated = json['updated'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['tenant_uid'] = tenantUid;
    _data['request_id'] = requestId;
    _data['reason'] = reason;
    _data['relation'] = relation;
    _data['updated'] = updated;
    return _data;
  }
}
