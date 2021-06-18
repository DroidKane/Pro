import java.util.Scanner;


public class JimmyAnthonyMuebles {
  public static String reg_datos_usuario[] = new String[12];
  //private static String reg_Pedidos[] = new String[100];
  public static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    reg_datos_usuario[0] = "123456789";
    reg_datos_usuario[1] = "adminName";
    reg_datos_usuario[2] = "00/00/00";
    reg_datos_usuario[3] = "admin123@gmail.com";
    reg_datos_usuario[4] = "administrador";
    reg_datos_usuario[5] = "pass";
    menu();
    
  }

  // Menu Principal: Solo se encarga de reenviar al usuario final como
  // administrador o empleado.
  public static void menu() {
    byte menu = 0;
    while (menu == 0) {
      try {
        System.out.println("*************************************");
        System.out.println("**      Fábrica de muebles STO     **");
        System.out.println("** 1- Ingresar como administrador  **");
        System.out.println("** 2- Ingresar como empleado       **");
        System.out.println("** 3- Salir                        **");
        System.out.println("*************************************");
        int opt_menu = sc.nextInt();

        switch (opt_menu) {
          case 1:
            admin();
            break;
          case 2:
            empleado();
            break;
          case 3:
            menu += 1;
            break;
          default:
            System.out.println("\n");
            System.out.println("\u001B[31m" + "Error, solo números entre el 1 al 3." + "\u001B[0m");
            System.out.println("\n\n\n");
            sc.nextLine();
            break;
        }
      } catch (Exception e) {
        System.out.println("\n");
        System.out.println("\u001B[31m" + "Error, introduce un número." + "\u001B[0m");
        System.out.println("\n\n\n");
        sc.nextLine();
      }
    }
  }

  // Menu del administrador:
  public static void admin() {
    byte op=0;
    while(op == 0){
      try {
        System.out.println("*************************************");
        System.out.println("**      Menú Adaministrador        **");
        System.out.println("** 1- Leer Pedidos                 **");
        System.out.println("** 2- Revisión Pedidos             **");
        System.out.println("** 3- Procesar Pedidos             **");
        System.out.println("** 4- Consultas                    **");
        System.out.println("** 5- Salir                        **");
        System.out.println("*************************************");

        switch (op) {
          case 1:
            leer_Pedidos();
            break;
          case 2:
            revisar_Pedidos();
            break;
          case 3:
            procesar_Pedidos();
            break;
          case 4:
            consultas();
            break;
          case 5:
            menu();
            break;
          default:
            System.out.println("\n");
            System.out.println("\u001B[31m" + "Error, solo números entre el 1 al 5." + "\u001B[0m");
            System.out.println("\n\n\n");
            sc.nextLine();
            break;
        }
      }catch (Exception e) {
        System.out.println("\n");
        System.out.println("\u001B[31m" + "Error, introduce un número." + "\u001B[0m");
        System.out.println("\n\n\n");
        sc.nextLine();
      }
    }
  }

  // Menu del empleado:
  /* Permite iniciar sesión como empleado o crear una cuenta*/
  public static void empleado() {
    String cedula, nombre, fecha_nacimiento, correo, pass;
    String tipo_user = "empleado";
    byte empleado = 0;

    while (empleado == 0) {
      try {
        System.out.println("\n\n\n");
        System.out.println("*************************************");
        System.out.println("**            Empleado             **");
        System.out.println("** 1- Iniciar sesión               **");
        System.out.println("** 2- Crear cuenta                 **");
        System.out.println("** 3- Salir                        **");
        System.out.println("*************************************");
        int opt_menu = sc.nextInt();

        switch (opt_menu) {
          case 1:
            sc.nextLine();
            System.out.println("\n");
            System.out.println("Ingrese su id/cédula");
            cedula = sc.nextLine();
            System.out.println("\n");
            System.out.println("Ingrese su contraseña");
            pass = sc.nextLine();

            for(int i = 0; i < reg_datos_usuario.length; i++) {
              if(cedula.equals(reg_datos_usuario[i])) {
                String pass_nueva = reg_datos_usuario[i+5];

                if(pass.equals(pass_nueva)) {
                  empleadoLogeado();
                }
              }
            }

            break;
          case 2:
            sc.nextLine();
            System.out.println("\n");
            System.out.println("Ingrese su número de cédula");
            cedula = sc.nextLine();
            System.out.println("\n");
            System.out.println("Ingrese su nombre completo");
            nombre = sc.nextLine();
            System.out.println("\n");
            System.out.println("Ingrese su fecha de nacimiento");
            fecha_nacimiento = sc.nextLine();
            System.out.println("\n");
            System.out.println("Ingrese su correo electrónico");
            correo = sc.nextLine();
            System.out.println("\n");
            System.out.println("Ingrese su de contraseña");
            pass = sc.nextLine();

            reg_datos_usuario[6] = cedula;
            reg_datos_usuario[7] = nombre;
            reg_datos_usuario[8] = fecha_nacimiento;
            reg_datos_usuario[9] = correo;
            reg_datos_usuario[10] = tipo_user;
            reg_datos_usuario[11] = pass;
            System.out.println("\u001B[32m" + "Usuario creado exitosamente!" + "\u001B[0m");
            break;
          case 3:
            empleado += 1;
            break;
          default:
            System.out.println("\n");
            System.out.println("\u001B[31m" + "Error, solo números entre el 1 al 3." + "\u001B[0m");
            sc.nextLine();
            System.out.println("\n\n\n");
            break;
        }

      } catch (Exception e) {
        System.out.println("\n");
        System.out.println("\u001B[31m" + "Error, introduce un número." + "\u001B[0m");
        sc.nextLine();
        System.out.println("\n\n\n");
      }
    }
  }

  public static void empleadoLogeado() {
    byte empleado = 0;

    while (empleado == 0) {
      try {
        System.out.println("\n\n\n");
        System.out.println("*************************************");
        System.out.println("**   Bienvenido que desea hacer?   **");
        System.out.println("** 1- Registrar clientes           **");
        System.out.println("** 2- Realizar/Finalizar pedido    **");
        System.out.println("** 3- Imprimir etiqueta            **");
        System.out.println("** 4- Salir                        **");
        System.out.println("*************************************");
        int opt_menu = sc.nextInt();

        switch (opt_menu) {
          case 1:
            break;
          case 2:
            break;
          case 3:
            break;
          case 4:
            empleado += 1;
            break;
          default:
            System.out.println("\n");
            System.out.println("\u001B[31m" + "Error, solo números entre el 1 al 4." + "\u001B[0m");
            System.out.println("\n\n\n");
            sc.nextLine();
            break;
        }

      } catch (Exception e) {
        System.out.println("\n");
        System.out.println("\u001B[31m" + "Error, introduce un número." + "\u001B[0m");
        System.out.println("\n\n\n");
        sc.nextLine();
      }
    }
  }
  
  //Metodos del admin
  /**
   * Muestra los pedidos
   */
  public static void leer_Pedidos(){
    System.out.println("*************************************");
    System.out.println("**   Leer Pedidos   **");
    int cont=1;
    for (String string : reg_datos_usuario) {
      System.out.println(cont+": "+string);
    }
  }

  public static void revisar_Pedidos(){
    System.out.println("*************************************");
    System.out.println("**   Revisar Pedidos   **");

  }
  
  public static void procesar_Pedidos(){
    System.out.println("*************************************");
    System.out.println("**   Procesar Pedidos   **");

  }

  public static void consultas(){
    System.out.println("*************************************");
    System.out.println("**   Consultas Pedidos   **");

  }
}