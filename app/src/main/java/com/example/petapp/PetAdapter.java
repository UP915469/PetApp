package com.example.petapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static java.security.AccessController.getContext;

class PetAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<PetAdapter.ViewHolder> {

    List<Pet> pets;
    private Context context;

    public PetAdapter(List<Pet> pets, Context context){
        this.pets = pets;
        this.context = context;
    }
    @NonNull
    @Override
    public PetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetAdapter.ViewHolder holder, int position) {
        holder.petName.setText(pets.get(position).getName());
        int resourceId = context.getResources().getIdentifier(pets.get(position).getImgPath(),"drawable","com.example.petapp");
        holder.petImg.setImageResource(resourceId);
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView petName;
        public ImageView petImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            petName = itemView.findViewById(R.id.pet_name);
            petImg = itemView.findViewById(R.id.pet_img);
        }
    }
}
