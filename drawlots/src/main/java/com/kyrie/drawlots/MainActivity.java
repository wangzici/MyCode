package com.kyrie.drawlots;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatEditText mEtAdd;
    RecyclerView mRv_Player;

    private List<String> mPlayers = new ArrayList<>();
    private String[] mResults;
    private PlayerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mEtAdd = findViewById(R.id.et_add);
        mRv_Player = findViewById(R.id.rv_player);
        mRv_Player.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void initData() {
        mAdapter = new PlayerAdapter(R.layout.layout_item, mPlayers);
        mRv_Player.setAdapter(mAdapter);
    }

    private void initEvent() {
        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_drawlots).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final int id = view.getId();
        switch (id) {
            case R.id.btn_add:
                addPlayer();
                break;
            case R.id.btn_drawlots:
                getResult();
                break;
        }
    }

    private void getResult() {
        final int size = mPlayers.size();
        mResults = mPlayers.toArray(new String[0]);
        for (int i = 0; i < size; i++) {
            int random = new Random().nextInt(size);
            String temp = mResults[i];
            mResults[i] = mResults[random];
            mResults[random] = temp;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.final_result);
        builder.setIcon(R.drawable.papapa);
        builder.setItems(mResults, null);
        builder.create().show();
    }

    private void addPlayer() {
        String username = mEtAdd.getEditableText().toString();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
        } else {
            mPlayers.add(username);
            mAdapter.notifyItemInserted(mPlayers.size());
            mEtAdd.setText("");
        }
    }
}
