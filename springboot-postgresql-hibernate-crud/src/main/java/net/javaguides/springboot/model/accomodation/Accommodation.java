package net.javaguides.springboot.model.accomodation;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Accommodations")
public class Accommodation {


    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "cap", length = 10)
    private String cap;

    @Column(name = "interno")
    private String interno;

    @Column(name = "area", length = 30)
    private String area;

    @Column(name = "province", length = 10)
    private String province;

    @Column(name = "website", length = 30)
    private String website;

    @Column(name = "location", length = 100)
    private String location;

    @Column(name = "fax", length = 20)
    private String fax;

    @Column(name = "newlr11classification", length = 10)
    private String newLR11Classification;

    @Column(name = "telephone", length = 20)
    private String telephone;

    @Column(name = "town", length = 20)
    private String town;

    @Column(name = "type", length = 30)
    private String type;

    @Column(name = "email", length = 40)
    private String email;

    @Column(name = "stars")
    private String stars;

    @Column(name = "category")
    private String category;

    @Column(name = "last_time_updated")
    private Date lastTimeUpdated;

    @Column(name = "country_fair")
    private boolean countryFair;

    @Column(name = "fsstation")
    private boolean fsStation;

    @Column(name = "spanish")
    private boolean spanish;

    @Column(name = "lake")
    private boolean lake;

    @Column(name = "airport")
    private boolean airport;

    @Column(name = "highway")
    private boolean highway;

    @Column(name = "fitness")
    private boolean fitness;

    @Column(name = "sauna")
    private boolean sauna;

    @Column(name = "ski_lifts")
    private boolean skiLifts;

    @Column(name = "english")
    private boolean english;

    @Column(name = "thermal")
    private boolean thermal;

    @Column(name = "disable_people_access")
    private boolean disablePeopleAccess;

    @Column(name = "conference_room")
    private boolean conferenceRoom;

    @Column(name = "childrens_games")
    private boolean childrensGames;

    @Column(name = "parking")
    private boolean parking;

    @Column(name = "outskirts")
    private boolean outskirts;

    @Column(name = "old_town")
    private boolean oldTown;

    @Column(name = "air_conditioning")
    private boolean airConditioning;

    @Column(name = "sea")
    private boolean sea;

    @Column(name = "pets")
    private boolean pets;

    @Column(name = "pool")
    private boolean pool;

    @Column(name = "german")
    private boolean german;

    @Column(name = "hilly")
    private boolean hilly;

    @Column(name = "temporary_closure")
    private boolean temporaryClosure;

    @Column(name = "french")
    private boolean french;

    @Column(name = "restaurant")
    private boolean restaurant;

    @Column(name = "covered_pool")
    private boolean coveredPool;

    @Column(name = "solarium")
    private boolean solarium;

    //TODO: FK
    @Column(name = "holder", length = 30)
    private String holder;

    //TODO:FK
    @Column(name = "tourismpromoter")
    private Integer tourismPromoter;
    @Column(name = "other_services")
    private String otherServices;
    @Column(name = "house_number", length = 10)
    private String houseNumber;


    public Accommodation(){super();}


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Accomodation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cap='" + cap + '\'' +
                ", interno='" + interno + '\'' +
                ", area='" + area + '\'' +
                ", province='" + province + '\'' +
                ", website='" + website + '\'' +
                ", location='" + location + '\'' +
                ", fax='" + fax + '\'' +
                ", newLR11Classification='" + newLR11Classification + '\'' +
                ", telephone='" + telephone + '\'' +
                ", town='" + town + '\'' +
                ", type='" + type + '\'' +
                ", email='" + email + '\'' +
                ", stars='" + stars + '\'' +
                ", category='" + category + '\'' +
                ", lastTimeUpdated=" + lastTimeUpdated +
                ", countryFair=" + countryFair +
                ", fsStation=" + fsStation +
                ", spanish=" + spanish +
                ", lake=" + lake +
                ", airport=" + airport +
                ", highway=" + highway +
                ", fitness=" + fitness +
                ", sauna=" + sauna +
                ", skiLifts=" + skiLifts +
                ", english=" + english +
                ", thermal=" + thermal +
                ", disablePeopleAccess=" + disablePeopleAccess +
                ", conferenceRoom=" + conferenceRoom +
                ", childrensGames=" + childrensGames +
                ", parking=" + parking +
                ", outskirts=" + outskirts +
                ", oldTown=" + oldTown +
                ", airConditioning=" + airConditioning +
                ", sea=" + sea +
                ", pets=" + pets +
                ", pool=" + pool +
                ", german=" + german +
                ", hilly=" + hilly +
                ", temporaryClosure=" + temporaryClosure +
                ", french=" + french +
                ", restaurant=" + restaurant +
                ", coveredPool=" + coveredPool +
                ", solarium=" + solarium +
                ", holder='" + holder + '\'' +
                ", tourismPromoter=" + tourismPromoter +
                ", otherServices='" + otherServices + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
