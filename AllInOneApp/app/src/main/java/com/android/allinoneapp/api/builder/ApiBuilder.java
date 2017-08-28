package com.android.allinoneapp.api.builder;

import com.android.allinoneapp.api.request.RequestInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sagarkhakhar on 26/08/17.
 */

public class ApiBuilder {
  private static final String BASE_URL = "http://www.json-generator.com/api/json/get/";
  private static RequestInterface mRequestInterface;


  private ApiBuilder(){
    mRequestInterface = getInstance();
  }

  public static RequestInterface getInstance(){
    if (mRequestInterface == null){
      mRequestInterface = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .build().create(RequestInterface.class);
    }
    return mRequestInterface;
  }
}
