package com.android.allinoneapp.api.usecaseimpl;

import com.android.allinoneapp.api.builder.ApiBuilder;
import com.android.allinoneapp.api.response.ApiResponse;
import com.android.allinoneapp.api.response.model.ApiResponseModel;
import com.android.allinoneapp.api.usecase.GetDataUseCase;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;

/**
 * Created by sagarkhakhar on 26/08/17.
 */

public class GetDataUseCaseImpl implements GetDataUseCase {

  @Override
  public Single<ApiResponseModel> execute(int indent) {
    return ApiBuilder.getInstance().getData(indent).flatMap(
        new Function<List<ApiResponse>, SingleSource<ApiResponseModel>>() {
          @Override
          public SingleSource<ApiResponseModel> apply(List<ApiResponse> apiResponses)
              throws Exception {
            return Single.just(new ApiResponseModel(apiResponses));
          }
        });
  }
}
