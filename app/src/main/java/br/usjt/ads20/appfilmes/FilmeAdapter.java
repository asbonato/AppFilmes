package br.usjt.ads20.appfilmes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Hashtable;

import br.usjt.ads20.appfilmes.model.Filme;

public class FilmeAdapter extends BaseAdapter implements SectionIndexer {
    private Filme[] filmes;
    private Context context;
    private Object[] sectionHeaders;
    private Hashtable<Integer, Integer> positionForSectionMap;
    private Hashtable<Integer, Integer> sectionForPositionMap;


    public FilmeAdapter(Context context, Filme[] filmes) {
        this.filmes = filmes;
        this.context = context;
        sectionHeaders = SectionIndexBuilder.buildSectionHeaders(filmes);
        positionForSectionMap = SectionIndexBuilder.buildPositionForSectionMap(filmes);
        sectionForPositionMap = SectionIndexBuilder.buildSectionForPosition(filmes);
    }

    @Override
    public int getCount() {
        return filmes.length;
    }

    @Override
    public Object getItem(int i) {
        if(i >=0 && i < filmes.length) {
            return filmes[i];
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_filme, viewGroup, false);
            ImageView posterFilme = (ImageView) view.findViewById(R.id.poster_filme);
            TextView nomeFilme = (TextView) view.findViewById(R.id.nome_filme);
            TextView detalheFilme = (TextView) view.findViewById(R.id.detalhe_filme);
            view.setTag(new ViewHolder(posterFilme, nomeFilme, detalheFilme));
        }
        ViewHolder holder = (ViewHolder)view.getTag();
        Drawable drawable = Util.getDrawable(context,
                filmes[i].getPosterPath().substring(0,
                        filmes[i].getPosterPath().length()-4).toLowerCase());
        holder.getPosterFilme().setImageDrawable(drawable);
        holder.getNomeFilme().setText(filmes[i].getTitulo());
        String direcao = context.getResources().getString(R.string.lbl_direcao);
        holder.getDetalheFilme().setText(String.format("%s - %s: %s", filmes[i].getGenero().getNome(),
                direcao, filmes[i].getDiretor()));

        return view;
    }

    @Override
    public Object[] getSections() {
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int i) {
        return positionForSectionMap.get(i).intValue();
    }

    @Override
    public int getSectionForPosition(int i) {
        return sectionForPositionMap.get(i).intValue();
    }
}
