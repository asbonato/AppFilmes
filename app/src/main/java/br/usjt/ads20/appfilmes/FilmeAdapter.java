package br.usjt.ads20.appfilmes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Hashtable;

import br.usjt.ads20.appfilmes.model.Filme;
import br.usjt.ads20.appfilmes.model.Poster;

public class FilmeAdapter extends BaseAdapter implements SectionIndexer {
    Filme[] filmes;
    Poster[] imagens;
    Context context;
    Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public FilmeAdapter(Context context, Filme[] filmes, Poster[] imagens){
        this.filmes = filmes;
        this.imagens = imagens;
        this.context = context;
        sectionHeaders = SectionIndexBuilder.buildSectionHeaders(filmes);
        positionForSectionMap = SectionIndexBuilder.buildPositionForSectionMap(filmes);
        sectionForPositionMap = SectionIndexBuilder.buildSectionForPositionMap(filmes);
    }

    @Override
    public int getCount() {
        return filmes.length;
    }

    @Override
    public Object getItem(int i) {
        if(i >= 0 && i < filmes.length){
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
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_filme, viewGroup, false);
            ImageView posterFilme = (ImageView) view.findViewById(R.id.poster_filme);
            TextView nomeFilme = (TextView) view.findViewById(R.id.nome_filme);
            TextView detalhe1Filme = (TextView) view.findViewById(R.id.detalhe1_filme);
            TextView detalhe2Filme = (TextView) view.findViewById(R.id.detalhe2_filme);
            TextView detalhe3Filme = (TextView) view.findViewById(R.id.detalhe3_filme);
            TextView detalhe4Filme = (TextView) view.findViewById(R.id.detalhe4_filme);
            ViewHolder viewHolder = new ViewHolder(posterFilme, nomeFilme, detalhe1Filme,
                    detalhe2Filme, detalhe3Filme, detalhe4Filme);
            view.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder)view.getTag();
        viewHolder.getPosterFilme().setImageBitmap(imagens[i].getPoster());
        viewHolder.getNomeFilme().setText(filmes[i].getTitulo());
        //Locale locale = new Locale("pt", "BR");
        String lbl_gen = context.getResources().getString(R.string.lbl_genero);
        String lbl_dir = context.getResources().getString(R.string.lbl_direcao);
        String lbl_lanc = context.getResources().getString(R.string.lbl_lancamento);
        String lbl_pop = context.getResources().getString(R.string.lbl_popularidade);
        viewHolder.getDetalhe1Filme().setText(String.format("%s: %s", lbl_gen, filmes[i].getGenero().getNome()));
        viewHolder.getDetalhe2Filme().setText(String.format("%s: %s", lbl_dir, filmes[i].getDiretor()));
        viewHolder.getDetalhe3Filme().setText(String.format("%s: %td-%tb-%ty", lbl_lanc,
                filmes[i].getDataLancamento(), filmes[i].getDataLancamento(),
                filmes[i].getDataLancamento()));
        viewHolder.getDetalhe4Filme().setText(String.format("%s: %.1f", lbl_pop, filmes[i].getPopularidade()));

        return view;
    }

    @Override
    public Object[] getSections() {
        System.out.println(sectionHeaders);
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
