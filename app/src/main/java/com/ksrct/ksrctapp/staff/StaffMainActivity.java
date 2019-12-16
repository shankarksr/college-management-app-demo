package com.ksrct.ksrctapp.staff;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ksrct.ksrctapp.About;
import com.ksrct.ksrctapp.LoginAct;
import com.ksrct.ksrctapp.R;
import com.ksrct.ksrctapp.feedback;

import java.util.Objects;

public class StaffMainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.draw);
        drawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.closer);
        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        Toolbar mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("KSRCT app");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.logoutb:
                logout();
                return true;
            case R.id.feedback:
                sendtoFeedback();
                return true;
            case R.id.about:
                showAbout();
                return true;
            default:
                return false;
        }
    }

    private void logout() {
        Intent intent=new Intent(this,LoginAct.class);
        startActivity(intent);
        }

    private void showAbout() {
        Intent intent=new Intent(this,About.class);
        startActivity(intent);
    }

    private void sendtoFeedback() {
        Intent intent=new Intent(this,feedback.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_items,menu);
        return true;
    }

    @Override
    public void onBackPressed()
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AlertDia));
        builder.setMessage("Are you sure want to exit?");
        builder.setCancelable(true);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
