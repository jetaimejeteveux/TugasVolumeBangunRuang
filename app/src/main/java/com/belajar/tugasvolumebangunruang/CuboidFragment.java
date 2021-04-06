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
import com.belajar.tugasvolumebangunruang.databinding.FragmentCuboidBinding;
import com.bumptech.glide.Glide;


public class CuboidFragment extends Fragment {
    private FragmentCuboidBinding binding;
    public CuboidFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCuboidBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String urlImage = "https://rumuspintar.com/wp-content/uploads/2019/07/Balok.jpg";
        Glide.with(this)
                .load(urlImage)
                .into(binding.ivCuboid);
        binding.btnCalculate.setOnClickListener(view1 -> {
            String inputLength = binding.edtLength.getText().toString().trim();
            String inputWidth = binding.edtWidth.getText().toString().trim();
            String inputHeight = binding.edtHeight.getText().toString().trim();

            if(TextUtils.isEmpty(inputLength)){
                Toast.makeText(getContext(), "Silakan isi panjang balok", Toast.LENGTH_LONG).show();
                binding.edtLength.requestFocus();
            }
            if(TextUtils.isEmpty(inputWidth)){
                Toast.makeText(getContext(), "Silakan isi lebar balok", Toast.LENGTH_LONG).show();
                binding.edtWidth.requestFocus();
            }
            if(TextUtils.isEmpty(inputHeight)){
                Toast.makeText(getContext(), "Silakan isi tinggi balok", Toast.LENGTH_LONG).show();
                binding.edtHeight.requestFocus();
            }

            double length = Double.parseDouble(inputLength);
            double width = Double.parseDouble(inputWidth);
            double height = Double.parseDouble(inputHeight);

            double volume = length * width * height;
            double sArea = 2 * ((length * width) + (width * height) + (length * height));

            binding.tvVolumeResult.setText(String.valueOf(volume));
            binding.tvAreaResult.setText(String.valueOf(sArea));

            binding.tvAreaResult.setVisibility(View.VISIBLE);
            binding.tvVolumeResult.setVisibility(View.VISIBLE);
        });

    }
}