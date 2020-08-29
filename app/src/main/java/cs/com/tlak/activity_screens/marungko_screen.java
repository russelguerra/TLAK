package cs.com.tlak.activity_screens;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;

import cs.com.tlak.CategoryScreen;
import cs.com.tlak.R;
import cs.com.tlak.marungko_screen.ba_ba_screen;
import cs.com.tlak.marungko_screen.da_da_screen;
import cs.com.tlak.marungko_screen.ga_ga_screen;
import cs.com.tlak.marungko_screen.ha_ha_screen;
import cs.com.tlak.marungko_screen.ka_ka_screen;
import cs.com.tlak.marungko_screen.la_la_screen;
import cs.com.tlak.marungko_screen.ma_ma_screen;
import cs.com.tlak.marungko_screen.na_na_screen;
import cs.com.tlak.marungko_screen.nga_nga_screen;
import cs.com.tlak.marungko_screen.pa_pa_screen;
import cs.com.tlak.marungko_screen.ra_ra_screen;
import cs.com.tlak.marungko_screen.sa_sa_screen;
import cs.com.tlak.marungko_screen.ta_ta_screen;
import cs.com.tlak.marungko_screen.wa_wa_screen;
import cs.com.tlak.marungko_screen.ya_ya_screen;
import cs.com.tlak.methods_class.speak_tama;

public class marungko_screen extends AppCompatActivity {

    Button button_ba_ba, button_da_da, button_ga_ga, button_ha_ha, button_ka_ka,button_la_la,button_ma_ma,button_na_na,button_nga_nga,button_pa_pa,button_ra_ra,button_sa_sa,button_ta_ta,button_wa_wa,button_ya_ya;
    ImageView back, background;
    MediaPlayer bgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marungko_screen);

        initialise();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_tama.tap_back(marungko_screen.this);

                startActivity(new Intent(marungko_screen.this, CategoryScreen.class));
                Animatoo.animateSlideRight(marungko_screen.this);
                finish();
            }
        });

        button_ba_ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, ba_ba_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });

       button_da_da.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, da_da_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });
        button_ga_ga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, ga_ga_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });
        button_ha_ha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, ha_ha_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });

        button_ka_ka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, ka_ka_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });

        button_la_la.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, la_la_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });
        button_ma_ma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, ma_ma_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });
        button_na_na.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, na_na_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });
        button_nga_nga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, nga_nga_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });
        button_pa_pa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, pa_pa_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });
        button_ra_ra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, ra_ra_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });
        button_sa_sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, sa_sa_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });
        button_ta_ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, ta_ta_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });
        button_wa_wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, wa_wa_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });
        button_ya_ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(marungko_screen.this, ya_ya_screen.class));
                Animatoo.animateSlideLeft(marungko_screen.this);
                finish();
            }
        });




    }

    private void initialise() {
        hideSystemUI();

        if (bgm == null) {
            bgm = MediaPlayer.create(marungko_screen.this, R.raw.bgm6);
            bgm.setVolume(.1f, .1f);
            bgm.setLooping(true);
            bgm.start();
        }

        button_ba_ba = findViewById(R.id.button_ba_ba);
        button_da_da = findViewById(R.id.button_da_da);
        button_ga_ga = findViewById(R.id.button_ga_ga);
        button_ha_ha = findViewById(R.id.button_ha_ha);
        button_ka_ka = findViewById(R.id.button_ka_ka);
        button_la_la = findViewById(R.id.button_la_la);
        button_ma_ma = findViewById(R.id.button_ma_ma);
        button_na_na = findViewById(R.id.button_na_na);
        button_nga_nga = findViewById(R.id.button_nga_nga);
        button_pa_pa = findViewById(R.id.button_pa_pa);
        button_ra_ra = findViewById(R.id.button_ra_ra);
        button_sa_sa = findViewById(R.id.button_sa_sa);
        button_ta_ta = findViewById(R.id.button_ta_ta);
        button_wa_wa = findViewById(R.id.button_wa_wa);
        button_ya_ya = findViewById(R.id.button_ya_ya);
        back = findViewById(R.id.back);
        background = findViewById(R.id.background);
        Glide.with(this).load(R.drawable.bg_gif5).into(background);
        Glide.with(this).load(R.drawable.ic_back).into(back);
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
    protected void onPause() {
        bgm.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        bgm.start();
        super.onResume();
    }
}
