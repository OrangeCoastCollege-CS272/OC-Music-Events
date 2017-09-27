package edu.orangecoastcollege.a273.sbadajoz.ocmusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {

    /**
     * Called when the activity is starting.
     * Grabs the StringExtras from the intent which called this activity
     *
     * Puts strings into TextViews
     *
     * Uses {@link AssetManager} to fetch photo from assets and insert into imageView
     *
     * @param savedInstanceState Saved state from last run occurrence
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String details = intent.getStringExtra("details");

        TextView eventTitleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView eventDetailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);
        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);

        eventTitleTextView.setText(title);
        eventDetailsTextView.setText(details);

        AssetManager assetManager = getAssets();
        String imageFileName = title.replaceAll(" ", "") + ".jpeg";
        try {
            InputStream inputStream = assetManager.open(imageFileName);
            Drawable drawable = Drawable.createFromStream(inputStream, title);
            eventImageView.setImageDrawable(drawable);
        } catch (IOException e) {
            Log.e("OC Music Events", "Error loading image: " + imageFileName, e);
        }

    }

    /**
     * Returns back to previous Activity
     * @param v Clicked view
     */
    protected void goBackToList(View v) {
        finish();
    }

}
