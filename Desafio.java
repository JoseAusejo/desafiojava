import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        // Inicialización de variables de la cuenta
        String nombre = "Tony Stark";
        String tipoDeCuenta = "Corriente";
        double saldo = 1599.99;
        int opcion = 0;

        // Información del cliente
        System.out.println("*****************************************");
        System.out.println("\nNombre del cliente: " + nombre);
        System.out.println("Tipo de cuenta: " + tipoDeCuenta);
        System.out.printf("Saldo disponible: %.2f $\n", saldo);
        System.out.println("\n*****************************************");

        // Menú de opciones
        String menu = """
                ** Escriba el número de la opción deseada **
                1 - Consultar saldo
                2 - Retirar
                3 - Depositar
                9 - Salir
                """;

        // Inicialización del scanner para la entrada del usuario
        Scanner teclado = new Scanner(System.in);

        // Bucle principal que mantiene el menú hasta que el usuario seleccione salir (opción 9)
        while (opcion != 9) {
            System.out.println(menu);
            opcion = teclado.nextInt();

            // Procesar la opción seleccionada por el usuario
            switch (opcion) {
                case 1:
                    // Opción para consultar el saldo
                    System.out.printf("El saldo actualizado es: %.2f $\n", saldo);
                    break;
                case 2:
                    // Opción para retirar dinero
                    System.out.println("¿Cuál es el valor que deseas retirar?");
                    double valorARetirar = teclado.nextDouble();

                    // Validación para asegurarse de que el valor ingresado sea positivo
                    if (valorARetirar <= 0) {
                        System.out.println("El valor debe ser mayor que 0.");
                    } else if (valorARetirar > saldo) {
                        // Validación de saldo suficiente
                        System.out.println("Saldo insuficiente.");
                    } else {
                        // Actualización del saldo después de la retirada
                        saldo -= valorARetirar;
                        System.out.printf("Saldo restante: %.2f $\n", saldo);
                    }
                    break;
                case 3:
                    // Opción para depositar dinero
                    System.out.println("¿Cuál es el valor que vas a depositar?");
                    double valorADepositar = teclado.nextDouble();

                    // Validación para asegurarse de que el valor ingresado sea positivo
                    if (valorADepositar <= 0) {
                        System.out.println("El valor debe ser mayor que 0.");
                    } else {
                        // Actualización del saldo después del depósito
                        saldo += valorADepositar;
                        System.out.printf("El saldo actualizado es: %.2f $\n", saldo);
                    }
                    break;
                case 9:
                    // Opción para salir del programa
                    System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios.");
                    break;
                default:
                    // Manejo de opciones no válidas
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }

        // Cierre del Scanner para evitar fugas de recursos
        teclado.close();
    }
}
