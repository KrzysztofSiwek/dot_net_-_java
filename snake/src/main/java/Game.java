import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import java.awt.*;

public class Game extends JPanel  implements ActionListener {



    private boolean runGame = true;
    private int SEGMENTX = 10;
    private int SEGMENTY = 10;
    private int BOARDSIZEX = 1200;
    private int BOARDSIZEY = 700;
    private int GAMESIZEX = 900;
    private int GAMESIZEY = 700;
    private int speed = 50;
    private KeyLis keyLis = new KeyLis();
    private Snake snake  = new Snake();
    private Food food = new Food();

    Game(){

        setBackground(Color.BLACK);
        setSize(BOARDSIZEX,BOARDSIZEY);
        setFocusable(true);

        this.addKeyListener(keyLis);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(runGame){
            checkCollision();
            checkFood();
            snake.move(keyLis.getMove());
            repaint();
        }
        else{
            snake.stop(runGame);
        }


    }


    void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,GAMESIZEX,GAMESIZEY);

        if (runGame == true) {
            for(int i = 0; i<snake.snakeLenght();i++) {
                g.setColor(Color.BLUE);
                g.fillRect(snake.getSnakeX(i),snake.getSnakeY(i),SEGMENTX,SEGMENTY);
            }

            g.setColor(Color.green);
            g.fillRect(food.getFoodX(), food.getFoodY(), SEGMENTX, SEGMENTY); // food

        }
        else {
            g.setColor(Color.RED);
            g.drawString("Game Over", 450,350);
        }
    }


    public void initializeGame(){

        Timer timer = new Timer(speed, this);
        timer.start();

    }

    public void checkFood(){

        if((Math.abs(snake.getSnakeY(0)-food.getFoodY()) < 10) && (Math.abs(snake.getSnakeX(0)-food.getFoodX()) < 10)  )
            {
            food.newPos();
            System.out.println(food.getFoodX());
            snake.setSegment(snake.getSegment());

        }
    }

    public void checkCollision(){
        if((snake.getSnakeX(0)>= GAMESIZEX)|| (snake.getSnakeX(0) <= 0)){
            runGame =false;
        }
        if((snake.getSnakeY(0) >= GAMESIZEY) || (snake.getSnakeY(0) <=0)){
            runGame = false;
        }
    }
}


