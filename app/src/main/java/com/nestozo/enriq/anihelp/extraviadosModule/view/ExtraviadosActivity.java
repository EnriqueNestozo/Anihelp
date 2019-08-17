package com.nestozo.enriq.anihelp.extraviadosModule.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;

import com.nestozo.enriq.anihelp.R;

public class ExtraviadosActivity extends AppCompatActivity implements ExtraviadosFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extraviados);
        commitFragment();
    }

    private void commitFragment() {
        ExtraviadosFragment fragment= new ExtraviadosFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activity_extraviados,fragment,null);
        fragmentTransaction.commit();

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
