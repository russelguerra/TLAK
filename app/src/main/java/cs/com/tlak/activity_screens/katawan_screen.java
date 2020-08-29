package cs.com.tlak.activity_screens;

import android.animation.Animator;
import android.content.ClipData;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.text.SimpleDateFormat;
import java.util.Random;

import cs.com.tlak.CategoryScreen;
import cs.com.tlak.R;
import cs.com.tlak.methods_class.speak_tama;
import cs.com.tlak.overview_screen;

public class katawan_screen extends AppCompatActivity {
    private static final String TAG = "katawan_screen";

    private ImageView parts, model, back, background, tap1, background1, image_view_background_parte, image_view_border_parte, image_view_question;
    private ImageView empty_star1, empty_star2, empty_star3, empty_star4, empty_star5, empty_star6, empty_star7, empty_star8, empty_star9, empty_star10, empty_star11;
    private RelativeLayout layout1, layout2, layout3, layout4, layout5, layout6, layout7, layout8, layout9, layout10, layout11;
    private int counter = 0;
    private boolean tap_is_true = false;

    private MediaPlayer bgm, sound, yay;

    private Handler handler;
    private Runnable runnable;
    private Thread thread;
    private String simula, wakas, date_t;
    private int oras = 0;
    private long date;
    private boolean running;

    private int tunog = R.raw.isa1;
    private Random r_tunog = new Random();
    private int x_tunog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katawan_screen);
        initialise();

        image_view_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question();
            }
        });
    }

    private void initialise() {
        hideSystemUI();

        yay = MediaPlayer.create(katawan_screen.this, R.raw.kids_yay);

        if (bgm == null) {
            bgm = MediaPlayer.create(katawan_screen.this, R.raw.bgm6);
            bgm.setVolume(.1f, .1f);
            bgm.setLooping(true);
            bgm.start();
        }

        back = findViewById(R.id.back);
        background = findViewById(R.id.background);

        parts = findViewById(R.id.parts);
        model = findViewById(R.id.model);
        tap1 = findViewById(R.id.tap1);

        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);
        layout5 = findViewById(R.id.layout5);
        layout6 = findViewById(R.id.layout6);
        layout7 = findViewById(R.id.layout7);
        layout8 = findViewById(R.id.layout8);
        layout9 = findViewById(R.id.layout9);
        layout10 = findViewById(R.id.layout10);
        layout11 = findViewById(R.id.layout11);

        empty_star1 = findViewById(R.id.empty_star1);
        empty_star2 = findViewById(R.id.empty_star2);
        empty_star3 = findViewById(R.id.empty_star3);
        empty_star4 = findViewById(R.id.empty_star4);
        empty_star5 = findViewById(R.id.empty_star5);
        empty_star6 = findViewById(R.id.empty_star6);
        empty_star7 = findViewById(R.id.empty_star7);
        empty_star8 = findViewById(R.id.empty_star8);
        empty_star9 = findViewById(R.id.empty_star9);
        empty_star10 = findViewById(R.id.empty_star10);
        empty_star11 = findViewById(R.id.empty_star11);

        background1 = findViewById(R.id.background1);
        image_view_background_parte = findViewById(R.id.image_view_background_parte);
        image_view_border_parte = findViewById(R.id.image_view_border_parte);
        image_view_question = findViewById(R.id.question);

        Glide.with(this).load(R.drawable.katawan_background).into(background1);
        Glide.with(this).load(R.drawable.katawan_background_parte).into(image_view_background_parte);
        Glide.with(this).load(R.drawable.katawan_border_yellow).into(image_view_border_parte);
        Glide.with(this).load(R.drawable.ic_question).into(image_view_question);

        Glide.with(this).load(R.drawable.model).into(model);
        Glide.with(this).load(R.drawable.buhok).into(parts);
        Glide.with(this).load(R.drawable.tap).into(tap1);

        Glide.with(this).load(R.drawable.ic_back).into(back);
        Glide.with(this).load(R.drawable.bg_gif4).into(background);

        Glide.with(this).load(R.drawable.ic_star).into(empty_star1);
        Glide.with(this).load(R.drawable.ic_star).into(empty_star2);
        Glide.with(this).load(R.drawable.ic_star).into(empty_star3);
        Glide.with(this).load(R.drawable.ic_star).into(empty_star4);
        Glide.with(this).load(R.drawable.ic_star).into(empty_star5);
        Glide.with(this).load(R.drawable.ic_star).into(empty_star6);
        Glide.with(this).load(R.drawable.ic_star).into(empty_star7);
        Glide.with(this).load(R.drawable.ic_star).into(empty_star8);
        Glide.with(this).load(R.drawable.ic_star).into(empty_star9);
        Glide.with(this).load(R.drawable.ic_star).into(empty_star10);
        Glide.with(this).load(R.drawable.ic_star).into(empty_star11);

        parts.setOnTouchListener(touchListener);

        layout1.setOnDragListener(dragListener);
        layout2.setOnDragListener(dragListener);
        layout3.setOnDragListener(dragListener);
        layout4.setOnDragListener(dragListener);
        layout5.setOnDragListener(dragListener);
        layout6.setOnDragListener(dragListener);
        layout7.setOnDragListener(dragListener);
        layout8.setOnDragListener(dragListener);
        layout9.setOnDragListener(dragListener);
        layout10.setOnDragListener(dragListener);
        layout11.setOnDragListener(dragListener);

       question();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound = MediaPlayer.create(katawan_screen.this, R.raw.ba);
                sound.start();
                sound.stop();
                sound.release();

                speak_tama.tap_back(katawan_screen.this);
                startActivity(new Intent(katawan_screen.this, CategoryScreen.class));
                Animatoo.animateSlideRight(katawan_screen.this);
                finish();
            }
        });

        date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        simula = sdf.format(date);

        sdf = new SimpleDateFormat("MM/dd/yyyy");
        date_t = sdf.format(date);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (counter < 11 && !tap_is_true) {
                    tap1.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.SlideOutLeft).duration(2000).repeat(99).playOn(tap1);
                }
            }
        };
    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    ClipData clipdata = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                    view.startDrag(clipdata, shadowBuilder, view, 0);

                    switch (counter) {
                        case 0:
                            speak_isa();
                            break;
                        case 1:
                            speak_dalawa();
                            break;
                        case 2:
                            speak_tatlo();
                            break;
                        case 3:
                            speak_apat();
                            break;
                        case 4:
                            speak_lima();
                            break;
                        case 5:
                            speak_anim();
                            break;
                        case 6:
                            speak_pito();
                            break;
                        case 7:
                            speak_walo();
                            break;
                        case 8:
                            speak_siyam();
                            break;
                        case 9:
                            speak_sampo();
                    }

                    break;
            }

            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            switch (dragEvent.getAction()) {
                case DragEvent.ACTION_DROP:
                    if (counter == 0 && (view.getId() == R.id.layout1 || view.getId() == R.id.layout2)) {
                        correct_placement();
                        Glide.with(katawan_screen.this).load(R.drawable.katawan_border_blue).into(image_view_border_parte);
                        Glide.with(katawan_screen.this).load(R.drawable.model_1_buhok).into(model);
                        Glide.with(katawan_screen.this).load(R.drawable.kamay).into(parts);
                        star_animation(empty_star1);
                        counter = 1;
                        break;
                    } else if (counter == 1 && view.getId() == R.id.layout8) {
                        correct_placement();
                        Glide.with(katawan_screen.this).load(R.drawable.katawan_border_green).into(image_view_border_parte);
                        Glide.with(katawan_screen.this).load(R.drawable.model_2_kamay).into(model);
                        Glide.with(katawan_screen.this).load(R.drawable.paa).into(parts);
                        star_animation(empty_star2);
                        counter = 2;
                        break;
                    } else if (counter == 2 && view.getId() == R.id.layout11) {
                        correct_placement();
                        Glide.with(katawan_screen.this).load(R.drawable.katawan_border_indigo).into(image_view_border_parte);
                        Glide.with(katawan_screen.this).load(R.drawable.model_3_paa).into(model);
                        Glide.with(katawan_screen.this).load(R.drawable.bibig).into(parts);
                        star_animation(empty_star3);
                        counter = 3;
                        break;
                    } else if (counter == 3 && view.getId() == R.id.layout4) {
                        correct_placement();
                        Glide.with(katawan_screen.this).load(R.drawable.katawan_border_orange).into(image_view_border_parte);
                        Glide.with(katawan_screen.this).load(R.drawable.model_4_bibig).into(model);
                        Glide.with(katawan_screen.this).load(R.drawable.mata).into(parts);
                        star_animation(empty_star4);
                        counter = 4;
                        break;
                    } else if (counter == 4 && view.getId() == R.id.layout3) {
                        correct_placement();
                        Glide.with(katawan_screen.this).load(R.drawable.katawan_border_pink).into(image_view_border_parte);
                        Glide.with(katawan_screen.this).load(R.drawable.model_5_mata).into(model);
                        Glide.with(katawan_screen.this).load(R.drawable.tenga).into(parts);
                        star_animation(empty_star5);
                        counter = 5;
                        break;
                    } else if (counter == 5 && view.getId() == R.id.layout4) {
                        correct_placement();
                        Glide.with(katawan_screen.this).load(R.drawable.katawan_border_red).into(image_view_border_parte);
                        Glide.with(katawan_screen.this).load(R.drawable.model_6_tenga).into(model);
                        Glide.with(katawan_screen.this).load(R.drawable.ilong).into(parts);
                        star_animation(empty_star6);
                        counter = 6;
                        break;
                    } else if (counter == 6 && view.getId() == R.id.layout4) {
                        correct_placement();
                        Glide.with(katawan_screen.this).load(R.drawable.katawan_border_violet).into(image_view_border_parte);
                        Glide.with(katawan_screen.this).load(R.drawable.model_7_ilong).into(model);
                        Glide.with(katawan_screen.this).load(R.drawable.braso).into(parts);
                        star_animation(empty_star7);
                        counter = 7;
                        break;
                    } else if (counter == 7 && (view.getId() == R.id.layout6 || view.getId() == R.id.layout7)) {
                        correct_placement();
                        Glide.with(katawan_screen.this).load(R.drawable.katawan_border_white).into(image_view_border_parte);
                        Glide.with(katawan_screen.this).load(R.drawable.model_8_braso).into(model);
                        Glide.with(katawan_screen.this).load(R.drawable.binti).into(parts);
                        star_animation(empty_star8);
                        counter = 8;
                        break;
                    } else if (counter == 8 && (view.getId() == R.id.layout9 || view.getId() == R.id.layout10)) {
                        correct_placement();
                        Glide.with(katawan_screen.this).load(R.drawable.katawan_border_yellow).into(image_view_border_parte);
                        Glide.with(katawan_screen.this).load(R.drawable.model_9_binti).into(model);
                        Glide.with(katawan_screen.this).load(R.drawable.katawan).into(parts);
                        star_animation(empty_star9);
                        counter = 9;
                        break;
                    } else if (counter == 9 && (view.getId() == R.id.layout6 || view.getId() == R.id.layout7)) {
                        correct_placement();
                        Glide.with(katawan_screen.this).load(R.drawable.katawan_border_blue).into(image_view_border_parte);
                        Glide.with(katawan_screen.this).load(R.drawable.model_10_katawan).into(model);
                        Glide.with(katawan_screen.this).load(R.drawable.damit).into(parts);
                        star_animation(empty_star10);
                        counter = 10;
                        break;
                    } else if (counter == 10 && (view.getId() == R.id.layout6 || view.getId() == R.id.layout7 || view.getId() == R.id.layout8)) {
                        Glide.with(katawan_screen.this).load(R.drawable.model_kompleto).into(model);
                        Glide.with(katawan_screen.this).load(R.drawable.model_kompleto).into(model);
                        star_animation(empty_star11);
                        parts.setVisibility(View.INVISIBLE);
                        counter++;
                        image_view_question.setEnabled(false);

                        running = false;
                        run_thread();
                        disable_tap();

                        yay.start();
                        yay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                Intent go = new Intent(katawan_screen.this, overview_screen.class);
                                go.putExtra("SIMULA", simula)
                                        .putExtra("WAKAS", wakas)
                                        .putExtra("ORAS", oras)
                                        .putExtra("DATE", date_t)
                                        .putExtra("TITLE", "Parte ng Katawan");
                                startActivity(go);
                                Animatoo.animateShrink(katawan_screen.this);
                                finish();
                            }
                        });
                        break;
                    } else {
                        wrong_placement();
                        break;
                    }
            }

            return true;
        }
    };

    private void question() {
        YoYo.with(Techniques.Pulse).duration(2500).repeat(0).playOn(image_view_question);

        image_view_question.setEnabled(false);
        sound = MediaPlayer.create(katawan_screen.this, R.raw.ilagay_sa_tamang_pwesto_ang_larawan2);
        sound.start();
        sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                sound.release();
                YoYo.with(Techniques.Pulse).duration(2500).repeat(0).playOn(parts);

                tap_is_true = true;
                tap1.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.Pulse).duration(100)
                        .withListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                image_view_question.setEnabled(true);
                                YoYo.with(Techniques.SlideOutLeft).duration(2000)
                                        .withListener(new Animator.AnimatorListener() {
                                            @Override
                                            public void onAnimationStart(Animator animator) {

                                            }

                                            @Override
                                            public void onAnimationEnd(Animator animator) {
                                                tap_is_true = false;
                                            }

                                            @Override
                                            public void onAnimationCancel(Animator animator) {

                                            }

                                            @Override
                                            public void onAnimationRepeat(Animator animator) {

                                            }
                                        })
                                        .repeat(99).playOn(tap1);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        })
                        .repeat(0).playOn(tap1);
            }
        });

    }

    private void star_animation(ImageView image_view) {
        YoYo.with(Techniques.BounceInDown).duration(800).withListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (counter == 11) {
                    YoYo.with(Techniques.Tada).duration(1200).repeat(0).playOn(empty_star1);
                    YoYo.with(Techniques.Tada).duration(1200).repeat(0).playOn(empty_star2);
                    YoYo.with(Techniques.Tada).duration(1200).repeat(0).playOn(empty_star3);
                    YoYo.with(Techniques.Tada).duration(1200).repeat(0).playOn(empty_star4);
                    YoYo.with(Techniques.Tada).duration(1200).repeat(0).playOn(empty_star5);
                    YoYo.with(Techniques.Tada).duration(1200).repeat(0).playOn(empty_star6);
                    YoYo.with(Techniques.Tada).duration(1200).repeat(0).playOn(empty_star7);
                    YoYo.with(Techniques.Tada).duration(1200).repeat(0).playOn(empty_star8);
                    YoYo.with(Techniques.Tada).duration(1200).repeat(0).playOn(empty_star9);
                    YoYo.with(Techniques.Tada).duration(1200).repeat(0).playOn(empty_star10);
                    YoYo.with(Techniques.Tada).duration(1200).repeat(0).playOn(empty_star11);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        })
                .repeat(0).playOn(image_view);
        Glide.with(katawan_screen.this).load(R.drawable.ic_star_colored).into(image_view);
    }

    private void correct_placement() {
        sound = speak_tama.speak_tama(katawan_screen.this);
        sound.start();
        sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                sound.release();
            }
        });
    }

    private void wrong_placement() {
        Random r = new Random();
        int x = r.nextInt(3) + 1;
        switch (x) {
            case 1:
                sound = MediaPlayer.create(katawan_screen.this, R.raw.ilagay_ang_larawan_sa_tamang_pwesto);
                break;
            case 2:
                sound = MediaPlayer.create(katawan_screen.this, R.raw.ilagay_sa_tamang_pwesto_ang_larawan1);
                break;
            case 3:
                sound = MediaPlayer.create(katawan_screen.this, R.raw.ilagay_sa_tamang_pwesto_ang_larawan2);
                break;
        }
        sound.start();
        sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                sound.release();
            }
        });
    }

    private void speak_isa() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.buhok1;
                break;
            case 2:
                tunog = R.raw.buhok2;
                break;
        }
        tunog(tunog);
    }

    private void speak_dalawa() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.kamay1;
                break;
            case 2:
                tunog = R.raw.kamay2;
                break;
        }
        tunog(tunog);
    }

    private void speak_tatlo() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.paa1;
                break;
            case 2:
                tunog = R.raw.paa2;
                break;
        }
        tunog(tunog);
    }

    private void speak_apat() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.bibig1;
                break;
            case 2:
                tunog = R.raw.bibig2;
                break;
        }
        tunog(tunog);
    }

    private void speak_lima() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.mata1;
                break;
            case 2:
                tunog = R.raw.mata2;
                break;
        }
        tunog(tunog);
    }

    private void speak_anim() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.tenga1;
                break;
            case 2:
                tunog = R.raw.tenga2;
                break;
        }
        tunog(tunog);
    }

    private void speak_pito() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.ilong1;
                break;
            case 2:
                tunog = R.raw.ilong2;
                break;
        }
        tunog(tunog);
    }

    private void speak_walo() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.braso1;
                break;
            case 2:
                tunog = R.raw.braso2;
                break;
        }
        tunog(tunog);
    }

    private void speak_siyam() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.binti1;
                break;
            case 2:
                tunog = R.raw.binti2;
                break;
        }
        tunog(tunog);
    }

    private void speak_sampo() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.dibdib1;
                break;
            case 2:
                tunog = R.raw.dibdib2;
                break;
        }
        tunog(tunog);
    }

    private void tunog(int tunog) {
        sound.release();
        sound = MediaPlayer.create(katawan_screen.this, tunog);
        sound.start();
    }

    private void run_thread() {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted() && running) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                                wakas = sdf.format(date);

                                oras++;
                                hideSystemUI();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    Log.e(TAG, "run: ", e);
                }
            }
        };
        thread.start();
    }

    private void disable_tap() {
        tap1.setVisibility(View.GONE);
        tap_is_true = false;
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        disable_tap();
        stopHandler();
        startHandler();
    }

    private void stopHandler() {
        handler.removeCallbacks(runnable);
    }

    private void startHandler() {
        handler.postDelayed(runnable, 3000);
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
        running = false;
        super.onPause();
    }

    @Override
    protected void onResume() {
        bgm.start();
        running = true;
        run_thread();
        super.onResume();
    }
}
