package com.example.shoo.gptrial2;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.sql.BatchUpdateException;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {

    public HomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent i = new Intent(getActivity(),HomeActivityFragment.class);
        getActivity().startService(i);

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
