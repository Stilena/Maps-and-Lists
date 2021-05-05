import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer>numbers= Arrays.stream(scanner.nextLine().split("\\s+"))
        .map(Integer::parseInt).collect(Collectors.toList());
        String command=scanner.nextLine();
        while(!command.equals("end")){
            String [] tokens=command.split("\\s+");
            String text=tokens[0];
            int num=Integer.parseInt(tokens[1]);
            if (text.equals("Delete")){
                numbers.removeAll(Arrays.asList(num));
            }else if(text.equals("Insert")){
                int position=Integer.parseInt(tokens[2]);
                numbers.add(position,num);
            }
            command=scanner.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number+" ");
        }
    }
}
