package j2ee.demo.service.impl;

import j2ee.demo.mapper.FavouriteMapper;
import j2ee.demo.model.Favourites;
import j2ee.demo.service.FavouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "favouritesService")
public class FavouritesServiceImpl implements FavouritesService {
    @Autowired
    private FavouriteMapper favouriteMapper;

    @Override
    public int addFavourite(Integer userId, Favourites favourites) {
        return favouriteMapper.insert(favourites);
    }

    @Override
    public int deleteFavourite(Integer userId, Integer favouriteId) {
        return favouriteMapper.delete(favouriteId);
    }

    @Override
    public Favourites findByName(String name) {
        return favouriteMapper.findByName(name);
    }
}
