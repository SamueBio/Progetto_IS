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
            "WHERE (a.countryFair = true AND :#{#accommodation.countryFair} = true OR :#{#accommodation.countryFair} = false) " +
            "AND (a.fsStation = true AND :#{#accommodation.fsStation} = true OR :#{#accommodation.fsStation} = false) " +
            "AND (a.spanish = true AND :#{#accommodation.spanish} = true OR :#{#accommodation.spanish} = false) " +
            "AND (a.lake = true AND :#{#accommodation.lake} = true OR :#{#accommodation.lake} = false) " +
            "AND (a.airport = true AND :#{#accommodation.airport} = true OR :#{#accommodation.airport}=false) " +
            "AND (a.highway = true AND :#{#accommodation.highway} = true OR :#{#accommodation.highway}=false) " +
            "AND (a.fitness = true AND :#{#accommodation.fitness} = true OR :#{#accommodation.fitness}=false) " +
            "AND (a.sauna = true AND :#{#accommodation.sauna} = true OR :#{#accommodation.sauna}=false) " +
            "AND (a.skiLifts = true AND :#{#accommodation.skiLifts} = true OR :#{#accommodation.skiLifts}=false) " +
            "AND (a.english = true AND :#{#accommodation.english} = true OR :#{#accommodation.english}=false) " +
            "AND (a.thermal = true AND :#{#accommodation.thermal} = true OR :#{#accommodation.thermal}=false) " +
            "AND (a.disablePeopleAccess = true AND :#{#accommodation.disablePeopleAccess} = true OR :#{#accommodation.disablePeopleAccess}=false) " +
            "AND (a.conferenceRoom = true AND :#{#accommodation.conferenceRoom} = true OR :#{#accommodation.conferenceRoom}=false) " +
            "AND (a.childrensGames = true AND :#{#accommodation.childrensGames} = true OR :#{#accommodation.childrensGames}=false) " +
            "AND (a.parking = true AND :#{#accommodation.parking} = true OR :#{#accommodation.parking}=false) " +
            "AND (a.outskirts = true AND :#{#accommodation.outskirts} = true OR :#{#accommodation.outskirts}=false) " +
            "AND (a.oldTown = true AND :#{#accommodation.oldTown} = true OR :#{#accommodation.oldTown}=false) " +
            "AND (a.airConditioning = true AND :#{#accommodation.airConditioning} = true OR :#{#accommodation.airConditioning}=false) " +
            "AND (a.sea = true AND :#{#accommodation.sea} = true OR :#{#accommodation.sea}=false) " +
            "AND (a.pets = true AND :#{#accommodation.pets} = true OR :#{#accommodation.pets}=false) " +
            "AND (a.pool = true AND :#{#accommodation.pool} = true OR :#{#accommodation.pool}=false) " +
            "AND (a.german = true AND :#{#accommodation.german} = true OR :#{#accommodation.german}=false) " +
            "AND (a.hilly = true AND :#{#accommodation.hilly} = true OR :#{#accommodation.hilly}=false) " +
            "AND (a.temporaryClosure = true AND :#{#accommodation.temporaryClosure} = true OR :#{#accommodation.temporaryClosure}=false) " +
            "AND (a.french = true AND :#{#accommodation.french} = true OR :#{#accommodation.french}=false) " +
            "AND (a.restaurant = true AND :#{#accommodation.restaurant} = true OR :#{#accommodation.restaurant}=false) " +
            "AND (a.coveredPool = true AND :#{#accommodation.coveredPool} = true OR :#{#accommodation.coveredPool}=false) " +
            "AND (a.solarium = true AND :#{#accommodation.solarium} = true OR :#{#accommodation.solarium}=false) " +
            "AND a.otherServices LIKE %:#{#accommodation.otherServices}% " +
            "AND a.cap LIKE %:#{#accommodation.cap}% " +
            "AND a.address LIKE %:#{#accommodation.address}% " +
            "AND a.area LIKE %:#{#accommodation.area}% " +
            "AND a.province LIKE %:#{#accommodation.province}% " +
            "AND a.town LIKE %:#{#accommodation.town}% " +
            "AND a.type LIKE %:#{#accommodation.type}% " +
            "AND a.location LIKE %:#{#accommodation.location}% " +
            "AND a.stars LIKE %:#{#accommodation.stars}% " +
            "AND a.category LIKE %:#{#accommodation.category}% " +
            "AND a.name LIKE %:#{#accommodation.name} " )
    List<Accommodation> findByServices(@Param("accommodation") Accommodation accommodation);
    @Query("SELECT a FROM Accommodation a LEFT JOIN Favourite f ON a.id = f.accommodation AND f.username = :#{#accommodation.favourite.username} " +
            "WHERE (a.countryFair = true AND :#{#accommodation.accommodation.countryFair} = true OR a.countryFair = false) " +
            "AND (a.fsStation = true AND :#{#accommodation.accommodation.fsStation} = true OR a.fsStation = false) " +
            "AND (a.spanish = true AND :#{#accommodation.accommodation.spanish} = true OR a.spanish = false) " +
            "AND (a.lake = true AND :#{#accommodation.accommodation.lake} = true OR a.lake = false) " +
            "AND (a.airport = true AND :#{#accommodation.accommodation.airport} = true OR a.airport=false) " +
            "AND (a.highway = true AND :#{#accommodation.accommodation.highway} = true OR a.highway=false) " +
            "AND (a.fitness = true AND :#{#accommodation.accommodation.fitness} = true OR a.fitness=false) " +
            "AND (a.sauna = true AND :#{#accommodation.accommodation.sauna} = true OR a.sauna=false) " +
            "AND (a.skiLifts = true AND :#{#accommodation.accommodation.skiLifts} = true OR a.skiLifts=false) " +
            "AND (a.english = true AND :#{#accommodation.accommodation.english} = true OR a.english=false) " +
            "AND (a.thermal = true AND :#{#accommodation.accommodation.thermal} = true OR a.thermal=false) " +
            "AND (a.disablePeopleAccess = true AND :#{#accommodation.accommodation.disablePeopleAccess} = true OR a.disablePeopleAccess=false) " +
            "AND (a.conferenceRoom = true AND :#{#accommodation.accommodation.conferenceRoom} = true OR a.conferenceRoom=false) " +
            "AND (a.childrensGames = true AND :#{#accommodation.accommodation.childrensGames} = true OR a.childrensGames=false) " +
            "AND (a.parking = true AND :#{#accommodation.accommodation.parking} = true OR a.parking=false) " +
            "AND (a.outskirts = true AND :#{#accommodation.accommodation.outskirts} = true OR a.outskirts=false) " +
            "AND (a.oldTown = true AND :#{#accommodation.accommodation.oldTown} = true OR a.oldTown=false) " +
            "AND (a.airConditioning = true AND :#{#accommodation.accommodation.airConditioning} = true OR a.airConditioning=false) " +
            "AND (a.sea = true AND :#{#accommodation.accommodation.sea} = true OR a.sea=false) " +
            "AND (a.pets = true AND :#{#accommodation.accommodation.pets} = true OR a.pets=false) " +
            "AND (a.pool = true AND :#{#accommodation.accommodation.pool} = true OR a.pool=false) " +
            "AND (a.german = true AND :#{#accommodation.accommodation.german} = true OR a.german=false) " +
            "AND (a.hilly = true AND :#{#accommodation.accommodation.hilly} = true OR a.hilly=false) " +
            "AND (a.temporaryClosure = true AND :#{#accommodation.accommodation.temporaryClosure} = true OR a.temporaryClosure=false) " +
            "AND (a.french = true AND :#{#accommodation.accommodation.french} = true OR a.french=false) " +
            "AND (a.restaurant = true AND :#{#accommodation.accommodation.restaurant} = true OR a.restaurant=false) " +
            "AND (a.coveredPool = true AND :#{#accommodation.accommodation.coveredPool} = true OR a.coveredPool=false) " +
            "AND (a.solarium = true AND :#{#accommodation.accommodation.solarium} = true OR a.solarium=false) " +
            "AND a.otherServices LIKE %:#{#accommodation.accommodation.otherServices}% " +
            "AND a.cap LIKE %:#{#accommodation.accommodation.cap}% " +
            "AND a.address LIKE %:#{#accommodation.accommodation.address}% " +
            "AND a.area LIKE %:#{#accommodation.accommodation.area}% " +
            "AND a.province LIKE %:#{#accommodation.accommodation.province}% " +
            "AND a.town LIKE %:#{#accommodation.accommodation.town}% " +
            "AND a.type LIKE %:#{#accommodation.accommodation.type}% " +
            "AND a.location LIKE %:#{#accommodation.accommodation.location}% " +
            "AND a.stars LIKE %:#{#accommodation.accommodation.stars}% " +
            "AND a.category LIKE %:#{#accommodation.accommodation.category}% " +
            "AND a.name LIKE %:#{#accommodation.accommodation.name} " )
    List<AccommodationFavourite> search(@Param("accommodation")AccommodationFavourite accommodation);

    @Query("SELECT a FROM Accommodation a")
    List<Accommodation> findAll();



}
