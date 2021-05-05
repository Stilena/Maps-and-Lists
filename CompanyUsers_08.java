import java.util.*;
import java.util.stream.Collectors;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        TreeMap<String, List<String>>information=new TreeMap<>();
       String command=scanner.nextLine();
        while (!command.equals("End")){
            String [] input=command.split("->");
            String name=input[0];
            String employee=input[1];
            if (!information.containsKey(name)){
                information.put(name,new ArrayList<>());
                 information.get(name).add(employee);
            }
            if (information.containsKey(name) && !information.get(name).contains(employee)) {
                information.get(name).add(employee);
            }
            command=scanner.nextLine();
        }
        for (var entry : information.entrySet()) {
            System.out.println(entry.getKey());
            for (String ids : entry.getValue()) {
                System.out.println("--"+ ids);
            }
        }
    }
}
