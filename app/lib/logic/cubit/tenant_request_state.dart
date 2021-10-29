part of 'tenant_request_cubit.dart';

@immutable
abstract class TenantRequestState {}

class TenantRequestInitial extends TenantRequestState {}

class TenantRequestLoading extends TenantRequestState {}

class TenantRequestSuccess extends TenantRequestState {}

class TenantRequestFailure extends TenantRequestState {
  String err;
  TenantRequestFailure({
    required this.err,
  });
}
