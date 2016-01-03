package hackro.com.att.Activities;

import android.database.Cursor;
import android.graphics.Bitmap;
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
    PolylineOptions polylineOptions;
    private BaseManager db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db = new BaseManager(getApplicationContext());

        //   new LongOperation().execute("");
        //  PolylineOptions options =
        myMap = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();
        WebServices ws = new WebServices(getApplicationContext());
        ws.QueryGet("");

        myMap.setMyLocationEnabled(true);

        polylineOptions = new PolylineOptions();

       // myMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(20.6766031, -103.4182771)));
        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(20.6766031, -103.4182771), 12.0f));

        MarkerOptions options = new MarkerOptions();
        options.anchor(10,10);


        arraylist = new ArrayList<LatLng>();

/*
        Cursor cursor = db.GetAllDatesPolylines();
        Cursor c = cursor;
        String[] data;
        if (c != null) {//mientras el cursor sea distinto a null
            while (c.moveToNext()) {
                arraylist.add(new LatLng(Float.valueOf(c.getString(6)),Float.valueOf(c.getString(7))));
              //  Log.e("Resultados:: ", c.getString(6) + " / " + c.getString(7));//Obtener cada campo de la tabla,en posicion y tipo de dato
            }
            c.close();
        }

*/


        arraylist.add(new LatLng(20.6766031,-103.4182771));
        arraylist.add(new LatLng(20.6766031,-103.4182771));
        arraylist.add(new LatLng(20.6766031,-103.4182771));
        arraylist.add(new LatLng(20.6766031,-103.4182771));
        arraylist.add(new LatLng(20.6743847,-103.412902));
        arraylist.add(new LatLng(20.6717548,-103.4105631));
        arraylist.add(new LatLng(20.6717548,-103.4105631));
        arraylist.add(new LatLng(20.6717548,-103.4105631));
        arraylist.add(new LatLng(20.6717548,-103.4105631));
        arraylist.add(new LatLng(20.6698676,-103.4044047));
        arraylist.add(new LatLng(20.6683619,-103.40198));
        arraylist.add(new LatLng(20.6683619,-103.40198));
        arraylist.add(new LatLng(20.6651696,-103.3940836));
        arraylist.add(new LatLng(20.6651696,-103.3940836));
        arraylist.add(new LatLng(20.6617967,-103.3867773));
        arraylist.add(new LatLng(20.6582329,-103.3815201));
        arraylist.add(new LatLng(20.6565262,-103.3771642));
      //  arraylist.add(new LatLng(19.1539267, -103.0220045));
     //   arraylist.add(new LatLng(20.6998812, -103.405454));

        Handler handler = new Handler(Looper.getMainLooper());

        handler = new Handler();

        final Handler finalHandler = handler;
        final Runnable r = new Runnable() {
            int i = 0;
            public void run() {
                Pinta(i);
                finalHandler.postDelayed(this, 2000);
                i++;
            }
        };

        handler.postDelayed(r, 19000);

    }

public void Pinta(int i)
{
    if(arraylist.size()> i){
        polylineOptions.add(arraylist.get(i));
        myMap.addPolyline(polylineOptions);
    }

   /* int tamaño arraylist.size();
    for (LatLng ll : arraylist) {
        polylineOptions.add(ll);
        myMap.addPolyline(polylineOptions);
    }*/
}

}

