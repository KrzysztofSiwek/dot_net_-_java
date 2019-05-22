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
    private int GAMESIZEX = 1000;
    private int GAMESIZEY = 660;
    private int speed = 50;
    private KeyLis keyLis = new KeyLis();
    private Snake snake  = new Snake();
    private Food food = new Food();
    Image appleImg = Toolkit.getDefaultToolkit().getImage("src\\image\\apple.png");
    Image fieldImg = Toolkit.getDefaultToolkit().getImage("src\\image\\Field.png");
    Image overImg = Toolkit.getDefaultToolkit().getImage("src\\image\\over.png");
    Timer timer = new Timer(speed, this);
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
           snake.move(keyLis.getMove());
           checkCollision();
           checkFood();
           repaint();
        }

        if((!runGame)&&(keyLis.getNewGame())){
            initializeGame();
        }


    }

    void draw(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(0,0,BOARDSIZEX,BOARDSIZEY);

        g.drawImage(fieldImg,0,0, GAMESIZEX, GAMESIZEY,this);

        g.drawString( "Score:",1050,GAMESIZEY/2);
        g.drawString( Integer.toString((snake.getSegment() - 1) * 10),1050,GAMESIZEY/2 +10);

        if (runGame == true) {
            g.setColor(Color.BLUE);
            for(int i = 0; i<snake.snakeLenght();i++) {
                g.fillRect(snake.getSnakeX(i),snake.getSnakeY(i),SEGMENTX,SEGMENTY);
            }
            g.drawImage(appleImg,food.getFoodX(), food.getFoodY(),10,10,this);

        }
        else {
            g.setColor(Color.RED);
            g.drawImage(overImg,250, 200,500,250,this);
        }
    }


    public void initializeGame(){
        runGame = true;
        keyLis.setMove();
        snake.setSnake();
        food.setFood();
        timer.start();

    }



    public void checkFood(){

        if((Math.abs(snake.getSnakeY(0)-food.getFoodY()) < 10) && (Math.abs(snake.getSnakeX(0)-food.getFoodX()) < 10)  )
            {
            food.newPos(snake.getTabX(),snake.getTabY());
            snake.setSegment();


        }
    }
    public boolean getGame(){
        return runGame;
    }
    public void checkCollision(){
        for (int i = snake.getSegment(); i > 0; i--) {
            if ((i > 1)
                    && (snake.getSnakeX(0) == snake.getSnakeX(i) && (snake
                    .getSnakeY(0) == snake.getSnakeY(i)))) {
                runGame = false;
            }
        }
        if((snake.getSnakeX(0)>= GAMESIZEX)|| (snake.getSnakeX(0) <= 0)){
            runGame =false;
        }
        if((snake.getSnakeY(0) >= GAMESIZEY) || (snake.getSnakeY(0) <=0)){
            runGame = false;
        }
    }
}


