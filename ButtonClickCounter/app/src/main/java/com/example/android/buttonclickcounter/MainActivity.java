package com.example.android.buttonclickcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //fiels that are storing references to widgets
    private EditText userInput;
    // private Button button;
    private TextView textView;
    // private int numTimesClicked = 0;
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "TextContents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("");//replaces with the new text
        userInput.setText("");
        textView.setMovementMethod(new ScrollingMovementMethod());
        View.OnClickListener ourOnclicklistener = new View.OnClickListener() {//created a new object of type OnClickListener
            @Override
            public void onClick(View v) {
                /*numTimesClicked = numTimesClicked + 1;
                String result = "The button got tapped "+numTimesClicked+ " time";
                if (numTimesClicked !=1)
                    result += "s";
                textView.append(result+"\n");*/
                String result = userInput.getText().toString();
                result = result + "\n";
                textView.append(result);
                userInput.setText("");
            }
        };
        button.setOnClickListener(ourOnclicklistener);
        Log.d(TAG, "onCreate: out");

    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
        //      String savedString = savedInstanceState.getString(TEXT_CONTENTS);
//        textView.setText(savedString);
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: in");
        super.onDestroy();
        Log.d(TAG, "onDestroy: out");
    }
}
