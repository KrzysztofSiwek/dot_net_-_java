import java.awt.*;
import java.util.ArrayList;

public class Snake {

    private int BOARDSIZEX = 1000;
    private int BOARDSIZEY = 660;
    private  int[] x = new int[(BOARDSIZEY*BOARDSIZEY)/20];
    private  int[] y = new int[(BOARDSIZEY*BOARDSIZEY)/20];
    private int speed = 10;
    private int segment = 1;
    private boolean moveLeft = false;
    private boolean moveRight = false;
    private boolean moveDown = false;
    private boolean moveUp = false;

    Snake(){
        x[0] = BOARDSIZEX/2 ;
        y[0] = BOARDSIZEY/2;
    }

    public void setSegment(){
        segment +=1;
    }

    public int getSegment(){
        return segment;
    }

    public void move(int direction){
        moveParameters(direction);
        for (int i = segment; i > 0; i--) {

            x[i] = x[(i - 1)];
            y[i] = y[(i - 1)];
        }

        if(moveLeft){

            x[0] -= speed;

        }
        if(moveRight){
            x[0] += speed;
        }
        if(moveDown){
            y[0]+= speed;
        }
        if(moveUp){
            y[0] -= speed;
        }

    }

    public void setSnake(){
        moveLeft = false;
        moveRight =false;
        moveUp = false;
        moveDown = false;
        x[0] = BOARDSIZEX/2 ;
        y[0] = BOARDSIZEY/2;
        segment = 1;
    }

    public int[] getTabX(){
        int[] tmp = new int[segment];
        for(int i =0; i<segment;i++){
            tmp[i] = x[i];
        }
        return tmp;
    }

    public int[] getTabY(){
        int[] tmp = new int[segment];
        for(int i =0; i<segment;i++){
            tmp[i] = y[i];
        }
        return tmp;
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

    public void stop(){
        moveLeft = false;
        moveRight =false;
        moveUp = false;
        moveDown = false;
    }



    public int snakeLenght(){
        return segment;
    }

    public int getSnakeX(int index) {
        return x[index];
    }

    public int getSnakeY(int index) {
        return y[index];
    }
}

