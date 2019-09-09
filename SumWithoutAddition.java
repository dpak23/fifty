package fiftyquestions;

public class SumWithoutAddition {


    public static int sum(int a, int b) {
        if (b == 0) return a;
        int partialSum = a ^ b;
        int carry = (a & b) << 1;
        return sum(partialSum, carry);
    }

    public static void main(String[] args) {
        System.out.print(sum(2, 4));
    }






}
