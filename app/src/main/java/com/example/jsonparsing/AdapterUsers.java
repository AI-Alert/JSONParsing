package com.example.jsonparsing;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterUsers  {
    public static class AdapteryUsers extends RecyclerView.Adapter<AdapteryUsers.MyUserViewHolder>{

        private Context mContext;
        private List<UserModelClass> mData;

//Переменные для UserDetail

        String amplua;
        String group;
        String firstname;
        String lastname;
        String email;
        String year;
        String height;
        String weight;

        public AdapteryUsers(Context mContext, List<UserModelClass> mData) {
            this.mContext = mContext;
            this.mData = mData;
        }

        @NonNull
        @Override
        public MyUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.user_item, parent, false);



            return new MyUserViewHolder(view);
        }

//Метод для UserDetail и Users

        @Override
        public void onBindViewHolder(@NonNull MyUserViewHolder holderUser, int position) {
            UserModelClass ins = mData.get(position);

            //Для Users

            holderUser.firstname.setText(mData.get(position).getFirstname());
            holderUser.lastname.setText(mData.get(position).getEmail());

            holderUser.email.setText(mData.get(position).getEmail());
            holderUser.amplua.setText(mData.get(position).getAmplua());

            //Для UserDetail

            firstname = mData.get(position).getFirstname();
            lastname = mData.get(position).getLastname();

            amplua = mData.get(position).getAmplua();
            group = mData.get(position).getGroup();

            email = mData.get(position).getEmail();
            year = mData.get(position).getYear();

            height = mData.get(position).getHeight();
            weight = mData.get(position).getWeight();

            holderUser.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(mContext, UserDetailActivity.class);
                    i.putExtra("firstname", ins.getFirstname());
                    i.putExtra("lastname", ins.getLastname());

                    i.putExtra("amplua", ins.getAmplua());
                    i.putExtra("group", ins.getGroup());

                    i.putExtra("email", ins.getEmail());
                    i.putExtra("year", ins.getYear());

                    i.putExtra("height", ins.getHeight());
                    i.putExtra("weight", ins.getWeight());

                    mContext.startActivity(i);
                }
            });



            Glide.with(mContext)
                    .load(mData.get(position).getImg())
                    .into(holderUser.image);

        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

//Для Users

        public static class MyUserViewHolder extends RecyclerView.ViewHolder{

            TextView firstname;
            TextView lastname;
            TextView email;
            ImageView image;
            TextView amplua;
            TextView group;


            public MyUserViewHolder(@NonNull View itemView) {
                super(itemView);

                firstname = itemView.findViewById(R.id.firstname);
                lastname =itemView.findViewById(R.id.id_lastname);
                amplua =itemView.findViewById(R.id.id_amplua);
                group =itemView.findViewById(R.id.id_group);
                image = itemView.findViewById(R.id.id_image_user);

            }
        }

    }
}
