public class Task {
    private String task;
    private int nr;
    private boolean done;
    private static int amount = 0;

    Task(int nr, String task){
        this.task = task;
        this.nr = nr;
        this.done = false;
        this.amount++;//TODO
    }

    int getNr() {
        return nr;
    }

    public static int getAmount() {
        return amount;
    }

    void setDone() {
        if (done) {
            this.done = false;
        } else {
            this.done = true;
        }
    }

    Task getTask() {
        return this;
    }



    public String toString() {
        if(done){
            return this.nr+". " + this.task + "[X]";
        } else {
            return this.nr+". " + this.task + "[]";
        }
    }
}
