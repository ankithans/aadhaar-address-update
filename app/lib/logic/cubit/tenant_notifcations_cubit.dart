import 'package:aadhaar_address_update/data/models/tenant/tenant_accept_address_input.dart';
import 'package:aadhaar_address_update/data/models/tenant/tenant_notifcations.dart';
import 'package:aadhaar_address_update/data/models/tenant/tenant_request_update_input.dart';
import 'package:aadhaar_address_update/data/repository/api_client.dart';
import 'package:bloc/bloc.dart';
import 'package:meta/meta.dart';
import 'package:shared_preferences/shared_preferences.dart';

part 'tenant_notifcations_state.dart';

class TenantNotifcationsCubit extends Cubit<TenantNotifcationsState> {
  final APIClient apiClient;

  TenantNotifcationsCubit(
    this.apiClient,
  ) : super(TenantNotifcationsInitial());

  getTenantNotifications() async {
    try {
      emit(TenantNotificationsLoading());
      SharedPreferences prefs = await SharedPreferences.getInstance();
      String uid = prefs.getString('tenantUID').toString();

      TenantNotifications tenantNotifications =
          await apiClient.tenantNotifications(uid);
      print(uid);
      emit(TenantNotificationsLoaded(tenantNotifications: tenantNotifications));
    } catch (e) {
      emit(TenantNotificationsFailure(err: e.toString()));
    }
  }

  tenantUpdateRequest(
    String requestId,
    String reason,
    String relation,
  ) async {
    emit(TenantNotificationUpdateLoading());
    SharedPreferences prefs = await SharedPreferences.getInstance();
    String uid = prefs.getString('tenantUID').toString();
    String datetime = DateTime.now().toString();
    try {
      TenantRequestUpdateInput tenantRequestUpdateInput =
          TenantRequestUpdateInput(
        tenantUid: uid,
        requestId: requestId,
        reason: reason,
        relation: relation,
        updated: datetime,
      );
      emit(TenantNotificationUpdateLoaded());
      //   getTenantNotifications();
      await apiClient.tenantRequestUpdate(tenantRequestUpdateInput);
    } catch (e) {
      emit(TenantNotificationUpdateFailure(err: e.toString()));
    }
  }

  deleteTenantRequest(String requestId) async {
    try {
      emit(TenantNotificationDeleteLoading());
      SharedPreferences prefs = await SharedPreferences.getInstance();
      String uid = prefs.getString('tenantUID').toString();

      await apiClient.tenantRequestDelete(requestId, uid);

      emit(TenantNotificationDeleteLoaded());
    } catch (e) {
      emit(TenantNotificationDeleteFailure(err: e.toString()));
    }
  }

  tenantAcceptAddress(
    String country,
    String dist,
    String house,
    String lm,
    String loc,
    String pc,
    String state,
    String vtc,
    String street,
  ) async {
    try {
      emit(TenantNotificationSubmitLoading());
      SharedPreferences prefs = await SharedPreferences.getInstance();
      String uid = prefs.getString('tenantUID').toString();

      TenantAcceptAddressInput tenantAcceptAddressInput =
          TenantAcceptAddressInput(
        address: Address(
          co: "",
          country: country,
          dist: dist,
          house: house,
          lm: lm,
          loc: loc,
          pc: pc,
          state: state,
          vtc: vtc,
          street: street,
        ),
        uid: uid,
      );
      await apiClient.tenantAcceptAddress(tenantAcceptAddressInput);

      emit(TenantNotificationSubmitLoaded());
    } catch (e) {
      emit(TenantNotificationSubmitFailure(err: e.toString()));
    }
  }
}
