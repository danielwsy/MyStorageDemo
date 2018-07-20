package com.example.danielwang.mystorage;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author danielwang
 * @Description:
 * @date 2018/7/16 10:01
 */
public class FileActivity extends Activity implements View.OnClickListener {
    private EditText editText;
    private TextView textView;
    private Button btInSave, btInGget, btOutSave, btOutGet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        initViews();
    }

    private void initViews() {
        editText = findViewById(R.id.fil_edit);
        textView = findViewById(R.id.file_text);
        btInSave = findViewById(R.id.file_save_InternalStorage);
        btInGget = findViewById(R.id.file_get_InternalStorage);
        btOutSave = findViewById(R.id.file_save_ExternalStorage);
        btOutGet = findViewById(R.id.file_get_ExternalStorage);

        btInSave.setOnClickListener(this);
        btInGget.setOnClickListener(this);
        btOutSave.setOnClickListener(this);
        btOutGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.file_save_InternalStorage:
                break;
            case R.id.file_get_InternalStorage:
                break;
            case R.id.file_save_ExternalStorage:
                break;
            case R.id.file_get_ExternalStorage:
                break;
        }

    }
}
