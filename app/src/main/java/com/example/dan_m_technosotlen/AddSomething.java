package com.example.dan_m_technosotlen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dan_m_technosotlen.Database.Entities.TechnoStolen;
import com.example.dan_m_technosotlen.databinding.FragmentAddSomethingBinding;


public class AddSomething extends Fragment {

    FragmentAddSomethingBinding binding;
    ElectronicViewModel viewModel;


    public AddSomething() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ElectronicViewModel.class);
        binding = FragmentAddSomethingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.saveIiiiiiiiiiiit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.addItem(new TechnoStolen(binding.writeHereGoddamit.getText().toString()));

                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }
}