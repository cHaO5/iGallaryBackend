package j2ee.demo.service;

import j2ee.demo.model.Favourites;

public interface FavouritesService {
    int addFavourite(Integer userId, Favourites favourites);

    int deleteFavourite(Integer userId, Integer favouriteId);
}
