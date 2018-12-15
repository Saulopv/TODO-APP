import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Storage storage = Storage.getInstance();

    System.out.println("Welcome");
    Scanner scanner = new Scanner(System.in);
    while(true){
      boolean shift = true;
      String input = scanner.nextLine();

      try{
        switch (input.toLowerCase()){
            case "quit":
              System.exit(0);
            case "new":
              shift = false;
              if(storage.getSize() == 2){
                System.out.println("You have 10 todo's! Maybe you should" +
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
          System.out.print("Option does not exist.");
        }
      } catch (NumberFormatException e) {
        if(shift) {
          if(storage.getSize()>0){
            System.out.print("You pressed the key " + "'" + input + "'\n");
          }else{
            System.out.print("You pressed the key " + "'" + input + "'");
          }
        }
      }
      System.out.println(storage.toString());
    }
  }
}
