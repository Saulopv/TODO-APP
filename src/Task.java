public class Task {
  private String task;
  private int nr;
  private boolean done;
  private static int amount=1;

  Task(int nr, String task){
    this.task = task;
    this.nr = nr;
    this.done = false;
  }

  Task getTask() {
    return this;
  }

  int getNr() {
    return nr;
  }

  public static int getAmount() {
    return amount;
  }

  void setTask(String task) {
    this.task = task;
  }

  void setDone() {
    if (done) {
      this.done = false;
    } else {
      this.done = true;
    }
  }

  public static void addAmount() {
    Task.amount++;
  }

  public String toString() {
    if(done){
      return this.nr+". " + this.task + "[X]";
    } else {
      return this.nr+". " + this.task + "[]";
    }
  }
}
