package com.example.mozeeb.presidenrepublikindonesia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mozeeb.presidenrepublikindonesia.Adapter.CardViewPresidentAdapter;
import com.example.mozeeb.presidenrepublikindonesia.Adapter.GridPresidentAdapter;
import com.example.mozeeb.presidenrepublikindonesia.Adapter.ListPresidentAdapter;
import com.example.mozeeb.presidenrepublikindonesia.Model.President;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<President> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = (RecyclerView) findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(PresidentData.getListData());

        showRecyclerList();

    }

    //untuk menampilkan judul setiap di klik
    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    //Untuk menampilkan RcyclerView
    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListPresidentAdapter listPresidentAdapter = new ListPresidentAdapter(this);
        listPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(listPresidentAdapter);
    }
    //untuk menampilkan GridView

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridPresidentAdapter gridPresidentAdapter = new GridPresidentAdapter(this);
        gridPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(gridPresidentAdapter);
    }

    //Untuk menampilkan CardView
    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewPresidentAdapter cardViewPresidentAdapter = new CardViewPresidentAdapter(this);
        cardViewPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(cardViewPresidentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = null;
        switch (item.getItemId()) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                title = "Mode Grid";
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
