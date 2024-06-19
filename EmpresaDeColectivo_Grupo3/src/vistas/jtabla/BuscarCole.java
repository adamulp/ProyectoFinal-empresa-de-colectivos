package vistas.jtabla;

import EmpresaDeColectivo.Entidades.Colectivo;
import EmpresaDeColectivo.Entidades.Pasaje;
import EmpresaDeColectivo.Entidades.Pasajero;
import EmpresaDeColectivo.Entidades.Ruta;
import accesoADatos.ColectivoData;
import accesoADatos.HorarioData;
import accesoADatos.PasajeData;
import accesoADatos.PasajeroData;
import accesoADatos.RutaData;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author adam
 */
public class BuscarCole extends javax.swing.JFrame {
    private JTablaCompuesta tabla;
    private ModeloTablaCompuesta modelo;
    /**
     * Creates new form BuscarCole
     */
    public BuscarCole() {
        initComponents();
        vincularTablaConFormulario();
    }
    
    private void vincularTablaConFormulario() {
        modelo = new ModeloTablaCompuesta();
        
// ################################################################################################
// ----------------- Vincular los campos del formulario con el modelo de la jtabla ----------------
// ################################################################################################

        // -------------------------Pasajes-------------------------------------
        PasajeData pasajeData = new PasajeData();
        List<Pasaje> pasajes = pasajeData.listarPasajes();
        
        SeccionTabla datosPasajes = new SeccionTabla(
                
                    "Datos Pasajes",
                      "Pasajes"
                
        );
        datosPasajes.agregarColumna(
                
            "Fecha Viaje",
                jdFechaViaje,
              true
                
        );
        
        datosPasajes.agregarColumna(
                
           "Hora Viaje", 
               comboHoraViaje, 
             true
                
        );
        
        datosPasajes.agregarColumna(
            "Asiento", 
                txtAsiento, 
              true
        );
        
        datosPasajes.agregarColumna(
                
            "Precio", 
                txtPrecio, 
              false
                
        );
        
        
        // -------------------------Pasajeros-------------------------------------
        SeccionTabla datosPasajero = new SeccionTabla(
                
                  "Datos Pasajeros",
                    "Pasajeros"
                
        );
        
        datosPasajero.agregarColumna(
                
            "Nombre",
                txtNombre, 
              false
        );
        
        datosPasajero.agregarColumna(
                
                "Apellido", 
                txtApellido, 
                false
                
        );
        
        datosPasajero.agregarColumna(
                
            "DNI",
                txtDni, 
              false
        );
        
        datosPasajero.agregarColumna(
                
                "Correo", 
                txtCorreo, 
                true
        );
        
        datosPasajero.agregarColumna(
                
           "Telefono", 
                txtTelefono, 
              true
        );
        
//        datosPasajero.agregarColumna("Estado", checkBoxPasajeroActivo, false);
        
        // -------------------------Colectivos-------------------------------------
        SeccionTabla datosColectivo = new SeccionTabla(
              "Datos Colectivos", 
                "Colectivos"
        );
        
//        datosColectivo.agregarColumna("ID_Colectivo", txtIdColectivo, false);
        datosColectivo.agregarColumna(
                
            "Matricula", 
                txtMatricula, 
              false
                
        );
        
        datosColectivo.agregarColumna(
                
            "Marca", 
                txtMarca, 
              false
                
        );
        datosColectivo.agregarColumna(
                
            "Modelo", 
                txtModelo, 
                false
        );
        datosColectivo.agregarColumna(
                
            "Capacidad", 
                txtCapacidad, 
              true
                
        );
//        datosColectivo.agregarColumna("Estado", checkBoxColectivoActivo, false);

        // -------------------------Rutas-------------------------------------
        SeccionTabla datosRuta = new SeccionTabla(
                
                "Datos Ruta",
                "Rutas"
                
        );
//        datosRuta.agregarColumna("ID_Ruta", txtIdRuta, false);
        datosRuta.agregarColumna(
                
        "Origen", 
            comboOrigen, 
          true
                
        );
        
        datosRuta.agregarColumna(
                
            "Destino", 
                comboDestino, 
              true
                
        );
        datosRuta.agregarColumna(
                
            "Duración Estimada", 
                txtDuracionEstimada, 
              false
        );
//        datosRuta.agregarColumna("Ruta Activa", checkBoxRutaActiva, false);
        

// ################################################################################################
// ----------------- Llenar la jtabla con datos de la base de datos  ------------------------------
// ################################################################################################

        for(Pasaje pasaje: pasajes){
            int idPasaje = pasaje.getIdPasaje();
            LocalDate fechaViaje = pasaje.getFechaViaje();
            LocalTime horaViaje = pasaje.getHoraViaje();
            int asiento = pasaje.getAsiento();
            double precio = pasaje.getPrecio();
            
            datosPasajes.agregarFila(idPasaje, new Object[]{
                fechaViaje, 
                horaViaje, 
                asiento, 
                precio
            });
            
            
            Pasajero pasajero = pasaje.getPasajero();
            int idPasajero = pasajero.getIdPasajero();
            datosPasajero.agregarFila(idPasajero, new Object[]{
                pasajero.getNombre(),
                pasajero.getApellido(),
                pasajero.getDni(),
                pasajero.getCorreo(),
                pasajero.getTelefono()
            });
            
            Colectivo colectivo = pasaje.getColectivo();
            int idColectivo = colectivo.getIdColectivo();
            datosColectivo.agregarFila(idColectivo, new Object[]{
                colectivo.getMatricula(),
                colectivo.getMarca(),
                colectivo.getModelo(),
                colectivo.getCapacidad()
            });
            System.out.println("Prueba de rutas");
            Ruta ruta = pasaje.getRuta();
            int idRuta = ruta.getIdRuta();
            datosRuta.agregarFila(idRuta, new Object[]{
                ruta.getOrigen(),
                ruta.getDestino(),
                strDuracion(ruta.getDuracionEstimada())
            });
        }
        modelo.agregarSeccion(datosPasajes);
        modelo.agregarSeccion(datosPasajero);
        modelo.agregarSeccion(datosColectivo);
        modelo.agregarSeccion(datosRuta);
                
        tabla = new JTablaCompuesta(modelo);
        jScrollPane1.setViewportView(tabla);

        // llenarCombos();
    }
    
    private String strDuracion(Duration duration){
        // Datos Rutas.duracion
        long duracionSegundos = duration.getSeconds();
        long horas = duracionSegundos / 3600;
        long minutos = (duracionSegundos % 3600) / 60;
        String duracionHora = String.format("%02d", horas);
        String duracionMin = String.format("%02d", minutos);
        return duracionHora + ":" + duracionMin;
    }
    
    private String strDuracion(Ruta ruta){
        return BuscarCole.this.strDuracion(ruta.getDuracionEstimada());
    }
    private void llenarCombos() {
        // Llenar combo de colectivos
        ColectivoData colectivoData = new ColectivoData();
        List<Colectivo> colectivos = colectivoData.listarColectivos();
        if (colectivos != null) {
            for (Colectivo colectivo : colectivos) {
                comboColectivos.addItem(colectivo.toString());
            }
        }

        // Llenar combo de Rutas
        boolean seleccionRutasActivas = checkboxColectivosActivos.isSelected();
        RutaData rutaData = new RutaData();
        
        List<String> origenes = rutaData.listarOrigenesUnicos(
                seleccionRutasActivas
        );
        
        List<String> destinos = rutaData.listarDestinosUnicos(
                seleccionRutasActivas
        );

        if (origenes != null) {
            for (String origen : origenes) {
                comboOrigen.addItem(origen);
            }
        }

        if (destinos != null) {
            for (String destino : destinos) {
                comboDestino.addItem(destino);
            }
        }

        // Llenar combo de horarios
        HorarioData horarioData = new HorarioData();
        boolean seleccionHorariosActivos = checkboxHorariosActivos.isSelected();
        
        List<LocalTime> horariosDeSalida = horarioData.listarHorariosDeSalida(
                seleccionHorariosActivos
        );
        
        List<LocalTime> horariosDeLlegada = horarioData.listarHorariosDeLlegada(
                seleccionHorariosActivos
        );

        if (horariosDeSalida != null) {
            for (LocalTime horario : horariosDeSalida) {
                comboHoraSalida.addItem(horario.toString());
            }
        }

        if (horariosDeLlegada != null) {
            for (LocalTime horario : horariosDeLlegada) {
                comboHoraLlegada.addItem(horario.toString());
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCamposTexto1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tabPanePasajes = new javax.swing.JTabbedPane();
        panelPasajero = new javax.swing.JPanel();
        lblNombres = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblDni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblDatosPasajero = new javax.swing.JLabel();
        panelRutas = new javax.swing.JPanel();
        lblOrigenes = new javax.swing.JLabel();
        comboOrigen = new javax.swing.JComboBox<>();
        lblDestinos = new javax.swing.JLabel();
        comboDestino = new javax.swing.JComboBox<>();
        lblDuracionEstimada = new javax.swing.JLabel();
        txtDuracionEstimada = new javax.swing.JTextField();
        checkBoxRutasActivas = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        panelHorarios = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        comboHoraLlegada = new javax.swing.JComboBox<>();
        checkboxHorariosActivos = new javax.swing.JCheckBox();
        jPanel21 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        comboHoraSalida = new javax.swing.JComboBox<>();
        lblHorarios = new javax.swing.JLabel();
        panelColectivo = new javax.swing.JPanel();
        lblMatricula = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblCapacidad = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        txtCapacidad = new javax.swing.JTextField();
        checkboxColectivosActivos = new javax.swing.JCheckBox();
        lblColectivo = new javax.swing.JLabel();
        comboColectivos = new javax.swing.JComboBox<>();
        lblDatosColectivo = new javax.swing.JLabel();
        panelPasaje = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdFechaViaje = new com.toedter.calendar.JDateChooser();
        comboHoraViaje = new javax.swing.JComboBox<>();
        txtAsiento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblDatosPasaje = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        panelPasajero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        lblNombres.setText("Nombres:");

        txtNombre.setForeground(javax.swing.UIManager.getDefaults().getColor("TitlePane.embeddedForeground"));

        lblApellidos.setText("Apellidos:");

        lblDni.setText("DNI:");

        lblCorreo.setText("Correo");

        jLabel5.setText("Telefono");

        lblDatosPasajero.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        lblDatosPasajero.setText("Datos Pasajero");

        javax.swing.GroupLayout panelPasajeroLayout = new javax.swing.GroupLayout(panelPasajero);
        panelPasajero.setLayout(panelPasajeroLayout);
        panelPasajeroLayout.setHorizontalGroup(
            panelPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPasajeroLayout.createSequentialGroup()
                .addGroup(panelPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPasajeroLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(lblDatosPasajero))
                    .addGroup(panelPasajeroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNombres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPasajeroLayout.createSequentialGroup()
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPasajeroLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(lblCorreo)
                                .addGap(233, 233, 233)
                                .addComponent(jLabel5))
                            .addGroup(panelPasajeroLayout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblApellidos)
                                .addGap(18, 18, 18)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        panelPasajeroLayout.setVerticalGroup(
            panelPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPasajeroLayout.createSequentialGroup()
                .addComponent(lblDatosPasajero)
                .addGap(17, 17, 17)
                .addGroup(panelPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panelPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPasajeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        tabPanePasajes.addTab("Pasajero", panelPasajero);

        panelRutas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        lblOrigenes.setText("Origines");

        lblDestinos.setText("Destinos");

        lblDuracionEstimada.setText("Duración Estimada");

        checkBoxRutasActivas.setText("RutasActivas");
        checkBoxRutasActivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxRutasActivasActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel6.setText("Rutas");

        javax.swing.GroupLayout panelRutasLayout = new javax.swing.GroupLayout(panelRutas);
        panelRutas.setLayout(panelRutasLayout);
        panelRutasLayout.setHorizontalGroup(
            panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRutasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRutasLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRutasLayout.createSequentialGroup()
                        .addGroup(panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRutasLayout.createSequentialGroup()
                                .addGroup(panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelRutasLayout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(lblOrigenes)))
                                .addGroup(panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelRutasLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                        .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelRutasLayout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(lblDestinos)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(panelRutasLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(checkBoxRutasActivas)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelRutasLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(lblDuracionEstimada)
                .addGap(18, 18, 18)
                .addComponent(txtDuracionEstimada, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 438, Short.MAX_VALUE))
        );
        panelRutasLayout.setVerticalGroup(
            panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRutasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrigenes)
                    .addComponent(lblDestinos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuracionEstimada)
                    .addComponent(txtDuracionEstimada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(checkBoxRutasActivas)
                .addGap(27, 27, 27))
        );

        tabPanePasajes.addTab("Rutas", panelRutas);

        panelHorarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel31.setText("Hora llegada");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel31)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboHoraLlegada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        checkboxHorariosActivos.setText("Horarios Activos");
        checkboxHorariosActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxHorariosActivosActionPerformed(evt);
            }
        });

        jLabel28.setText("Hora salida");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel28)
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboHoraSalida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        lblHorarios.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        lblHorarios.setText("Horarios");

        javax.swing.GroupLayout panelHorariosLayout = new javax.swing.GroupLayout(panelHorarios);
        panelHorarios.setLayout(panelHorariosLayout);
        panelHorariosLayout.setHorizontalGroup(
            panelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHorariosLayout.createSequentialGroup()
                .addGroup(panelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHorariosLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(lblHorarios))
                    .addGroup(panelHorariosLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelHorariosLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(checkboxHorariosActivos)))
                .addContainerGap(475, Short.MAX_VALUE))
        );
        panelHorariosLayout.setVerticalGroup(
            panelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHorariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHorarios)
                .addGap(8, 8, 8)
                .addGroup(panelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(checkboxHorariosActivos)
                .addGap(28, 28, 28))
        );

        tabPanePasajes.addTab("Horarios", panelHorarios);

        panelColectivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        lblMatricula.setText("Matricula");

        lblMarca.setText("Marca");

        lblModelo.setText("Modelo");

        lblCapacidad.setText("Capacidad");

        checkboxColectivosActivos.setText("Colectivos Activos");
        checkboxColectivosActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxColectivosActivosActionPerformed(evt);
            }
        });

        lblColectivo.setText("Colectivo");

        lblDatosColectivo.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        lblDatosColectivo.setText("Datos Colectivo");

        javax.swing.GroupLayout panelColectivoLayout = new javax.swing.GroupLayout(panelColectivo);
        panelColectivo.setLayout(panelColectivoLayout);
        panelColectivoLayout.setHorizontalGroup(
            panelColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColectivoLayout.createSequentialGroup()
                .addGroup(panelColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelColectivoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelColectivoLayout.createSequentialGroup()
                                .addGroup(panelColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMarca)
                                    .addComponent(lblModelo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(txtModelo))
                                .addGroup(panelColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelColectivoLayout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelColectivoLayout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(lblMatricula)
                                        .addGap(41, 41, 41)
                                        .addComponent(lblCapacidad))))
                            .addComponent(lblDatosColectivo)))
                    .addGroup(panelColectivoLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panelColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelColectivoLayout.createSequentialGroup()
                                .addComponent(lblColectivo)
                                .addGap(18, 18, 18)
                                .addComponent(comboColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(checkboxColectivosActivos))))
                .addContainerGap(385, Short.MAX_VALUE))
        );
        panelColectivoLayout.setVerticalGroup(
            panelColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColectivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDatosColectivo)
                .addGap(21, 21, 21)
                .addGroup(panelColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarca)
                    .addComponent(lblMatricula)
                    .addComponent(lblCapacidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(panelColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColectivo)
                    .addComponent(comboColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(checkboxColectivosActivos)
                .addGap(24, 24, 24))
        );

        tabPanePasajes.addTab("Colectivo", panelColectivo);

        panelPasaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel2.setText("Fecha");

        jLabel3.setText("Horario");

        jLabel1.setText("Asiento");

        jLabel4.setText("Precio");

        lblDatosPasaje.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        lblDatosPasaje.setText("Datos Pasaje");

        javax.swing.GroupLayout panelPasajeLayout = new javax.swing.GroupLayout(panelPasaje);
        panelPasaje.setLayout(panelPasajeLayout);
        panelPasajeLayout.setHorizontalGroup(
            panelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPasajeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPasajeLayout.createSequentialGroup()
                            .addComponent(txtAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelPasajeLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(39, 39, 39)
                            .addComponent(jLabel4)))
                    .addGroup(panelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPasajeLayout.createSequentialGroup()
                            .addComponent(jdFechaViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(comboHoraViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelPasajeLayout.createSequentialGroup()
                            .addGroup(panelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(lblDatosPasaje))
                            .addGap(153, 153, 153)
                            .addComponent(jLabel3))))
                .addContainerGap(504, Short.MAX_VALUE))
        );
        panelPasajeLayout.setVerticalGroup(
            panelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPasajeLayout.createSequentialGroup()
                .addComponent(lblDatosPasaje)
                .addGap(27, 27, 27)
                .addGroup(panelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdFechaViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboHoraViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(panelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(8, 8, 8)
                .addGroup(panelPasajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        tabPanePasajes.addTab("Pasaje", panelPasaje);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setText("Pasajes");

        javax.swing.GroupLayout panelCamposTexto1Layout = new javax.swing.GroupLayout(panelCamposTexto1);
        panelCamposTexto1.setLayout(panelCamposTexto1Layout);
        panelCamposTexto1Layout.setHorizontalGroup(
            panelCamposTexto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposTexto1Layout.createSequentialGroup()
                .addGroup(panelCamposTexto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposTexto1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(panelCamposTexto1Layout.createSequentialGroup()
                        .addGap(622, 622, 622)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelCamposTexto1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(tabPanePasajes, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(723, Short.MAX_VALUE))
        );
        panelCamposTexto1Layout.setVerticalGroup(
            panelCamposTexto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposTexto1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPanePasajes, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCamposTexto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelCamposTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkboxHorariosActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxHorariosActivosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxHorariosActivosActionPerformed

    private void checkboxColectivosActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxColectivosActivosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxColectivosActivosActionPerformed

    private void checkBoxRutasActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxRutasActivasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxRutasActivasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarCole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarCole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarCole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarCole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarCole().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBoxRutasActivas;
    private javax.swing.JCheckBox checkboxColectivosActivos;
    private javax.swing.JCheckBox checkboxHorariosActivos;
    private javax.swing.JComboBox<String> comboColectivos;
    private javax.swing.JComboBox<String> comboDestino;
    private javax.swing.JComboBox<String> comboHoraLlegada;
    private javax.swing.JComboBox<String> comboHoraSalida;
    private javax.swing.JComboBox<String> comboHoraViaje;
    private javax.swing.JComboBox<String> comboOrigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdFechaViaje;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCapacidad;
    private javax.swing.JLabel lblColectivo;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDatosColectivo;
    private javax.swing.JLabel lblDatosPasaje;
    private javax.swing.JLabel lblDatosPasajero;
    private javax.swing.JLabel lblDestinos;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblDuracionEstimada;
    private javax.swing.JLabel lblHorarios;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblOrigenes;
    private javax.swing.JPanel panelCamposTexto1;
    private javax.swing.JPanel panelColectivo;
    private javax.swing.JPanel panelHorarios;
    private javax.swing.JPanel panelPasaje;
    private javax.swing.JPanel panelPasajero;
    private javax.swing.JPanel panelRutas;
    private javax.swing.JTabbedPane tabPanePasajes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtAsiento;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDuracionEstimada;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
