import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_04 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String command=scanner.nextLine();
        Map<String,Double>productPrice=new LinkedHashMap<>();
        Map<String,Integer>productCount=new LinkedHashMap<>();
        while(!command.equals("buy")){
            String [] input=command.split("\\s+");
           String product=input[0];
           double price=Double.parseDouble(input[1]);
           int count=Integer.parseInt(input[2]);
           productPrice.put(product,price);
            if (!productCount.containsKey(product)){
                productCount.put(product,count);
            }else {
                productCount.put(product,productCount.get(product)+count);
            }
            command=scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry:productPrice.entrySet()) {
            String productName=entry.getKey();
            double finalResult=entry.getValue()*productCount.get(productName);
            System.out.printf("%s -> %.2f%n", productName, finalResult);

        }
    }
}
