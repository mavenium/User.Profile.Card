package ir.mavenium.userprofile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

public class UserProfileCard extends RelativeLayout implements View.OnClickListener {

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
            Toast.makeText(getContext(), "Click", Toast.LENGTH_SHORT).show();
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
