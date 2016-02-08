package Store;


import java.sql.*;
import java.util.Scanner;
import java.net.*;
import java.lang.*;

public class Controller {

    public static final String URL = "jdbc:mysql://localhost:3306/store";
    public static final String USER = "root";
    public static final String PASSWORD = "1111";
    public static final String ALL_MODELS_QUERY = "SELECT id, provider, model FROM model";
    public static final String ALL_HDD_QUERY = "SELECT id, provider, size FROM hdd";
    public static final String ALL_CPU_QUERY = "SELECT id, provider, frequency FROM cpu";
    public static final String ALL_RAM_QUERY = "SELECT id, provider, ram_size FROM ram";
    public static final String ALL_SCREEN_QUERY = "SELECT id, screen_size FROM screen";
    public static final String ALL_VIDEOCARD_QUERY = "SELECT id, provider, video_size FROM videocard";

    //private Connection connection;

    AdminView adminView = new AdminView();

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public Controller() {
    }



    public Controller(Connection connection) {
        this.connection = connection;
    }


    public void showModels() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String getModelQuery = "SELECT id,provider,model FROM model";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getModelQuery);

        StringBuilder sb = new StringBuilder();
        while (resultSet.next()) {
            sb.append(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + "\n");
        }
        System.out.println("============ Models ============");
        System.out.print(sb.toString());
        System.out.println("================================");
        adminView.startMenu();
    }


        //   public void showModels() throws SQLException{
//        try {
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(ALL_MODELS_QUERY);
//            System.out.println("Models table:");
//
//            while(resultSet.next()){
//                int id = resultSet.getInt("id");
//                String provider = resultSet.getString("provider");
//                String model = resultSet.getString("model");
//                System.out.println(id + " " + provider + " " + model);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        System.out.println("================");
//        adminView.startMenu();
//    }




        public void showCPU() throws SQLException {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String getModelQuery = "SELECT id,provider,frequency FROM cpu";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getModelQuery);

            StringBuilder sb = new StringBuilder();
            while (resultSet.next()){
                sb.append(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getDouble(3) + "\n");
            }
            System.out.println("============ CPU ============");
            System.out.print(sb.toString());
            System.out.println("=============================");
            adminView.startMenu();
        }



    public void showHDD() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String getModelQuery = "SELECT id,provider,size FROM hdd";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getModelQuery);

        StringBuilder sb = new StringBuilder();
        while (resultSet.next()){
            sb.append(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + "\n");
        }
        System.out.println("============ HDD ============");
        System.out.print(sb.toString());
        System.out.println("=============================");
        adminView.startMenu();
    }



    public void showRAM() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String getModelQuery = "SELECT id,provider,ram_size FROM ram";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getModelQuery);

        StringBuilder sb = new StringBuilder();
        while (resultSet.next()){
            sb.append(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + "\n");
        }
        System.out.println("============ RAM ============");
        System.out.print(sb.toString());
        System.out.println("=============================");
        adminView.startMenu();
    }



    public void showScreen() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String getModelQuery = "SELECT id,screen_size FROM screen";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getModelQuery);

        StringBuilder sb = new StringBuilder();
        while (resultSet.next()){
            sb.append(resultSet.getInt(1) + " " + resultSet.getInt(2) + "\n");
        }
        System.out.println("============ Screen ============");
        System.out.print(sb.toString());
        System.out.println("================================");
        adminView.startMenu();
    }


    public void showVideocard() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String getModelQuery = "SELECT id,provider,video_size FROM videocard";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getModelQuery);

        StringBuilder sb = new StringBuilder();
        while (resultSet.next()){
            sb.append(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + "\n");
        }
        System.out.println("=========== Videocard ==========");
        System.out.print(sb.toString());
        System.out.println("================================");
        adminView.startMenu();
    }


    //====================================================================================


    public void addElement(Scanner sc) {
        System.out.println("addElement");
    }

    public void deleteElement(Scanner sc) {
        System.out.println("deleteElement");
    }

    public void selectNotebook(Scanner sc) {
        System.out.println("selectNotebook");
    }


    //================================  ADD  ====================================================

    public void addModels() throws SQLException {

        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String QUERY_models = "INSERT INTO model (provider,model) VALUES (?,?)";
        PreparedStatement preparedStatement_models = connection.prepareStatement(QUERY_models);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter provider: ");
        String provider = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();

        preparedStatement_models.setString(1,provider);
        preparedStatement_models.setString(2, model);
        preparedStatement_models.execute();

        System.out.println("New model has been added");
        adminView.startMenu();
    }

    public void addCPU() throws SQLException {

        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String QUERY_cpu = "INSERT INTO cpu (provider,frequency) VALUES (?,?)";
        PreparedStatement preparedStatement_models = connection.prepareStatement(QUERY_cpu);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter provider: ");
        String provider = scanner.nextLine();
        System.out.println("Enter frequency: ");
        String frequency = scanner.nextLine();

        preparedStatement_models.setString(1,provider);
        preparedStatement_models.setString(2, frequency);
        preparedStatement_models.execute();

        System.out.println("New CPU has been added");
        adminView.startMenu();
    }

    public void addHDD() throws SQLException {

        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String QUERY_hdd = "INSERT INTO hdd (provider,size) VALUES (?,?)";
        PreparedStatement preparedStatement_models = connection.prepareStatement(QUERY_hdd);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter provider: ");
        String provider = scanner.nextLine();
        System.out.println("Enter size: ");
        String size = scanner.nextLine();

        preparedStatement_models.setString(1,provider);
        preparedStatement_models.setString(2, size);
        preparedStatement_models.execute();

        System.out.println("New HDD has been added");
        adminView.startMenu();
    }

    public void addRAM() throws SQLException {

        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String QUERY_ram = "INSERT INTO ram (provider,ram_size) VALUES (?,?)";
        PreparedStatement preparedStatement_models = connection.prepareStatement(QUERY_ram);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter provider: ");
        String provider = scanner.nextLine();
        System.out.println("Enter RAM size: ");
        String ram_size = scanner.nextLine();

        preparedStatement_models.setString(1, provider);
        preparedStatement_models.setString(2, ram_size);
        preparedStatement_models.execute();

        System.out.println("New RAM has been added");
        adminView.startMenu();
    }

    public void addScreen() throws SQLException {

        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String QUERY_screen = "INSERT INTO screen (screen_size) VALUES (?)";
        PreparedStatement preparedStatement_models = connection.prepareStatement(QUERY_screen);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Screen size: ");
        String screen_size = scanner.nextLine();

        preparedStatement_models.setString(1,screen_size);
        preparedStatement_models.execute();

        System.out.println("New SCREEN has been added");
        adminView.startMenu();
    }


    public void addVideocard() throws SQLException {

        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String QUERY_videocard = "INSERT INTO videocard (provider,video_size) VALUES (?,?)";
        PreparedStatement preparedStatement_models = connection.prepareStatement(QUERY_videocard);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter provider: ");
        String provider = scanner.nextLine();
        System.out.println("Enter video_size: ");
        String video_size = scanner.nextLine();

        preparedStatement_models.setString(1, provider);
        preparedStatement_models.setString(2, video_size);
        preparedStatement_models.execute();

        System.out.println("New VIDEOCARD has been added");
        adminView.startMenu();
    }


//================================  DELETE  ====================================================


    public void deleteModels() throws SQLException {

        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String QUERY_models = "DELETE FROM model WHERE id = (?)";
        PreparedStatement preparedStatement_models = connection.prepareStatement(QUERY_models);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide MODEL ID which you are going to DELETE: ");
        String id = scanner.nextLine();

        preparedStatement_models.setString(1, id);
        preparedStatement_models.execute();

        System.out.println("Model has been deleted");
        adminView.startMenu();
    }


    public void deleteCPU() throws SQLException {

        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String QUERY_models = "DELETE FROM model WHERE id = (id) VALUES (?)";
        PreparedStatement preparedStatement_models = connection.prepareStatement(QUERY_models);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide model id ehich you are going to DELETE: ");
        String id = scanner.nextLine();

        preparedStatement_models.setString(1, id);
        preparedStatement_models.execute();

        System.out.println("Model has been deleted");
        adminView.startMenu();
    }

    public void deleteHDD() throws SQLException {

        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String QUERY_models = "DELETE FROM model WHERE id = (id) VALUES (?)";
        PreparedStatement preparedStatement_models = connection.prepareStatement(QUERY_models);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide model id ehich you are going to DELETE: ");
        String id = scanner.nextLine();

        preparedStatement_models.setString(1, id);
        preparedStatement_models.execute();

        System.out.println("Model has been deleted");
        adminView.startMenu();
    }

    public void deleteRAM() throws SQLException {

        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String QUERY_models = "DELETE FROM model WHERE id = (id) VALUES (?)";
        PreparedStatement preparedStatement_models = connection.prepareStatement(QUERY_models);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide model id ehich you are going to DELETE: ");
        String id = scanner.nextLine();

        preparedStatement_models.setString(1, id);
        preparedStatement_models.execute();

        System.out.println("Model has been deleted");
        adminView.startMenu();
    }

    public void deleteScreen() throws SQLException {

        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String QUERY_models = "DELETE FROM model WHERE id = (id) VALUES (?)";
        PreparedStatement preparedStatement_models = connection.prepareStatement(QUERY_models);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide model id ehich you are going to DELETE: ");
        String id = scanner.nextLine();

        preparedStatement_models.setString(1, id);
        preparedStatement_models.execute();

        System.out.println("Model has been deleted");
        adminView.startMenu();
    }

    public void deleteVideocard() throws SQLException {

        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        String QUERY_models = "DELETE FROM model WHERE id = (id) VALUES (?)";
        PreparedStatement preparedStatement_models = connection.prepareStatement(QUERY_models);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide model id ehich you are going to DELETE: ");
        String id = scanner.nextLine();

        preparedStatement_models.setString(1, id);
        preparedStatement_models.execute();

        System.out.println("Model has been deleted");
        adminView.startMenu();
    }



    //====================================================================================


    public void addNewModel() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String QUERY_models = "INSERT INTO models (producer,model) VALUES (?,?)";
        String QUERY_models_desc = "INSERT INTO models_desc (model_id,cpu_id,hdd_id,ram_id,graphic_id,screen_id)" +
                " VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement_models = connection.prepareStatement(QUERY_models);
        PreparedStatement preparedStatement_models_desc = connection.prepareStatement(QUERY_models_desc);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter producer: ");
        String producer = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();

        System.out.printf("Please choose CPU id for %s-%s\n",producer,model);
        System.out.println(new Controller(connection).cpuList());
        int cpuId = scanner.nextInt();

        System.out.printf("Please choose HDD id for %s-%s\n",producer,model);
        System.out.println(new Controller(connection).hddList());
        int hddId = scanner.nextInt();

        System.out.printf("Please choose RAM id for %s-%s\n",producer,model);
        System.out.println(new Controller(connection).ramList());
        int ramId = scanner.nextInt();

        System.out.printf("Please choose graphic id for %s-%s\n",producer,model);
        System.out.println(new Controller(connection).graphicList());
        int graphicId = scanner.nextInt();

        System.out.printf("Please choose screen id for %s-%s\n",producer,model);
        System.out.println(new Controller(connection).screenList());
        int screenId = scanner.nextInt();

        preparedStatement_models.setString(1,producer);
        preparedStatement_models.setString(2,model);
        preparedStatement_models.execute();

        ResultSet rs = connection.createStatement().executeQuery("select id from models;");
        int count = 1;
        while (rs.next()){
            count++;
        }

        preparedStatement_models_desc.setInt(1,count);
        preparedStatement_models_desc.setInt(2,cpuId);
        preparedStatement_models_desc.setInt(3,hddId);
        preparedStatement_models_desc.setInt(4,ramId);
        preparedStatement_models_desc.setInt(5,graphicId);
        preparedStatement_models_desc.setInt(6,screenId);
        preparedStatement_models_desc.execute();

        System.out.println("New model created successfully");
    }

    public String cpuList() throws SQLException {
        String getCPUquery = "SELECT id,producer,frequency FROM cpu";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getCPUquery);

        StringBuilder sb = new StringBuilder();
        while (resultSet.next()){
            sb.append("(" + resultSet.getInt(1) + "-" + resultSet.getString(2) + "-" + resultSet.getDouble(3) + "GHz)");
        }
        return sb.toString();
    }

    public String hddList() throws SQLException {
        String getHDDquery = "SELECT id,producer,capacity FROM hdd";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getHDDquery);

        StringBuilder sb = new StringBuilder();
        while (resultSet.next()){
            sb.append("(" + resultSet.getInt(1) + "-" + resultSet.getString(2) + "-" + resultSet.getInt(3) + ")");
        }
        return sb.toString();
    }

    public String ramList() throws SQLException {
        String getRAMquery = "SELECT id,producer,capacity FROM ram";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getRAMquery);

        StringBuilder sb = new StringBuilder();
        while (resultSet.next()){
            sb.append("(" + resultSet.getInt(1) + "-" + resultSet.getString(2) + "-" + resultSet.getInt(3) + "GB)");
        }
        return sb.toString();
    }

    public String graphicList() throws SQLException {
        String getGRAPHICquery = "SELECT id,producer,capacity FROM graphic";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getGRAPHICquery);

        StringBuilder sb = new StringBuilder();
        while (resultSet.next()){
            sb.append("(" + resultSet.getInt(1) + "-" + resultSet.getString(2) + "-" + resultSet.getInt(3) + "GB)");
        }
        return sb.toString();
    }

    public String screenList() throws SQLException {
        String getSCREENquery = "SELECT id,size FROM screen";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getSCREENquery);

        StringBuilder sb = new StringBuilder();
        while (resultSet.next()){
            sb.append("(" + resultSet.getInt(1) + "-" + resultSet.getInt(2) + "\")");
        }
        return sb.toString();
    }
}