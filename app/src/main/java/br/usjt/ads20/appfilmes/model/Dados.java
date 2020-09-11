package br.usjt.ads20.appfilmes.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Dados {
    public static ArrayList<String> buscaFilmes(String chave){
        ArrayList<String> lista = geraListaFilmes();
        if(chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<String> filtro = new ArrayList<>();
            for(String nome: lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    filtro.add(nome);
                }
            }
            return filtro;
        }
    }
    public static ArrayList<String> geraListaFilmes(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Aventura: Guerra nas Estrelas (1977)");
        lista.add("Fantasia: O Senhor dos Anéis: O Retorno do Rei");
        lista.add("Ação: Matrix");
        lista.add("Aventura: De Volta para o Futuro");
        lista.add("Ficção Científica: Jornada nas Estrelas");
        lista.add("Aventura: Os Goonies");
        lista.add("Ficção Científica: Blade Runner, o Caçador de Androides");
        lista.add("Suspense: Allien");
        lista.add("Drama: Platoon");
        lista.add("Ação: Os Vingadores");
        lista.add("Thriller: Pulp Fiction");
        lista.add("Aventura: Os Caçadores da Arca Perdida");
        lista.add("Terror: It - A coisa");
        lista.add("Terror: Psicose");
        lista.add("Comédia: Monty Python em Busca do Cálice Sagrado");
        lista.add("Terror: Os Garotos Perdidos");
        lista.add("Suspense: Seven, os Sete Pecados Capitais");
        lista.add("Ação: Kill Bill");
        lista.add("Fantasia: Alice no País das Maravilhas");
        lista.add("Anime: Akira");
        lista.add("Terror: Hereditário");
        return lista;
    }

    public static ArrayList<Genero> criaGeneros() {
        ArrayList<Genero> lista = new ArrayList<>();
        lista.add(new Genero(1, "Não Cadastrado"));
        lista.add(new Genero(28, "Ação"));
        lista.add(new Genero(12, "Aventura"));
        lista.add(new Genero(16, "Animação"));
        lista.add(new Genero(35, "Comédia"));
        lista.add(new Genero(80, "Crime"));
        lista.add(new Genero(99, "Documentário"));
        lista.add(new Genero(18, "Drama"));
        lista.add(new Genero(10751, "Família"));
        lista.add(new Genero(14, "Fantasia"));
        lista.add(new Genero(36, "História"));
        lista.add(new Genero(27, "Horror"));
        lista.add(new Genero(10402, "Musical"));
        lista.add(new Genero(9648, "Mistério"));
        lista.add(new Genero(10749, "Romance"));
        lista.add(new Genero(878, "Ficção Científica"));
        lista.add(new Genero(10770, "Filme para TV"));
        lista.add(new Genero(53, "Suspense"));
        lista.add(new Genero(10752, "Guerra"));
        lista.add(new Genero(37, "Western"));

        return lista;
    }

    public static ArrayList<Filme> criaFilmes() {
        ArrayList<Filme> lista = new ArrayList<>();
        Filme filme;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        filme = new Filme();
        filme.setPopularidade(847.503);
        filme.setPosterPath("dGVUiqnahQ4ZZRchGRpO2SyhtQY.jpg");
        filme.setBackdropPath("gEjNlhZhyHeto6Fy5wWy5Uk3A9D.jpg");
        filme.setGenero(new Genero(28, "Ação"));
        filme.setDiretor("Yeon Sang-ho");
        filme.setTitulo("Península");
        filme.setDescricao("O filme decorre no mesmo mundo do primeiro filme, mas acontece quatro " +
                "anos depois do original. Gang Dong-Won é um antigo soldado que conseguiu escapar " +
                "da Coreia do Sul infestada por zombies. O vírus fez colapsar governos pelo mundo " +
                "e a Coreia do Sul tornou-se numa enorme favela. O ex-soldado tem como missão " +
                "entrar no país para recuperar algo muito valioso, mas depara-se com um grupo de " +
                "não-infetados que precisam de ser salvos.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-08-27"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(781.209);
        filme.setPosterPath("teDX74nsxkv2ysWvNT5EPXQ9E.jpg");
        filme.setBackdropPath("qVygtf2vU15L2yKS4Ke44U4oMdD.jpg");
        filme.setGenero(new Genero(28, "Ação"));
        filme.setDiretor("Henry Joost & Ariel Schulman");
        filme.setTitulo("Project Power: Descobre o Poder");
        filme.setDescricao("Os caminhos de um ex-soldado, uma adolescente e um polícia cruzam-se " +
                "em Nova Orleães, enquanto procuram a fonte de uns novos comprimidos que provocam " +
                "poderes temporários.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-08-14"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(352.029);
        filme.setPosterPath("p7RjlzDLV4KksrWtyve1Rg40nLv.jpg");
        filme.setBackdropPath("fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg");
        filme.setGenero(new Genero(12, "Aventura"));
        filme.setDiretor("Tony Cervone");
        filme.setTitulo("Scooby!");
        filme.setDescricao("O primeiro filme completo de animação chega aos grandes ecrãs com " +
                "histórias nunca contadas das origens de Scooby-Doo e um dos maiores mistérios " +
                "da carreira de Mystery Inc.. Vamos ver como Shaggy e Scooby se conheceram e como " +
                "foram apresentados aos jovens detectives Fred, Velma e Daphne para formarem a " +
                "Mystery Inc.. Agora o grupo tem o seu maior desafio, que envolve um enredo para " +
                "libertar o cão fantasma Cerberus no mundo.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-08-07"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(346.752);
        filme.setPosterPath("knfExByNW2jCwtmIuwYYxzPKpkm.jpg");
        filme.setBackdropPath("m0ObOaJBerZ3Unc74l471ar8Iiy.jpg");
        filme.setGenero(new Genero(28, "Ação"));
        filme.setDiretor("Gina Prince-Bythewood");
        filme.setTitulo("A Velha Guarda");
        filme.setDescricao("Quatro guerreiros imortais, que protegem a humanidade em segredo há " +
                "séculos, são perseguidos pelos seus misteriosos poderes, justamente quando " +
                "descobrem uma nova imortal.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-07-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(328.69);
        filme.setPosterPath("sTKl7J5OWnsZSTRiKPIvPx4ngBG.jpg");
        filme.setBackdropPath("upUy2QhMZEmtypPW3PdieKLAHxh.jpg");
        filme.setGenero(new Genero(28, "Ação"));
        filme.setDiretor("Adil El Arbi & Bilall Fallah");
        filme.setTitulo("Bad Boys Para Sempre");
        filme.setDescricao("Will Smith e Martin Lawrence estão de regresso às ruas de Miami, a dar " +
                "corpo aos detectives Mike Lowrey e Marcus Burnett, do Departamento de Narcóticos. " +
                "Agora, ao mesmo tempo que lidam com problemas a nível pessoal – que incluem " +
                "mudanças de carreira, envelhecimento e crises de meia-idade –, vão ter de " +
                "enfrentar Armando Armas, o líder do mais perigoso cartel de drogas a actuar em " +
                "todo o estado da Flórida.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-01-30"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(311.359);
        filme.setPosterPath("A50Ngq9lh9aCTGHC6kttrppHNoF.jpg");
        filme.setBackdropPath("xNOiv6DZZjH7ABoUUDP0ZynouU.jpg");
        filme.setGenero(new Genero(28, "Ação"));
        filme.setDiretor("Cathy Yan");
        filme.setTitulo("Aves de Rapina");
        filme.setDescricao("Harley Quinn decide lutar pela sua emancipação e separa-se de Joker. " +
                "Uma notícia que agrada a muitos que querem contar com a sua ajuda para outros " +
                "planos perigosos. Mas, Harley junta-se aos super-heróis Black Canary, Huntress e " +
                "Renee Montoya para salvar uma jovem.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-02-06"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(268.133);
        filme.setDiretor("Josh Boone");
        filme.setTitulo("Os Novos Mutantes");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-10-08"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        filme.setGenero(new Genero(28, "Ação"));
        filme.setBackdropPath("eCIvqa3QVCx6H09bdeOS8Al2Sqy.jpg");
        filme.setDescricao("Num hospital isolado, um grupo de jovens mutantes é mantido enclausurado " +
                "para acompanhamento psiquiátrico. Quando estranhos acontecimentos têm lugar, as " +
                "suas novas habilidades mutantes e as suas amizades serão postas à prova, enquanto " +
                "lutam pela sobrevivência.");
        filme.setPosterPath("RcWaW43UWIJzhIp6bcmui2efd.jpg");
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(284.474);
        filme.setPosterPath("el7iWlogQ4Mv6A0qvBn4ZyxHGiW.jpg");
        filme.setBackdropPath("xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg");
        filme.setGenero(new Genero(28, "Ação"));
        filme.setDiretor("Aaron Schneider");
        filme.setTitulo("Missão Greyhound");
        filme.setDescricao("No início da Segunda Guerra Mundial, um conjunto internacional formado " +
                "por 37 navios aliados, liderado pelo comandante Ernest Krause na sua primeira " +
                "missão à frente de um destroyer norte-americano, atravessa as águas traiçoeiras " +
                "do Atlântico Norte enquanto é perseguido por matilhas de submarinos nazis U-Boot.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-07-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(252.159);
        filme.setPosterPath("u3B2YKUjWABcxXZ6Nm9h10hLUbh.jpg");
        filme.setBackdropPath("ToEZvF2Obp9zNZbY5ELVnmrW.jpg");
        filme.setGenero(new Genero(18, "Drama"));
        filme.setDiretor("Jenny Gage");
        filme.setTitulo("After");
        filme.setDescricao("Inspirado no best-seller de Anna Todd, “After” conta-nos a história " +
                "de Tessa (Josephine Langford), estudante aplicada, filha perfeita e namorada leal " +
                "da sua paixão da escola secundária, no momento em que esta entra na universidade. " +
                "Armada com grandes ambições para o futuro, o seu mundo protegido quebra quando " +
                "conhece o misterioso Hardin Scott (Hero Tiffin), um rebelde carismático que a " +
                "levará a questionar tudo o que pensava saber sobre si e sobre os seus objetivos " +
                "de vida…");
        try {
            filme.setDataLancamento((Date) formatter.parse("2019-04-11"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(278.387);
        filme.setPosterPath("Kt9iFdTu5TbAm7tNfc876mrWU.jpg");
        filme.setBackdropPath("stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg");
        filme.setGenero(new Genero(28, "Ação"));
        filme.setDiretor("Jeff Fowler");
        filme.setTitulo("Sonic: O Filme");
        filme.setDescricao("Baseado no videojogo da Sega, sucesso à escala global, Sonic: O Filme " +
                "conta a história do ouriço mais rápido do mundo a partir do momento em que este " +
                "chega à sua nova casa – o planeta Terra. Nesta comédia e aventura live-action, " +
                "Sonic e o seu novo melhor amigo Tom  juntam-se para defender o planeta do génio " +
                "do mal, o Dr. Robotnik, e dos seus planos para domínio do mundo.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-02-13"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(249.127);
        filme.setPosterPath("xLxgVxFWvb9hhUyCDDXxRPPnFck.jpg");
        filme.setBackdropPath("n6bUvigpRFqSwmPp1m2YADdbRBc.jpg");
        filme.setGenero(new Genero(80, "Crime"));
        filme.setDiretor("Todd Phillips");
        filme.setTitulo("Joker");
        filme.setDescricao("Arthur Fleck é um homem que enfrenta a crueldade e o desprezo da " +
                "sociedade, juntamente com a indiferença de um sistema que lhe permite passar da " +
                "vulnerabilidade para a depravação. Durante o dia é um palhaço e à noite luta para " +
                "se tornar um artista de stand-up comedy…mas descobre que é ele próprio a piada. " +
                "Sempre diferente de todos em seu redor, o seu riso incontrolável e inapropriado, " +
                "ganha ainda mais força quando tenta contê-lo, expondo-o a situações ridículas e " +
                "até à violência. Preso numa existência cíclica que oscila entre o precipício da " +
                "realidade e da loucura, uma má decisão acarreta uma reacção em cadeia de eventos " +
                "crescentes e, por fim, mortais.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2019-10-03"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(271.014);
        filme.setPosterPath("Z7AJiQhocA20MkI5JXZ6OjTxEW.jpg");
        filme.setBackdropPath("lP5eKh8WOcPysfELrUpGhHJGZEH.jpg");
        filme.setGenero(new Genero(28, "Ação"));
        filme.setDiretor("Dave Wilson");
        filme.setTitulo("Bloodshot");
        filme.setDescricao("Baseado no best-seller de banda desenhada, Vin Diesel protagoniza " +
                "“Bloodshot” na pele de Ray Garrison, um soldado recentemente morto em combate e " +
                "ressuscitado como o super – humano Bloodshot da empresa RST. Com um exército de " +
                "nanotecnologia nas suas veias, Rayé uma força imparável – mais forte do que nunca " +
                "e capaz de se curar instantaneamente. Mas, ao controlar o seu corpo, a empresa " +
                "controla também a sua mente e as suas memórias. Agora, Ray não sabe o que é real " +
                "e o que não é, mas está decidido a descobrir a verdade.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-03-12"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(252.152);
        filme.setPosterPath("k68nPLbIST6NP96JmTxmZijEvCA.jpg");
        filme.setBackdropPath("wzJRB4MKi3yK138bJyuL9nx47y6.jpg");
        filme.setGenero(new Genero(28, "Ação"));
        filme.setDiretor("Christopher Nolan");
        filme.setTitulo("Tenet");
        filme.setDescricao("Armado apenas com uma palavra – Tenet – e lutando pela sobrevivência do " +
                "planeta, o Protagonista viaja pelo mundo penumbroso da espionagem internacional numa " +
                "missão que irá desvendar algo além do tempo real. Não se trata de uma viagem no tempo. " +
                "Mas sim, uma inversão.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-09-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(227.879);
        filme.setDiretor("Sam Mendes");
        filme.setTitulo("1917");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-01-23"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        filme.setGenero(new Genero(10752, "Guerra"));
        filme.setBackdropPath("cqa3sa4c4jevgnEJwq3CMF8UfTG.jpg");
        filme.setDescricao("No auge da Primeira Guerra Mundial, dois jovens soldados britânicos, " +
                "Schofield e Blake, recebem uma missão aparentemente impossível. Numa corrida " +
                "contra o tempo, têm de atravessar território inimigo e entregar uma mensagem que " +
                "impedirá um ataque letal contra centenas de soldados, entre eles o irmão de Blake.");
        filme.setPosterPath("KkyXE7Hd9MPOOkORxkMM6SUXAB.jpg");
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(246.499);
        filme.setPosterPath("jsi2UM64Mhr6NmY1LKeeCuZOaCo.jpg");
        filme.setBackdropPath("xFxk4vnirOtUxpOEWgA1MCRfy6J.jpg");
        filme.setGenero(new Genero(12, "Aventura"));
        filme.setDiretor("Dan Scanlon");
        filme.setTitulo("Bora Lá");
        filme.setDescricao("Num mundo de fantasia urbano, dois irmãos elfos adolescentes, Ian e " +
                "Barley Lightfoot, embarcam numa aventura para descobrir se ainda resta um pouco de " +
                "magia para passar um último dia com o pai que morreu quando eles eram muito novos.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-03-05"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(226.958);
        filme.setPosterPath("roRRTAzpLJSo32jRGPDuUKZDfC.jpg");
        filme.setBackdropPath("x3NqAzuTWvnron4pXXyFGkyTFo7.jpg");
        filme.setGenero(new Genero(18, "Drama"));
        filme.setDiretor("Charlie Kaufman");
        filme.setTitulo("Tudo Acaba Agora");
        filme.setDescricao("Nada é o que parece quando uma mulher vai com o novo namorado, em relação " +
                "ao qual tem algumas reservas, para a quinta remota dos pais dele.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-09-04"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(226.544);
        filme.setDiretor("Anthony Russo & Joe Russo");
        filme.setTitulo("Vingadores: Guerra do Infinito");
        try {
            filme.setDataLancamento((Date) formatter.parse("2018-04-26"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        filme.setGenero(new Genero(12, "Aventura"));
        filme.setBackdropPath("bOGkgRGdhrBYJSLpXaxhXVstddV.jpg");
        filme.setDescricao("Após 10 anos de uma viagem cinematográfica sem precedentes e que abrange " +
                "todo o universo cinematográfico Marvel, \"Vingadores: Guerra do Infinito\" traz ao " +
                "grande ecrã o maior confronto de todos os tempos. Os Vingadores e os seus aliados " +
                "Super-Heróis devem estar dispostos a sacrificar tudo para tentarem derrotar o " +
                "poderoso Thanos antes que o seu ataque de devastação e ruína acabe com o universo.");
        filme.setPosterPath("QTZmn34iwXYeCpVxhC9UrT8sX.jpg");
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(215.412);
        filme.setPosterPath("g6n7TdQSgozArIM0okXTjjCM9Np.jpg");
        filme.setBackdropPath("xJWPZIYOEFIjZpBL7SVBGnzRYXp.jpg");
        filme.setGenero(new Genero(12, "Aventura"));
        filme.setDiretor("Chris Buck & Jennifer Lee");
        filme.setTitulo("Frozen 2 - O Reino Gelado");
        filme.setDescricao("Porque será que Elsa nasceu com poderes mágicos? A resposta está a " +
                "atormentá-la e a ameaçar o seu reino. Juntamente com Anna, Kristoff, Olaf e Sven, " +
                "ela parte numa perigosa e memorável aventura. Em \"Frozen\", Elsa temia que os " +
                "seus poderes fossem demais para o mundo, em \"Frozen 2\" espera que sejam " +
                "suficientes.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-01-02"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(207.718);
        filme.setPosterPath("oUafkafJiFKkXuzROaAY8N9gGq.jpg");
        filme.setBackdropPath("wO5QSWZPBT71gMLvrRex0bVc0V9.jpg");
        filme.setGenero(new Genero(35, "Comédia"));
        filme.setDiretor("Vince Marcello");
        filme.setTitulo("A Banca dos Beijos 2");
        filme.setDescricao("Com a ida para a faculdade no horizonte, Elle tem de tomar decisões e " +
                "lidar com o namoro à distância com Noah, a amizade com Lee e os seus sentimentos " +
                "por um novo colega.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-07-24"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);
        filme = new Filme();
        filme.setPopularidade(209.768);
        filme.setPosterPath("DS1Xh1dxfrR1H0sqATPxkwWFzi.jpg");
        filme.setBackdropPath("R6cvRtZgsYCkh8UFuWFN33xBP4.jpg");
        filme.setGenero(new Genero(28, "Ação"));
        filme.setDiretor("Sam Hargrave");
        filme.setTitulo("Tyler Rake: Operação de Resgate");
        filme.setDescricao("A missão de um mercenário empedernido torna-se uma luta pela sobrevivência " +
                "e pela própria alma quando é enviado ao Bangladeche para resgatar o filho de um " +
                "barão da droga.");
        try {
            filme.setDataLancamento((Date) formatter.parse("2020-04-24"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lista.add(filme);

        return lista;
    }
}
