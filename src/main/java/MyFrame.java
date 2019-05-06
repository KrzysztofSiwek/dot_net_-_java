
import javax.swing.JFrame;
import java.awt.Dimension;

public class MyFrame extends JFrame {



    public MyFrame(int x, int y) {
        setUndecorated(true);
        setMinimumSize(new Dimension(50,100));
        setLocationRelativeTo(null);
        setLocation(x,y);
        setVisible(true);
    }
}