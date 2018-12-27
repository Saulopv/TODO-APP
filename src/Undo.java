import java.util.EmptyStackException;
import java.util.Stack;

public class Undo {
  private Stack<Storage> stack;
  private static Undo singleton = new Undo();

  private Undo() {
    this.stack = new Stack<>();
  }

  static Undo getInstance() {
    return singleton;
  }

  void pushTo(Storage storage) {
    stack.push(storage);
  }

  Storage popFrom() throws EmptyStackException {
    return this.stack.pop();
  }

  void copyStorage(Storage prevStorage, Undo stack) {
    Storage storage = new Storage();
    for (Integer i : prevStorage.getStorage().keySet()) {
      Task tmp = prevStorage.getStorage().get(i);
      Task newTask = storage.newTask(tmp.getTodo());
      newTask.setDone(tmp.getDone());
    }
    stack.pushTo(storage);
  }
}
