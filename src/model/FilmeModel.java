package model;

public class FilmeModel {
    private String titulo;
    private int anoLancamento;
    private int duracao;
    private float avaliacao;
    private int quantidadeAvaliacao;
    private int visualizacao = 0;

    public FilmeModel(String titulo, int anoLancamento, int duracao) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.duracao = duracao;
    }

    public void avaliar(float nota) {
        avaliacao += nota;
        quantidadeAvaliacao++;
    }

    public float getMediaAvaliacao() {
        if (quantidadeAvaliacao == 0) return 0;
        return (avaliacao / quantidadeAvaliacao) / 2;
    }

    /*public String getMediaFormatada() {
        float media = getMediaAvaliacao();
        if (media == 0) {
            return "0";
        }
        int estrelasInteiras = (int) media;
        String estrelas = "★".repeat(estrelasInteiras);

        if (media > estrelasInteiras) {
            return (estrelasInteiras == 0) ? "0+" : estrelas + "+";
        }
        return estrelas;
    }*/

    public String getDuracaoFormatada() {
        int horas = duracao / 60;
        int minutos = duracao % 60;
        return horas + "h " + minutos + "min";
    }

    public int getVisualizacao() {
        return visualizacao;
    }

    public void setVisualizacao() {
        this.visualizacao ++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public float getAvaliacao() {
        return avaliacao;
    }

    public int getQuantidadeAvaliacao() {
        return quantidadeAvaliacao;
    }

}
