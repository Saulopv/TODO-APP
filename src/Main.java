import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();

        String s = "Tvätta";
        String s2 = "Gymma";
        String s3 = "Chillar";
        Task task = new Task(1, s); //TODO, no input
        Task task2 = new Task(2, s2);
        Task task3 = new Task(3, s3);
        storage.addToStorage(task);
        storage.addToStorage(task2);
        storage.addToStorage(task3);

        System.out.println("Welcome");
        while(true){
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
             try{
                switch (input.toLowerCase()){
                    case "quit":
                        System.exit(0);
                    case "new":
                        System.out.println("New task input");//TODO
                    default:
                        break;
                }
                if(storage.contains(input)){
                    storage.getTask(input).setDone();
                } else {
                    System.out.println("Option does not exist.");
                }
                    } catch (NumberFormatException e) {
                         System.out.println("You pressed the key " + "'"+input+"'" + "\n");
                    }

                    System.out.println(storage.toString());
        }
    }
}
