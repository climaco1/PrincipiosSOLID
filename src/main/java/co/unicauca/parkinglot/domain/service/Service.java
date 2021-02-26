/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fermt
 */
public class Service {
    
    private IVehicleRepository repository;

    public Service(IVehicleRepository repository) {
        this.repository =  repository;
    }
    
    public long calculateParkingCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        if (veh == null) {
            return -1;
        }
        IParkingCost delivery = ParkingCostFactory.getInstance().getDelivery(veh.getType());
        long result = delivery.calculateCost(veh,input,output);
        return result;
    }
    
    public boolean saveVehicle(Vehicle newVehiculo){
        if (newVehiculo == null){
            return false;
        }
        repository.save(newVehiculo);
        return true;
    }
    
    public List<Vehicle> listVehicles() {
        List<Vehicle> products = new ArrayList<>();
        products = repository.list();;
        return products;
    }
}
