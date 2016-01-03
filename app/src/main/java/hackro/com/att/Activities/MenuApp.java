package hackro.com.att.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import hackro.com.att.DataBase.BaseManager;
import hackro.com.att.DataBase.DBHelper;
import hackro.com.att.Entities.User;
import hackro.com.att.R;

public class MenuApp extends AppCompatActivity {

    private BaseManager dataBaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_app);
        dataBaseManager  = new BaseManager(getApplicationContext());

        String f = getIntent().getStringExtra("foto");//Obtenemos el mail
        String n = getIntent().getStringExtra("usuario");//Obtenemos en nombre
        String e = getIntent().getStringExtra("email");//Obtenemos el mail

        Log.e("foto",f);
        Log.e("usuario",n);
        Log.e("email",e);


        dataBaseManager.InsertUser(new User(f,n,e));



    }
}
