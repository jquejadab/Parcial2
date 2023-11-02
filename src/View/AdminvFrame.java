package View;

/**
 *
 * @author Sebastian
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import model.ProductosEnSQL;
import modelView.Producto;

public class AdminvFrame extends JFrame implements Vistas{

    public AdminvFrame() {
        setTitle("Administrar Inventario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);

        // Crear un panel para los campos de texto en forma de lista
        JPanel camposPanel = new JPanel();
        camposPanel.setLayout(new BoxLayout(camposPanel, BoxLayout.Y_AXIS));

        // Crear campos de texto y agregarlos al panel
        JTextField nombreField = new JTextField(20);
        JTextField cantidadField = new JTextField(20);
        JTextField ValorField = new JTextField(20);
        JTextField fechaIngresoField = new JTextField(20);

        camposPanel.add(new JLabel("Nombre:"));
        camposPanel.add(nombreField);
        ((AbstractDocument) nombreField.getDocument()).setDocumentFilter(new DocumentFilter() {
                    @Override
                    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                        if (esLetra(text)) {
                            super.replace(fb, offset, length, text, attrs);
                        } else {
                            mostrarAdvertencia();
                        }
                    }

                    private boolean esLetra(String texto) {
                        for (int i = 0; i < texto.length(); i++) {
                            if (!Character.isLetter(texto.charAt(i))) {
                                return false;
                            }
                        }
                        return true;
                    }

                    private void mostrarAdvertencia() {
                        JOptionPane.showMessageDialog(nombreField, "¡Solo se permiten letras!", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                });
        camposPanel.add(new JLabel("Cantidad:"));
        camposPanel.add(cantidadField);
        ((AbstractDocument) cantidadField.getDocument()).setDocumentFilter(new DocumentFilter() {
                    @Override
                    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                        if (esNumero(text)) {
                            super.replace(fb, offset, length, text, attrs);
                        } else {
                            mostrarAdvertencia();
                        }
                    }

                    private boolean esNumero(String texto) {
                       for (int i = 0; i < texto.length(); i++) {
                         if (!Character.isDigit(texto.charAt(i))) {
                            return false;
                                }
                            }
                             return true;
                         }
                    private void mostrarAdvertencia() {
                        JOptionPane.showMessageDialog(nombreField, "¡Solo se permiten numeros!", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                    });
        camposPanel.add(new JLabel("Valor:"));
        camposPanel.add(ValorField);
        ((AbstractDocument) ValorField.getDocument()).setDocumentFilter(new DocumentFilter() {
                    @Override
                    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                        if (esNumero(text)) {
                            super.replace(fb, offset, length, text, attrs);
                        } else {
                            mostrarAdvertencia();
                        }
                    }

                    private boolean esNumero(String texto) {
                       for (int i = 0; i < texto.length(); i++) {
                         if (!Character.isDigit(texto.charAt(i))) {
                            return false;
                                }
                            }
                             return true;
                         }    
                    private void mostrarAdvertencia() {
                        JOptionPane.showMessageDialog(nombreField, "¡Solo se permiten numeros!", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                });
        camposPanel.add(new JLabel("Fecha de Ingreso:"));
        camposPanel.add(fechaIngresoField);

        // Agregar el panel de campos al centro del frame
        add(camposPanel, BorderLayout.CENTER);
       JButton guardarButton = new JButton("Guardar");
        camposPanel.add(guardarButton);
        
            ProductosEnSQL productosEnSQL = new ProductosEnSQL("jdbc:mysql://localhost:3306/inventario", "root","");

        // Agregar un manejador de eventos al botón "Guardar"
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí se agrega la lógica para guardar los datos en SQL
                String nombre = nombreField.getText();
                String cantidad = cantidadField.getText();
                String fechaCaducidad = ValorField.getText();
                String fechaIngreso = fechaIngresoField.getText();

                // Crear una instancia de la clase Producto y guardar los datos
                Producto producto = new Producto(nombre, cantidad, fechaCaducidad, fechaIngreso);
                productosEnSQL.guardarProducto(producto);
                
                // Mostramos confirmacion aquí de que se haya guardado el producto
                JOptionPane.showMessageDialog(AdminvFrame.this, "Producto guardado");
            }
        });
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
    public void mostrarAdvertencia() {
        JOptionPane.showMessageDialog(this, "¡Solo se permiten letras!", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}