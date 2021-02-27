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
public class CarParkingCost implements IParkingCost{
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        long result = 0;
        
        int totalHoras = output.getHour() - input.getHour();
        int minutosTranscurridos = output.getMinute() - input.getMinute();
        
        if(totalHoras <= 1 && minutosTranscurridos <= 0){
            result = 2000;
        }else{
            result = 2000 + (((totalHoras-1)*60 + minutosTranscurridos) * 1000)/60;
        }
        return result;
    }
}
