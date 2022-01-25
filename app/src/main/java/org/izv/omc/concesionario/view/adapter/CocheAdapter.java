package org.izv.omc.concesionario.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import org.izv.omc.concesionario.R;
import org.izv.omc.concesionario.model.Coche;
import org.izv.omc.concesionario.view.adapter.viewholder.CocheViewHolder;

import java.util.ArrayList;

public class CocheAdapter extends RecyclerView.Adapter<CocheViewHolder> {

    private ArrayList<Coche> cochesList;
    private Context context;

    public CocheAdapter(Context context){ this.context = context; }

    @NonNull
    @Override
    public CocheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coche, parent, false);

        return new CocheViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CocheViewHolder holder, int position) {
        Coche coche = cochesList.get(position);
        holder.coche = coche;
        holder.tvName.setText(coche.getTitulo());
        holder.tvPrice.setText(coche.getPrecio() + " €");
        holder.tvKM.setText(coche.getKm() + " Km");
        holder.tvCV.setText(coche.getPotencia() + " cv");
        holder.tvFuel.setText(coche.getCombustible());
        holder.tvGear.setText(coche.getCambio());
        holder.tvRef.setText(String.valueOf(coche.getRef()));
        //Cargo el contenido del Slider
        ArrayList<SlideModel> imagenes = new ArrayList<>();
        for (int i = 0; i < coche.getImagenes().length; i++) {
            imagenes.add(new SlideModel(coche.getImagenes()[i], null, ScaleTypes.CENTER_CROP));
            if(i >= 5)
                i=coche.getImagenes().length;
        }
        holder.ivCar.setImageList(imagenes);
        //Glide.with(context).load(coche.getImagenPrincipal()).into(holder.ivCar);

    }

    @Override
    public int getItemCount() {
        if(cochesList == null){
            return 0;
        }
        return cochesList.size();
    }

    public void setCarList(ArrayList<Coche> cochesList){
        this.cochesList = cochesList;
    }
}
