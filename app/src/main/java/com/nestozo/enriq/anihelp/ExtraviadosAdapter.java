package com.nestozo.enriq.anihelp;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.nestozo.enriq.anihelp.POJO.Animal;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExtraviadosAdapter extends RecyclerView.Adapter<ExtraviadosAdapter.ViewHolder> {
    private List<Animal> animals;
    


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.animalImageView)
        AppCompatImageView animalImage;
        @BindView(R.id.textViewUbicacion)
        AppCompatTextView animalLocation;
        @BindView(R.id.textViewNombre)
        AppCompatTextView animalName;

        private View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.view = itemView;
        }
    }
}
