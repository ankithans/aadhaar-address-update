class EkycXmlToJson {
  EkycXmlToJson({
    required this.code,
    required this.ret,
    required this.ts,
    required this.ttl,
    required this.txn,
    required this.Rar,
    required this.uidData,
    required this.signature,
  });
  late final String code;
  late final String ret;
  late final String ts;
  late final String ttl;
  late final String txn;
  late final String Rar;
  late final UidData uidData;
  late final Signature signature;

  EkycXmlToJson.fromJson(Map<String, dynamic> json) {
    code = json['code'];
    ret = json['ret'];
    ts = json['ts'];
    ttl = json['ttl'];
    txn = json['txn'];
    Rar = json['Rar'];
    uidData = UidData.fromJson(json['UidData']);
    signature = Signature.fromJson(json['Signature']);
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['code'] = code;
    _data['ret'] = ret;
    _data['ts'] = ts;
    _data['ttl'] = ttl;
    _data['txn'] = txn;
    _data['Rar'] = Rar;
    _data['UidData'] = uidData.toJson();
    _data['Signature'] = signature.toJson();
    return _data;
  }
}

class UidData {
  UidData({
    required this.tkn,
    required this.uid,
    required this.poi,
    required this.poa,
    required this.LData,
    required this.Pht,
  });
  late final String tkn;
  late final String uid;
  late final Poi poi;
  late final Poa poa;
  late final List<dynamic> LData;
  late final String Pht;

  UidData.fromJson(Map<String, dynamic> json) {
    tkn = json['tkn'];
    uid = json['uid'];
    poi = Poi.fromJson(json['Poi']);
    poa = Poa.fromJson(json['Poa']);
    LData = List.castFrom<dynamic, dynamic>(json['LData']);
    Pht = json['Pht'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['tkn'] = tkn;
    _data['uid'] = uid;
    _data['Poi'] = poi.toJson();
    _data['Poa'] = poa.toJson();
    _data['LData'] = LData;
    _data['Pht'] = Pht;
    return _data;
  }
}

class Poi {
  Poi({
    required this.dob,
    required this.gender,
    required this.name,
    required this.phone,
  });
  late final String dob;
  late final String gender;
  late final String name;
  late final String phone;

  Poi.fromJson(Map<String, dynamic> json) {
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

class Poa {
  Poa({
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

  Poa.fromJson(Map<String, dynamic> json) {
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

class Signature {
  Signature({
    required this.signedInfo,
    required this.signatureValue,
    required this.keyInfo,
  });
  late final SignedInfo signedInfo;
  late final String signatureValue;
  late final KeyInfo keyInfo;

  Signature.fromJson(Map<String, dynamic> json) {
    signedInfo = SignedInfo.fromJson(json['SignedInfo']);
    signatureValue = json['SignatureValue'];
    keyInfo = KeyInfo.fromJson(json['KeyInfo']);
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['SignedInfo'] = signedInfo.toJson();
    _data['SignatureValue'] = signatureValue;
    _data['KeyInfo'] = keyInfo.toJson();
    return _data;
  }
}

class SignedInfo {
  SignedInfo({
    required this.canonicalizationMethod,
    required this.signatureMethod,
    required this.reference,
  });
  late final CanonicalizationMethod canonicalizationMethod;
  late final SignatureMethod signatureMethod;
  late final Reference reference;

  SignedInfo.fromJson(Map<String, dynamic> json) {
    canonicalizationMethod =
        CanonicalizationMethod.fromJson(json['CanonicalizationMethod']);
    signatureMethod = SignatureMethod.fromJson(json['SignatureMethod']);
    reference = Reference.fromJson(json['Reference']);
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['CanonicalizationMethod'] = canonicalizationMethod.toJson();
    _data['SignatureMethod'] = signatureMethod.toJson();
    _data['Reference'] = reference.toJson();
    return _data;
  }
}

class CanonicalizationMethod {
  CanonicalizationMethod({
    required this.Algorithm,
  });
  late final String Algorithm;

  CanonicalizationMethod.fromJson(Map<String, dynamic> json) {
    Algorithm = json['Algorithm'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['Algorithm'] = Algorithm;
    return _data;
  }
}

class SignatureMethod {
  SignatureMethod({
    required this.Algorithm,
  });
  late final String Algorithm;

  SignatureMethod.fromJson(Map<String, dynamic> json) {
    Algorithm = json['Algorithm'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['Algorithm'] = Algorithm;
    return _data;
  }
}

class Reference {
  Reference({
    required this.URI,
    required this.transforms,
    required this.digestMethod,
    required this.DigestValue,
  });
  late final String URI;
  late final Transforms transforms;
  late final DigestMethod digestMethod;
  late final String DigestValue;

  Reference.fromJson(Map<String, dynamic> json) {
    URI = json['URI'];
    transforms = Transforms.fromJson(json['Transforms']);
    digestMethod = DigestMethod.fromJson(json['DigestMethod']);
    DigestValue = json['DigestValue'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['URI'] = URI;
    _data['Transforms'] = transforms.toJson();
    _data['DigestMethod'] = digestMethod.toJson();
    _data['DigestValue'] = DigestValue;
    return _data;
  }
}

class Transforms {
  Transforms({
    required this.transform,
  });
  late final Transform transform;

  Transforms.fromJson(Map<String, dynamic> json) {
    transform = Transform.fromJson(json['Transform']);
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['Transform'] = transform.toJson();
    return _data;
  }
}

class Transform {
  Transform({
    required this.Algorithm,
  });
  late final String Algorithm;

  Transform.fromJson(Map<String, dynamic> json) {
    Algorithm = json['Algorithm'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['Algorithm'] = Algorithm;
    return _data;
  }
}

class DigestMethod {
  DigestMethod({
    required this.Algorithm,
  });
  late final String Algorithm;

  DigestMethod.fromJson(Map<String, dynamic> json) {
    Algorithm = json['Algorithm'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['Algorithm'] = Algorithm;
    return _data;
  }
}

class KeyInfo {
  KeyInfo({
    required this.x509Data,
  });
  late final X509Data x509Data;

  KeyInfo.fromJson(Map<String, dynamic> json) {
    x509Data = X509Data.fromJson(json['X509Data']);
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['X509Data'] = x509Data.toJson();
    return _data;
  }
}

class X509Data {
  X509Data({
    required this.X509SubjectName,
    required this.X509Certificate,
  });
  late final String X509SubjectName;
  late final String X509Certificate;

  X509Data.fromJson(Map<String, dynamic> json) {
    X509SubjectName = json['X509SubjectName'];
    X509Certificate = json['X509Certificate'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['X509SubjectName'] = X509SubjectName;
    _data['X509Certificate'] = X509Certificate;
    return _data;
  }
}
