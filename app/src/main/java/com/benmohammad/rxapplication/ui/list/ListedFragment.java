package com.benmohammad.rxapplication.ui.list;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.benmohammad.rxapplication.R;
import com.benmohammad.rxapplication.base.BaseFragment;
import com.benmohammad.rxapplication.data.model.Repo;
import com.benmohammad.rxapplication.ui.detail.DetailsFragment;
import com.benmohammad.rxapplication.ui.detail.DetailsViewModel;
import com.benmohammad.rxapplication.util.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class ListedFragment extends BaseFragment implements RepoSelectedListener {

    @BindView(R.id.recyclerView)
    RecyclerView listView;

    @BindView(R.id.tv_error)
    TextView errorTextView;

    @BindView(R.id.loading_view)
    View loadingView;

    @Inject
    ViewModelFactory viewModelFactory;

    private ListViewModel viewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(ListViewModel.class);
        listView.addItemDecoration(new DividerItemDecoration(getBaseActivity(), DividerItemDecoration.VERTICAL));
        listView.setAdapter(new RepoListAdapter(viewModel, getBaseActivity(),  this));
        listView.setLayoutManager(new LinearLayoutManager(getBaseActivity()));

        observableViewModel();

    }

    @Override
    protected int layoutRes() {
        return R.layout.screen_list;
    }

    @Override
    public void onRepoSelected(Repo repo) {
        DetailsViewModel detailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(DetailsViewModel.class);
        detailsViewModel.setSelectedRepo(repo);
        getBaseActivity().getFragmentManager().beginTransaction().replace(R.id.screenContainer, new DetailsFragment())
                .addToBackStack(null).commit();
    }

    private void observableViewModel() {
        viewModel.getRepos().observe( getBaseActivity(), repos -> {
            if(repos != null) {
                listView.setVisibility(View.VISIBLE);
            }
        });

        viewModel.getError().observe(getBaseActivity(), isError -> {
             if(isError != null) {
                 errorTextView.setVisibility(View.VISIBLE);
                 listView.setVisibility(View.GONE);
                 errorTextView.setText("An Error happened");
             } else {
                 errorTextView.setVisibility(View.GONE);
                 errorTextView.setText(null);
             }
        });

        viewModel.getLoading().observe(getBaseActivity(), isLoading -> {
            if(isLoading != null) {
                loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if(isLoading) {
                    errorTextView.setVisibility(View.GONE);
                    listView.setVisibility(View.GONE);
                }
            }
        });
    }

}
