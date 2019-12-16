package com.ksrct.ksrctapp.student;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.ksrct.ksrctapp.About;
import com.ksrct.ksrctapp.LoginAct;
import com.ksrct.ksrctapp.R;
import com.ksrct.ksrctapp.feedback;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mbottomNavigationView;
    private FrameLayout mframeLayout;

    private ProfileFragment profileFragment;
    private CircularFragment circularFragment;
    private AcademicFragment academicFragment;
    private LibraryFragment libraryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbottomNavigationView = (BottomNavigationView) findViewById(R.id.main_botnav);
        mframeLayout = (FrameLayout) findViewById(R.id.main_frame);

        profileFragment = new ProfileFragment();
        circularFragment = new CircularFragment();
        academicFragment = new AcademicFragment();
        libraryFragment = new LibraryFragment();

        Toolbar mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("KSRCT app");


        setFragment(profileFragment);

        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_pro :
                        setFragment(profileFragment);
                        return true;
                    case R.id.nav_cir:
                        setFragment(circularFragment);
                        return true;
                    case R.id.nav_acad:
                        setFragment(academicFragment);
                        return true;
                    case R.id.nav_lib:
                        setFragment(libraryFragment);
                        return true;
                        default:
                            return false;

                }
            }
        });
    }
    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
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
        Intent intent=new Intent(MainActivity.this,LoginAct.class);
        startActivity(intent);
    }

    private void showAbout() {
        Intent intent=new Intent(MainActivity.this,About.class);
        startActivity(intent);
    }

    private void sendtoFeedback() {
        Intent intent=new Intent(MainActivity.this,feedback.class);
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
        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.this,R.style.AlertDia));
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
