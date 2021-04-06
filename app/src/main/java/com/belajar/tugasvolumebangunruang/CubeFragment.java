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

import com.belajar.tugasvolumebangunruang.databinding.FragmentCubeBinding;
import com.bumptech.glide.Glide;


public class CubeFragment extends Fragment {
    private FragmentCubeBinding binding;

    public CubeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCubeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String urlImage = "https://asset-a.grid.id//crop/0x0:0x0/700x0/photo/2021/02/02/kerangka-kubusjpg-20210202095535.jpg";
        Glide.with(this)
                .load(urlImage)
                .into(binding.ivCube);
        binding.btnCalculate.setOnClickListener(view1 -> {
            String inputLength = binding.edtLength.getText().toString().trim();
            if(TextUtils.isEmpty(inputLength)){
                Toast.makeText(getContext(), "Silakan isi panjang sisi kubus", Toast.LENGTH_LONG).show();
                binding.edtLength.requestFocus();
            }
            double length = Double.parseDouble(inputLength);
            double volume = length * length * length;
            double sArea = length * length * 6;
            binding.tvVolumeResult.setText(String.valueOf(volume));
            binding.tvAreaResult.setText(String.valueOf(sArea));

            binding.tvAreaResult.setVisibility(View.VISIBLE);
            binding.tvVolumeResult.setVisibility(View.VISIBLE);


        });





    }
}