package com.example.prudhvi.approtech.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.prudhvi.approtech.Helper;
import com.example.prudhvi.approtech.view.MapActivity;
import com.example.prudhvi.approtech.R;
import com.example.prudhvi.approtech.model.Forest;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Prudhvi on 12-09-2019.
 */

public class ForestAdapter extends RecyclerView.Adapter<ForestAdapter.MyViewHolder> {

    Context context;
    List<Forest> list;

    public ForestAdapter(Context context, List<Forest> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ForestAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForestAdapter.MyViewHolder holder, int position) {
        final Forest forest = list.get(position);

        if (!forest.getBirthid().equals("")) {
            holder.iv_next.setVisibility(View.VISIBLE);

        } else {
            holder.iv_next.setVisibility(View.GONE);
        }

        holder.tv_name.setText(forest.getName());
        holder.tv_weight.setText(forest.getWeight());
        holder.tv_description.setText(forest.getDescription());

        if (Helper.isNetworkAvailable(context)){
            Glide
                    .with(context)
                    .load(forest.getUrl())
                    .centerCrop()
                    .placeholder(R.drawable.ic_crop_original_black_24dp)
                    .into(holder.profile_image);

        }else {
            Toast.makeText(context, "To View Image please on your internet", Toast.LENGTH_SHORT).show();
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!forest.getBirthid().equals("")) {
                    Intent intent = new Intent(context, MapActivity.class);
                    intent.putExtra("model", forest);
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, "No Address for this Animal", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView profile_image;
        ImageView iv_next;
        TextView tv_name, tv_weight, tv_description;

        public MyViewHolder(View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.profile_image);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_weight = itemView.findViewById(R.id.tv_weight);
            tv_description = itemView.findViewById(R.id.tv_description);
            iv_next = itemView.findViewById(R.id.iv_next);
        }
    }
}
