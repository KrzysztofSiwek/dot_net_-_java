import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class KeyLis implements KeyListener {

    private int move = 0;

    public int getMove(){
        return move;
    }

    @Override
    public void keyPressed(KeyEvent e){

        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT)){
            move = 1;
        }
        if ((key == KeyEvent.VK_RIGHT)){
            move = 2;
        }
        if ((key == KeyEvent.VK_DOWN)){
            move = 3;
        }
        if ((key == KeyEvent.VK_UP)){
            move = 4;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
