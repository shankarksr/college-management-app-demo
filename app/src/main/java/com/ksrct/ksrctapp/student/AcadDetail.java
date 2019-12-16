package com.ksrct.ksrctapp.student;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ksrct.ksrctapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AcadDetail extends Fragment {
    View v;

    public AcadDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_acad_detail, container, false);

        Button btn = v.findViewById(R.id.bacbut);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTomain();
            }
        });
        // Inflate the layout for this fragment
        return v;
    }

    private void sendTomain() {
        Fragment fragment = new AcademicFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.setCustomAnimations(R.anim.to_right,R.anim.from_right,R.anim.to_right,R.anim.from_right);
        transaction.add(R.id.acad_frame,fragment).commit();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
