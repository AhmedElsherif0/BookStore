package com.example.bookstore.view.activity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bookstore.R;
import com.example.bookstore.utility.Utility;
import com.example.bookstore.view.fragments.home.BookFragment;
import com.example.bookstore.view.fragments.home.HomeFragment;
import com.example.bookstore.view.fragments.user.ProfileFragment;
import com.example.bookstore.view.fragments.user.SignFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.bookstore.utility.Utility.openFragment;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.bottom_nav_navigationView)
    BottomNavigationView bottomNavNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bottomNavNavigationView.setOnNavigationItemSelectedListener(navListener);

        openFragment(getSupportFragmentManager(), new SignFragment(), R.id.frameLayout_fl_container);
    }
    String x = "smth";
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =

            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {

                        case R.id.nav_profile:
                            if (Utility.getToken(getApplicationContext()) != null) {
                                openFragment(getSupportFragmentManager(),
                                        new ProfileFragment(), R.id.frameLayout_fl_container);
                            } else {
                                openFragment(getSupportFragmentManager(),
                                        new SignFragment(),R.id.frameLayout_fl_container);
                            }
                            break;
                        case R.id.nav_home:
                            openFragment(getSupportFragmentManager(),
                                    new HomeFragment(), R.id.frameLayout_fl_container);
                            break;
                        case R.id.nav_book:

                            openFragment(getSupportFragmentManager(),
                                    new BookFragment(), R.id.frameLayout_fl_container);
                            break;
                    }
                    return true;
                }
            };
}
