import educationmanager.Manager;
import exception.MyException;
import staff.Staff;

/**
 *
 *@author User
 */
public class Main {

    public static void main(String[] args) {
        try {
            Manager mng = new Manager();
            Staff staff = mng.generateCourse(2, 2); // test for MyException
            System.out.println(staff.toString());
            System.out.println("Total money: " + mng.sumRanges(staff));
            System.out.println("Guys: " + mng.countListener(staff));
            staff = mng.sortbyYear(staff);
            System.out.println("After sorting by year:");
            System.out.println(staff.toString());
            String filename = "c:\\document.json";
            staff = mng.createGroup(filename);
            System.out.println("\nParsed in objects: ");
            System.out.println(staff.toString());
            staff = mng.sortbyName(staff);
            System.out.println("\nAfter sorting by name:");
            System.out.println(staff.toString());
        }
        catch (MyException exp)
        {
            System.out.println("Exception cathced: " + exp.getNumber() + " " + exp.getMessage());
        }
    }
}
