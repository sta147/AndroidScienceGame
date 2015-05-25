//package kayani.com.sciencegamenew;
//
//import android.graphics.Canvas;
//import android.view.SurfaceHolder;
//
///**
// * Created by kayani on 21/05/2015.
// */
//public class MainThread extends Thread{
//    private int fps = 30;
//    private double avg_fps;
//    private SurfaceHolder surfaceHolder;
//    private GamePanel gamePanel;
//    private boolean running;
//    public static Canvas canvas1;
//
//    public MainThread(SurfaceHolder surfaceHolder, GamePanel gamePanel){
//        super();
//        this.surfaceHolder = surfaceHolder;
//        this.gamePanel = gamePanel;
//    }
//    @Override
//    public void run(){
//        long startTime = 0;
//        long timeMillis;
//        long waitTime;
//        long totalTime = 0;
//        int frameCount = 0;
//        long targetTime = 1000/fps;
//
//        while(running){
//            startTime = System.nanoTime();
//            canvas1 = null;
//
//        //try to lock the canvas1 for pixel editing.
//            try{
//                canvas1 = this.surfaceHolder.lockCanvas();
//                synchronized (surfaceHolder){
//                    this.gamePanel.update();
//                    this.gamePanel.draw(canvas1);
//                }
//
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//            finally{
//                if(canvas1 !=null){
//                    try{
//                        surfaceHolder.unlockCanvasAndPost(canvas1);
//                    } catch (Exception e){ e.printStackTrace();}
//                }
//            }
//
//
//
//            timeMillis = System.nanoTime()-startTime/1000000;
//            waitTime = targetTime-targetTime-timeMillis;
//
//            try{
//                this.sleep(waitTime);
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//
//            totalTime+=System.nanoTime()-startTime;
//            frameCount++;
//            if(frameCount == fps){
//                avg_fps = 100/(totalTime/frameCount)/1000000;
//                frameCount=0;
//                totalTime=0;
//                System.out.println(avg_fps);
//            }
//        }
//    }
//    public void setRunning(boolean r){
//        running = r;
//    }
//}
