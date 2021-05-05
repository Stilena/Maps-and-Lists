import java.util.*;

public class SoftUniParking_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersOfCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> parkingList = new LinkedHashMap<>();
        for (int i = 0; i < numbersOfCommands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String name = input[1];

            if (command.equals("register")) {
                String number = input[2];
                if (!parkingList.containsKey(name)) {
                    parkingList.put(name, number);
                    System.out.println(name + " registered " + number + " successfully");
                } else {
                    System.out.println("ERROR: already registered with plate number " + number);
                }

            } else if (command.equals("unregister")) {
                if (!parkingList.containsKey(name)) {
                    System.out.printf("ERROR: user %s not found%n", name);
                } else {
                    parkingList.remove(name);
                    System.out.printf("%s unregistered successfully%n", name);
                }
            }
        }
        parkingList
                .forEach((key, value) -> System.out.println(String.format("%s => %s", key, value)));

    }
}