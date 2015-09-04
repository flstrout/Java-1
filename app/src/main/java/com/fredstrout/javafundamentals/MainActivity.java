package com.fredstrout.javafundamentals;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
//    LinkedHashSet<Editable> strDataSet = new LinkedHashSet<Editable>();
//    I had a really rough time trying to get the HashSet working. Even when I was entering
//    the data into a hashset it was still allowing duplicate entries. Due to time slipping
//    away, I decided to use an ArrayList which finally allowed me to retrieve some data.

//    This is my Collection
    ArrayList<String> strDataSet= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity_layout);

//        Create OnClickListeners for each of my buttons
        Button btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(submitClicked);

        Button btnRetrieve = (Button) findViewById(R.id.btn_retrieve);
        btnRetrieve.setOnClickListener(retrieveClicked);

    }

//    Action-OnClickListener-Submit Data Button
    private View.OnClickListener submitClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

//            Get the data entered in the txt_Data EditText field
            EditText txtData = (EditText) findViewById(R.id.txt_Data);

//            Make sure there is data to get - prevents null entries
            if (txtData.length() == 0) // If no data -> display AlertDialog
            {

//                Build an AlertDialog to inform the user that there was a problem
                AlertDialog.Builder builder4 = new AlertDialog.Builder(MainActivity.this);
                builder4.setTitle("No Null Values!");
                builder4.setMessage("Please input text to store in the data collection.");
                builder4.setCancelable(true);
                builder4.setPositiveButton("OK", null);

//                Display the AlertDialog
                AlertDialog alertDialog4 = builder4.create();
                alertDialog4.show();

            } else {

//                 Add the retrieved data to the collection
                strDataSet.add(txtData.getText().toString());

//                 Temporary testing code - normally removed, left fyi
//                 for (int n = 0; n < strDataSet.size(); n++) {
//                     Object obj = strDataSet.get(n);
//                     Log.i(TAG, "Data Object = " + obj);
//                 }
//                 Log.i(TAG, "Data Set: " + strDataSet);

//                 Clear the contents of the txt_Data EditText field
                txtData.setText("");
            }
        }
    };

//    Action-OnClickListener-Retrieve Data Button
    private View.OnClickListener retrieveClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

//            Get the data entered in the int_Index EditText field
            EditText intIndex = (EditText) findViewById(R.id.int_Index);

//            Make sure there is data to get - prevents app crash!!!
            if (intIndex.length() == 0) // If no data -> display AlertDialog
            {

//                Build an AlertDialog to inform the user that there was a problem
                AlertDialog.Builder builder3 = new AlertDialog.Builder(MainActivity.this);
                builder3.setTitle("No Null Values!");
                builder3.setMessage("Please input an index number to retrieve a record.");
                builder3.setCancelable(true);
                builder3.setPositiveButton("OK", null);

//                Display the AlertDialog
                AlertDialog alertDialog3 = builder3.create();
                alertDialog3.show();

            } else { // If data -> proceed with other checks

//                Parse the absolute string value of intIndex into an Integer
                int intIndex2 = Integer.parseInt(intIndex.getText().toString());

//                Set an Integer Variable for the number of records in the collection
                int dataSetSize = strDataSet.size();

//                Perform some checks to make sure a record is available in the collection
                if (dataSetSize == 0) { // Make sure the collection has at least one record

//                    Build an AlertDialog to inform the user that there was a problem
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                    builder2.setTitle("No Data In Collection!");
                    builder2.setMessage("The dataset is empty! Please input data and retry.");
                    builder2.setCancelable(true);
                    builder2.setPositiveButton("OK", null);

//                    Display the AlertDialog
                    AlertDialog alertDialog2 = builder2.create();
                    alertDialog2.show();

//                    Clear the contents of the int_Index EditText field
                    intIndex.setText("");

                }else if (dataSetSize > intIndex2) { // Passes dataSetSize Comparison -> execute

//                    Get the record that matches the entered index number
                    String retrievedData = strDataSet.get(intIndex2);

//                    Build an AlertDialog to display the retrieved data
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setTitle("The record for index " + intIndex2 + " is:");
                    builder1.setMessage(retrievedData);
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("OK", null);

//                    Display the AlertDialog
                    AlertDialog alertDialog1 = builder1.create();
                    alertDialog1.show();

//                    Temporary testing code - normally removed, left fyi
//                    Log.i(TAG, "Retrieved: " + retrievedData);

//                    Clear the contents of the int_Index EditText field
                    intIndex.setText("");

                } else { // Entry does not pass previous check

//                    Build an AlertDialog to inform the user that there was a problem
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                    builder2.setTitle("Entered Value Out Of Range!");
                    builder2.setMessage("The index you entered exceeds the number of records in the dataset. Please enter a number between 0 and " + (dataSetSize - 1) + ".");
                    builder2.setCancelable(true);
                    builder2.setPositiveButton("OK", null);

//                    Display the AlertDialog
                    AlertDialog alertDialog2 = builder2.create();
                    alertDialog2.show();

//                    Clear the contents of the int_Index EditText field
                    intIndex.setText("");

                }
            }
        }

    };
}
