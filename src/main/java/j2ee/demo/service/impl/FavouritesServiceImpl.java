package j2ee.demo.service.impl;

import j2ee.demo.mapper.FavouriteMapper;
import j2ee.demo.mapper.FavouritesMomentMapper;
import j2ee.demo.model.Favourites;
import j2ee.demo.model.FavouritesMoment;
import j2ee.demo.service.FavouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "favouritesService")
public class FavouritesServiceImpl implements FavouritesService {
    @Autowired
    private FavouriteMapper favouriteMapper;

    @Autowired
    private FavouritesMomentMapper favouritesMomentMapper;

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

    @Override
    public Favourites findByFavId(Integer favId) {
        return favouriteMapper.findByFavId(favId);
    }

    @Override
    public Integer findMomentFavouriteByUserIdAndMomentId(Integer userId, Integer momentId) {
        return favouriteMapper.findMomentFavouriteByUserIdAndMomentId(userId, momentId);
    }

    @Override
    public Integer addMomentToFavourites(FavouritesMoment favouritesMoment) {
        return favouritesMomentMapper.insert(favouritesMoment);
    }

    @Override
    public Integer deleteFavouritesMoment(Integer favId, Integer momentId) {
        return favouritesMomentMapper.delete(favId, momentId);
    }

    @Override
    public Integer moveToFavourites(Integer favMomId, Integer favId) {
        return favouritesMomentMapper.moveToFavourites(favMomId, favId);
    }
}
