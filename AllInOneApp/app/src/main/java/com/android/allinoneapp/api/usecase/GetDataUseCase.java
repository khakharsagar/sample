package com.android.allinoneapp.api.usecase;

import com.android.allinoneapp.api.response.ApiResponse;
import com.android.allinoneapp.api.response.model.ApiResponseModel;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.Query;

/**
 * Created by sagarkhakhar on 26/08/17.
 */

public interface GetDataUseCase {
  Single<ApiResponseModel> execute(int indent);
}
