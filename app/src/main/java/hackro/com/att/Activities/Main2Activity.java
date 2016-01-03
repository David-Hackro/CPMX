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
    static   ArrayList<LatLng> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);





        new LongOperation().execute("");
      //  PolylineOptions options = new PolylineOptions().width(5).color(Color.BLUE).geodesic(true);

    }


    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            lista = new ArrayList<LatLng>();

            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable(){
                @Override
                public void run() {
                    myMap = ((SupportMapFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.map)).getMap();


                    myMap.setMyLocationEnabled(true);

                    final PolylineOptions polylineOptions = new PolylineOptions();

      /*  myMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(17.547789, -99.532435))  // Guerrero
                .add(new LatLng(19.1539267, -103.0220045))  // Michoacan
                .add(new LatLng(20.6998812, -103.405454)));  // Guadalajara*/


                    myMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(17.547789, -99.532435)));
                    lista.add(new LatLng(17.547789, -99.532435));
                    for (int i = 0; i < 5; i++) {
                        try {
                            //    LatLng point = list.get(z);
                                float f = (float) (17.547789 + 100f);
                            LatLng point = new LatLng(f, -99.532435);
                            lista.add(point);
                            myMap.clear();
                            for (LatLng a :lista ){
                                Log.e("d","-------------------------------------------------------");
                                Log.e("d",a.toString());

                                myMap.addPolyline(new PolylineOptions().geodesic(true)
                                        .add(a));
                            }


                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.interrupted();
                        }
                }
                // your UI code here
            }


            });

            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

            // myMap.clear();

        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }


}

