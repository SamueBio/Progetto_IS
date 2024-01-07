package com.example.myapplication;

import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Accommodation;
import com.example.myapplication.model.User;

public class GlobalData extends AppCompatActivity {
    private static GlobalData instance;

    //INFORMAZIONI GLOBALI DELL'UTENTE CHE EFFETTUA L'ACCESSO
     private User u = new User();

    //INFORMAZIONI GLOBALI DEI SERVIZI SCELTI PER LA RICERCA ALLOGGI
    private Accommodation accommodation = new Accommodation();

    //GETTER & SETTER
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

    public GlobalData() {
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

    public boolean isPiscina() {
        return accommodation.isPool();
    }

    public void setPiscina(boolean piscina) {
        this.accommodation.setPool(piscina);
    }

    public boolean isPiscinaCoperta() {
        return accommodation.isCoveredPool();
    }

    public void setPiscinaCoperta(boolean piscinaCoperta) { this.accommodation.setCoveredPool(piscinaCoperta);}

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

    public void setAccessoDisabili(boolean accessoDisabili) {        this.accommodation.setDisablePeopleAccess(accessoDisabili);}

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

    public void setSalaConferenze(boolean salaConferenze) {this.accommodation.setConferenceRoom(salaConferenze);}

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

    public boolean isCollinare() {
        return accommodation.isHilly();
    }

    public void setCollinare(boolean hill) {
        this.accommodation.setHilly(hill);
    }

    public boolean isCentroStorico() {return accommodation.isOldTown();}

    public void setCentroStorico(boolean centroStorico) {this.accommodation.setOldTown(centroStorico);}

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

    public boolean isHighway(){
        return accommodation.isHighway();
    }

    public void setHighway(boolean highway){
        accommodation.setHighway(highway);
    }

    public boolean isCountryFair(){
        return accommodation.isCountryFair();
    }

    public void setCountryFair(boolean country){
        accommodation.setCountryFair(country);
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

    public void setFalse(){
        accommodation = new Accommodation();
    }


}
