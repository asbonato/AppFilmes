package br.usjt.ads20.appfilmes.model;

import android.provider.BaseColumns;

public final class FilmeContract {
    public static abstract class FilmeEntry implements BaseColumns{
        public static final String TABLE_NAME = "filme";
        public static final String COLUMN_NAME_ID_FILME = "idFilme";
        public static final String COLUMN_NAME_TITULO = "titulo";
        public static final String COLUMN_NAME_DESCRICAO = "descricao";
        public static final String COLUMN_NAME_POPULARIDADE =  "popularidade";
        public static final String COLUMN_NAME_DATA_LANCAMENT0 = "dataLancamento";
        public static final String COLUMN_NAME_POSTER_PATH = "posterPath";
        public static final String COLUMN_NAME_BACKDROP_PATH = "backdropPath";
        public static final String COLUMN_NAME_DIRETOR = "diretor";
        public static final String COLUMN_NAME_ID_GENERO = "idGenero";
        public static final String COLUMN_NAME_NOME_GENERO = "nomeGenero";
        public static final String COLUMN_NAME_IMG_POSTER = "imgPoster";
        public static final String COLUMN_NAME_IMG_BACKDROP = "imgBackdrop";
    }

}
