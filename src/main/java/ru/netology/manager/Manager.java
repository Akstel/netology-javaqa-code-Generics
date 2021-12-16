package ru.netology.manager;

import ru.netology.domain.Trip;
import ru.netology.repository.ProductRepository;

import java.util.Arrays;

public class Manager {

    private ProductRepository repository = new ProductRepository();

    public Manager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Trip item) {
        repository.save(item);
    }


    public Trip[] searchByAirports(String arrivalAirport, String departureAirport) {
        Trip[] result = new Trip[0];
        for (Trip trip : repository.findAll()) {
            if (matches(trip, arrivalAirport) && matches(trip, departureAirport)) {
                Trip[] tmp = new Trip[result.length + 1];

                System.arraycopy(result, 0, tmp, 0, result.length);

                tmp[tmp.length - 1] = trip;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Trip trip, String search) {


        if (trip.getArrivalAirport().contains(search)) {
            return true;
        }
        if (trip.getDepartureAirport().contains(search)) {
            return true;
        }
        return false;

    }
}
