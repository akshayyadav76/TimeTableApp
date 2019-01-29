package across.timetableapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
SeekBar seekBar;
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        listView = findViewById(R.id.list);

        seekBar.setMax(20);
        seekBar.setProgress(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                int min = 1;
                int table;
                if (progress < min)
                {
                    table = min;
                    seekBar.setProgress(min);
                } else
                    table = progress;
                genratetimetable(table);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    void genratetimetable(int table)
    {
        int i;
        ArrayList<String>timetables=new ArrayList<String>();
        for(i=1;i<=10;i++)
        {
            timetables.add(Integer.toString(i* table));
        }

        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item,timetables);

        listView.setAdapter(arrayAdapter);
    }
}