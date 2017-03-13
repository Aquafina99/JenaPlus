package com.mood.jenaPlus;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Carlo on 2017-03-10.
 */

public class MainMPController {

    // Singleton Pattern Design
    MoodPlus moodPlus = null;

    // Constructor
    public MainMPController(MoodPlus aMoodPlus) {
        this.moodPlus = aMoodPlus;
    }

    public Participant getParticipant() {
        return moodPlus.getParticipant();
    }

    public void usingParticipant(String aName) {

        // Get the participant via elastic search
        moodPlus.getParticipantElastic(aName);
    }
    public void addMoodParticipant(String text, Boolean addLocation, LatLng location, String id,
                                   String social, String photo, String color) {
        moodPlus.addNewMood(text,addLocation,location,id,social,photo,color);
        moodPlus.notifyViews();
    }

    public void deleteMoodParticipant(Mood mood) {
        moodPlus.deleteMood(mood);
        moodPlus.notifyViews();
    }



}
