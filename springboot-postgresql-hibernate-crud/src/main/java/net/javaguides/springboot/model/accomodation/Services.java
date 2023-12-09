package net.javaguides.springboot.model.accomodation;

import jakarta.persistence.Column;

public class Services {
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
    private boolean outskirts;
    private boolean oldTown;
    private boolean airConditioning;
    private boolean sea;
    private boolean pets;
    private boolean pool;
    private boolean german;
    private boolean hilly;
    private boolean temporaryClosure;
    private boolean french;
    private boolean restaurant;
    private boolean coveredPool;
    private boolean solarium;
    private String otherServices;

    public Services(){
        countryFair = false;
        fsStation = false;
        spanish = false;
        lake = false;
        airport = false;
        highway = false;
        fitness = false;
        sauna = false;
        skiLifts = false;
        english = false;
        thermal = false;
        disablePeopleAccess = false;
        conferenceRoom = false;
        childrensGames = false;
        parking = false;
        outskirts = false;
        oldTown = false;
        airConditioning = false;
        sea = false;
        pets = false;
        pool = false;
        german = false;
        hilly = false;
        temporaryClosure = false;
        french = false;
        restaurant = false;
        coveredPool = false;
        solarium = false;
        otherServices = "";
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

    public String getOtherServices() {
        return otherServices;
    }

    public void setOtherServices(String otherServices) {
        this.otherServices = otherServices;
    }
}
