
import javax.swing.JFrame;
import java.awt.Dimension;

public class MyFrame extends JFrame {

    public MyFrame() {
        setUndecorated(true);
        setMinimumSize(new Dimension(50,100));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}