package com.ksrct.ksrctapp.student;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ksrct.ksrctapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AcademicFragment extends Fragment {

    private CardView acadDetail;
    View v;


    public AcademicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_academic, container, false);

        acadDetail = v.findViewById(R.id.acad_detai);
        acadDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAcadDetail();
            }
        });
        // Inflate the layout for this fragment
        return v;
    }

    public void openAcadDetail(){
        Fragment fragment = new AcadDetail();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.setCustomAnimations(R.anim.from_right,R.anim.to_right,R.anim.from_right,R.anim.to_right);
        transaction.add(R.id.acad_frame,fragment).commit();

    }

}
