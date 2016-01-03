package hackro.com.att.Interfaces;

import android.content.ContentValues;

import java.util.ArrayList;

import hackro.com.att.Entities.Bus;
import hackro.com.att.Entities.User;

/**
 * Created by hackro on 2/01/16.
 */
public interface IMethods {



    public ContentValues GenerateContentValueUser(User User);
    public boolean InsertUser(User user);
    public boolean UpdateUser(User user);
    public boolean DeleteUser(User user);





}
