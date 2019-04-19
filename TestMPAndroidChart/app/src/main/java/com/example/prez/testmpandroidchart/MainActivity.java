package com.example.prez.testmpandroidchart;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BarChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        chart = (BarChart)findViewById(R.id.graficoBarras);

        /*---------------Grafico de barras----------------*/
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        // gap of 2f
        entries.add(new BarEntry(5f, 70f));
        entries.add(new BarEntry(6f, 60f));
        entries.add(new BarEntry(7f, 60f));
        entries.add(new BarEntry(8f, 60f));
        entries.add(new BarEntry(9f, 60f));

        BarDataSet set = new BarDataSet(entries, "Ventas");

        set.setColors(new int[] {
                R.color.c1,
                R.color.c2,
                R.color.c3,
                R.color.c4,
                R.color.c5,
                R.color.c6,
                R.color.c7,
                R.color.c7,
                R.color.c7,
                R.color.c7
        }, MainActivity.this);

        BarData data = new BarData(set);


        // Añadirle el $ al precio
        data.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                DecimalFormat mFormat = new DecimalFormat("0");
                return "$"+mFormat.format(value);
            }
        });




        // poner los meses en las barras
        final String[] values = new String[] {"ene","feb","mar","abr","may","jun", "jul", "ago", "sep", "OCT"};

        XAxis xAxis = chart.getXAxis();
        xAxis.setTextSize(15);

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return values[(int)value];
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });


        // poner los $ en las barras
        YAxis yAxis = chart.getAxisLeft();
        yAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return "$"+new DecimalFormat("0").format(value);
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });





        /* no funca

        Legend l = chart.getLegend();
        l.setDrawInside(true);
        l.setFormSize(10f); // set the size of the legend forms/shapes
        l.setForm(Legend.LegendForm.CIRCLE); // set what type of form/shape should be used
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        l.setTextSize(12f);
        l.setTextColor(Color.BLACK);
        l.setXEntrySpace(5f); // set the space between the legend entries on the x-axis
        l.setYEntrySpace(5f); // set the space between the legend entries on the y-axis

        */




        data.setBarWidth(0.9f); // set custom bar width
        data.setValueTextSize(15);

        chart.setData(data);
        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.invalidate(); // refresh
        /*---------------Grafico de barras----------------*/


        /*---------------Grafico de barras en grupos----------------*/
        /*float[] group1 = {100f, 200f, 300f, 400f};
        float[] group2 = {200f, 400f, 600f, 800f};

        List<BarEntry> entriesGroup1 = new ArrayList<>();
        List<BarEntry> entriesGroup2 = new ArrayList<>();

// fill the lists
        for(int i = 0; i < group1.length; i++) {
            entriesGroup1.add(new BarEntry(i, group1[i]));
            entriesGroup2.add(new BarEntry(i, group2[i]));
        }

        BarDataSet set1 = new BarDataSet(entriesGroup1, "Ventas");
        BarDataSet set2 = new BarDataSet(entriesGroup2, "Cobros");




        float groupSpace = 0.06f;
        float barSpace = 0.02f; // x2 dataset
        float barWidth = 0.45f; // x2 dataset
// (0.02 + 0.45) * 2 + 0.06 = 1.00 -> interval per "group"

        BarData data = new BarData(set1, set2);
        data.setBarWidth(barWidth); // set the width of each bar
        chart.setData(data);
        chart.groupBars(1990f, groupSpace, barSpace); // perform the "explicit" grouping
        chart.invalidate(); // refresh*/

        /*---------------Grafico de barras en grupos----------------*/



        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }


}
