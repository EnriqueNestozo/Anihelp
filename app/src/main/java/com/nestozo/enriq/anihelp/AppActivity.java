package com.nestozo.enriq.anihelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nestozo.enriq.anihelp.presentation.view.AdoptionFragment;
import com.nestozo.enriq.anihelp.presentation.view.ExtraviadosFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppActivity extends AppCompatActivity implements ExtraviadosFragment.OnFragmentInteractionListener, AdoptionFragment.OnFragmentInteractionListener {
    @BindView(R.id.bottom_navbar) BottomNavigationView bottomNavigationView;
    ExtraviadosFragment extraviadosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        ButterKnife.bind(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ExtraviadosFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()){
                    case R.id.nav_extraviados:
                        selectedFragment = new ExtraviadosFragment();
                        break;
                    case R.id.nav_adopcion:
                        selectedFragment = new AdoptionFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                return true;
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
