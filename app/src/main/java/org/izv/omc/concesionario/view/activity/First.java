package org.izv.omc.concesionario.view.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import org.izv.omc.concesionario.databinding.FragmentFirstBinding;
import org.izv.omc.concesionario.model.Coche;
import org.izv.omc.concesionario.view.adapter.CocheAdapter;

import java.util.ArrayList;

public class First extends Fragment {
    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createRVCars();
    }

    private void createRVCars() {
        binding.rvCars.setLayoutManager(new LinearLayoutManager(getContext()));
        CocheAdapter carAdapter = new CocheAdapter(getContext());
        binding.rvCars.setAdapter(carAdapter);
        ArrayList<Coche> listaCars = MainActivity.coches;
        carAdapter.setCarList(listaCars);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}