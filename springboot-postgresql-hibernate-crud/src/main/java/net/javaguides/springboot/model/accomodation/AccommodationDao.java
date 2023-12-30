package net.javaguides.springboot.model.accomodation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccommodationDao {
    @Autowired
    private AccommodationRepository accomodationRepository;

    public void save(Accommodation accomodation){accomodationRepository.save(accomodation);}

    public List<Accommodation> getAllAccomodations(){
        return accomodationRepository.findAll();
    }

    public List<AccommodationBoolean> getAccommodationFavourite(AccommodationFavourite accommodationFavourite){return accomodationRepository.search(accommodationFavourite);}
    public List<AccommodationBoolean> getAllAccommodationBoolean(AccommodationFavourite accommodationFavourite){return accomodationRepository.getAllAccommodationBoolean(accommodationFavourite);}

    public List<Accommodation> getAccomodationByName(String name){
        return accomodationRepository.findByName(name);
    }

    public List<Accommodation> getAccomodationByServices(Accommodation accommodation){

        return accomodationRepository.findByServices(accommodation);
    }

    public List<AccommodationBoolean> search(AccommodationFavourite accommodationFavourite){
        return accomodationRepository.search(accommodationFavourite);
    }

    public void delete(int id) {
        accomodationRepository.deleteById(id);
    }


}
