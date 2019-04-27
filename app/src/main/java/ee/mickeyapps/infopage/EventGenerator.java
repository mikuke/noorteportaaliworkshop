package ee.mickeyapps.infopage;

import java.util.ArrayList;
import java.util.List;

public class EventGenerator {

    public static List<Event> generateEvents() {
        List<Event> events = new ArrayList<>();

        events.add(new Event("Miki Mukiver", "20.08.1996", "Orissaare"));
        events.add(new Event("Sander Sepp", "12.05.2080", "Tallinn"));
        events.add(new Event("Johannes Ojala", "15.12.2004", "Kostivere"));
        events.add(new Event("Juku", "20.11.2999", "Tallinn"));
        events.add(new Event("Krahv WonSlibenbach", "07.03.1879", "Raidvere"));
        events.add(new Event("Kirjstjan", "30.10.2001", "Raasiku"));
        events.add(new Event("Juss Joosep", "24.04.2002", "Käina"));
        events.add(new Event("Heino", "13.05.2001", "Saaremaa"));
        events.add(new Event("Ait Olev", "01.04.2019", "Jõgeva"));
        events.add(new Event("Georg", "29.11.2002", "Käina"));
        events.add(new Event("Riho", "01.01.2001", "Tallinn"));
        events.add(new Event("Kassu", "02.08.2007", "Tallinn"));

        return events;
    }
}
