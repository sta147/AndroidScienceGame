package kayani.com.sciencegamenew;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by kayani on 27/05/2015.
 */
public class Sprite {

    int x,y;
    int xSpeed;
    int height, width;
    Bitmap person;

    GamePanel gamePanel;

    public Sprite(GamePanel gamePanel, Bitmap bm_sprite) {
        this.gamePanel = gamePanel;
        bm_sprite = person;
        height = person.getHeight();
        width = person.getWidth();
        x = y = 0;
        xSpeed = 5;


    }

    public void onDraw(Canvas canvas) {
        Rect src = new Rect(100,100,width,height);
        Rect dst = new Rect(x,y,x+width,y+height);

        canvas.drawBitmap(person,src,dst,null);
    }
}
