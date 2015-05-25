package kayani.com.sciencegamenew;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, SensorEventListener {

    Button btn_play;
    Button btn_help;
    Button btn_score;
    public  float sensor_x_val;
    public  float sensor_y_val;
    boolean gameRunning = false;

    SensorManager sensorManager;
    Sensor accelerometer;

    GamePanel gamePanel;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_play = (Button) findViewById(R.id.btn_play);
        btn_play.setOnClickListener(this );

        btn_help = (Button) findViewById(R.id.btn_help);
        btn_help.setOnClickListener(this);


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play:
                btn_play_clicked();
                break;
            case R.id.btn_help:
                btn_help_clicked();
                break;
            case R.id.btn_scores:
                btn_scores_clicked();
                break;
        }

    }

    private void btn_play_clicked(){
//        startActivity(new Intent(getBaseContext(),PlayActivity.class));
            startActivity(new Intent(getBaseContext(), QuizActivity.class));
    }
    private void btn_help_clicked(){


        gamePanel = new GamePanel(this);
        setContentView(gamePanel);
        gameRunning = true;

    }

    private void btn_scores_clicked(){

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            sensor_x_val = event.values[0];


            if (gameRunning)
            {
                gamePanel.updateXValue(sensor_x_val);

            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }



}
