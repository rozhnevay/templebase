package ru.bmstu.test;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import ru.bmstu.tamplebase.model.Temple;
import ru.bmstu.tamplebase.model.TempleFields;
import ru.bmstu.templebase.manager.BaseManager;
import ru.bmstu.templemanager.database.DatabaseTempleManager;
import ru.bmstu.test.templebase.manager.TestBaseManager;

import java.util.List;

public class DataBaseTest {
    private BaseManager<Temple, TempleFields> baseManager = new DatabaseTempleManager();
    private Temple current;

    @Дано("^Объекты в базе данных$")
    public void объекты_в_базе(List<Temple> temples) throws Throwable {
        baseManager.addAll(temples);
        Assert.assertFalse(baseManager.getAll().isEmpty());
    }


    @Когда("^передаем (\\d+) в менеджер$")
    public void передаем_в_менеджер(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        current = baseManager.get(arg1);
        Assert.assertNotNull(current);
    }

    @Тогда("^менеджер \"([^\"]*)\"$")
    public void менеджер(String arg1) throws Throwable {
        Assert.assertEquals(arg1, current.getName());
    }

}
