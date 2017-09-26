package staff;

import units.Person;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Служит для работы со списком обучающихся
 * Created by User on 12.09.2017.
 */

public class Staff {
    private CopyOnWriteArrayList<Person> studlist; // Коллекция из обучающихся

    public Staff() {
        studlist = new CopyOnWriteArrayList<Person>();
    }

    public Staff(CopyOnWriteArrayList<Person> persons) {
        studlist = persons;
    }

    public List<Person> getStudlist() {
        return studlist;
    }

    public void setStudlist(CopyOnWriteArrayList<Person> studlist){
        this.studlist = studlist;
    }

    public void add (Person item) {
        studlist.add(item);
    }

    public void remove (Person item)
    {
        studlist.remove(item);
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        for (Person p : studlist)
        {
            result.append(p.toString()).append("\n");
        }
        return result.toString();
    }

}
