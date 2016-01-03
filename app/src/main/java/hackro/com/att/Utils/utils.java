package hackro.com.att.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import hackro.com.att.R;

/**
 * Created by hackro on 2/01/16.
 */
public class utils {

    public void DownloadImageFromPath(String path){
        InputStream in =null;
        Bitmap bmp=null;
       // ImageView iv = (ImageView)findViewById(R.id.img1);
        int responseCode = -1;
        try{

            URL url = new URL(path);//"http://192.xx.xx.xx/mypath/img1.jpg
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setDoInput(true);
            con.connect();
            responseCode = con.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK)
            {
                //download
                in = con.getInputStream();
                bmp = BitmapFactory.decodeStream(in);
                in.close();

                //iv.setImageBitmap(bmp);
            }

        }
        catch(Exception ex){
            Log.e("Exception",ex.toString());
        }
    }

    //Metodo para almacenar una imagen en una ruta determinada

    public void createDirectoryAndSaveFile(Bitmap imageToSave, String fileName) throws FileNotFoundException {


        File direct = new File(Environment.getExternalStorageDirectory() + "/Buster");

        if (!direct.exists()) {
            File wallpaperDirectory = new File("/sdcard/Buster/");
            wallpaperDirectory.mkdirs();
        }

        File file = new File(new File("/sdcard/Buster/"), fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            imageToSave.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteImageProfile(String fileName) {
        File file = new File(new File("/sdcard/Buster/"), fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}
