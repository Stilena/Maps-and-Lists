import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commands = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();

        for (int i = 1; i <= commands; i++) {
            String text = scanner.nextLine();
            String[] tokens = text.split("\\s+");
            String name = tokens[0];
            if (tokens[2].equals("going!")) {
                if (names.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    names.add(name);
                }
            } else if (tokens[2].equals("not")) {
                if (names.contains(name)) {
                    names.remove(0);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        //System.out.println();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
