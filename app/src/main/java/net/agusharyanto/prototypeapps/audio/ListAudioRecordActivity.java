package net.agusharyanto.prototypeapps.audio;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.agusharyanto.prototypeapps.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListAudioRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_audio_record);
        ListView listView = (ListView) findViewById(R.id.listViewFile);
        String AudioSavePathInDevice =
                Environment.getExternalStorageDirectory().getAbsolutePath() + "/soundrec/";

        File dirFileObj = new File(AudioSavePathInDevice);

        List <File> inFiles = getListFiles(dirFileObj);
        ArrayList <String> listfilename = new ArrayList<String>();
        for (File file:inFiles) {
            String content =file.getName()+" "+file.length();
            listfilename.add(content);
            //Log.d("TAG","content:"+content);
        }

      ArrayAdapter<String>  adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listfilename);
        listView.setAdapter(adapter);
    }


    private List<File> getListFiles(File parentDir) {
        ArrayList<File> inFiles = new ArrayList<File>();
        File[] files = parentDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                inFiles.addAll(getListFiles(file));
            } else {
                inFiles.add(file);
            }
        }
        return inFiles;
    }
}
