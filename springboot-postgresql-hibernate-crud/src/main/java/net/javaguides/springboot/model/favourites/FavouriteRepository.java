package net.javaguides.springboot.model.favourites;

import net.javaguides.springboot.model.accomodation.Accommodation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FavouriteRepository extends CrudRepository<Favourite,Favourite>{ //da vedere se tenere <Accommodation, Integer>
    /*
    SELECT a
    FROM Favourite f JOIN Accommmodation a ON f.accommodation = a.id
    WHERE f.user = username
    */
    @Query(value = "SELECT a FROM Favourite f JOIN Accommodation a ON f.accommodation = a.id WHERE f.username = :#{#favourite.username}")
    List<Accommodation> findFavouritesAccommodationByUser(@Param("favourite") Favourite favourite);
    //cerca tutti i preferiti di quell utente

    @Query(value ="SELECT f from Favourite f")
    List<Favourite> findAll();
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO favourites (accommodation, username) VALUES (:#{#favourite.accommodation}, :#{#favourite.username})", nativeQuery = true)
    void saveFavourite(@Param("favourite")Favourite favourite);

}