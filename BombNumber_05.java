import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumber_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //четем изречение от числа
        //четем специалното число и силата
        //премахнем числата от ляво и от дясно на спец число колкото е мощта
        //образуваме сума от останалите
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

    String [] token=scanner.nextLine().split("\\s+");
        int specialNum =Integer.parseInt( token[0]);
        int power =Integer.parseInt(token[1]) ;
        int sum=0;


        while (numbers.contains(specialNum)) {
            int index=numbers.indexOf(specialNum);
                int left = Math.max(0, specialNum - power);
                int right = Math.min(numbers.size() - 1, specialNum + power);
                for (int j = right; j >= left; j--) {
                        numbers.remove(j);
                }
            }

        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
/*reshenie!!!
package feb20_Lists_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P5_BombNumbers {
    public static void main(String[] args) {
        @SuppressWarnings("resource")

        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] input = sc.nextLine().split("\\s+");
        int bombNumber = Integer.parseInt(input[0]);
        int bombPower = Integer.parseInt(input[1]);

        int sum = 0;

        while (numbers.contains(bombNumber)) {
            int indexBomb = numbers.indexOf(bombNumber);

            int left = Math.max(0, indexBomb - bombPower);
            int right = Math.min(numbers.size() - 1, indexBomb + bombPower);

            for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println(sum);

    }
}*/