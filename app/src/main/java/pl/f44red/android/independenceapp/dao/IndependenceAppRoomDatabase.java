package pl.f44red.android.independenceapp.dao;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;
import pl.f44red.android.independenceapp.model.HistoryEvent;

@Database(entities = {HistoryEvent.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class IndependenceAppRoomDatabase extends RoomDatabase {

    public abstract HistoryEventDao historyEventDao();

    public static volatile IndependenceAppRoomDatabase INSTANCE;

    public static IndependenceAppRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (IndependenceAppRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            IndependenceAppRoomDatabase.class, "word_database")
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new IndependenceAppDbPopulator(INSTANCE).execute();
        }
    };

}
