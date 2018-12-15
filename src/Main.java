import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Storage storage = Storage.getInstance();

    System.out.println("Welcome");
    Scanner scanner = new Scanner(System.in);
    while(true){
      String input = scanner.nextLine();
      System.out.print("\033[2J\033[;H");
      try{
        switch (input.toLowerCase()){
            case "quit":
              System.exit(0);
            case "new":
              if(storage.getSize() == 50){
                System.out.println("You have 50 todo's! Maybe you should" +
                        " complete some of them before adding more? ;)");
                break;
              }
              System.out.println("Type in your new task.");
              String newTask = scanner.nextLine();
              new Storage.NewTask(newTask);
            default:
              break;
        }
        if(storage.contains(input)){
          storage.getTask(input).setDone();
        } else {
          System.out.print("Option does not exist.\n");
        }
      } catch (NumberFormatException e) { }
      System.out.println(storage.toString());
    }
  }
}
