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

class TenantNotificationUpdateLoading extends TenantNotifcationsState {}

class TenantNotificationUpdateLoaded extends TenantNotifcationsState {}

class TenantNotificationUpdateFailure extends TenantNotifcationsState {
  String err;
  TenantNotificationUpdateFailure({
    required this.err,
  });
}

class TenantNotificationDeleteLoading extends TenantNotifcationsState {}

class TenantNotificationDeleteLoaded extends TenantNotifcationsState {}

class TenantNotificationDeleteFailure extends TenantNotifcationsState {
  String err;
  TenantNotificationDeleteFailure({
    required this.err,
  });
}

class TenantNotificationVerifyLoading extends TenantNotifcationsState {}

class TenantNotificationVerifyLoaded extends TenantNotifcationsState {}

class TenantNotificationVerifyFailure extends TenantNotifcationsState {
  String err;
  TenantNotificationVerifyFailure({
    required this.err,
  });
}

class TenantNotificationSubmitLoading extends TenantNotifcationsState {}

class TenantNotificationSubmitLoaded extends TenantNotifcationsState {}

class TenantNotificationSubmitFailure extends TenantNotifcationsState {
  String err;
  TenantNotificationSubmitFailure({
    required this.err,
  });
}
