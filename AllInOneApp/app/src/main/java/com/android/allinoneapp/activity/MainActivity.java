package com.android.allinoneapp.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;
import com.android.allinoneapp.R;
import com.android.allinoneapp.adapter.AllInOneAdapter;
import com.android.allinoneapp.api.response.model.ApiResponseModel;
import com.android.allinoneapp.api.usecase.GetDataUseCase;
import com.android.allinoneapp.api.usecaseimpl.GetDataUseCaseImpl;
import com.android.allinoneapp.databinding.ActivityMainBinding;
import com.android.allinoneapp.viewmodel.ApiResponseViewModel;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
  private CompositeDisposable mCompositeDisposable;
  private GetDataUseCase mGetDataUseCase;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final ActivityMainBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    viewDataBinding.recyclerviewData.setLayoutManager(new LinearLayoutManager(this));
    mCompositeDisposable = new CompositeDisposable();
    mGetDataUseCase = new GetDataUseCaseImpl();
    mCompositeDisposable.add(mGetDataUseCase.execute(2)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<ApiResponseModel>() {
          @Override
          public void accept(ApiResponseModel apiResponseModel) throws Exception {
            AllInOneAdapter allInOneAdapter = new AllInOneAdapter(apiResponseModel.getApiResponses(),MainActivity.this);
            viewDataBinding.recyclerviewData.setAdapter(allInOneAdapter);
          }
        }, new Consumer<Throwable>() {
          @Override
          public void accept(Throwable throwable) throws Exception {
            Toast.makeText(MainActivity.this, "Api failed", Toast.LENGTH_SHORT).show();
            throwable.printStackTrace();
          }
        }));
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mCompositeDisposable.dispose();
  }
}
