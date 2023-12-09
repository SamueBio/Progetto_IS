package net.javaguides.springboot.model.accomodation;

import net.javaguides.springboot.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccomodationDao {
    @Autowired
    private AccomodationRepository accomodationRepository;

    public void save(Accomodation accomodation){accomodationRepository.save(accomodation);}

    public List<Accomodation> getAllAccomodations(){
        return accomodationRepository.findAll();
    }

    public List<Accomodation> getAccomodationByName(String name){
        return accomodationRepository.findByName(name);
    }

    public List<Accomodation> getAccomodationByServices(Services services){

        return accomodationRepository.findByServices(services);
    }

    public void delete(int id) {
        accomodationRepository.deleteById(id);
    }


}
