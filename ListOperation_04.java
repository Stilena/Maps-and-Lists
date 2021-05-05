import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperation_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //четене на лист с цели числа
        //до получаване на end се дават операции
        //при невалидна операция invalid index
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] token = command.split("\\s+");
            String operation = token[0];
            switch (operation) {
                case "Add": {
                    int num = Integer.parseInt(token[1]);
                    numbers.add(num);
                    break;
                }
                case "Insert": {
                    int num = Integer.parseInt(token[1]);
                    int index = Integer.parseInt(token[2]);
                    if (isValid(index, numbers.size())) {
                        numbers.add(index, num);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                }
                case "Remove": {
                    int index = Integer.parseInt(token[1]);
                    if (isValid(index, numbers.size())) {
                        numbers.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                }
                case "Shift":
                    if (token[1].equals("left")) {
                        int count = Integer.parseInt(token[2]);
                        for (int i = 1; i <= count; i++) {
                            int firstNum = numbers.get(0);
                            numbers.remove(0);
                            numbers.add(firstNum);
                        }
                    } else if (token[1].equals("right")) {
                        int count = Integer.parseInt(token[2]);
                        for (int i = 1; i <= count; i++) {
                            int lastNum = numbers.get(numbers.size() - 1);
                            numbers.remove(numbers.size() - 1);
                            numbers.add(0,lastNum);
                        }
                    }
                    break;
            }
            command = scanner.nextLine();

        }
        for (Integer number : numbers) {
            System.out.print(number + " ");

        }
    }

    private static boolean isValid(int index,int length) {
      return index>=0 && index<=length-1;

    }
}