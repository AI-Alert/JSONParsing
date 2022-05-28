package com.example.jsonparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideExtension;

import java.util.List;

public class Adapter  {
    public static class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder>{

        private Context mContext;
        private List<PostModelClass> mData;

        public Adaptery(Context mContext, List<PostModelClass> mData) {
            this.mContext = mContext;
            this.mData = mData;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.post_item, parent, false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            holder.title.setText(mData.get(position).getTitle());
            holder.excerpt.setText(mData.get(position).getExcerpt());
            holder.data.setText(mData.get(position).getData());

            Glide.with(mContext)
                    .load(mData.get(position).getImg())
                    .into(holder.image);

        }

        @Override
        public int getItemCount() {
            return mData.size();
        }


        public static class MyViewHolder extends RecyclerView.ViewHolder{

            TextView title;
            TextView data;
            TextView excerpt;
            ImageView image;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                title.findViewById(R.id.id_title);
                data.findViewById(R.id.id_published);
                excerpt.findViewById(R.id.id_excerpt);
                image.findViewById(R.id.id_image);
            }
        }

    }
}
