package kayani.com.sciencegamenew;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;


public class VideoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

    String path="http://www.ted.com/talks/download/video/8584/talk/761";
//    String path2="http://www.pasco.com/resources/videos/Physics/MatchGraph.mp4";
//    String path2="http://jwst.nasa.gov/sciencevids/PlanetaryEvolution/Nebula_to_cu_of_Protoplanetary_disc_ipod_sm.mp4";
    String path2="https://ia700401.us.archive.org/19/items/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";

        String path1="https://r4---sn-8pgbpohxqp5-ac5l.googlevideo.com/videoplayback?id=acf5901af58e0c30&itag=135&source=youtube&requiressl=yes&mm=31&pl=24&mv=m&ms=au&ratebypass=yes&mime=video/mp4&gir=yes&clen=106243569&lmt=1392980858856456&dur=1622.401&key=dg_yt0&signature=5E267BA9E2E186F6AFFF3025F73CB642C768E78C.154A9537FD4AACD52FD43789E116BBC6EC14054D";

    Uri uri= Uri.parse(path2);

        MediaController vidControl = new MediaController(this);

        VideoView video=(VideoView)findViewById(R.id.videoView);
        vidControl.setAnchorView(video);
        video.setMediaController(vidControl);

        video.setVideoURI(uri);
        video.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video, menu);
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
