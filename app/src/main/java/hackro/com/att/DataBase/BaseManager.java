package hackro.com.att.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import hackro.com.att.Entities.Bus;
import hackro.com.att.Entities.User;
import hackro.com.att.Entities.stops;
import hackro.com.att.Interfaces.IMethods;
import hackro.com.att.Interfaces.InterfaceValues;

/**
 * Created by hackro on 2/01/16.
 */
public class BaseManager implements InterfaceValues, IMethods {


    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public BaseManager(Context context) {
        dbHelper = new DBHelper(context);

        db = dbHelper.getWritableDatabase();//Creation of DB

        //   db = dbHelper.getWritableDatabase();//Creation of DB
    }


    public static final String CreateTableBuses =
            "create table " + TABLE_NAME_Bus + " (" + Bus1 + " integer primary key autoincrement, " +
                    "" + Bus2 + " text not null," +
                    "" + Bus3 + " int not null);";
    //  "" + Bus2 + " int not null," +
    //    " " + I_PASSWORD + " text not null);";

    public static final String CreateTableUsers =
            "create table " + TABLE_NAME_User + " (" +
                    "" + User2 + " text not null," +
                    "" + User3 + " text not null," +
                    "" + User4 + " text not null);";


    public static final String CreateTablePolilineas =
            "create table Polilineas (" +
                    "" + Polylines1 + " text not null," +
                    "" + Polylines2 + " text not null," +
                    "" + Polylines3 + " text not null," +
                    "" + Polylines4 + " text not null," +
                    "" + Polylines5 + " text not null," +
                    "" + Polylines6 + " int not null," +
                    "" + Polylines7 + " text not null," +
                    "" + Polylines8 + " text not null);";


    //**************************************************************************************//
    //Table of users
    //*************************************************************************************//
    @Override
    public ContentValues GenerateContentValueUser(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(User2, user.getName());
        contentValues.put(User3, user.getEmail());
        contentValues.put(User4, user.getPhoto());
        return contentValues;
    }

    @Override
    public boolean InsertUser(User user) {

        db.insert(TABLE_NAME_User, null, GenerateContentValueUser(user));
     //   db.close();
        return false;
    }

    @Override
    public boolean UpdateUser(User user) {
        db.insert(TABLE_NAME_User, null, GenerateContentValueUser(user));
    //    db.close();
        return false;
    }

    @Override
    public boolean DeleteUser(User user) {
        db.delete(TABLE_NAME_User, User2 + "=?", new String[]{user.getEmail()});
    ///    db.close();
        return false;
    }

    @Override
    public Cursor GetAllDatesUser(String user) {
        String[] columnas = new String[]{User1, User2, User3, User4};
        String[] args = new String[]{user};
        Cursor c = db.query(TABLE_NAME_User, columnas, User1, args, null, null, null);//OCupamos nuevamente un metodo de ContentValues,pasando como parametro el nombre de la tabla y el arreglo de campos
    //    db.close();

        return c;
    }

    @Override
    public ContentValues GenerateContentValuePolylines(stops stops) {
        ContentValues contentValues = new ContentValues();


        contentValues.put(Polylines1, stops.getStopName());
        contentValues.put(Polylines2, stops.getShelter());
        contentValues.put(Polylines3, stops.getBench());
        contentValues.put(Polylines4, stops.getStopId());
        contentValues.put(Polylines5, stops.getOdom());
        contentValues.put(Polylines6, stops.getLoad());
        contentValues.put(Polylines7, stops.getLongitud());
        contentValues.put(Polylines8, stops.getLat());


        return contentValues;
    }

    @Override
    public boolean InsertPolylines(stops stops) {
        db.insert("Polilineas", null, GenerateContentValuePolylines(stops));
        //db.close();
        return false;
    }

    @Override
    public boolean DeletePolylines() {
        db.delete(TABLE_NAME_P, null, null);
       // db.close();
        return false;
    }

    @Override
    public Cursor GetAllDatesPolylines() {

   //     String[] columnas = new String[]{Polylines1, Polylines2, Polylines3, Polylines4, Polylines5, Polylines6, Polylines7, Polylines8};//En un arreglo colocamos los campos
    //    Cursor c = db.query(TABLE_NAME_P, columnas, null, null, null, null, null);//OCupamos nuevamente un metodo de ContentValues,pasando como parametro el nombre de la tabla y el arreglo de campos
     //   db.close();
        Cursor c = null;
        return c;
    }

}
