
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;


class MainWindow extends JFrame{

    boolean newGame = false;
    private int BOARDSIZEX = 1200;
    private int BOARDSIZEY = 700;
    Game game = new Game();

    public MainWindow() {

        setTitle("Main");
        setSize(BOARDSIZEX, BOARDSIZEY);

        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }


    ActionListener act = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            getContentPane().removeAll();

            runGame();
            repaint();

        }
    };



    public void runGame(){

        game.initializeGame();
        add(game);
        game.requestFocus();
        setVisible(true);


    }



    public void setMain(){

        JPanel panel = new JPanel();
        JButton button = new JButton("Start");

        setContentPane(new JLabel(new ImageIcon("src\\image\\main.png")));
        setLayout(null);

        button.setBounds(550,400,400,100);
        button.setBackground(new Color(46,239, 53));
        add(button);

        panel.setLocation(0,0);

        button.addActionListener(act);
        setVisible(true);
    }





}
