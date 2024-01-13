package net.javaguides.springboot.model.csv;

import net.javaguides.springboot.model.accomodation.Accommodation;
import net.javaguides.springboot.model.accomodation.AccommodationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CsvDataService {
    @Autowired
    private AccommodationDao accomodationDao;
    private boolean isInteger(String toVerify){
        toVerify=toVerify.replace("\"","");
        if (toVerify.isEmpty()) {
            return false;
        }
        boolean ret = true;
        for(int i = 0; i< toVerify.length();++i){
            if(toVerify.charAt(i) < '0' || toVerify.charAt(i) > '9')
               ret = false;
        }
        return ret;
    }
    private boolean isDate(String toVerify){
        String div = "/";
        if(toVerify.split(div).length != 3)
            return false;
        else
            return true;
    }
    private Date toDate(String toConvert){
        String div = "/";
        int day = Integer.parseInt(toConvert.split(div)[0]);
        int month = Integer.parseInt(toConvert.split(div)[1]);
        int year = Integer.parseInt(toConvert.split(div)[2]);
        return new Date(year,month,day);
    }

    private boolean toBool(String toConvert){
        toConvert = toConvert.toUpperCase();
        if(toConvert.equals("VERO"))
            return true;
        else
            return false;
    }

    public void saveDataFromCsv(String filePath) {

        String COMMA_DELIMITER = ";";
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        char v = 34;
        int fairZoneCounter = 0;
        int stationCounter = 1;
        int spanishCounter = 2;
        int lakeCounter = 3;
        int airportCounter = 4;
        int capCounter = 5;
        int internCounter = 6;
        int superstreetCounter = 7;
        int fitnessCounter = 8;
        int idCounter = 9;
        int conferenceRoomCounter = 10;
        int kidsGamesCounter = 11;
        int secondaryTypeCounter = 12;
        int parkingCounter = 13;
        int categoryCounter = 14;
        int saunaCounter = 15;
        int areaCounter = 16;
        int skiliftsCounter = 17;
        int provinceCounter = 18;
        int nameCounter = 19;
        int websiteCounter = 20;
        int englishCounter = 21;
        int starsCounter = 22;
        int thermalCounter = 23;
        int otherServicesCounter = 45;
        int disablePeopleCounter = 25;
        int outskirtsCounter = 26;
        int oldTownCounter = 27;
        int locationCounter = 28;
        int airConditioningCounter = 29;
        int seaCounter = 30;
        int petsCounter = 31;
        int poolCounter = 32;
        int faxCounter = 33;
        int newClasslr11Counter = 34;
        int germanCounter = 35;
        int telephoneCounter = 36;
        int hillCounter = 37;
        int townCounter = 38;
        int tempClosureCounter = 39;
        int civicNumberCounter = 40;
        int frenchCounter = 41;
        int restaurantCounter = 42;
        int typeCounter = 43;
        int addressCounter = 44;
        int coveredPoolCounter = 45;
        int dateLastUpdateCounter = 46;
        int solariumCounter = 47;
        int mailCounter = 48;


        for(int i = 1; i < records.size();++i){
            Accommodation accomodation = new Accommodation();
            //Campi String
            int z;
            //System.out.println("i = "+i);
            //System.out.println(records.get(i).size());
            //System.out.println(records.get(i));
            z = provinceCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setProvince(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            z=townCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setTown(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            z=locationCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setLocation(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            z=typeCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setType(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            z=categoryCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setCategory((records.get(i).get(z)).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            z=starsCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setStars((records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=nameCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setName(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            z=addressCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setAddress(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            z=civicNumberCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setHouseNumber(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            z=internCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setInterno((records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=capCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setCap(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            z=telephoneCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setTelephone(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            z=faxCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setFax(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            z=mailCounter;
            if(records.get(i).size() > z && records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setEmail(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            else
                accomodation.setEmail("");
            z=websiteCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setWebsite(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            z=areaCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setArea(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            z=disablePeopleCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setDisablePeopleAccess(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=poolCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setPool(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=coveredPoolCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setCoveredPool(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=restaurantCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setRestaurant(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=parkingCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setParking(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=conferenceRoomCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setConferenceRoom(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=airConditioningCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setAirConditioning(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=kidsGamesCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setChildrensGames(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=saunaCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setSauna(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=solariumCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setSolarium(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=fitnessCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setFitness(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=petsCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setPets(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=oldTownCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setOldTown(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=fairZoneCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setCountryFair(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=lakeCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setLake(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=airportCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setAirport(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=superstreetCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setHighway(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=skiliftsCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setSkiLifts(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=stationCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setFsStation(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=seaCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setSea(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=thermalCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setThermal(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=outskirtsCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setOutskirts(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=hillCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setHilly(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=englishCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setEnglish(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=frenchCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setFrench(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=germanCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setGerman(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=spanishCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setSpanish(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=tempClosureCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setTemporaryClosure(toBool(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=otherServicesCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length>0)
                accomodation.setOtherServices((records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length - 1]));
            //while(!isInteger(records.get(i).get(z))) {
            //    if(records.get(i).get(z).split(String.valueOf(v)).length>0)
            //        accomodation.setOtherServices(accomodation.getOtherServices()+(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length - 1]));
            //    ++z;
            //}
            z=idCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setId(Integer.parseInt(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z=dateLastUpdateCounter;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setLastTimeUpdated(toDate(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            z = newClasslr11Counter;
            if(records.get(i).get(z).split(String.valueOf(v)).length <= 1)
                accomodation.setNewLR11Classification("");
            else
                accomodation.setNewLR11Classification((records.get(i).get(z).split(String.valueOf(v))[1]));
            //System.out.println(accomodation);
            accomodationDao.save(accomodation);
        }
    }
}

