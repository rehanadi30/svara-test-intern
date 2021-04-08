package com.bookingman.svaratest;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bookingman.svaratest.model.LoginResponse;
import com.bookingman.svaratest.model.Radio;
import com.bookingman.svaratest.model.RadioResponse;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RadioActivity extends AppCompatActivity {
    public int id;

    public TextView namaRadio;
    public ImageView gambarRadio;
    public EditText contohET;
    public TextView duar;

    public ImageView pauseBtn, playBtn, nextBtn, prevBtn;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_activity);

        Radio radio = getIntent().getParcelableExtra("Radio_Terpilih");

        id = radio.getId();
//        String url = radio.getImages();
        String urlTest1 = "https://goo.gl/ghVPFq";
        String urlTest2 = "https://api.svara.id/svara-radio-logo/download/573e8bfd0c3f8b20491c8147";
        namaRadio = findViewById(R.id.namaRadio);
        namaRadio.setText(radio.getName());

//        contohET = findViewById(R.id.editTextTextPersonName);
//        duar = findViewById(R.id.textView);
//        duar.setText(contohET.getText().toString());

        playBtn = findViewById(R.id.playButton);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playBtn.setVisibility(View.GONE);
                pauseBtn.setVisibility(View.VISIBLE);
                playAudio(radio);
            }
        });

        pauseBtn = findViewById(R.id.pauseButton);
        pauseBtn.setVisibility(View.GONE);
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseBtn.setVisibility(View.GONE);
                playBtn.setVisibility(View.VISIBLE);
                if (mediaPlayer.isPlaying()) {
                    // pausing the media player if media player
                    // is playing we are calling below line to
                    // stop our media player.
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();

                    // below line is to display a message
                    // when media player is paused.
                    Toast.makeText(RadioActivity.this, "Radio sedang dijeda", Toast.LENGTH_SHORT).show();
                } else {
                    // this method is called when media
                    // player is not playing.
                    Toast.makeText(RadioActivity.this, "Radio tidak menyala", Toast.LENGTH_SHORT).show();
                }
            }
        });

        gambarRadio = findViewById(R.id.gambarRadio);
        Picasso.get().load(urlTest1).into(gambarRadio);
    }

    private void playAudio(Radio radio) {

        String audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";
//        String audioUrl = radio.getStream();

        // initializing media player
        mediaPlayer = new MediaPlayer();

        // below line is use to set the audio
        // stream type for our media player.
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        // below line is use to set our
        // url to our media player.
        try {
            mediaPlayer.setDataSource(audioUrl);
            // below line is use to prepare
            // and start our media player.
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // below line is use to display a toast message.
        Toast.makeText(this, "Kamu sedang mendengarkan " + radio.getName(), Toast.LENGTH_SHORT).show();
    }
}
