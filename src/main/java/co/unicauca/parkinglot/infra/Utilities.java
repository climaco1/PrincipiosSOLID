/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.infra;

import co.unicauca.parkinglot.domain.TypeEnum;

/**
 *
 * @author fermt
 */
public class Utilities {
    /*
    // Singleton
    private static Utilities instance;
    
    private Utilities() {
    }
    
    public static Utilities getInstance() {
        if (instance == null) {
            instance = new Utilities();
        }
        return instance;
    }
    */
    public TypeEnum string_to_enum(String cadena){
        switch (cadena) {
            case "CAR":
                return TypeEnum.CAR;
            case "MOTO":
                return TypeEnum.MOTO;
            case "TRUCK":
                return TypeEnum.TRUCK;
        }
        return null;
    }
}
