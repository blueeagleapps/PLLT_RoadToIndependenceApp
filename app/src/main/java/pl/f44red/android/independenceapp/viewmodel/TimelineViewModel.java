package pl.f44red.android.independenceapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import pl.f44red.android.independenceapp.model.HistoryEvent;
import pl.f44red.android.independenceapp.repositories.HistoryEventRepository;

public class TimelineViewModel extends AndroidViewModel {

    private HistoryEventRepository repository;
    private LiveData<List<HistoryEvent>> eventsPl;
    private LiveData<List<HistoryEvent>> eventsLt;

    public TimelineViewModel(@NonNull Application application) {
        super(application);
        repository = new HistoryEventRepository(application);
        // viewmodel will hold those values until changed in db despite of timeline activity lifecycle stage
        eventsPl = repository.getAllEvents("pl");
        eventsLt = repository.getAllEvents("lt");
    }

    public void insert(HistoryEvent event) {
        repository.insert(event);
    }

    public LiveData<List<HistoryEvent>> getAllEvents(String countryCode) {
        if (countryCode.equals("pl"))
            return eventsPl;
        else
            return eventsLt;
    }
}
