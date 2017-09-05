package com.example.lucifer.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class second extends Activity {
Button button2;
    RatingBar rat;
TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        //Intent i =getIntent();
        String v1 = extras.getString("Value1");
        String v2 = extras.getString("Value2");
        String v3 = extras.getString("Value3");
        String v4 = extras.getString("Value4");
        String v5 = extras.getString("Value5");
        String v6 = extras.getString("Value6");
        String v7 = extras.getString("Value7");
        String v8 = extras.getString("Value8");
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        tv4=(TextView)findViewById(R.id.tv4);
        tv5=(TextView)findViewById(R.id.tv5);
        tv6=(TextView)findViewById(R.id.tv6);
        tv7=(TextView)findViewById(R.id.tv7);
        tv8=(TextView)findViewById(R.id.tv8);
        rat=(RatingBar)findViewById(R.id.ratingBar1);

        Toast.makeText(getApplicationContext(),"Values are:\n First value: "+v1+ "\n Second value: "+v2+"\n Third value: "+v3+"\n Fourth value: "+v4+
                "\n Fifth Value: "+v5+"\n Sixth M/F value: "+v6+"\n Seventh value: "+v7+"\n Eighth value: "+v8,Toast.LENGTH_LONG).show();
        tv1.setText(v1);
        tv2.setText(v2);
        tv3.setText(v3);
        tv4.setText(v4);
        tv5.setText(v5);
        tv6.setText(v6);
        tv7.setText(v7);
        tv8.setText(v8);

        addListenerOnButton();
    }

    private void addListenerOnButton() {
        button2= (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),hello.class);
                startActivity(i);
                String rating=String.valueOf(rat.getRating());
                Toast.makeText(getApplicationContext(),"User has given " +rating+" stars for this page", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(),"Welcome to Registration Page",Toast.LENGTH_LONG).show();

            }
        });
/*
              <Button
          android:layout_width="fill_parent"
          android:layout_height="0sp"
          android:layout_weight="1"
          android:layout_centerVertical="true"
          android:layout_alignParentBottom="true"
          android:layout_centerHorizontal="true"
          android:id="@+id/button2"
          android:text="First Actiity"/>

        */
    }
}
