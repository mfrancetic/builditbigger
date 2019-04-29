package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.udacity.joketellinglibrary.JokeTellingClass;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        MobileAds.initialize(getActivity().getApplicationContext(), getString(R.string.banner_ad_id));

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        mAdView.setVisibility(View.VISIBLE);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."

//        String deviceIdEmulator = "B3EEABB8EE11C2BE770B684D95219ECB";
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .addTestDevice(deviceIdEmulator)

                .build();
        mAdView.loadAd(adRequest);

//        InterstitialAd interstitialAd = new InterstitialAd(getActivity());
//
//        interstitialAd.setAdUnitId(getString(R.string.banner_ad_id));
//


        return root;
    }

}