import javax.swing.JFrame;
import java.util.Random;
import javax.swing.Timer;


public class Move {
    private final static int FIRST_POSITION = 500;
    public int x = FIRST_POSITION;
    public int y = FIRST_POSITION;
    public int old_x = FIRST_POSITION;
    public int old_y = FIRST_POSITION;

    public void motion(JFrame frame){

        if(y < old_y){
            old_y -= 1;
        }
        else if(y > old_y){
            old_y += 1;
        }
        else{
            old_y = y;
        }

        if(x < old_x){
            old_x -= 1 ;
        }
        else if(x > old_x){
            old_x += 1;
        }
        else{
            old_x = x;
        }

        frame.setLocation(old_x,old_y);

    }

    public void stop(Timer timer){

        if(x == old_x && y == old_y){
            timer.stop();
            System.out.println("stare");
        }
    }

    public void set_position(){
        Random position = new Random();
        if(position.nextBoolean()){

            y = position.ints(0, 1000).limit(1).findFirst().getAsInt();
        }
        else{

            x = position.ints(0, 1000).limit(1).findFirst().getAsInt();
        }



    }
}
