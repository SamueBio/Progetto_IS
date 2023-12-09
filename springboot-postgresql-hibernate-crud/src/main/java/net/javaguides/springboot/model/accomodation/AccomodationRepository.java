package net.javaguides.springboot.model.accomodation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomodationRepository extends CrudRepository<Accomodation,Integer>{
    //Interno,Stars, Category, OtherServices
    @Query("SELECT a FROM Accomodation a WHERE a.name LIKE %:name%")
    List<Accomodation> findByName(@Param("name")String name);
    @Query("SELECT a FROM Accomodation a " +
            "WHERE (a.countryFair = true AND :#{#services.countryFair} = true OR a.countryFair = false) " +
            "AND (a.fsStation = true AND  :#{#services.fsStation} = true OR a.fsStation = false) " +
            "AND (a.spanish = true AND :#{#services.spanish} = true OR a.spanish = false) " +
            "AND (a.lake = true AND :#{#services.lake} = true OR a.lake = false) " +
            "AND (a.airport = true AND :#{#services.airport} = true OR a.airport=false) " +
            "AND (a.highway = true AND :#{#services.highway} = true OR a.highway=false) " +
            "AND (a.fitness = true AND :#{#services.fitness} = true OR a.fitness=false) " +
            "AND (a.sauna = true AND :#{#services.sauna} = true OR a.sauna=false) " +
            "AND (a.skiLifts = true AND :#{#services.skiLifts} = true OR a.skiLifts=false) " +
            "AND (a.english = true AND :#{#services.english} = true OR a.english=false) " +
            "AND (a.thermal = true AND :#{#services.thermal} = true OR a.thermal=false) " +
            "AND (a.disablePeopleAccess = true AND :#{#services.disablePeopleAccess} = true OR a.disablePeopleAccess=false) " +
            "AND (a.conferenceRoom = true AND :#{#services.conferenceRoom} = true OR a.conferenceRoom=false) " +
            "AND (a.childrensGames = true AND :#{#services.childrensGames} = true OR a.childrensGames=false) " +
            "AND (a.parking = true AND :#{#services.parking} = true OR a.parking=false) " +
            "AND (a.outskirts = true AND :#{#services.outskirts} = true OR a.outskirts=false) " +
            "AND (a.oldTown = true AND :#{#services.oldTown} = true OR a.oldTown=false) " +
            "AND (a.airConditioning = true AND :#{#services.airConditioning} = true OR a.airConditioning=false) " +
            "AND (a.sea = true AND :#{#services.sea} = true OR a.sea=false) " +
            "AND (a.pets = true AND :#{#services.pets} = true OR a.pets=false) " +
            "AND (a.pool = true AND :#{#services.pool} = true OR a.pool=false) " +
            "AND (a.german = true AND :#{#services.german} = true OR a.german=false) " +
            "AND (a.hilly = true AND :#{#services.hilly} = true OR a.hilly=false) " +
            "AND (a.temporaryClosure = true AND :#{#services.temporaryClosure} = true OR a.temporaryClosure=false) " +
            "AND (a.french = true AND :#{#services.french} = true OR a.french=false) " +
            "AND (a.restaurant = true AND :#{#services.restaurant} = true OR a.restaurant=false) " +
            "AND (a.coveredPool = true AND :#{#services.coveredPool} = true OR a.coveredPool=false) " +
            "AND (a.solarium = true AND :#{#services.solarium} = true OR a.solarium=false) " +
            "AND a.otherServices LIKE %:#{#services.otherServices}%")
    List<Accomodation> findByServices(@Param("services") Services services);

}
