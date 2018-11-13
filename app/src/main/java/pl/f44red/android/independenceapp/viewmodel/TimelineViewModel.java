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

    public TimelineViewModel(@NonNull Application application) {
        super(application);
        repository = new HistoryEventRepository(application);
    }

    public void insert(HistoryEvent event) {
        repository.insert(event);
    }

    public LiveData<List<HistoryEvent>> getAllEvents(String countryCode) {
        return repository.getAllEvents(countryCode);
    }
}
