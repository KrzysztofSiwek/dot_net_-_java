import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.util.Random;
import javax.swing.Timer;


public class GhostButton {
    private final static int ONE_SECOND = 20;


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Random r = new Random();
                Timer timer = new Timer(ONE_SECOND, null);
                Move move = new Move();

                MyFrame frame = new MyFrame(move.old_x, move.old_y);
                JButton ghostButton = new JButton("Wkurzający przycisk ");

                frame.add(ghostButton);


                timer.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                        move.motion(frame);
                        move.stop(timer);

                    }

                });

                ghostButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        move.set_position();
                        timer.start();




                    }
                });

            }
        });



    }
}

