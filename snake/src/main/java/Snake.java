import java.awt.*;
import java.util.ArrayList;

public class Snake {


    private ArrayList<Point> snakePos = new ArrayList<Point>();
    private int speed = 5;

    private boolean moveLeft = false;
    private boolean moveRight = false;
    private boolean moveDown = false;
    private boolean moveUp = false;
    private int segment = 0;

    Snake(){
        snakePos.add(new Point(100,100));
    }

    public void move(int direction){
        moveParameters(direction);

//        System.out.println(snakePos);
        for(int i = segment;i >0 ;i--){
            snakePos.add(snakePos.get(i-1)) ;
        }
        if(moveLeft){
            snakePos.get(0).x -= speed;
        }
        if(moveRight){
            snakePos.get(0).x += speed;
        }
        if(moveDown){
            snakePos.get(0).y += speed;
        }
        if(moveUp){
            snakePos.get(0).y -= speed;
        }
    }

    public void moveParameters(int direction){

        if((direction == 1)&&(!moveRight)){
            moveLeft =true;
            moveUp = false;
            moveDown = false;

        }
        if((direction ==2)&&(!moveLeft)){
            moveRight =true;
            moveUp = false;
            moveDown = false;
        }
        if((direction == 3)&&(!moveUp)){
            moveRight =false;
            moveLeft = false;
            moveDown = true;
        }
        if((direction == 4) && (!moveDown)){
            moveRight =false;
            moveUp = true;
            moveLeft = false;
        }

    }

    public int getSegment(){
        return segment;
    }
    public void setSegment(int s){
         segment = s +1;
    }
    public void stop(boolean stop){
        if(!stop){
            moveLeft = false;
            moveRight =false;
            moveUp = false;
            moveLeft = false;
        }
    }



    public int snakeLenght(){
        return snakePos.size();
    }

    public int getSnakeX(int x) {
        return snakePos.get(x).x;
    }

    public int getSnakeY(int y) {
        return snakePos.get(y).y;
    }
}

