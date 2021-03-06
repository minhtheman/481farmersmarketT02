package ca.ucalgary.farmersmarketapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Whoosp on 2016-11-25.
 */

public class customInventoryAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<inventory_item> list = new ArrayList<inventory_item>();
    private Context context;
    private inventory_item_screen inventoryItemScreen;

    public customInventoryAdapter(inventory_item_screen inventoryItemScreen, ArrayList<inventory_item> list, Context context){
        this.list = list;
        this.context = context;
        this.inventoryItemScreen = inventoryItemScreen;
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
        //jfor simplicity returning the position
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_inventory_listview, null);
        }
        TextView text1 = (TextView) view.findViewById(R.id.text1);
        text1.setText(list.get(position).getName());

        TextView text1Val = (TextView) view.findViewById(R.id.text1Val);
        text1Val.setText(String.valueOf(list.get(position).getQuantity()));

        final Button temperatureButton = (Button)view.findViewById(R.id.tempAddButton);

        temperatureButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
                //basically make a new layout called "activity_popup_temperature_log.xml"
                //have it so that we can add some text (numbers) and a submit button.
                //the submit button should close the window.
                //i can make the code to actually add the temperature log.
                //good luck!
                //(p.s. you may need to import some stuff and make variables, just do it like the customEmployeeAdapter.java)

                //do something
                //list.get(position).addRole("Person"); //Implement role adding or removing
                //notifyDataSetChanged();

                LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.activity_popup_inventory_temperature, null);
                final Button modifyTemperature = (Button)popupView.findViewById(R.id.modTemperature);
                modifyTemperature.setEnabled(false);
                modifyTemperature.getBackground().setAlpha(0);

                makeGraph(popupView,position, temperatureButton);

                final PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setFocusable(true);
                popupWindow.update();


                final EditText temperatureReading = (EditText) popupView.findViewById(R.id.temperatureReading);
                temperatureReading.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND){
                            int t = Integer.parseInt(temperatureReading.getText().toString());
                            handled = true;
                            list.get(position).addTempature(t);

                        }
                        if (handled == false){
                            int t = Integer.parseInt(temperatureReading.getText().toString());
                            //handled = true;
                            list.get(position).addTempature(t);
                            modifyTemperature.setEnabled(true);
                            modifyTemperature.getBackground().setAlpha(255);
                        }
                        return handled;
                    }
                });

                modifyTemperature.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        makeGraph(popupView, position, temperatureButton);
                    }});

                Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
                btnDismiss.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        popupWindow.dismiss();
                    }});

                popupWindow.showAtLocation(temperatureButton, Gravity.CENTER, 0, 40);
                //popupWindow.showAsDropDown(editRoleButton, 50, -30);

            }});

                //list.get(position).addTempature(100);
                //notifyDataSetChanged();

        return view;
    }

    public void makeGraph(View popupView, int position, Button temperatureButton){
        GraphView thisGraph = (GraphView) popupView.findViewById(R.id.itemGraph);
        DataPoint[] DataPointList = new DataPoint[list.get(position).getLogSize()];
        for (int i=0; i<list.get(position).getLogSize(); i++){
            DataPoint tempInfo = new DataPoint(list.get(position).dateAt(i), (double) list.get(position).tempAt(i));
            DataPointList[i] = tempInfo;
        }
        LineGraphSeries<DataPoint> tempLog = new LineGraphSeries<>(DataPointList);
        tempLog.setDrawDataPoints(true);
        tempLog.setDataPointsRadius(10);
        Paint customPaint = new Paint();
        customPaint.setStyle(Paint.Style.STROKE);
        customPaint.setStrokeWidth(1);
        customPaint.setPathEffect(new DashPathEffect(new float[]{2, 3}, 0));
        tempLog.setCustomPaint(customPaint);

        thisGraph.addSeries(tempLog);


        thisGraph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(temperatureButton.getContext(), new SimpleDateFormat("HH:mm")));
        thisGraph.getGridLabelRenderer().setNumHorizontalLabels(4);
        thisGraph.getGridLabelRenderer().setNumVerticalLabels(4);

        thisGraph.getViewport().setYAxisBoundsManual(true);
        thisGraph.getViewport().setMinY(0);
        thisGraph.getViewport().setMaxY(15);

        thisGraph.getViewport().setXAxisBoundsManual(true);
        thisGraph.getViewport().setMinX(new Date().getTime() - TimeUnit.MINUTES.toMillis(30));
        thisGraph.getViewport().setMaxX(new Date().getTime());
        thisGraph.getGridLabelRenderer().setHumanRounding(false);

        thisGraph.getViewport().setScrollable(true);
        thisGraph.getViewport().setScrollableY(true);
    }
}