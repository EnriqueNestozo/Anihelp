package com.nestozo.enriq.anihelp.presentation.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nestozo.enriq.anihelp.R;
import com.nestozo.enriq.anihelp.common.model.Animal;
import com.nestozo.enriq.anihelp.ExtraviadosContract;
import com.nestozo.enriq.anihelp.presentation.adapters.ExtraviadosAdapter;
import com.nestozo.enriq.anihelp.presentation.adapters.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExtraviadosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExtraviadosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExtraviadosFragment extends Fragment implements OnItemClickListener{

    @BindView(R.id.addButton)
    FloatingActionButton addButton;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private ExtraviadosAdapter adapter;
    private List<Animal> animals;


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ExtraviadosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExtraviadosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExtraviadosFragment newInstance(String param1, String param2) {
        ExtraviadosFragment fragment = new ExtraviadosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_extraviados, container, false);
        ButterKnife.bind(this, view);
        initRecyclerView();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        animals = new ArrayList<>();
        adapter = new ExtraviadosAdapter(animals, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int animalPosition) {
        //Intent intent = new Intent(this,someClass.class);
        //intent.putExtra("Animal",animals.get(animalPosition));
        //startActivity(intent);
        Log.d("Click", animals.get(animalPosition).getName());
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
