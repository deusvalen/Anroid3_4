package organization;

import org.jetbrains.annotations.Contract;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Перечисление всех организаций из которых могут придти слушатели
 * Created by User on 12.09.2017.
 */

public enum Organizations {
    MICROSOFT(1000),
    APPLE(2000),
    EPAM(3000),
    YANDEX(4000),
    MAILRU(5000);

    @Contract(pure = true)
    public int getMoney() {
        return money;
    }

    /**
     * Поле деньги
     * Определяет выделяемые компанией средства на обучение слушателей
     */
    private final int money;

    Organizations(int money)
    {
        this.money = money;
    }

    @Contract(pure = true)
    public static List<Organizations> getVALUES() {
        return VALUES;
    }

    /**
     * Служит для преобразования названия компании к типу Organizations
     * @param org Является строковым представлением компании
     * @return Возвращает определенную организацию
     */
    @Contract(pure = true)
    public static Organizations castOrg(String org)
    {
        Organizations organization;
        switch (org)
        {
            case "MICROSOFT" : organization = Organizations.MICROSOFT; break;
            case "APPLE" : organization = Organizations.APPLE; break;
            case "YANDEX" : organization = Organizations.YANDEX; break;
            case "MAILRU" : organization = Organizations.MAILRU; break;
            case "EPAM" : organization = Organizations.EPAM; break;
            default: organization = Organizations.MICROSOFT;
        }
        return organization;
    }

    private static final List<Organizations> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

}
