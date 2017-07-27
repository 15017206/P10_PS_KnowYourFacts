package com.example.a15017206.p10psknowyourfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {

    String TAG = "Frag 1";

    Button btnChangeColor;
    LinearLayout ll2;
    EditText etFact1;

    public Frag2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag2, container, false);
        btnChangeColor = (Button) view.findViewById(R.id.btnChangeColor2);
        ll2 = (LinearLayout) view.findViewById(R.id.ll2);
        etFact1 = (EditText) view.findViewById(R.id.etFact2);

        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                ll2.setBackgroundColor(color);
                etFact1.setBackgroundColor(color);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }
}
