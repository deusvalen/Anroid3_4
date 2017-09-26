package units;

/**
 * Created by User on 12.09.2017.
 */

public abstract class Person {
    private int year;
    private String name;
    private String surname;
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Person(int year, String name, String surname)
    {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Person()
    {

    }
}
