package com.android.allinoneapp.api.response.model;

import com.android.allinoneapp.api.response.ApiResponse;
import java.util.List;

/**
 * Created by sagarkhakhar on 26/08/17.
 */

public class ApiResponseModel {
  private List<ApiResponse> mApiResponses;

  public ApiResponseModel(List<ApiResponse> apiResponses) {
    mApiResponses = apiResponses;
  }

  public List<ApiResponse> getApiResponses() {
    return mApiResponses;
  }
}
