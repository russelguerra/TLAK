package cs.com.tlak.activity_screens;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import cs.com.tlak.CategoryScreen;
import cs.com.tlak.R;
import cs.com.tlak.methods_class.speak_tama;
import cs.com.tlak.overview_screen;

import static cs.com.tlak.methods_class.on_click_animation.on_click;

public class gulay_screen extends AppCompatActivity {
    private static final String TAG = "gulay_screen";
    public static final int REQUEST_PERMISSION_RECORD_AUDIO = 2000;

    private SpeechRecognizer speechRecognizer;
    private Intent intent;
    private String speech = "", word = "";

    private HorizontalScrollView scroll_view;
    private boolean tutorial = true;
    private RelativeLayout tutorial_layout;
    private ImageView image1_2, mic1_2, tap1_2, tap2_2;

    private ImageView back, background,
            image1, mic1, image2, mic2, image6, mic6,
            image4, mic4, image5, mic5,
            image10, mic10, image9, mic9, image8, mic8, image7, mic7, image3, mic3,
            check1, check2, check3, check4, check5, check6, check7, check8, check9, check10,
            tap1, tap2, tap3, tap4, tap5, tap6, tap7, tap8, tap9, tap10;
    private MediaPlayer sound, bgm, sound_tama;
    private String string_karot = "carrot", string_bawang = "bawang", string_patatas = "patatas",
            string_sibuyas = "sibuyas", string_lara = "lara", string_kalabasa = "kalabasa", string_kamote = "kamote",
            string_sili = "sili", string_upo = "upo", string_talong = "talong";

    private int tunog = R.raw.isa1;
    private Random r_tunog = new Random();
    private int x_tunog;

    private int counter_check = 0, tap_count = 0;
    private boolean bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10;
    private boolean bool_mic_case_down;

    private Handler handler;
    private Runnable runnable;
    private Thread thread;
    private String simula, wakas, date_t;
    private int oras = 0;
    private long date;
    private boolean running;

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gulay_screen);

        initialise();
        image_views();
        mics();

        sound = MediaPlayer.create(gulay_screen.this, R.raw.ba);
        sound_tama = MediaPlayer.create(gulay_screen.this, R.raw.ba);

        if (bgm == null) {
            bgm = MediaPlayer.create(gulay_screen.this, R.raw.bgm3);
            bgm.setVolume(.1f, .1f);
            bgm.setLooping(true);
            bgm.start();
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void mics() {
        mic2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mic_case_down(mic2);
                        word = string_bawang;
                        break;

                    case MotionEvent.ACTION_UP:
                        mic_case_up();
                        break;
                }
                return true;
            }
        });

        mic5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mic_case_down(mic5);
                        word = string_lara;
                        break;

                    case MotionEvent.ACTION_UP:
                        mic_case_up();
                        break;
                }
                return true;
            }
        });

        mic3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mic_case_down(mic3);
                        word = string_upo;
                        break;

                    case MotionEvent.ACTION_UP:
                        mic_case_up();
                        break;
                }
                return true;
            }
        });

        mic1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mic_case_down(mic1);
                        word = string_karot;
                        break;

                    case MotionEvent.ACTION_UP:
                        mic_case_up();
                        break;
                }
                return true;
            }
        });

        mic4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mic_case_down(mic4);
                        word = string_sibuyas;
                        break;

                    case MotionEvent.ACTION_UP:
                        mic_case_up();
                        break;
                }
                return true;
            }
        });

        mic6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mic_case_down(mic6);
                        word = string_patatas;
                        break;

                    case MotionEvent.ACTION_UP:
                        mic_case_up();
                        break;
                }
                return true;
            }
        });

        mic10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mic_case_down(mic10);
                        word = string_kalabasa;
                        break;

                    case MotionEvent.ACTION_UP:
                        mic_case_up();
                        break;
                }
                return true;
            }
        });

        mic9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mic_case_down(mic9);
                        word = string_kamote;
                        break;

                    case MotionEvent.ACTION_UP:
                        mic_case_up();
                        break;
                }
                return true;
            }
        });

        mic8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mic_case_down(mic8);
                        word = string_sili;
                        break;

                    case MotionEvent.ACTION_UP:
                        mic_case_up();
                        break;
                }
                return true;
            }
        });

        mic7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mic_case_down(mic7);
                        word = string_talong;
                        break;

                    case MotionEvent.ACTION_UP:
                        mic_case_up();
                        break;
                }
                return true;
            }
        });

        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {
                Log.e(TAG, "onError: " + i);

                disable_image_views(false);
                bgm.start();
                if (bool_mic_case_down) {
                    bool_mic_case_down = false;
                    sound_tama = MediaPlayer.create(gulay_screen.this, R.raw.panatilihing_pindot_ang_mikropono1);
                } else {
                    if (i == 1 || i == 2 || i == 3 || i == 4) {
                        sound_tama = MediaPlayer.create(gulay_screen.this, R.raw.kailangan_kumunekta_sa_internet1);
                    } else if (i == 6) {
                        sound_tama = MediaPlayer.create(gulay_screen.this, R.raw.panatilihing_pindot_ang_mikropono1);
                    } else if (i == 7) {
                        sound_tama = speak_tama.speak_mali(gulay_screen.this);
                    } else if (i == 5) {
                        sound_tama = speak_tama.speak_mali(gulay_screen.this);
                        Log.e(TAG, "onError: Error code: 5");
                    } else if (i == 9) {
                        sound_tama = speak_tama.speak_mali(gulay_screen.this);
                        Log.e(TAG, "onError: Error code: 9 No Permission");
                    } else {
                        sound_tama = MediaPlayer.create(gulay_screen.this, R.raw.pakiulit_ng_iyong_sinabi1);
                    }
                }

                sound_tama.start();
                sound_tama.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        sound_tama.release();
                        disable_image_views(true);
                    }
                });
            }

            @Override
            public void onResults(Bundle bundle) {
                disable_image_views(false);
                bool_mic_case_down = false;
                bgm.start();

                ArrayList<String> matchesFound = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if (matchesFound != null) {
                    speech = matchesFound.get(0);
                    speech = speech.toLowerCase();
                }
                Log.e(TAG, "onResults: " + speech);

                if (word.equals(string_karot) && speech.equals(string_karot)) {
                    sound_tama = speak_tama.speak_tama(gulay_screen.this);
                    bool1 = true;
                    counter_check++;
                    tutorial = false;
                } else if (word.equals(string_bawang) && (speech.equals("bauang") || speech.equals(string_bawang))) {
                    sound_tama = speak_tama.speak_tama(gulay_screen.this);
                    bool2 = true;
                    counter_check++;
                } else if (word.equals(string_upo) && speech.equals(string_upo)) {
                    sound_tama = speak_tama.speak_tama(gulay_screen.this);
                    bool3 = true;
                    counter_check++;
                } else if (word.equals(string_sibuyas) && (speech.equals(string_sibuyas))) {
                    sound_tama = speak_tama.speak_tama(gulay_screen.this);
                    bool4 = true;
                    counter_check++;
                } else if (word.equals(string_lara) && speech.equals(string_lara)) {
                    sound_tama = speak_tama.speak_tama(gulay_screen.this);
                    bool5 = true;
                    counter_check++;
                } else if (word.equals(string_patatas) && speech.equals(string_patatas)) {
                    sound_tama = speak_tama.speak_tama(gulay_screen.this);
                    bool6 = true;
                    counter_check++;
                } else if (word.equals(string_talong) && (speech.equals(string_talong) || speech.equals("palong")) || speech.equals("along") || speech.equals("malong")) {
                    sound_tama = speak_tama.speak_tama(gulay_screen.this);
                    bool7 = true;
                    counter_check++;
                } else if (word.equals(string_sili) && speech.equals(string_sili)) {
                    sound_tama = speak_tama.speak_tama(gulay_screen.this);
                    bool8 = true;
                    counter_check++;
                } else if (word.equals(string_kamote) && speech.equals(string_kamote)) {
                    sound_tama = speak_tama.speak_tama(gulay_screen.this);
                    bool9 = true;
                    counter_check++;
                } else if (word.equals(string_kalabasa) && speech.equals(string_kalabasa)) {
                    sound_tama = speak_tama.speak_tama(gulay_screen.this);
                    bool10 = true;
                    counter_check++;
                } else {
                    sound_tama = speak_tama.speak_mali(gulay_screen.this);
                }

                visible_check();
                sound_tama.start();
                sound_tama.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        sound_tama.release();
                        disable_image_views(true);

                        if (counter_check == 10) {
                            running = false;
                            run_thread();
                            speechRecognizer.destroy();

                            Intent go = new Intent(gulay_screen.this, overview_screen.class);
                            go.putExtra("SIMULA", simula)
                                    .putExtra("WAKAS", wakas)
                                    .putExtra("ORAS", oras)
                                    .putExtra("DATE", date_t)
                                    .putExtra("TITLE", "Mga Gulay");
                            startActivity(go);
                            Animatoo.animateShrink(gulay_screen.this);
                            finish();
                        }
                    }
                });
            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });

    }

    private void mic_case_down(ImageView mic) {
        if (bool_mic_case_down) {
            bool_mic_case_down = false;
            speechRecognizer.stopListening();
        }

        checkPermission();
        sound.release();
        bgm.pause();
        speech = "";
        YoYo.with(Techniques.Pulse)
                .duration(1000)
                .repeat(0)
                .playOn(mic);

        bool_mic_case_down = true;
        speechRecognizer.startListening(intent);
    }

    private void mic_case_up() {
        speechRecognizer.stopListening();
        bool_mic_case_down = false;
        bgm.start();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void image_views() {
        image1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        on_motion_down(image1);
                        break;

                    case MotionEvent.ACTION_UP:
                        on_motion_up(image1);
                        break;
                }
                return false;
            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_click(image1_2, mic1_2);
                speak_isa();
                tap1_2.setVisibility(View.GONE);
            }
        });

        image2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        on_motion_down(image2);
                        break;

                    case MotionEvent.ACTION_UP:
                        on_motion_up(image2);
                        break;
                }
                return false;
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_click(image2, mic2);
                speak_dalawa();
            }
        });

        image3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        on_motion_down(image3);
                        break;

                    case MotionEvent.ACTION_UP:
                        on_motion_up(image3);
                        break;
                }
                return false;
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_click(image3, mic3);
                speak_tatlo();
            }
        });

        image4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        on_motion_down(image4);
                        break;

                    case MotionEvent.ACTION_UP:
                        on_motion_up(image4);
                        break;
                }
                return false;
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_click(image4, mic4);
                speak_apat();
            }
        });

        image5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        on_motion_down(image5);
                        break;

                    case MotionEvent.ACTION_UP:
                        on_motion_up(image5);
                        break;
                }
                return false;
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_click(image5, mic5);
                speak_lima();
            }
        });

        image6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        on_motion_down(image6);
                        break;

                    case MotionEvent.ACTION_UP:
                        on_motion_up(image6);
                        break;
                }
                return false;
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_click(image6, mic6);
                speak_anim();
            }
        });

        image7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        on_motion_down(image7);
                        break;

                    case MotionEvent.ACTION_UP:
                        on_motion_up(image7);
                        break;
                }
                return false;
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_click(image7, mic7);
                speak_pito();
            }
        });

        image8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        on_motion_down(image8);
                        break;

                    case MotionEvent.ACTION_UP:
                        on_motion_up(image8);
                        break;
                }
                return false;
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_click(image8, mic8);
                speak_walo();
            }
        });

        image9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        on_motion_down(image9);
                        break;

                    case MotionEvent.ACTION_UP:
                        on_motion_up(image9);
                        break;
                }
                return false;
            }
        });

        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_click(image9, mic9);
                speak_siyam();
            }
        });

        image10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        on_motion_down(image10);
                        break;

                    case MotionEvent.ACTION_UP:
                        on_motion_up(image10);
                        break;
                }
                return false;
            }
        });

        image10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_click(image10, mic10);
                speak_sampo();
            }
        });
    }

    private void on_motion_down(ImageView gulay) {
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(gulay,
                "scaleX", 0.8f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(gulay,
                "scaleY", 0.8f);
        scaleDownX.setDuration(1000);
        scaleDownY.setDuration(1000);

        AnimatorSet scaleDown = new AnimatorSet();
        scaleDown.play(scaleDownX).with(scaleDownY);

        scaleDown.start();
    }

    private void on_motion_up(ImageView gulay) {
        ObjectAnimator scaleDownX2 = ObjectAnimator.ofFloat(
                gulay, "scaleX", 1f);
        ObjectAnimator scaleDownY2 = ObjectAnimator.ofFloat(
                gulay, "scaleY", 1f);
        scaleDownX2.setDuration(1000);
        scaleDownY2.setDuration(1000);

        AnimatorSet scaleDown2 = new AnimatorSet();
        scaleDown2.play(scaleDownX2).with(scaleDownY2);

        scaleDown2.start();
    }

    private void speak_isa() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.karot1;
                break;
            case 2:
                tunog = R.raw.karot2;
                break;
        }
        tunog(tunog);
    }

    private void speak_dalawa() {
        x_tunog = r_tunog.nextInt(1) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.bawang1;
                break;
        }
        tunog(tunog);
    }

    private void speak_tatlo() {
        x_tunog = r_tunog.nextInt(1) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.upo1;
                break;
        }
        tunog(tunog);
    }

    private void speak_apat() {
        x_tunog = r_tunog.nextInt(1) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.sibuyas1;
                break;
        }
        tunog(tunog);
    }

    private void speak_lima() {
        x_tunog = r_tunog.nextInt(1) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.lara1;
                break;
        }
        tunog(tunog);
    }

    private void speak_anim() {
        x_tunog = r_tunog.nextInt(1) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.patatas1;
                break;
        }
        tunog(tunog);
    }

    private void speak_pito() {
        x_tunog = r_tunog.nextInt(1) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.talong1;
                break;
        }
        tunog(tunog);
    }

    private void speak_walo() {
        x_tunog = r_tunog.nextInt(1) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.sili1;
                break;
        }
        tunog(tunog);
    }

    private void speak_siyam() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.kamote1;
                break;
            case 2:
                tunog = R.raw.kamote2;
                break;
        }
        tunog(tunog);
    }

    private void speak_sampo() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.kalabasa1;
                break;
            case 2:
                tunog = R.raw.kalabasa2;
                break;
        }
        tunog(tunog);
    }

    private void tunog(int tunog) {
        sound.release();
        disable_image_views(false);

        if (bool_mic_case_down) {
            speechRecognizer.stopListening();
        }
        bgm.start();

        sound = MediaPlayer.create(gulay_screen.this, tunog);
        sound.start();
        sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                sound.release();
                disable_image_views(true);
                if (tutorial) {
                    tap2_2.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap2_2);
                    YoYo.with(Techniques.Tada).duration(1500).repeat(20).playOn(mic1_2);
                }
                show_dialog();
            }
        });
    }

    private void visible_check() {
        if (bool1) {
            check1.setVisibility(View.VISIBLE);
            YoYo.with(Techniques.FadeOut).duration(500)
                    .withListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            tutorial_layout.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    })
                    .repeat(0).playOn(tutorial_layout);
            image1.setEnabled(false);
            mic1.setEnabled(false);
        }

        if (bool2) {
            check2.setVisibility(View.VISIBLE);
            image2.setEnabled(false);
            mic2.setEnabled(false);
        }
        if (bool3) {
            check3.setVisibility(View.VISIBLE);
            image3.setEnabled(false);
            mic3.setEnabled(false);
        }
        if (bool4) {
            check4.setVisibility(View.VISIBLE);
            image4.setEnabled(false);
            mic4.setEnabled(false);
        }
        if (bool5) {
            check5.setVisibility(View.VISIBLE);
            image5.setEnabled(false);
            mic5.setEnabled(false);
        }
        if (bool6) {
            check6.setVisibility(View.VISIBLE);
            image6.setEnabled(false);
            mic6.setEnabled(false);
        }
        if (bool7) {
            check7.setVisibility(View.VISIBLE);
            image7.setEnabled(false);
            mic7.setEnabled(false);
        }
        if (bool8) {
            check8.setVisibility(View.VISIBLE);
            image8.setEnabled(false);
            mic8.setEnabled(false);
        }
        if (bool9) {
            check9.setVisibility(View.VISIBLE);
            image9.setEnabled(false);
            mic9.setEnabled(false);
        }
        if (bool10) {
            check10.setVisibility(View.VISIBLE);
            image10.setEnabled(false);
            mic10.setEnabled(false);
        }

    }

    private void disable_image_views(boolean bool) {
        mic1.setEnabled(bool);
        image1.setEnabled(bool);

        if (tutorial) {
            mic2.setEnabled(false);
            image2.setEnabled(false);
            mic3.setEnabled(false);
            image3.setEnabled(false);
            mic4.setEnabled(false);
            image4.setEnabled(false);
            mic5.setEnabled(false);
            image5.setEnabled(false);
            mic6.setEnabled(false);
            image6.setEnabled(false);
            mic7.setEnabled(false);
            image7.setEnabled(false);
            mic8.setEnabled(false);
            image8.setEnabled(false);
            mic9.setEnabled(false);
            image9.setEnabled(false);
            mic10.setEnabled(false);
            image10.setEnabled(false);
        } else {
            mic1.setEnabled(bool);
            image1.setEnabled(bool);
            mic2.setEnabled(bool);
            image2.setEnabled(bool);
            mic3.setEnabled(bool);
            image3.setEnabled(bool);
            mic4.setEnabled(bool);
            image4.setEnabled(bool);
            mic5.setEnabled(bool);
            image5.setEnabled(bool);
            mic6.setEnabled(bool);
            image6.setEnabled(bool);
            mic7.setEnabled(bool);
            image7.setEnabled(bool);
            mic8.setEnabled(bool);
            image8.setEnabled(bool);
            mic9.setEnabled(bool);
            image9.setEnabled(bool);
            mic10.setEnabled(bool);
            image10.setEnabled(bool);
        }

        visible_check();
    }

    private void visible_tap() {
        if (tutorial) {
            tap1_2.setVisibility(View.VISIBLE);
            YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap1_2);

            tap1.setVisibility(View.GONE);
            tap2.setVisibility(View.GONE);
            tap3.setVisibility(View.GONE);
            tap4.setVisibility(View.GONE);
            tap5.setVisibility(View.GONE);
            tap6.setVisibility(View.GONE);
            tap7.setVisibility(View.GONE);
            tap8.setVisibility(View.GONE);
            tap9.setVisibility(View.GONE);
            tap10.setVisibility(View.GONE);

            image2.setEnabled(false);
            image3.setEnabled(false);
            image4.setEnabled(false);
            image5.setEnabled(false);
            image6.setEnabled(false);
            image7.setEnabled(false);
            image8.setEnabled(false);
            image9.setEnabled(false);
            mic2.setEnabled(false);
            mic3.setEnabled(false);
            mic4.setEnabled(false);
            mic5.setEnabled(false);
            mic6.setEnabled(false);
            mic7.setEnabled(false);
            mic8.setEnabled(false);
            mic9.setEnabled(false);
        } else {
            if (bool1) {
                tap1.setVisibility(View.GONE);
            } else {
                tap1.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap1);
            }

            if (bool2) {
                tap2.setVisibility(View.GONE);
            } else {
                tap2.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap2);
            }

            if (bool3) {
                tap3.setVisibility(View.GONE);
            } else {
                tap3.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap3);
            }

            if (bool4) {
                tap4.setVisibility(View.GONE);
            } else {
                tap4.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap4);
            }

            if (bool5) {
                tap5.setVisibility(View.GONE);
            } else {
                tap5.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap5);
            }

            if (bool6) {
                tap6.setVisibility(View.GONE);
            } else {
                tap6.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap6);
            }

            if (bool7) {
                tap7.setVisibility(View.GONE);
            } else {
                tap7.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap7);
            }

            if (bool8) {
                tap8.setVisibility(View.GONE);
            } else {
                tap8.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap8);
            }

            if (bool9) {
                tap9.setVisibility(View.GONE);
            } else {
                tap9.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap9);
            }

            if (bool10) {
                tap10.setVisibility(View.GONE);
            } else {
                tap10.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap10);
            }
        }
    }

    private void disable_tap() {
        tap2_2.setVisibility(View.GONE);
        tap1.setVisibility(View.GONE);
        tap2.setVisibility(View.GONE);
        tap3.setVisibility(View.GONE);
        tap4.setVisibility(View.GONE);
        tap5.setVisibility(View.GONE);
        tap6.setVisibility(View.GONE);
        tap7.setVisibility(View.GONE);
        tap8.setVisibility(View.GONE);
        tap9.setVisibility(View.GONE);
        tap10.setVisibility(View.GONE);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void tutorial() {
        if (tutorial) {
            tap2_2.setVisibility(View.INVISIBLE);
            YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap1_2);

            scroll_view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return tutorial;
                }
            });

            visible_tap();
        }
    }

    private void show_dialog() {
        if (tap_count > 2 && (tap_count % 2 == 0)) {
            tap_count = 0;
            disable_image_views(false);

            dialog.setContentView(R.layout.dialog_mic);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();

            ImageView dialog_mic = dialog.findViewById(R.id.dialog_mic);
            Glide.with(this).load(R.drawable.ic_microphone).into(dialog_mic);
            sound = MediaPlayer.create(gulay_screen.this, R.raw.sabihin_ang_salitang_narinig_gamit_ang_mikropono);
            YoYo.with(Techniques.Pulse).duration(1000).repeat(0).playOn(dialog_mic);
            sound.start();
            sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    sound.release();
                    disable_image_views(true);
                    dialog.dismiss();
                }
            });
        } else {
            tap_count++;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initialise() {
        hideSystemUI();
        checkPermission();

        dialog = new Dialog(this);

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-Ph");

        back = findViewById(R.id.back);
        background = findViewById(R.id.background);
        image1 = findViewById(R.id.karot);
        mic1 = findViewById(R.id.mic_karot);
        image2 = findViewById(R.id.bawang);
        mic2 = findViewById(R.id.mic_bawang);
        image3 = findViewById(R.id.upo);
        mic3 = findViewById(R.id.mic_upo);
        image4 = findViewById(R.id.sibuyas);
        mic4 = findViewById(R.id.mic_sibuyas);
        image5 = findViewById(R.id.kamatis);
        mic5 = findViewById(R.id.mic_kamatis);
        image6 = findViewById(R.id.patatas);
        mic6 = findViewById(R.id.mic_patatas);
        image10 = findViewById(R.id.kalabasa);
        mic10 = findViewById(R.id.mic_kalabasa);
        image9 = findViewById(R.id.kamote);
        mic9 = findViewById(R.id.mic_kamote);
        image8 = findViewById(R.id.sili);
        mic8 = findViewById(R.id.mic_sili);
        image7 = findViewById(R.id.talong);
        mic7 = findViewById(R.id.mic_talong);

        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        check4 = findViewById(R.id.check4);
        check5 = findViewById(R.id.check5);
        check6 = findViewById(R.id.check6);
        check7 = findViewById(R.id.check7);
        check8 = findViewById(R.id.check8);
        check9 = findViewById(R.id.check9);
        check10 = findViewById(R.id.check10);

        tap1 = findViewById(R.id.tap1);
        tap2 = findViewById(R.id.tap2);
        tap3 = findViewById(R.id.tap3);
        tap4 = findViewById(R.id.tap4);
        tap5 = findViewById(R.id.tap5);
        tap6 = findViewById(R.id.tap6);
        tap7 = findViewById(R.id.tap7);
        tap8 = findViewById(R.id.tap8);
        tap9 = findViewById(R.id.tap9);
        tap10 = findViewById(R.id.tap10);

        scroll_view = findViewById(R.id.scroll_view);
        tutorial_layout = findViewById(R.id.tutorial_layout);
        image1_2 = findViewById(R.id.karot_2);
        tap1_2 = findViewById(R.id.tap1_2);
        tap2_2 = findViewById(R.id.tap2_2);
        mic1_2 = findViewById(R.id.mic_karot_2);

        Glide.with(this).load(R.drawable.karot).into(image1_2);
        Glide.with(this).load(R.drawable.microphone).into(mic1_2);
        Glide.with(this).load(R.drawable.tap).into(tap1_2);
        Glide.with(this).load(R.drawable.tap).into(tap2_2);

        Glide.with(this).load(R.drawable.ic_back).into(back);
        Glide.with(this).load(R.drawable.bg_gif2).into(background);
        Glide.with(this).load(R.drawable.karot).into(image1);
        Glide.with(this).load(R.drawable.microphone).into(mic1);
        Glide.with(this).load(R.drawable.bawang).into(image2);
        Glide.with(this).load(R.drawable.microphone).into(mic2);
        Glide.with(this).load(R.drawable.upo).into(image3);
        Glide.with(this).load(R.drawable.microphone).into(mic3);
        Glide.with(this).load(R.drawable.sibuyas).into(image4);
        Glide.with(this).load(R.drawable.microphone).into(mic4);
        Glide.with(this).load(R.drawable.lara).into(image5);
        Glide.with(this).load(R.drawable.microphone).into(mic5);
        Glide.with(this).load(R.drawable.patatas).into(image6);
        Glide.with(this).load(R.drawable.microphone).into(mic6);
        Glide.with(this).load(R.drawable.kalabasa).into(image10);
        Glide.with(this).load(R.drawable.microphone).into(mic10);
        Glide.with(this).load(R.drawable.kamote).into(image9);
        Glide.with(this).load(R.drawable.microphone).into(mic9);
        Glide.with(this).load(R.drawable.sili).into(image8);
        Glide.with(this).load(R.drawable.microphone).into(mic8);
        Glide.with(this).load(R.drawable.talong).into(image7);
        Glide.with(this).load(R.drawable.microphone).into(mic7);

        Glide.with(this).load(R.drawable.check).into(check1);
        Glide.with(this).load(R.drawable.check).into(check2);
        Glide.with(this).load(R.drawable.check).into(check3);
        Glide.with(this).load(R.drawable.check).into(check4);
        Glide.with(this).load(R.drawable.check).into(check5);
        Glide.with(this).load(R.drawable.check).into(check6);
        Glide.with(this).load(R.drawable.check).into(check7);
        Glide.with(this).load(R.drawable.check).into(check8);
        Glide.with(this).load(R.drawable.check).into(check9);
        Glide.with(this).load(R.drawable.check).into(check10);

        Glide.with(this).load(R.drawable.tap).into(tap1);
        Glide.with(this).load(R.drawable.tap).into(tap2);
        Glide.with(this).load(R.drawable.tap).into(tap3);
        Glide.with(this).load(R.drawable.tap).into(tap4);
        Glide.with(this).load(R.drawable.tap).into(tap5);
        Glide.with(this).load(R.drawable.tap).into(tap6);
        Glide.with(this).load(R.drawable.tap).into(tap7);
        Glide.with(this).load(R.drawable.tap).into(tap8);
        Glide.with(this).load(R.drawable.tap).into(tap9);
        Glide.with(this).load(R.drawable.tap).into(tap10);

        tutorial();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound = MediaPlayer.create(gulay_screen.this, R.raw.ba);
                sound.start();
                sound.stop();
                sound.release();

                speechRecognizer.stopListening();
                speechRecognizer.destroy();

                speak_tama.tap_back(gulay_screen.this);
                startActivity(new Intent(gulay_screen.this, CategoryScreen.class));
                Animatoo.animateSlideRight(gulay_screen.this);
                finish();
            }
        });

        visible_tap();

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                visible_tap();
            }
        };

        date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        simula = sdf.format(date);

        sdf = new SimpleDateFormat("MM/dd/yyyy");
        date_t = sdf.format(date);
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
        handler.postDelayed(runnable, 5000);
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!(ContextCompat.checkSelfPermission(gulay_screen.this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO)) {
                    new AlertDialog.Builder(this)
                            .setTitle("Kailangan ng Permiso")
                            .setMessage("Ito ay kailangan upang gamitin ang mikropono")
                            .setPositiveButton("Sige", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ActivityCompat.requestPermissions(gulay_screen.this, new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_PERMISSION_RECORD_AUDIO);
                                }
                            })
                            .setNegativeButton("Ayaw", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                            .create().show();
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_PERMISSION_RECORD_AUDIO);
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION_RECORD_AUDIO) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.e(TAG, "onRequestPermissionsResult: Granted permission");
            } else {
                Log.e(TAG, "onRequestPermissionsResult: Denied permission");

                new AlertDialog.Builder(this)
                        .setTitle("Kailangan ng Permiso")
                        .setMessage("Ito ay kailangan upang gamitin ang mikropono. Pumunta sa 'Settings' upang pahintulutan ang 'T-LAK' na gamitin ang mikropono.")
                        .setPositiveButton("Sige", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package", getPackageName(), null);
                                intent.setData(uri);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Ayaw", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .create().show();
            }
        }
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
