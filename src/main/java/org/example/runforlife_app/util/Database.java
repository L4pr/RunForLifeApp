package org.example.runforlife_app.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {

    private static Event[] events = new Event[3];

    public static Event getEvent(int i) {
        return events[i];
    }

    public static Event getCurrentEvent() {
        return events[currentEvent];
    }

    public static void addEvent(int i) {
        events[i] = new Event("event" + i, FXCollections.observableArrayList(), FXCollections.observableArrayList());
    }

    public static void deleteEvent(int i) {
        events[i] = null;
    }

    public static int currentEvent = 0;


}
