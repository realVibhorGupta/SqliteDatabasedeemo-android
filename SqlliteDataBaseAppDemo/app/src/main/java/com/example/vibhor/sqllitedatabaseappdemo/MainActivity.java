package com.example.vibhor.sqllitedatabaseappdemo;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    vibhHelper vibhHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibhHelper = new vibhHelper(this);

        SQLiteDatabase sqLiteDatabase = vibhHelper.getWritableDatabase();


    }
}
