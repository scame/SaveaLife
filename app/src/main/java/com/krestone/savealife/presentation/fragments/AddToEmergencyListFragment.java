package com.krestone.savealife.presentation.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krestone.savealife.R;
import com.krestone.savealife.presentation.activities.DrawerActivity;
import com.krestone.savealife.presentation.models.ContactModel;
import com.krestone.savealife.presentation.presenters.AddToEmergencyListPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddToEmergencyListFragment extends Fragment implements AddToEmergencyListPresenter.AddToEmergencyListView {

    @BindView(R.id.contacts_rv)
    RecyclerView contactsRv;

    @Inject
    AddToEmergencyListPresenter<AddToEmergencyListPresenter.AddToEmergencyListView> addToEmergencyListPresenter;

    private List<ContactModel> contacts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.contacts_layout, container, false);
        ButterKnife.bind(this, fragmentView);

        inject();
        addToEmergencyListPresenter.setView(this);
        addToEmergencyListPresenter.requestContacts();

        return fragmentView;
    }

    private void inject() {
        if (getActivity() instanceof DrawerActivity) {
            ((DrawerActivity) getActivity()).provideContactsComponent().inject(this);
        }
    }


    @Override
    public void onDestroyView() {
        addToEmergencyListPresenter.destroy();
        super.onDestroyView();
    }

    @Override
    public void displayContacts(List<ContactModel> contacts) {

    }
}