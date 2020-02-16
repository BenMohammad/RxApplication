package com.benmohammad.rxapplication.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;

import com.benmohammad.rxapplication.R;
import com.benmohammad.rxapplication.base.BaseFragment;
import com.benmohammad.rxapplication.util.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class DetailsFragment extends BaseFragment {

    @BindView(R.id.tv_repo_name )
    TextView repoNameTextView;

    @BindView(R.id.tv_repo_description)
    TextView repoDescriptionTextView;

    @BindView(R.id.tv_forks)
    TextView forksTextView;

    @BindView(R.id.tv_stars)
    TextView starsTextView;

    @Inject
    ViewModelFactory viewModelFactory;

    private DetailsViewModel detailsViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        detailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(DetailsViewModel.class);
        detailsViewModel.restoreFromBundle(savedInstanceState);
        displayRepo();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        detailsViewModel.saveToBundle(outState);
    }

    private void displayRepo() {
        detailsViewModel.getSelectedRepo().observe(getBaseActivity(), repo -> {
            if(repo != null) {
                repoNameTextView.setText(repo.name);
                repoDescriptionTextView.setText(repo.description);
                forksTextView.setText(String.valueOf(repo.forks));
                starsTextView.setText(String.valueOf(repo.stars));
            }
        });
    }

    @Override
    protected int layoutRes() {
        return R.layout.screen_details;
    }


}
