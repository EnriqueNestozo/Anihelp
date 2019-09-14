package com.nestozo.enriq.anihelp.presentation.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.nestozo.enriq.anihelp.common.model.Animal;
import com.nestozo.enriq.anihelp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExtraviadosAdapter extends RecyclerView.Adapter<ExtraviadosAdapter.ViewHolder> {
    private List<Animal> animals;
    private OnItemClickListener listener;
    private Context context;

    public ExtraviadosAdapter(List<Animal> animals, OnItemClickListener listener) {
        this.animals = animals;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false);
        this.context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Animal animal = animals.get(position);
            holder.setOnClickListener(animal,listener);
            holder.animalName.setText(context.getString(R.string.item_animal_name, animal.getName()));
            holder.lastAnimalLocation.setText(context.getString(R.string.item_animal_location, animal.getLastLocation()));
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.animalImageView)
        AppCompatImageView animalImage;
        @BindView(R.id.textViewUbicacion)
        AppCompatTextView lastAnimalLocation;
        @BindView(R.id.textViewNombre)
        AppCompatTextView animalName;

        private View view;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.view = itemView;
        }

        void setOnClickListener(final Animal animal, final OnItemClickListener listener) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(animal);
                }
            });
        }
    }
}
