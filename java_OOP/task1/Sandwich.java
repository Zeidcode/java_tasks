
public class Sandwich extends Product {
    public Sandwich(String name, double price, boolean isVegan) {
        super(name, price);
        this.setIsVegan(isVegan);
    }

    private boolean isVegan;

    public boolean getIsVegan() {
        return isVegan;
    }

    private void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        if (isVegan) {
            sb.append(", вегетарианский");
        }
        return sb.toString();
    }
}
