package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Accommodation;
import com.example.myapplication.retrofit.AccommodationApi;
import com.example.myapplication.retrofit.RetrofitService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cerca extends AppCompatActivity {
    private static GlobalData instance;
    private EditText nomeSearch;
    private EditText indirizzo;
    private TextView backk;
    private TextView nomeAll;
    private TextView inviaRichiesta;
    private Button searchButton;
    private ImageButton home;
    private ImageView cuore;
    private ImageButton back;
    private ImageButton filtri;
    private ListView resultsListView;
    private AlloggioAdapter adapter; // Supponiamo che tu abbia un adattatore personalizzato per gli alloggi
    private AccomodationAdapter adapterAcc;
    private ArrayList<Accommodation> resultAcc;
    private ArrayList<Alloggio> allAccommodations; // La lista completa degli alloggi
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.cerca);

        // Inizializza i componenti dell'interfaccia utente
        nomeSearch = findViewById(R.id.nome);
        searchButton = findViewById(R.id.searchButton);
        filtri= findViewById(R.id.filtri);
        indirizzo = findViewById(R.id.indirizzo);
        // resultsListView = findViewById(R.id.accommodationListView);
        home = (ImageButton) findViewById(R.id.house);

        // Inizializza la lista completa degli alloggi con dati di esempio
        allAccommodations = new ArrayList<>();
        allAccommodations.add(new Alloggio("Nome Alloggio 1", "Posizione 1"));
        allAccommodations.add(new Alloggio("Nome Alloggio 2", "Posizione 2"));
        allAccommodations.add(new Alloggio("Nome Alloggio 3", "Posizione 3"));
        allAccommodations.add(new Alloggio("Nome Alloggio 4", "Posizione 4"));
        allAccommodations.add(new Alloggio("Nome Alloggio 5", "Posizione 5"));
        allAccommodations.add(new Alloggio("Nome Alloggio 6", "Posizione 6"));
        allAccommodations.add(new Alloggio("Nome Alloggio 7", "Posizione 7"));
        allAccommodations.add(new Alloggio("Nome Alloggio 8", "Posizione 8"));
        allAccommodations.add(new Alloggio("Nome Alloggio 9", "Posizione 9"));

        // Inizializza l'adattatore con la lista completa degli alloggi
        adapter = new AlloggioAdapter(this, allAccommodations);
        adapterAcc = new AccomodationAdapter(this, resultAcc);

        // Imposta l'adattatore per la ListView
        //resultsListView.setAdapter(adapter);

        // Gestisci il clic del pulsante di ricerca
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

        filtri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });
    }

    /*
    * In this popup there aren't:
    *   highway
    *   countryFair
    *   otherServices (String field)
    *
    * */
    //METODO PER GESTIRE I SERVIZI DELLA RICERCA ALLOGGI
    private void showPopup() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.servizi, null);
        dialogBuilder.setView(dialogView);

        final CheckBox piscina = dialogView.findViewById(R.id.piscina);
        if(GlobalData.getInstance().isPiscina())
            piscina.setChecked(true);
        piscina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                piscina.setChecked(!GlobalData.getInstance().isPiscina());
                boolean sup =!GlobalData.getInstance().isPiscina();
                GlobalData.getInstance().setPiscina(sup);
            }
        });

        final CheckBox piscinaCoperta = dialogView.findViewById(R.id.piscinaCoperta);
        if(GlobalData.getInstance().isPiscinaCoperta())
            piscinaCoperta.setChecked(true);
        piscinaCoperta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                piscinaCoperta.setChecked(!GlobalData.getInstance().isPiscinaCoperta());
                boolean sup =!GlobalData.getInstance().isPiscinaCoperta();
                GlobalData.getInstance().setPiscinaCoperta(sup);
            }
        });

        final CheckBox animaliAmm = dialogView.findViewById(R.id.animaliAmm);
        if(GlobalData.getInstance().isAnimaliAmm())
            animaliAmm.setChecked(true);
        animaliAmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animaliAmm.setChecked(!GlobalData.getInstance().isAnimaliAmm());
                boolean sup =!GlobalData.getInstance().isAnimaliAmm();
                GlobalData.getInstance().setAnimaliAmm(sup);
            }
        });

        final CheckBox ariaCond = dialogView.findViewById(R.id.ariaCond);
        if(GlobalData.getInstance().isAriaCond())
            ariaCond.setChecked(true);
        ariaCond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ariaCond.setChecked(!GlobalData.getInstance().isAriaCond());
                boolean sup =!GlobalData.getInstance().isAriaCond();
                GlobalData.getInstance().setAriaCond(sup);
            }
        });

        final CheckBox ristorante = dialogView.findViewById(R.id.ristorante);
        if(GlobalData.getInstance().isRistorante())
            ristorante.setChecked(true);
        ristorante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ristorante.setChecked(!GlobalData.getInstance().isRistorante());
                boolean sup =!GlobalData.getInstance().isRistorante();
                GlobalData.getInstance().setRistorante(sup);
            }
        });

        final CheckBox parcheggio = dialogView.findViewById(R.id.parcheggio);
        if(GlobalData.getInstance().isParcheggio())
            parcheggio.setChecked(true);
        parcheggio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parcheggio.setChecked(!GlobalData.getInstance().isParcheggio());
                boolean sup =!GlobalData.getInstance().isParcheggio();
                GlobalData.getInstance().setParcheggio(sup);
            }
        });

        final CheckBox accessoDisabili = dialogView.findViewById(R.id.accessoDisabili);
        if(GlobalData.getInstance().isAccessoDisabili())
            accessoDisabili.setChecked(true);
        accessoDisabili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accessoDisabili.setChecked(!GlobalData.getInstance().isAccessoDisabili());
                boolean sup =!GlobalData.getInstance().isAccessoDisabili();
                GlobalData.getInstance().setAccessoDisabili(sup);
            }
        });

        final CheckBox stazioneFs = dialogView.findViewById(R.id.stazioneFs);
        if(GlobalData.getInstance().isStazioneFs())
            stazioneFs.setChecked(true);
        stazioneFs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stazioneFs.setChecked(!GlobalData.getInstance().isStazioneFs());
                boolean sup =!GlobalData.getInstance().isStazioneFs();
                GlobalData.getInstance().setStazioneFs(sup);
            }
        });

        final CheckBox lago = dialogView.findViewById(R.id.lago);
        if(GlobalData.getInstance().isLago())
            lago.setChecked(true);
        lago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lago.setChecked(!GlobalData.getInstance().isLago());
                boolean sup =!GlobalData.getInstance().isLago();
                GlobalData.getInstance().setLago(sup);
            }
        });

        final CheckBox aeroporto = dialogView.findViewById(R.id.aeroporto);
        if(GlobalData.getInstance().isParcheggio())
            aeroporto.setChecked(true);
        aeroporto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aeroporto.setChecked(!GlobalData.getInstance().isAeroporto());
                boolean sup =!GlobalData.getInstance().isAeroporto();
                GlobalData.getInstance().setAeroporto(sup);
            }
        });

        final CheckBox sauna = dialogView.findViewById(R.id.sauna);
        if(GlobalData.getInstance().isSauna())
            sauna.setChecked(true);
        sauna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sauna.setChecked(!GlobalData.getInstance().isSauna());
                boolean sup =!GlobalData.getInstance().isSauna();
                GlobalData.getInstance().setSauna(sup);
            }
        });

        final CheckBox terme = dialogView.findViewById(R.id.terme);
        if(GlobalData.getInstance().isTerme())
            terme.setChecked(true);
        terme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terme.setChecked(!GlobalData.getInstance().isTerme());
                boolean sup =!GlobalData.getInstance().isTerme();
                GlobalData.getInstance().setTerme(sup);
            }
        });

        final CheckBox salaConferenze = dialogView.findViewById(R.id.conferenze);
        if(GlobalData.getInstance().isSalaConferenze())
            salaConferenze.setChecked(true);
        salaConferenze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salaConferenze.setChecked(!GlobalData.getInstance().isSalaConferenze());
                boolean sup =!GlobalData.getInstance().isSalaConferenze();
                GlobalData.getInstance().setSalaConferenze(sup);
            }
        });

        final CheckBox areaBimbi = dialogView.findViewById(R.id.bimbi);
        if(GlobalData.getInstance().isAreaBimbi())
            areaBimbi.setChecked(true);
        areaBimbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                areaBimbi.setChecked(!GlobalData.getInstance().isAreaBimbi());
                boolean sup =!GlobalData.getInstance().isAreaBimbi();
                GlobalData.getInstance().setAreaBimbi(sup);
            }
        });


        final CheckBox solarium = dialogView.findViewById(R.id.solarium);
        if(GlobalData.getInstance().isSolarium())
            solarium.setChecked(true);
        solarium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solarium.setChecked(!GlobalData.getInstance().isSolarium());
                boolean sup =!GlobalData.getInstance().isSolarium();
                GlobalData.getInstance().setSolarium(sup);
            }
        });


        final CheckBox mare = dialogView.findViewById(R.id.mare);
        if(GlobalData.getInstance().isMare())
            mare.setChecked(true);
        mare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mare.setChecked(!GlobalData.getInstance().isMare());
                boolean sup =!GlobalData.getInstance().isMare();
                GlobalData.getInstance().setMare(sup);
            }
        });


        final CheckBox periferia = dialogView.findViewById(R.id.periferia);
        if(GlobalData.getInstance().isPeriferia())
            periferia.setChecked(true);
        periferia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                periferia.setChecked(!GlobalData.getInstance().isPeriferia());
                boolean sup =!GlobalData.getInstance().isPeriferia();
                GlobalData.getInstance().setPeriferia(sup);
            }
        });

        final CheckBox collina = dialogView.findViewById(R.id.collina);
        if(GlobalData.getInstance().isCollinare())
            collina.setChecked(true);
        collina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                collina.setChecked(!GlobalData.getInstance().isCollinare());
                boolean sup =!GlobalData.getInstance().isCollinare();
                GlobalData.getInstance().setCollinare(sup);
            }
        });

        final CheckBox centroStorico = dialogView.findViewById(R.id.centroStorico);
        if(GlobalData.getInstance().isCentroStorico())
            centroStorico.setChecked(true);
        centroStorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centroStorico.setChecked(!GlobalData.getInstance().isCentroStorico());
                boolean sup =!GlobalData.getInstance().isCentroStorico();
                GlobalData.getInstance().setCentroStorico(sup);
            }
        });

        final CheckBox palestra = dialogView.findViewById(R.id.palestra);
        if(GlobalData.getInstance().isPalestra())
            palestra.setChecked(true);
        palestra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                palestra.setChecked(!GlobalData.getInstance().isPalestra());
                boolean sup =!GlobalData.getInstance().isPalestra();
                GlobalData.getInstance().setPalestra(sup);
            }
        });

        final CheckBox skilift = dialogView.findViewById(R.id.skilift);
        if(GlobalData.getInstance().isSkilift())
            skilift.setChecked(true);
        skilift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skilift.setChecked(!GlobalData.getInstance().isSkilift());
                boolean sup =!GlobalData.getInstance().isSkilift();
                GlobalData.getInstance().setSkilift(sup);
            }
        });


        final CheckBox inglese = dialogView.findViewById(R.id.inglese);
        if(GlobalData.getInstance().isInglese())
            inglese.setChecked(true);
        inglese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inglese.setChecked(!GlobalData.getInstance().isInglese());
                boolean sup =!GlobalData.getInstance().isInglese();
                GlobalData.getInstance().setInglese(sup);
            }
        });

        final CheckBox spagnolo = dialogView.findViewById(R.id.spagnolo);
        if(GlobalData.getInstance().isSpagnolo())
            spagnolo.setChecked(true);
        spagnolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spagnolo.setChecked(!GlobalData.getInstance().isSpagnolo());
                boolean sup =!GlobalData.getInstance().isSpagnolo();
                GlobalData.getInstance().setSpagnolo(sup);
            }
        });


        final CheckBox tedesco = dialogView.findViewById(R.id.tedesco);
        if(GlobalData.getInstance().isTedesco())
            tedesco.setChecked(true);
        tedesco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tedesco.setChecked(!GlobalData.getInstance().isTedesco());
                boolean sup =!GlobalData.getInstance().isTedesco();
                GlobalData.getInstance().setTedesco(sup);
            }
        });

        final CheckBox francese = dialogView.findViewById(R.id.francese);
        if(GlobalData.getInstance().isFrancese())
            francese.setChecked(true);
        francese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                francese.setChecked(!GlobalData.getInstance().isFrancese());
                boolean sup =!GlobalData.getInstance().isFrancese();
                GlobalData.getInstance().setFrancese(sup);
            }
        });
        Button btnSelectServices = dialogView.findViewById(R.id.btnSelectServices);
        btnSelectServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }


    //METODO PER EFFETTUARE LA RICERCA
    @SuppressLint("MissingInflatedId")
    private void performSearch() {
        RetrofitService retrofitService = new RetrofitService();
        AccommodationApi accommodationApi = retrofitService.getRetrofit().create(AccommodationApi.class);

        //ARRAYLIST DEI RISULTATI DELLA RICERCA
        ArrayList<Accommodation> result = new ArrayList<>();

        //TODO: query
        Accommodation accommodation = GlobalData.getInstance().getAccommodation();
        accommodation.setName(nomeSearch.getText().toString());
        accommodation.setAddress(indirizzo.getText().toString());

        Call<ResponseBody> call = accommodationApi.search(accommodation.generateJson());

        /*call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //da implementare il salvataggio della response della chiamata API nella
               // lista "resultAcc"
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });*/


        result.add(accommodation);
        adapterAcc = new AccomodationAdapter(this, result);
        //passo alla visualizzazione della pagina di ricerca eseguita
        setContentView(R.layout.cerca2);
        //setto gli elementi della pagina
        back=findViewById(R.id.back);
        backk=findViewById(R.id.back2);
        nomeAll = findViewById(R.id.nameTextView);
        resultsListView = findViewById(R.id.accommodationListView);
        resultsListView.setAdapter(adapter);
        cuore = findViewById(R.id.pref);
        resultsListView = findViewById(R.id.accommodationListView);
        //setto dall'adapter, visualizzando nome e indirizzo dei risultati
        resultsListView.setAdapter(adapterAcc);

        //------------------------------------
        /*String keyword = nomeSearch.getText().toString();
        String keyword2 = indirizzo.getText().toString();
        String[] inputArray = (keyword+" "+keyword2).trim().split(" ");
        adapter = new AlloggioAdapter(this, filterAccommodationsByKeywords(allAccommodations, inputArray));
        setContentView(R.layout.cerca2);
        back=findViewById(R.id.back);
        backk=findViewById(R.id.back2);
        nomeAll = findViewById(R.id.nameTextView);
        resultsListView = findViewById(R.id.accommodationListView);
        resultsListView.setAdapter(adapter);
        cuore = findViewById(R.id.pref);
        //------------------------------------
        //righe da eliminare se query di ricerca funziona correttamente

*/

        nomeAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { specAll(v);
            }
        });
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                backSearch();
            }
        });
        backk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                backSearch();
            }
        });
    }

    //GESTIONE ALLOGGIO PREFERITO
    public void onHeartIconClick(View view) {
        ImageView heartIcon = (ImageView) view;
        Alloggio accommodation = (Alloggio) heartIcon.getTag();
        if (accommodation.isFavourited()) {
            heartIcon.setImageResource(R.drawable.cuore);
           // removeFromFavorites(accommodation);
        } else {
            heartIcon.setImageResource(R.drawable.cuore_si);
            //addToFavorites(accommodation);
        }
        accommodation.setFavourited(!accommodation.isFavourited());
    }

    //METODO VISUALIZZAZIONE DASHBOARD
    private void openDashboard(){
        Intent intent=new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    //METODO PER TORNARE INDIETRO NELLA PAGINA DI RICERCA ALLOGGIO
    private void backSearch(){
        Intent intent=new Intent(this, Cerca.class);
        startActivity(intent);
    }

    //VISUALIZZAZIONE PAGINA SPECIFICA ALLOGGIO
    public void specAll(View view){
        Intent intent=new Intent(this, SpecAll.class);
        intent.putExtra("nome_alloggio", nomeAll.getText());
        startActivity(intent);
    }


    //METODI PER FILTRARE LA RICERCA IN BASE A NOME E/O INDIRIZZO

    // --->  METODI DA ELIMINARE UNA VOLTA IMPLEMENTATA CORRETTAMENTE LA RICERCA CON QUERY  <----

    private ArrayList<Alloggio> filterAccommodationsByKeywords(ArrayList<Alloggio> allAccommodations, String[] keywords) {
        ArrayList<Alloggio> filteredAccommodations = new ArrayList<>();
        String[] arrayStringhe = new String[keywords.length];
        for (int i = 0; i < keywords.length; i++) {
           arrayStringhe[i] = String.valueOf(keywords[i]);
        }
        for(int j=0; j<allAccommodations.size(); j++){
            for(int i=0; i<keywords.length; i++){
                if (accommodationContainsKeyword(allAccommodations.get(j), keywords[i])) {
                    filteredAccommodations.add(allAccommodations.get(j));
                    i = keywords.length;
                }
            }
        }
        return filteredAccommodations;
    }
    private boolean accommodationContainsKeyword(Alloggio accommodation, String keyword) {
        return accommodation.getNome().toLowerCase().contains(keyword.toLowerCase())
                || accommodation.getIndirizzo().toLowerCase().contains(keyword.toLowerCase());
    }
}
