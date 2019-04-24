import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Random;

public class GhostButton {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {

                Random r = new Random();
                JButton ghostButton = new JButton("Wkurzający przycisk ");

                MyFrame frame = new MyFrame();
                frame.add(ghostButton);

                ghostButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        frame.setLocation(r.ints(0, 1500).limit(1).findFirst().getAsInt(),r.ints(0, 500).limit(1).findFirst().getAsInt());
                        ghostButton.setBackground(
                                new Color(
                                r.ints(0,255).limit(1).findFirst().getAsInt(),
                                r.ints(0,255).limit(1).findFirst().getAsInt(),
                                r.ints(0,255).limit(1).findFirst().getAsInt()
                                )

                        );
                    }
                });

            }
        });
    }



}