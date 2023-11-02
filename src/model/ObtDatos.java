/*
 */
package model;

import java.util.Random;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelView.Usuario;

public class ObtDatos {
    public static void insertarUsuarioEnBD(Usuario usuario) {
        String jdbcURL = "jdbc:mysql://localhost:3306/usuarios";
        String usuarioDB = "root";
        String contraseñaDB = "";
        
        try {
            Connection conexion = DriverManager.getConnection(jdbcURL, usuarioDB, contraseñaDB);

            String sql = "INSERT INTO usuarios (nombre, contraseña, cedula, correo, telefono) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = conexion.prepareStatement(sql);
                statement.setString(1, usuario.getNombre());
                statement.setString(2, usuario.getContraseña());
                statement.setString(3, usuario.getCedula());
                statement.setString(4, usuario.getCorreo());
                statement.setString(5, usuario.getTelefono());


            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("------------");
                System.out.println("Trabajador registrado en la base de datos.");
               System.exit(0);
                return;
            } else {
                System.out.println("No se pudo registrar el usuario en la base de datos.");
            }

            statement.close();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
     
    }

    public static Usuario obtenerDatos() {
        
        return null;
        
    }
}