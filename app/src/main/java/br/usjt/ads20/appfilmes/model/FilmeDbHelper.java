package br.usjt.ads20.appfilmes.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static br.usjt.ads20.appfilmes.model.FilmeContract.FilmeEntry;


public class FilmeDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Filmes.db";
    public static final String SQL_CREATE_FILME =
            "CREATE TABLE " + FilmeEntry.TABLE_NAME + " ( " +
                    FilmeEntry._ID + " INTEGER PRIMARY KEY," +
                    FilmeEntry.COLUMN_NAME_ID_FILME + " INTEGER," +
                    FilmeEntry.COLUMN_NAME_TITULO + " TEXT," +
                    FilmeEntry.COLUMN_NAME_DESCRICAO +  " TEXT," +
                    FilmeEntry.COLUMN_NAME_POPULARIDADE + " REAL," +
                    FilmeEntry.COLUMN_NAME_DATA_LANCAMENT0 + " TEXT," +
                    FilmeEntry.COLUMN_NAME_POSTER_PATH + " TEXT," +
                    FilmeEntry.COLUMN_NAME_BACKDROP_PATH + " TEXT," +
                    FilmeEntry.COLUMN_NAME_DIRETOR + " TEXT," +
                    FilmeEntry.COLUMN_NAME_ID_GENERO + " INTEGER," +
                    FilmeEntry.COLUMN_NAME_NOME_GENERO + " TEXT," +
                    FilmeEntry.COLUMN_NAME_IMG_POSTER + " BLOB," +
                    FilmeEntry.COLUMN_NAME_IMG_BACKDROP + " BLOB)";

    public static final String SQL_DROP_FILME =
            "DROP TABLE IF EXISTS " + FilmeEntry.TABLE_NAME;

    public FilmeDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_FILME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQL_DROP_FILME);
        sqLiteDatabase.execSQL(SQL_CREATE_FILME);
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        super.onDowngrade(sqLiteDatabase, oldVersion, newVersion);
        onUpgrade(sqLiteDatabase, newVersion, oldVersion);
    }
}
