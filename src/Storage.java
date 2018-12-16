import java.util.HashMap;

public class Storage {
  private HashMap<Integer, Task> storage;
  private static Storage singleton = new Storage();

  private Storage(){
    this.storage = new HashMap<>();
  }

  static Storage getInstance(){
    return singleton;
  }

  void addToStorage(Task task) {
    storage.put(task.getNr(), task.getTask());
  }

  void removeTask(String str){
    if (contains(str)) {
      storage.remove(Integer.parseInt(str));
      Task.decreaseAmount();
    }
  }

  Task getTask(String str){
    return storage.get(Integer.parseInt(str));
  }

  boolean contains(String str) {
    return storage.containsKey(Integer.parseInt(str));
  }

  int getSize(){
    return storage.size();
  }

  void zwitch(String str1, String str2){
    Task task1 = storage.get(Integer.parseInt(str1));
    Task task2 = storage.get(Integer.parseInt(str2));
    String tmp = task1.getTodo();
    task1.setTask(task2.getTodo());
    task2.setTask(tmp);
  }

  void change(Task task, String toChange){
    task.setTask(toChange);
  }

  void reassignIndex(){//TODO first case, middle case

  }

  @Override
  public String toString() {
    String taskList = "";
    for(int i=1; i<storage.size()+1; i++){//FIXME exception maybe? or assertion
      if(i == storage.size()){
        taskList += getTask(Integer.toString(i));
      }else {
        taskList += getTask(Integer.toString(i)) + "\n";
      }
    }
    return taskList;
  }

  static class NewTask{
    NewTask(String todo){
      Task task = new Task(Task.getAmount(), todo);
      singleton.addToStorage(task);
      Task.addAmount();
    }
  }
}
