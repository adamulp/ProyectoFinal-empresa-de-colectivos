package vistas.jtabla;

import javax.swing.*;

public class ComboEditable {
    
    private String[] valoresIniciales;

    public ComboEditable() {
    }

    public ComboEditable(String[] valoresIniciales) {
        this.valoresIniciales = valoresIniciales;
        JComboBox<String> comboBox = new JComboBox<>(valoresIniciales);
        comboBox.setEditable(true);

            comboBox.addActionListener(e -> {
                String newItem = (String) comboBox.getSelectedItem();
                if (newItem != null && !newItem.trim().isEmpty() && comboBox.getItemCount() == 0) {
                    comboBox.addItem(newItem);
                }
            });
    }
}
