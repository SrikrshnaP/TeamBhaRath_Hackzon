package com.example.mediaplayerhackathon;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize the MediaPlayer object reference with null
        mediaPlayer = null;
    }

    public void Audio(View view) {
         //switch(view.getId()){
             //case R.id.button:
                 if(mediaPlayer == null){
                     mediaPlayer = MediaPlayer.create(this, R.raw.voicerec);
                 }
                 mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                     @Override
                     public void onCompletion(MediaPlayer mediaPlayer) {
                         // Here, call a method to release the MediaPlayer object and to set it to null.
                         stopAudio();
                     }
                 });
                 mediaPlayer.start();
    }

    private void stopAudio() {
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopAudio();
    }

}