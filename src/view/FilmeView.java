package view;

import model.FilmeModel;

import java.util.Scanner;

public class FilmeView {

    private Scanner scan = new Scanner(System.in);

    public void exibirIniciando() {
        String[] animacao = {"Iniciando.", "Iniciando..", "Iniciando..."};
        try {
            for (String frame : animacao) {
                // LIMPA E VOLTA O CURSOR PRO TOPO (Instantâneo)
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // Imprime centralizado apenas com um pouco de margem
                System.out.println("\n\n\t\t   " + frame);
                Thread.sleep(600);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void exibirNomeApp() {
        try {
            String[] animacao = {"FilmFlix...", "FilmFlix..", "FilmFlix.", "FilmFlix"};
            for (String frame : animacao) {
                // Limpeza total (incluindo o que você veria ao rolar)
                System.out.print("\033[H\033[2J\033[3J");
                System.out.flush();

                System.out.println("\n\n\t\t   " + frame);
                Thread.sleep(600);
            }
            // Limpa antes de entregar para o menu
            System.out.print("\033[H\033[2J\033[3J");
            System.out.flush();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void limpaTela() {
        try {
            // Verifica se o sistema é Windows e executa o comando 'cls'
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Caso um dia rode no Linux/Mac, executa 'clear'
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Se falhar, não faz nada para não travar o app
        }
    }

    public void fichaTecnica(FilmeModel filme) {
        System.out.println("\n------- Ficha Tecnica -------");
        System.out.println("Titulo: " + filme.getTitulo());
        System.out.println("Ano de lancamento: " + filme.getAnoLancamento());
        System.out.println("Duracao: " + filme.getDuracaoFormatada());
        //System.out.println("Avaliacao: " + filme.getMediaFormatada());
        System.out.println("Avaliacao: " + filme.getAvaliacao());
        System.out.println("Views " + filme.getVisualizacao());
        System.out.println("-----------------------------");
    }

    public int exibeMenu() {
        limpaTela();
        System.out.println("""
                
                           FilmFlix
                ------------------------------
                      Digite sua Escolha
                
                      1. Adicionar Filme
                       2. Remover Filme
                      3. Visualizar Filme
                       4. Listar Filmes
                       5. Avaliar Filme
                        '0' para SAIR
                ------------------------------
                """);
        int s = scan.nextInt();
        scan.nextLine();
        return s;
    }

    public FilmeModel exibeMenuAdicionar() {
        System.out.println("Titulo do Filme: ");
        String titulo = scan.nextLine();
        System.out.println("Ano de lancamento do Filme: ");
        int anoLancamento = scan.nextInt();
        scan.nextLine();
        System.out.println("Duracao do Filme: (Em Minutos)");
        int duracao = scan.nextInt();
        scan.nextLine();
        return new FilmeModel(titulo, anoLancamento, duracao);

    }

    public String exibeMenuRemover() {
        System.out.println("Qual Filme deseja remover?");
        String confirmacao = scan.nextLine();
        return confirmacao;
    }

    public int removerFilme(String tituloFilme) {
        System.out.println("Tem certeza que deseja remover?\n" + tituloFilme);
        System.out.println("'1' SIM / '2' NAO");
        int confirmacao = scan.nextInt();
        scan.nextLine();
        return confirmacao;
    }

    public String visualizaFilme() {
        System.out.println("Qual filme deseja visualizar? ");
        String confirmacao = scan.nextLine();
        return confirmacao;
    }

    public void exibeFilmeView(String tituloFilme, int esq, int lado) {
        System.out.println("******************************");
        System.out.println("*                            *");
        System.out.println("*                            *");
        System.out.println("*" + " ".repeat(lado) + tituloFilme + " ".repeat(lado) + "*");
        System.out.println("*                            *");
        System.out.println("*                            *");
        System.out.println("******************************");
    }

    public String avaliarFilmeView() {
        System.out.println("Qual filme deseja avaliar? ");
        String confirmacao = scan.nextLine();
        return confirmacao;
    }

    public float avaliarFilmeValor() {
        System.out.println("Qual a NOTA  do Filme? (0 a 10 aceita valores decimais)");
        float confirmacao = scan.nextFloat();
        scan.nextLine();
        return confirmacao;
    }

    public float avaliarFilmeValor2() {
        System.out.println("Erro! So aceita valores entre 0 e 10!");
        System.out.println("Digite novamente: ");
        float confirmacao = scan.nextFloat();
        scan.nextLine();
        return confirmacao;
    }

    public void filmeNaoEncontrado() {
        System.out.println("Erro! Filme não encontrado!");
    }

    public void esperarEnter() {
        System.out.println("\n--- Pressione ENTER para voltar ao menu ---");
        scan.nextLine();
    }

    public void escolhaInvalida() {
        System.out.println("Opcao INVALIDA! Escolha um numero do MENU");
    }

    public void operacaoConfirmada() {
        System.out.println("Solicitacao Executada!");
    }

    public void operacaoCancelada() {
        System.out.println("Opcao CANCELADA!");
    }

    public int continuarAvaliacao() {
        System.out.println("Continuar avaliando? (1 SIM / 2 NAO)");
        int confirmacao = scan.nextInt();
        scan.nextLine();
        return confirmacao;
    }

    public void encerrarApp() {
        String[] animacao = {"Encerrando.", "Encerrando..", "Encerrando..."};
        try {
            for (String frame : animacao) {
                // LIMPA E VOLTA O CURSOR PRO TOPO (Instantâneo)
                System.out.print("\033[H\033[2J");
                System.out.flush();

                // Imprime centralizado apenas com um pouco de margem
                System.out.println("\n\n\t\t" + frame);
                Thread.sleep(600);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
