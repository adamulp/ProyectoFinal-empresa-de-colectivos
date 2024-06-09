
package EmpresaDeColectivo.Entidades;

import accesoADatos.PasajeData;
import accesoADatos.PasajeroData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


/**
 *
 * @author Hollmann
 */
public class main {

    public static void main(String[] args) {
        /*
---------------------------- Pruebas de PasajeroData ------------------------------------------------
         */

        PasajeroData psd = new PasajeroData();
        Pasajero ps1 = new Pasajero("Alexis", "Allendez", "44643928", "alexis@dwd.com", "261231241");
        Pasajero ps2 = new Pasajero("Enzo", "Casalegno", "4124124", "dwqdq@dwd.com", "2123121412");
        Pasajero ps3 = new Pasajero("Nicolas", "Hollman", "5421124", "dqwqwd@dwd.com", "512141");
        Pasajero ps4 = new Pasajero("Adam", "Rigg", "53453", "dqwqwd@dwd.com", "645641");
        
    //Guardar Pasajeros
       psd.guardarPasajero(ps1);
       psd.guardarPasajero(ps2);
       psd.guardarPasajero(ps3);
       psd.guardarPasajero(ps4);
        
    //BuscarPasajeros
     Pasajero p1 = psd.buscarPasajero(ps1.getIdPasajero());
     Pasajero p2 = psd.buscarPasajero(ps2.getIdPasajero());
     Pasajero p3 = psd.buscarPasajero(ps3.getIdPasajero());
     Pasajero p4 = psd.buscarPasajero(ps4.getIdPasajero());
     
        if (p1 != null) {
           System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);
      }
        
    //ListarPasajeros
    
    List<Pasajero> lista1 = psd.listarPasajeros();
        System.out.println("-----------------------------------------------");
        System.out.println("Los pasajeros son: ");
        
        for(int i = 0 ; i < lista1.size();i++){
            System.out.println(lista1.get(i));
        }
      
     //ModificarPasajero
     p1.setDni("5124124");
     p2.setDni("2151");
     p3.setDni("5142");
     p4.setDni("6431");
      
     psd.modificarPasajero(p1);
     psd.modificarPasajero(p2);
     psd.modificarPasajero(p3);
     psd.modificarPasajero(p4);
   
     
     //EliminarPasajero
     psd.eliminarPasajero(45);
     
     //BuscarPasajeroPorDNI
     
        System.out.println("Pasajero buscado por DNI");
              Pasajero Ale = new Pasajero("Ale", "Ashendes", "5123", "dqwqwd@dwd.com", "2141");
              psd.guardarPasajero(Ale);
              Ale = psd.buscarPasajeroPorDni("5123");
              
              System.out.println(Ale);
    }
}
