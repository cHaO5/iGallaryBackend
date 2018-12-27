package j2ee.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FavouritesMoment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int favouritesId;

    private int momentId;

    public FavouritesMoment() {}

    public FavouritesMoment(int favouritesId, int momentId) {
        this.favouritesId = favouritesId;
        this.momentId = momentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFavouritesId() {
        return favouritesId;
    }

    public void setFavouritesId(int favouritesId) {
        this.favouritesId = favouritesId;
    }

    public int getMomentId() {
        return momentId;
    }

    public void setMomentId(int momentId) {
        this.momentId = momentId;
    }
}
