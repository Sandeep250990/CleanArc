package com.example.cleanarch.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cleanarch.R;
import com.example.cleanarch.data.model.UserResponse;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.CustomView> {

    List<UserResponse.DataBean>userDataList;
    private Context context;

    public UsersAdapter(List<UserResponse.DataBean> dataBeanList, Context context){
        this.context=context;
        this.userDataList=dataBeanList;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main,parent,false);

        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {

        holder.nameTxt.setText(userDataList.get(position).getFirst_name()+" "+userDataList.get(position).getLast_name());
    }

    @Override
    public int getItemCount() {
        return userDataList.size();
    }

    class CustomView extends RecyclerView.ViewHolder{

        private TextView nameTxt;

        public CustomView(@NonNull View itemView) {
            super(itemView);

            nameTxt=itemView.findViewById(R.id.textView_name);
        }
    }



}
