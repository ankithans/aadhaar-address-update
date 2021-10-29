class EkycPoi {
  EkycPoi({
    required this.dob,
    required this.gender,
    required this.name,
    required this.phone,
  });
  late final String dob;
  late final String gender;
  late final String name;
  late final String phone;

  EkycPoi.fromJson(Map<String, dynamic> json) {
    dob = json['dob'];
    gender = json['gender'];
    name = json['name'];
    phone = json['phone'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['dob'] = dob;
    _data['gender'] = gender;
    _data['name'] = name;
    _data['phone'] = phone;
    return _data;
  }
}
