package com.example.healthandfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuySupplementsActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Creatine Monohydrate Powder", "", "", "", "50"},
                    {"Clear Whey Isolate", "", "", "", "50"},
                    {"Impact Whey Isolate", "", "", "", "50"},
                    {"Impact Diet Whey", "", "", "", "50"},
                    {"Layered Protein Bar", "", "", "", "50"},
                    {"Impact Weight Gainer", "", "", "", "50"},
                    {"Ashwagandha KSM66 Capsules", "", "", "", "50"},
                    {"Protein Pancake Mix", "", "", "", "50"},
                    {"Flavdrops", "", "", "", "50"},
                    {"Alpha Pre-Workout", "", "", "", "50"},

            };


    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_supplements);

        lst = findViewById(R.id.listViewBS);
        btnBack = findViewById(R.id.buttonBSBack);
        btnGoToCart = findViewById(R.id.buttonBSGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(BuySupplementsActivity.this,CartTestActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuySupplementsActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:" + packages[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuySupplementsActivity.this, BuySupplementsDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", packages[i][4]);
                startActivity(it);

            }
        });

    }

}




