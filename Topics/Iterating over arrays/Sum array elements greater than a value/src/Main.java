import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        int n = in.nextInt();
        int sum = 0;
        for (int v : arr) {
            if (v > n) {
                sum += v;
            }
        }
        System.out.println(sum);
    }
}