package cs.com.tlak;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.Random;

public class youtube_screen extends YouTubeBaseActivity {
    private static final String TAG = "youtube_screen";

    YouTubePlayerView youtube_video;
    YouTubePlayer.OnInitializedListener youtube_initialise;
    ImageView back;
    TextView title, uploader;

    private static final String API_KEY = "AIzaSyA2cKtPxGom1Qme4tnA48UBGCb5IG03Y0U";
    private String string_title = "", string_uploader = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_screen);
        hideSystemUI();

        youtube_video = findViewById(R.id.youtube_video);
        back = findViewById(R.id.back);
        title = findViewById(R.id.title);
        uploader = findViewById(R.id.uploader);

        Glide.with(this).load(R.drawable.ic_back).into(back);

        youtube_initialise = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Random r = new Random();
                int x = r.nextInt(10) + 1;
                String video = "";

                switch (x) {
                    case 1:
                        video = "rm4PaKyp46M";
                        string_title = "Ang Pipit";
                        string_uploader = "Pambata TV";
                        break;
                    case 2:
                        video = "lJCSu8RmSjE";
                        string_title = "Tatlong Bibe";
                        string_uploader = "Pambata TV";
                        break;
                    case 3:
                        video = "p6msvVZSKZc";
                        string_title = "Ulo Balikat Tuhod At Ang Paa";
                        string_uploader = "Pambata TV";
                        break;
                    case 4:
                        video = "bMp5TZHyzi0";
                        string_title = "Alamat ng Aso't Pusa";
                        string_uploader = "Pambata TV";
                        break;
                    case 5:
                        video = "qQBxCk2G8x4";
                        string_title = "Kung Bakit Tumitilaok ang Manok";
                        string_uploader = "Batibot TV";
                        break;
                    case 6:
                        video = "jI9JokSbMjI";
                        string_title = "Kwentong Pambata";
                        string_uploader = "Kids Planet Filipino";
                        break;
                    case 7:
                        video = "AAT_eUFgKXs";
                        string_title = "Mahiwagang Palaka";
                        string_uploader = "Kids Planet Filipino";
                        break;
                    case 8:
                        video = "xunx09WzZxQ";
                        string_title = "Pinocchio ";
                        string_uploader = "Kids Planet Filipino";
                        break;
                    case 9:
                        video = "LeiOhsORPUo";
                        string_title = "Ang Langgam at ang tipaklong";
                        string_uploader = "Kids Planet Filipino";
                        break;
                    case 10:
                        video = "W6gynYnZYzU";
                        string_title = "Kwento Ng Kalabasa";
                        string_uploader = "Kids Planet Filipino";
                        break;
                }

                Log.e(TAG, "onInitializationSuccess: " + x);
                youTubePlayer.loadVideo(video);
                title.setText(string_title);
                uploader.setText("Youtube: " + string_uploader);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youtube_video.initialize(API_KEY, youtube_initialise);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(youtube_screen.this, CategoryScreen.class));
                Animatoo.animateSlideRight(youtube_screen.this);
                finish();
            }
        });
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
}
