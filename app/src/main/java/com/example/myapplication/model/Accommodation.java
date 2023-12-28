package com.example.myapplication.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class Accommodation implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private String cap;
    private String interno;
    private String area;
    private String province;
    private String website;
    private String location;
    private String fax;
    private String newLR11Classification;
    private String telephone;
    private String town;
    private String type;
    private String email;
    private String stars;
    private String category;
    private Date lastTimeUpdated;
    //Zona Fiera
    private boolean countryFair;
    private boolean fsStation;
    private boolean spanish;
    private boolean lake;
    private boolean airport;
    private boolean highway;
    private boolean fitness;
    private boolean sauna;
    private boolean skiLifts;
    private boolean english;
    private boolean thermal;
    private boolean disablePeopleAccess;
    private boolean conferenceRoom;
    private boolean childrensGames;
    private boolean parking;
    //Periferia
    private boolean outskirts;
    //Centro storico
    private boolean oldTown;
    private boolean airConditioning;
    private boolean sea;
    private boolean pets;
    private boolean pool;
    private boolean german;
    //Collinare
    private boolean hilly;
    private boolean temporaryClosure;
    private boolean french;
    private boolean restaurant;
    private boolean coveredPool;
    private boolean solarium;
    private String holder;
    private Integer tourismPromoter;
    private String otherServices;
    private String houseNumber;

    //PREFERITO
    private boolean isFavourited;


    public Accommodation() {
        super();
        this.isFavourited=false;
        this.name = "";
        this.area = "";
        this.province = "";
        this.location = "";
        this.town = "";
        this.type = "";
        this.stars = "";
        this.category = "";
        this.countryFair = false;
        this.fsStation = false;
        this.spanish = false;
        this.lake = false;
        this.airport = false;
        this.highway = false;
        this.fitness = false;
        this.sauna = false;
        this.skiLifts = false;
        this.english = false;
        this.thermal = false;
        this.disablePeopleAccess = false;
        this.conferenceRoom = false;
        this.childrensGames = false;
        this.parking = false;
        this.outskirts = false;
        this.oldTown = false;
        this.airConditioning = false;
        this.sea = false;
        this.pets = false;
        this.pool = false;
        this.german = false;
        this.hilly = false;
        this.temporaryClosure = false;
        this.french = false;
        this.restaurant = false;
        this.coveredPool = false;
        this.solarium = false;
        this.otherServices = "";
        //Non mi convince per niente sta roba. Probabilmente è inutile.
        long miliseconds = System.currentTimeMillis();
        this.lastTimeUpdated=new Date(miliseconds);
    }

    public boolean isFavourited() {
        return isFavourited;
    }
    public void setFavourited(boolean favourited) {
        isFavourited = favourited;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNewLR11Classification() {
        return newLR11Classification;
    }

    public void setNewLR11Classification(String newLR11Classification) {
        this.newLR11Classification = newLR11Classification;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getLastTimeUpdated() {
        return lastTimeUpdated;
    }

    public void setLastTimeUpdated(Date lastTimeUpdated) {
        this.lastTimeUpdated = lastTimeUpdated;
    }

    public boolean isCountryFair() {
        return countryFair;
    }

    public void setCountryFair(boolean countryFair) {
        this.countryFair = countryFair;
    }

    public boolean isFsStation() {
        return fsStation;
    }

    public void setFsStation(boolean fsStation) {
        this.fsStation = fsStation;
    }

    public boolean isSpanish() {
        return spanish;
    }

    public void setSpanish(boolean spanish) {
        this.spanish = spanish;
    }

    public boolean isLake() {
        return lake;
    }

    public void setLake(boolean lake) {
        this.lake = lake;
    }

    public boolean isAirport() {
        return airport;
    }

    public void setAirport(boolean airport) {
        this.airport = airport;
    }

    public boolean isHighway() {
        return highway;
    }

    public void setHighway(boolean highway) {
        this.highway = highway;
    }

    public boolean isFitness() {
        return fitness;
    }

    public void setFitness(boolean fitness) {
        this.fitness = fitness;
    }

    public boolean isSauna() {
        return sauna;
    }

    public void setSauna(boolean sauna) {
        this.sauna = sauna;
    }

    public boolean isSkiLifts() {
        return skiLifts;
    }

    public void setSkiLifts(boolean skiLifts) {
        this.skiLifts = skiLifts;
    }

    public boolean isEnglish() {
        return english;
    }

    public void setEnglish(boolean english) {
        this.english = english;
    }

    public boolean isThermal() {
        return thermal;
    }

    public void setThermal(boolean thermal) {
        this.thermal = thermal;
    }

    public boolean isDisablePeopleAccess() {
        return disablePeopleAccess;
    }

    public void setDisablePeopleAccess(boolean disablePeopleAccess) {
        this.disablePeopleAccess = disablePeopleAccess;
    }

    public boolean isConferenceRoom() {
        return conferenceRoom;
    }

    public void setConferenceRoom(boolean conferenceRoom) {
        this.conferenceRoom = conferenceRoom;
    }

    public boolean isChildrensGames() {
        return childrensGames;
    }

    public void setChildrensGames(boolean childrensGames) {
        this.childrensGames = childrensGames;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isOutskirts() {
        return outskirts;
    }

    public void setOutskirts(boolean outskirts) {
        this.outskirts = outskirts;
    }

    public boolean isOldTown() {
        return oldTown;
    }

    public void setOldTown(boolean oldTown) {
        this.oldTown = oldTown;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public boolean isSea() {
        return sea;
    }

    public void setSea(boolean sea) {
        this.sea = sea;
    }

    public boolean isPets() {
        return pets;
    }

    public void setPets(boolean pets) {
        this.pets = pets;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isGerman() {
        return german;
    }

    public void setGerman(boolean german) {
        this.german = german;
    }

    public boolean isHilly() {
        return hilly;
    }

    public void setHilly(boolean hilly) {
        this.hilly = hilly;
    }

    public boolean isTemporaryClosure() {
        return temporaryClosure;
    }

    public void setTemporaryClosure(boolean temporaryClosure) {
        this.temporaryClosure = temporaryClosure;
    }

    public boolean isFrench() {
        return french;
    }

    public void setFrench(boolean french) {
        this.french = french;
    }

    public boolean isRestaurant() {
        return restaurant;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isCoveredPool() {
        return coveredPool;
    }

    public void setCoveredPool(boolean coveredPool) {
        this.coveredPool = coveredPool;
    }

    public boolean isSolarium() {
        return solarium;
    }

    public void setSolarium(boolean solarium) {
        this.solarium = solarium;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Integer getTourismPromoter() {
        return tourismPromoter;
    }

    public void setTourismPromoter(Integer tourismPromoter) {
        this.tourismPromoter = tourismPromoter;
    }

    public String getOtherServices() {
        return otherServices;
    }

    public void setOtherServices(String otherServices) {
        this.otherServices = otherServices;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public JsonObject generateJson(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id",0);
        jsonObject.addProperty("name",name);
        jsonObject.addProperty("address","");
        jsonObject.addProperty("cap","");
        jsonObject.addProperty("interno","");
        jsonObject.addProperty("area",area);
        jsonObject.addProperty("province",province);
        jsonObject.addProperty("website","");
        jsonObject.addProperty("location",location);
        jsonObject.addProperty("fax","");
        jsonObject.addProperty("newLR11Classification","");
        jsonObject.addProperty("telephone","");
        jsonObject.addProperty("town",town);
        jsonObject.addProperty("type",type);
        jsonObject.addProperty("email","");
        jsonObject.addProperty("stars",stars);
        jsonObject.addProperty("category",category);
        jsonObject.addProperty("lastTimeUpdated","");
        jsonObject.addProperty("countryFair",countryFair);
        jsonObject.addProperty("fsStation",fsStation);
        jsonObject.addProperty("spanish",spanish);
        jsonObject.addProperty("lake",lake);
        jsonObject.addProperty("airport",airport);
        jsonObject.addProperty("highway",highway);
        jsonObject.addProperty("fitness",fitness);
        jsonObject.addProperty("sauna",sauna);
        jsonObject.addProperty("skiLifts",skiLifts);
        jsonObject.addProperty("english",english);
        jsonObject.addProperty("thermal",thermal);
        jsonObject.addProperty("disablePeopleAccess",disablePeopleAccess);
        jsonObject.addProperty("conferenceRoom",conferenceRoom);
        jsonObject.addProperty("childrensGames",childrensGames);
        jsonObject.addProperty("parking",parking);
        jsonObject.addProperty("outskirts",outskirts);
        jsonObject.addProperty("oldTown",oldTown);
        jsonObject.addProperty("airConditioning",airConditioning);
        jsonObject.addProperty("sea",sea);
        jsonObject.addProperty("pets",pets);
        jsonObject.addProperty("pool",pool);
        jsonObject.addProperty("german",german);
        jsonObject.addProperty("hilly",hilly);
        jsonObject.addProperty("temporaryClosure",temporaryClosure);
        jsonObject.addProperty("french",french);
        jsonObject.addProperty("restaurant",restaurant);
        jsonObject.addProperty("coveredPool",coveredPool);
        jsonObject.addProperty("solarium",solarium);
        jsonObject.addProperty("holder","");
        jsonObject.addProperty("tourismPromoter","");
        jsonObject.addProperty("otherServices",otherServices);
        jsonObject.addProperty("houseNumber","");

        return jsonObject;
    }

    public static List<Accommodation> parseString(String responseBody){
        List<Accommodation> accommodationList = new ArrayList<>();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Accommodation>>(){}.getType();
        accommodationList = gson.fromJson(responseBody,listType);
        return accommodationList;
    }
}
