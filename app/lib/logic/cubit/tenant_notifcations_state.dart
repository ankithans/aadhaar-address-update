part of 'tenant_notifcations_cubit.dart';

@immutable
abstract class TenantNotifcationsState {}

class TenantNotifcationsInitial extends TenantNotifcationsState {}

class TenantNotificationsLoading extends TenantNotifcationsState {}

class TenantNotificationsLoaded extends TenantNotifcationsState {
  TenantNotifications tenantNotifications;
  TenantNotificationsLoaded({
    required this.tenantNotifications,
  });
}

class TenantNotificationsFailure extends TenantNotifcationsState {
  String err;
  TenantNotificationsFailure({
    required this.err,
  });
}
