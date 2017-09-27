package edu.orangecoastcollege.a273.sbadajoz.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends ListActivity {

    /**
     * Creates the activity view and connects list to list adapter
     * @param savedInstanceState Saved state from last run occurrence
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));
    }

    /**
     * Method which handles a click of a ListView item
     * @param l ListView where click happened
     * @param v View that was clicked within the ListView
     * @param position The position of the view in the list
     * @param id The row id of the item that was clicked
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String title = MusicEvent.titles[position];
        String details = MusicEvent.details[position];

        Intent intent = new Intent(this, EventDetailsActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("details", details);

        startActivity(intent);
    }
}
