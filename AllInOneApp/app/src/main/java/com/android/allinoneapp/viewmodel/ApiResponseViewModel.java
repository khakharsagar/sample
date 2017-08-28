package com.android.allinoneapp.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.android.allinoneapp.api.response.ApiResponse;
import com.android.allinoneapp.api.response.model.ApiResponseModel;
import com.bumptech.glide.Glide;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

/**
 * Created by sagarkhakhar on 26/08/17.
 */

public class ApiResponseViewModel extends BaseObservable {
  private ApiResponse mApiResponse;
  private Context mContext;

  public ApiResponseViewModel(ApiResponse apiResponse, Context context) {
    mApiResponse = apiResponse;
    mContext = context;
  }

  @Bindable
  public String getName(){
    return mApiResponse.index+" "+mApiResponse.name;
  }
    @Bindable
  public String getAddress(){
    return mApiResponse.address;
  }
    @Bindable
  public String getEmail(){
    return mApiResponse.email;
  }
    @Bindable
  public String getGender(){
    return mApiResponse.gender;
  }

  @Bindable
  public String getImageUrl(){
    return mApiResponse.picture;
  }

  @BindingAdapter({"loadImageUrl"})
  public static void loadImage(ImageView view, String url) {
    Glide.with(view.getContext()).load(url).centerCrop().into(view);
  }
}
