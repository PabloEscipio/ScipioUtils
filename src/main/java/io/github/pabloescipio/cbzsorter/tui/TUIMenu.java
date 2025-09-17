package io.github.pabloescipio.cbzsorter.tui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TUIMenu {
    private String title;
    private List<String> options;

    public TUIMenu() {
        this.options = new ArrayList<>();
    }

    public TUIMenu(List<String> options) {
        this.options = options;
    }

    public TUIMenu(String title, List<String> options) {
        this.title = title;
        this.options = options;
    }

    private void displayMenu() {
        System.out.printf("----%s----\n", title.toUpperCase());

        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, options.get(i));
        }

        System.out.println("0. Exit");
    }

    /**
     * Displays the menu to the user and prompts him to choose one of the given option
     * <i>(or quit, which is represented by 0)</i>.
     *
     * @return The index of the chosen option <i>(+ 1, meaning that if the user chooses the
     * first option, this method would return 1)</i>, or 0 if the user exits out of the menu.
     */
    public int prompt() {
        Scanner sc = new Scanner(System.in);

        int eleccion = -1;
        while (true) {
            displayMenu();
            try {
                System.out.print("Choose an option by typing its associated number> ");
                eleccion = sc.nextInt();
            } catch (NumberFormatException ne) {
                System.err.println("You didn't specify a number.");
                continue;
            }

            if (eleccion >= 0 && eleccion <= options.size())
                return eleccion;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titulo) {
        this.title = titulo;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
