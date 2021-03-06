package com.headhunter.client.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.headhunter.client.R;
import com.headhunter.client.data.model.detail.KeySkill;
import com.headhunter.client.databinding.FragmentDetailHeadHunterBinding;
import com.headhunter.client.ui.adapter.KeySkillsAdapter;
import com.headhunter.client.utils.Constant;
import com.headhunter.client.viewmodel.detail.DetailViewModel;
import com.headhunter.client.viewmodel.detail.DetailViewModelFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailHeadHunterFragment extends Fragment {

    private DetailViewModel detailViewModel;
    private FragmentDetailHeadHunterBinding binding;
    private KeySkillsAdapter keySkillsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_detail_head_hunter, container, false);

        initializeRecyclerChips(binding.keyRecycler);

        detailViewModel = new ViewModelProvider(this, new DetailViewModelFactory(getDetailId())).get(DetailViewModel.class);
        binding.setViewModel(detailViewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        detailViewModel.getHeadHunterBodyLiveData().observe(getViewLifecycleOwner(), detailModelBody -> {
            binding.setDetailModel(detailModelBody);
            keySkillsAdapter.setList(detailModelBody.getKeySkills());
        });

    }

    private void initializeRecyclerChips(RecyclerView recyclerView) {
        List<KeySkill> list = new ArrayList<>();
        keySkillsAdapter = new KeySkillsAdapter(list);
        recyclerView.setAdapter(keySkillsAdapter);
        recyclerView.setLayoutManager(getGridLayoutManager());
    }

    private String getDetailId() {
        String id;

        if (getArguments().getString(Constant.FAVOURITE_ITEM) != null) {
            id = getArguments().getString(Constant.FAVOURITE_ITEM);
        } else {
            id = getArguments().getString(Constant.ITEM);
        }

        return id;
    }

    private GridLayoutManager getGridLayoutManager() {
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 1 || position == 6 ? 2 : 1;
            }
        });

        return manager;
    }

}
