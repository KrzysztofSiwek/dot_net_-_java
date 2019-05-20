import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


class MainWindow extends JFrame{

    boolean newGame = false;

    public void newGame(){

    }
    ActionListener act = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            getContentPane().removeAll();
            getContentPane().repaint();
            runGame();



        }
    };

    public void runGame(){
        setLayout(null);
        JPanel panel = new JPanel();
        JButton b = new JButton("cdo");
        panel.setSize(1200,750);
        panel.add(b);
        add(panel);
        setVisible(true);

    }
    


    public void setMain(){

        JPanel panel = new JPanel();
        JButton button = new JButton("Start");

        setContentPane(new JLabel(new ImageIcon("C:\\Users\\48888\\Desktop\\JAVA\\snake\\src\\image\\main.png")));
        setLayout(null);

        button.setBounds(550,400,400,100);
        button.setBackground(new Color(46,239, 53));
        add(button);

        panel.setLocation(0,0);

        setVisible(true);
        button.addActionListener(act);
    }


    public MainWindow() {

        setTitle("Main");
        setSize(1200, 750);

        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }


}
