package com.belajar.tugasvolumebangunruang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.belajar.tugasvolumebangunruang.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnCube.setOnClickListener(view -> {
           Fragment fragmentCube = new CubeFragment();
           setFragment(fragmentCube);
        });
        binding.btnCuboid.setOnClickListener(view -> {
            Fragment fragmentCuboid = new CuboidFragment();
            setFragment(fragmentCuboid);
        });
        binding.btnSphere.setOnClickListener(view -> {
            Fragment fragmentSphere = new SphereFragment();
            setFragment(fragmentSphere);
        });
        binding.btnCylinder.setOnClickListener(view -> {
            Fragment fragmentCylinder = new CylinderFragment();
            setFragment(fragmentCylinder);
        });
    }
    protected void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


}