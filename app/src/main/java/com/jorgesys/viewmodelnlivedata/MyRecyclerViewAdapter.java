package com.jorgesys.viewmodelnlivedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<User> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    MyRecyclerViewAdapter(Context context, List<User> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    //Inflates item layout (Row Layout)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    //Binds the data to the Views.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = mData.get(position);
        holder.txtAge.setText(String.valueOf(user.getAge()));
        holder.txtName.setText(user.getName() + " " + user.getLastName());
    }

    //get number of rows.
    @Override
    public int getItemCount() {
        return mData.size();
    }


    //Stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtAge, txtName;

        ViewHolder(View itemView) {
            super(itemView);
            txtAge = itemView.findViewById(R.id.txtAge);
            txtName = itemView.findViewById(R.id.txtName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    //Convenience method for getting data at click position.
     User getItem(int id) {
        return mData.get(id);
    }

    //Allows clicks events to be caught.
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    //Parent activity will implement this Interface´s method to respond to click events.
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}