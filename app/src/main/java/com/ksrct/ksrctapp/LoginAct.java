package com.ksrct.ksrctapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ksrct.ksrctapp.staff.StaffMainActivity;
import com.ksrct.ksrctapp.student.MainActivity;

public class LoginAct extends AppCompatActivity {

    private EditText email,pass;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.rnum);
        pass = findViewById(R.id.pass);
        Button logbtn = findViewById(R.id.log);
        progressDialog = new ProgressDialog(this);

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String logemail =  email.getText().toString();
                String logpass = pass.getText().toString();

                if (!TextUtils.isEmpty(logemail)&& !TextUtils.isEmpty(logpass)){
                    progressDialog.setMessage("Loading...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                    if(logemail.equals(logpass)){
                        progressDialog.dismiss();
                        Intent i = new Intent(LoginAct.this,MainActivity.class);
                        startActivity(i);
                    }if(logpass.equals("user")||logemail.equals("staff")){
                        progressDialog.dismiss();
                        Intent i = new Intent(LoginAct.this,StaffMainActivity.class);
                        startActivity(i);
                    }

                }else {
                    progressDialog.dismiss();
                    Toast.makeText(LoginAct.this,"Error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
