package net.javaguides.springboot.model.accomodation;

import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends CrudRepository<Accommodation,Integer>{
    //Interno,Stars, Category, OtherServices
    @Query("SELECT a FROM Accommodation a WHERE a.name LIKE %:name%")
    List<Accommodation> findByName(@Param("name")String name);
    @Query("SELECT a FROM Accommodation a " +
            "WHERE (a.countryFair = true AND :#{#accommodation.countryFair} = true OR a.countryFair = false) " +
            "AND (a.fsStation = true AND :#{#accommodation.fsStation} = true OR a.fsStation = false) " +
            "AND (a.spanish = true AND :#{#accommodation.spanish} = true OR a.spanish = false) " +
            "AND (a.lake = true AND :#{#accommodation.lake} = true OR a.lake = false) " +
            "AND (a.airport = true AND :#{#accommodation.airport} = true OR a.airport=false) " +
            "AND (a.highway = true AND :#{#accommodation.highway} = true OR a.highway=false) " +
            "AND (a.fitness = true AND :#{#accommodation.fitness} = true OR a.fitness=false) " +
            "AND (a.sauna = true AND :#{#accommodation.sauna} = true OR a.sauna=false) " +
            "AND (a.skiLifts = true AND :#{#accommodation.skiLifts} = true OR a.skiLifts=false) " +
            "AND (a.english = true AND :#{#accommodation.english} = true OR a.english=false) " +
            "AND (a.thermal = true AND :#{#accommodation.thermal} = true OR a.thermal=false) " +
            "AND (a.disablePeopleAccess = true AND :#{#accommodation.disablePeopleAccess} = true OR a.disablePeopleAccess=false) " +
            "AND (a.conferenceRoom = true AND :#{#accommodation.conferenceRoom} = true OR a.conferenceRoom=false) " +
            "AND (a.childrensGames = true AND :#{#accommodation.childrensGames} = true OR a.childrensGames=false) " +
            "AND (a.parking = true AND :#{#accommodation.parking} = true OR a.parking=false) " +
            "AND (a.outskirts = true AND :#{#accommodation.outskirts} = true OR a.outskirts=false) " +
            "AND (a.oldTown = true AND :#{#accommodation.oldTown} = true OR a.oldTown=false) " +
            "AND (a.airConditioning = true AND :#{#accommodation.airConditioning} = true OR a.airConditioning=false) " +
            "AND (a.sea = true AND :#{#accommodation.sea} = true OR a.sea=false) " +
            "AND (a.pets = true AND :#{#accommodation.pets} = true OR a.pets=false) " +
            "AND (a.pool = true AND :#{#accommodation.pool} = true OR a.pool=false) " +
            "AND (a.german = true AND :#{#accommodation.german} = true OR a.german=false) " +
            "AND (a.hilly = true AND :#{#accommodation.hilly} = true OR a.hilly=false) " +
            "AND (a.temporaryClosure = true AND :#{#accommodation.temporaryClosure} = true OR a.temporaryClosure=false) " +
            "AND (a.french = true AND :#{#accommodation.french} = true OR a.french=false) " +
            "AND (a.restaurant = true AND :#{#accommodation.restaurant} = true OR a.restaurant=false) " +
            "AND (a.coveredPool = true AND :#{#accommodation.coveredPool} = true OR a.coveredPool=false) " +
            "AND (a.solarium = true AND :#{#accommodation.solarium} = true OR a.solarium=false) " +
            "AND a.otherServices LIKE %:#{#accommodation.otherServices}% " +
            "AND a.cap LIKE %:#{#accommodation.cap}% " +
            "AND a.address LIKE %:#{#accommodation.address}% " +
            "AND a.area LIKE %:#{#accommodation.area}% " +
            "AND a.province LIKE %:#{#accommodation.province}% " +
            "AND a.town LIKE %:#{#accommodation.town}% " +
            "AND a.type LIKE %:#{#accommodation.type}% " +
            "AND a.location LIKE %:#{#accommodation.location}%")
    List<Accommodation> findByServices(@Param("accommodation") Accommodation accommodation);

    @Query("SELECT a FROM Accommodation a")
    List<Accommodation> findAll();
}
