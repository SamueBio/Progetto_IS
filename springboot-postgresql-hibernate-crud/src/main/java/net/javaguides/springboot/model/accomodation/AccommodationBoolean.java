package net.javaguides.springboot.model.accomodation;

import java.util.Date;

public class AccommodationBoolean {
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
	private String holder;
	private Integer tourismPromoter;
	private String otherServices;
	private String houseNumber;
    private boolean favourite;

	public AccommodationBoolean(Accommodation accommodation, boolean isFavourite){
		this.id = accommodation.getId();
		this.name = accommodation.getName();
		this.address = accommodation.getAddress();
		this.cap = accommodation.getCap();
		this.interno = accommodation.getInterno();
		this.area = accommodation.getArea();
		this.province = accommodation.getProvince();
		this.website = accommodation.getWebsite();
		this.location = accommodation.getLocation();
		this.fax = accommodation.getFax();
		this.newLR11Classification = accommodation.getNewLR11Classification();
		this.telephone = accommodation.getTelephone();
		this.town = accommodation.getTown();
		this.type = accommodation.getType();
		this.email = accommodation.getEmail();
		this.stars = accommodation.getStars();
		this.category = accommodation.getCategory();
		this.lastTimeUpdated = accommodation.getLastTimeUpdated();
		this.countryFair = accommodation.isCountryFair();
		this.fsStation = accommodation.isFsStation();
		this.spanish = accommodation.isSpanish();
		this.lake = accommodation.isLake();
		this.airport = accommodation.isAirport();
		this.highway = accommodation.isHighway();
		this.fitness = accommodation.isFitness();
		this.sauna = accommodation.isSauna();
		this.skiLifts = accommodation.isSkiLifts();
		this.english = accommodation.isEnglish();
		this.thermal = accommodation.isThermal();
		this.disablePeopleAccess = accommodation.isDisablePeopleAccess();
		this.conferenceRoom = accommodation.isConferenceRoom();
		this.childrensGames = accommodation.isChildrensGames();
		this.parking = accommodation.isParking();
		this.outskirts = accommodation.isOutskirts();
		this.oldTown = accommodation.isOldTown();
		this.airConditioning = accommodation.isAirConditioning();
		this.sea = accommodation.isSea();
		this.pets = accommodation.isPets();
		this.pool = accommodation.isPool();
		this.german = accommodation.isGerman();
		this.hilly = accommodation.isHilly();
		this.temporaryClosure = accommodation.isTemporaryClosure();
		this.french = accommodation.isFrench();
		this.restaurant = accommodation.isRestaurant();
		this.coveredPool = accommodation.isCoveredPool();
		this.solarium = accommodation.isSolarium();
		this.holder = accommodation.getHolder();
		this.tourismPromoter = accommodation.getTourismPromoter();
		this.otherServices = accommodation.getOtherServices();
		this.houseNumber = accommodation.getHouseNumber();
		this.favourite = isFavourite;
	}

	public AccommodationBoolean(Integer id, String name, String address, String cap, String interno, String area, String province, String website, String location, String fax, String newLR11Classification, String telephone, String town, String type, String email, String stars, String category, Date lastTimeUpdated, boolean countryFair, boolean fsStation, boolean spanish, boolean lake, boolean airport, boolean highway, boolean fitness, boolean sauna, boolean skiLifts, boolean english, boolean thermal, boolean disablePeopleAccess, boolean conferenceRoom, boolean childrensGames, boolean parking, boolean outskirts, boolean oldTown, boolean airConditioning, boolean sea, boolean pets, boolean pool, boolean german, boolean hilly, boolean temporaryClosure, boolean french, boolean restaurant, boolean coveredPool, boolean solarium, String holder, Integer tourismPromoter, String otherServices, String houseNumber, boolean favourite) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.cap = cap;
		this.interno = interno;
		this.area = area;
		this.province = province;
		this.website = website;
		this.location = location;
		this.fax = fax;
		this.newLR11Classification = newLR11Classification;
		this.telephone = telephone;
		this.town = town;
		this.type = type;
		this.email = email;
		this.stars = stars;
		this.category = category;
		this.lastTimeUpdated = lastTimeUpdated;
		this.countryFair = countryFair;
		this.fsStation = fsStation;
		this.spanish = spanish;
		this.lake = lake;
		this.airport = airport;
		this.highway = highway;
		this.fitness = fitness;
		this.sauna = sauna;
		this.skiLifts = skiLifts;
		this.english = english;
		this.thermal = thermal;
		this.disablePeopleAccess = disablePeopleAccess;
		this.conferenceRoom = conferenceRoom;
		this.childrensGames = childrensGames;
		this.parking = parking;
		this.outskirts = outskirts;
		this.oldTown = oldTown;
		this.airConditioning = airConditioning;
		this.sea = sea;
		this.pets = pets;
		this.pool = pool;
		this.german = german;
		this.hilly = hilly;
		this.temporaryClosure = temporaryClosure;
		this.french = french;
		this.restaurant = restaurant;
		this.coveredPool = coveredPool;
		this.solarium = solarium;
		this.holder = holder;
		this.tourismPromoter = tourismPromoter;
		this.otherServices = otherServices;
		this.houseNumber = houseNumber;
		this.favourite = favourite;
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

	public boolean isFavourite() {
		return favourite;
	}

	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}
}
