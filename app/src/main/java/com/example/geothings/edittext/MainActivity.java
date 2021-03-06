package com.example.geothings.edittext;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        districtSpinner = (Spinner) findViewById(R.id.districtSpinner);
        countySpinner = (Spinner)findViewById(R.id.countySpinner);

        districtSpinner();

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.recyclerView);
        ContactsAdapter adapter = new ContactsAdapter(this, Contact.getListName());
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        rvContacts.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {
                view.findViewById(R.id.tv_name).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "111", Toast.LENGTH_SHORT).show();
                    }
                });
                view.findViewById(R.id.iv_image).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "222", Toast.LENGTH_SHORT).show();
                    }
                });


            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {


            }
        });

//        ItemClickSupport.addTo(rvContacts).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
//            @Override
//            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                // do it
//
//            }
//        });
    }

    private void zzz() {
        String[] a = {"aaa", "bbb", "ccc"};
        List<String> aa = new ArrayList<>();
//        aa.add("aaa");
//        aa.add("bbb");
//        aa.add("ccc");
//        LogUntil.logString(aa.toString());

//        for (String i :a){
//            StringBuffer a1 = new StringBuffer();
//
//
//        }
//        String result = Arrays.toString(a);
//        String[] result2 = result.split("\\[|\\]");
//        String result3 = result2[1];
//        String output = result3.replaceAll("\\s+","");
//        LogUntil.logString(output);
//        String z1 = aa.toString();
        String z1 = "sf";
        String[] z2 = z1.split(",");
//        String[] z2 = z1.split("\\[|\\]");
//        String output = z2[1].replaceAll("\\s+", "");
//        LogUntil.logString(output);
        LogUntil.logString(z2.length + "---");

    }

    public void test1(View view) {
        Intent intent = new Intent(this, Tabs.class);
        startActivity(intent);
    }


    public Spinner districtSpinner, countySpinner;
    public int selectedDistrict;

    public void districtSpinner() {

        ArrayAdapter<String> Dadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.districtNames));
        Dadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        districtSpinner.setAdapter(Dadapter);

        districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                                          int selectedDistrict = position + 1;
                                                          // do yourself a favor and intoduce an empty choice for 7;


                                                          countySpinner(selectedDistrict);
                                                      }

                                                      public void onNothingSelected(AdapterView<?> parent) {
                                                      }
                                                  }
        );
    }

    private int getDistrictResourceId(int districtnr) {
        int resId = R.array.district1;
        switch (districtnr) {
            case 1:
                resId = R.array.district1;
                break;
            case 2:
                resId = R.array.district2;
                break;
            case 3:
                resId = R.array.district3;
                break;
            case 4:
                resId = R.array.district4;
                break;
            case 5:
                resId = R.array.district5;
                break;

            // please add the rest
        }

        return resId;
    }

    public void countySpinner(int districtnr) {


        int resId = getDistrictResourceId(districtnr);

        ArrayAdapter<String> Cadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(resId));
        Cadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

                countySpinner.setAdapter(Cadapter);
                countySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                            }

                                                            public void onNothingSelected(AdapterView<?> parent) {
                                                            }
                                                        }
                );



    }

    public void expendListView(View view){
        Intent i = new Intent(this,ExpendListView.class);
        startActivity(i);
    }
}

