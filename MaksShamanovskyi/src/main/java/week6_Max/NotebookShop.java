package week6_Max;

import java.sql.*;
import java.util.*;

public class NotebookShop {
    private Scanner sc = new Scanner(System.in);
    private Set<NoteBook> shopSet;
    private boolean closed;
    private static final String URL = "jdbc:mysql://localhost:3306/week6";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String SELECT = "SELECT models.company, models.model, proces.company, proces.frequency, " +
            "hdd.company, hdd.size, memory.company, memory.size, vcards.company, vcards.size, screens.size \n" +
            "FROM notebooks \n" +
            "JOIN models ON notebooks.model_id=models.id \n" +
            "JOIN proces ON notebooks.proc_id=proces.id\n" +
            "JOIN hdd ON notebooks.hdd_id=hdd.id\n" +
            "JOIN memory ON notebooks.memory_id=memory.id\n" +
            "JOIN vcards ON notebooks.vcard_id=vcards.id\n" +
            "JOIN screens ON notebooks.screen_id=screens.id;";
    private static final String INSERT = "INSERT INTO notebooks(model_id, proc_id, hdd_id, memory_id, vcard_id, screen_id)" +
            " VALUES(?, ?, ?, ?, ?, ?);";
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public NotebookShop() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        shopSet = new HashSet<>();
        closed = false;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(INSERT);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        connect();
    }

    private void connect() throws ClassNotFoundException {
        try (ResultSet resultSet = statement.executeQuery(SELECT)) {
            while (resultSet.next()) {
                Model model = new Model(resultSet.getString(1), resultSet.getString(2));
                Proc processor = new Proc(resultSet.getString(3), resultSet.getInt(4));
                Hdd hdd = new Hdd(resultSet.getString(5), resultSet.getInt(6));
                Memory memory = new Memory(resultSet.getString(7), resultSet.getInt(8));
                VideoCard videoCard = new VideoCard(resultSet.getString(9), resultSet.getInt(10));
                Screen screen = new Screen(resultSet.getFloat(11));
                shopSet.add(new NoteBook(model, processor, hdd, memory, videoCard, screen));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setNewNotebook() {
            System.out.println("Chose model of notebooks:");
            working("SELECT company, model FROM models", 2, 1);
            System.out.println("Chose proc of notebooks:");
            working("SELECT company, frequency FROM proces", 2, 2);
            System.out.println("Chose hdd of notebooks:");
            working("SELECT company, size FROM hdd", 2, 3);
            System.out.println("Chose memory of notebooks:");
            working("SELECT company, size FROM memory", 2, 4);
            System.out.println("Chose videocard of notebooks:");
            working("SELECT company, size FROM vcards", 2, 5);
            System.out.println("Chose screen of notebooks:");
            working("SELECT size FROM screens", 1, 6);
        try{
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void working(String select, int count, int pos) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(select)) {
            int i = 1;
            while (resultSet.next()) {
                if (count == 2) {
                    System.out.println(i + ". " + resultSet.getString(1) + " " + resultSet.getString(2));
                } else {
                    System.out.println(i + ". " + resultSet.getString(1));
                }
                i++;
            }
            int index = sc.nextInt();
            preparedStatement.setInt(pos, index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        if(!closed){
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
