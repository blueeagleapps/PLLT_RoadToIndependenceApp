package pl.f44red.android.independenceapp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pl.f44red.android.independenceapp.R;
import pl.f44red.android.independenceapp.view.timeline.TimelineActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPolishTimeline(View view) {
        Intent intent = new Intent(this, TimelineActivity.class);
        intent.putExtra("country", "pl");
        startActivity(intent);
    }

    public void startLithuanianTimeline(View view) {
        Intent intent = new Intent(this, TimelineActivity.class);
        intent.putExtra("country", "lt");
        startActivity(intent);
    }
}
