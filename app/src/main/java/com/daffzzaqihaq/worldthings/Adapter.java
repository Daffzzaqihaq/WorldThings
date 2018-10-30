package com.daffzzaqihaq.worldthings;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daffzzaqihaq.worldthings.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    int[] gambarWorld;
    String[] namaWorld,detailWorld;

    public Adapter(Context context,int[] gambarWorld, String[] namaWorld, String[] detailWorld){
        this.context = context;
        this.gambarWorld = gambarWorld;
        this.namaWorld = namaWorld;
        this.detailWorld = detailWorld;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listworld, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaWorld[i]);
        Glide.with(context).load(gambarWorld[i]).into(viewHolder.imgLogo);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context,DetailActivity.class);
                pindah.putExtra("nh",namaWorld[i]);
                pindah.putExtra("dh",detailWorld[i]);
                pindah.putExtra("gh",gambarWorld[i]);
                context.startActivity(pindah);

            }
        });
    }



    @Override
    public int getItemCount() {
        return gambarWorld.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView txtNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgList);
            txtNama = itemView.findViewById(R.id.txtListTitle);

        }
    }
}

