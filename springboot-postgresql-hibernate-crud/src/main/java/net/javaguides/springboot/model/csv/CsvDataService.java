package net.javaguides.springboot.model.csv;

import net.javaguides.springboot.model.accomodation.Accomodation;
import net.javaguides.springboot.model.accomodation.AccomodationDao;
import net.javaguides.springboot.model.user.User;
import net.javaguides.springboot.model.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CsvDataService {
    @Autowired
    private AccomodationDao accomodationDao;
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
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
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
        for(int i = 3657; i < records.size();++i){
            Accomodation accomodation = new Accomodation();
            //Campi String
            int z = 0;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setProvince(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setTown(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setLocation(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setType(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setCategory((records.get(i).get(5)).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setStars((records.get(i).get(6).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setName(records.get(i).get(7).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setAddress(records.get(i).get(8).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setHouseNumber(records.get(i).get(9).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setInterno((records.get(i).get(10).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setCap(records.get(i).get(11).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setTelephone(records.get(i).get(12).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setFax(records.get(i).get(13).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setEmail(records.get(i).get(14).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setWebsite(records.get(i).get(15).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setArea(records.get(i).get(16).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]);
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setDisablePeopleAccess(toBool(records.get(i).get(17).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setPool(toBool(records.get(i).get(18).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setCoveredPool(toBool(records.get(i).get(19).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setRestaurant(toBool(records.get(i).get(20).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setParking(toBool(records.get(i).get(21).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setConferenceRoom(toBool(records.get(i).get(22).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setAirConditioning(toBool(records.get(i).get(23).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setChildrensGames(toBool(records.get(i).get(24).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setSauna(toBool(records.get(i).get(25).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setSolarium(toBool(records.get(i).get(26).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setFitness(toBool(records.get(i).get(27).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setPets(toBool(records.get(i).get(28).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setOldTown(toBool(records.get(i).get(29).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setCountryFair(toBool(records.get(i).get(30).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setLake(toBool(records.get(i).get(31).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setAirport(toBool(records.get(i).get(32).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setHighway(toBool(records.get(i).get(33).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setSkiLifts(toBool(records.get(i).get(34).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setFsStation(toBool(records.get(i).get(35).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setSea(toBool(records.get(i).get(36).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setThermal(toBool(records.get(i).get(37).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setOutskirts(toBool(records.get(i).get(38).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setHilly(toBool(records.get(i).get(39).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setEnglish(toBool(records.get(i).get(40).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setFrench(toBool(records.get(i).get(41).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setGerman(toBool(records.get(i).get(42).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setSpanish(toBool(records.get(i).get(43).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setTemporaryClosure(toBool(records.get(i).get(44).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;

            while(!isInteger(records.get(i).get(z))) {
                if(records.get(i).get(z).split(String.valueOf(v)).length>0)
                    accomodation.setOtherServices(accomodation.getOtherServices()+(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length - 1]));
                ++z;
            }
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setId(Integer.parseInt(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;
            if(records.get(i).get(z).split(String.valueOf(v)).length > 0)
                accomodation.setLastTimeUpdated(toDate(records.get(i).get(z).split(String.valueOf(v))[records.get(i).get(z).split(String.valueOf(v)).length-1]));
            ++z;

            if(records.get(i).size() <= z)
                accomodation.setNewLR11Classification("");
            else
                accomodation.setNewLR11Classification((records.get(i).get(z).split(String.valueOf(v))[1]));

            accomodationDao.save(accomodation);
        }
    }
}

