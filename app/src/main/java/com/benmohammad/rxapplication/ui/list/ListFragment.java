package com.benmohammad.rxapplication.ui.list;

import com.benmohammad.rxapplication.base.BaseFragment;
import com.benmohammad.rxapplication.data.model.Repo;

public class ListFragment extends BaseFragment implements RepoSelectedListener {

    @Override
    protected int layoutRes() {
        return 0;
    }

    @Override
    public void onRepoSelected(Repo repo) {

    }
}
