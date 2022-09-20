package com.example.bottomnavigationbarexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
   private BottomNavigationView bottomNav;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
              new HomeFragment()).commit();

      bottomNav = findViewById(R.id.bottom_navigation);
      bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = new HomeFragment();

            switch (item.getItemId()) {
               case R.id.nav_home:
                  selectedFragment = new HomeFragment();
                  break;
               case R.id.nav_favorites:
                  selectedFragment = new FavoritesFragment();
                  break;
               case R.id.nav_search:
                  selectedFragment = new SearchFragment();
                  break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();

            return true;
         }
      });
   }
}