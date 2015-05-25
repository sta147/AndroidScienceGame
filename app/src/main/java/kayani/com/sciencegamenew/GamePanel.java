package kayani.com.sciencegamenew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import static android.view.MotionEvent.ACTION_DOWN;

/**
 * Created by kayani on 21/05/2015.
 */
public class GamePanel extends View implements Runnable, View.OnTouchListener {

//    private MainThread thread;
//    private Background bg;
//    private final static int INTERVAL = 15;

    private final static int INTERVAL = 15; // speed of the falling
    private boolean running = true;
    private Paint paint;
    private Paint finalResult;
    Thread myThread;
    private int score = 0;
    private long time = 1000;
    Context context;
    private boolean hasStarted;
    private Bitmap bm_myBitmap;
    private Bitmap bm_player;
    private Bitmap bm_bullet;
    float panel_x;
    float panel_y;
    private boolean finished = false;
    private Canvas canvas;
    private boolean firing = false;

    float x=0, y=0, dx=5, dy=5;

    public GamePanel(Context context) {
        super(context);

        this.context = context;
        paint = new Paint();

        myThread = new Thread(this);
        myThread.start();
    }

    public void start()
    {

//        planets = new PlanetClass[getHeight()/50];
//        for (int i = 0; i < planets.length; i++)
//        {
//            int y = i*-50;
//            int x = (int) (Math.random()*(getWidth()-25));
//            planets[i] = new PlanetClass(x, y, getResources());
//        }

        bm_myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.space_bg);
        bm_myBitmap = Bitmap.createScaledBitmap(bm_myBitmap, getWidth(), getHeight(), true);

        bm_player = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        bm_player = Bitmap.createScaledBitmap(bm_player, 100, 100, true);

//        bm_bullet = BitmapFactory.decodeResource(getResources(), R.drawable.sci_logo);
//        bm_bullet = Bitmap.createScaledBitmap(bm_bullet, 100, 100, true);


        hasStarted = true;
    }

    public void run()
    {
        while(running)
        {
            try
            {

                Thread.sleep(15); //speed of falling
            }
            catch (Exception e)
            {

            }
            update();
        }
    }

    private void update ()
    {
        if(hasStarted==false)
        {
            return;
        }
//        for (int i = 0; i < 5; i++) // amount of the planets falling
//        {
//            planets[i].move(getHeight(), getWidth());
//
//
//        }

        postInvalidate();

    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (hasStarted == false)
        {
            start();
        }

        canvas.drawBitmap(bm_myBitmap, 0, 0, paint); //background
       // panel_x+= 5;
        if(panel_x>canvas.getWidth() || panel_x<0)
        {
            panel_x-=panel_x;
        }

        else if(panel_x>canvas.getWidth()*300 || panel_x<0)
        {

        }
//        if(py>canvas.getHeight() || py<0)
//        {
//            py=-py;
//        }

//        checkPlanetCollision();

//        panel_y+= dy;
        if(firing){
            bm_bullet = BitmapFactory.decodeResource(getResources(), R.drawable.sci_logo);
            bm_bullet = Bitmap.createScaledBitmap(bm_bullet, 100, 100, true);
            canvas.drawBitmap(bm_bullet, panel_x, getHeight()-300, paint);
            if(panel_y>canvas.getHeight() || panel_y<0)
            {
                panel_y+=panel_y;
            }
            firing = false;
        }

        canvas.drawBitmap(bm_player, panel_x, getHeight()-100, paint);
//
//        //paint.setColor(Color.RED);
//        for(int i = 0; i < planets.length; i++)
//        {
//            planets[i].draw(canvas, paint);
//        }


        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        canvas.drawText("Score: " + score,  getWidth()-150, 30, paint);
//        if(time !=0)
//        {
//            int seconds = (int) time--;
//            canvas.drawText("Time: " + seconds/100,  200, 30, paint);
//        }
//        else
//        {
//            finished = true;
//            if(score > 5 & score < 10)
//            {
//                hasStarted = false;
//                canvas.drawText("Your Score is: " + score, 200, 400, finalResult);
//                canvas.drawText("Not Bad", 200, 600, finalResult);
//                canvas.drawText("Main Menu", 200, 900, finalResult);
//            }
//            else if(score > 10 & score < 15)
//            {
//                hasStarted = false;
//                canvas.drawText("Your Score is: " + score, 200, 400, finalResult);
//                canvas.drawText("Good", 200, 600, finalResult);
//                canvas.drawText("Main Menu", 200, 900, finalResult);
//
//            }
//            else if(score > 15)
//            {
//                hasStarted = false;
//                canvas.drawText("Your Score is: " + score, 200, 400, finalResult);
//                canvas.drawText("Excellent", 200, 600, finalResult);
//                canvas.drawText("Main Menu", 200, 900, finalResult);
//            }
//            else
//            {
//                hasStarted = false;
//                canvas.drawText("Your Score is: " + score, 200, 400, finalResult);
//                canvas.drawText("Seriously", 200, 600, finalResult);
//                canvas.drawText("Main Menu", 200, 900, finalResult);
//            }
//
//        }

    }

    public void updateXValue(float sensor_x_val) {
        panel_x -= sensor_x_val*15;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        if(action == ACTION_DOWN)
        {
//                canvas.drawBitmap(bm_bullet, 200, 400, paint);
//                invalidate();
//
            firing = true;


//            canvas.drawBitmap(bm_bullet,panel_x, panel_y, paint);
//            if (event.getX() == panel_x)
//            {
//                panel_y +=10;
//
//            }
//            else
//            {
//
//            }



        } else if(action == MotionEvent.ACTION_UP)
        {

        } else if (action==MotionEvent.ACTION_MOVE)
        {

        }

        return super.onTouchEvent(event);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                firing = true;
                break;
        }

        return true;
    }
}
