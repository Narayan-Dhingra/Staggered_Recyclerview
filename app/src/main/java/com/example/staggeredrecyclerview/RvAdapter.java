package com.example.staggeredrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private ArrayList<String> images = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();
    Context context;

    public RvAdapter(ArrayList<String> images, ArrayList<String> names, Context context) {
        this.images = images;
        this.names = names;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        RequestOptions requestOptions = new RequestOptions()
                        .placeholder(R.drawable.ic_launcher_background);

        Glide.with(context)
                .load(images.get(position))
                .apply(requestOptions)
                .into(holder.image);

        holder.name.setText(names.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "" +names.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_item);
            name = itemView.findViewById(R.id.tv_item);
            constraintLayout = itemView.findViewById(R.id.rv_item_layout);

        }
    }
}
