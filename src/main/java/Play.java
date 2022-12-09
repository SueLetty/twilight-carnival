import java.util.Scanner;
public class Play {

  public static void main(String[] args) {
    //// TODO: 12/9/2022 clear console
    System.out.print("\033[H\033[2J");
    System.out.flush();

    Scanner input = new Scanner(System.in);
    System.out.println("you can go north");

    String direction = input.nextLine();
    System.out.println("you want to " + direction);


  }
}
