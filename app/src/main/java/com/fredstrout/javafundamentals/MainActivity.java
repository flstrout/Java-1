package com.fredstrout.javafundamentals;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;


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
            int dataSetSize = strDataSet.size();

            if (dataSetSize == 0) {

                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                builder2.setTitle("Houston, We Have A Problem!");
                builder2.setMessage("The dataset is empty! Please input data and retry.");
                builder2.setCancelable(true);
                builder2.setPositiveButton("OK", null);

                AlertDialog alertDialog2 = builder2.create();
                alertDialog2.show();
                intIndex.setText("");

            }else if (dataSetSize > intIndex2) {

                String retrievedData = strDataSet.get(intIndex2);

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("The value for index " + intIndex2 + " is:");
                builder1.setMessage(retrievedData);
                builder1.setCancelable(true);
                builder1.setPositiveButton("OK", null);

                AlertDialog alertDialog1 = builder1.create();
                alertDialog1.show();

                Log.i(TAG, "Retrieved: " + retrievedData);
                intIndex.setText("");

            } else {

                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                builder2.setTitle("Houston, We Have A Problem!");
                builder2.setMessage("The index you entered exceeds the number of records in the dataset. Please enter a number between 0 and " + (dataSetSize - 1) + ".");
                builder2.setCancelable(true);
                builder2.setPositiveButton("OK", null);

                AlertDialog alertDialog2 = builder2.create();
                alertDialog2.show();
                intIndex.setText("");

            }

        }

    };
}
