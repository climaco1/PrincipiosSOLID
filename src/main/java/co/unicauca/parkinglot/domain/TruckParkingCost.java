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
public class TruckParkingCost implements IParkingCost {
    private long result = 0;
    private boolean ganoSorteo = false;
    
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output){
        if(ganoSorteo){
           return 0;
        }else{
             int totalDias = output.getDayOfMonth() - input.getDayOfMonth();
            int totalHoras = output.getHour() - input.getHour();

            if(totalHoras <= 12 && totalDias == 0){
                result = 10000;
            }else{
                if( totalHoras > 12 && totalHoras <=24 && totalDias == 0){
                    result = 15000;
                }else{
                    result = 15000 + (((totalDias-1)*24 + totalHoras) * 15000)/24;
                }    
            }
            return ((result + 99) / 100 ) * 100;
        }
    }
    
    public boolean sortearCon(int prmNumero){
        int numeroAleatorio = (int)(Math.random() * 1000) + 1; //Encuantra un numero aleatorio entre 1-1000
        ganoSorteo = (numeroAleatorio == prmNumero);
        return ganoSorteo;
    }
}
