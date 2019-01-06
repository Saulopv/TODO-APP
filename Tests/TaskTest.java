import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {
  private Task task1 = new Task(1,"Laundry");
  private Task task2 = new Task(2,"Clean room");

  @Test
  public void getTodo() {
    assertEquals("Laundry" ,task1.getTodo());
  }

  @Test
  public void getTask() {
    assertEquals(task1, task1.getTask());
    assertNotEquals(task2, task1.getTask());
  }

  @Test
  public void getNr() {
    assertNotEquals(task1.getNr(), task2.getNr());
    assertEquals(2, task2.getNr());
  }

  @Test
  public void getAmount() {
    assertEquals(2, Task.getAmount());
  }

  @Test
  public void setTask() {
    assertEquals("Laundry", task1.getTodo());
    task1.setTask("Homework");
    assertEquals("Homework", task1.getTodo());
  }

 // @Test Not used?
 // public void setNr() {}

  @Test
  public void setDone() {
    task1.setDone();
    assertTrue(task1.getDone());
    task1.setDone();
    assertNotEquals(true, task1.getDone());
  }

  @Test
  public void setDone1() {
    task1.setDone(false);
    assertFalse(task1.getDone());
  }

  @Test
  public void getDone() {
    task1.setDone(true);
    assertTrue(task1.getDone());
  }

  @Test
  public void addAmount() {
    Task.addAmount();
    assertNotEquals(1, Task.getAmount());
    assertEquals(2, Task.getAmount());
  }

  @Test
  public void decreaseAmount() {
    Task.decreaseAmount();
    assertEquals(1, Task.getAmount());
  }

  @Test
  public void resetAmount() {
    for(int i=0; i<10; i++) {
      Task.addAmount();
    }
    Task.resetAmount();
    assertEquals(1, Task.getAmount());
  }
}