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
        
        SeccionTabla datosPasajes = new SeccionTabla("Datos Pasajes", "Pasajes");
//        datosPasajes.agregarColumna(new FormularioData("ID_Pasaje", txtIdPasaje, false));
//        datosPasajes.agregarColumna(new FormularioData("ID_Pasajero", txtIdPasajero, false));
//        datosPasajes.agregarColumna(new FormularioData("ID_Colectivo", txtIdColectivo, false));
//        datosPasajes.agregarColumna(new FormularioData("ID_Ruta", txtIdRuta, false));
        datosPasajes.agregarColumna("Fecha Viaje", jdFechaViaje, false);
        datosPasajes.agregarColumna("Hora Viaje", comboHoraViaje, false);
        datosPasajes.agregarColumna("Asiento", txtAsiento, false);
        datosPasajes.agregarColumna("Precio", txtPrecio, false);
        
        
        // -------------------------Pasajeros-------------------------------------
        SeccionTabla datosPasajero = new SeccionTabla("Datos Pasajeros", "Pasajeros");
//        datosPasajero.agregarColumna("ID_Pasajero", txtIdPasajero, false);
        datosPasajero.agregarColumna("Nombre", txtNombre, false);
        datosPasajero.agregarColumna("Apellido", txtApellido, false);
        datosPasajero.agregarColumna("DNI", txtDni, false);
        datosPasajero.agregarColumna("Correo", txtCorreo, false);
        datosPasajero.agregarColumna("Telefono", txtTelefono, false);
//        datosPasajero.agregarColumna("Estado", checkBoxPasajeroActivo, false);
        
        // -------------------------Colectivos-------------------------------------
        SeccionTabla datosColectivo = new SeccionTabla("Datos Colectivos", "Colectivos");
//        datosColectivo.agregarColumna("ID_Colectivo", txtIdColectivo, false);
        datosColectivo.agregarColumna("Matricula", txtMatricula, false);
        datosColectivo.agregarColumna("Marca", txtMarca, false);
        datosColectivo.agregarColumna("Modelo", txtModelo, false);
        datosColectivo.agregarColumna("Capacidad", txtCapacidad, false);
//        datosColectivo.agregarColumna("Estado", checkBoxColectivoActivo, false);

        // -------------------------Rutas-------------------------------------
        SeccionTabla datosRuta = new SeccionTabla("Datos Ruta", "Rutas");
//        datosRuta.agregarColumna("ID_Ruta", txtIdRuta, false);
        datosRuta.agregarColumna("Origen", comboOrigen, false);
        datosRuta.agregarColumna("Destino", comboDestino, false);
        datosRuta.agregarColumna("Duración Estimada", txtDuracionEstimada, false);
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
            datosPasajes.agregarFila(idPasaje, new Object[]{fechaViaje, horaViaje, asiento, precio});
            
            
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
            
            Ruta ruta = pasaje.getRuta();
            int idRuta = ruta.getIdRuta();
            datosRuta.agregarFila(idRuta, new Object[]{
                ruta.getOrigen(),
                ruta.getDestino(),
                ruta.getDuracionEstimada()
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
        List<String> origenes = rutaData.listarOrigenesUnicos(seleccionRutasActivas);
        List<String> destinos = rutaData.listarDestinosUnicos(seleccionRutasActivas);

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
        List<LocalTime> horariosDeSalida = horarioData.listarHorariosDeSalida(seleccionHorariosActivos);
        List<LocalTime> horariosDeLlegada = horarioData.listarHorariosDeLlegada(seleccionHorariosActivos);

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
        panelCamposTexto2 = new javax.swing.JPanel();
        comboFecha = new javax.swing.JComboBox<>();
        comboHorario = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdFechaViaje = new com.toedter.calendar.JDateChooser();
        comboHoraViaje = new javax.swing.JComboBox<>();
        txtAsiento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblDatosPasaje = new javax.swing.JLabel();
        panelHorarios = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        comboHoraLlegada = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        checkboxHorariosActivos = new javax.swing.JCheckBox();
        txtIdHorario = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        comboHoraSalida = new javax.swing.JComboBox<>();
        lblHorarios = new javax.swing.JLabel();
        panelCamposTexto3 = new javax.swing.JPanel();
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
        panelRutas = new javax.swing.JPanel();
        lblOrigenes = new javax.swing.JLabel();
        comboOrigen = new javax.swing.JComboBox<>();
        lblDestinos = new javax.swing.JLabel();
        comboDestino = new javax.swing.JComboBox<>();
        lblDuracionEstimada = new javax.swing.JLabel();
        txtDuracionEstimada = new javax.swing.JTextField();
        checkBoxRutasActivas = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();

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

        panelCamposTexto2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jLabel2.setText("comboFecha");

        jLabel3.setText("comboHorario");

        jLabel1.setText("Asiento");

        jLabel4.setText("Precio");

        lblDatosPasaje.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        lblDatosPasaje.setText("Datos Pasaje");

        javax.swing.GroupLayout panelCamposTexto2Layout = new javax.swing.GroupLayout(panelCamposTexto2);
        panelCamposTexto2.setLayout(panelCamposTexto2Layout);
        panelCamposTexto2Layout.setHorizontalGroup(
            panelCamposTexto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposTexto2Layout.createSequentialGroup()
                .addGroup(panelCamposTexto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposTexto2Layout.createSequentialGroup()
                        .addGroup(panelCamposTexto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelCamposTexto2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel2)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel3)
                                .addGap(13, 13, 13))
                            .addGroup(panelCamposTexto2Layout.createSequentialGroup()
                                .addGroup(panelCamposTexto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCamposTexto2Layout.createSequentialGroup()
                                        .addComponent(comboFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposTexto2Layout.createSequentialGroup()
                                        .addComponent(jdFechaViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)))
                                .addGroup(panelCamposTexto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboHorario, 0, 112, Short.MAX_VALUE)
                                    .addComponent(comboHoraViaje, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(panelCamposTexto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCamposTexto2Layout.createSequentialGroup()
                                .addComponent(txtAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCamposTexto2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel4))))
                    .addGroup(panelCamposTexto2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDatosPasaje)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelCamposTexto2Layout.setVerticalGroup(
            panelCamposTexto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposTexto2Layout.createSequentialGroup()
                .addComponent(lblDatosPasaje)
                .addGap(27, 27, 27)
                .addGroup(panelCamposTexto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposTexto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addGroup(panelCamposTexto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdFechaViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCamposTexto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboHoraViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jLabel30.setText("idHorario");

        checkboxHorariosActivos.setText("Horarios Activos");
        checkboxHorariosActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxHorariosActivosActionPerformed(evt);
            }
        });

        txtIdHorario.setEnabled(false);

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
                .addGap(19, 19, 19)
                .addGroup(panelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHorariosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtIdHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkboxHorariosActivos))
                    .addGroup(panelHorariosLayout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelHorariosLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(lblHorarios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtIdHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxHorariosActivos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCamposTexto3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        lblNombres.setText("Nombres:");

        lblApellidos.setText("Apellidos:");

        lblDni.setText("DNI:");

        lblCorreo.setText("Correo");

        jLabel5.setText("Telefono");

        lblDatosPasajero.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        lblDatosPasajero.setText("Datos Pasajero");

        javax.swing.GroupLayout panelCamposTexto3Layout = new javax.swing.GroupLayout(panelCamposTexto3);
        panelCamposTexto3.setLayout(panelCamposTexto3Layout);
        panelCamposTexto3Layout.setHorizontalGroup(
            panelCamposTexto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposTexto3Layout.createSequentialGroup()
                .addGroup(panelCamposTexto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposTexto3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNombres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblApellidos))
                    .addGroup(panelCamposTexto3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelCamposTexto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposTexto3Layout.createSequentialGroup()
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                    .addGroup(panelCamposTexto3Layout.createSequentialGroup()
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelCamposTexto3Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(lblCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(229, 229, 229))
            .addGroup(panelCamposTexto3Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(lblDatosPasajero)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCamposTexto3Layout.setVerticalGroup(
            panelCamposTexto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposTexto3Layout.createSequentialGroup()
                .addComponent(lblDatosPasajero)
                .addGap(17, 17, 17)
                .addGroup(panelCamposTexto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCamposTexto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposTexto3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

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
                                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelColectivoLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(lblMatricula)
                                .addGap(41, 41, 41)
                                .addComponent(lblCapacidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(checkboxColectivosActivos)
                                .addGap(18, 18, 18)
                                .addComponent(lblColectivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelColectivoLayout.createSequentialGroup()
                        .addComponent(lblDatosColectivo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(lblCapacidad)
                    .addComponent(lblColectivo)
                    .addComponent(comboColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxColectivosActivos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

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
                        .addGroup(panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRutasLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(lblOrigenes)
                                .addGap(71, 71, 71)))
                        .addGroup(panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRutasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDestinos)
                                .addGap(76, 76, 76))
                            .addGroup(panelRutasLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelRutasLayout.createSequentialGroup()
                        .addComponent(checkBoxRutasActivas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDuracionEstimada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDuracionEstimada, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelRutasLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelRutasLayout.setVerticalGroup(
            panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRutasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRutasLayout.createSequentialGroup()
                        .addComponent(lblDestinos)
                        .addGap(31, 31, 31))
                    .addGroup(panelRutasLayout.createSequentialGroup()
                        .addComponent(lblOrigenes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panelRutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuracionEstimada)
                    .addComponent(txtDuracionEstimada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxRutasActivas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelCamposTexto1Layout = new javax.swing.GroupLayout(panelCamposTexto1);
        panelCamposTexto1.setLayout(panelCamposTexto1Layout);
        panelCamposTexto1Layout.setHorizontalGroup(
            panelCamposTexto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposTexto1Layout.createSequentialGroup()
                .addGroup(panelCamposTexto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposTexto1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposTexto1Layout.createSequentialGroup()
                        .addGroup(panelCamposTexto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCamposTexto1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(panelCamposTexto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(panelRutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 42, Short.MAX_VALUE)
                                .addComponent(panelHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCamposTexto1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(panelCamposTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)))
                .addContainerGap())
        );
        panelCamposTexto1Layout.setVerticalGroup(
            panelCamposTexto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposTexto1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCamposTexto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposTexto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(panelRutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelCamposTexto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCamposTexto1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(panelHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(panelCamposTexto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCamposTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCamposTexto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCamposTexto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JComboBox<String> comboFecha;
    private javax.swing.JComboBox<String> comboHoraLlegada;
    private javax.swing.JComboBox<String> comboHoraSalida;
    private javax.swing.JComboBox<String> comboHoraViaje;
    private javax.swing.JComboBox<String> comboHorario;
    private javax.swing.JComboBox<String> comboOrigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JPanel panelCamposTexto2;
    private javax.swing.JPanel panelCamposTexto3;
    private javax.swing.JPanel panelColectivo;
    private javax.swing.JPanel panelHorarios;
    private javax.swing.JPanel panelRutas;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtAsiento;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDuracionEstimada;
    private javax.swing.JTextField txtIdHorario;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
