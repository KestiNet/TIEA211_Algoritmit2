import java.util.PriorityQueue;

public class PrioQu {
    public static void main(String[] args) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        int vali;


        numbers.add(4);
        numbers.add(7);
        numbers.add(3);
        for (int i = 0; i < numbers.size(); i++) {
            if (a[i] > a[j]) {
                vali = a[i];
                a[i] = a[j];
                a[j] = vali;
            }
            System.out.println("PrioQu: " + numbers);

        }
    }
}