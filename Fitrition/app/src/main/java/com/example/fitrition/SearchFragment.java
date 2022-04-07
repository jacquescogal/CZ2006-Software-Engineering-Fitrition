package com.example.fitrition;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitrition.adapter.StatusAdapter;
import com.example.fitrition.boundary.StatusHistoryFragment;
import com.example.fitrition.entities.Status;
import com.example.fitrition.utils.SpacingItemDecoration;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    RecyclerView recyclerView;
    StatusAdapter statusAdapter;
    ArrayList<Status> statusList=new ArrayList<Status>();


    SwipeRefreshLayout swipeRefreshLayout;

    public static final String[] statusTest= {
            "Alex",
            "Daniel",
            "Yoyo",
            "Exceline",
            "Daniel2",
            "Adam",
            "Z2",
            "Z3"
    };
    //public static final int[] TvShowImgs = {R.drawable.breaking_bad_logo,R.drawable.rick_and_morty_logoo,R.drawable.friends,R.drawable.sherlock,R.drawable.stranger_things};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);



        for (int i = 0; i < statusTest.length; i++) //set a limit to the number of status shown
        {
            Status status = new Status();

            status.setDescription(statusTest[i]);

            statusList.add(status);

            if (statusList.size() > 20) {
                statusList.remove(statusList.size() - 1);
            }
        }


        statusAdapter = new StatusAdapter(statusList);

        recyclerView = (RecyclerView) view.findViewById(R.id.listview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        SpacingItemDecoration itemDecoration = new SpacingItemDecoration(10);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(statusAdapter);

        return view;
    }
}