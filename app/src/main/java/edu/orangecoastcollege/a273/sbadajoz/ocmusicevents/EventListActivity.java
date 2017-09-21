package edu.orangecoastcollege.a273.sbadajoz.ocmusicevents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

public class EventListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));
    }


}
