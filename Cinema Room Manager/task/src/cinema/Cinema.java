package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    private static final Scanner in = new Scanner(System.in);

    private static void showRoom(int totalRows, int totalSeats, boolean[][] room) {
        System.out.println("\nCinema:");
        for (int i = 0; i <= totalRows; i++) {
            for (int j = 0; j <= totalSeats; j++) {
                int s = i + j;
                if (s == 0) {
                    System.out.print(" ");
                } else if (s == i) {
                    System.out.print(i);
                } else if (s == j) {
                    System.out.print(j);
                } else {
                    System.out.print(room[i - 1][j - 1] ? "B" : "S");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int calcProfit(int rows, int rowSeats) {
        if (rows * rowSeats > 60) {
            return (rows * 8 + rows / 2 * 2) * rowSeats;
        } else {
            return rows * rowSeats * 10;
        }
    }

    private static int getTicketPrice(int totalRows, int totalSeats, int row) {
        return totalRows * totalSeats > 60 && row > totalRows / 2 ? 8 : 10;
    }

    private static int getChoice() {
        System.out.println("""
                                
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit""");
        return in.nextInt();
    }

    private static void buyTicket(int totalRows, int totalSeats, boolean[][] room) {
        while (true) {
            System.out.println("\nEnter a row number:");
            int row = in.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seat = in.nextInt();

            if (row < 1 || row > totalRows || seat < 1 || seat > totalSeats) {
                System.out.println("\nWrong input!");
            } else if (room[row - 1][seat - 1]) {
                System.out.printf("""
                                            
                        That ticket has already been purchased!
                        """);
            } else {
                room[row - 1][seat - 1] = true;
                System.out.printf("""
                                        
                        Ticket price: $%d
                        """, getTicketPrice(totalRows, totalSeats, row));
                break;
            }
        }
    }

    private static void showStatistic(int totalRows, int totalSeats, boolean[][] room) {
        int purchased = 0;
        int income = 0;
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalSeats; j++) {
                if (room[i][j]) {
                    purchased++;
                    income += getTicketPrice(totalRows, totalSeats, i + 1);
                }
            }
        }
        System.out.printf("""
                                                    
                        Number of purchased tickets: %d
                        Percentage: %.2f%%
                        Current income: $%d
                        Total income: $%d
                        """,
                purchased,
                (float) purchased * 100 / (totalRows * totalSeats),
                income,
                calcProfit(totalRows, totalSeats));
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        int totalRows = in.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int totalSeats = in.nextInt();

        boolean[][] room = new boolean[totalRows][totalSeats];
        for (boolean[] row : room) {
            Arrays.fill(row, false);
        }

        while (true) {
            int choice = getChoice();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                showRoom(totalRows, totalSeats, room);
            } else if (choice == 2) {
                buyTicket(totalRows, totalSeats, room);
            } else if (choice == 3) {
                showStatistic(totalRows, totalSeats, room);
            }
        }
    }
}