package app;

import controller.FilmeController;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // Força o Java a usar UTF-8 internamente e na saída
        System.setProperty("file.encoding", "UTF-8");
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        // O restante do seu código...
        FilmeController controller = new FilmeController();
        controller.iniciarApp();
    }
}