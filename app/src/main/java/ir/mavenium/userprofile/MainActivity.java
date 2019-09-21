package ir.mavenium.userprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    UserProfileCard userProfileCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userProfileCard = findViewById(R.id.user_profile_card);

        userProfileCard.getButtonOne().setOnClickListener(this);
        userProfileCard.getButtonTwo().setOnClickListener(this);
        userProfileCard.getButtonTre().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == userProfileCard.getButtonOne().getId() || v.getId() == userProfileCard.getButtonTwo().getId() || v.getId() == userProfileCard.getButtonTre().getId()) {
            Toast.makeText(this, ((AppCompatButton) v).getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
