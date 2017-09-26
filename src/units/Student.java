package units;

/**
 * Created by User on 12.09.2017.
 */

public class Student extends Person {
    private double rating;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Student(int year, String name, String surname, double rating) {
        super(year, name, surname);
        this.rating = rating;
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(this.getName() + " " + this.getSurname() + " " + this.getYear() + " " + this.getRating());
    return str.toString();
    }
}
