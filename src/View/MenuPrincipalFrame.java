/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 * @author Sebastian
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalFrame extends JFrame{

    public MenuPrincipalFrame() {
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridLayout(2, 2)); // Dividir en 2 filas y 2 columnas

        // Crear los botones para las opciones
        JButton btnAdministrarInventario = new JButton("Ver existencias");
        btnAdministrarInventario.setSize(250,250);
        JButton btnIngresos = new JButton("Añadir productos");
        btnIngresos.setSize(250,250);
        // Agregar los botones a los paneles
        JPanel panelAdministrarInventario = new JPanel();
        panelAdministrarInventario.add(btnAdministrarInventario);
        add(panelAdministrarInventario);

        JPanel panelExistencias = new JPanel();
        panelExistencias.add(btnIngresos);
        add(panelExistencias);


        // Agregar acciones a los botones
        btnAdministrarInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción para "Administrar Inventario"
                JOptionPane.showMessageDialog(MenuPrincipalFrame.this, "Has seleccionado ver existencias");
                existencias existencias = new existencias();
                existencias.mostrar();
            }
        });


        btnIngresos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción para "Pedidos"
                JOptionPane.showMessageDialog(MenuPrincipalFrame.this, "Has seleccionado ingresar un producto");
                AdminvFrame gestion = new AdminvFrame();
                gestion.mostrar();
            }
        });
    }
    void mostrar() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }
}

