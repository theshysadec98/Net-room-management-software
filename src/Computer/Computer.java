package Computer;

import java.util.Timer;

public class Computer {
    private double price;
    private String nameComputer;
    private boolean turnComputer = false;
    private double money;

    public Computer(double price, String nameComputer, boolean turnComputer, double money) {
        this.price = price;
        this.nameComputer = nameComputer;
        this.turnComputer = turnComputer;
        this.money = money;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameComputer() {
        return nameComputer;
    }

    public void setNameComputer(String nameComputer) {
        this.nameComputer = nameComputer;
    }

    public boolean isTurnComputer() {
        return turnComputer;
    }

    public void setTurnComputer(boolean turnComputer) {
        this.turnComputer = turnComputer;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "price=" + price +
                ", nameComputer='" + nameComputer + '\'' +
                ", turnComputer=" + turnComputer +
                ", money=" + money +
                '}';
    }
}
