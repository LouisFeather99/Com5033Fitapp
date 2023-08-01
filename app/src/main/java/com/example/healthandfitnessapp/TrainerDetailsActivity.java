package com.example.healthandfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class TrainerDetailsActivity extends AppCompatActivity {

    private String [][] trainer_details1 =
            {
                    {"Trainer Name : James Clark", "Location : Leeds", "Exp : 4yrs", "Mobile no: 07479174889", "£30"},
                    {"Trainer Name : Ben Smith", "Location : York", "Exp : 8yrs", "Mobile no: 07449194889", "£37"},
                    {"Trainer Name : Lebron Harden", "Location : Manchester", "Exp : 2yrs", "Mobile no: 07979174580", "£25"},
                    {"Trainer Name : Ben Wallace", "Location : London", "Exp : 4yrs", "Mobile no: 07709144889", "£23"},
                    {"Trainer Name : Clark Huw", "Location : Malton", "Exp : 1yrs", "Mobile no: 07599174880", "£15"},
            };

    private String [][] trainer_details2 =
            {
                    {"Trainer Name : James Clark", "Location : Leeds", "Exp : 4yrs", "Mobile no: 07479174889", "£30"},
                    {"Trainer Name : Ben Smith", "Location : York", "Exp : 8yrs", "Mobile no: 07449194889", "£37"},
                    {"Trainer Name : Lebron Harden", "Location : Manchester", "Exp : 2yrs", "Mobile no: 07979174580", "£25"},
                    {"Trainer Name : Ben Wallace", "Location : London", "Exp : 4yrs", "Mobile no: 07709144889", "£23"},
                    {"Trainer Name : Clark Huw", "Location : Malton", "Exp : 1yrs", "Mobile no: 07599174880", "£15"},
            };

    private String [][] trainer_details3 =
            {
                    {"Trainer Name : James Clark", "Location : Leeds", "Exp : 4yrs", "Mobile no: 07479174889", "£30"},
                    {"Trainer Name : Ben Smith", "Location : York", "Exp : 8yrs", "Mobile no: 07449194889", "£37"},
                    {"Trainer Name : Lebron Harden", "Location : Manchester", "Exp : 2yrs", "Mobile no: 07979174580", "£25"},
                    {"Trainer Name : Ben Wallace", "Location : London", "Exp : 4yrs", "Mobile no: 07709144889", "£23"},
                    {"Trainer Name : Clark Huw", "Location : Malton", "Exp : 1yrs", "Mobile no: 07599174880", "£15"},
            };

    private String [][] trainer_details4 =
            {
                    {"Trainer Name : James Clark", "Location : Leeds", "Exp : 4yrs", "Mobile no: 07479174889", "£30"},
                    {"Trainer Name : Ben Smith", "Location : York", "Exp : 8yrs", "Mobile no: 07449194889", "£37"},
                    {"Trainer Name : Lebron Harden", "Location : Manchester", "Exp : 2yrs", "Mobile no: 07979174580", "£25"},
                    {"Trainer Name : Ben Wallace", "Location : London", "Exp : 4yrs", "Mobile no: 07709144889", "£23"},
                    {"Trainer Name : Clark Huw", "Location : Malton", "Exp : 1yrs", "Mobile no: 07599174880", "15"},
            };

    private String [][] trainer_details5 =
            {
                    {"Trainer Name : James Clark", "Location : Leeds", "Exp : 4yrs", "Mobile no: 07479174889", "£30"},
                    {"Trainer Name : Ben Smith", "Location : York", "Exp : 8yrs", "Mobile no: 07449194889", "£37"},
                    {"Trainer Name : Lebron Harden", "Location : Manchester", "Exp : 2yrs", "Mobile no: 07979174580", "£25"},
                    {"Trainer Name : Ben Wallace", "Location : London", "Exp : 4yrs", "Mobile no: 07709144889", "£23"},
                    {"Trainer Name : Clark Huw", "Location : Malton", "Exp : 1yrs", "Mobile no: 07599174880", "£15"},
            };


    TextView tv;
    Button btn;
    String[][] trainer_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer_details);

        tv = findViewById(R.id.textViewTDTitle);
        btn = findViewById(R.id.buttonTDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);


        if(title.compareTo("Physique Trainer")==0)
             trainer_details = trainer_details1;
        else
        if(title.compareTo("Strength Trainer")==0)
            trainer_details = trainer_details2;

        else
        if(title.compareTo("Performance Trainer")==0)
            trainer_details = trainer_details3;

        else
        if(title.compareTo("Lifestyle Coach")==0)
            trainer_details = trainer_details4;

        else
        if(title.compareTo("Fitness Trainer")==0)
            trainer_details = trainer_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrainerDetailsActivity.this,FindTrainerActivity.class));
            }
        });

        list  = new ArrayList();
        for(int i=0;i<trainer_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", trainer_details[i][0]);
            item.put("line2", trainer_details[i][1]);
            item.put("line3", trainer_details[i][2]);
            item.put("line4", trainer_details[i][3]);
            item.put("line5", "Price "+trainer_details[i][4]+"");
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listviewTD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(TrainerDetailsActivity.this,BookSessionActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",trainer_details[i][0]);
                it.putExtra("text3",trainer_details[i][1]);
                it.putExtra("text4",trainer_details[i][3]);
                it.putExtra("text5",trainer_details[i][4]);
                startActivity(it);
            }
        });

    }
}