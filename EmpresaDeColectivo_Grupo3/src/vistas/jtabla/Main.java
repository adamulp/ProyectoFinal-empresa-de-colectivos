package vistas.jtabla;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main extends JFrame {
    private JTablaCompuesta tabla;
    private ModeloTablaCompuesta modelo;

    public Main() {
        // Crear el modelo de la tabla
        modelo = new ModeloTablaCompuesta();

        // Secciones y datos de ejemplo
        SeccionTabla datosPersonales = new SeccionTabla("Datos Pasajero", "Pasajeros");
        datosPersonales.agregarColumna(new FormularioData("ID", "txt", true));
        datosPersonales.agregarColumna(new FormularioData("Nombre", "txt", true));
        datosPersonales.agregarColumna(new FormularioData("Apellido", "txt", true));
        datosPersonales.agregarFila(1, new Object[]{1001, "Juan", "Pérez"});
        datosPersonales.agregarFila(2, new Object[]{1002, "María", "Gómez"});

        SeccionTabla orgRol = new SeccionTabla("Pasajes Disponibles", "Pasajes");
        orgRol.agregarColumna(new FormularioData("Fecha del Viaje",
                Arrays.asList("2024-6-17", "2024-6-18", "2024-6-19")));
        orgRol.agregarColumna(new FormularioData("Horario", Arrays.asList("09:00hs", "11:15hs", "13:30hs")));
        orgRol.agregarFila(1, new Object[]{"2024-6-17", "09:00hs"});
        orgRol.agregarFila(2, new Object[]{"2024-6-18", "11:15hs"});

        modelo.agregarSeccion(datosPersonales);
        modelo.agregarSeccion(orgRol);

        // Crear la tabla personalizada
        tabla = new JTablaCompuesta(modelo);

        // Crear los campos de texto y combo boxes
        JPanel panelCamposTexto = new JPanel(new GridLayout(0, 2));

        // Sección 1
        Object[] camposPersonales = new Object[datosPersonales.getNombresColumnas().size()];
        tabla.agregarCamposSeccion(panelCamposTexto, datosPersonales, camposPersonales);

        // Sección 2
        Object[] camposOrgRol = new Object[orgRol.getNombresColumnas().size()];
        tabla.agregarCamposSeccion(panelCamposTexto, orgRol, camposOrgRol);

        // Configurar el marco principal
        setLayout(new BorderLayout());
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelCamposTexto, BorderLayout.SOUTH);

        setTitle("Ejemplo de Tabla Personalizada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
