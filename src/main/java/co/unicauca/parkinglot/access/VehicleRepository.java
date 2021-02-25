/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.service.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleRepository implements IVehicleRepository{
    private Connection conn;

    public VehicleRepository() {
        initDatabase();
    }
    
    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	VehiclePlate text PRIMARY KEY,\n"
                + ");";
                /*
                String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	VehiclePlate text PRIMARY KEY,\n"
                + "	Tipo text NOT NULL,\n"
                + ");";
                */
        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void connect() {
        // Si se quiere guardar los datos a un archivo
        //String url = "jdbc:sqlite:./mydatabase.db";    
        // Guarda los datos en memoria RAM
        String url = "jdbc:sqlite:.mydatabase.sqlite";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
    public boolean save(Vehicle newVehicle) {
        try {
            //Validate product
            if (newVehicle == null) {
                return false;
            }
            //this.connect();
            /*
            String sql = "INSERT INTO Vehicle ( VehiclePlate, Tipo ) "
                    + "VALUES ( ?, ? )";
            */
            String sql = "INSERT INTO Vehicle ( VehiclePlate ) "
                    + "VALUES ( ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVehicle.getPlate());
            //pstmt.set(2, newVehicle.getType());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Vehicle> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
