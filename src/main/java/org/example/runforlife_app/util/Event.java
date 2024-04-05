package org.example.runforlife_app.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;


public class Event {
    private String eventName;
    private ObservableList<Runner> runnerData;
    private ObservableList<Sponsor> sponsorData;
    private String goedDoel;
    private LocalDate datumEvent;
    private LocalDate datumGegevensVerwijderen;

    public Event(String eventName, ObservableList<Runner> runnerData, ObservableList<Sponsor> sponsorData) {
        this.eventName = eventName;
        this.runnerData = runnerData;
        this.sponsorData = sponsorData;
    }

    public String getGoedDoel() {
        return goedDoel;
    }

    public void setGoedDoel(String goedDoel) {
        this.goedDoel = goedDoel;
    }

    public LocalDate getDatumEvent() {
        return datumEvent;
    }

    public void setDatumEvent(LocalDate datumEvent) {
        this.datumEvent = datumEvent;
    }

    public LocalDate getDatumGegevensVerwijderen() {
        return datumGegevensVerwijderen;
    }

    public void setDatumGegevensVerwijderen(LocalDate datumGegevensVerwijderen) {
        this.datumGegevensVerwijderen = datumGegevensVerwijderen;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public ObservableList<Runner> getRunnerData() {
        return runnerData;
    }

    public ObservableList<Sponsor> getSponsorData() {
        return sponsorData;
    }

    public void setRunnerData(ObservableList<Runner> runnerData) {
        this.runnerData = runnerData;
    }
}
