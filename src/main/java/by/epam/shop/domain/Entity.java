package by.epam.shop.domain;

import java.io.Serializable;

/**
 * Class parent for all  application entities
 *
 * @author Maksim Shilvian
 */
public abstract class Entity implements Serializable{

    private static final long serialVersionUID = 8196397299359287215L;

    /**
     * Common ID field for all entities
     */
    private int id;

    public Entity() {
        super();
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
