import java.util.Scanner;

class ConsoleReader implements Reader {

    @Override
    public String read() {
        Scanner scaner = new Scanner(System.in);
        return scaner.nextLine();
    }
}
