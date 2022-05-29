package com.example.jsonparsing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
        String content;
        String title;
        String data;

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
           // holder.content.setText(mData.get(position).getContent());
            title = mData.get(position).getTitle();
            content = mData.get(position).getContent();
            data = mData.get(position).getData();
//            Log.e("CONTENT", content.toString());
//            Log.e("TITLE", title.toString());
//            Log.e("DATA", data.toString());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent i = new Intent(mContext, PostDetailActivity.class);
                    i.putExtra("content", content);
                    i.putExtra("title", title);
                    i.putExtra("data", data);


                    mContext.startActivity(i);
                }
            });



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
            TextView content;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                title = itemView.findViewById(R.id.id_title);
                data =itemView.findViewById(R.id.id_published);
                excerpt = itemView.findViewById(R.id.id_excerpt);
                image = itemView.findViewById(R.id.id_image);
                content = itemView.findViewById(R.id.content);
                image = itemView.findViewById(R.id.id_image);

            }
        }

    }
}
