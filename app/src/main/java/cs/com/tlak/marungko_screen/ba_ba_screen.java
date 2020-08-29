package cs.com.tlak.marungko_screen;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.widget.ImageView;
import android.widget.TextView;

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

import cs.com.tlak.CategoryScreen;
import cs.com.tlak.R;
import cs.com.tlak.methods_class.speak_tama;
import cs.com.tlak.methods_class.speech_method;
import cs.com.tlak.overview_screen;

public class ba_ba_screen extends AppCompatActivity {
    private static final String TAG = "ba_ba_screen";
    public static final int REQUEST_PERMISSION_RECORD_AUDIO = 2000;

    private SpeechRecognizer speechRecognizer;
    private Intent intent;

    private ImageView background, blackboard, back, question, mic, tap, check;
    private TextView text;
    private MediaPlayer bgm, sound, sound_mali;

    private int counter = 0;
    private boolean bool_mic_case_down, tama;
    private String speech;

    private Handler handler;
    private Runnable runnable;
    private Thread thread;
    private String simula, wakas, date_t;
    private int oras = 0;
    private long date;
    private boolean running;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ba_ba_screen);

        initialise();

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                say_question(counter);
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enable_disable(false);
                question(counter);
                YoYo.with(Techniques.Tada).duration(2500).repeat(0).playOn(text);
                sound.start();
                sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        enable_disable(true);
                        sound.release();

                        tap.setVisibility(View.VISIBLE);
                        YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap);
                    }
                });
            }
        });

        mic.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mic_case_down(mic);
                        break;

                    case MotionEvent.ACTION_UP:
                        mic_case_up();
                        break;
                }
                return true;
            }
        });
    }

    private void question(int counter) {
        switch (counter) {
            case 0:
                text.setText("Ba");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_ba);
                break;
            case 1:
                text.setText("Ma");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_ma);
                break;
            case 2:
                text.setText("Sa");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_sa);
                break;
            case 3:
            case 12:
                text.setText("Aba");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_aba);
                break;
            case 4:
                text.setText("Saba");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_saba);
                break;
            case 5:
                text.setText("Babae");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_babae);
                break;
            case 6:
                text.setText("Bababa");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_bababa);
                break;
            case 7:
                text.setText("Iba");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_iba);
                break;
            case 8:
                text.setText("Basa");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_basa);
                break;
            case 9:
                text.setText("Ibaba");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_ibaba);
                break;
            case 10:
                text.setText("Mababa");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_mababa);
                break;
            case 11:
                text.setText("Bao");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_bao);
                break;
            case 13:
                text.setText("Babasa");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_babasa);
                break;
            case 14:
                text.setText("Babasa ang babae");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_babasa_ang_babae);
                break;
            case 15:
                text.setText("May saba sa ibaba");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_may_saba_sa_ibaba);
                break;
            case 16:
                text.setText("Ang bao ay basa");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_ang_bao_ay_basa);
                break;
            case 17:
                text.setText("Ang Saba");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_ang_saba);
                break;
            case 18:
                text.setText("May saba ang babae");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_may_saba_ang_babae);
                break;
            case 19:
                text.setText("Basa ang bao sa ibaba");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_basa_ang_bao_sa_ibaba);
                break;
            case 20:
                text.setText("Iba-iba ang saba sa ibaba");
                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.new_ibaiba_ang_saba_sa_ibaba);
                break;

        }
    }

    private void say_question(final int counter) {
        check.setVisibility(View.INVISIBLE);
        sound = MediaPlayer.create(ba_ba_screen.this, R.raw.ba);
        sound.release();
        sound = MediaPlayer.create(ba_ba_screen.this, R.raw.makinig_at_basahin_ng_mabuti_ang_mga_titik_gamit_ang_mikropono);
        sound.start();
        YoYo.with(Techniques.Tada).duration(2500).repeat(0).playOn(question);
        enable_disable(false);

        sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                sound.release();
                question(counter);

                sound.start();
                YoYo.with(Techniques.Tada).duration(2500).repeat(0).playOn(text);
                sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        enable_disable(true);
                        sound.release();

                        tap.setVisibility(View.VISIBLE);
                        YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap);
                        YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(mic);
                    }
                });
            }
        });
        hideSystemUI();
    }

    private void mic_case_down(ImageView mic) {
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

    private void speechRecognizer() {
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

                enable_disable(false);

                bgm.start();
                if (bool_mic_case_down) {
                    bool_mic_case_down = false;
                    sound_mali = MediaPlayer.create(ba_ba_screen.this, R.raw.panatilihing_pindot_ang_mikropono1);
                } else {
                    if (i == 1 || i == 2 || i == 3 || i == 4) {
                        sound_mali = MediaPlayer.create(ba_ba_screen.this, R.raw.kailangan_kumunekta_sa_internet1);
                    } else if (i == 6) {
                        sound_mali = MediaPlayer.create(ba_ba_screen.this, R.raw.panatilihing_pindot_ang_mikropono1);
                    } else if (i == 7 || i == 5 || i == 9) {
                        sound_mali = speak_tama.speak_mali(ba_ba_screen.this);
                    } else {
                        sound_mali = MediaPlayer.create(ba_ba_screen.this, R.raw.pakiulit_ng_iyong_sinabi1);
                    }
                }

                sound_mali.start();
                sound_mali.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        enable_disable(true);
                        sound_mali.release();
                        tap.setVisibility(View.VISIBLE);
                        YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap);
                    }
                });
            }

            @Override
            public void onResults(Bundle bundle) {
                bool_mic_case_down = false;
                bgm.start();

                ArrayList<String> matchesFound = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if (matchesFound != null) {
                    speech = matchesFound.get(0);
                    speech = speech.toLowerCase();
                }

                String text_text = text.getText().toString().trim().toLowerCase().replaceAll("[\\\\.\\\\?\\\\,\\\\!]", "");

                Log.e(TAG, "onResults: " + speech + " | Text: " + text_text);
                Log.e(TAG, "onResults: Tama: " + text_text.contains(speech));

                enable_disable(false);

                if (speech_method.speech(text_text, speech)) {
                    sound = speak_tama.speak_tama(ba_ba_screen.this);
                    counter++;
                    tama = true;
                    check.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.ZoomInDown).duration(800).playOn(check);

                    sound.start();
                    sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            sound.release();

                            if (counter == 21) {
                                tama = false;
                                running = false;
                                run_thread();
                                speechRecognizer.destroy();

                                Intent go = new Intent(ba_ba_screen.this, overview_screen.class);
                                go.putExtra("SIMULA", simula)
                                        .putExtra("WAKAS", wakas)
                                        .putExtra("ORAS", oras)
                                        .putExtra("DATE", date_t)
                                        .putExtra("TITLE", "Marungko Approach: Ba-ba");
                                startActivity(go);
                                Animatoo.animateShrink(ba_ba_screen.this);
                                finish();
                            } else {
                                check.setVisibility(View.INVISIBLE);
                                question(counter);
                                YoYo.with(Techniques.Tada).duration(2500).repeat(0).playOn(text);
                                sound.start();
                                sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mediaPlayer) {
                                        sound.release();
                                        enable_disable(true);

                                        tap.setVisibility(View.VISIBLE);
                                        YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap);
                                    }
                                });
                            }
                        }
                    });
                } else {
                    sound_mali = speak_tama.speak_mali(ba_ba_screen.this);
                    tama = false;
                    sound_mali.start();
                    sound_mali.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            enable_disable(true);
                            sound_mali.release();
                        }
                    });
                }
            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });
    }

    private void enable_disable(boolean bool) {
        question.setEnabled(bool);
        text.setEnabled(bool);
        mic.setEnabled(bool);
    }

    private void initialise() {
        hideSystemUI();
        checkPermission();

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-Ph");

        speechRecognizer();

        if (bgm == null) {
            bgm = MediaPlayer.create(ba_ba_screen.this, R.raw.bgm1);
            bgm.setVolume(.1f, .1f);
            bgm.setLooping(true);
            bgm.start();
        }

        background = findViewById(R.id.background);
        blackboard = findViewById(R.id.blackboard);
        back = findViewById(R.id.back);
        question = findViewById(R.id.question);
        mic = findViewById(R.id.mic);
        text = findViewById(R.id.text);
        tap = findViewById(R.id.tap);
        check = findViewById(R.id.check);

        Glide.with(this).load(R.drawable.rainbow_gradiant_bg).into(background);
        Glide.with(this).load(R.drawable.blackboard).into(blackboard);
        Glide.with(this).load(R.drawable.ic_back).into(back);
        Glide.with(this).load(R.drawable.ic_question).into(question);
        Glide.with(this).load(R.drawable.ic_microphone).into(mic);
        Glide.with(this).load(R.drawable.tap).into(tap);
        Glide.with(this).load(R.drawable.check).into(check);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sound = MediaPlayer.create(ba_ba_screen.this, R.raw.ba);
                sound.start();
                sound.stop();
                sound.release();

                speechRecognizer.stopListening();
                speechRecognizer.destroy();

                speak_tama.tap_back(ba_ba_screen.this);
                startActivity(new Intent(ba_ba_screen.this, CategoryScreen.class));
                Animatoo.animateSlideRight(ba_ba_screen.this);
                finish();
            }
        });

        say_question(counter);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                tap.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.Pulse).duration(1500).repeat(20).playOn(tap);
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
        tap.setVisibility(View.GONE);
        stopHandler();
        startHandler();
    }

    private void stopHandler() {
        handler.removeCallbacks(runnable);
    }

    private void startHandler() {
        handler.postDelayed(runnable, 10000);
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!(ContextCompat.checkSelfPermission(ba_ba_screen.this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO)) {
                    new AlertDialog.Builder(this)
                            .setTitle("Kailangan ng Permiso")
                            .setMessage("Ito ay kailangan upang gamitin ang mikropono")
                            .setPositiveButton("Sige", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ActivityCompat.requestPermissions(ba_ba_screen.this, new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_PERMISSION_RECORD_AUDIO);
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
        run_thread();
        running = true;
        super.onResume();
    }
}
