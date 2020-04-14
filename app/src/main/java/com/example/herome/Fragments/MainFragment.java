package com.example.herome.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.herome.Activities.MainActivity;
import com.example.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button accidentButton;
    private Button geneticButton;
    private Button bornButton;
    private Button chooseButton;


    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        accidentButton = view.findViewById(R.id.accidentButton);
        geneticButton = view.findViewById(R.id.genericButton);
        bornButton = view.findViewById(R.id.bornButton);
        chooseButton = view .findViewById(R.id.chooseButton);

        accidentButton.setOnClickListener(this);
        geneticButton.setOnClickListener((this));
        bornButton.setOnClickListener(this);

        chooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadPickPowerScreen();

            }
        });


        chooseButton.setEnabled(false);
        chooseButton.getBackground().setAlpha(128);

        return view;
    }

    @Override
    public void onClick(View v) {
            chooseButton.setEnabled(true);
            chooseButton.getBackground().setAlpha(255);

            accidentButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,0,0);
            geneticButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic,0,0,0);
            bornButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket,0,0,0);


            Button button = (Button)v;
            int leftDrawable = 0;

            if(button == accidentButton){
                leftDrawable = R.drawable.lightning;
            }else if(button == geneticButton){
                leftDrawable = R.drawable.atomic;
            }else if (button == bornButton){
                leftDrawable = R.drawable.rocket;
            }
            button.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0,R.drawable.item_selected, 0);

    }





}
