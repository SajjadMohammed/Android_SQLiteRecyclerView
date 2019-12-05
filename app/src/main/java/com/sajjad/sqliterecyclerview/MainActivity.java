package com.sajjad.sqliterecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.service.quicksettings.TileService;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.sajjad.sqliterecyclerview.PersonPackage.PersonModel;
import com.sajjad.sqliterecyclerview.PersonPackage.PersonRecyclerAdapter;
import com.sajjad.sqliterecyclerview.SQLitePackage.SQLiteHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SQLiteHelper sqLiteHelper;
    RecyclerView personRecycler;
    PersonRecyclerAdapter personRecyclerAdapter;
    List<PersonModel> personModels;
    Toolbar mainToolbar;
    RecyclerView.LayoutManager layoutManager;
    LinearLayout footerLayout;
    private boolean shouldLoadMore = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mainToolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);
        footerLayout = findViewById(R.id.footerLayout);
        layoutManager = new LinearLayoutManager(this);
        personRecycler = findViewById(R.id.personRecycler);
        personRecycler.setLayoutManager(layoutManager);
        sqLiteHelper = new SQLiteHelper(this);

        personRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (dy > 0) {
                    if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == personModels.size() - 1) {
                        if (shouldLoadMore) {
                            loadMore();
                        }
                    }
                }

            }
        });

    }

    private void loadMore() {
        footerLayout.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                personModels.addAll(sqLiteHelper.getAll().subList(10, 20));
                personRecyclerAdapter.notifyDataSetChanged();
                if (personModels.size() == sqLiteHelper.getAll().size()) {
                    shouldLoadMore = false;
                }
                footerLayout.setVisibility(View.GONE);
            }
        }, 2000);
    }

    public void loadFirstPage(View view) {
        shouldLoadMore = true;
        personModels = sqLiteHelper.getAll().subList(0, 10);
        personRecyclerAdapter = new PersonRecyclerAdapter(personModels);
        personRecycler.setAdapter(personRecyclerAdapter);
    }
}