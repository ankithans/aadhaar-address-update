class EkycAPI {
  EkycAPI({
    required this.kycRes,
  });
  late final KycRes kycRes;

  EkycAPI.fromJson(Map<String, dynamic> json) {
    kycRes = KycRes.fromJson(json['KycRes']);
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['KycRes'] = kycRes.toJson();
    return _data;
  }
}

class KycRes {
  KycRes({
    required this.Rar,
    required this.signature,
    required this.uidData,
    required this.code,
    required this.ret,
    required this.ts,
    required this.ttl,
    required this.txn,
  });
  late final String Rar;
  late final Signature signature;
  late final UidData uidData;
  late final String code;
  late final String ret;
  late final String ts;
  late final String ttl;
  late final String txn;

  KycRes.fromJson(Map<String, dynamic> json) {
    Rar = json['Rar'];
    signature = Signature.fromJson(json['Signature']);
    uidData = UidData.fromJson(json['UidData']);
    code = json['code'];
    ret = json['ret'];
    ts = json['ts'];
    ttl = json['ttl'];
    txn = json['txn'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['Rar'] = Rar;
    _data['Signature'] = signature.toJson();
    _data['UidData'] = uidData.toJson();
    _data['code'] = code;
    _data['ret'] = ret;
    _data['ts'] = ts;
    _data['ttl'] = ttl;
    _data['txn'] = txn;
    return _data;
  }
}

class Signature {
  Signature({
    required this.keyInfo,
    required this.signatureValue,
    required this.signedInfo,
    required this.xmlns,
  });
  late final KeyInfo keyInfo;
  late final String signatureValue;
  late final SignedInfo signedInfo;
  late final String xmlns;

  Signature.fromJson(Map<String, dynamic> json) {
    keyInfo = KeyInfo.fromJson(json['KeyInfo']);
    signatureValue = json['SignatureValue'];
    signedInfo = SignedInfo.fromJson(json['SignedInfo']);
    xmlns = json['xmlns'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['KeyInfo'] = keyInfo.toJson();
    _data['SignatureValue'] = signatureValue;
    _data['SignedInfo'] = signedInfo.toJson();
    _data['xmlns'] = xmlns;
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
    required this.X509Certificate,
    required this.X509SubjectName,
  });
  late final String X509Certificate;
  late final String X509SubjectName;

  X509Data.fromJson(Map<String, dynamic> json) {
    X509Certificate = json['X509Certificate'];
    X509SubjectName = json['X509SubjectName'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['X509Certificate'] = X509Certificate;
    _data['X509SubjectName'] = X509SubjectName;
    return _data;
  }
}

class SignedInfo {
  SignedInfo({
    required this.canonicalizationMethod,
    required this.reference,
    required this.signatureMethod,
  });
  late final CanonicalizationMethod canonicalizationMethod;
  late final Reference reference;
  late final SignatureMethod signatureMethod;

  SignedInfo.fromJson(Map<String, dynamic> json) {
    canonicalizationMethod =
        CanonicalizationMethod.fromJson(json['CanonicalizationMethod']);
    reference = Reference.fromJson(json['Reference']);
    signatureMethod = SignatureMethod.fromJson(json['SignatureMethod']);
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['CanonicalizationMethod'] = canonicalizationMethod.toJson();
    _data['Reference'] = reference.toJson();
    _data['SignatureMethod'] = signatureMethod.toJson();
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

class Reference {
  Reference({
    required this.digestMethod,
    required this.digestValue,
    required this.transforms,
    required this.URI,
  });
  late final DigestMethod digestMethod;
  late final String digestValue;
  late final Transforms transforms;
  late final String URI;

  Reference.fromJson(Map<String, dynamic> json) {
    digestMethod = DigestMethod.fromJson(json['DigestMethod']);
    digestValue = json['DigestValue'];
    transforms = Transforms.fromJson(json['Transforms']);
    URI = json['URI'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['DigestMethod'] = digestMethod.toJson();
    _data['DigestValue'] = digestValue;
    _data['Transforms'] = transforms.toJson();
    _data['URI'] = URI;
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

class UidData {
  UidData({
    required this.lData,
    required this.pht,
    required this.poa,
    required this.poi,
    required this.tkn,
    required this.uid,
  });
  late final LData lData;
  late final String pht;
  late final Poa poa;
  late final Poi poi;
  late final String tkn;
  late final int uid;

  UidData.fromJson(Map<String, dynamic> json) {
    lData = LData.fromJson(json['LData']);
    pht = json['Pht'];
    poa = Poa.fromJson(json['Poa']);
    poi = Poi.fromJson(json['Poi']);
    tkn = json['tkn'];
    uid = json['uid'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['LData'] = lData.toJson();
    _data['Pht'] = pht;
    _data['Poa'] = poa.toJson();
    _data['Poi'] = poi.toJson();
    _data['tkn'] = tkn;
    _data['uid'] = uid;
    return _data;
  }
}

class LData {
  LData();

  LData.fromJson(Map json);

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
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
  late final int pc;
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
  late final int phone;

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
