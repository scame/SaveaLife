package com.krestone.savealife.presentation.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.krestone.savealife.R;
import com.krestone.savealife.data.entities.responses.map.MapObject;

import butterknife.BindView;
import butterknife.OnClick;

public class SosWindowFragment extends AbstractFragment {

    @BindView(R.id.address_tv)
    TextView addressTv;

    @BindView(R.id.accident_time)
    TextView accidentTimeTv;

    @BindView(R.id.dismiss_window_btn)
    ImageButton dismissBtn;

    @BindView(R.id.help_btn)
    Button helpButton;

    public static SosWindowFragment newInstance(MapObject mapObject) {
        SosWindowFragment sosWindowFragment = new SosWindowFragment();
        Bundle args = new Bundle();

        args.putParcelable(SosWindowFragment.class.getCanonicalName(), mapObject);
        sosWindowFragment.setArguments(args);

        return sosWindowFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = super.onCreateView(inflater, container, savedInstanceState);

        return fragmentView;
    }

    @Override
    protected void inject() {

    }

    @OnClick(R.id.dismiss_window_btn)
    public void onDismissClick(View v) {
        getFragmentManager().popBackStack();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.sos_window;
    }
}