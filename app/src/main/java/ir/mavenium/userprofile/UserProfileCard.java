package ir.mavenium.userprofile;

import android.animation.Animator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

public class UserProfileCard extends RelativeLayout implements View.OnClickListener {

    private static final int REVEAL_DURATION = 700;

    View rootView;

    private RelativeLayout layoutReveal;
    private AppCompatImageView coverImage;
    private LinearLayoutCompat layoutButtons;
    private AppCompatButton buttonOne, buttonTwo, buttonTre;
    private AppCompatImageView userImage;
    private AppCompatImageView toggleImage;
    private AppCompatTextView userDescription;

    public UserProfileCard(Context context) {
        super(context);
        init(context);
    }

    public UserProfileCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        rootView = inflate(context, R.layout.layout_user_profile, this);

        layoutReveal = rootView.findViewById(R.id.layout_user_profile_reveal_relativeLayout);
        coverImage = rootView.findViewById(R.id.layout_user_profile_cover_image);
        layoutButtons = rootView.findViewById(R.id.layout_user_profile_buttons_linearLayoutCompat);
        buttonOne = rootView.findViewById(R.id.layout_user_profile_button_one);
        buttonTwo = rootView.findViewById(R.id.layout_user_profile_button_two);
        buttonTre = rootView.findViewById(R.id.layout_user_profile_button_tre);
        userImage = rootView.findViewById(R.id.user_profile_image);
        toggleImage = rootView.findViewById(R.id.user_profile_toggle);
        userDescription = rootView.findViewById(R.id.user_profile_description);

        toggleImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.user_profile_toggle) {
            int centerX = (toggleImage.getRight() + toggleImage.getLeft()) / 2;
            int centerY = (toggleImage.getBottom() + toggleImage.getTop()) / 2;
            float radius = (float) Math.hypot(centerX - coverImage.getLeft(), coverImage.getHeight());
            displayButtons(centerX, centerY, radius);
        }

    }

    public void displayButtons(int centerX, int centerY, float radius) {
        if (layoutReveal.getVisibility() != VISIBLE) {
            toggleImage.setImageResource(R.drawable.ic_close_24dp);
            toggleImage.setBackgroundResource(R.drawable.toggle_close_bg);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Animator animator = ViewAnimationUtils.createCircularReveal(layoutReveal, centerX, centerY, 0, radius);
                animator.setDuration(REVEAL_DURATION);
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        layoutReveal.setVisibility(VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        layoutButtons.setVisibility(VISIBLE);
                        Animation fade_in = AnimationUtils.loadAnimation(rootView.getContext() ,R.anim.fade_in);
                        layoutButtons.startAnimation(fade_in);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animator.start();
            } else {
                Animation fade_in = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
                fade_in.setDuration(REVEAL_DURATION * 3 / 4);
                fade_in.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        layoutReveal.setVisibility(VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        layoutButtons.setVisibility(VISIBLE);
                        Animation fade_in = AnimationUtils.loadAnimation(rootView.getContext() ,R.anim.fade_in);
                        fade_in.setDuration(REVEAL_DURATION * 3 / 8);
                        layoutButtons.startAnimation(fade_in);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                layoutReveal.startAnimation(fade_in);
            }
        } else {
            toggleImage.setImageResource(R.drawable.ic_menu_white_24dp);
            toggleImage.setBackgroundResource(R.drawable.toggle_normal_bg);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Animator animator = ViewAnimationUtils.createCircularReveal(layoutReveal, centerX, centerY, radius, 0);
                animator.setDuration(700 / 2);
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        layoutReveal.setVisibility(GONE);
                        layoutButtons.setVisibility(GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animator.start();
            } else {
                Animation fade_out = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);
                fade_out.setDuration(REVEAL_DURATION / 2);
                fade_out.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        layoutReveal.setVisibility(GONE);
                        layoutButtons.setVisibility(GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                layoutReveal.startAnimation(fade_out);
            }
        }
    }

    public AppCompatImageView getCoverImage() {
        return coverImage;
    }

    public AppCompatButton getButtonOne() {
        return buttonOne;
    }

    public AppCompatButton getButtonTwo() {
        return buttonTwo;
    }

    public AppCompatButton getButtonTre() {
        return buttonTre;
    }

    public AppCompatImageView getUserImage() {
        return userImage;
    }

    public AppCompatTextView getUserDescription() {
        return userDescription;
    }
}
