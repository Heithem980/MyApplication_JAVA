package com.example.myapplication_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView xtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xtext = (TextView) findViewById(R.id.Hello);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);




        Log.d("TAG","onCreate: Hello World");
        //helloThere.setText("Hello World for real");

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("btn1","onClick: Button Click");
                //helloThere.setText("Hey there?");

            }

        });




    }
    private int tal;
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {


        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            int leftRight = (int) sensorEvent.values[0];
            int upDown = (int) sensorEvent.values[1];

            if ( leftRight > 4 || leftRight < -4){

                xtext.setText("you moved left or right");

            }
            else if ( upDown > 10 || upDown < 8){

                xtext.setText( " you moved up or down   ");

            }

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}