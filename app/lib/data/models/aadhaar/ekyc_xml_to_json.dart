class EkycXmlToJson {
  EkycXmlToJson({
    required this.kycRes,
  });
  late final KycRes kycRes;

  EkycXmlToJson.fromJson(Map<String, dynamic> json) {
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
    required this.uidData,
    required this.signature,
  });
  late final String Rar;
  late final UidData uidData;
  late final Signature signature;

  KycRes.fromJson(Map<String, dynamic> json) {
    Rar = json['Rar'];
    uidData = UidData.fromJson(json['UidData']);
    signature = Signature.fromJson(json['Signature']);
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['Rar'] = Rar;
    _data['UidData'] = uidData.toJson();
    _data['Signature'] = signature.toJson();
    return _data;
  }
}

class UidData {
  UidData({
    required this.Poi,
    required this.Poa,
    required this.LData,
    required this.Pht,
  });
  late final String Poi;
  late final String Poa;
  late final String LData;
  late final String Pht;

  UidData.fromJson(Map<String, dynamic> json) {
    Poi = json['Poi'];
    Poa = json['Poa'];
    LData = json['LData'];
    Pht = json['Pht'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['Poi'] = Poi;
    _data['Poa'] = Poa;
    _data['LData'] = LData;
    _data['Pht'] = Pht;
    return _data;
  }
}

class Signature {
  Signature({
    required this.signedInfo,
    required this.SignatureValue,
    required this.keyInfo,
  });
  late final SignedInfo signedInfo;
  late final String SignatureValue;
  late final KeyInfo keyInfo;

  Signature.fromJson(Map<String, dynamic> json) {
    signedInfo = SignedInfo.fromJson(json['SignedInfo']);
    SignatureValue = json['SignatureValue'];
    keyInfo = KeyInfo.fromJson(json['KeyInfo']);
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['SignedInfo'] = signedInfo.toJson();
    _data['SignatureValue'] = SignatureValue;
    _data['KeyInfo'] = keyInfo.toJson();
    return _data;
  }
}

class SignedInfo {
  SignedInfo({
    required this.CanonicalizationMethod,
    required this.SignatureMethod,
    required this.reference,
  });
  late final String CanonicalizationMethod;
  late final String SignatureMethod;
  late final Reference reference;

  SignedInfo.fromJson(Map<String, dynamic> json) {
    CanonicalizationMethod = json['CanonicalizationMethod'];
    SignatureMethod = json['SignatureMethod'];
    reference = Reference.fromJson(json['Reference']);
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['CanonicalizationMethod'] = CanonicalizationMethod;
    _data['SignatureMethod'] = SignatureMethod;
    _data['Reference'] = reference.toJson();
    return _data;
  }
}

class Reference {
  Reference({
    required this.transforms,
    required this.DigestMethod,
    required this.DigestValue,
  });
  late final Transforms transforms;
  late final String DigestMethod;
  late final String DigestValue;

  Reference.fromJson(Map<String, dynamic> json) {
    transforms = Transforms.fromJson(json['Transforms']);
    DigestMethod = json['DigestMethod'];
    DigestValue = json['DigestValue'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['Transforms'] = transforms.toJson();
    _data['DigestMethod'] = DigestMethod;
    _data['DigestValue'] = DigestValue;
    return _data;
  }
}

class Transforms {
  Transforms({
    required this.Transform,
  });
  late final String Transform;

  Transforms.fromJson(Map<String, dynamic> json) {
    Transform = json['Transform'];
  }

  Map<String, dynamic> toJson() {
    final _data = <String, dynamic>{};
    _data['Transform'] = Transform;
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
