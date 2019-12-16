package com.ksrct.ksrctapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LaunchAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent;
        intent= new Intent(this,LoginAct.class);
        startActivity(intent);
        finish();
    }
}
