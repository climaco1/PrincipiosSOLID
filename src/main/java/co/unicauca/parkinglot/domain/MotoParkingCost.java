/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 *
 * @author fermt
 */
public class MotoParkingCost implements IParkingCost {
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        long result;
        /*
        int hora_entrada = input.getHour(),hora_salida = input.getHour();
        if(hora_salida - hora_entrada <= 1){
            result = 1000;
        }else{
            result = 3600;
        }
        */
        return 6300;
    }
}
