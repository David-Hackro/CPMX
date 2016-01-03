package hackro.com.att.Activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;

import hackro.com.att.DataBase.BaseManager;
import hackro.com.att.DataBase.DBHelper;
import hackro.com.att.Entities.User;
import hackro.com.att.R;
import hackro.com.att.Utils.utils;
import hackro.com.att.WebServices;

public class MenuApp extends AppCompatActivity {

    private BaseManager dataBaseManager;

    private ImageView Profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_app);
        dataBaseManager  = new BaseManager(getApplicationContext());
        Profile = (ImageView) findViewById(R.id.Profile);
        String f = getIntent().getStringExtra("foto");//Obtenemos el mail
        String n = getIntent().getStringExtra("usuario");//Obtenemos en nombre
        String e = getIntent().getStringExtra("email");//Obtenemos el mail

        Log.e("foto",f);
        Log.e("usuario",n);
        Log.e("email",e);


        dataBaseManager.InsertUser(new User(f,n,e));
        utils utils = new utils();

        try {
            utils.createDirectoryAndSaveFile(utils.DownloadImageFromPath(f),e);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        String imageInSD = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Buster/" + e + ".jpg";
        Bitmap bitmap = BitmapFactory.decodeFile(imageInSD);

        Profile.setImageBitmap(bitmap);

        WebServices ws = new WebServices(getApplicationContext());
        ws.QueryGet("");






    }
}
