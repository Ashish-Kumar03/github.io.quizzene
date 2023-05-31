package com.ashish.quizzene;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.cardview.widget.CardView;
import androidx.collection.CircularArray;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerValue=20;
    ProgressBar progressBar;
    List<Modelclass> allQuestionsList;
    Modelclass modelclass;
    int index=0;
    TextView card_question,option_a,option_b,option_c,option_d;
    CardView cardOA,cardOB,cardOC,cardOD;
    int correctCount=0;
    int wrongCount=0;
    LinearLayout next_btn_shape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Hooks();
        List<Modelclass> list = null;
        allQuestionsList = list;
        Collections.shuffle(allQuestionsList);
        modelclass = list.get(index);
        setAllData();

        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                timerValue = timerValue-1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(DashboardActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);
                dialog.findViewById(R.id.btn_tryagain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        }.start();
    }

    private void setAllData() {
        card_question.setText(modelclass.getQuestion());
        option_a.setText(modelclass.getoA());
        option_b.setText(modelclass.getoB());
        option_c.setText(modelclass.getoC());
        option_d.setText(modelclass.getoD());
    }

    private void Hooks() {
        progressBar = findViewById(R.id.timer);
        card_question = findViewById(R.id.card_question);
        option_a = findViewById(R.id.card_option_a);
        option_b = findViewById(R.id.card_option_b);
        option_c = findViewById(R.id.card_option_c);
        option_d = findViewById(R.id.card_option_d);

        cardOA = findViewById(R.id.option_a);
        cardOB = findViewById(R.id.option_b);
        cardOC = findViewById(R.id.option_c);
        cardOD = findViewById(R.id.option_d);

        next_btn_shape = findViewById(R.id.next);

    }
    public void Correct(){
        next_btn_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCount++;
                CircularArray<Object> list = null;
                modelclass= (Modelclass) list.get(index);
                setAllData();
            }
        });

    }
    @SuppressLint("RestrictedApi")
    public void Wrong(){
        wrongCount++;

        CircularArray<Object> list = null;
        if(index<list.size()-1){
            index++;
            modelclass= (Modelclass) list.get(index);
            setAllData();
        }else{
            GameWon();
        }
    }

    private void GameWon() {
        Intent intent = new Intent(DashboardActivity.this, WonActivity.class);
        startActivity(intent);
    }
}