package hackro.com.att.Activities;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import hackro.com.att.R;

public class Main2Activity extends AppCompatActivity {

    private GoogleMap myMap;
    private long ms = 0;//milisegundos
    private long splashTime = 13000;//tiempo de duracion del splashScrenn en milisegundos
    private boolean splashActive = true;
    static ArrayList<LatLng> lista;
    ArrayList<LatLng> arraylist;
    PolylineOptions polylineOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //   new LongOperation().execute("");
        //  PolylineOptions options =
        myMap = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();


        myMap.setMyLocationEnabled(true);

        polylineOptions = new PolylineOptions();


        myMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(17.547789, -99.532435)));

        arraylist = new ArrayList<LatLng>();

        arraylist.add(new LatLng(17.547789, -99.532435));
        arraylist.add(new LatLng(19.1539267, -103.0220045));
        arraylist.add(new LatLng(20.6998812, -103.405454));

        Handler handler = new Handler(Looper.getMainLooper());

        handler = new Handler();

        final Handler finalHandler = handler;
        final Runnable r = new Runnable() {
            public void run() {
                Pinta();
                finalHandler.postDelayed(this, 1000);
            }
        };

        handler.postDelayed(r, 3000);

    }

public void Pinta()
{
    for (LatLng ll : arraylist) {
        polylineOptions.add(ll);
        myMap.addPolyline(polylineOptions);
    }
}

}

