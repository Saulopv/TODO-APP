import java.util.HashMap;

public class Storage {
    private HashMap<Integer, Task> storage;

    Storage(){
        this.storage = new HashMap<>();

    }

    void addToStorage(Task task){
        storage.put(task.getNr(), task.getTask());
    }

    Task getTask(String str){
        return storage.get(Integer.parseInt(str));
    }

    boolean contains(String str){
        return storage.containsKey(Integer.parseInt(str));
    }

    @Override
    public String toString() {
        String taskList = "";
        for(int i=1; i<storage.size()+1; i++){//FIXME exception maybe? or assertion
            taskList += getTask(Integer.toString(i))+"\n";
        }
        return taskList;
    }
}
