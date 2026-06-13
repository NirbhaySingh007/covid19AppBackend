package com.example.myfavouriteservice.service;

import java.util.ArrayList;
import java.util.List;

import com.example.myfavouriteservice.exception.CountryAlreadyExistsException;
import com.example.myfavouriteservice.exception.CountryNotFoundException;
import com.example.myfavouriteservice.model.Covid;
import com.example.myfavouriteservice.model.User;
import com.example.myfavouriteservice.repository.FavouriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FavouriteServiceImpl implements FavouriteService{

    //	@Autowired
    private FavouriteRepository favRepository;

    @Autowired
    public FavouriteServiceImpl(FavouriteRepository favRepository) {
        super();
        this.favRepository = favRepository;
    }

    @Override
    public User saveCountryToFavorite(Covid covid, String username) throws CountryAlreadyExistsException {
        // TODO Auto-generated method stub
        User user1 = favRepository.findByUsername(username);

        if (user1 == null) {
            user1 = new User(username, new ArrayList<Covid>());
        }

        List<Covid> covidList = user1.getCountryList();

        if (covidList != null) {
            for (Covid p : covidList) {

                if (p.getCountry().equals(covid.getCountry())) {
                    throw new CountryAlreadyExistsException();
                }
            }

            covidList.add(covid);

            System.out.println("Saving Data if block");
            user1.setCountryList(covidList);
            favRepository.save(user1);
        }

        else {
            covidList = new ArrayList();
            covidList.add(covid);

            user1.setCountryList(covidList);
            favRepository.save(user1);
        }
        return user1;

    }



    @Override
    public User deleteCountryFromFavorite(String country, String username) throws CountryNotFoundException {
        User user1 = favRepository.findByUsername(username);
        boolean trackFound = false;
        int indexnum = 0;
        List<Covid> covidList = user1.getCountryList();

        if (covidList != null && covidList.size() > 0) {
            for (Covid t : covidList) {
                indexnum++;
                if (t.getCountry().equals(country)) {
                    covidList.remove(indexnum - 1);
                    user1.setCountryList(covidList);
                    favRepository.save(user1);
                    break;
                }
            }

        }

        else {
            throw new CountryNotFoundException();
        }
        return user1;
    }

    @Override
    public List<Covid> getCountryList(String username) throws Exception {
        User user1 = favRepository.findByUsername(username);
        return user1.getCountryList();
    }


}
