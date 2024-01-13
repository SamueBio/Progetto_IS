package net.javaguides.springboot.model.csv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsvController {
    @Autowired
    private CsvDataService csvDataService;

    //@GetMapping("/load-csv")
    public ResponseEntity<String> loadCsvData() {
        csvDataService.saveDataFromCsv("C:\\Users\\sfori\\Downloads\\Elenco-delle-Strutture-Ricettive-Turistiche-della-Regione-Veneto.csv");
        return ResponseEntity.ok("Dati CSV salvati nel database.");
    }
}
