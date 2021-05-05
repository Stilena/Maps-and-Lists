import java.util.*;

public class Courses_06 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, List<String>>course=new LinkedHashMap<>();
        while (!command.equals("end")){
            String [] input=command.split(" : ");
            String courseName=input[0];
            String studentName=input[1];
            if (!course.containsKey(courseName)){
                course.put(courseName,new ArrayList<>());
            }
            course.get(courseName).add(studentName);
            command=scanner.nextLine();
        }
        course.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue().stream()
                            .sorted(String::compareTo)
                            .forEach(student -> System.out.println("-- " + student));
                });
    }
}
