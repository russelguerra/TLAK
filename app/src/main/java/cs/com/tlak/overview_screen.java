package cs.com.tlak;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.io.File;
import java.io.FileOutputStream;

import cs.com.tlak.methods_class.sound_effects;
import cs.com.tlak.methods_class.speak_tama;

public class overview_screen extends AppCompatActivity {
    private static final String TAG = "overview_screen";

    private static int REQUEST_PERMISSION_WRITE_STORAGE = 99;
    String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath();

    private MediaPlayer bgm, yay;
    private ImageView background, back, play_button, tap1, share, sti;
    private TextView text2, text4, text6, txt_date, txt_title;
    private RelativeLayout layout_button;
    private String simula, wakas, oras, date, title;
    private sound_effects sound_effects;
    private boolean granted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview_screen);
        initialise();

    }

    private void initialise() {
        checkPermission();
        hideSystemUI();
        sound_effects = new sound_effects(this);

        yay = MediaPlayer.create(overview_screen.this, R.raw.kids_yay);
        yay.start();

        if (bgm == null) {
            bgm = MediaPlayer.create(overview_screen.this, R.raw.bgm_overview);
            bgm.setVolume(.1f, .1f);
            bgm.setLooping(true);
            bgm.start();
        }
        bgm.start();

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            simula = extra.getString("SIMULA");
            wakas = extra.getString("WAKAS");
            oras = extra.getInt("ORAS") + " segundo";
            date = extra.getString("DATE");
            title = extra.getString("TITLE");
        }

        background = findViewById(R.id.background);
        back = findViewById(R.id.back);
        tap1 = findViewById(R.id.tap1);
        layout_button = findViewById(R.id.layout_button);
        play_button = findViewById(R.id.play_button);
        text2 = findViewById(R.id.text2);
        text4 = findViewById(R.id.text4);
        text6 = findViewById(R.id.text6);
        txt_date = findViewById(R.id.txt_date);
        txt_title = findViewById(R.id.title);
        share = findViewById(R.id.share);
        sti = findViewById(R.id.sti);

        text2.setText(simula);
        text4.setText(wakas);
        text6.setText(oras);
        txt_date.setText(date);
        txt_title.setText(title);

        Glide.with(this).load(R.drawable.ic_back).into(back);
        Glide.with(this).load(R.drawable.bg_gif5).into(background);
        Glide.with(this).load(R.drawable.ic_play_button).into(play_button);
        Glide.with(this).load(R.drawable.tap).into(tap1);
        Glide.with(this).load(R.drawable.share).into(share);
        Glide.with(this).load(R.drawable.sti_college_lucena_logo).into(sti);

        YoYo.with(Techniques.Pulse).duration(1500).repeat(99).playOn(tap1);
        YoYo.with(Techniques.Pulse).duration(3000).repeat(99).playOn(share);

        layout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_tama.tap_back(overview_screen.this);
                startActivity(new Intent(overview_screen.this, youtube_screen.class));
                Animatoo.animateShrink(overview_screen.this);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_tama.tap(overview_screen.this);
                startActivity(new Intent(overview_screen.this, CategoryScreen.class));
                Animatoo.animateSlideRight(overview_screen.this);
                finish();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission();
                View rootView = getWindow().getDecorView().getRootView();
                Bitmap bm = getScreenShot(rootView);
                final String fileName = System.currentTimeMillis() + ".jpg";
                store(bm, fileName);
                shareImage(fileName);
            }
        });
    }

    private void shareImage(String file) {
        try {
            Uri uri = FileProvider.getUriForFile(overview_screen.this, overview_screen.this.getApplicationContext().getPackageName() + ".provider",
                    new File(dirPath + "/" + file));
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("image/*");

            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
            intent.putExtra(android.content.Intent.EXTRA_TEXT, "");
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            try {
                startActivity(Intent.createChooser(intent, "Share Screenshot"));
            } catch (ActivityNotFoundException e) {
                Log.e(TAG, "shareImage: ", e);
            }
        } catch (Exception e) {
            Log.e(TAG, "shareImage: ", e);
        }
    }

    public void store(Bitmap bm, String fileName) {
        File dir = new File(dirPath + "/Screenshots");
        if (!dir.exists())
            dir.mkdirs();
        File file = new File(dirPath, fileName);
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bitmap getScreenShot(View view) {
        View screenView = view.getRootView();
        screenView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(screenView.getDrawingCache());
        screenView.setDrawingCacheEnabled(false);
        return bitmap;
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

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!(ContextCompat.checkSelfPermission(overview_screen.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    new AlertDialog.Builder(this)
                            .setTitle("Kailangan ng Permiso")
                            .setMessage("Ito ay kailangan upang ma-i-save ang screenshot at ma-ishare.")
                            .setPositiveButton("Sige", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ActivityCompat.requestPermissions(overview_screen.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION_WRITE_STORAGE);
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
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION_WRITE_STORAGE);
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION_WRITE_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.e(TAG, "onRequestPermissionsResult: Granted permission");
            } else {
                Log.e(TAG, "onRequestPermissionsResult: Denied permission");

                new AlertDialog.Builder(this)
                        .setTitle("Kailangan ng Permiso")
                        .setMessage("Ito ay kailangan upang ma-i-save ang screenshot at ma-ishare. Pumunta sa 'Settings' upang pahintulutan ang 'T-LAK' na gamitin ang storage.")
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
