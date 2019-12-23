package com.akash.supershop.ui.ShopOwner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.akash.supershop.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<Product> datalist;
    private MyAdapterItemClickListener listener;

    public MyAdapter(List<Product> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recycler,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    public void setListener(MyAdapterItemClickListener listener) {
        this.listener = listener;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        int id=datalist.get(position).getId();
        String name=datalist.get(position).getName();
        holder.pro_id.setText(""+id);
        holder.pro_name.setText(""+name);
        holder.pro_category.setText(""+datalist.get(position).getCategory());
        holder.pro_descrip.setText(""+datalist.get(position).getDescription());
        holder.pro_price.setText(""+datalist.get(position).getPrice());
        holder.cardViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null)
                {
                    listener.onItemClick(datalist.get(position),position);


                }
            }
        });
        holder.cardViewLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onItemLongClick(datalist.get(position),position);
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

   

    public interface MyAdapterItemClickListener {
        void onItemClick(Product product, int position);
        public void onItemLongClick(Product item,int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
       private TextView pro_id;
       private TextView pro_name;
       private TextView pro_category;
       private TextView pro_descrip;
       private TextView pro_price;
       private CardView cardViewLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pro_id=itemView.findViewById(R.id.product_id);
            pro_name=itemView.findViewById(R.id.product_name);
            pro_category=itemView.findViewById(R.id.product_category);
            pro_descrip=itemView.findViewById(R.id.product_description);
            pro_price=itemView.findViewById(R.id.product_price);
            cardViewLayout = itemView.findViewById(R.id.cardview);
        }

    }
}
