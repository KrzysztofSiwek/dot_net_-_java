
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import  java.io.File;
import java.io.IOException;

class Window extends JFrame{



    JPanel panel = new JPanel();
    JButton button = new JButton("Start");
    ActionListener act = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Hello");
        }
    };

    public Window() {

        setTitle("Main");
        setSize(400, 400);


        button.addActionListener(act);

        panel.add(button);

        this.getContentPane().add(panel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}