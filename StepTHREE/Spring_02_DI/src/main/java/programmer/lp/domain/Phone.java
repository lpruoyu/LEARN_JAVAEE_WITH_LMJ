package programmer.lp.domain;

public class Phone {

    private String color;
    private Double price;
    private Screen screen;

    public Phone() { }

    public Phone(String color, Double price, Screen screen) {
        this.color = color;
        this.price = price;
        this.screen = screen;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
