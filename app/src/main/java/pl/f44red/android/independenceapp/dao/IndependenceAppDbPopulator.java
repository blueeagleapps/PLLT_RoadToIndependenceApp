package pl.f44red.android.independenceapp.dao;

import android.os.AsyncTask;

import java.util.Calendar;
import java.util.GregorianCalendar;

import pl.f44red.android.independenceapp.model.HistoryEvent;

class IndependenceAppDbPopulator extends AsyncTask<Void, Void, Void> {

    private final HistoryEventDao dao;

    IndependenceAppDbPopulator (IndependenceAppRoomDatabase db) {
        dao = db.historyEventDao();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        //todo - remove that if database is completed (final set of data hardcoded below
        dao.deleteAll();

        if (dao.countRows() == 0) {

            ////////////////////////////// POLISH ROAD TO INDEPENDENCE /////////////////////////////

            HistoryEvent event = new HistoryEvent("USSR invasion on Poland", "pl");
            event.setDate(new GregorianCalendar(1939, Calendar.SEPTEMBER, 17).getTime());
            event.setDescription("The Soviet troops attacked the Polish border guards from the east, sixteen days after Germany invaded Poland from the west.");
            dao.insert(event);

            event = new HistoryEvent("Act of Independence of Poland", "pl");
            event.setDate(new GregorianCalendar(1918, Calendar.NOVEMBER, 11).getTime());
            event.setDescription("The restoration of Poland's independence was gradual. The date of November 11 is the one on which Marshal Józef Piłsudski assumed control of Poland.");
            dao.insert(event);

            event = new HistoryEvent("Act of Independence of Poland 2", "pl");
            event.setDate(new GregorianCalendar(1918, Calendar.NOVEMBER, 11).getTime());
            event.setDescription("The restoration of Poland's independence was gradual. The date of November 11 is the one on which Marshal Józef Piłsudski assumed control of Poland.");
            dao.insert(event);

            event = new HistoryEvent("Act of Independence of Poland 3", "pl");
            event.setDate(new GregorianCalendar(1918, Calendar.NOVEMBER, 11).getTime());
            event.setDescription("The restoration of Poland's independence was gradual. The date of November 11 is the one on which Marshal Józef Piłsudski assumed control of Poland.");
            dao.insert(event);

            event = new HistoryEvent("Act of Independence of Poland 4", "pl");
            event.setDate(new GregorianCalendar(1918, Calendar.NOVEMBER, 11).getTime());
            event.setDescription("The restoration of Poland's independence was gradual. The date of November 11 is the one on which Marshal Józef Piłsudski assumed control of Poland.");
            dao.insert(event);

            ////////////////////////////// LITHUANIAN ROAD TO INDEPENDENCE /////////////////////////////

            event = new HistoryEvent("Act of Independence of Lithuania", "lt");
            event.setDate(new GregorianCalendar(1918, Calendar.FEBRUARY, 16).getTime());
            event.setDescription("Act of 16 February was signed by the Council of Lithuania, proclaiming the restoration of an Independent State of Lithuania, governed by democratic principles.");
            dao.insert(event);

            event = new HistoryEvent("USSR invasion on Lithuania", "lt");
            event.setDate(new GregorianCalendar(1940, Calendar.JUNE, 15).getTime());
            event.setDescription("The Soviet troops attacked the Latvian border guards at Masļenki. In a matter of days around 500,000 Soviet Red Army troops occupied the three Baltic states.");
            dao.insert(event);

            event = new HistoryEvent("USSR invasion on Lithuania 2", "lt");
            event.setDate(new GregorianCalendar(1940, Calendar.JUNE, 15).getTime());
            event.setDescription("The Soviet troops attacked the Latvian border guards at Masļenki. In a matter of days around 500,000 Soviet Red Army troops occupied the three Baltic states.");
            dao.insert(event);

            event = new HistoryEvent("USSR invasion on Lithuania 3", "lt");
            event.setDate(new GregorianCalendar(1940, Calendar.JUNE, 15).getTime());
            event.setDescription("The Soviet troops attacked the Latvian border guards at Masļenki. In a matter of days around 500,000 Soviet Red Army troops occupied the three Baltic states.");
            dao.insert(event);

        }

        return null;
    }

}
