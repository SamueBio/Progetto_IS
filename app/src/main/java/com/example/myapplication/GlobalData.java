package com.example.myapplication;

import android.widget.CheckBox;

public class GlobalData {
    private static GlobalData instance;
    private String username;
    private String nome;
    private String cognome;
    private String mail;
    private String password;

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
        return spagnolo;
    }

    public void setSpagnolo(boolean spagnolo) {
        this.spagnolo = spagnolo;
    }

    public boolean isTedesco() {
        return tedesco;
    }

    public void setTedesco(boolean tedesco) {
        this.tedesco = tedesco;
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
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    public boolean isPiscinaCoperta() {
        return piscinaCoperta;
    }

    public void setPiscinaCoperta(boolean piscinaCoperta) {
        this.piscinaCoperta = piscinaCoperta;
    }

    public boolean isAnimaliAmm() {
        return animaliAmm;
    }

    public void setAnimaliAmm(boolean animaliAmm) {
        this.animaliAmm = animaliAmm;
    }

    public boolean isAriaCond() {
        return ariaCond;
    }

    public void setAriaCond(boolean ariaCond) {
        this.ariaCond = ariaCond;
    }

    public boolean isRistorante() {
        return ristorante;
    }

    public void setRistorante(boolean ristorante) {
        this.ristorante = ristorante;
    }

    public boolean isParcheggio() {
        return parcheggio;
    }

    public void setParcheggio(boolean parcheggio) {
        this.parcheggio = parcheggio;
    }

    public boolean isAccessoDisabili() {
        return accessoDisabili;
    }

    public void setAccessoDisabili(boolean accessoDisabili) {
        this.accessoDisabili = accessoDisabili;
    }

    public boolean isStazioneFs() {
        return stazioneFs;
    }

    public void setStazioneFs(boolean stazioneFs) {
        this.stazioneFs = stazioneFs;
    }

    public boolean isLago() {
        return lago;
    }

    public void setLago(boolean lago) {
        this.lago = lago;
    }

    public boolean isAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(boolean aeroporto) {
        this.aeroporto = aeroporto;
    }

    public boolean isSauna() {
        return sauna;
    }

    public void setSauna(boolean sauna) {
        this.sauna = sauna;
    }

    public boolean isTerme() {
        return terme;
    }

    public void setTerme(boolean terme) {
        this.terme = terme;
    }

    public boolean isSalaConferenze() {
        return salaConferenze;
    }

    public void setSalaConferenze(boolean salaConferenze) {
        this.salaConferenze = salaConferenze;
    }

    public boolean isAreaBimbi() {
        return areaBimbi;
    }

    public void setAreaBimbi(boolean areaBimbi) {
        this.areaBimbi = areaBimbi;
    }

    public boolean isSolarium() {
        return solarium;
    }

    public void setSolarium(boolean solarium) {
        this.solarium = solarium;
    }

    public boolean isMare() {
        return mare;
    }

    public void setMare(boolean mare) {
        this.mare = mare;
    }

    public boolean isPeriferia() {
        return periferia;
    }

    public void setPeriferia(boolean periferia) {
        this.periferia = periferia;
    }

    public boolean isCampagna() {
        return campagna;
    }

    public void setCampagna(boolean campagna) {
        this.campagna = campagna;
    }

    public boolean isCentroStorico() {
        return centroStorico;
    }

    public void setCentroStorico(boolean centroStorico) {
        this.centroStorico = centroStorico;
    }

    public boolean isPalestra() {
        return palestra;
    }

    public void setPalestra(boolean palestra) {
        this.palestra = palestra;
    }

    public boolean isSkilift() {
        return skilift;
    }

    public void setSkilift(boolean skilift) {
        this.skilift = skilift;
    }

    public boolean isInglese() {
        return inglese;
    }

    public void setInglese(boolean inglese) {
        this.inglese = inglese;
    }

    public boolean isFrancese() {
        return francese;
    }

    public void setFrancese(boolean francese) {
        this.francese = francese;
    }
}
