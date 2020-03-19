public class FixedTimeTask implements Task, Runnable{
    long taskLength; //in miliseconds
    String name;
    long startTime = -1;
    boolean isCompleted;





    public FixedTimeTask( String name, long taskLength){
        this.name = name;
        this.taskLength = taskLength;//*60000;
        isCompleted = false;
        //System.out.println("Task constructor called");
        //System.out.println("isCompleted: " + isCompleted);

    }


    public boolean startTask(){
        startTime = System.currentTimeMillis();
       // System.out.println("start task called");
       // System.out.println("isCompleted: " + isCompleted);
        new Thread(this).start();
            return true;


        //return false; //false if this function should not be called
    }


    public boolean isCompleted1() {
        long time = System.currentTimeMillis();
        if(time >= startTime + taskLength){
            return true;
        }
        return false;
    }

    public boolean isCompleted(){
        //System.out.println(isCompleted);
        return isCompleted;
    }

    public String getName(){
        return name;
    }


    public long timeRemaining() {
       long result = startTime + taskLength - System.currentTimeMillis();
       if(result < 0){
           result = 0;
       }
       return result;
    }


    public void run(){

      // System.out.println("task thread started");
       // System.out.println("isCompleted: " + isCompleted);
        try {
            Thread.sleep(taskLength);
        }catch (Exception e){e.printStackTrace();}

        isCompleted = true;
        //System.out.println("task thread timer finished");
        //System.out.println("isCompleted: " + isCompleted);
    }


}
