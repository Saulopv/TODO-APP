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

  String getTodo(){
    return this.task;
  }

  Task getTask() { return this; }

  int getNr() {
    return nr;
  }

  public static int getAmount() {
    return amount;
  }

  void setTask(String task) {
    this.task = task;
  }

  public void setNr(int nr) {
    this.nr = nr;
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

  public static void decreaseAmount() {
    Task.amount--;
  }

  public String toString() {
    if(done){
      return this.nr+". " + this.task + "[X]";
    } else {
      return this.nr+". " + this.task + "[]";
    }
  }
}
