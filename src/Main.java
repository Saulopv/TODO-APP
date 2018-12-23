import java.util.EmptyStackException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Storage storage = new Storage();

    System.out.println("Welcome");
    Scanner scanner = new Scanner(System.in);
    while(true){
      String input = scanner.nextLine();
      System.out.print("\033[2J\033[;H");//Just for the terminal
      try{
        label:
        switch (input.toLowerCase()) {
          case "quit":
            System.exit(0);
          case "new":
            if (storage.getSize() == 50) {
              System.out.println("You have 50 todo's! Maybe you should" +
                      " complete some of them before adding more? ;)");
              break;
            }
            System.out.println("Type in your new task.");
            String newTask = scanner.nextLine();
            storage.newTask(newTask);
            break;
          case "edit":
            String newInput = scanner.nextLine().toLowerCase();
            if (newInput.equals("change") || newInput.equals("remove")
                    || newInput.equals("switch")) {
              switch (newInput) {
                case "remove":
                  String toRemove = scanner.nextLine();
                  storage.removeTask(toRemove);
                  break;
                case "change":
                  String index = scanner.nextLine();
                  if (!storage.contains(index)) {
                    System.out.println("Does not exist!");
                    break label;
                  }
                  System.out.println("To what do wish to change?");
                  String newTodo = scanner.nextLine();
                  storage.change(storage.getTask(index), newTodo);
                  break;
                default:
                  System.out.println("Enter first index to switch!");
                  String first = scanner.nextLine();
                  if (!storage.contains(first)) {
                    System.out.println("Wrong index!");
                    break label;
                  }
                  System.out.println("Enter second index to switch!");
                  String second = scanner.nextLine();
                  if (!storage.contains(second)) {
                    System.out.println("Wrong index!");
                    break label;
                  }
                  storage.zwitch(first, second);
                  break;
              }
            } else {
              break;
            }
          default:
            break;
        }
          if(storage.contains(input)){
          storage.getTask(input).setDone();
        } else {
          System.out.print("Option does not exist.\n");
        }
      } catch (NumberFormatException e) {

      } catch (EmptyStackException e) {
        System.out.print("Empty stack!");
      }
      System.out.println(storage.toString());
    }
  }
}
