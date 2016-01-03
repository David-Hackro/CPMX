
package hackro.com.att.Activities;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import hackro.com.att.DataBase.BaseManager;
import hackro.com.att.R;
import hackro.com.att.WebServices;

public class Main2Activity extends AppCompatActivity {

    private GoogleMap myMap;
    private long ms = 0;//milisegundos
    private long splashTime = 13000;//tiempo de duracion del splashScrenn en milisegundos
    private boolean splashActive = true;
    static ArrayList<LatLng> lista;
    ArrayList<LatLng> arraylist;
    ArrayList<String > arraylistSation;
    ArrayList<String> arraylistStations;

    PolylineOptions polylineOptions;
    private BaseManager db;
    private WebServices ws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db = new BaseManager(getApplicationContext());

        ws = new WebServices(getApplicationContext());
        //   new LongOperation().execute("");
        //  PolylineOptions options =
        myMap = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();
        WebServices ws = new WebServices(getApplicationContext());
        ws.getRuta("");

        myMap.setMyLocationEnabled(true);


        polylineOptions = new PolylineOptions().width(5).color(Color.RED).geodesic(true);


        // myMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(20.6766031, -103.4182771)));
        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(20.6653001, -103.3950384), 16.0f));

        MarkerOptions options = new MarkerOptions();
        options.anchor(10, 10);


        arraylist = new ArrayList<LatLng>();
        arraylistSation = new ArrayList<String>();


        Cursor cursor = db.GetAllDatesPolylines();
        Cursor c = cursor;
        String[] data;
        if (c != null) {//mientras el cursor sea distinto a null
            while (c.moveToNext()) {
                  //  arraylist.add(new LatLng(Float.valueOf(c.getString(6)),Float.valueOf(c.getString(7))));
                arraylistSation.add(c.getString(0));
              //  Log.e("Resultados:: ", c.getString(6) + " / " + c.getString(7));//Obtener cada campo de la tabla,en posicion y tipo de dato
            }
            c.close();
        }



        arraylist.add(new LatLng(20.6653001, -103.3950384));
        arraylist.add(new LatLng(20.6653453, -103.3948668));
        arraylist.add(new LatLng(20.665147, -103.3943893));
        arraylist.add(new LatLng(20.665147, -103.3943893));
        arraylist.add(new LatLng(20.6646426, -103.3942874));
        arraylist.add(new LatLng(20.6646426, -103.3942874));
        arraylist.add(new LatLng(20.6618418, -103.3959611));
        arraylist.add(new LatLng(20.6618418, -103.3959611));
        arraylist.add(new LatLng(20.6618418, -103.3959611));
        arraylist.add(new LatLng(20.6586996, -103.3982785));
        arraylist.add(new LatLng(20.6586996, -103.3982785));
        arraylist.add(new LatLng(20.6586996, -103.3982785));
        arraylist.add(new LatLng(20.6586996, -103.3982785));
        arraylist.add(new LatLng(20.6586996, -103.3982785));
        arraylist.add(new LatLng(20.6586996, -103.3982785));
        arraylist.add(new LatLng(20.6586996, -103.3982785));
        arraylist.add(new LatLng(20.6582981, -103.3955105));
        arraylist.add(new LatLng(20.6582981, -103.3955105));
        arraylist.add(new LatLng(20.6568224, -103.3948668));
        arraylist.add(new LatLng(20.6562401, -103.394105));
        arraylist.add(new LatLng(20.6562401, -103.394105));
        arraylist.add(new LatLng(20.6562401, -103.394105));
        arraylist.add(new LatLng(20.6562401, -103.394105));
        arraylist.add(new LatLng(20.6562401, -103.394105));
        arraylist.add(new LatLng(20.6551659, -103.3945235));
        //  arraylist.add(new LatLng(19.1539267, -103.0220045));
        //   arraylist.add(new LatLng(20.6998812, -103.405454));
int  i = 0;

            for (LatLng ll : arraylist) {
                polylineOptions.add(ll);
                //MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.user));
              //  myMap.addPolyline(polylineOptions);
                MarkerOptions marker = new MarkerOptions().position(ll).title(arraylistSation.get(i));

                marker.icon(BitmapDescriptorFactory.fromResource(R.mipmap.station));

                myMap.addMarker(marker);
                ws.getLocalizacionRuta("");
                i++;
                //myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arraylist.get(i), 16.0f));
            }

            //Hilo principal


            Handler handler = new Handler(Looper.getMainLooper());

            handler = new Handler();
            polylineOptions = new PolylineOptions().width(1).color(Color.BLUE).geodesic(true);

            final Handler finalHandler = handler;
            final Runnable r = new Runnable() {
                int i = 0;

                public void run() {
                    Pinta(i);
                    finalHandler.postDelayed(this, 500);
                    i++;
                }
            };

            handler.postDelayed(r, 1000);


    }

    public void Pinta(int i)
    {
        if(arraylist.size()> i){


            polylineOptions.add(arraylist.get(i));
            //MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.user));
            myMap.addPolyline(polylineOptions);

            //   ws.getLocalizacionRuta("");

            //myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arraylist.get(i), 16.0f));
        }

    }
}