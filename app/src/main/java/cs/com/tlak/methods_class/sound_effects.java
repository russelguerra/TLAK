package cs.com.tlak.methods_class;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import cs.com.tlak.R;

public class sound_effects {
    private AudioAttributes audioAttributes;
    private int SOUND_POOL_MAX = 6;

    SoundPool soundPool;
    public static int tap, tap_back;

    public sound_effects(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(SOUND_POOL_MAX)
                    .build();
        } else {
            soundPool = new SoundPool(SOUND_POOL_MAX, AudioManager.STREAM_MUSIC, 0);
        }

        tap = soundPool.load(context, R.raw.tap1, 1);
        tap_back = soundPool.load(context, R.raw.tap5, 1);
    }


    public void play_tap() {
        soundPool.play(tap, 1.0f, 1.0f, 1, 0, 1.0f);
    }
}
