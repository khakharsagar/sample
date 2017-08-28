package com.android.allinoneapp.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.android.allinoneapp.R;
import com.android.allinoneapp.api.response.ApiResponse;
import com.android.allinoneapp.databinding.ItemCardViewBinding;
import com.android.allinoneapp.viewmodel.ApiResponseViewModel;
import java.util.List;

/**
 * Created by sagarkhakhar on 26/08/17.
 */

public class AllInOneAdapter extends RecyclerView.Adapter<AllInOneAdapter.AllInOneViewHolder> {
  private List<ApiResponse> mApiResponseList;
  private Context mContext;

  public AllInOneAdapter(List<ApiResponse> apiResponseList, Context context) {
    mApiResponseList = apiResponseList;
    mContext = context;
  }

  @Override
  public AllInOneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ItemCardViewBinding itemCardViewBinding = DataBindingUtil
        .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_card_view, parent, false);

    return new AllInOneViewHolder(itemCardViewBinding);
  }

  @Override
  public void onBindViewHolder(AllInOneViewHolder holder, int position) {
    ItemCardViewBinding itemCardViewBinding = holder.mItemCardViewBinding;
    itemCardViewBinding.setViewModel(new ApiResponseViewModel(mApiResponseList.get(position),mContext));
  }

  @Override
  public int getItemCount() {
    return (mApiResponseList == null) ? 0 : mApiResponseList.size();
  }

  public static class AllInOneViewHolder extends RecyclerView.ViewHolder{
    private ItemCardViewBinding mItemCardViewBinding;

    public AllInOneViewHolder(ItemCardViewBinding itemCardViewBinding) {
      super(itemCardViewBinding.contactCard);
      mItemCardViewBinding = itemCardViewBinding;
    }
  }
}
