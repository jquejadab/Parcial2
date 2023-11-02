/*

 */
package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import model.Login;
import model.ObtDatos;
import modelView.Usuario;


public abstract class principalScreens implements Vistas{
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            inicial();
        });
    }
      @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void inicial() {
        JFrame frame = new JFrame("Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        JPanel panel = new JPanel();
        panel.setSize(500, 500);

        JLabel label = new JLabel("Menú Principal:");
        JButton registrarseButton = new JButton("Registrarse");
        JButton iniciarSesionButton = new JButton("Iniciar Sesión");
        JButton salirButton = new JButton("Salir");
        
        panel.setLayout(new BorderLayout());

        // Crear un panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2));

        buttonPanel.add(label);
        buttonPanel.add(new JLabel()); // Espacio en blanco
        buttonPanel.add(registrarseButton);
        buttonPanel.add(iniciarSesionButton);
        buttonPanel.add(new JLabel()); // Espacio en blanco
        buttonPanel.add(salirButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registroFrame = new JFrame("Registrarse");
                registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               
                JPanel registroPanel = new JPanel();
                registroPanel.setLayout(new GridLayout(3, 2));

                JLabel nombreLabel = new JLabel("Nombre:");
                JTextField nombreField = new JTextField();
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
                JLabel emailLabel = new JLabel("Email:");
                JTextField emailField = new JTextField();
                JPasswordField contraField = new JPasswordField();
                JLabel contraLabel = new JLabel("Contraseña");
                JLabel cedulaLabel = new JLabel("Cedula");
                JTextField cedulaField = new JTextField();
                ((AbstractDocument) cedulaField.getDocument()).setDocumentFilter(new DocumentFilter() {
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
                JLabel telLabel = new JLabel("Telefono");
                JTextField telField = new JTextField();
                ((AbstractDocument) telField.getDocument()).setDocumentFilter(new DocumentFilter() {
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
                JButton registrarUsuarioButton = new JButton("Terminar registro");

                registroPanel.add(nombreLabel);
                registroPanel.add(nombreField);
                
                registroPanel.add(contraLabel);
                registroPanel.add(contraField);
                
                registroPanel.add(cedulaLabel);
                registroPanel.add(cedulaField);
                
                registroPanel.add(emailLabel);
                registroPanel.add(emailField);
                
                registroPanel.add(telLabel);
                registroPanel.add(telField);
                //Se añaden los campos de texto al formulario de "registro"
                
                registroPanel.add(new JLabel());
                registroPanel.add(registrarUsuarioButton);
                
                registroFrame.add(registroPanel);
                registroFrame.pack();
                registroFrame.setVisible(true);
                
                registrarUsuarioButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Lógica para registrar el usuario con los datos de nombre y email
                        String nombre = nombreField.getText();
                        String contraseña = contraField.getText();
                        String cedula = cedulaField.getText();
                        String correo = emailField.getText();
                        String telefono = telField.getText();
                        // Lógica de inserción en la base de datos
                        Usuario nuevoUsuario = new Usuario(nombre,contraseña,cedula, correo, telefono);
 
                        ObtDatos.insertarUsuarioEnBD(nuevoUsuario);
                        // Cerrar la ventana de registro
                        registroFrame.dispose();
                    }
                });
            }
        });

        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame inicioSesionFrame = new JFrame("Iniciar Sesión");
                inicioSesionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel inicioSesionPanel = new JPanel();
                inicioSesionPanel.setLayout(new BoxLayout(inicioSesionPanel, BoxLayout.Y_AXIS));

                JLabel nombreLabel = new JLabel("Usuario:");
                JLabel contraLabel = new JLabel("Contraseña");
                JTextField nombreField = new JTextField(20);
                ((AbstractDocument) nombreField.getDocument()).setDocumentFilter(new DocumentFilter() {
                    @Override
                    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
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
                JPasswordField contraField = new JPasswordField(20); 
                JButton iniciarSesionButton = new JButton("Iniciar Sesión");
                inicioSesionPanel.add(nombreLabel);
                inicioSesionPanel.add(nombreField);
                inicioSesionPanel.add(contraLabel);
                inicioSesionPanel.add(contraField);
                inicioSesionPanel.add(new JLabel()); // Espacio en blanco
                inicioSesionPanel.add(iniciarSesionButton);

                inicioSesionFrame.add(inicioSesionPanel);
                inicioSesionFrame.pack();
                inicioSesionFrame.setVisible(true);

                iniciarSesionButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nombre = nombreField.getText();
                        String contra = contraField.getText();
                        // Lógica de autenticación en la base de datos
                         boolean credencialesValidas = Login.verificarCredenciales(nombre, contra);

                        if (credencialesValidas) {
                        // Las credenciales son válidas, se mostrará un msj de éxito y llevará a la siguiente pantalla
                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                        MenuPrincipalFrame menuFrame = new MenuPrincipalFrame();
                        menuFrame.mostrar();
                        //Aqui se abrira la siguiente pantalla luego del inicio de sesión.
                        } else {
                        // Las credenciales no son válidas, muestra un mensaje de error
                        JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Intente nuevamente.");
                    }
                        // Cerrar la ventana de inicio de sesión
                        inicioSesionFrame.dispose();
                    }
                });
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog saliendo = new JDialog();
                System.out.println("Saliendo del programa.");
                
                System.exit(0);
            }
        });
    }
}