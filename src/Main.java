import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hej og velkommen til gæt et tal spillet");

        int chosenDifficulty = 0;
//        boolean correct = true;
        boolean play = true;

        do {

            System.out.println("Til at starte med skal du vælge en sværhedsgrad (let, mellem, svær)");
            String difficulty = input.nextLine();

//            do {
//                if (difficulty.equals("let")) {
//                    chosenDifficulty = 10;
//                } else if (difficulty.equals("mellem")) {
//                    chosenDifficulty = 50;
//                } else if (difficulty.equals("svær")) {
//                    chosenDifficulty = 100;
//                } else {
//                    System.out.println("vælg en sværhedsgrad");
//                    correct = false;
//                    difficulty = input.nextLine();
//                }
//            } while (correct == false );

            int choosenDifficulty = chooseDifficulty(difficulty);

            int number = 1 + (int)(choosenDifficulty * Math.random());



            for (int attempts = 1; attempts <= 3; attempts++) {
                System.out.println("gæt et tal: ");
                int guess = input.nextInt();

                if (guess == number) {
                    System.out.println("Tillykke, du har gættet rigtigt på " + attempts + " forsøg");
                    break;
                } else if (guess < number) {
                    System.out.println("Dit gæt var under tallet");
                } else {
                    System.out.println("Du gættede for højt");
                }
            }

            System.out.println("du har brugt alle dine gæt, vil du spille igen?");
            String again = input.nextLine();
            again = input.nextLine();

            switch (again) {
                case "ja":
                    play=true;
                    break;
                case "nej":
                    play=false;
                    break;
            }


        } while (play);



    }

    public static int chooseDifficulty(String difficulty) {
        Scanner input = new Scanner(System.in);

        boolean correct = true;
        int chosenDifficulty = 0;

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

        return (chosenDifficulty);
    }
}