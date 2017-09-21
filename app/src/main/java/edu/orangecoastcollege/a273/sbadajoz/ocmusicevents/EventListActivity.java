package edu.orangecoastcollege.a273.sbadajoz.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String title = MusicEvent.titles[position];
        String details = MusicEvent.details[position];

        Intent intent = new Intent(this, EventDetailsActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("details", details);

        Animation animation =
        startActivity(intent);
    }
}
