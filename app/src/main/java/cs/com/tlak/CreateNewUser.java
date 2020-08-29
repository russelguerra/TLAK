package cs.com.tlak;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;

import java.util.List;

import cs.com.tlak.classes.User;

import static cs.com.tlak.StartScreen.db;

public class CreateNewUser extends AppCompatActivity {

    private static final String TAG = "CreateNewUser";

    ImageView image_man, image_woman, check1, check2;
    EditText et_name;
    Button okay;

    private MediaPlayer bgm, yay;
    private String gender = "male";
    private String name = "";
    private int id;
    private boolean update = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);

        initialize();

        image_man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check1.setVisibility(View.VISIBLE);
                gender = "male";
                check2.setVisibility(View.INVISIBLE);
            }
        });

        image_woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check2.setVisibility(View.VISIBLE);
                gender = "female";
                check1.setVisibility(View.INVISIBLE);
            }
        });

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = et_name.getText().toString().trim();
                List<User> check_list_for_user = db.com().getUser(name);

                if (check_list_for_user.size() > 0 && !update) {
                    Toast.makeText(CreateNewUser.this, "Ang pangalan ay nakarehistro na. Pumili ng ibang pangalan.", Toast.LENGTH_SHORT).show();
                } else if (name.isEmpty()) {
                    Toast.makeText(CreateNewUser.this, "Kailangan lagyan ng pangalan", Toast.LENGTH_SHORT).show();
                } else {
                    if (update) {
                        db.com().updateUser(name, gender, id);
                    } else {
                        db.com().insertAccount(new User(name, gender, true));
                    }

                    List<User> list = db.com().getAccounts();
                    for (User user : list) {
                        if (!user.getName().equals(name)) {
                            db.com().updateLastUser(false, user.getName());
                        }
                    }
                    db.com().updateLastUser(true, name);

                    yay.start();
                    startActivity(new Intent(CreateNewUser.this, CategoryScreen.class));
                    Animatoo.animateSpin(CreateNewUser.this);
                    finish();
                }
            }
        });
    }

    private void initialize() {
        hideSystemUI();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("NAME");
            gender = extras.getString("GENDER");
            id = extras.getInt("ID");
            update = true;
        }

        image_man = findViewById(R.id.image_man);
        image_woman = findViewById(R.id.image_woman);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        et_name = findViewById(R.id.et_name);
        okay = findViewById(R.id.okay);

        if (bgm == null) {
            yay = MediaPlayer.create(CreateNewUser.this, R.raw.kids_yay);
            bgm = MediaPlayer.create(CreateNewUser.this, R.raw.bgm1);
            bgm.setVolume(.1f, .1f);
            bgm.setLooping(true);
            bgm.start();
        }

        Glide.with(this).load(R.drawable.man).into(image_man);
        Glide.with(this).load(R.drawable.woman).into(image_woman);
        Glide.with(this).load(R.drawable.check).into(check1);
        Glide.with(this).load(R.drawable.check).into(check2);

        et_name.setText(name);
        if (gender.equals("male")) {
            check1.setVisibility(View.VISIBLE);
            check2.setVisibility(View.INVISIBLE);
        } else {
            check1.setVisibility(View.INVISIBLE);
            check2.setVisibility(View.VISIBLE);
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
        super.onPause();
    }

    @Override
    protected void onResume() {
        bgm.start();
        super.onResume();
    }
}
