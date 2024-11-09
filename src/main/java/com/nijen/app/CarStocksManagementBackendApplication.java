package com.nijen.app;

import com.nijen.app.models.Car;
import com.nijen.app.services.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CarStocksManagementBackendApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(CarStocksManagementBackendApplication.class, args);
        Car car = context.getBean(Car.class);
        car.setCarName("Kia");
        car.setCarModel("Seltos");
        car.setCarModelYear(2024);
        CarService carService = context.getBean(CarService.class);
        carService.saveCar(car);

        System.out.println("All Cars Details:");
        carService.findAll().forEach(System.out::println);
    }

}
