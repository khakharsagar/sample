package com.android.allinoneapp.api.request;

import com.android.allinoneapp.api.response.ApiResponse;
import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sagarkhakhar on 26/08/17.
 */

public interface RequestInterface {
  @GET("cgqLMYEgSW/")
  Single<List<ApiResponse>> getData(@Query("indent") int indent);
}
