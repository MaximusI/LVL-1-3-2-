package Main;
/* 2 * Создать массив из слов
String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
"cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
"peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если
слово не угадано, компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}; //25

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = new Random().nextInt(25);
        System.out.println("Компьютер загадал одно из слов:");
        System.out.println(Arrays.toString(words));
        String userCase;
        do {
            userCase = scanner.next();
            compareWords(userCase, words[i]);
        }   while (!userCase.equals(words[i]));
        System.out.println("Вы выиграли!" + " Компьютер загадал слово : " + words[i]);
    }

    private static void compareWords(String userCase, String word) {
        char[] masUsCase = userCase.toCharArray();
        char[] masWord = word.toCharArray();
        String partOfWord = "";
        if (userCase.equals(word)) return;

        for (int i = 0; i < masUsCase.length; i++) {
            if (masUsCase[i] == masWord[i])
                partOfWord += masWord[i];
        }
        for (int j = partOfWord.length(); j < 15; j++) {
            partOfWord += "#";
        }
        System.out.format("%s \n", partOfWord);
    }
}
