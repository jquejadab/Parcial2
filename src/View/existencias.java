/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class existencias extends JFrame implements Vistas {
    public existencias() {
        setTitle("Existencias");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        
        JPanel verInventarioPanel = new JPanel();
        verInventarioPanel.setLayout(new BorderLayout());

        // Simulación de una tabla de inventario con categorías
        String[] columnNames = {"Categoría", "Producto", "Cantidad"};
        Object[][] data = {
            {"Carnes", "Carne de res", 50},
            {"Carnes", "Pollo", 30},
            {"Vegetales", "Tomates", 100},
            {"Vegetales", "Lechuga", 80},
            {"Bebidas", "Agua mineral", 200},
            {"Bebidas", "Refresco de cola", 150},
            {"Frutas", "Manzanas", 70},
            {"Frutas", "Plátanos", 90},
            {"Especias y Condimentos", "Sal", 500},
            {"Especias y Condimentos", "Pimienta", 200},
            {"Procesados", "Cereal", 40},
            {"Procesados", "Galletas", 60},
            {"Granos", "Arroz", 120},
            {"Granos", "Frijoles", 80},
            {"Lácteos", "Leche", 150},
            {"Lácteos", "Queso", 40},
            {"Grasas/Aceites", "Aceite de oliva", 30},
            {"Grasas/Aceites", "Mantequilla", 20}
        };

        JTable inventarioTable = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane tableScrollPane = new JScrollPane(inventarioTable);

        verInventarioPanel.add(tableScrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Ver Inventario", verInventarioPanel);

    
       

       
        add(tabbedPane);
    }

    @Override
    public void mostrar() {
       SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
    });
    }

}
    