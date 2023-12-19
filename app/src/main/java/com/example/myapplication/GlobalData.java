package com.example.myapplication;

import android.widget.CheckBox;

import com.example.myapplication.model.Accommodation;
import com.example.myapplication.model.User;

public class GlobalData {
    private static GlobalData instance;

    //INFORMAZIONI GLOBALI DELL'UTENTE CHE EFFETTUA L'ACCESSO
    private User u = new User();
   /* private String username;
    private String nome;
    private String cognome;
    private String mail;
    private String password;*/

    //INFORMAZIONI GLOBALI DEI SERVIZI SCELTI PER LA RICERCA ALLOGGI
    private Accommodation accommodation = new Accommodation();

    private boolean piscina = false;
    private boolean piscinaCoperta = false;
    private boolean animaliAmm = false;
    private boolean ariaCond = false;
    private boolean ristorante = false;
    private boolean parcheggio  = false;
    private boolean accessoDisabili  = false;
    private boolean stazioneFs  = false;
    private boolean lago  = false;
    private boolean aeroporto  = false;
    private boolean sauna = false;
    private boolean terme = false;
    private boolean salaConferenze  = false;
    private boolean areaBimbi = false;
    private boolean solarium = false;
    private boolean mare  = false;
    private boolean periferia  = false;
    private boolean campagna  = false;
    private boolean centroStorico  = false;
    private boolean palestra  = false;
    private boolean skilift = false;
    private boolean inglese  = false;
    private boolean francese = false;
    private boolean spagnolo  = false;
    private boolean tedesco = false;

    public boolean isSpagnolo() {
        return accommodation.isSpanish();
    }

    public void setSpagnolo(boolean spagnolo) {
        this.accommodation.setSpanish(spagnolo);
    }

    public boolean isTedesco() {
        return accommodation.isGerman();
    }

    public void setTedesco(boolean tedesco) {
        this.accommodation.setGerman(tedesco);
    }

    private GlobalData() {
        // Costruttore privato per impedire l'istanziazione diretta
    }
    public static synchronized GlobalData getInstance() {
        if (instance == null) {
            instance = new GlobalData();
        }
        return instance;
    }

    public String getUsername() {
        return u.getUsername();
    }

    public void setUsername(String username) {
        u.setUsername(username);
    }

    public String getNome() {
        return u.getFirstName();
    }

    public void setNome(String nome) {
        u.setFirstName(nome);
    }

    public String getCognome() {
        return u.getLastName();
    }

    public void setCognome(String cognome) { u.setLastName(cognome); }

    public String getMail() {
        return u.getEmail();
    }

    public void setMail(String mail) {
        u.setEmail(mail);
    }

    public String getPassword() {
        return u.getPassword();
    }

    public void setPassword(String password) {
        u.setPassword(password);
    }


    public boolean isPiscina() {
        return accommodation.isPool();
    }

    public void setPiscina(boolean piscina) {
        this.accommodation.setPool(piscina);
    }

    public boolean isPiscinaCoperta() {
        return accommodation.isCoveredPool();
    }

    public void setPiscinaCoperta(boolean piscinaCoperta) {
        this.accommodation.setCoveredPool(piscinaCoperta);
    }

    public boolean isAnimaliAmm() {
        return accommodation.isPets();
    }

    public void setAnimaliAmm(boolean animaliAmm) {
        this.accommodation.setPets(animaliAmm);
    }

    public boolean isAriaCond() {
        return accommodation.isAirConditioning();
    }

    public void setAriaCond(boolean ariaCond) {
        this.accommodation.setAirConditioning(ariaCond);
    }

    public boolean isRistorante() {
        return accommodation.isRestaurant();
    }

    public void setRistorante(boolean ristorante) {
        this.accommodation.setRestaurant(ristorante);
    }

    public boolean isParcheggio() {
        return accommodation.isParking();
    }

    public void setParcheggio(boolean parcheggio) {
        this.accommodation.setParking(parcheggio);
    }

    public boolean isAccessoDisabili() {
        return accommodation.isDisablePeopleAccess();
    }

    public void setAccessoDisabili(boolean accessoDisabili) {
        this.accommodation.setDisablePeopleAccess(accessoDisabili);
    }

    public boolean isStazioneFs() {
        return accommodation.isFsStation();
    }

    public void setStazioneFs(boolean stazioneFs) {
        this.accommodation.setFsStation(stazioneFs);
    }

    public boolean isLago() {
        return accommodation.isLake();
    }

    public void setLago(boolean lago) {
        this.accommodation.setLake(lago);
    }

    public boolean isAeroporto() {
        return accommodation.isAirport();
    }

    public void setAeroporto(boolean aeroporto) {
        this.accommodation.setAirport(aeroporto);
    }

    public boolean isSauna() {
        return accommodation.isSauna();
    }

    public void setSauna(boolean sauna) {
        this.accommodation.setSauna(sauna);
    }

    public boolean isTerme() {
        return accommodation.isThermal();
    }

    public void setTerme(boolean terme) {
        this.accommodation.setThermal(terme);
    }

    public boolean isSalaConferenze() {
        return accommodation.isConferenceRoom();
    }

    public void setSalaConferenze(boolean salaConferenze) {
        this.accommodation.setConferenceRoom(salaConferenze);
    }

    public boolean isAreaBimbi() {
        return accommodation.isChildrensGames();
    }

    public void setAreaBimbi(boolean areaBimbi) {
        this.accommodation.setChildrensGames(areaBimbi);
    }

    public boolean isSolarium() {
        return accommodation.isSolarium();
    }

    public void setSolarium(boolean solarium) {
        this.accommodation.setSolarium(solarium);
    }

    public boolean isMare() {
        return accommodation.isSea();
    }

    public void setMare(boolean mare) {
        this.accommodation.setSea(mare);
    }

    public boolean isPeriferia() {
        return accommodation.isOutskirts();
    }

    public void setPeriferia(boolean periferia) {
        this.accommodation.setOutskirts(periferia);
    }

    /*
    Campagna errato -> collinare corretto
    * */

    public boolean isCampagna() {
        return accommodation.isHilly();
    }

    public void setCampagna(boolean campagna) {
        this.accommodation.setHilly(campagna);
    }

    public boolean isCentroStorico() {
        return accommodation.isOldTown();
    }

    public void setCentroStorico(boolean centroStorico) {
        this.accommodation.setOldTown(centroStorico);
    }

    public boolean isPalestra() {
        return accommodation.isFitness();
    }

    public void setPalestra(boolean palestra) {
        this.accommodation.setFitness(palestra);
    }

    public boolean isSkilift() {
        return accommodation.isSkiLifts();
    }

    public void setSkilift(boolean skilift) {
        this.accommodation.setSkiLifts(skilift);
    }

    public boolean isInglese() {
        return accommodation.isEnglish();
    }

    public void setInglese(boolean inglese) {
        this.accommodation.setEnglish(inglese);
    }

    public boolean isFrancese() {
        return accommodation.isFrench();
    }

    public void setFrancese(boolean francese) {
        this.accommodation.setFrench(francese);
    }

    public boolean isZonaFiera(){
        return accommodation.isCountryFair();
    }

    public void setZonaFiera(boolean zonaFiera){
        this.accommodation.setCountryFair(zonaFiera);
    }

    public boolean isHighway(){
        return accommodation.isHighway();
    }

    public void setHighway(boolean highway){
        accommodation.setHighway(highway);
    }

    public String getOtherServices(){
        return this.accommodation.getOtherServices();
    }

    public void setOtherServices(String otherServices){
        this.accommodation.setOtherServices(otherServices);
    }

    public Accommodation getAccommodation(){
        return this.accommodation;
    }

    /*
    Questo metodo non serve più. Il costruttore di accommodation setta tutto a afalse
    * */

    public void setFalse(){
        piscina = false;
        piscinaCoperta = false;
        animaliAmm = false;
        ariaCond = false;
        ristorante = false;
        parcheggio  = false;
        accessoDisabili  = false;
        stazioneFs  = false;
        lago  = false;
        aeroporto  = false;
        sauna = false;
        terme = false;
        salaConferenze  = false;
        areaBimbi = false;
        solarium = false;
        mare  = false;
        periferia  = false;
        campagna  = false;
        centroStorico  = false;
        palestra  = false;
        skilift = false;
        inglese  = false;
        francese = false;
        spagnolo  = false;
        tedesco = false;
    }
}
