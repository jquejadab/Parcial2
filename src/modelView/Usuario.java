/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelView;





public class Usuario {

    private int id;
    private String nombre;
    private String contraseña;
    private String cedula;
    private String correo;
    private String telefono;

    // Constructor
    public Usuario(String nombre, String contraseña, String cedula, String correo, String telefono) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
    }
    public void mostrarDatos() {
        System.out.println("------------");
        System.out.println("Datos del usuario:");
        System.out.println("------------");
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Cedula: " + this.cedula);
        System.out.println("Correo: " + this.correo);
        System.out.println("Telefono: " + this.telefono);
        System.out.println("------------");
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }
}
