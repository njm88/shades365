package com.tinker.shades365;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_colorwheel, R.id.navigation_dashboard, R.id.navigation_quickselector)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        getSupportActionBar().hide();
        navView.setItemIconTintList(createColorStateList());
    }

    private ColorStateList createColorStateList() {
        int[][] states = new int[][] {
                new int[]{android.R.attr.state_pressed},
                new int[] {-android.R.attr.state_checked},
                new int[]{android.R.attr.state_enabled},
                new int[]{} // this should be empty to make default color as we want
        };

        int[] colors = new int[] {
                Color.BLACK,
                Color.GRAY,
                Color.MAGENTA,
                Color.WHITE
        };

        return new ColorStateList(states, colors);
    }

}
