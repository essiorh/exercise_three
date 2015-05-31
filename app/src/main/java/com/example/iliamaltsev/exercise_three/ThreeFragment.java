package com.example.iliamaltsev.exercise_three;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ThreeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private ImageView imageViewOne;
    private ImageView imageViewTwo;
    private LinearLayout linearLayout;
    private TextView tvTime;
    volatile int i;



    public static ThreeFragment newInstance(String param1, String param2) {
        ThreeFragment fragment = new ThreeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ThreeFragment() {
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
        LinearLayout inflateView = (LinearLayout) inflater.inflate(R.layout.fragment_three, container, false);
        linearLayout = (LinearLayout) inflateView.findViewById(R.id.fon);
        imageViewOne = (ImageView) inflateView.findViewById(R.id.our_image_one);
        imageViewTwo = (ImageView) inflateView.findViewById(R.id.our_image_two);
        ImageView.ScaleType imgScaleType = ImageView.ScaleType.valueOf(mParam2);
        imageViewOne.setScaleType(imgScaleType);
        tvTime = (TextView) inflateView.findViewById(R.id.timer);
        Timer myTimer = new Timer();
        final Handler uiHandler = new Handler();
        i = 0;
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                final String result = Integer.toString(i++);

                uiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        switch (i%2){
                            case 0:
                                imageViewOne.setImageResource(R.drawable.two);
                                imageViewTwo.setImageResource(R.drawable.three);
                                break;
                            case 1:
                                imageViewOne.setImageResource(R.drawable.three);
                                imageViewTwo.setImageResource(R.drawable.two);
                                break;

                        }
                        tvTime.setText(result);
                    }
                });
            }
        }, 0L, 1L * 1000);
        return inflateView;
    }
}