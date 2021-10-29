import 'package:aadhaar_address_update/data/models/tenant/tenant_request.dart';
import 'package:aadhaar_address_update/data/models/tenant/tenant_request_input.dart';
import 'package:aadhaar_address_update/data/repository/api_client.dart';
import 'package:bloc/bloc.dart';
import 'package:meta/meta.dart';

part 'tenant_request_state.dart';

class TenantRequestCubit extends Cubit<TenantRequestState> {
  final APIClient apiClient;

  TenantRequestCubit(
    this.apiClient,
  ) : super(TenantRequestInitial());

  submitRequestForm(String uid, String relation, String reason) async {
    emit(TenantRequestLoading());
    try {
      String datetime = DateTime.now().toString();
      TenantRequestInput tenantRequestInput = TenantRequestInput(
        tenantUid: uid,
        landlordUid: uid,
        landlordNo: 0,
        status: 0,
        landlordAddress: "",
        created: datetime,
        relation: relation,
        reason: reason,
        updated: datetime,
      );

      TenantRequest tenantRequest =
          await apiClient.tenantRequest(tenantRequestInput);
      emit(TenantRequestSuccess());
    } catch (e) {
      emit(TenantRequestFailure(err: e.toString()));
    }
  }
}
