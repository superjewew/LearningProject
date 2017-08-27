package norman.com.learningproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.SensorManager;

/**
 * Created by norman on 8/21/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "constants.db";
    public static final int SCHEMA = 1;
    public static final String TITLE = "title";
    public static final String VALUE = "value";
    public static final String TABLE = "constants";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE constants (title TEXT, value REAL);");

        ContentValues cv = new ContentValues();

        cv.put(TITLE, "Gravity, Death Star I");
        cv.put(VALUE, SensorManager.GRAVITY_DEATH_STAR_I);
        db.insert(TABLE, TITLE, cv);
        cv.put(TITLE, "Gravity, Earth");
        cv.put(VALUE, SensorManager.GRAVITY_EARTH);
        db.insert(TABLE, TITLE, cv);
        cv.put(TITLE, "Gravity, Jupiter");
        cv.put(VALUE, SensorManager.GRAVITY_JUPITER);
        db.insert(TABLE, TITLE, cv);
        cv.put(TITLE, "Gravity, Mars");
        cv.put(VALUE, SensorManager.GRAVITY_MARS);
        db.insert(TABLE, TITLE, cv);
        cv.put(TITLE, "Gravity, Mercury");
        cv.put(VALUE, SensorManager.GRAVITY_MERCURY);
        db.insert(TABLE, TITLE, cv);
        cv.put(TITLE, "Gravity, Moon");
        cv.put(VALUE, SensorManager.GRAVITY_MOON);
        db.insert(TABLE, TITLE, cv);
        cv.put(TITLE, "Gravity, Neptune");
        cv.put(VALUE, SensorManager.GRAVITY_NEPTUNE);
        db.insert(TABLE, TITLE, cv);
        cv.put(TITLE, "Gravity, Pluto");
        cv.put(VALUE, SensorManager.GRAVITY_PLUTO);
        db.insert(TABLE, TITLE, cv);
        cv.put(TITLE, "Gravity, Saturn");
        cv.put(VALUE, SensorManager.GRAVITY_SATURN);
        db.insert(TABLE, TITLE, cv);
        cv.put(TITLE, "Gravity, Sun");
        cv.put(VALUE, SensorManager.GRAVITY_SUN);
        db.insert(TABLE, TITLE, cv);
        cv.put(TITLE, "Gravity, The Island");
        cv.put(VALUE, SensorManager.GRAVITY_THE_ISLAND);
        db.insert(TABLE, TITLE, cv);
        cv.put(TITLE, "Gravity, Uranus");
        cv.put(VALUE, SensorManager.GRAVITY_URANUS);
        db.insert(TABLE, TITLE, cv);
        cv.put(TITLE, "Gravity, Venus");
        cv.put(VALUE, SensorManager.GRAVITY_VENUS);
        db.insert(TABLE, TITLE, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        throw new RuntimeException("how did we get here?");
    }
}
