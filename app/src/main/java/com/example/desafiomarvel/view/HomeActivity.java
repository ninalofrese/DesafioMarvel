package com.example.desafiomarvel.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafiomarvel.R;
import com.example.desafiomarvel.model.Result;
import com.example.desafiomarvel.view.adapter.RecyclerMonthAdapter;
import com.example.desafiomarvel.view.interfaces.ComicOnClick;
import com.example.desafiomarvel.viewmodel.HomeActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements ComicOnClick {
    private RecyclerView recyclerMonthComics;
    private ProgressBar progressMonthComics;
    private HomeActivityViewModel viewModel;
    private RecyclerMonthAdapter adapter;
    private List<Result> monthComics = new ArrayList<>();

    public int offset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("This Month");

        initViews();

        viewModel.getThisMonthComics(offset);

        viewModel.getComics().observe(this, results -> {
            adapter.updateList(results);
        });

        viewModel.getLoading().observe(this, aBoolean -> {
            if (aBoolean) {
                progressMonthComics.setVisibility(View.VISIBLE);
            } else {
                progressMonthComics.setVisibility(View.GONE);
            }
        });

        viewModel.getError().observe(this, s -> {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        });
    }

    public void initViews() {
        recyclerMonthComics = findViewById(R.id.recycler_home_comics);
        progressMonthComics = findViewById(R.id.progress_home_comics);
        viewModel = ViewModelProviders.of(this).get(HomeActivityViewModel.class);
        adapter = new RecyclerMonthAdapter(monthComics, this);
        recyclerMonthComics.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerMonthComics.setAdapter(adapter);
    }

    @Override
    public void onClick(Result result) {
        Intent intent = new Intent(HomeActivity.this, DetalheActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("result", result);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
