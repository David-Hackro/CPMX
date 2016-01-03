
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
        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(20.656326,-103.389519), 20.0f));

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
            //    arraylistSation.add(c.getString(0));
              //  Log.e("Resultados:: ", c.getString(6) + " / " + c.getString(7));//Obtener cada campo de la tabla,en posicion y tipo de dato
            }
            c.close();
        }



/*
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
        //   arraylist.add(new LatLng(20.6998812, -103.405454));*/

        arraylist.add(new LatLng(20.656326,-103.389519));
        arraylist.add(new LatLng(20.6561215,-103.389876));
        arraylist.add(new LatLng(20.6553334,-103.3912135));
        arraylist.add(new LatLng(20.6550324,-103.39175));
        arraylist.add(new LatLng(20.6549292,-103.391919));
        arraylist.add(new LatLng(20.6547316,-103.3922429));
        arraylist.add(new LatLng(20.6543463,-103.3929307));
        arraylist.add(new LatLng(20.6542612,-103.3930778));
        arraylist.add(new LatLng(20.6541476,-103.3932739));
        arraylist.add(new LatLng(20.6540448,-103.3934514));
        arraylist.add(new LatLng(20.6539935,-103.39354));
        arraylist.add(new LatLng(20.6539426,-103.3936279));
        arraylist.add(new LatLng(20.6538458,-103.3937951));
        arraylist.add(new LatLng(20.6537652,-103.39394));
        arraylist.add(new LatLng(20.6536595,-103.3941303));
        arraylist.add(new LatLng(20.6534983,-103.3944165));
        arraylist.add(new LatLng(20.6533516,-103.3946723));
        arraylist.add(new LatLng(20.6532587,-103.3948343));
        arraylist.add(new LatLng(20.6531279,-103.3950625));
        arraylist.add(new LatLng(20.6529032,-103.3954547));
        arraylist.add(new LatLng(20.6527341,-103.3952552));
        arraylist.add(new LatLng(20.6526735,-103.3951157));
        arraylist.add(new LatLng(20.6526253,-103.3950066));
        arraylist.add(new LatLng(20.652548,-103.3948679));
        arraylist.add(new LatLng(20.6524047,-103.394701));
        arraylist.add(new LatLng(20.6523358,-103.394622));
        arraylist.add(new LatLng(20.6522155,-103.3944695));
        arraylist.add(new LatLng(20.6521658,-103.3943781));
        arraylist.add(new LatLng(20.6521019,-103.3941016));
        arraylist.add(new LatLng(20.6519893,-103.3939072));
        arraylist.add(new LatLng(20.6518581,-103.3937624));
        arraylist.add(new LatLng(20.6517716,-103.3936909));
        arraylist.add(new LatLng(20.6516031,-103.3936479));
        arraylist.add(new LatLng(20.6513752,-103.3936102));
        arraylist.add(new LatLng(20.6512273,-103.3935998));
        arraylist.add(new LatLng(20.6511244,-103.3935926));
        arraylist.add(new LatLng(20.6509162,-103.393575));
        arraylist.add(new LatLng(20.6507018,-103.3935525));
        arraylist.add(new LatLng(20.6505995,-103.3935472));
        arraylist.add(new LatLng(20.6503934,-103.3935516));
        arraylist.add(new LatLng(20.6501906,-103.3935695));
        arraylist.add(new LatLng(20.6499582,-103.3935974));
        arraylist.add(new LatLng(20.6497795,-103.393619));
        arraylist.add(new LatLng(20.6495806,-103.3936472));
        arraylist.add(new LatLng(20.6493761,-103.3936763));
        arraylist.add(new LatLng(20.6491781,-103.3937046));
        arraylist.add(new LatLng(20.6488798,-103.3937471));
        arraylist.add(new LatLng(20.6482968,-103.3938615));
        arraylist.add(new LatLng(20.6481093,-103.39398));
        arraylist.add(new LatLng(20.6479988,-103.3939983));
        arraylist.add(new LatLng(20.6478369,-103.393971));
        arraylist.add(new LatLng(20.6478168,-103.3939417));
        arraylist.add(new LatLng(20.6477834,-103.3938032));
        arraylist.add(new LatLng(20.6479141,-103.3936627));
        arraylist.add(new LatLng(20.6479041,-103.3936159));
        arraylist.add(new LatLng(20.6478779,-103.3934941));
        arraylist.add(new LatLng(20.6478286,-103.3932598));
        arraylist.add(new LatLng(20.6478051,-103.3931472));




        int  i = 0;

            for (LatLng ll : arraylist) {
                polylineOptions.add(ll);
                //MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.user));
              //  myMap.addPolyline(polylineOptions);
               // MarkerOptions marker = new MarkerOptions().position(ll).title(arraylistSation.get(i));

              //  marker.icon(BitmapDescriptorFactory.fromResource(R.mipmap.station));

            //    myMap.addMarker(marker);
                ws.getLocalizacionRuta("");
                i++;
                //myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arraylist.get(i), 16.0f));
            }

            //Hilo principal


            Handler handler = new Handler(Looper.getMainLooper());

            handler = new Handler();
            polylineOptions = new PolylineOptions().width(4).color(Color.BLUE).geodesic(true);

            final Handler finalHandler = handler;
            final Runnable r = new Runnable() {
                int i = 0;

                public void run() {
                    Pinta(i);
                    finalHandler.postDelayed(this, 500);
                    i++;
                }
            };

            handler.postDelayed(r, 3000);


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