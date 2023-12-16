package net.javaguides.springboot.model.favorites;

import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesRepository extends CrudRepository<Accommodation,Integer>{ //da vedere se tenere <Accommodation, Integer>
    @Query("SELECT f.accommodation FROM Favorites f WHERE f.user LIKE %:user%")
    List<Accommodation> findFavoritesAccommodationByUser(@Param("user")String user);  //cerca tutti i preferiti di quell utente

}