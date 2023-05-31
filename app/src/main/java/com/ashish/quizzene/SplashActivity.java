package com.ashish.quizzene;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    public static ArrayList<Modelclass> list;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity_main);
        list = new ArrayList<>();
        list.add(new Modelclass("In which Italian city can you find the Colosseum?","Venice","Rome", "Naples","Milan", "Rome"));
        list.add(new Modelclass("In the TV show New Girl, which actress plays Jessica Day?","Zooey Deschanel","Kaley Cuoco","Jennifer Aniston","Alyson Hannigan","Zooey Deschanel"));
        list.add(new Modelclass("Grand Central Terminal, Park Avenue, New York is the world's","largest railway station","highest railway station","longest railway station","None of the above","largest railway station"));
        list.add(new Modelclass("Entomology is the science that studies","Behavior of human beings","Insects","The origin and history of technical and scientific terms","The formation of rocks","Insects"));
        list.add(new Modelclass("Garampani sanctuary is located at","Junagarh, Gujarat","Diphu, Assam","Kohima, Nagaland","Gangtok, Sikkim","Diphu, Assam"));
        list.add(new Modelclass("For which of the following disciplines is Nobel Prize awarded?","Physics and Chemistry","Physiology or Medicine","Literature, Peace and Economics","All of the above","All of the above"));
        list.add(new Modelclass("Fastest shorthand writer was","Dr. G. D. Bist","J.R.D. Tata","J.M. Tagore","Khudada Khan","Dr. G. D. Bist"));
        list.add(new Modelclass("Epsom (England) is the place associated with","Horse racing","Polo","Shooting","Snooker","Horse racing"));
        list.add(new Modelclass("FFC stands for","Foreign Finance Corporation","Film Finance Corporation","Federation of Football Council","None of the above","Film Finance Corporation"));
        list.add(new Modelclass("Hitler party which came into power in 1933 is known as","Labour Party","Nazi Party","Ku-Klux-Klan","Democratic Party","Nazi Party"));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        }, 1500);
    }
}
