package com.socialcafe.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.socialcafe.R;
import com.socialcafe.databinding.PreviousOrderRowBinding;
import com.socialcafe.models.OrderModel;

import java.util.List;

public class PreviousOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<OrderModel> list;
    private Context context;
    private LayoutInflater inflater;

    //private Fragment_Main fragment_main;
    public PreviousOrderAdapter(List<OrderModel> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        //  this.fragment_main=fragment_main;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        PreviousOrderRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.previous_order_row, parent, false);
        return new MyHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder) holder;
        myHolder.binding.setModel(list.get(position));
        myHolder.binding.recView.setLayoutManager(new LinearLayoutManager(context));
        ProductOrderAdapter productOrderAdapter = new ProductOrderAdapter(list.get(position).getDetails(), context);
       myHolder.binding.recView.setLayoutManager(new LinearLayoutManager(context));
        myHolder.binding.recView.setAdapter(productOrderAdapter);

//Log.e("eeee",list.get(position).getOffer_value()+""+(list.get(position).getAmount()%list.get(position).getOffer_min()));
        // Log.e("ssss",((list.get(position).getHave_offer().equals("yes")?(list.get(position).getOffer_type().equals("per")?(list.get(position).getProduct_default_price().getPrice()-((list.get(position).getProduct_default_price().getPrice()*list.get(position).getOffer_value())/100)):list.get(position).getProduct_default_price().getPrice()-list.get(position).getOffer_value()):list.get(position).getProduct_default_price().getPrice())+""));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public PreviousOrderRowBinding binding;

        public MyHolder(@NonNull PreviousOrderRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


}
