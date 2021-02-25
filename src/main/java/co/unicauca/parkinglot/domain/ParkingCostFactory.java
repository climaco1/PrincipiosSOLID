/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 * Fábrica de que utiliza el patrón de diseño Singleton para generar una
 * instancia de la interfaz IParkingCost
 *
 * @author Libardo, Julio
 */
public class ParkingCostFactory {

    private Map<TypeEnum, IParkingCost> dictionary;

    // Singleton
    private static ParkingCostFactory instance;
   
    private ParkingCostFactory() {
        dictionary = new EnumMap<>(TypeEnum.class);
        dictionary.put(TypeEnum.CAR, new CarParkingCost());
        dictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        dictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
    }
     /**
     * Devuelve la instancia de la clase
     *
     * @return instancia unica de la la fábrica
     */
    public static ParkingCostFactory getInstance() {
        if (instance == null) {
            instance = new ParkingCostFactory();
        }
        return instance;
    }
    
    public IParkingCost getDelivery(TypeEnum type) {
        IParkingCost result = null;
        if (dictionary.containsKey(type)) {
            result = dictionary.get(type);
        }
        return result;
    }
}
