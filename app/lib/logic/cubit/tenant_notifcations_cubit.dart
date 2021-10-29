import 'package:aadhaar_address_update/data/models/tenant/tenant_notifcations.dart';
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
      emit(TenantNotificationsLoaded(tenantNotifications: tenantNotifications));
    } catch (e) {
      emit(TenantNotificationsFailure(err: e.toString()));
    }
  }
}
