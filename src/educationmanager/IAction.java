package educationmanager;

import exception.MyException;
import staff.Staff;

/**
 * Интерфейс для Manager
 * Created by User on 12.09.2017.
 */

public interface IAction {
    Staff createGroup(String filename);
    Staff generateCourse(int maxstudCount, int maxlistCount) throws MyException;
    int sumRanges(Staff anyCourse);
    int countListener(Staff anyCourse);
    Staff sortbyYear(Staff anyCourse);
}
