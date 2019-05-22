package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentSingle extends Fragment{
    public FragmentSingle() {
    }
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view=inflater.inflate(R.layout.single_fragment,container,false);


        Button button = (Button) view.findViewById(R.id.button_quiz);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startQuiz();
            }
        });
        return view;
    }

    private void startQuiz() {
        Intent intent = new Intent(getActivity(), com.example.myapplication.QuizActivity.class);
        startActivity(intent);
    }
}
