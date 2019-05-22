import java.util.Random;

public class Food {
    Random random = new Random();

    private int BOARDSIZEX = 1000;
    private int BOARDSIZEY = 660;
    private int foodX = 400;
    private int foodY = 400;


    public void newPos(int[] x, int[] y){
        this.foodX = random.nextInt(BOARDSIZEX/10 - 2) + 1;
        this.foodY = random.nextInt(BOARDSIZEY/10 - 2) + 1;
        this.foodX *= 10;
        this.foodY *= 10;
        for(int i = 0; i< x.length;i++){
            if((Math.abs(foodX - x[i])<10)&&(Math.abs(foodY - y[i])<10)){
                newPos(x,y);
            }
        }
    }

    public void setFood(){
        foodY = 400;
        foodX = 400;
    }

    public int getFoodX() {

        return foodX;
    }

    public int getFoodY() {
        return foodY;
    }
}



