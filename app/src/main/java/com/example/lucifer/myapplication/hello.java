package com.example.lucifer.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.view.Menu;
import android.os.Bundle;
import android.view.Menu;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class hello extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
 Button b;
    Spinner spin;
    AutoCompleteTextView actv;
    String[] language ={"C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP"};
    String item;
    RadioGroup rg1;
    RadioButton rb1;
    ImageButton ib1;
    TextView dob;
    CheckBox cb1;
    EditText ed1,ed2,ed3,ed4,ed5;
    int yr, month, day;
    static final int Dialogid = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        // Toast.makeText(getApplicationContext(),"onCreate called", Toast.LENGTH_LONG).show();
        spin = (Spinner) findViewById(R.id.spin);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, language);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        addListenerRadioButton();
        ib1 = (ImageButton) findViewById(R.id.ib1);
        dob = (TextView) findViewById(R.id.dob);
        showDialogButtonClick();
    }
    public void showDialogButtonClick() {
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(Dialogid);
            }
        });

        }
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == Dialogid)
            return new DatePickerDialog(this, dpickerListener, yr, month, day);
        return null;
    }
    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            yr=i;
            month=i1+1;
            day=i2;
            StringBuilder date = new StringBuilder(day+"/"+month+"/"+yr);
            dob.setText(date);
            //Toast.makeText(hello.this, day+"/"+month+"/"+yr,Toast.LENGTH_LONG).show();

        }
    };



    private void addListenerRadioButton() {
        rg1 = (RadioGroup) findViewById(R.id.rg1);
        b = (Button) findViewById(R.id.button1);

        cb1 = (CheckBox) findViewById(R.id.cb1);

       // else
        //{b.setEnabled(false);}
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        ed4 = (EditText) findViewById(R.id.ed4);
        ed5 = (EditText) findViewById(R.id.ed5);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = rg1.getCheckedRadioButtonId();
                rb1 = (RadioButton) findViewById(selected);
                String ans1 = ed1.getText().toString();
                String ans2 = ed2.getText().toString();
                String ans3 = ed3.getText().toString();
                String ans4 = ed4.getText().toString();
                String ans5 = ed5.getText().toString();
                String ans6 = rb1.getText().toString();
                String ans7 = item;
                String ans8 = dob.getText().toString();

                Intent i = new Intent(getApplicationContext(), second.class);//(hello.this,second.class);
                i.putExtra("Value1", ans1);
                i.putExtra("Value2", ans2);
                i.putExtra("Value3", ans3);
                i.putExtra("Value4", ans4);
                i.putExtra("Value5", ans5);
                i.putExtra("Value6", ans6);
                i.putExtra("Value7", ans7);
                i.putExtra("Value8", ans8);
                startActivity(i);
                // Toast.makeText(getApplicationContext(),ed1.getText(),Toast.LENGTH_LONG).show();

                //Toast.makeText(getApplicationContext(),"DATA ENTERED",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         item = adapterView.getItemAtPosition(i).toString();
       // String ans7 = item;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
