
public class Milk extends Product {
    public Milk(String name, double price, int fat) {
        super(name, price);
        this.setFat(fat);
    }
    private int fat;

    public int getFat() {
        return fat;
    }

    private void setFat(int fat) {
        this.fat = fat;
    }

    public String toString(){
        return String.format("%s, %d%% жирности", super.toString(), fat);
    }
}
