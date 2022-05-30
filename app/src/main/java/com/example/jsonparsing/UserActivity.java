package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    //https://run.mocky.io/v3/f0cdd274-9395-4db8-8d7a-a0ddcc24cab0
    private static String JSON_URL = "https://run.mocky.io/v3/f0cdd274-9395-4db8-8d7a-a0ddcc24cab0";

    List<UserModelClass> userList;
    RecyclerView recyclerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userList = new ArrayList<>();
        recyclerView1 = findViewById(R.id.recyclerViewUser);


        GetUserData getUserData = new GetUserData();
        getUserData.execute();

    }

    public class GetUserData extends AsyncTask<String, String, String>{


        @Override
        protected String doInBackground(String... strings) {

            String current = "";

            try {
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream inputStream = urlConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                    int data = inputStreamReader.read();
                    while (data != -1){

                        current += (char) data;
                        data = inputStreamReader.read();

                    }

                    return current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                finally {
                    if (urlConnection != null){
                        urlConnection.disconnect();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            return current;
        }

        @Override
        protected void onPostExecute(String s) {

            try {
                JSONObject jsonObject = new JSONObject(s);

                JSONArray jsonArray = jsonObject.getJSONArray("users");

                for (int i = 0 ; i<jsonArray.length(); i++){

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    UserModelClass modelClass = new UserModelClass();
                    modelClass.setFirstname(jsonObject1.getString("firstname"));
                    modelClass.setLastname(jsonObject1.getString("lastname"));
                    modelClass.setEmail(jsonObject1.getString("email"));
                    modelClass.setYear(jsonObject1.getString("year"));
                    modelClass.setGroup(jsonObject1.getString("group"));
                    modelClass.setAmplua(jsonObject1.getString("amplua"));
                    modelClass.setHeight(jsonObject1.getString("height"));
                    modelClass.setWeight(jsonObject1.getString("weight"));
                    modelClass.setImg(jsonObject1.getString("image"));


                    userList.add(modelClass);


                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            PutDataIntoRecyclerView(userList);

        }
    }

    private void PutDataIntoRecyclerView(List<UserModelClass> userList){

        AdapterUsers.AdapteryUsers adaptery = new AdapterUsers.AdapteryUsers(this, userList);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        recyclerView1.setAdapter(adaptery);

    }

}