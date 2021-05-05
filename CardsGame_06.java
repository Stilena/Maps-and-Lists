import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> cardsPlayerOne = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> cardsPlayerTwo = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

int sum=0;
        while (cardsPlayerOne.size() > 0 && cardsPlayerTwo.size() > 0) {

            for (int i = 0; i < cardsPlayerOne.size(); i++) {
                int cardOne = cardsPlayerOne.get(i);
                int cardTwo = cardsPlayerTwo.get(i);
                if (cardOne > cardTwo) {
                   sumOfCards(cardOne,cardTwo,sum);
                    cardsPlayerTwo.remove(i);
                    cardsPlayerOne.add(cardOne);
                    //cardsPlayerOne.remove(Integer.valueOf(cardOne));
                    cardsPlayerOne.add(cardsPlayerOne.size() - 1, cardTwo);
                } else if (cardOne < cardTwo) {
                    sumOfCards(cardOne,cardTwo,sum);
                    cardsPlayerOne.remove(i);
                    cardsPlayerTwo.add(cardOne);
                    cardsPlayerTwo.add(cardsPlayerTwo.size() - 1, cardTwo);
                } else {
                    cardsPlayerOne.remove(i);
                    cardsPlayerTwo.remove(i);
                }
            }
        }
       printSum(sum,cardsPlayerOne,cardsPlayerTwo);
    }

    private static void printSum(int sum, List<Integer> cardsPlayerOne, List<Integer> cardsPlayerTwo) {
        if(cardsPlayerOne.isEmpty()){
            System.out.printf("Player Second wins! Sum: %d");
        }else {
            System.out.printf("Player First wins! Sum: %d");
        }
    }

    private static void sumOfCards(int cardOne, int cardTwo, int sum) {
        sum+=cardOne+cardTwo;
    }
}
