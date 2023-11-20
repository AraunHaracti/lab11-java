package com.example.dan_m_technosotlen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import android.app.Activity;


import com.example.dan_m_technosotlen.Database.Dao.ElCountryDao;
import com.example.dan_m_technosotlen.Database.Dao.ElTypeDao;
import com.example.dan_m_technosotlen.Database.Dao.TechnoStolenDao;
import com.example.dan_m_technosotlen.Database.Database;
import com.example.dan_m_technosotlen.Database.Entities.El_Country;
import com.example.dan_m_technosotlen.Database.Entities.El_Type;
import com.example.dan_m_technosotlen.Database.Entities.TechnoStolen;
import com.example.dan_m_technosotlen.databinding.FragmentStatusBinding;


import java.util.List;
import java.util.stream.Collectors;

public class StatusFragment extends Fragment {
    FragmentStatusBinding binding;
    ElectronicViewModel viewModel;
    List<TechnoStolen> technoStolens;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentStatusBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(this).get(ElectronicViewModel.class);

        viewModel.getListValues().observe(getViewLifecycleOwner(), new Observer<List<TechnoStolen>>() {
            @Override
            public void onChanged(List<TechnoStolen> technoStolen) {
                technoStolens = technoStolen;
            }
        });

        return binding.getRoot();

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //testDataInit();

        setInitList(view);

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_view_tag, new AddSomething(), "addddd")
                        .addToBackStack("returnnnn")
                        .commit();
            }
        });

        binding.listWithElectronic.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                binding.LOADBar.setVisibility(View.VISIBLE);
                binding.listWithElectronic.setVisibility(View.GONE);

                viewModel.deleteItem((TechnoStolen) parent.getItemAtPosition(position));
                setInitList(view);
                return false;
            }
        });

    }

//    private void testDataInit(){
//        TechnoStolen technoStolen_status = new TechnoStolen("GDGSD-5325");
//        TechnoStolen technoStolen_status2 = new TechnoStolen("HFDH-75");
//        TechnoStolen technoStolen_status3 = new TechnoStolen("NFSGHRT-1462");
//        El_Country el_country = new El_Country("Germany");
//        El_Type el_type = new El_Type("Mouse");
//
//        Runnable insertCarRnb = ()->{
//
//            viewModel.addStatuses_Tech(technoStolen_status);
//            viewModel.addStatuses_Tech(technoStolen_status2);
//            viewModel.addStatuses_Tech(technoStolen_status3);
//            //viewModel.addStatuses_Country(el_country);
//            //viewModel.addStatuses_Type(el_type);
//
//        };
//        Thread thread = new Thread(insertCarRnb);
//        thread.start();
//    }
    private void setInitList(View view) {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    viewModel.execute();
                    Thread.sleep(1500);
                    if (technoStolens == null) return;

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            AdapterTechnoStolen adapterTechnoStolen =
                                    new AdapterTechnoStolen(getContext(), R.layout.item_list, technoStolens);

                            binding.listWithElectronic.setAdapter(adapterTechnoStolen);

                            binding.LOADBar.setVisibility(View.GONE);
                            binding.listWithElectronic.setVisibility(View.VISIBLE);
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }
}