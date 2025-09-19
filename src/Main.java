import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hej og velkommen til gæt et tal spillet");
        System.out.println("Til at starte med skal du vælge en sværhedsgrad (let, mellem, svær)");

        String difficulty = input.nextLine();
        int chosenDifficulty = 0;
        boolean correct = true;

        do {
            if (difficulty.equals("let")) {
                chosenDifficulty = 10;
            } else if (difficulty.equals("mellem")) {
                chosenDifficulty = 50;
            } else if (difficulty.equals("svær")) {
                chosenDifficulty = 100;
            } else {
                System.out.println("vælg en sværhedsgrad");
                correct = false;
                difficulty = input.nextLine();
            }
        } while (correct == false );

    }
}