package com.fredstrout.javafundamentals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.LinkedHashSet;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //LinkedHashSet<Editable> strDataSet = new LinkedHashSet<Editable>();
    ArrayList<String> strDataSet= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity_layout);

        Button btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(submitClicked);

        Button btnRetrieve = (Button) findViewById(R.id.btn_retrieve);
        btnRetrieve.setOnClickListener(retrieveClicked);

    }

    private View.OnClickListener submitClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText txtData = (EditText) findViewById(R.id.txt_Data);

            strDataSet.add(txtData.getText().toString());
            for (int n = 0; n < strDataSet.size(); n++) {
                Object obj = strDataSet.get(n);
                Log.i(TAG, "Data Object = " + obj);
            }
            Log.i(TAG, "Data Set: " + strDataSet);
            txtData.setText("");
        }
    };

    private View.OnClickListener retrieveClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText intIndex = (EditText) findViewById(R.id.int_Index);
            int intIndex2 = Integer.parseInt(intIndex.getText().toString());
            String retrievedData = strDataSet.get(intIndex2);

            Log.i(TAG, "Retrieved: " + retrievedData);
            intIndex.setText("");

        }

    };
}
