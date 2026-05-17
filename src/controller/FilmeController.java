package controller;

import model.FilmeModel;
import view.FilmeView;

import java.util.ArrayList;
import java.util.List;

public class FilmeController {
    private List<FilmeModel> listaDeFilmes = new ArrayList<>();

    private FilmeView view = new FilmeView();

    public void iniciarApp() {
        view.exibirIniciando();
        adicionarFilmesAoSistema();
        view.exibirNomeApp();

        menuPrincipalLogica(99);

    }

    private void adicionarFilmesAoSistema() {
        listaDeFilmes.add(new FilmeModel("Interestelar", 2014, 169));
        listaDeFilmes.add(new FilmeModel("Ilha do Medo", 2010, 138));
        listaDeFilmes.add(new FilmeModel("A Origem", 2010, 148));
        listaDeFilmes.add(new FilmeModel("Piratas do Caribe", 2003, 143));
        listaDeFilmes.add(new FilmeModel("TeneT", 2020, 150));
        listaDeFilmes.add(new FilmeModel("Amnesia", 2000, 114));
        listaDeFilmes.add(new FilmeModel("Dunkirk", 2017, 106));
    }

    private void exibirTodasAsFichasTecnicas() {
        for (FilmeModel filme : listaDeFilmes) {
            view.fichaTecnica(filme);
        }
    }

    private FilmeModel procurarFilme(String nomeFilme) {

        for (FilmeModel filmeModel : listaDeFilmes) {

            if (filmeModel.getTitulo().equalsIgnoreCase(nomeFilme)) {
                return filmeModel;
            }
        }
        return null;
    }

    private void removerFilme(String nomeFilme) {
        FilmeModel filme = procurarFilme(nomeFilme);

        if (filme == null) {
            view.filmeNaoEncontrado();
            return;
        }

        int positivo = view.removerFilme(nomeFilme);

        if (positivo == 1) {
            listaDeFilmes.remove(filme);
            view.operacaoConfirmada();
            return;
        } else {
            view.operacaoCancelada();
            return;
        }
    }

    private void visualizarFilme(String nomeFilme) {

        FilmeModel filme = procurarFilme(nomeFilme);

        if (filme == null) {
            view.filmeNaoEncontrado();
            return;
        } else {
            filme.setVisualizacao();
            Medidas m = medidasTela(filme.getTitulo());

            view.exibeFilmeView(filme.getTitulo(), m.esq(), m.dir());
            view.fichaTecnica(filme);
        }
    }

    private Medidas medidasTela(String largura) {

        int larguraTotalLivre = 28;
        int sobra = larguraTotalLivre - largura.length();
        int esquerda = sobra / 2;
        int direita = sobra - esquerda;

        return new Medidas(esquerda, direita);
    }

    private void enviarAvaliacao() {
        int confirmacao;
        String nomeFilme;
        do {
            nomeFilme = view.avaliarFilmeView();
            FilmeModel filme = procurarFilme(nomeFilme);
            if (filme == null) {
                view.filmeNaoEncontrado();
                return;
            } else {
                float nota = view.avaliarFilmeValor();
                if (nota >= 0 && nota <= 10) {
                    filme.avaliar(nota);
                    visualizarFilme(nomeFilme);
                } else {
                    nota = view.avaliarFilmeValor2();
                    if (nota >= 0 && nota <= 10) {
                        filme.avaliar(nota);
                    } else {
                        view.operacaoCancelada();
                    }
                }
            }
            confirmacao = view.continuarAvaliacao();
        } while (confirmacao == 1);
    }

    private void menuPrincipalLogica(int escolha) {
        do {
            escolha = view.exibeMenu();
            switch (escolha) {

                case 1:
                    view.limpaTela();
                    FilmeModel novoFilme = view.exibeMenuAdicionar();
                    listaDeFilmes.add(novoFilme);
                    view.fichaTecnica(novoFilme);
                    view.esperarEnter();
                    break;

                case 2:
                    view.limpaTela();
                    String nomeRemoverFilme = view.exibeMenuRemover();
                    removerFilme(nomeRemoverFilme);
                    view.esperarEnter();
                    break;

                case 3:
                    view.limpaTela();
                    String nomeVisualizarFilme = view.visualizaFilme();
                    visualizarFilme(nomeVisualizarFilme);
                    view.esperarEnter();
                    break;

                case 4:
                    view.limpaTela();
                    exibirTodasAsFichasTecnicas();
                    view.esperarEnter();
                    break;

                case 5:
                    view.limpaTela();
                    enviarAvaliacao();
                    view.esperarEnter();
                    break;

                default:
                    view.limpaTela();
                    view.escolhaInvalida();
                    view.esperarEnter();
            }
        } while (escolha != 0);
        if (escolha == 0) {
            view.encerrarApp();
        }
    }

    private record Medidas(int esq, int dir) {
    }
}
