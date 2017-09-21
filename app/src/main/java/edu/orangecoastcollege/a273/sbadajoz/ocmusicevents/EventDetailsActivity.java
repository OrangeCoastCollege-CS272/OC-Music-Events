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

    protected void goBackToList(View v) {
        finish();
    }

}
