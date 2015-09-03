package com.fredstrout.javafundamentals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

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
            Log.i(TAG, "Data Submited: " + txtData.getText());
            txtData.setText("");
        }
    };

    private View.OnClickListener retrieveClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText intIndex = (EditText) findViewById(R.id.int_Index);
            Log.i(TAG, "Index Retrieved: " + intIndex.getText());
            intIndex.setText("");
        }
    };
}
