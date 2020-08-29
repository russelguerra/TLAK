package cs.com.tlak;

import android.animation.Animator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.List;

import cs.com.tlak.classes.User;
import cs.com.tlak.methods_class.sound_effects;

public class StartScreen extends AppCompatActivity {
    private static final String TAG = "StartScreen";

    public static cs.com.tlak.db.db db;
    List<User> account;

    ImageView image1, sti;
    cs.com.tlak.methods_class.sound_effects sound_effects;

    Handler handler;
    public static MediaPlayer yay, boing;
    private int duration = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        hideSystemUI();

        db = Room.databaseBuilder(getApplicationContext(), cs.com.tlak.db.db.class, "database")
                .allowMainThreadQueries()
                .build();
        account = db.com().getAccounts();

        sound_effects = new sound_effects(this);
        handler = new Handler();
        image1 = findViewById(R.id.image1);
        sti = findViewById(R.id.sti);

        yay = MediaPlayer.create(StartScreen.this, R.raw.kids_yay);
        boing = MediaPlayer.create(StartScreen.this, R.raw.boing);

        Glide.with(this).load(R.drawable.logo).into(image1);
        Glide.with(this).load(R.drawable.sti_college_lucena_logo).into(sti);

        yay.start();
        image1.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.RotateIn)
                .duration(duration)
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        boing.start();
                        boing.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                boing.release();
                            }
                        });

                        sti.setVisibility(View.VISIBLE);
                        YoYo.with(Techniques.Wobble).duration(duration).repeat(0).playOn(sti);

                        yay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                yay.release();

                                if (account.size() > 0) {
                                    startActivity(new Intent(StartScreen.this, CategoryScreen.class));
                                } else {
                                    startActivity(new Intent(StartScreen.this, CreateNewUser.class));
                                }
                                Animatoo.animateSpin(StartScreen.this);
                                finish();
                            }
                        });
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                .playOn(image1);
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
