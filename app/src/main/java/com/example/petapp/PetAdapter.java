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

/**
 *  @author UP915469
 *  Adapter used to manage the pet lists functionatility.
 * @see com.example.petapp.PetList for information on how this adapter is used.
 */
class PetAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<PetAdapter.ViewHolder> {

    List<Pet> pets;
    private Context context;
    private OnSelectListener onSelectListener;

    public PetAdapter(List<Pet> pets, Context context, OnSelectListener onSelectListener){
        this.pets = pets;
        this.context = context;
        this.onSelectListener = onSelectListener;
    }
    @NonNull
    @Override
    public PetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_list, parent, false);
        return new ViewHolder(view, onSelectListener);
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

    /**
     *  @author UP915469
     *  Class responsible for assigning the pet name and img to each list item
     *  Also manages the onclick call for each list item.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView petName;
        public ImageView petImg;
        OnSelectListener onSelectListener;

        public ViewHolder(@NonNull View itemView, OnSelectListener onSelectListener) {
            super(itemView);
            petName = itemView.findViewById(R.id.pet_name);
            petImg = itemView.findViewById(R.id.pet_img);

            this.onSelectListener = onSelectListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            onSelectListener.onPetClick(getAdapterPosition());
        }
    }

    public interface OnSelectListener {
        void onPetClick(int position);
    }
}
