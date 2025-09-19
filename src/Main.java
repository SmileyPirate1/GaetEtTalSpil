import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Velkommen til spillet, gæt et tal: ");

        boolean play = true;

        while (play) {
            //Starter med at vælge sværhedsgrad
            System.out.println("Du skal vælge din sværhedsgrad valgmuligheder er : Let, Mellem, Svær");
            String difficulty = input.nextLine();
            int maxNumber = chooseDifficulty(difficulty);

            //Jeg finder nu mit random nummer
            int randomNumber = randomNumberGenerator(maxNumber);

            //Jeg skal nu starte spillet
            boolean game = false;

            for (int attempts = 0; attempts < 3; attempts++) {
                System.out.println("Gæt et tal");
                int guess = input.nextInt();
                input.nextLine();

                String returnFeedBack = checkGuess(randomNumber, guess);
                System.out.println(returnFeedBack);

                if (randomNumber == guess) {
                    //System.out.println("Du har gættet rigtigt!");
                    game = true;
                    break;
                }
            }
            if (!game) {
                System.out.println("Du har brugt alle dine gæt, det rigtige tal var: " + randomNumber);
            }
            System.out.println("Vil du gerne spille igen?");
            String answer = input.nextLine();
            play = handlePlayAgain(answer);
        }

    }

    //Metode 1 til at vælge sværhedsgrad
    public static int chooseDifficulty(String difficulty) {
        if (difficulty.equalsIgnoreCase("let")) {
            return 10;
        } else if (difficulty.equalsIgnoreCase("standard")) {
            return 50;
        } else if (difficulty.equalsIgnoreCase("svær")) {
            return 100;
        } else {
            System.out.println("Dit tal er ugyldigt, standard vælges automatisk");
            return 50;
        }
    }

    //Metode 2 til at genere et random tal
    public static int randomNumberGenerator(int max){
        return 1 + (int) (Math.random()*(max));
    }

    //Metode 3 til at tjekke op på ens gæt
    public static String checkGuess(int number, int guess){
        if (guess == number){
            return "Tillykke! Du gættede rigtigt";
        }
        else if (guess < number){
            return "Dit gæt skal være højere";
        }
        else {
            return "Dit gæt skal være lavere";
        }
    }

    //Metode 4 til at spørge om brugeren vil spille igen.
    public static boolean handlePlayAgain(String answer){
        switch (answer.toLowerCase()){
            case "ja":
                return true;
            case "nej":
                return false;
            default:
                System.out.println("Ugyldigt valg, spillet afsluttes");
                return false;
        }
    }
}