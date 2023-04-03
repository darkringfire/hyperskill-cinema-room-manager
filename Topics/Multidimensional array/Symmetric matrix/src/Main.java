import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean sym = true;
        int size = in.nextInt();
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = in.nextInt();
                if (i > 0 && j < i) {
                    sym = sym && arr[i][j] == arr[j][i];
                }
            }
        }
        System.out.println(sym ? "YES" : "NO");
    }
}