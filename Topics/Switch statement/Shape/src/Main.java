import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] shapes = {"", "square", "circle", "triangle", "rhombus"};
        int shape = scanner.nextInt();
        if (shape > 0 && shape < shapes.length) {
            System.out.printf("You have chosen a %s", shapes[shape]);
        } else {
            System.out.println("There is no such shape!");
        }
    }
}