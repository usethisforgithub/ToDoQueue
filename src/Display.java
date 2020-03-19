import java.io.IOException;

public class Display implements Runnable{

    public Display(){}

    public void run(){
        String currentDisp = "";
        while(ToDoQueue.running){
            String stringToPrint = "Current Task: " + ToDoQueue.currentTask.getName() + "\nRemaining Time: " + ToDoQueue.currentTask.timeRemaining();
            if(!stringToPrint.equals(currentDisp)){
                currentDisp = stringToPrint;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(currentDisp);

            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
