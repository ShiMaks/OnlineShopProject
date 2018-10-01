package by.epam.shop.domain;

/**
 * Class describing Category entity from database
 *
 * @author Maksim Shilvian
 */
public class Category extends Entity {

    private static final long serialVersionUID = -3385004261121645360L;
    /**
     * Name of category
     */
    private  String name;

    public Category(){

    }

    public Category(int id, String name){
        super(id);
        this.name =name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Category category = (Category) o;

        return name != null ? name.equals(category.name) : category.name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category: " +
                "name= " + name + ", id= " + getId();
    }
}
