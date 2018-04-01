package net.agusharyanto.prototypeapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.agusharyanto.prototypeapps.audio.AudioPlayerActivity;
import net.agusharyanto.prototypeapps.audio.AudioRecorderActivity;
import net.agusharyanto.prototypeapps.audio.ListAudioRecordActivity;
import net.agusharyanto.prototypeapps.camera.TakePictureActivity;
import net.agusharyanto.prototypeapps.camera.VideoCaptureActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listMenu = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initMenu();
    }

    /*
       Method initMenu digunakan untuk menginisialisasi data menu dan ditampilkan ke listview
     */
    private void initMenu() {
        String[] menus = {"Audio Player","Audio Recorder","List Audio","Take Picture","Video Recorder","Youtube", "Web View"};
        listMenu =  new ArrayList<String>(Arrays.asList(menus));
        ListView listView = (ListView) findViewById(R.id.listViewMenu);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listMenu);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openMenu(listMenu.get(position));
            }
        });
    }

    /**
     * Method openMenu digunakan untuk melakukan aksi terhadap menu yang dipilih
     * @param pmenu
     */
    private void openMenu(String pmenu) {
        Intent intent;
        switch (pmenu) {
            case "Audio Player":
                intent = new Intent(MainActivity.this, AudioPlayerActivity.class);
                startActivity(intent);
                break;
            case "Audio Recorder":
                intent = new Intent(MainActivity.this, AudioRecorderActivity.class);
                startActivity(intent);
                break;
            case "List Audio":
                intent = new Intent(MainActivity.this, ListAudioRecordActivity.class);
                startActivity(intent);
                break;
            case "Take Picture":
                intent = new Intent(MainActivity.this, TakePictureActivity.class);
                startActivity(intent);
                break;
            case "Video Recorder":
                intent = new Intent(MainActivity.this, VideoCaptureActivity.class);
                startActivity(intent);
                break;
            case "Youtube":
                intent = new Intent(MainActivity.this, YoutubeActivity.class);
                startActivity(intent);
                break;
            case "Web View":
                intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
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

}
