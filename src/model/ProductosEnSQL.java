/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sebastian
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelView.Producto;

public class ProductosEnSQL {
    private String jdbcURL = "jdbc:mysql://localhost:3306/inventario";
    private String usuario = "root";
    private String contraseña = "";

    public ProductosEnSQL(String jdbcURL, String usuario, String contraseña) {
        this.jdbcURL = jdbcURL;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public void guardarProducto(Producto producto) {
        try (Connection conn = DriverManager.getConnection(jdbcURL, usuario, contraseña)) {
            String sql = "INSERT INTO productos (nombre, cantidad, fecha_caducidad, fecha_ingreso) VALUES (?, ?, ?, ?)";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, producto.getNombre());
                stmt.setString(2, producto.getCantidad());
                stmt.setString(3, producto.getFechaCaducidad());
                stmt.setString(4, producto.getFechaIngreso());
                stmt.executeUpdate();
            }

            System.out.println("Producto guardado en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
