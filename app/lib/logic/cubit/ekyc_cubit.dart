import 'package:bloc/bloc.dart';
import 'package:meta/meta.dart';

part 'ekyc_state.dart';

class EkycCubit extends Cubit<EkycState> {
  EkycCubit() : super(EkycInitial());
}
