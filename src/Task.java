public interface Task {

    boolean startTask();//returns true if task was successfully started
    boolean isCompleted(); //returns completion state of the task
    String getName();
    long timeRemaining();

}
