package com.example.to_do_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Button btn_add;
    private EditText writeText;
    private LinearLayout layoutList, layoutDelete;
    private static int id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeText = findViewById(R.id.writeText);
        layoutList = findViewById(R.id.layoutList);
        btn_add = findViewById(R.id.btn_add);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Layout List
                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layout.topMargin = 20;
                //Text view setting
                TextView text = new TextView(MainActivity.this);
                text.setId(id);
                text.setTextSize(20);
                text.setTextColor(Color.WHITE);
                text.setText(id + ") " + writeText.getText().toString());
                layoutList.addView(text, layout);
                writeText.setText(null);
                id++;

                //Layout delete
                LinearLayout.LayoutParams lDelete = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btn_clear:
                id = 1;
                layoutList.removeAllViews();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}