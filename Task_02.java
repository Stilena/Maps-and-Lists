import com.sun.security.jgss.GSSUtil;

import java.util.*;
public class Task_02 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String resource = scanner.nextLine(); //ресурс или stop
            //ресурс -> количество
            Map<String, Integer> resourcesQuantity = new LinkedHashMap<>();
            while(!resource.equals("stop")) {
                int quantity = Integer.parseInt(scanner.nextLine());

                //да нямам такъв ресурс
                if(!resourcesQuantity.containsKey(resource)) {
                    resourcesQuantity.put(resource, quantity);
                } else {
                    resourcesQuantity.put(resource, resourcesQuantity.get(resource) + quantity);
                }



                resource = scanner.nextLine();
            }

            resourcesQuantity.forEach((k, v) -> System.out.println(k + " -> " + v));

        }
    }

