
package EmpresaDeColectivo.Entidades;

import accesoADatos.PasajeData;
import accesoADatos.PasajeroData;
import accesoADatos.RutaData;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


/**
 *
 * @author Hollmann
 */
public class Main {

    public static void main(String[] args) {
        /*
//---------------------------- Pruebas de PasajeroData ------------------------------------------------
//         */
//
//        PasajeroData psd = new PasajeroData();
//        Pasajero ps1 = new Pasajero("Alexis", "Allendez", "44643928", "alexis@dwd.com", "261231241");
//        Pasajero ps2 = new Pasajero("Enzo", "Casalegno", "4124124", "dwqdq@dwd.com", "2123121412");
//        Pasajero ps3 = new Pasajero("Nicolas", "Hollman", "5421124", "dqwqwd@dwd.com", "512141");
//        Pasajero ps4 = new Pasajero("Adam", "Rigg", "53453", "dqwqwd@dwd.com", "645641");
//        
//    //Guardar Pasajeros
//       psd.guardarPasajero(ps1);
//       psd.guardarPasajero(ps2);
//       psd.guardarPasajero(ps3);
//       psd.guardarPasajero(ps4);
//        
//    //BuscarPasajeros
//     Pasajero p1 = psd.buscarPasajero(ps1.getIdPasajero());
//     Pasajero p2 = psd.buscarPasajero(ps2.getIdPasajero());
//     Pasajero p3 = psd.buscarPasajero(ps3.getIdPasajero());
//     Pasajero p4 = psd.buscarPasajero(ps4.getIdPasajero());
//     
//        if (p1 != null) {
//           System.out.println(p1);
//            System.out.println(p2);
//            System.out.println(p3);
//            System.out.println(p4);
//      }
//        
//    //ListarPasajeros
//    
//    List<Pasajero> lista1 = psd.listarPasajeros();
//        System.out.println("-----------------------------------------------");
//        System.out.println("Los pasajeros son: ");
//        
//        for(int i = 0 ; i < lista1.size();i++){
//            System.out.println(lista1.get(i));
//        }
//      
//     //ModificarPasajero
//     p1.setDni("5124124");
//     p2.setDni("2151");
//     p3.setDni("5142");
//     p4.setDni("6431");
//      
//     psd.modificarPasajero(p1);
//     psd.modificarPasajero(p2);
//     psd.modificarPasajero(p3);
//     psd.modificarPasajero(p4);
//   
//     
//     //EliminarPasajero
//     psd.eliminarPasajero(45);
//     
//     //BuscarPasajeroPorDNI
//     
//        System.out.println("Pasajero buscado por DNI");
//              Pasajero Ale = new Pasajero("Ale", "Ashendes", "5123", "dqwqwd@dwd.com", "2141");
//              psd.guardarPasajero(Ale);
//              Ale = psd.buscarPasajeroPorDni("5123");
//              
//              System.out.println(Ale);
              
                          /*
---------------------------- Pruebas de RutaData ------------------------------------------------
//         */
//    
//    RutaData rd1 = new RutaData();
//    
//    Duration duracion1 = Duration.ofHours(2).plusMinutes(30).plusSeconds(15);
//    Duration duracion2= Duration.ofHours(0).plusMinutes(40).plusSeconds(15);
//    Duration duracion3 = Duration.ofHours(3).plusMinutes(30).plusSeconds(15);
//    
//    Ruta r1 = new Ruta("San Luis", "Villa Mercedes", duracion1);
//    Ruta r2 = new Ruta("San Luis", "La Punta", duracion2);
//    Ruta r3 = new Ruta("San Luis", "Merlo", duracion3);
//  
//    
//                  //Guardar ruta
//    rd1.guardarRuta(r1);
//    rd1.guardarRuta(r2);
//    rd1.guardarRuta(r3);
//

//                  //BuscarRuta
//        
//        r1.setIdRuta(21);
//        r2.setIdRuta(22);
//        r3.setIdRuta(23);
//        
//        Ruta rds1 = rd1.buscarRuta(r1.getIdRuta());
//        Ruta rds2 = rd1.buscarRuta(r2.getIdRuta());
//        Ruta rds3 = rd1.buscarRuta(r3.getIdRuta());
//      
//
//        if (rds1 != null || rds2 != null|| rds3 != null) {
//            System.out.println(rds1);
//            System.out.println(rds2);
//            System.out.println(rds3);
//           
//        }
//        
//              //ListarRuta
//      List<Ruta> listaRuta = rd1.listarRutas("San Luis", "Merlo");
//        System.out.println("-----------------------------------------------");
//        System.out.println("Las rutas son: ");
//        
//        for(int i = 0 ; i < listaRuta.size();i++){
//            System.out.println(listaRuta.get(i));
//        }
//        
//          List<Ruta> listaRuta1 = rd1.listarRutasxDestino( "La Punta");
//        System.out.println("-----------------------------------------------");
//        System.out.println("Las rutas son: ");
//        
//        for(int i = 0 ; i < listaRuta1.size();i++){
//            System.out.println(listaRuta1.get(i));
//        }
//        
//          List<Ruta> listaRuta2 = rd1.listarRutasxDuracion(duracion1);
//        System.out.println("-----------------------------------------------");
//        System.out.println("Las rutas son: ");
//        
//        for(int i = 0 ; i < listaRuta2.size();i++){
//            System.out.println(listaRuta2.get(i));
//        }
//        
//        
//             
//              //ModificarRuta
//  r1.setDestino("El Potrero");
//  r2.setDestino("Juana Koslay");
//  r3.setDestino("La Florida");
//      
//     rd1.modificarRuta(r1);
//     rd1.modificarRuta(r2);
//     rd1.modificarRuta(r3);
//
//             //EliminarRuta
//        rd1.borrarRuta(r2);
//            

    }


   
    
}
