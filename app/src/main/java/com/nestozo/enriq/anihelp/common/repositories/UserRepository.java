package com.nestozo.enriq.anihelp.common.repositories;
import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.nestozo.enriq.anihelp.ViewModels.ViewModelLogin;
import com.nestozo.enriq.anihelp.common.model.User;

public class UserRepository {
    FirebaseAuth auth;
    ViewModelLogin viewModel;
    public UserRepository(ViewModelLogin viewModel){
        this.viewModel = viewModel;
        auth = FirebaseAuth.getInstance();
    }

    public void signIn(User user){
        auth.signInWithEmailAndPassword(user.getEmail(),user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isComplete()){
                    if(task.isSuccessful()){
                        viewModel.loadMainView();
                    }else{
                        viewModel.loadErrorMessage("Correo y/o contraseña incorrectos");
                    }

                }else{
                    viewModel.loadErrorMessage("Error al comunicarse con el servidor, intente más tarde");
                }
            }
        });
    }

}
