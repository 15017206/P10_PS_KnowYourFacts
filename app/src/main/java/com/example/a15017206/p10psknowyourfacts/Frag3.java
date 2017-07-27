package com.example.a15017206.p10psknowyourfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag3 extends Fragment {

    String TAG = "Frag 1";

    Button btnChangeColor;
    LinearLayout ll3;
    EditText etFact1;
    ImageView iv;

    public Frag3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag3, container, false);
        btnChangeColor = (Button) view.findViewById(R.id.btnChangeColor3);
        ll3 = (LinearLayout) view.findViewById(R.id.ll3);
        etFact1 = (EditText) view.findViewById(R.id.etFact3);
        iv = (ImageView) view.findViewById(R.id.iv);

        String imageUrl = "http://68.media.tumblr.com/6961bf4827c1626518e156cd8df6fe62/tumblr_otq1x9z3EK1roqv59o1_500.png";
        Picasso.with(getContext()).load(imageUrl).into(iv);


        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                ll3.setBackgroundColor(color);
                etFact1.setBackgroundColor(color);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
