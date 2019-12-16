package com.ksrct.ksrctapp.student;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ksrct.ksrctapp.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CircularFragment extends Fragment {
    private RecyclerView recyclerView;
    View v;
    private List<Circular> circularList;
    private Adaptor mAdaptor;


    public CircularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_circular, container, false);


        recyclerView = v.findViewById(R.id.recview);
        mAdaptor = new Adaptor(getContext(),circularList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdaptor);

        // Inflate the layout for this fragment
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        circularList = new ArrayList<>();
        circularList.add(new Circular("test","lll","test"));
        circularList.add(new Circular("test1","lll","test1"));
    }

}
