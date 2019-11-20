 package com.irving.funfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


 public class MainActivity extends AppCompatActivity {
     private static final String KEY_FACT = "KEY_FACT";
     private static final String KEY_COLOR = "KEY_COLOR";

     private FactBook factBook = new FactBook();
     private ColorWheel colorWheel = new ColorWheel();
    // declare our view variable
     private TextView factTextView;
     private Button showFactButton;
     private RelativeLayout relativeLayout;
     private String mFact;
     private int mColor;

     @Override
     protected void onSaveInstanceState(Bundle outState) {
         super.onSaveInstanceState(outState);

         outState.putString(KEY_FACT, mFact);
         outState.putInt(KEY_COLOR, mColor);
     }

     @Override
     protected void onRestoreInstanceState(Bundle savedInstanceState) {
         super.onRestoreInstanceState(savedInstanceState);

         mFact = savedInstanceState.getString(KEY_FACT);
         factTextView.setText(mFact);

         mColor = savedInstanceState.getInt(KEY_COLOR);
         relativeLayout.setBackgroundColor(mColor);
         showFactButton.setTextColor(mColor);
     }

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        factTextView = (TextView) findViewById(R.id.factTextView);
        showFactButton = (Button) findViewById(R.id.showFactButton);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFact = factBook.getFact();
                factTextView.setText(mFact);

                mColor = colorWheel.getColor();
                relativeLayout.setBackgroundColor(mColor);
                showFactButton.setTextColor(mColor);
            }
        };

        showFactButton.setOnClickListener(listener);

        Toast.makeText(this, "Yay! our activity was created", Toast.LENGTH_SHORT).show();
    }
}
