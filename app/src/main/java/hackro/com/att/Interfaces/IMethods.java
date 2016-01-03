package hackro.com.att.Interfaces;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;

import hackro.com.att.Entities.Bus;
import hackro.com.att.Entities.User;
import hackro.com.att.Entities.stops;

/**
 * Created by hackro on 2/01/16.
 */
public interface IMethods {



    public ContentValues GenerateContentValueUser(User User);
    public boolean InsertUser(User user);
    public boolean UpdateUser(User user);
    public boolean DeleteUser(User user);
    public Cursor GetAllDatesUser(String user);



    public ContentValues GenerateContentValuePolylines(stops stops);
    public boolean InsertPolylines(stops stops);
    public boolean DeletePolylines();
    public Cursor GetAllDatesPolylines();



}
