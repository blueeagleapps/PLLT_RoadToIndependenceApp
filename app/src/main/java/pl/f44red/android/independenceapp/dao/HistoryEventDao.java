package pl.f44red.android.independenceapp.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import pl.f44red.android.independenceapp.model.HistoryEvent;

@Dao
public interface HistoryEventDao {

    @Insert
    void insert(HistoryEvent historyEvent);

    @Query("DELETE FROM history_event_table")
    void deleteAll();

    @Query("SELECT * from history_event_table WHERE country_code LIKE :countryCode ORDER BY date DESC")
    LiveData<List<HistoryEvent>> getAllEvents(String countryCode);

    @Query("SELECT COUNT(*) FROM history_event_table")
    int countRows();

}
