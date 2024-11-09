package com.nijen.app.services;

import com.nijen.app.models.Car;
import com.nijen.app.repositery.CarRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    CarRepositery carRepositery;

    @Autowired
    public void setCarRepositery(CarRepositery carRepositery){
        this.carRepositery = carRepositery;
    }

    public CarRepositery getCarRepositery(){
        return carRepositery;
    }

    public void saveCar(Car car){
        carRepositery.save(car);
    }

    public List<Car> findAll(){
        return carRepositery.findAll();
    }
}
