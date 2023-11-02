/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelView;

/**
 *
 * @author Sebastian
 */
public class Producto {
    private String nombre;
    private String cantidad;
    private String fechaCaducidad;
    private String fechaIngreso;

    public Producto(String nombre, String cantidad, String fechaCaducidad, String fechaIngreso) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }
}
