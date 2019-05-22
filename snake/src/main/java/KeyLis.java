import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class KeyLis implements KeyListener {

    private int move = 0;
    private boolean newGame = false;

    public boolean getNewGame(){
        return newGame;
    }

    public void setNewGame(boolean x){
        newGame = x;
    }

    public void setMove(){
        newGame = false;
        move = 0;

    }
    public int getMove(){
        return move;
    }

    @Override
    public void keyPressed(KeyEvent e){

        if ((e.getKeyCode() == KeyEvent.VK_LEFT)){
            move = 1;
        }
        if ((e.getKeyCode() == KeyEvent.VK_RIGHT)){
            move = 2;
        }
        if ((e.getKeyCode() == KeyEvent.VK_DOWN)){
            move = 3;
        }
        if ((e.getKeyCode() == KeyEvent.VK_UP)){
            move = 4;
        }
        if ((e.getKeyCode() == KeyEvent.VK_ENTER)){
            newGame = true;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
