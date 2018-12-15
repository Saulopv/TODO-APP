import java.util.HashMap;

public class Storage {//TODO put limit on todos!
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

  Task getTask(String str){
    return storage.get(Integer.parseInt(str));
  }

  boolean contains(String str) {
    return storage.containsKey(Integer.parseInt(str));
  }

  int getSize(){
    return storage.size();
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

