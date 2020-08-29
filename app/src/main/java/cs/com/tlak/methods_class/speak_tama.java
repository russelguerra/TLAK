package cs.com.tlak.methods_class;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.Random;

import cs.com.tlak.R;

public class speak_tama {
    private static MediaPlayer speak_tama, tap, tap_back, speak_mali;
    private static Random r = new Random();
    private static int x = 0;

/*    public static void speak_tama(Context context) {
        speak_tama = MediaPlayer.create(context, R.raw.magaling1);
        speak_tama.release();

        x = r.nextInt(8) + 1;
        switch (x) {
            case 1:
                speak_tama = MediaPlayer.create(context, R.raw.magaling1);
                break;
            case 2:
                speak_tama = MediaPlayer.create(context, R.raw.magaling2);
                break;
            case 3:
                speak_tama = MediaPlayer.create(context, R.raw.magaling3);
                break;
            case 4:
                speak_tama = MediaPlayer.create(context, R.raw.mahusay1);
                break;
            case 5:
                speak_tama = MediaPlayer.create(context, R.raw.mahusay2);
                break;
            case 6:
                speak_tama = MediaPlayer.create(context, R.raw.mahusay3);
                break;
            case 7:
                speak_tama = MediaPlayer.create(context, R.raw.tama1);
                break;
            case 8:
                speak_tama = MediaPlayer.create(context, R.raw.tama2);
                break;
        }
        speak_tama.start();
    }*/

    public static MediaPlayer speak_tama(Context context) {
        speak_tama = MediaPlayer.create(context, R.raw.magaling1);
        speak_tama.release();

        x = r.nextInt(8) + 1;
        switch (x) {
            case 1:
                speak_tama = MediaPlayer.create(context, R.raw.magaling1);
                break;
            case 2:
                speak_tama = MediaPlayer.create(context, R.raw.magaling2);
                break;
            case 3:
                speak_tama = MediaPlayer.create(context, R.raw.magaling3);
                break;
            case 4:
                speak_tama = MediaPlayer.create(context, R.raw.mahusay1);
                break;
            case 5:
                speak_tama = MediaPlayer.create(context, R.raw.mahusay2);
                break;
            case 6:
                speak_tama = MediaPlayer.create(context, R.raw.mahusay3);
                break;
            case 7:
                speak_tama = MediaPlayer.create(context, R.raw.tama1);
                break;
            case 8:
                speak_tama = MediaPlayer.create(context, R.raw.tama2);
                break;
        }

        return speak_tama;
    }

    public static MediaPlayer speak_mali(Context context) {
        Random r_mali = new Random();
        int x_mali = r_mali.nextInt(3) + 1;
        switch (x_mali) {
            case 1:
                speak_mali = MediaPlayer.create(context, R.raw.pakiulit_ng_iyong_sinabi1);
                break;
            case 2:
                speak_mali = MediaPlayer.create(context, R.raw.iba_pang_sagot1);
                break;
            case 3:
                Random r_ano = new Random();
                int x_ano = r_ano.nextInt(2) + 1;
                switch (x_ano) {
                    case 1:
                        speak_mali = MediaPlayer.create(context, R.raw.ano_uli_iyon1);
                        break;
                    case 2:
                        speak_mali = MediaPlayer.create(context, R.raw.ano_uli_iyon2);
                        break;
                }
                break;
        }
        return speak_mali;
    }

    public static void tap(Context context) {
        tap = MediaPlayer.create(context, R.raw.tap1);
        tap.release();

        x = r.nextInt(4) + 1;
        switch (x) {
            case 1:
                tap = MediaPlayer.create(context, R.raw.tap1);
                break;
            case 2:
                tap = MediaPlayer.create(context, R.raw.tap2);
                break;
            case 3:
                tap = MediaPlayer.create(context, R.raw.tap3);
                break;
            case 4:
                tap = MediaPlayer.create(context, R.raw.tap4);
                break;
        }
        tap.setVolume(.2f, .2f);
        tap.start();
    }

    public static void tap_back(Context context) {
        tap_back = MediaPlayer.create(context, R.raw.tap5);
        tap_back.release();
        tap_back = MediaPlayer.create(context, R.raw.tap5);
        tap_back.setVolume(.2f, .2f);
        tap_back.start();
    }
}
