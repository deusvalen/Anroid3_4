package educationmanager;

import exception.MyException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import organization.Organizations;
import random_persons.RandomPerson;
import staff.Staff;
import units.Listener;
import units.Person;
import units.Student;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Comparator;

/**
 * Предназначен для организации групп,
 * Сортировка группы по параметрам,
 * Чтение JSON файла.
 * Created by User on 12.09.2017.
 */

public class Manager implements IAction {

    /**
     * Создает группу студентов по готовой JSON структуре
     * @param filename Путь к JSON файлу
     * @return группу студентов
     */
    @Override
    public Staff createGroup(String filename) {
        Staff staff = new Staff();
        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader(filename);
            Object jsonObj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) jsonObj;
            System.out.println(jsonObject);
            System.out.println("\nJSON file: ");
            getJsonStudents(staff, jsonObject);
            getJsonListeners(staff, jsonObject);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return staff;
    }


    private void getJsonListeners(Staff staff, JSONObject jsonObject) {
        JSONArray listeners = (JSONArray) jsonObject.get("listeners");
        for (Object listener1 : listeners) {
            JSONObject listener = (JSONObject) listener1;
            String name = (String) listener.get("name");
            String surname = (String) listener.get("surname");
            long age = (Long) listener.get("age");
            String company = (String) listener.get("company");
            System.out.println(name + " " + surname + " " + age + " " + company);
            staff.add(new Listener((int) age, name, surname, Organizations.castOrg(company)));
        }
    }

    private void getJsonStudents(Staff staff, JSONObject jsonObject) {
        JSONArray students = (JSONArray) jsonObject.get("students");
        for (Object student1 : students) {
            JSONObject student = (JSONObject) student1;
            String name = (String) student.get("name");
            String surname = (String) student.get("surname");
            long age = (Long) student.get("age");
            double rating = (Double) student.get("rating");
            System.out.println(name + " " + surname + " " + age + " " + rating);
            staff.add(new Student((int) age, name, surname, rating));
        }
    }


    /**
     * Случайно генерирует группу
     * @param maxstudCount количество студентов
     * @param maxlistCount количество слушателей
     * @return Группу студентов
     * @throws MyException Тест работы MyException
     */
    @Override
    public Staff generateCourse(int maxstudCount, int maxlistCount) throws MyException{
        if(maxstudCount < 0 || maxlistCount < 0) {
            throw new MyException("MyException works",1);
        }
        Staff staff = new Staff();
        for(int i = 0; i < maxstudCount ; i++){
            staff.add(RandomPerson.randomStudent());
        }
        for(int i = 0; i < maxlistCount ; i++){
            staff.add(RandomPerson.randomListener());
        }
        return staff;
    }

    /**
     * @param anyCourse Группа из студентов и слушателей
     * @return Количество денег полученное преподавателем за курс
     */
    @Override
    public int sumRanges(Staff anyCourse) {
        int money = 0;
        for(Person person: anyCourse.getStudlist()) {
            money += person.getMoney();
        }
        return money;
    }

    /**
     * @return Количество студентов на курсе
     */
    @Override
    public int countListener(Staff anyCourse) {

        return anyCourse.getStudlist().size();
    }

    /**
     * Сортировка студентов по году рождения
     */
    @Override
    public Staff sortbyYear(Staff anyCourse) {
        anyCourse.getStudlist().sort(Comparator.comparingInt(Person::getYear));
        return anyCourse;
    }

    /**
     * Сортировка студентов по Имени
     */
    public Staff sortbyName(Staff anyCourse){
        anyCourse.getStudlist().sort(Comparator.comparing(Person::getName));
        return anyCourse;
    }

}
