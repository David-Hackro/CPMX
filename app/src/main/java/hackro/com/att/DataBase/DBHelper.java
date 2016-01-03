package hackro.com.att.DataBase;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import hackro.com.att.Interfaces.InterfaceValues;

/***/
public class DBHelper extends SQLiteOpenHelper implements InterfaceValues {

    private static final int  DB_SCHEME_VERSION= 1;


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BaseManager.CreateTablePolilineas);
        db.execSQL(BaseManager.CreateTableBuses);
        db.execSQL(BaseManager.CreateTableUsers);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}