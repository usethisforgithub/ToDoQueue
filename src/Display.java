import java.io.IOException;

public class Display implements Runnable{

private static String OS = System.getProperty("os.name").toLowerCase();
    public Display(){}

    public void run(){
        String currentDisp = "";
        while(ToDoQueue.running){
            String stringToPrint = "Current Task: " + ToDoQueue.currentTask.getName() + "\nRemaining Time: " + ToDoQueue.currentTask.timeRemaining();
            if(!stringToPrint.equals(currentDisp)){
                currentDisp = stringToPrint;
                try{clearScreen();}catch(Exception e){}
                
                System.out.println(currentDisp);

            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void clearScreen() throws Exception{
        
        if (isWindows()) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} else if (isMac()) {
			System.out.print("\033[H\033[2J");
                System.out.flush();
		}
    }

    private static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	private static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}
}
