import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> listNumber = new ArrayList<>();

        ArrayList<Integer> listNumber1 = new ArrayList<>(25);
        ArrayList<Integer> listNumber2 = new ArrayList<>(25);
        ArrayList<Integer> listNumber3 = new ArrayList<>(25);
        ArrayList<Integer> listNumber4 = new ArrayList<>(25);

        for (int i =1; i<=100; i++){
            listNumber.add(i);
        }

        listNumber1.addAll(listNumber.subList(0,25));
        listNumber2.addAll(listNumber.subList(25,50));
        listNumber3.addAll(listNumber.subList(50,75));
        listNumber4.addAll(listNumber.subList(75,100));

        OddNumbers oddNumbers = new OddNumbers(listNumber1);
        Thread t1 = new Thread(oddNumbers);
        t1.start();

        EvenNumbers evenNumbers = new EvenNumbers(listNumber1);
        Thread t2 = new Thread(evenNumbers);
        t2.start();
    }
}
