package random_persons;

import org.jetbrains.annotations.NotNull;
import organization.Organizations;
import units.Listener;
import units.Student;
import java.util.Random;

/**
 * Служит для генерации случайных слушателей и студентов
 * Created by User on 13.09.2017.
 */

public class RandomPerson {
    private static final Random random = new Random();
    static private String [] names = {"Dmitriy","Igor","Nikolay","Gleb","Ivan","Anton", "Roman","Maxim","Valentin","Ilia"};
    static private String [] surnames = {"Gulko","Panasuk","Kargin","Antipenko", "Gorevoi",
                          "Logvinov","Ritikov","Korsun","Lyolia","Stipakov"};

    private RandomPerson(){} // Приватный конструктор

    @NotNull
    public static Listener randomListener() {
        return new Listener(randomAge(), randomName(), randomSurname(), randomOrg());
    }
    @NotNull
    public static Student randomStudent() {
        return new Student(randomAge(), randomName(), randomSurname(), randomRating());
    }

    private static int randomAge() {
        return (random.nextInt(29)+1970);
    }

    private static String randomName() {
        return names[random.nextInt(names.length)];
    }

    private static String randomSurname() {
        return surnames[random.nextInt(surnames.length)];
    }

    private static double randomRating() {
        double rating = (Math.random()*6)+4;
        rating = Math.round(rating * 10.0) / 10.0;
        return rating;
    }

    private static Organizations randomOrg() {
        int size = Organizations.getVALUES().size();
        return Organizations.getVALUES().get(random.nextInt(size));
    }

}
