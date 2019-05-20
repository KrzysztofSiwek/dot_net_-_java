import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main  {

    public static void main(String[] args) {
        MainWindow main = new MainWindow();
        Game game = new Game();

        main.setMain();
        while (true) {
            if (main.newGame) {
                game.run();
            }
        }


    }


}
