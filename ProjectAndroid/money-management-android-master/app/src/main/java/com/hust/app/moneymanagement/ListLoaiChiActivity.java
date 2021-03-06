package com.hust.app.moneymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hust.app.moneymanagement.adapter.LoaiChiAdapter;
import com.hust.app.moneymanagement.dao.LoaiChiDAO;
import com.hust.app.moneymanagement.model.LoaiChi;

import java.util.List;

public class ListLoaiChiActivity extends AppCompatActivity {
    LoaiChiAdapter adapter;
    LoaiChiDAO loaiChiDAO;
    ListView lvLoaiChi;
    List<LoaiChi> loaiChiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_loai_chi);
        setupToolbar();
        lvLoaiChi = findViewById(R.id.lvLoaiChi);

        loaiChiDAO = new LoaiChiDAO(this);
        loaiChiList = loaiChiDAO.getAllLoaiChi();
        adapter = new LoaiChiAdapter(this,loaiChiList);
        lvLoaiChi.setAdapter(adapter);
    }
    public void setupToolbar(){
        setTitle("");
        Toolbar toolbar = findViewById(R.id.toolbarListLoaiChi);
        setSupportActionBar(toolbar);
        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Loại chi tiêu");
        ImageView ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void them(View view) {
        startActivity(new Intent(getApplicationContext(),ThemLoaiChiActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        loaiChiList.clear();
        loaiChiList = loaiChiDAO.getAllLoaiChi();
        adapter.setDataChange(loaiChiList);
    }
}