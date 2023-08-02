package com.example.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.ThongBao;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ThongBaoAdapter extends RecyclerView.Adapter<ThongBaoAdapter.ViewHonder>{
    private Context context;
    private ArrayList<ThongBao> listThongBao;
    public ThongBaoAdapter(Context context, ArrayList<ThongBao> listCanHo){
        this.context = context;
        this.listThongBao = listCanHo;
    }
    @NonNull
    @Override
    public ViewHonder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (( Activity )context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_list_thong_bao, parent, false);
        return new ViewHonder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHonder holder, int position) {
        holder.tvTitle.setText(listThongBao.get(position).getTitle());
//        holder.tvContent.setText(listThongBao.get(position).getContent() + "");
        holder.tvDate.setText(listThongBao.get(position).getDate() + "");
        holder.tvTime.setText(listThongBao.get(position).getTime() + "");
    }

    @Override
    public int getItemCount() {
        return listThongBao.size();
    }

    public class ViewHonder extends RecyclerView.ViewHolder{
        TextView tvTitle, tvContent, tvDate, tvTime;
        public ViewHonder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
//            tvContent = itemView.findViewById(R.id.tvda);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }
}
