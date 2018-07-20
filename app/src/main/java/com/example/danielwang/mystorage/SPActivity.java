package com.example.danielwang.mystorage;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.danielwang.mystorage.MyUtils.SharedPreferencesUtils;

/**
 * @author danielwang
 * @Description:
 * @date 2018/7/16 10:01
 */
public class SPActivity extends Activity {
    private EditText editText;
    private TextView textView;
    private Button btSave, btGet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        initViews();
    }

    private void initViews() {
        editText = findViewById(R.id.sp_edit);
        textView = findViewById(R.id.sp_text);
        btSave = findViewById(R.id.sp_save);
        btGet = findViewById(R.id.sp_get);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                if (!TextUtils.isEmpty(s)) {
                    SharedPreferencesUtils.putString(SPActivity.this, "sp", s);
                }

            }
        });

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = SharedPreferencesUtils.getString(SPActivity.this, "sp", "1");
                if (!TextUtils.isEmpty(s)) {
                    textView.setText(s);
                }
            }
        });
    }


}
