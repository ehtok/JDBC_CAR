package bean;

import annotation.MyColumn;
import annotation.MyTable;

import java.util.Objects;

@MyTable("car")
public class Car {
    private int identify;
    @MyColumn("name")
    private String name;
    @MyColumn("color")
    private String color;
    @MyColumn("price")
    private String price;

    public Car(int identify, String name, String color, String price) {
        this.identify = identify;
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public Car() {
    }

    public int getIdentify() {
        return identify;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return identify == car.identify && Objects.equals(name, car.name) && Objects.equals(color, car.color) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identify, name, color, price);
    }

    @Override
    public String toString() {
        return name + color +price ;

    }
}
