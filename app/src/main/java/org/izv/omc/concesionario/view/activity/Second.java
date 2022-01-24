package org.izv.omc.concesionario.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import org.izv.omc.concesionario.databinding.FragmentSecondBinding;
import org.izv.omc.concesionario.model.Coche;

import java.util.ArrayList;

public class Second extends Fragment {
    private FragmentSecondBinding binding;
    private Coche coche;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialize();
    }

    private void initialize() {
        Bundle bundle = new Bundle();
        bundle = getArguments();
        coche = bundle.getParcelable("coche");

        binding.tvNameFicha.setText(coche.getTitulo());
        binding.tvPrecioFicha.setText(coche.getPrecio() + " €");
        binding.tvKmFicha.setText(coche.getKm() + " km");
        binding.tvCambioFicha.setText(coche.getCambio());
        binding.tvCombustibleFicha.setText(coche.getCombustible());
        binding.tvPotenciaFicha.setText(coche.getPotencia() + " cv");
        binding.tvLugarFicha.setText(coche.getLugar());
        binding.tvNPuertasFicha.setText(String.valueOf(coche.getNpuertas()));
        binding.tvColorFicha.setText(coche.getColor());
        binding.tvAnyoFicha.setText(String.valueOf(coche.getYear()));
        binding.tvDescripcionFicha.setText(coche.getDescr());
        binding.tvUrlFicha.setText(coche.getUrl());

        //Si pulsamos en la URL nos abre le navegador con ella
        binding.tvUrlFicha.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(coche.getUrl()));
            startActivity(i);
        });

        //Cargo el contenido del Slider
        ArrayList<SlideModel> imagenes = new ArrayList<>();
        for (int i = 0; i < coche.getImagenes().length; i++) {
            imagenes.add(new SlideModel(coche.getImagenes()[i], (i+1)+"/"+coche.getImagenes().length, ScaleTypes.CENTER_INSIDE));
        }
        binding.imageSlider.setImageList(imagenes);
    }
}