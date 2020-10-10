package br.usjt.ads20.appfilmes.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static br.usjt.ads20.appfilmes.model.FilmeContract.FilmeEntry;

public class FilmeDb {
    FilmeDbHelper dbHelper;

    public FilmeDb(Context contexto){
        dbHelper = new FilmeDbHelper(contexto);
    }

    public void salvarFilmes(ArrayList<Filme> filmes){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //limpar a base - delete sem where!!!
        db.delete(FilmeEntry.TABLE_NAME, null, null);

        for(Filme filme:filmes){
            ContentValues values = new ContentValues();
            values.put(FilmeEntry.COLUMN_NAME_ID_FILME, filme.getId());
            values.put(FilmeEntry.COLUMN_NAME_TITULO, filme.getTitulo());
            values.put(FilmeEntry.COLUMN_NAME_DESCRICAO, filme.getDescricao());
            values.put(FilmeEntry.COLUMN_NAME_POPULARIDADE, filme.getPopularidade());
            values.put(FilmeEntry.COLUMN_NAME_DATA_LANCAMENT0,
                    String.format("%tY-%tm-%td", filme.getDataLancamento(),
                            filme.getDataLancamento(), filme.getDataLancamento()));
            values.put(FilmeEntry.COLUMN_NAME_POSTER_PATH, filme.getPosterPath());
            values.put(FilmeEntry.COLUMN_NAME_BACKDROP_PATH, filme.getBackdropPath());
            values.put(FilmeEntry.COLUMN_NAME_DIRETOR, filme.getDiretor());
            values.put(FilmeEntry.COLUMN_NAME_ID_GENERO, filme.getGenero().getId());
            values.put(FilmeEntry.COLUMN_NAME_NOME_GENERO, filme.getGenero().getNome());

            db.insert(FilmeEntry.TABLE_NAME, null, values);
        }
        db.close();
    }

    public ArrayList<Filme> buscarFilmes(){
        ArrayList<Filme> filmes = new ArrayList<>();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = {
          FilmeEntry.COLUMN_NAME_ID_FILME,
                FilmeEntry.COLUMN_NAME_TITULO,
                FilmeEntry.COLUMN_NAME_DESCRICAO,
                FilmeEntry.COLUMN_NAME_POPULARIDADE,
                FilmeEntry.COLUMN_NAME_DATA_LANCAMENT0,
                FilmeEntry.COLUMN_NAME_POSTER_PATH,
                FilmeEntry.COLUMN_NAME_BACKDROP_PATH,
                FilmeEntry.COLUMN_NAME_DIRETOR,
                FilmeEntry.COLUMN_NAME_ID_GENERO,
                FilmeEntry.COLUMN_NAME_NOME_GENERO
        };
        String where = null;
        String[] conditions = null;
        String order = FilmeEntry.COLUMN_NAME_TITULO;

        Cursor c = db.query(FilmeEntry.TABLE_NAME, colunas, where, conditions, order, null, null);

        while(c.moveToNext()){
            Filme filme = new Filme();
            filme.setId(c.getInt(c.getColumnIndex(FilmeEntry.COLUMN_NAME_ID_FILME)));
            filme.setTitulo(c.getString(c.getColumnIndex(FilmeEntry.COLUMN_NAME_TITULO)));
            filme.setDescricao(c.getString(c.getColumnIndex(FilmeEntry.COLUMN_NAME_DESCRICAO)));
            filme.setPopularidade(c.getDouble(c.getColumnIndex(FilmeEntry.COLUMN_NAME_POPULARIDADE)));
            Date dataLancamento = null;
            try {
                dataLancamento = formatter.parse(c.getString(c.getColumnIndex(FilmeEntry.COLUMN_NAME_DATA_LANCAMENT0)));
                filme.setDataLancamento(dataLancamento);
            } catch (ParseException e) {
                filme.setDataLancamento(new Date());
                e.printStackTrace();
            }
            filme.setPosterPath(c.getString(c.getColumnIndex(FilmeEntry.COLUMN_NAME_POSTER_PATH)));
            filme.setBackdropPath(c.getString(c.getColumnIndex(FilmeEntry.COLUMN_NAME_BACKDROP_PATH)));
            filme.setDiretor(c.getString(c.getColumnIndex(FilmeEntry.COLUMN_NAME_DIRETOR)));
            Genero genero = new Genero();
            genero.setId(c.getInt(c.getColumnIndex(FilmeEntry.COLUMN_NAME_ID_GENERO)));
            genero.setNome(c.getString(c.getColumnIndex(FilmeEntry.COLUMN_NAME_NOME_GENERO)));
            filme.setGenero(genero);
            filmes.add(filme);
        }
        c.close();
        db.close();
        return filmes;
    }

    public void atualizaPosters(ArrayList<Poster> posters){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selecao = FilmeEntry.COLUMN_NAME_ID_FILME + "=?";
        String[] selectionArgs = new String[1];

        for(Poster poster:posters){
            selectionArgs[0] = ""+poster.getId();
            ContentValues values = new ContentValues();
            values.put(FilmeEntry.COLUMN_NAME_IMG_POSTER, getPictureOfArray(poster.getPoster()));
            db.update(FilmeEntry.TABLE_NAME, values, selecao, selectionArgs);
        }

    }

    public void atualizaBackdrop(int idFilme, Bitmap img){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selecao = FilmeEntry.COLUMN_NAME_ID_FILME + "=?";
        String[] selectionArgs = new String[1];

        selectionArgs[0] = ""+idFilme;
        ContentValues values = new ContentValues();
        values.put(FilmeEntry.COLUMN_NAME_IMG_BACKDROP, getPictureOfArray(img));
        db.update(FilmeEntry.TABLE_NAME, values, selecao, selectionArgs);
        Log.d("Salvou imagem do filme: ", ""+idFilme);
    }

    public ArrayList<Poster> buscaPosters(){
        ArrayList<Poster> posters = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] colunas = {
                FilmeEntry.COLUMN_NAME_ID_FILME,
                FilmeEntry.COLUMN_NAME_TITULO,
                FilmeEntry.COLUMN_NAME_IMG_POSTER
        };
        String ordem = null;
        String where = null;
        String[] conditions = null;

        Cursor c = db.query(FilmeEntry.TABLE_NAME, colunas, where, conditions, ordem, null, null);

        while(c.moveToNext()){
            Poster poster = new Poster();
            poster.setId(c.getInt(c.getColumnIndex(FilmeEntry.COLUMN_NAME_ID_FILME)));
            poster.setTitulo(c.getString(c.getColumnIndex(FilmeEntry.COLUMN_NAME_TITULO)));
            poster.setPoster(getBitmapFromByte(c.getBlob(c.getColumnIndex(FilmeEntry.COLUMN_NAME_IMG_POSTER))));

            posters.add(poster);
        }
        c.close();
        db.close();

        return posters;
    }

    public Bitmap buscaBackdrop(int idFilme){
        Bitmap img = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] colunas = {
                FilmeEntry.COLUMN_NAME_IMG_BACKDROP
        };
        String selecao = FilmeEntry.COLUMN_NAME_ID_FILME + "=?";
        String[] selectionArgs = new String[1];

        selectionArgs[0] = ""+idFilme;

        Cursor c = db.query(FilmeEntry.TABLE_NAME, colunas, selecao, selectionArgs, null, null, null);
        Log.d("Vai recuperar a imagem do filme: ", ""+idFilme);
        if (c.moveToNext()){
            img = getBitmapFromByte(c.getBlob(c.getColumnIndex(FilmeEntry.COLUMN_NAME_IMG_BACKDROP)));
        }
        c.close();
        db.close();

        return img;
    }

    private byte[] getPictureOfArray(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private Bitmap getBitmapFromByte(byte[] image){
        try {
            return BitmapFactory.decodeByteArray(image, 0, image.length);
        } catch (Exception e){
            return null;
        }
    }

}

















