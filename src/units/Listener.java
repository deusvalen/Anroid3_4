package units;

import organization.Organizations;

/**
 * Created by User on 12.09.2017.
 */

public class Listener extends Person {

    private Organizations org;

    public Listener(int year, String name, String surname, Organizations org) {
        super(year, name, surname);
        this.org = org;
        setMoney(org.getMoney());
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(this.getName() + " " + this.getSurname() + " " + this.getYear() + " " + org + " " + org.getMoney());
        return str.toString();
    }
}
