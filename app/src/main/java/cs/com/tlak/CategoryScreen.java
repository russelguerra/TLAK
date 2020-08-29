package cs.com.tlak;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Random;

import cs.com.tlak.activity_screens.bilang_screen;
import cs.com.tlak.activity_screens.gulay_screen;
import cs.com.tlak.activity_screens.hayop_screen;
import cs.com.tlak.activity_screens.hugis_screen;
import cs.com.tlak.activity_screens.katawan_screen;
import cs.com.tlak.activity_screens.marungko_screen;
import cs.com.tlak.activity_screens.numero_screen;
import cs.com.tlak.activity_screens.prutas_screen;
import cs.com.tlak.activity_screens.transportasyon_screen;
import cs.com.tlak.adapter.UserListAdapter;
import cs.com.tlak.classes.User;
import cs.com.tlak.methods_class.sound_effects;
import cs.com.tlak.methods_class.speak_tama;

import static cs.com.tlak.StartScreen.db;

public class CategoryScreen extends AppCompatActivity {
    private static final String TAG = "CategoryScreen";

    ImageView button_marungko_screen, button_shapes, button_gulay, button_bilang, button_transportasyon, button_numero,
            button_prutas, button_hayop, button_katawan;
    ImageView background;
    private MediaPlayer bgm;
    private sound_effects sound_effects;

    ImageView image_user;
    TextView name;
    RelativeLayout r1;
    Dialog dialog;
    private List<User> userList;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_screen);

        initialize();

        if (bgm == null) {
            bgm = MediaPlayer.create(CategoryScreen.this, R.raw.bgm1);
            bgm.setVolume(.1f, .1f);
            bgm.setLooping(true);
            bgm.start();
        }

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSystemUI();
                dialog.setContentView(R.layout.dialog_parent);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                ImageView close = dialog.findViewById(R.id.close);
                TextView tv_num1 = dialog.findViewById(R.id.num1), tv_num2 = dialog.findViewById(R.id.num2);
                final EditText et_sagot = dialog.findViewById(R.id.et_sagot);
                Button okay = dialog.findViewById(R.id.okay);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        hideSystemUI();
                        dialog.dismiss();
                    }
                });

                Random random = new Random();
                final int num1, num2, ans;

                num1 = random.nextInt(50) + 1;
                num2 = random.nextInt(50) + 1;
                ans = num1 + num2;

                tv_num1.setText(num1 + "");
                tv_num2.setText(num2 + "");

                okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            int answer = Integer.parseInt(et_sagot.getText().toString().trim());

                            if (ans == answer) {
                                hideSystemUI();
                                dialog.setContentView(R.layout.dialog_user_list);
                                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                dialog.show();

                                get_list();

                                Button bagong_user = dialog.findViewById(R.id.bagong_user);
                                bagong_user.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        startActivity(new Intent(CategoryScreen.this, CreateNewUser.class));
                                        Animatoo.animateShrink(CategoryScreen.this);
                                        finish();
                                    }
                                });
                            } else {
                                Toast.makeText(CategoryScreen.this, "Mali ang sagot", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            Toast.makeText(CategoryScreen.this, "Sagutan ang tanong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        button_marungko_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_tama.tap(CategoryScreen.this);
                startActivity(new Intent(CategoryScreen.this, marungko_screen.class));
                Animatoo.animateShrink(CategoryScreen.this);
                finish();
            }
        });

        button_shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_tama.tap(CategoryScreen.this);
                startActivity(new Intent(CategoryScreen.this, hugis_screen.class));
                Animatoo.animateShrink(CategoryScreen.this);
                finish();
            }
        });

        button_gulay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_tama.tap(CategoryScreen.this);
                startActivity(new Intent(CategoryScreen.this, gulay_screen.class));
                Animatoo.animateShrink(CategoryScreen.this);
                finish();
            }
        });

        button_bilang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_tama.tap(CategoryScreen.this);
                startActivity(new Intent(CategoryScreen.this, bilang_screen.class));
                Animatoo.animateShrink(CategoryScreen.this);
                finish();
            }
        });

        button_transportasyon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_tama.tap(CategoryScreen.this);
                startActivity(new Intent(CategoryScreen.this, transportasyon_screen.class));
                Animatoo.animateShrink(CategoryScreen.this);
                finish();
            }
        });

        button_numero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_tama.tap(CategoryScreen.this);
                startActivity(new Intent(CategoryScreen.this, numero_screen.class));
                Animatoo.animateShrink(CategoryScreen.this);
                finish();
            }
        });

        button_prutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_tama.tap(CategoryScreen.this);
                startActivity(new Intent(CategoryScreen.this, prutas_screen.class));
                Animatoo.animateShrink(CategoryScreen.this);
                finish();
            }
        });

        button_hayop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_tama.tap(CategoryScreen.this);
                startActivity(new Intent(CategoryScreen.this, hayop_screen.class));
                Animatoo.animateShrink(CategoryScreen.this);
                finish();
            }
        });

        button_katawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_tama.tap(CategoryScreen.this);
                startActivity(new Intent(CategoryScreen.this, katawan_screen.class));
                Animatoo.animateShrink(CategoryScreen.this);
                finish();
            }
        });
    }

    private void initialize() {
        hideSystemUI();

        dialog = new Dialog(this);

        sound_effects = new sound_effects(this);
        button_marungko_screen = findViewById(R.id.button_marungko_screen);
        button_shapes = findViewById(R.id.button_shapes);
        button_gulay = findViewById(R.id.button_gulay);
        button_bilang = findViewById(R.id.button_bilang);
        button_transportasyon = findViewById(R.id.button_transportasyon);
        button_numero = findViewById(R.id.button_numero);
        button_prutas = findViewById(R.id.button_prutas);
        button_hayop = findViewById(R.id.button_hayop);
        button_katawan = findViewById(R.id.button_katawan);

        background = findViewById(R.id.background);

        image_user = findViewById(R.id.user);
        name = findViewById(R.id.name);
        r1 = findViewById(R.id.r1);

        Glide.with(this).load(R.drawable.bg_gif1).into(background);
        Glide.with(this).load(R.drawable.parihaba).into(button_shapes);
        Glide.with(this).load(R.drawable.karot).into(button_gulay);
        Glide.with(this).load(R.drawable.b10).into(button_bilang);
        Glide.with(this).load(R.drawable.bus).into(button_transportasyon);
        Glide.with(this).load(R.drawable.ten).into(button_numero);
        Glide.with(this).load(R.drawable.kahel).into(button_prutas);
        Glide.with(this).load(R.drawable.aso).into(button_hayop);
        Glide.with(this).load(R.drawable.model_kompleto).into(button_katawan);
        Glide.with(this).load(R.drawable.reading).into(button_marungko_screen);

        List<User> lastUser = db.com().getLastUser();
        User user1 = lastUser.get(0);
        name.setText(user1.getName());
        if (user1.getGender().equals("male")) {
            Glide.with(this).load(R.drawable.man).into(image_user);
            image_user.setBackgroundResource(R.drawable.katawan_border_blue);
        } else {
            Glide.with(this).load(R.drawable.woman).into(image_user);
            image_user.setBackgroundResource(R.drawable.katawan_border_pink);
        }
    }

    private void get_list() {
        userList = db.com().getAccounts();
        RecyclerView recycler_view = dialog.findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(CategoryScreen.this));
        recycler_view.setHasFixedSize(true);
        UserListAdapter userListAdapter = new UserListAdapter(userList, CategoryScreen.this);

        recycler_view.setAdapter(userListAdapter);
        userListAdapter.setOnItemClickListener(new UserListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int id, int position) {
                user = userList.get(position);
                List<User> list = db.com().getAccounts();
                for (User userInList : list) {
                    if (!user.getName().equals(image_user)) {
                        db.com().updateLastUser(false, userInList.getName());
                    }
                }
                db.com().updateLastUser(true, user.getName());
                startActivity(new Intent(CategoryScreen.this, StartScreen.class));
                Animatoo.animateShrink(CategoryScreen.this);
                finish();
            }

            @Override
            public void onDeleteClick( int id, int position) {
                if (userList.size() == 1) {
                    Toast.makeText(CategoryScreen.this, "Bawal tanggalin ang nag-iisang 'user'", Toast.LENGTH_SHORT).show();
                } else {
                    user = userList.get(position);
                    AlertDialog.Builder builder = new AlertDialog.Builder(CategoryScreen.this);
                    builder.setMessage("Tanggalin ang 'user' na si " + user.getName() + "?");
                    builder.setPositiveButton("Oo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            db.com().deleteUser(user.getId());
                            get_list();
                        }
                    });
                    builder.setNegativeButton("Hindi", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }

            @Override
            public void onUpdateClick(int id, int position) {
                User user = userList.get(position);
                Intent intent = new Intent(CategoryScreen.this, CreateNewUser.class);
                intent.putExtra("NAME", user.getName());
                intent.putExtra("GENDER", user.getGender());
                intent.putExtra("ID", user.getId());

                startActivity(intent);
                Animatoo.animateShrink(CategoryScreen.this);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
