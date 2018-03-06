package net.agusharyanto.prototypeapps.camera;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.VideoView;

import net.agusharyanto.prototypeapps.R;

public class VideoCaptureActivity extends AppCompatActivity {

    VideoView mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_capture);
        mVideoView = (VideoView) findViewById(R.id.videoView);
    }

    static final int REQUEST_VIDEO_CAPTURE = 1;

    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.d("TAG","masukvideo");
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = intent.getData();
            Log.d("TAG", "videouri:"+videoUri.toString());
            mVideoView.setVideoURI(videoUri);
            mVideoView.start();
        }
    }

    public void buttonClick(View view) {
        dispatchTakeVideoIntent();
    }
}
