package com.mood.jenaPlus;

/**
 * This class is used for getting the correct png icon and the correct color associated\n
 * with the selected mood.
 * Created by Carlo on 2017-02-25.
 */
public class MoodIcon  {

    private String moodString;
    private String hexColor;

    /**
     * Gets color.
     *
     * @param icon the icon
     * @return the color
     */
    public String getColor(Integer icon) {
        switch (icon) {
            case 0: this.hexColor = "#FFCC80"; //orange
                break;
            case 1: this.hexColor = "#A5D6A7"; //green
                break;
            case 2: this.hexColor = "#BDBDBD"; //black
                break;
            case 3: this.hexColor = "#E1BEE7"; //purple
                break;
            case 4: this.hexColor = "#FFF176"; //yellow
                break;
            case 5: this.hexColor = "#FF8A80"; //red
                break;
            case 6: this.hexColor = "#BBDEFB"; //blue
                break;
            case 7: this.hexColor = "#F8BBD0"; // pink
                break;
            default: this.hexColor = "#A7FFEB"; // drak blue
                break;
        }
        return hexColor;
    }

    /**
     * Gets mood.
     *
     * @param iconNum the icon num
     * @return the mood
     */
    public String getMood(Integer iconNum) {
        switch (iconNum) {
            case 0: this.moodString = "surprised";
                break;
            case 1: this.moodString = "disgust";
                break;
            case 2: this.moodString = "fear";
                break;
            case 3: this.moodString = "confused";
                break;
            case 4: this.moodString = "happy";
                break;
            case 5: this.moodString = "angry";
                break;
            case 6: this.moodString = "sad";
                break;
            case 7: this.moodString = "shame";
                break;
            case 8: this.moodString = "annoyed";
                break;
        }

        return moodString;
    }
}
