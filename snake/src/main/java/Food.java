import java.util.Random;

public class Food {
    Random random = new Random();
    private int foodX = 50;
    private int foodY = 50;;


    public void newPos(){
        this.foodX = random.nextInt(100);
        this.foodY = random.nextInt(100);
    }

    public int getFoodX() {

        return foodX;
    }

    public int getFoodY() {
        return foodY;
    }
}



