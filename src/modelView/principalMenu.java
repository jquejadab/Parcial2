/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelView;

import model.Login;
import model.ObtDatos;
import static model.ObtDatos.insertarUsuarioEnBD;
import java.util.Scanner;

public class principalMenu {

     public static void main(String[] args) {
         ejecutarMP();
     }
        static void ejecutarMP() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Menu Principal:");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar Sesion");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        // Registrarse
                        Usuario nuevoUsuario = ObtDatos.obtenerDatos();
                        insertarUsuarioEnBD(nuevoUsuario);
                        System.out.println("Registro exitoso.");
                        mostrarDatosUsuario(nuevoUsuario);
                        break;

                    case 2:
                        // Iniciar Sesión
                        Login.iniciarSesion();
                        break;

                    case 3:
                        System.out.println("Saliendo del programa.");
                        System.exit(0); // Termina el programa
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine(); // Consumir la entrada incorrecta
            }
        }
    }

    // Resto del código de la clase principalMenu

    // Función para mostrar los datos de un usuario
    private static void mostrarDatosUsuario(Usuario usuario) {
        System.out.println("------------");
        System.out.println("Datos ingresados:");
        System.out.println("------------");
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Contrasena: " + usuario.getContraseña());
        System.out.println("Cedula: " + usuario.getCedula());
        System.out.println("Correo: " + usuario.getCorreo());
        System.out.println("Telefono: " + usuario.getTelefono());
        System.out.println("------------");
    }
}