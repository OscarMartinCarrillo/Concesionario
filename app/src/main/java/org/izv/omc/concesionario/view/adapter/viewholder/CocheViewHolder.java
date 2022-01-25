package org.izv.omc.concesionario.view.adapter.viewholder;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;

import org.izv.omc.concesionario.R;
import org.izv.omc.concesionario.model.Coche;

public class CocheViewHolder extends RecyclerView.ViewHolder {

    public Coche coche;
    public Bundle bundle;
    public TextView tvName, tvPrice, tvKM, tvCV, tvFuel, tvGear, tvRef;
    public ImageSlider ivCar;

    public CocheViewHolder(@NonNull View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.tvName);
        tvPrice = itemView.findViewById(R.id.tvPrice);
        tvKM = itemView.findViewById(R.id.tvKM);
        tvCV = itemView.findViewById(R.id.tvCV);
        tvFuel = itemView.findViewById(R.id.tvFuel);
        tvGear = itemView.findViewById(R.id.tvGear);
        tvRef = itemView.findViewById(R.id.tvRef);
        ivCar = itemView.findViewById(R.id.ivCar);


        itemView.setOnClickListener(view -> {
            bundle = new Bundle();
            bundle.putParcelable("coche", coche);
            Navigation.findNavController(view).navigate(R.id.action_first_to_second, bundle);
        });
    }
}
