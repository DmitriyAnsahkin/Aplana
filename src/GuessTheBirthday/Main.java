package GuessTheBirthday;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        do {
            mainText();
            int trickNumber = trickNumber();
            StringBuffer dateBir = gettingBirthdaySB(trickNumber);
            if (showResultAndContinue()) {
                System.out.println("Дата Вашего рождения ... Ну конечно же " + dateBir + " ! =)");
            }
        } while (repeatTrick());
    }

    private static void mainText() {
        System.out.println("Умножте на два число своего рождения.");
        System.out.println("А теперь прибавьте к получившемуся числу цифру 5 и умножте на 50.");
        System.out.println("И последнее: прибавьте к полученному результату номер месяца рождения.");
        System.out.println("(Июль - 7, Январь - 1, Сентябрь - 9 и т.д.) Введите резултат:");
    }

    private static int trickNumber() {
        Scanner scanner = new Scanner(System.in);
        int trickNumber = 0;
        boolean isValidOptions = false;
        do {
            try {
                trickNumber = scanner.nextInt();

                if (trickNumber < 351 || trickNumber > 3362) {
                    isValidOptions = false;
                    System.out.println("Кажется Вы допустили ошибку в расчетах. Пожалуйста, пересчитайте" +
                            " и введите число заного:");
                } else isValidOptions = true;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели некорректные данные. Попробуйте еще раз:");
                scanner.next();
            }
        } while (!isValidOptions);
        return trickNumber;
    }

    private static StringBuffer gettingBirthdaySB(int trickNumber) {
        String str = Integer.toString(trickNumber - 250);
        StringBuffer sb = new StringBuffer(str);
        if (sb.length() == 3) {
            sb.insert(0, "0");
        }
        sb.insert(2, ".");
        return sb;
    }

    private static boolean showResultAndContinue() {
        System.out.println("Ну что, готовы к чудесам?");
        System.out.println("Нажмите 1, если да");
        System.out.println("Нажмите 2, если хотите завершить работу программу, ну её, эту шайтан машину ...");
        System.out.println("Не знаю что она от меня хочет, боюсь, что и правда угадает =)");
        Scanner scanner = new Scanner(System.in);
        boolean isValidOptions = false;
        do {
            try {
                int answer = scanner.nextInt();
                if (answer == 2) System.exit(0);
                if (answer == 1) return true;

                if (answer != 1 || answer != 2) {
                    isValidOptions = false;
                    System.out.println("Кажется Вы ввели что-то не то, попробуйте еще раз.");
                    System.out.println("Ну что, готовы к чудесам?");
                    System.out.println("Нажмите 1, если да");
                    System.out.println("Нажмите 2, если хотите завершить работу программу, ну её, эту шайтан машину ..." +
                            "Не знаю что она от меня хочет, боюсь, что и правда угадает =)");
                } else {
                    if (answer == 2) System.exit(0);
                    if (answer == 1) return true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Вы ввели некорректные данные. Попробуйте еще раз:");
                System.out.println("Ну что, готовы к чудесам?");
                System.out.println("Нажмите 1, если да");
                System.out.println("Нажмите 2, если хотите завершить работу программу, ну её, эту шайтан машину ..." +
                        "Не знаю что она от меня хочет, боюсь, что и правда угадает =)");
                scanner.next();
            }
        } while (!isValidOptions);
        return true;
    }

    private static boolean repeatTrick (){
        Scanner scanner = new Scanner(System.in);
        boolean isValidOptions = false;
        do {
            try {
                System.out.println("Хотите сыграть еще раз? 1 - Да. 2 - Нет.");
                int repeatTrick = scanner.nextInt();
                if (repeatTrick == 1) {
                    return true;
                }
                if (repeatTrick == 2) {
                    System.exit(0);
                } else {
                    System.out.println("Такого варианта нет.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели некорректные данные. Попробуйте еще раз:");
                scanner.next();
            }

        } while (isValidOptions);
        return true;
    }

}
