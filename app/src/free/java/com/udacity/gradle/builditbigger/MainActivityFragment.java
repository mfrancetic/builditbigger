package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /* Inflate the view */
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        if (getActivity() != null) {
            /* Initialize a mobile ad */
            MobileAds.initialize(getActivity().getApplicationContext(), getString(R.string.banner_ad_id));
        }

        /* Find the adView and make it visible */
        AdView mAdView = root.findViewById(R.id.adView);
        mAdView.setVisibility(View.VISIBLE);

        /* Create and build an ad request.  */
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }
}