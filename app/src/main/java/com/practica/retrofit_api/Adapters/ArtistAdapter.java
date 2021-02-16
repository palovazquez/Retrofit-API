package com.practica.retrofit_api.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.practica.retrofit_api.Classes.Artist;
import com.practica.retrofit_api.R;

import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.MyViewHolder>{
    private Context mContext;
    private List<Artist> artistsList;

    public ArtistAdapter(Context mContext, List<Artist> artistsList){
        this.mContext = mContext;
        this.artistsList = artistsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.artist_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(artistsList.get(position).getName());
        holder.duration.setText(artistsList.get(position).getId());
        holder.category.setText(artistsList.get(position).getUrlTickets());
        holder.release.setText(artistsList.get(position).getName());

        Glide.with(mContext).load(artistsList.get(position).getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return artistsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title, category, duration, release;
        ImageView img;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textViewTitle);
            duration = itemView.findViewById(R.id.textViewDuration);
            img = itemView.findViewById(R.id.imageView);
            category = itemView.findViewById(R.id.textViewCategory);
            release = itemView.findViewById(R.id.textViewRelease);
        }
    }

}

