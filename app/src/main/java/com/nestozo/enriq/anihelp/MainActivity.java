package com.nestozo.enriq.anihelp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nestozo.enriq.anihelp.ViewModels.ViewModelLogin;
import com.nestozo.enriq.anihelp.common.callbacks.LoginCallbacks;
import com.nestozo.enriq.anihelp.common.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginCallbacks{
    @BindView(R.id.buttonLogin)
    Button buttonlogin;
    @BindView(R.id.editTextEmail)
    EditText editTextEmail;
    @BindView(R.id.editTextPassword)
    EditText editTextPassword;

    ViewModelLogin viewModelLogin;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getApplicationContext().getSharedPreferences("Preferences",0);
        String login = sharedPreferences.getString("LOGIN",null);
        if(login !=null){
            goToAppActivity();
        }else{
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);
            viewModelLogin = ViewModelProviders.of(this, new ViewModelFactory(this)).get(ViewModelLogin.class);
        }
    }

    @OnClick(R.id.buttonLogin)
    public void login(View view){
        viewModelLogin.setUser(new User(editTextEmail.getText().toString(),editTextPassword.getText().toString()));
    }

    @Override
    public void onSucces(User user) {
        saveUser(user);
        goToAppActivity();
    }

    public void saveUser(User user){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("LOGIN",user.getEmail());
        editor.commit();
    }

    public void goToAppActivity(){
        Intent intento = new Intent(this,AppActivity.class);
        startActivity(intento);
        finish();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
