package kayani.com.sciencegamenew;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by kayani on 22/05/2015.
 */
public class Background {
    private Bitmap img;
    private int x, y, dx;
    public Background(Bitmap res){

        img = res;
    }

    public void update(){

    }

    public void draw(){

    }


    public void draw(Canvas canvas) {
        canvas.drawBitmap(img,x,y,null);
    }


    public void setVector(int dx){
        this.dx =dx;
    }
}
