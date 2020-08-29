package cs.com.tlak.activity_screens;

import android.animation.Animator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

import cs.com.tlak.CategoryScreen;
import cs.com.tlak.R;
import cs.com.tlak.methods_class.speak_tama;

public class bilang_screen extends AppCompatActivity {
    private static final String TAG = "bilang_screen";
    public static final int REQUEST_PERMISSION_RECORD_AUDIO = 2000;

    private ImageView back, background,
            button_isa, button_dalawa, button_tatlo, button_apat, button_lima, button_anim, button_pito, button_walo, button_siyam, button_sampu,
            button_apple1,
            button_mango1, button_mango2,
            button_orange1, button_orange2, button_orange3,
            button_pineapple1, button_pineapple2, button_pineapple3, button_pineapple4,
            button_strawberry1, button_strawberry2, button_strawberry3, button_strawberry4, button_strawberry5,
            button_watermelon1, button_watermelon2, button_watermelon3, button_watermelon4, button_watermelon5, button_watermelon6,
            button_jackfruit1, button_jackfruit2, button_jackfruit3, button_jackfruit4, button_jackfruit5, button_jackfruit6, button_jackfruit7,
            button_dalandan1, button_dalandan2, button_dalandan3, button_dalandan4, button_dalandan5, button_dalandan6, button_dalandan7, button_dalandan8,
            button_guava1, button_guava2, button_guava3, button_guava4, button_guava5, button_guava6, button_guava7, button_guava8, button_guava9,
            button_banana1, button_banana2, button_banana3, button_banana4, button_banana5, button_banana6, button_banana7, button_banana8, button_banana9, button_banana10;
    private ImageView one1;
    private int c1 = 1, c2 = 1, c3 = 1, c4 = 1, c5 = 1, c6 = 1, c7 = 1, c8 = 1, c9 = 1, c10 = 1;
    private int animation_duration = 1500;
    private float opacity = 0.5f;
    private MediaPlayer bgm, sound;

    private int tunog = R.raw.isa1;
    private Random r_tunog = new Random();
    private int x_tunog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilang_screen);

        initialise();

        set_on_clicker();

        if (bgm == null) {
            bgm = MediaPlayer.create(bilang_screen.this, R.raw.bgm2);
            bgm.setVolume(.1f, .1f);
            bgm.setLooping(true);
            bgm.start();
        }
    }

    private void set_on_clicker() {
        button_apple1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apple1(button_apple1);
                button_apple1.setAlpha(opacity);
            }
        });
        //dalawa
        button_mango1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mango2(button_mango1);
            }
        });

        button_mango2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mango2(button_mango2);
            }
        });

        //tatlo
        button_orange1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                orange3(button_orange1);
            }
        });

        button_orange2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                orange3(button_orange2);
            }
        });

        button_orange3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                orange3(button_orange3);
            }
        });

        //apat

        button_pineapple1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pineapple4(button_pineapple1);
            }
        });

        button_pineapple2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pineapple4(button_pineapple2);
            }
        });

        button_pineapple3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pineapple4(button_pineapple3);
            }
        });
        button_pineapple4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pineapple4(button_pineapple4);
            }
        });

        //lima
        button_strawberry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strawberry5(button_strawberry1);
            }
        });
        button_strawberry2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strawberry5(button_strawberry2);
            }
        });
        button_strawberry3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strawberry5(button_strawberry3);
            }
        });

        button_strawberry4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strawberry5(button_strawberry4);
            }
        });
        button_strawberry5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strawberry5(button_strawberry5);
            }
        });

        //anim

        button_watermelon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                watermelon6(button_watermelon1);
            }
        });
        button_watermelon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                watermelon6(button_watermelon2);
            }
        });

        button_watermelon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                watermelon6(button_watermelon3);
            }
        });

        button_watermelon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                watermelon6(button_watermelon4);
            }
        });

        button_watermelon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                watermelon6(button_watermelon5);
            }
        });

        button_watermelon6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                watermelon6(button_watermelon6);
            }
        });

        //pito

        button_jackfruit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jackfruit7(button_jackfruit1);
            }
        });

        button_jackfruit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jackfruit7(button_jackfruit2);
            }
        });

        button_jackfruit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jackfruit7(button_jackfruit3);
            }
        });
        button_jackfruit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jackfruit7(button_jackfruit4);
            }
        });

        button_jackfruit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jackfruit7(button_jackfruit5);
            }
        });

        button_jackfruit6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jackfruit7(button_jackfruit6);
            }
        });
        button_jackfruit7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jackfruit7(button_jackfruit7);
            }
        });

        //walo
        button_dalandan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dalandan8(button_dalandan1);
            }
        });
        button_dalandan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dalandan8(button_dalandan2);
            }
        });
        button_dalandan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dalandan8(button_dalandan3);
            }
        });
        button_dalandan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dalandan8(button_dalandan4);
            }
        });
        button_dalandan5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dalandan8(button_dalandan5);
            }
        });

        button_dalandan6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dalandan8(button_dalandan6);
            }
        });

        button_dalandan7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dalandan8(button_dalandan7);
            }
        });

        button_dalandan8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dalandan8(button_dalandan8);
            }
        });

        //siyam
        button_guava1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guava9(button_guava1);
            }
        });

        button_guava2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guava9(button_guava2);
            }
        });
        button_guava3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guava9(button_guava3);
            }
        });
        button_guava4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guava9(button_guava4);
            }
        });
        button_guava5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guava9(button_guava5);
            }
        });
        button_guava6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guava9(button_guava6);
            }
        });
        button_guava7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guava9(button_guava7);
            }
        });
        button_guava8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guava9(button_guava8);
            }
        });

        button_guava9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guava9(button_guava9);
            }
        });

        button_banana1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                banana10(button_banana1);
            }
        });
        button_banana2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                banana10(button_banana2);
            }
        });
        button_banana3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                banana10(button_banana3);
            }
        });
        button_banana4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                banana10(button_banana4);
            }
        });

        button_banana5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                banana10(button_banana5);
            }
        });

        button_banana6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                banana10(button_banana6);
            }
        });

        button_banana7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                banana10(button_banana7);
            }
        });

        button_banana8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                banana10(button_banana8);
            }
        });
        button_banana9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                banana10(button_banana9);
            }
        });

        button_banana10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                banana10(button_banana10);
            }
        });

        button_isa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_isa();
                YoYo.with(Techniques.Bounce)
                        .duration(animation_duration)
                        .repeat(0)
                        .playOn(button_isa);
            }
        });
        button_dalawa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_dalawa();
                YoYo.with(Techniques.Bounce)
                        .duration(animation_duration)
                        .repeat(0)
                        .playOn(button_dalawa);
            }
        });
        button_tatlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_tatlo();
                YoYo.with(Techniques.Bounce)
                        .duration(animation_duration)
                        .repeat(0)
                        .playOn(button_tatlo);
            }
        });
        button_apat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_apat();
                YoYo.with(Techniques.Bounce)
                        .duration(animation_duration)
                        .repeat(0)
                        .playOn(button_apat);
            }
        });
        button_lima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_lima();
                YoYo.with(Techniques.Bounce)
                        .duration(animation_duration)
                        .repeat(0)
                        .playOn(button_lima);
            }
        });
        button_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_anim();
                YoYo.with(Techniques.Bounce)
                        .duration(animation_duration)
                        .repeat(0)
                        .playOn(button_anim);
            }
        });
        button_pito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_pito();
                YoYo.with(Techniques.Bounce)
                        .duration(animation_duration)
                        .repeat(0)
                        .playOn(button_pito);
            }
        });
        button_walo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_walo();
                YoYo.with(Techniques.Bounce)
                        .duration(animation_duration)
                        .repeat(0)
                        .playOn(button_walo);
            }
        });
        button_siyam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_siyam();
                YoYo.with(Techniques.Bounce)
                        .duration(animation_duration)
                        .repeat(0)
                        .playOn(button_siyam);
            }
        });
        button_sampu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak_sampo();
                YoYo.with(Techniques.Bounce)
                        .duration(animation_duration)
                        .repeat(0)
                        .playOn(button_sampu);
            }
        });
    }

    private void apple1(ImageView image_view) {
        animation_start(image_view);
        animation_stop(image_view);
        speak_isa();
    }

    private void mango2(ImageView image_view) {
        animation_start(image_view);
        if (c2 == 1) {
            speak_isa();
            c2++;
        } else if (c2 == 2) {
            speak_dalawa();
            c2 = 1;
            animation_stop(button_mango1);
            animation_stop(button_mango2);
        }
    }

    private void orange3(ImageView image_view) {
        animation_start(image_view);
        if (c3 == 1) {
            speak_isa();
            c3++;
        } else if (c3 == 2) {
            speak_dalawa();
            c3++;
        } else if (c3 == 3) {
            speak_tatlo();
            animation_stop(button_orange1);
            animation_stop(button_orange2);
            animation_stop(button_orange3);
            c3 = 1;
        }

    }

    private void pineapple4(ImageView image_view) {
        animation_start(image_view);
        if (c4 == 1) {
            speak_isa();
            c4++;
        } else if (c4 == 2) {
            speak_dalawa();
            c4++;
        } else if (c4 == 3) {
            speak_tatlo();
            c4++;
        } else if (c4 == 4) {
            animation_stop(button_pineapple1);
            animation_stop(button_pineapple2);
            animation_stop(button_pineapple3);
            animation_stop(button_pineapple4);
            speak_apat();
            c4 = 1;
        }
    }

    private void strawberry5(ImageView image_view) {
        animation_start(image_view);
        if (c5 == 1) {
            speak_isa();
            c5++;
        } else if (c5 == 2) {
            speak_dalawa();
            c5++;
        } else if (c5 == 3) {
            speak_tatlo();
            c5++;
        } else if (c5 == 4) {
            speak_apat();
            c5++;
        } else if (c5 == 5) {
            speak_lima();
            animation_stop(button_strawberry1);
            animation_stop(button_strawberry2);
            animation_stop(button_strawberry3);
            animation_stop(button_strawberry4);
            animation_stop(button_strawberry5);
            c5 = 1;
        }
    }

    private void watermelon6(ImageView image_view) {
        animation_start(image_view);
        if (c6 == 1) {
            speak_isa();
            c6++;
        } else if (c6 == 2) {
            speak_dalawa();
            c6++;
        } else if (c6 == 3) {
            speak_tatlo();
            c6++;
        } else if (c6 == 4) {
            speak_apat();
            c6++;
        } else if (c6 == 5) {
            speak_lima();

            c6++;
        } else if (c6 == 6) {
            speak_anim();
            animation_stop(button_watermelon1);
            animation_stop(button_watermelon2);
            animation_stop(button_watermelon3);
            animation_stop(button_watermelon4);
            animation_stop(button_watermelon5);
            animation_stop(button_watermelon6);
            c6 = 1;
        }
    }

    private void jackfruit7(ImageView image_view) {
        animation_start(image_view);
        if (c7 == 1) {
            speak_isa();
            c7++;
        } else if (c7 == 2) {
            speak_dalawa();
            c7++;
        } else if (c7 == 3) {
            speak_tatlo();
            c7++;
        } else if (c7 == 4) {
            speak_apat();
            c7++;
        } else if (c7 == 5) {
            speak_lima();
            c7++;
        } else if (c7 == 6) {
            speak_anim();
            c7++;
        } else if (c7 == 7) {
            speak_pito();
            animation_stop(button_jackfruit1);
            animation_stop(button_jackfruit2);
            animation_stop(button_jackfruit3);
            animation_stop(button_jackfruit4);
            animation_stop(button_jackfruit5);
            animation_stop(button_jackfruit6);
            animation_stop(button_jackfruit7);
            c7 = 1;
        }
    }

    private void dalandan8(ImageView image_view) {
        animation_start(image_view);
        if (c8 == 1) {
            speak_isa();
            c8++;
        } else if (c8 == 2) {
            speak_dalawa();
            c8++;
        } else if (c8 == 3) {
            speak_tatlo();
            c8++;
        } else if (c8 == 4) {
            speak_apat();
            c8++;
        } else if (c8 == 5) {
            speak_lima();
            c8++;
        } else if (c8 == 6) {
            speak_anim();
            c8++;
        } else if (c8 == 7) {
            speak_pito();
            c8++;
        } else if (c8 == 8) {
            speak_walo();
            animation_stop(button_dalandan1);
            animation_stop(button_dalandan2);
            animation_stop(button_dalandan3);
            animation_stop(button_dalandan4);
            animation_stop(button_dalandan5);
            animation_stop(button_dalandan6);
            animation_stop(button_dalandan7);
            animation_stop(button_dalandan8);
            c8 = 1;
        }

    }

    private void guava9(ImageView image_view) {
        animation_start(image_view);
        if (c9 == 1) {
            speak_isa();
            c9++;
        } else if (c9 == 2) {
            speak_dalawa();
            c9++;
        } else if (c9 == 3) {
            speak_tatlo();
            c9++;
        } else if (c9 == 4) {
            speak_apat();
            c9++;
        } else if (c9 == 5) {
            speak_lima();
            c9++;
        } else if (c9 == 6) {
            speak_anim();
            c9++;
        } else if (c9 == 7) {
            speak_pito();
            c9++;
        } else if (c9 == 8) {
            speak_walo();
            c9++;
        } else if (c9 == 9) {
            speak_siyam();
            animation_stop(button_guava1);
            animation_stop(button_guava2);
            animation_stop(button_guava3);
            animation_stop(button_guava4);
            animation_stop(button_guava5);
            animation_stop(button_guava6);
            animation_stop(button_guava7);
            animation_stop(button_guava8);
            animation_stop(button_guava9);
            c9 = 1;
        }
    }

    private void banana10(ImageView image_view) {
        animation_start(image_view);

        if (c10 == 1) {
            speak_isa();
            c10++;
        } else if (c10 == 2) {
            speak_dalawa();
            c10++;
        } else if (c10 == 3) {
            speak_tatlo();
            c10++;
        } else if (c10 == 4) {
            speak_apat();
            c10++;
        } else if (c10 == 5) {
            speak_lima();
            c10++;
        } else if (c10 == 6) {
            speak_anim();
            c10++;
        } else if (c10 == 7) {
            speak_pito();
            c10++;
        } else if (c10 == 8) {
            speak_walo();
            c10++;
        } else if (c10 == 9) {
            speak_siyam();
            c10++;
        } else if (c10 == 10) {
            speak_sampo();
            c10 = 1;

            animation_stop(button_banana1);
            animation_stop(button_banana2);
            animation_stop(button_banana3);
            animation_stop(button_banana4);
            animation_stop(button_banana5);
            animation_stop(button_banana6);
            animation_stop(button_banana7);
            animation_stop(button_banana8);
            animation_stop(button_banana9);
            animation_stop(button_banana10);
        }
    }

    private void speak_isa() {
        x_tunog = r_tunog.nextInt(3) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.isa1;
                break;
            case 2:
                tunog = R.raw.isa2;
                break;
            case 3:
                tunog = R.raw.isa3;
                break;
        }
        tunog(tunog);
    }

    private void speak_dalawa() {
        x_tunog = r_tunog.nextInt(4) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.dalawa1;
                break;
            case 2:
                tunog = R.raw.dalawa2;
                break;
            case 3:
                tunog = R.raw.dalawa3;
                break;
            case 4:
                tunog = R.raw.dalawa4;
                break;
        }
        tunog(tunog);
    }

    private void speak_tatlo() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.tatlo1;
                break;
            case 2:
                tunog = R.raw.tatlo2;
                break;
        }
        tunog(tunog);
    }

    private void speak_apat() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.apat1;
                break;
            case 2:
                tunog = R.raw.apat2;
                break;
        }
        tunog(tunog);
    }

    private void speak_lima() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.lima1;
                break;
            case 2:
                tunog = R.raw.lima2;
                break;
        }
        tunog(tunog);
    }

    private void speak_anim() {
        x_tunog = r_tunog.nextInt(3) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.anim1;
                break;
            case 2:
                tunog = R.raw.anim2;
                break;
            case 3:
                tunog = R.raw.anim3;
                break;
        }
        tunog(tunog);
    }

    private void speak_pito() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.pito1;
                break;
            case 2:
                tunog = R.raw.pito2;
                break;
        }
        tunog(tunog);
    }

    private void speak_walo() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.walo1;
                break;
            case 2:
                tunog = R.raw.walo2;
                break;
        }
        tunog(tunog);
    }

    private void speak_siyam() {
        x_tunog = r_tunog.nextInt(2) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.siyam1;
                break;
            case 2:
                tunog = R.raw.siyam2;
                break;
        }
        tunog(tunog);
    }

    private void speak_sampo() {
        x_tunog = r_tunog.nextInt(3) + 1;
        switch (x_tunog) {
            case 1:
                tunog = R.raw.sampo1;
                break;
            case 2:
                tunog = R.raw.sampo2;
                break;
            case 3:
                tunog = R.raw.sampo3;
                break;
        }
        tunog(tunog);
    }

    private void tunog(int tunog) {
        sound.release();
        sound = MediaPlayer.create(bilang_screen.this, tunog);
        sound.start();
        hideSystemUI();
    }

    private void animation_start(ImageView image_view) {
        YoYo.with(Techniques.Pulse)
                .duration(animation_duration)
                .repeat(0)
                .playOn(image_view);
        image_view.setEnabled(false);
        image_view.setAlpha(opacity);
    }

    private void animation_stop(final ImageView image_view) {
        YoYo.with(Techniques.Tada)
                .duration(animation_duration)
                .repeat(0)
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        image_view.setEnabled(true);
                        image_view.setAlpha(1f);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                .playOn(image_view);
    }

    private void initialise() {
        hideSystemUI();

        sound = MediaPlayer.create(bilang_screen.this, R.raw.ba);

        back = findViewById(R.id.back);
        background = findViewById(R.id.background);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound = MediaPlayer.create(bilang_screen.this, R.raw.ba);
                sound.pause();
                sound.release();

                speak_tama.tap_back(bilang_screen.this);

                startActivity(new Intent(bilang_screen.this, CategoryScreen.class));
                Animatoo.animateSlideRight(bilang_screen.this);
                finish();
            }
        });

        button_isa = findViewById(R.id.button_isa);
        button_dalawa = findViewById(R.id.button_dalawa);
        button_tatlo = findViewById(R.id.button_tatlo);
        button_apat = findViewById(R.id.button_apat);
        button_lima = findViewById(R.id.button_lima);
        button_anim = findViewById(R.id.button_anim);
        button_pito = findViewById(R.id.button_pito);
        button_walo = findViewById(R.id.button_walo);
        button_siyam = findViewById(R.id.button_siyam);
        button_sampu = findViewById(R.id.button_sampu);

        button_apple1 = findViewById(R.id.button_apple1);

        button_mango1 = findViewById(R.id.button_mango1);
        button_mango2 = findViewById(R.id.button_mango2);

        button_orange1 = findViewById(R.id.button_orange1);
        button_orange2 = findViewById(R.id.button_orange2);
        button_orange3 = findViewById(R.id.button_orange3);

        button_pineapple1 = findViewById(R.id.button_pineapple1);
        button_pineapple2 = findViewById(R.id.button_pineapple2);
        button_pineapple3 = findViewById(R.id.button_pineapple3);
        button_pineapple4 = findViewById(R.id.button_pineapple4);

        button_strawberry1 = findViewById(R.id.button_strawberry1);
        button_strawberry2 = findViewById(R.id.button_strawberry2);
        button_strawberry3 = findViewById(R.id.button_strawberry3);
        button_strawberry4 = findViewById(R.id.button_strawberry4);
        button_strawberry5 = findViewById(R.id.button_strawberry5);

        button_watermelon1 = findViewById(R.id.button_watermelon1);
        button_watermelon2 = findViewById(R.id.button_watermelon2);
        button_watermelon3 = findViewById(R.id.button_watermelon3);
        button_watermelon4 = findViewById(R.id.button_watermelon4);
        button_watermelon5 = findViewById(R.id.button_watermelon5);
        button_watermelon6 = findViewById(R.id.button_watermelon6);

        button_jackfruit1 = findViewById(R.id.button_jackfruit1);
        button_jackfruit2 = findViewById(R.id.button_jackfruit2);
        button_jackfruit3 = findViewById(R.id.button_jackfruit3);
        button_jackfruit4 = findViewById(R.id.button_jackfruit4);
        button_jackfruit5 = findViewById(R.id.button_jackfruit5);
        button_jackfruit6 = findViewById(R.id.button_jackfruit6);
        button_jackfruit7 = findViewById(R.id.button_jackfruit7);

        button_dalandan1 = findViewById(R.id.button_dalandan1);
        button_dalandan2 = findViewById(R.id.button_dalandan2);
        button_dalandan3 = findViewById(R.id.button_dalandan3);
        button_dalandan4 = findViewById(R.id.button_dalandan4);
        button_dalandan5 = findViewById(R.id.button_dalandan5);
        button_dalandan6 = findViewById(R.id.button_dalandan6);
        button_dalandan7 = findViewById(R.id.button_dalandan7);
        button_dalandan8 = findViewById(R.id.button_dalandan8);

        button_guava1 = findViewById(R.id.button_guava1);
        button_guava2 = findViewById(R.id.button_guava2);
        button_guava3 = findViewById(R.id.button_guava3);
        button_guava4 = findViewById(R.id.button_guava4);
        button_guava5 = findViewById(R.id.button_guava5);
        button_guava6 = findViewById(R.id.button_guava6);
        button_guava7 = findViewById(R.id.button_guava7);
        button_guava8 = findViewById(R.id.button_guava8);
        button_guava9 = findViewById(R.id.button_guava9);

        button_banana1 = findViewById(R.id.button_banana1);
        button_banana2 = findViewById(R.id.button_banana2);
        button_banana3 = findViewById(R.id.button_banana3);
        button_banana4 = findViewById(R.id.button_banana4);
        button_banana5 = findViewById(R.id.button_banana5);
        button_banana6 = findViewById(R.id.button_banana6);
        button_banana7 = findViewById(R.id.button_banana7);
        button_banana8 = findViewById(R.id.button_banana8);
        button_banana9 = findViewById(R.id.button_banana9);
        button_banana10 = findViewById(R.id.button_banana10);

        Glide.with(this).load(R.drawable.ic_back).into(back);
        Glide.with(this).load(R.drawable.bg_gif2).into(background);

        Glide.with(this).load(R.drawable.b1).into(button_isa);
        Glide.with(this).load(R.drawable.b2).into(button_dalawa);
        Glide.with(this).load(R.drawable.b3).into(button_tatlo);
        Glide.with(this).load(R.drawable.b4).into(button_apat);
        Glide.with(this).load(R.drawable.b5).into(button_lima);
        Glide.with(this).load(R.drawable.b6).into(button_anim);
        Glide.with(this).load(R.drawable.b7).into(button_pito);
        Glide.with(this).load(R.drawable.b8).into(button_walo);
        Glide.with(this).load(R.drawable.b9).into(button_siyam);
        Glide.with(this).load(R.drawable.b10).into(button_sampu);

        Glide.with(this).load(R.drawable.apple).into(button_apple1);

        Glide.with(this).load(R.drawable.mango).into(button_mango1);
        Glide.with(this).load(R.drawable.mango).into(button_mango2);

        Glide.with(this).load(R.drawable.orange).into(button_orange1);
        Glide.with(this).load(R.drawable.orange).into(button_orange2);
        Glide.with(this).load(R.drawable.orange).into(button_orange3);

        Glide.with(this).load(R.drawable.pineapple).into(button_pineapple1);
        Glide.with(this).load(R.drawable.pineapple).into(button_pineapple2);
        Glide.with(this).load(R.drawable.pineapple).into(button_pineapple3);
        Glide.with(this).load(R.drawable.pineapple).into(button_pineapple4);

        Glide.with(this).load(R.drawable.strawberry).into(button_strawberry1);
        Glide.with(this).load(R.drawable.strawberry).into(button_strawberry2);
        Glide.with(this).load(R.drawable.strawberry).into(button_strawberry3);
        Glide.with(this).load(R.drawable.strawberry).into(button_strawberry4);
        Glide.with(this).load(R.drawable.strawberry).into(button_strawberry5);

        Glide.with(this).load(R.drawable.watermelon).into(button_watermelon1);
        Glide.with(this).load(R.drawable.watermelon).into(button_watermelon2);
        Glide.with(this).load(R.drawable.watermelon).into(button_watermelon3);
        Glide.with(this).load(R.drawable.watermelon).into(button_watermelon4);
        Glide.with(this).load(R.drawable.watermelon).into(button_watermelon5);
        Glide.with(this).load(R.drawable.watermelon).into(button_watermelon6);

        Glide.with(this).load(R.drawable.jackfruit).into(button_jackfruit1);
        Glide.with(this).load(R.drawable.jackfruit).into(button_jackfruit2);
        Glide.with(this).load(R.drawable.jackfruit).into(button_jackfruit3);
        Glide.with(this).load(R.drawable.jackfruit).into(button_jackfruit4);
        Glide.with(this).load(R.drawable.jackfruit).into(button_jackfruit5);
        Glide.with(this).load(R.drawable.jackfruit).into(button_jackfruit6);
        Glide.with(this).load(R.drawable.jackfruit).into(button_jackfruit7);

        Glide.with(this).load(R.drawable.dalandan).into(button_dalandan1);
        Glide.with(this).load(R.drawable.dalandan).into(button_dalandan2);
        Glide.with(this).load(R.drawable.dalandan).into(button_dalandan3);
        Glide.with(this).load(R.drawable.dalandan).into(button_dalandan4);
        Glide.with(this).load(R.drawable.dalandan).into(button_dalandan5);
        Glide.with(this).load(R.drawable.dalandan).into(button_dalandan6);
        Glide.with(this).load(R.drawable.dalandan).into(button_dalandan7);
        Glide.with(this).load(R.drawable.dalandan).into(button_dalandan8);

        Glide.with(this).load(R.drawable.guava).into(button_guava1);
        Glide.with(this).load(R.drawable.guava).into(button_guava2);
        Glide.with(this).load(R.drawable.guava).into(button_guava3);
        Glide.with(this).load(R.drawable.guava).into(button_guava4);
        Glide.with(this).load(R.drawable.guava).into(button_guava5);
        Glide.with(this).load(R.drawable.guava).into(button_guava6);
        Glide.with(this).load(R.drawable.guava).into(button_guava7);
        Glide.with(this).load(R.drawable.guava).into(button_guava8);
        Glide.with(this).load(R.drawable.guava).into(button_guava9);

        Glide.with(this).load(R.drawable.banana).into(button_banana1);
        Glide.with(this).load(R.drawable.banana).into(button_banana2);
        Glide.with(this).load(R.drawable.banana).into(button_banana3);
        Glide.with(this).load(R.drawable.banana).into(button_banana4);
        Glide.with(this).load(R.drawable.banana).into(button_banana5);
        Glide.with(this).load(R.drawable.banana).into(button_banana6);
        Glide.with(this).load(R.drawable.banana).into(button_banana7);
        Glide.with(this).load(R.drawable.banana).into(button_banana8);
        Glide.with(this).load(R.drawable.banana).into(button_banana9);
        Glide.with(this).load(R.drawable.banana).into(button_banana10);
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
