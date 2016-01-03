package hackro.com.att;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by hackro on 2/01/16.
 */
public class WebServices {

    private Context context;

    public WebServices(Context context) {//Cuando creamos la clase,podremos pasar el contexto del Activity
        this.context = context;
    }

    public WebServices() {
    }


    public void QueryGet(final String title) {//Pasamos los parametros
        final RequestQueue queue = Volley.newRequestQueue(context);//Creamos instancia de RequestQueue con el contexto como parametro
        String url = "http://172.18.97.248:1337/ruta/getRuta";//Colocamos la URL,concatenando el parametro
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {//Hacemos la peticion
            @Override
            public void onResponse(String response) {//Se es correcta OK
                Log.e("response: ", response);//Se mostrara en la consola la cadena con los valores obtenidos

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

