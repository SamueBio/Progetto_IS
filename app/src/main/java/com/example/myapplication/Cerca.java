package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.Accommodation;
import com.example.myapplication.model.Favourite;
import com.example.myapplication.retrofit.AccommodationApi;
import com.example.myapplication.retrofit.FavouritesApi;
import com.example.myapplication.retrofit.RetrofitService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cerca extends AppCompatActivity {
    private static GlobalData instance;
    private EditText nomeSearch;
    private EditText geographicArea;
    private EditText provincia;
    private TextView backk;
    private ImageButton back;
    private Button searchButton;
    private ImageButton home;
    private ImageView cuore;
    private ImageView loading;
    private ImageButton filtri;
    private ListView resultsListView;
    private AccomodationAdapter adapterAcc;
    private ArrayList<Accommodation> resultAcc;
    private AlertDialog alertDialog;
    private int pos;
    private Spinner spinner;
    private String tipologia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.cerca);

        // Inizializza i componenti dell'interfaccia utente
        nomeSearch = findViewById(R.id.nome);
        searchButton = findViewById(R.id.searchButton);
        filtri= findViewById(R.id.filtri);
        geographicArea = findViewById(R.id.geographicArea);
        provincia = findViewById(R.id.provincia);
        home = (ImageButton) findViewById(R.id.house);

        // Inizializza l'adattatore con la lista completa degli alloggi
        adapterAcc = new AccomodationAdapter(this, resultAcc);

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

        spinner = findViewById(R.id.tipologia);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.campi_array,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Azioni da eseguire quando un elemento è selezionato
                String selectedField = parentView.getItemAtPosition(position).toString();
                tipologia=selectedField;
                //Toast.makeText(Cerca.this, "Campo selezionato: " + selectedField, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Azioni da eseguire quando nessun elemento è selezionato
            }

        });


    }


    //METODO PER GESTIRE I SERVIZI DELLA RICERCA ALLOGGI
    private void showPopup() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.servizi, null);
        dialogBuilder.setView(dialogView);

        final CheckBox autostrada = dialogView.findViewById(R.id.autostrada);
        if(GlobalData.getInstance().isHighway())
            autostrada.setChecked(true);
        autostrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autostrada.setChecked(!GlobalData.getInstance().isHighway());
                boolean sup =!GlobalData.getInstance().isHighway();
                GlobalData.getInstance().setHighway(sup);
            }
        });

        final CheckBox sagra = dialogView.findViewById(R.id.sagra);
        if(GlobalData.getInstance().isCountryFair())
            sagra.setChecked(true);
        sagra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sagra.setChecked(!GlobalData.getInstance().isCountryFair());
                boolean sup =!GlobalData.getInstance().isCountryFair();
                GlobalData.getInstance().setCountryFair(sup);
            }
        });

        /*final String altro = findViewById(R.id.altroText);
        if(GlobalData.getInstance().setOtherServices(altro)){
            autostrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autostrada.setChecked(!GlobalData.getInstance().isCountryFair());
                boolean sup =!GlobalData.getInstance().isCountryFair();
                GlobalData.getInstance().setCountryFair(sup);
            }
        });*/


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
        if(GlobalData.getInstance().isAeroporto())
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
        resultAcc = new ArrayList<>();

        //TODO: query
        Accommodation accommodation = GlobalData.getInstance().getAccommodation();
        accommodation.setName(nomeSearch.getText().toString().toUpperCase().trim());
        accommodation.setTown(geographicArea.getText().toString().toUpperCase().trim());
        accommodation.setProvince(provincia.getText().toString().toUpperCase().trim());
        if(!(tipologia.isEmpty()||tipologia.equals("TIPOLOGIA")))
            accommodation.setType(tipologia);

        Call<ResponseBody> call = accommodationApi.search(accommodation.generateJsonUsername(GlobalData.getInstance().getUsername()));
        setContentView(R.layout.cerca2);
        //setto gli elementi della pagina
        back=findViewById(R.id.back);
        backk=findViewById(R.id.back2);
        loading = findViewById(R.id.loading);
        Glide.with(this)
                .asGif()
                .load(R.drawable.loading)
                .into(loading);

        resultsListView = findViewById(R.id.accommodationListView);

        cuore = findViewById(R.id.pref);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    //Entra qui dentro, capire come estrapolare dati
                    try {

                        String responseBody = response.body().string();
                        if(responseBody.equals("[]")){
                            Toast.makeText(Cerca.this,"NESSUN RISULTATO",(int)4).show();
                            backSearch();

                        }else{
                            resultAcc = (ArrayList<Accommodation>) Accommodation.parseString(responseBody);
                            // Toast.makeText(Cerca.this,responseBody,Toast.LENGTH_SHORT);
                            //setto dall'adapter, visualizzando nome e indirizzo dei risultati
                            adapterAcc = new AccomodationAdapter(Cerca.this, resultAcc);
                            loading.setVisibility(View.GONE);
                            resultsListView.setAdapter(adapterAcc);

                            //VISUALIZZAZIONE PAGINA SPECIFICA ALLOGGIO
                            resultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    // Alloggio selezionato dalla lista
                                    Accommodation alloggioSelezionato = resultAcc.get(position);
                                    pos=position;
                                    // Creazione di un Intent
                                    Intent intent=new Intent(Cerca.this, SpecAll.class);
                                    // Passaggio dell'alloggio attraverso l'Intent
                                    intent.putExtra("alloggio", alloggioSelezionato);
                                    intent.putExtra("pref", false);
                                    // Avvio dell'attività successiva
                                    startActivityForResult(intent, 123);

                                }
                            });

                        }

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Cerca.this, "Ricerca NON effettuata", Toast.LENGTH_SHORT).show();
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

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 123) {

            RetrofitService retrofitService = new RetrofitService();
            AccommodationApi accommodationApi = retrofitService.getRetrofit().create(AccommodationApi.class);

            //ARRAYLIST DEI RISULTATI DELLA RICERCA
            resultAcc = new ArrayList<>();

            //TODO: query
            Accommodation accommodation = GlobalData.getInstance().getAccommodation();
            accommodation.setName(nomeSearch.getText().toString().toUpperCase().trim());
            accommodation.setTown(geographicArea.getText().toString().toUpperCase().trim());
            accommodation.setProvince(provincia.getText().toString().toUpperCase().trim());
            if (!(tipologia.isEmpty() || tipologia.equals("TIPOLOGIA")))
                accommodation.setType(tipologia);

            Call<ResponseBody> call = accommodationApi.search(accommodation.generateJsonUsername(GlobalData.getInstance().getUsername()));
            setContentView(R.layout.cerca2);
            //setto gli elementi della pagina
            back = findViewById(R.id.back);
            backk = findViewById(R.id.back2);
            loading = findViewById(R.id.loading);
            Glide.with(this)
                    .asGif()
                    .load(R.drawable.loading)
                    .into(loading);

            resultsListView = findViewById(R.id.accommodationListView);

            cuore = findViewById(R.id.pref);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        //Entra qui dentro, capire come estrapolare dati
                        try {

                            String responseBody = response.body().string();
                            if (responseBody.equals("[]")) {
                                Toast.makeText(Cerca.this, "NESSUN RISULTATO", (int) 4).show();
                                backSearch();

                            } else {
                                resultAcc = (ArrayList<Accommodation>) Accommodation.parseString(responseBody);
                                // Toast.makeText(Cerca.this,responseBody,Toast.LENGTH_SHORT);
                                //setto dall'adapter, visualizzando nome e indirizzo dei risultati
                                adapterAcc = new AccomodationAdapter(Cerca.this, resultAcc);
                                loading.setVisibility(View.GONE);
                                resultsListView.setAdapter(adapterAcc);

                                //VISUALIZZAZIONE PAGINA SPECIFICA ALLOGGIO
                                resultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        // Alloggio selezionato dalla lista
                                        Accommodation alloggioSelezionato = resultAcc.get(position);
                                        pos = position;
                                        // Creazione di un Intent
                                        Intent intent = new Intent(Cerca.this, SpecAll.class);
                                        // Passaggio dell'alloggio attraverso l'Intent
                                        intent.putExtra("alloggio", alloggioSelezionato);
                                        intent.putExtra("pref", false);
                                        // Avvio dell'attività successiva
                                        startActivityForResult(intent, 123);

                                    }
                                });

                            }

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(Cerca.this, "Ricerca NON effettuata", Toast.LENGTH_SHORT).show();
                }


            });
        }

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
}
