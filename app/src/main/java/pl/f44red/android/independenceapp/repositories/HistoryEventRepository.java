package pl.f44red.android.independenceapp.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import pl.f44red.android.independenceapp.dao.HistoryEventDao;
import pl.f44red.android.independenceapp.dao.IndependenceAppRoomDatabase;
import pl.f44red.android.independenceapp.model.HistoryEvent;

public class HistoryEventRepository {

    private HistoryEventDao historyEventDao;

    public HistoryEventRepository(Application application) {
        IndependenceAppRoomDatabase db = IndependenceAppRoomDatabase.getDatabase(application);
        historyEventDao = db.historyEventDao();
    }

    public void insert(HistoryEvent event) {
        new InsertAsyncTask(historyEventDao).execute(event);
    }

    // getters & setters

    public LiveData<List<HistoryEvent>> getAllEvents(String countryCode) {
        return historyEventDao.getAllEvents(countryCode);
    }

    // static internal classes

    private static class InsertAsyncTask extends AsyncTask<HistoryEvent, Void, Void> {

        private HistoryEventDao asyncTaskDao;

        InsertAsyncTask(HistoryEventDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final HistoryEvent... events) {
            asyncTaskDao.insert(events[0]);
            return null;
        }
    }
}
