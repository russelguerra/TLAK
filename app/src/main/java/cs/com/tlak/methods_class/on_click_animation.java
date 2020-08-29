package cs.com.tlak.methods_class;

import android.animation.Animator;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class on_click_animation {

    public static void on_click(ImageView image_view, final ImageView image_mic) {

        Random r = new Random();
        int x;

        x = r.nextInt(10) + 1;
        switch (x) {
            case 1:
                YoYo.with(Techniques.Flash).duration(1500).withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        YoYo.with(Techniques.Wobble).duration(1500).repeat(0).playOn(image_mic);
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                        .repeat(0)
                        .playOn(image_view);
                break;
            case 2:
                YoYo.with(Techniques.Pulse).duration(1500).withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        YoYo.with(Techniques.Wobble).duration(1500).repeat(0).playOn(image_mic);
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                        .repeat(0)
                        .playOn(image_view);
                break;
            case 3:
                YoYo.with(Techniques.RubberBand).duration(1500).withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        YoYo.with(Techniques.Wobble).duration(1500).repeat(0).playOn(image_mic);
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                        .repeat(0)
                        .playOn(image_view);
                break;
            case 4:
                YoYo.with(Techniques.Shake).duration(1500).withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        YoYo.with(Techniques.Wobble).duration(1500).repeat(0).playOn(image_mic);
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                        .repeat(0)
                        .playOn(image_view);
                break;
            case 5:
                YoYo.with(Techniques.Swing).duration(1500).withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        YoYo.with(Techniques.Wobble).duration(1500).repeat(0).playOn(image_mic);
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                        .repeat(0)
                        .playOn(image_view);
                break;
            case 6:
                YoYo.with(Techniques.Wobble).duration(1500).withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        YoYo.with(Techniques.Wobble).duration(1500).repeat(0).playOn(image_mic);
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                        .repeat(0)
                        .playOn(image_view);
                break;
            case 7:
                YoYo.with(Techniques.Bounce).duration(1500).withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        YoYo.with(Techniques.Wobble).duration(1500).repeat(0).playOn(image_mic);
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                        .repeat(0)
                        .playOn(image_view);
                break;
            case 8:
                YoYo.with(Techniques.Tada).duration(1500).withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        YoYo.with(Techniques.Wobble).duration(1500).repeat(0).playOn(image_mic);
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                        .repeat(0)
                        .playOn(image_view);
                break;
            case 9:
                YoYo.with(Techniques.StandUp).duration(1500).withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        YoYo.with(Techniques.Wobble).duration(1500).repeat(0).playOn(image_mic);
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                        .repeat(0)
                        .playOn(image_view);
                break;
            case 10:
                YoYo.with(Techniques.Wave).duration(1500).withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        YoYo.with(Techniques.Wobble).duration(1500).repeat(0).playOn(image_mic);
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                        .repeat(0)
                        .playOn(image_view);
                break;
        }
    }
}
