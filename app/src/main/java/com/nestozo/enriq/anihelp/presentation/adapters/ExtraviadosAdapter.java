package com.nestozo.enriq.anihelp.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.nestozo.enriq.anihelp.common.model.Animal;
import com.nestozo.enriq.anihelp.R;
import com.nestozo.enriq.anihelp.presentation.adapters.OnItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ExtraviadosAdapter extends RecyclerView.Adapter<ExtraviadosAdapter.ViewHolder> {
    private List<Animal> animals;
    private OnItemClickListener listener;

    public ExtraviadosAdapter(List<Animal> animals, OnItemClickListener onItemClickListener) {
        this.animals = animals;
        this.listener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.animalName.setText(animals.get(position).getName());
            holder.lastAnimalLocation.setText(animals.get(position).getLastLocation());
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.animalImageView)
        CircleImageView animalImage;
        @BindView(R.id.textViewUbicacion)
        TextView lastAnimalLocation;
        @BindView(R.id.textViewNombre)
        TextView animalName;

        OnItemClickListener itemClickListener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener itemClickListener) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.itemClickListener = itemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClick(getAdapterPosition());
        }



    }
}
