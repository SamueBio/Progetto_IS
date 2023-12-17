package net.javaguides.springboot.model.favourites;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends CrudRepository<Favourite,String>{ //da vedere se tenere <Accommodation, Integer>
    @Query(value="SELECT f FROM favourites f WHERE f.user = :username", nativeQuery = true)
    List<Favourite> findFavouritesAccommodationByUser(@Param("username")String username);  //cerca tutti i preferiti di quell utente

}