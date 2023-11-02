/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

/**
 *
 * @author Sebastian
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Login {
    
    public static boolean verificarCredenciales(String Nombre, String contraseña) {
        String jdbcURL = "jdbc:mysql://localhost:3306/usuarios";
        String usuarioDB = "root";
        String contraseñaDB = "";

        try {
            Connection conexion = DriverManager.getConnection(jdbcURL, usuarioDB, contraseñaDB);
            String sql = "SELECT * FROM usuarios WHERE Nombre = ? AND Contraseña = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, Nombre);
            statement.setString(2, contraseña);
            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {
                // Si se encuentra un registro, las credenciales son válidas
                return true;
            }
            
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        
        // Si no se encuentra un registro, las credenciales no son válidas
        return false;
    }

    public static void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su nombre de usuario: ");
        String Nombre = scanner.nextLine();

        System.out.println("Ingrese su contrasena: ");
        String contraseña = scanner.nextLine();

        if (verificarCredenciales(Nombre, contraseña)) {
            System.out.println("Inicio de sesion exitoso.");
        } else {
            System.out.println("Inicio de sesion fallido. Verifique sus credenciales.");
           
        }

    scanner.close();
    }
}