package nbstock.model.product;

/**
 * Created by Dima on 18.01.2016.
 */
public class Model {
    private int id;
    private String manufacturer;
    private String name;

    public Model(String manufacturer, String name) {
        this.manufacturer = manufacturer;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public boolean equals(Model otherModel) {
        return ( otherModel.getName().equals(this.name) && otherModel.getManufacturer().equals(this.manufacturer) );
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;

        Model model = (Model) o;

        //if (getId() != model.getId()) return false;
        if (getManufacturer() != null ? !getManufacturer().equals(model.getManufacturer()) : model.getManufacturer() != null)
            return false;
        return getName() != null ? getName().equals(model.getName()) : model.getName() == null;

    }

    @Override
    public int hashCode() {
        return getId();
    }
}
