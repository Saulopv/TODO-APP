import java.util.HashMap;

public class Storage {
  private HashMap<Integer, Task> storage;

  public Storage(){
    this.storage = new HashMap<>();
    Task.resetAmount();
  }

  HashMap<Integer, Task> getStorage(){
    return this.storage;
  }

  void addToStorage(int nr,Task task) {
    storage.put(nr,task.getTask());
  }

  void addToStorage(Task task) {
    storage.put(task.getNr(), task.getTask());
  }

  void removeTask(String str) {
    int i = Integer.parseInt(str);
    if (contains(str)) {
      if(storage.size() == Integer.parseInt(str)) {
        storage.remove(Integer.parseInt(str));
        Task.decreaseAmount();
      }
      else if(storage.size() != Integer.parseInt(str) && storage.size() != 1) {
        i++;
        zwitch(str, Integer.toString(i));
        removeTask(Integer.toString(i));
      }
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

  @Override
  public String toString() {
    String taskList = "";
    for(int i=1; i<storage.size()+1; i++){
      if(i == storage.size()){
        taskList += getTask(Integer.toString(i));
      }else {
        taskList += getTask(Integer.toString(i)) + "\n";
      }
    }
    return taskList;
  }

  Task newTask(String todo){
    Task task = new Task(Task.getAmount(), todo);
    addToStorage(task);
    Task.addAmount();
    return task;
  }
}

