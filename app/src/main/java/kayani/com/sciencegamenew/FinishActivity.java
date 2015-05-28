package kayani.com.sciencegamenew;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class FinishActivity extends ActionBarActivity implements View.OnClickListener {

    private Button btn_retry;
    private Button btn_main_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("int_score",0);

        TextView str_score = (TextView)findViewById(R.id.textView4);
        str_score.setText("You answered: "+intValue+" correctly, out of 10.");

        btn_retry = (Button) findViewById(R.id.button);
        btn_retry.setOnClickListener(this);

        btn_main_menu = (Button) findViewById(R.id.button2);
        btn_main_menu.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_finish, menu);
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
            case R.id.button:
                btn_retry_clicked();
                break;
            case R.id.button2:
                btn_main_menu_clicked();
                break;
            default:
                break;
        }
    }

    private void btn_main_menu_clicked() {
        finishActivity(MainActivity.CONTEXT_INCLUDE_CODE);
        startActivity(new Intent(getBaseContext(),MainActivity.class));
    }

    private void btn_retry_clicked() {

        finishActivity(QuizActivity.CONTEXT_INCLUDE_CODE);
        startActivity(new Intent(getBaseContext(), QuizActivity.class));

    }
}
