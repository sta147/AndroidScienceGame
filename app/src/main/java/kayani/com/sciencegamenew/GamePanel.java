package kayani.com.sciencegamenew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import static android.view.MotionEvent.ACTION_DOWN;

/**
 * Created by kayani on 21/05/2015.
 */
public class GamePanel extends View implements Runnable, View.OnTouchListener {


    private boolean running = true;
    private Paint paint;
    Thread myThread;
    private int score = 0;
    private long time = 1000;
    Context context;
    private boolean hasStarted;
    private Bitmap bm_myBitmap;
    private Bitmap bm_player;
    private Bitmap bm_bullet;
    private Bitmap bm_sprite;
    float panel_x;
    float panel_y;
    private boolean finished = false;
    private Canvas canvas;
    private boolean firing = false;
    Rect textRect;
    String fact;
    private Sprite sprite;

    float x=0, y=0, dx=5, dy=5;
    private TextView tv;

    public GamePanel(Context context) {
        super(context);

        this.context = context;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(100);
        paint.setStyle(Paint.Style.FILL);
        fact = "Fun Fact: The human body can handle increased g-forces as seen in activities such as dragster races, airplane acrobatics and space training. The highest known acceleration voluntarily experienced by a human is 46.2 g by g-force pioneer John Stapp. ";

        textRect = new Rect();
        paint.getTextBounds(fact,0,fact.length(),textRect);


        myThread = new Thread(this);
        myThread.start();


    }

    public void start()
    {

        bm_myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.space_bg);
        bm_myBitmap = Bitmap.createScaledBitmap(bm_myBitmap, getWidth(), getHeight(), true);

        bm_player = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        bm_player = Bitmap.createScaledBitmap(bm_player, 100, 100, true);

        bm_bullet = BitmapFactory.decodeResource(getResources(), R.drawable.sci_logo);
        bm_bullet = Bitmap.createScaledBitmap(bm_bullet, 100, 100, true);

        bm_sprite = BitmapFactory.decodeResource(getResources(), R.drawable.spritesheet2);
        bm_sprite = Bitmap.createScaledBitmap(bm_sprite, 200, 200, true);

        hasStarted = true;
    }
    @Override
    public void run()
    {
        while(running)
        {
            try
            {
                panel_y -= 5;
                Thread.sleep(15); //speed of falling
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            update();
        }
        postInvalidate();
    }

    private void update ()
    {
        if(!hasStarted)
        {
            return;
        }

        postInvalidate();

    }

    public void draw(Canvas canvas)
    {
        this.canvas = canvas;
        super.draw(canvas);
        if (!hasStarted)
        {
            start();
        }

        canvas.drawBitmap(bm_myBitmap, 0, 0, paint); //background
//        panel_x+= 5;
        if(panel_x>canvas.getWidth() || panel_x<0)
        {
            panel_x-=panel_x;
        }

        else if(panel_x>canvas.getWidth()*300 || panel_x<0)
        {

        }

        if(firing){
            bm_bullet = BitmapFactory.decodeResource(getResources(), R.drawable.sci_logo);
            bm_bullet = Bitmap.createScaledBitmap(bm_bullet, 100, 100, true);
            canvas.drawBitmap(bm_bullet, panel_x, getHeight()-300, paint);
            if(panel_y>canvas.getHeight() || panel_y<0)
            {
                panel_y-=panel_y;
            }
            firing = false;
        }

        canvas.drawBitmap(bm_player, panel_x, getHeight()-100, paint);

        tv = new TextView(context);
        tv.setText(fact);
        tv.setTextColor(Color.WHITE);
        // you have to enable setDrawingCacheEnabled, or the getDrawingCache will return null
        tv.setDrawingCacheEnabled(true);
        // we need to setup how big the view should be..which is exactly as big as the canvas
        tv.measure(MeasureSpec.makeMeasureSpec(canvas.getWidth(), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(canvas.getHeight(), MeasureSpec.EXACTLY));
        // assign the layout values to the textview
        tv.layout(0, 0, tv.getMeasuredWidth(), tv.getMeasuredHeight());

        // draw the bitmap from the drawingcache to the canvas
        canvas.drawBitmap(tv.getDrawingCache(), 0, 0, paint);
        tv.setDrawingCacheEnabled(false);


        invalidate();

    }

    public void updateXValue(float sensor_x_val) {
        panel_x -= sensor_x_val;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int action = event.getAction();
        if(action == ACTION_DOWN)
        {
            firing = true;
            invalidate();
        } else if(action == MotionEvent.ACTION_UP)
        {
            firing = true;
            invalidate();

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
