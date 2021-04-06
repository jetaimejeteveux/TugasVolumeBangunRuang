package com.belajar.tugasvolumebangunruang;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.belajar.tugasvolumebangunruang.databinding.FragmentCylinderBinding;
import com.bumptech.glide.Glide;


public class CylinderFragment extends Fragment {
    private FragmentCylinderBinding binding;
    public CylinderFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCylinderBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String urlImage = "https://nilaimutlak.id/wp-content/uploads/2020/03/jari-jari-dan-tinggi-tabung.jpg";
        Glide.with(this)
                .load(urlImage)
                .into(binding.ivCylinder);
        binding.btnCalculate.setOnClickListener(view1 -> {
            String inputRadius = binding.edtRadius.getText().toString().trim();
            String inputHeight = binding.edtHeight.getText().toString().trim();

            if(TextUtils.isEmpty(inputRadius)){
                Toast.makeText(getContext(), "Silakan isi jari-jari tabung", Toast.LENGTH_LONG).show();
                binding.edtRadius.requestFocus();
            }
            if(TextUtils.isEmpty(inputHeight)){
                Toast.makeText(getContext(), "Silakan isi tinggi tabung", Toast.LENGTH_LONG).show();
                binding.edtRadius.requestFocus();
            }

            double radius = Double.parseDouble(inputRadius);
            double height = Double.parseDouble(inputHeight);
            double volume = Math.PI*radius*radius*height;
            double sArea = 2*Math.PI*radius*(radius+height);

            binding.tvVolumeResult.setText(String.valueOf(volume));
            binding.tvAreaResult.setText(String.valueOf(sArea));

            binding.tvAreaResult.setVisibility(View.VISIBLE);
            binding.tvVolumeResult.setVisibility(View.VISIBLE);
        });

    }
}