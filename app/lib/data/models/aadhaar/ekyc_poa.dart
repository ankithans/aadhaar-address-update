class EkycPoa {
  EkycPoa({
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
  late final String? co;
  late final String country;
  late final String dist;
  late final String house;
  late final lm;
  late final String loc;
  late final String pc;
  late final String state;
  late final String vtc;
  late final street;

  EkycPoa.fromJson(Map<String, dynamic> json) {
    co = json['co'];
    country = json['country'];
    dist = json['dist'];
    house = json['house'];
    lm = json['lm'];
    loc = json['loc'];
    pc = json['pc'];
    state = json['state'];
    vtc = json['vtc'];
    street = json['street'];
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
