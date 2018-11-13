package pl.f44red.android.independenceapp.view.timeline;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import pl.f44red.android.independenceapp.R;
import pl.f44red.android.independenceapp.model.HistoryEvent;
import pl.f44red.android.independenceapp.view.ctimelineview.TimelineRow;
import pl.f44red.android.independenceapp.view.ctimelineview.TimelineViewAdapter;
import pl.f44red.android.independenceapp.viewmodel.TimelineViewModel;

public class TimelineActivity extends AppCompatActivity {

    private TimelineViewModel timelineViewModel;
    private String countryCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        Intent intent = getIntent();
        countryCode = intent.getStringExtra("country");

        Toolbar myToolbar = findViewById(R.id.toolbar1);
        if (countryCode.equals("pl")) {
            myToolbar.setTitle(R.string.polish_timeline_title);
        } else {
            myToolbar.setTitle(R.string.lithuanian_timeline_title);
        }

        setSupportActionBar(myToolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        timelineViewModel = ViewModelProviders.of(this).get(TimelineViewModel.class);

        final ArrayAdapter<TimelineRow> adapter = new TimelineViewAdapter(this, 0, new ArrayList<TimelineRow>(),
                //if true, list will be sorted by date
                false);
        ListView listView = (ListView) findViewById(R.id.timeline_listView);
        listView.setAdapter(adapter);

        timelineViewModel.getAllEvents(countryCode).observe(this, new Observer<List<HistoryEvent>>() {
            @Override
            public void onChanged(@Nullable List<HistoryEvent> events) {
                //((TimelineViewAdapter) adapter).setRowDataList(getTimelineListForCountry(countryCode, events));
                adapter.clear();
                adapter.addAll(getTimelineListForCountry(countryCode, events));
            }
        });
    }

    private ArrayList<TimelineRow> getTimelineListForCountry(String countryCode, List<HistoryEvent> events) {
        ArrayList<TimelineRow> timelineRowsList = new ArrayList<>();
        TimelineRow row;
        int rowId = 0;

        for (HistoryEvent event : events) {
            row = new TimelineRow(rowId);
            row.setDate(event.getDate());
            row.setTitle(event.getTitle());
            row.setDescription(event.getDescription());
            if (countryCode.equals("pl"))
                row.setImage(BitmapFactory.decodeResource(getResources(), R.drawable.poland_ball));
            else
                row.setImage(BitmapFactory.decodeResource(getResources(), R.drawable.lithuania_ball));

            timelineRowsList.add(row);
            rowId++;
        }
        return timelineRowsList;
    }
}
