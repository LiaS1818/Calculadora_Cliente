import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static final int PUERTO1 = 8082;
    public static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        System.out.println("addr = " + HOST);
        Socket socket1 = new Socket(HOST, PUERTO1);

        try (
                BufferedReader entrada1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                PrintWriter salida1 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream())), true);
                PrintWriter salida2 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream())), true);
                Scanner teclado = new Scanner(System.in);
        ) {
            salida1.println("Usuario: Hola server soy tu cliente que vale mil");

            System.out.println("Primer numero:");
            int numero1 = teclado.nextInt();
            imprimirMenu();
            int opcion = teclado.nextInt();
            salida2.println(numero1 + "," + opcion);


            String str1 = entrada1.readLine();
            System.out.println(str1);
            salida1.println("FIN");

        } finally {
            System.out.println("cerrando...");
            socket1.close();
        }
    }

    private static void imprimirMenu(){
        System.out.println("Que operacion desead realizar");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Division");
        System.out.println("4. Multiplicacion");
        System.out.println("5. Residuo");
        System.out.println("6. Potencia");
    }
}
