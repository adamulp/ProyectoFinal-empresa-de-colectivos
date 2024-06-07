/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EmpresaDeColectivo.Entidades;

import accesoADatos.PasajeData;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Hollmann
 */
public class main {

    
    public static void main(String[] args) {
        //Prueba de pasajes
        LocalDate fecha = LocalDate.of(2024, 6, 7);
        LocalTime hora = LocalTime.of(15, 32, 45);
        
        PasajeData pd = new PasajeData();

        Pasaje p1 = new Pasaje(0, 0, 0, fecha, hora, 3, 24);

        pd.guardarPasaje(p1);
    }

}
