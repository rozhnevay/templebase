package ru.bmstu.templemanager.database;

import ru.bmstu.tamplebase.model.Temple;
import ru.bmstu.tamplebase.model.TempleFields;
import ru.bmstu.templebase.manager.BaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DatabaseTempleManager implements BaseManager<Temple, TempleFields> {
    public DatabaseTempleManager() {
        run();
    }

    private final String driverName = "com.mysql.jdbc.Driver";
    private final String connectionString = "jdbc:mysql://localhost:3306/temple";
    private final String login = "root";
    private final String password = "password";
    private Connection connection = null;
    private void run() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Can't get class. No driver found");
            e.printStackTrace();
            return;
        }
        try {
            connection = DriverManager.getConnection(connectionString, login, password);

        } catch (SQLException e) {
            System.out.println("Can't get connection. Incorrect URL");
            e.printStackTrace();

        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Can't close connection");
            e.printStackTrace();
            return;
        }}

    @Override
    public void add(Temple temple) {
        try{
            Statement st = connection.createStatement();
            st.execute("insert into temple(id, name) values (" + temple.getId() +"," + temple.getName() +")");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addAll(Collection<Temple> temples) {
        for (Temple t:temples) {
            add(t);
        }
    }

    @Override
    public Temple get(int id) {
        Temple temple = null;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from temple where id = " + id);
            while (rs.next()){
                temple = mapTemple(rs);
            };
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Temple mapTemple(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return new Temple(id, name);
    }

    @Override
    public Collection<Temple> getAll() {
        List<Temple> temples = new ArrayList<>();
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from temple");
            while (rs.next()){
                temples.add(mapTemple(rs));
            };
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Temple temple) {

    }

    @Override
    public void updateAll(Collection<Temple> temples) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Collection<Temple> searchBy(TempleFields field, String value) {
        return null;
    }
}
