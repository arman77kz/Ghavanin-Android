package com.megadroid.ghanoun;

import android.app.LauncherActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.megadroid.ghanoun.model.Api;
import com.megadroid.ghanoun.model.Hero;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.megadroid.ghanoun.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<ListItem> listItems;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listItems = new ArrayList<>();


        ListItem listItem = new ListItem("headnig","descritionssss");
        listItems.add(listItem);


        adapter = new MyAdapter(listItems,this);




        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        listView =(ListView)findViewById(R.id.listview);
        Retrofit retrofit = new  Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);

        Call<List<Hero>> call =api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {


            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroes = response.body();

                String [] heroNames = new String[heroes.size()];

                for (int i = 0; i<heroes.size();i++){

                    heroNames[i]=heroes.get(i).getName();
                }

                listView.setAdapter(
                        new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,heroNames)
                );


                adapter = new MyAdapter(Call<List<Hero>> heroes ,this);


            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });


    }
}
