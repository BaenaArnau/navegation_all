package com.example.navegationall;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.os.Bundle;

import com.example.navegationall.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        setSupportActionBar(binding.toolbar);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                // Top-level destinations:
                R.id.drawer1Fragment, R.id.drawer2Fragment
        )
                .setOpenableLayout(binding.drawerLayout)
                .build();

        NavController navController1 = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment1)).getNavController();
        NavigationUI.setupWithNavController(binding.navView, navController1);
        NavigationUI.setupWithNavController(binding.toolbar, navController1, appBarConfiguration);

        NavController navController2 = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment2)).getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavView, navController2);

        navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment3)).getNavController();
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }
}
