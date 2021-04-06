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

import com.belajar.tugasvolumebangunruang.databinding.FragmentSphereBinding;
import com.bumptech.glide.Glide;



public class SphereFragment extends Fragment {
    FragmentSphereBinding binding;
    public SphereFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSphereBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String urlImage = "https://id-static.z-dn.net/files/dc1/050c3588ee5f014487817461647a7f74.jpg";
        Glide.with(this)
                .load(urlImage)
                .into(binding.ivSphere);
        binding.btnCalculate.setOnClickListener(view1 -> {
            String inputRadius = binding.edtRadius.getText().toString().trim();
            if(TextUtils.isEmpty(inputRadius)){
                Toast.makeText(getContext(), "Silakan isi jari-jari bola", Toast.LENGTH_LONG).show();
                binding.edtRadius.requestFocus();
            }
            double radius = Double.parseDouble(inputRadius);
            double volume = 4*(Math.PI*radius*radius*radius)/3;
            double sArea = 4*Math.PI*radius*radius;

            binding.tvVolumeResult.setText(String.valueOf(volume));
            binding.tvAreaResult.setText(String.valueOf(sArea));

            binding.tvAreaResult.setVisibility(View.VISIBLE);
            binding.tvVolumeResult.setVisibility(View.VISIBLE);
        });

    }
}