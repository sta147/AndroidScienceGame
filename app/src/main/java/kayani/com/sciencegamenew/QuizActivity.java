package kayani.com.sciencegamenew;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class QuizActivity extends ActionBarActivity {

    private TextView question;
    private RadioGroup rg;
    private RadioButton rg_answer_1;
    private RadioButton rg_answer_2;
    private RadioButton rg_answer_3;
    private RadioButton rg_answer_4;
    private Button btn_Next;


    private String questions[] = {"The centre of our solar system is ...",
                                "What is our solar system a part of?",
                                "How many planets are there in our solar system?",
                                "The time it takes the Earth to orbit the Sun is ...",
                                "We can sometimes see some of the planets because ...",
                                "How many stars are there in our galaxy?",
                                "Which is the largest planet in our solar system?",
                                "Which was the first planet known to have rings?",
                                " A satellite is ...",
                                "Which one do artificial satellites NOT do?"};
    private String answers[] = {"the Sun", "Milky Way", "8", "a year", "they reflect light from the Sun", "Billions", "Jupiter", "Saturn", "a small object in orbit round a larger object", "Remain stationary"};
    private String options[] = {"Mars", "the Earth", "the Moon", "the Sun",
                                "Constellation", "Orion", "Mars", "Milky Way",
                                "7", "9", "10", "8",
                                "28 Days", "a month", "a year", "10 Years",
                                "they are a source of light", "they are luminous", "they reflect light from the Moon", "they reflect light from the Sun",
                                "Hundreds", "Millions", "Thousands", "Billions",
                                "Earth", "Jupiter", "Saturn", "Uranus",
                                "Jupiter", "Pluto", "Saturn", "Uranus",
                                "a large object in orbit round a smaller object", "a large object in space", "a small object in orbit round a larger object", "a small object in space",
                                "Collect information", "Remain stationary", "Send TV broadcasts", "Take photographs"};
    private int questionNumber, answerNumber, optionNumber = 0;

//    private enum Questions {
//        Q1 ("The centre of our solar system is ..."),
//        Q2 ("What is our solar system a part of?"),
//        Q3 ("How many planets are there in our solar system?"),
//        Q4 ("The time it takes the Earth to orbit the Sun is ..."),
//        Q5 ("We can sometimes see some of the planets because ...."),
//        Q6 ("How many stars are there in our galaxy?"),
//        Q7 ("Which is the largest planet in our solar system?"),
//        Q8 ("Which was the first planet known to have rings?"),
//        Q9 ("A satellite is ..."),
//        Q10 ("Which one do artificial satellites NOT do?");
//
//        private final String name;
//        private Questions(String s) {
//            name = s;
//        }
//        Questions(){
//            name=null;
//        }
//        @Override
//        public String toString(){
//            return name;
//        }
//        public static boolean contains(String s)
//        {
//            for(Questions choice:values())
//                if (choice.name().equals(s))
//                    return true;
//            return false;
//        }
//    }
//
//    private enum Answer{
//
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question = (TextView)findViewById(R.id.question);
        rg = (RadioGroup)findViewById(R.id.answer_group);
        rg_answer_1 = (RadioButton) findViewById(R.id.btn_option1);
        rg_answer_2 = (RadioButton) findViewById(R.id.btn_option2);
        rg_answer_3 = (RadioButton) findViewById(R.id.btn_option3);
        rg_answer_4 = (RadioButton) findViewById(R.id.btn_option4);
        btn_Next = (Button) findViewById(R.id.answer);

        System.out.println(answers.length);

        question.setText(questions[0]);
        rg_answer_1.setText(options[0]);
        rg_answer_2.setText(options[1]);
        rg_answer_3.setText(options[2]);
        rg_answer_4.setText(options[3]);
        optionNumber = 4;

        final AlertDialog alertOnNext = new AlertDialog.Builder(QuizActivity.this).create();
        alertOnNext.setTitle("Alert");
        alertOnNext.setMessage("Well Done!");
        alertOnNext.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });



        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(answerNumber<9) {
                    RadioButton checked_button = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                    String ansText = checked_button.getText().toString();


                    if (ansText.equals(answers[answerNumber])) {
                        rg.clearCheck();
                        questionNumber++;
                        answerNumber++;

                        question.setText(questions[questionNumber]);

                        rg_answer_1.setText(options[optionNumber]);
                        optionNumber++;
                        rg_answer_2.setText(options[optionNumber]);
                        optionNumber++;
                        rg_answer_3.setText(options[optionNumber]);
                        optionNumber++;
                        rg_answer_4.setText(options[optionNumber]);
                        optionNumber++;


                    }
                }
                else{
//                    alertOnNext.show();
                    startActivity(new Intent(getBaseContext(), FinishActivity.class));
                }

            }
        });

    }

    public void clearQuestion(){

    }

    public void addQuestion(){

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
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
}
