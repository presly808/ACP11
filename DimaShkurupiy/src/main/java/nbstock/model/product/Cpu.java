package nbstock.model.product;

import java.sql.*;

/**
 * Created by Dima on 18.01.2016.
 */
public class Cpu {
    private int id;
    private String manufacturer;
    private int frequency;

    private static String tableName = "cpu";

    private Cpu(int id, String manufacturer, int frequency) {
        this.manufacturer = manufacturer;
        this.frequency = frequency;
    }

    public static Cpu cpuFactory(Connection db, String manufacturer, int frequency) throws SQLException {
        String query = "INSERT INTO " + tableName + " (manufacturer, frequency) VALUES (" + manufacturer + "," + frequency + ")";

        PreparedStatement statement = db.prepareStatement("INSERT INTO cpu(manufacturer, frequency) VALUES (?,?)");
        statement.setString(1,manufacturer);
        statement.setInt(2,frequency);

        statement.execute();

        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return new Cpu(generatedKeys.getInt(1),generatedKeys.getString(2),generatedKeys.getInt(3));
        } else {
            // Throw exception?
            System.out.println(" &&&&&&&&&");
        }

        return null;
    }

    private Cpu readFromDB() {

        return null;
    }

    public int getId() {
        return id;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

/*    public boolean equals(Object o) {
        Cpu otherCpu = (Cpu) o;
        return ( otherCpu.getFrequency() == this.frequency && otherCpu.getManufacturer().equals(this.manufacturer) );
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cpu)) return false;

        Cpu cpu = (Cpu) o;

        //if (getId() != cpu.getId()) return false;
        if (getFrequency() != cpu.getFrequency()) return false;
        return getManufacturer().equals(cpu.getManufacturer());

    }

    @Override
    public int hashCode() {
        return getId();
    }
}
