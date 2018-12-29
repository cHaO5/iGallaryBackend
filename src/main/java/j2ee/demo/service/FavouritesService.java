package j2ee.demo.service;

import j2ee.demo.model.Favourites;
import j2ee.demo.model.FavouritesMoment;

import java.util.List;

public interface FavouritesService {
    int addFavourite(Integer userId, Favourites favourites);

    int deleteFavourite(Integer userId, Integer favouriteId);

    Favourites findByName(String name);

    Favourites findByFavId(Integer favId);

    Integer findMomentFavouriteByUserIdAndMomentId(Integer userId, Integer momentId);

    Integer addMomentToFavourites(FavouritesMoment favouritesMoment);

    Integer deleteFavouritesMoment(Integer favId, Integer momentId);

    Integer moveToFavourites(Integer favMomId, Integer favId);
}
