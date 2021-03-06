package hackro.com.att;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import hackro.com.att.DataBase.BaseManager;
import hackro.com.att.Entities.statusReport;
import hackro.com.att.Entities.stops;

/**
 * Created by hackro on 2/01/16.
 */
public class WebServices {

    private Context context;
    private BaseManager db;


    public WebServices(Context context) {//Cuando creamos la clase,podremos pasar el contexto del Activity
        this.context = context;

        db = new BaseManager(context);
    }

    public WebServices() {
    }


    public void getRuta(final String title) {//Pasamos los parametros
        final RequestQueue queue = Volley.newRequestQueue(context);//Creamos instancia de RequestQueue con el contexto como parametro
        String url = "https://bussattapp.herokuapp.com/ruta/getRuta";//Colocamos la URL,concatenando el parametro
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {//Hacemos la peticion
            @Override
            public void onResponse(String response) {//Se es correcta OK

                try {
                    JSONObject array = new JSONObject(response);//Cadena de respuesta como parametro

                    JSONObject statusReport = array.getJSONObject("statusReport");
                    stops stop;
                    JSONArray arrayStops = new JSONArray(statusReport.getString("stops"));
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = arrayStops.getJSONObject(i);

                        stop = new stops();
                        stop.setStopName( object.getString("stopName"));
                        stop.setShelter(object.getString("shelter"));
                        stop.setBench(object.getString("bench"));
                        stop.setStopId(object.getString("stopId"));
                        stop.setOdom(object.getString("odom"));
                        stop.setLoad(String.valueOf(object.getInt("load")));
                        stop.setLongitud(object.getString("long"));
                        stop.setLat(object.getString("lat"));
                        db.InsertPolylines(stop);



                    }
                    statusReport.getString("currentlyStoppedAtBusStop");
                    statusReport.getString("currentStopId");
                    statusReport.getString("routeId");
                    statusReport.getString("requestTime");
                    statusReport.getString("status");
                    statusReport.getString("requestType");



                    //array.getJSONArray("")

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error: ", error.getMessage() + "");//Se mostrara en la consola la cadena de error

            }
        });
        queue.add(stringRequest);

    }



    public void getLocalizacionRuta(final String vim) {//Pasamos los parametros
        final RequestQueue queue = Volley.newRequestQueue(context);//Creamos instancia de RequestQueue con el contexto como parametro
        String url = "https://bussattapp.herokuapp.com/ruta/getUbicacion";//Colocamos la URL,concatenando el parametro
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {//Hacemos la peticion
            @Override
            public void onResponse(String response) {//Se es correcta OK
               // Log.e("response: ", response);//Se mostrara en la consola la cadena con los valores obtenidos

                try {
                    JSONObject jsonObject = new JSONObject(response);//Cadena de respuesta como parametro

                  String lat =  jsonObject.getString("latitud");
                    String lon =    jsonObject.getString("longitude");

                    Log.e("["+lat+"]","["+lon+"]");
                    Toast.makeText(context,lat+" "+lon, Toast.LENGTH_SHORT).show();

                    } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error: ", error.getMessage() + "");//Se mostrara en la consola la cadena de error

            }
        });
        queue.add(stringRequest);

    }

}

