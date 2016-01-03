package hackro.com.att.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import hackro.com.att.Entities.Bus;
import hackro.com.att.Entities.User;
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
    }


    public static final String CreateTableBuses =
            "create table " + TABLE_NAME_Bus + " (" + Bus1 + " integer primary key autoincrement, " +
                    "" + Bus2 + " text not null," +
                    "" + Bus3 + " int not null);";
                  //  "" + Bus2 + " int not null," +
                //    " " + I_PASSWORD + " text not null);";

    public static final String CreateTableUsers =
            "create table " + TABLE_NAME_Bus + " (" +
                    "" + User2 + " text not null," +
                    "" + User3 + " text not null," +
                    "" + User4 + " text not null);";



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
        db.close();
        return false;
    }

    @Override
    public boolean UpdateUser(User user) {
        db.insert(TABLE_NAME_User, null, GenerateContentValueUser(user));
        db.close();
        return false;
    }

    @Override
    public boolean DeleteUser(User user) {
        db.delete(TABLE_NAME_User, User2 + "=?", new String[]{user.getEmail()});
        db.close();
        return false;
    }
}
