package belluste.drum;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private SoundPool sounds;
    private int sd1, sd2, sd3, sd4, sd5, sd6, sd7, sd8;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View mainView = getWindow().getDecorView();
        mainView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        ImageView d1 = findViewById(R.id.d1);
        ImageView d2 = findViewById(R.id.d2);
        ImageView d3 = findViewById(R.id.d3);
        ImageView d4 = findViewById(R.id.d4);
        ImageView d5 = findViewById(R.id.d5);
        ImageView d6 = findViewById(R.id.d6);
        ImageView d7 = findViewById(R.id.d7);
        ImageView d8 = findViewById(R.id.d8);

        d1.setOnTouchListener(this);
        d2.setOnTouchListener(this);
        d3.setOnTouchListener(this);
        d4.setOnTouchListener(this);
        d5.setOnTouchListener(this);
        d6.setOnTouchListener(this);
        d7.setOnTouchListener(this);
        d8.setOnTouchListener(this);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            sounds = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);
        } else {
            AudioAttributes attributi = new AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).setUsage(AudioAttributes.USAGE_GAME).build();
            sounds = new SoundPool.Builder().setAudioAttributes(attributi).setMaxStreams(6).build();
        }

        sd1 = sounds.load(getApplicationContext(), R.raw.d01, 1);
        sd2 = sounds.load(getApplicationContext(), R.raw.d02, 1);
        sd3 = sounds.load(getApplicationContext(), R.raw.d03, 1);
        sd4 = sounds.load(getApplicationContext(), R.raw.d04, 1);
        sd5 = sounds.load(getApplicationContext(), R.raw.d05, 1);
        sd6 = sounds.load(getApplicationContext(), R.raw.d06, 1);
        sd7 = sounds.load(getApplicationContext(), R.raw.d07, 1);
        sd8 = sounds.load(getApplicationContext(), R.raw.d08, 1);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.d1:
                sounds.play(sd1, 1.0f, 1.0f, 1, 0, 1.0f);
                break;
            case R.id.d2:
                sounds.play(sd2, 1.0f, 1.0f, 1, 0, 1.0f);
                break;
            case R.id.d3:
                sounds.play(sd3, 1.0f, 1.0f, 1, 0, 1.0f);
                break;
            case R.id.d4:
                sounds.play(sd4, 1.0f, 1.0f, 1, 0, 1.0f);
                break;
            case R.id.d5:
                sounds.play(sd5, 1.0f, 1.0f, 1, 0, 1.0f);
                break;
            case R.id.d6:
                sounds.play(sd6, 1.0f, 1.0f, 1, 0, 1.0f);
                break;
            case R.id.d7:
                sounds.play(sd7, 1.0f, 1.0f, 1, 0, 1.0f);
                break;
            case R.id.d8:
                sounds.play(sd8, 1.0f, 1.0f, 1, 0, 1.0f);
                break;
        }

        return false;
    }
}
