package com.mood.jenaPlus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static android.R.attr.entries;
import static android.media.CamcorderProfile.get;

public class GraphActivity extends AppCompatActivity implements MPView<MoodPlus> {

    ArrayList<Mood> moodArrayList = new ArrayList<Mood>();
    private UserMoodList myMoodList = new UserMoodList();
    private ArrayAdapter<Mood> adapter;
    String happy = "happy";
    String angry = "angry";
    String surprised = "surprised";
    String disgust = "disgust";
    String fear = "fear";
    String sad = "sad";
    String shame = "shame";
    String annoyed = "annoyed";
    String confused = "confused";

    int happyC = 0;
    int angryC = 0;
    int surprisedC = 0;
    int disgustC = 0;
    int fearC = 0;
    int sadC = 0;
    int shameC = 0;
    int annoyedC = 0;
    int confusedC = 0;

    BarChart chart ;
    List<BarEntry> BarEntry  = new ArrayList<>();
    ArrayList<String> BarEntryLabels = new ArrayList<>();
    BarDataSet set ;
    int mSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();

        chart = (BarChart) findViewById(R.id.BarChart);

        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY();

        AddValuesToBarEntryLabels();

        set = new BarDataSet(BarEntry, "BarDataSet");
        dataSets.add( (IBarDataSet) set);

        BarData b = new BarData(dataSets);
        chart.setData(b);
        chart.setFitBars(true);

        //chart.animateY(3000);
        chart.invalidate();

    }

    public void AddValuesToBARENTRY(){

        BarEntry.add(new BarEntry(0f, happyC));
        BarEntry.add(new BarEntry(1f, angryC));
        BarEntry.add(new BarEntry(2f, surprisedC));
        BarEntry.add(new BarEntry(3f, disgustC));
        BarEntry.add(new BarEntry(4f, fearC));
        BarEntry.add(new BarEntry(5f, sadC));
        BarEntry.add(new BarEntry(6f, shameC));
        BarEntry.add(new BarEntry(7f, annoyedC));
        BarEntry.add(new BarEntry(8f, confusedC));

    }

    public void AddValuesToBarEntryLabels(){

        BarEntryLabels.add(happy);
        BarEntryLabels.add(angry);
        BarEntryLabels.add(surprised);
        BarEntryLabels.add(disgust);
        BarEntryLabels.add(fear);
        BarEntryLabels.add(sad);
        BarEntryLabels.add(shame);
        BarEntryLabels.add(annoyed);
        BarEntryLabels.add(confused);

    }


    @Override
    public void update(MoodPlus moodPlus) {

    }

    @Override
    protected void onStart(){
        super.onStart();

        MainMPController mpController = MoodPlusApplication.getMainMPController();
        Participant participant = mpController.getParticipant();

        myMoodList = participant.getUserMoodList();
        moodArrayList = myMoodList.getUserMoodList();
        mSize = moodArrayList.size();


        for (int i = 0; i<mSize; i++) {
            if (moodArrayList.get(i).equals(happy)){
                happyC++;

            } else if(moodArrayList.get(i).equals(angry)) {
                angryC++;

            }else if(moodArrayList.get(i).equals(surprised)) {
                surprisedC++;

            }else if(moodArrayList.get(i).equals(disgust)) {
                disgustC++;

            }else if(moodArrayList.get(i).equals(fear)) {
                fearC++;

            }else if(moodArrayList.get(i).equals(sad)) {
                sadC++;

            }else if(moodArrayList.get(i).equals(shame)) {
                shameC++;

            }else if(moodArrayList.get(i).equals(annoyed)) {
                annoyedC++;

            }else if(moodArrayList.get(i).equals(confused)) {
                confusedC++;
            }

        }

    }
}
