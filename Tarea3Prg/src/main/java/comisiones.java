/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class comisiones {
    public static String[][] comision = new String[3][6];
    public static Scanner sc = new Scanner(System.in);

    public static void Tabla() {
        comision[0][0] = "Emanuel Roque";
        comision[0][1] = "98";
        comision[0][2] = "19";
        comision[0][3] = "30";

        comision[1][0] = "Gustavo Guerra";
        comision[1][1] = "16";
        comision[1][2] = "32";
        comision[1][3] = "40";

        comision[2][0] = "Bryan Idiarte";
        comision[2][1] = "55";
        comision[2][2] = "20";
        comision[2][3] = "10";

        System.out.println("TABLA DE VENTAS");
    }

    public static void imprimirDecorado(String[][] ma) {
        for (int x = 0; x < ma.length; x++) {
            System.out.print("|");
            for (int y = 0; y < ma[x].length; y++) {
                System.out.print(ma[x][y]);
                if (y != ma[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }

    public static void CalculoTotalPorMes() {
        int Mes;
        int Fila;
        int[] TotalMes = new int[comision.length];

        for (int columna = 1; columna < comision[0].length - 1; columna++) {
           
            Mes = 0;
            Fila = 0;

            for (int fila = 0; fila < comision.length; fila++) {

                Mes += Integer.parseInt(comision[fila][columna]);//sumo el operando izquierdo con el derecho y luego lo asigno al izquierdo
            }

            System.out.println("Total de la columna " + columna + " es " + Mes);
        }
    }

    public static void PromedioMes() {

        String nombre = "";
        int AcumMes;
        int CantidadMes;
        double Promedio;

        for (int fila = 0; fila < comision.length; fila++) {
            
            CantidadMes= 0;
            
            AcumMes= 0;
            Promedio = 0;

            for (int columna = 1; columna < comision[fila].length - 2; columna++) {
               

                
                AcumMes+= Integer.parseInt(comision[fila][columna]);
                CantidadMes++;

                Promedio = AcumMes / CantidadMes;

            }

            comision[fila][comision[fila].length - 2] = String.valueOf(AcumMes);//convierto mi tipo de dato
            comision[fila][comision[fila].length - 1] = String.valueOf(Promedio);

           
        }

    }

    public static void VentasMaximasMes(String mes) {
        int ValorFila;
        int ColumnaMes;

       
        int MaxVenta = 0;

       
        int MinVenta = 4999;

        
        String NombreMaxVent = "";
        String NombreMinVent = "";

        switch (mes.toLowerCase()) {
            case "enero":
                ColumnaMes = 1;
                break;

            case "febrero":
                ColumnaMes= 2;
                break;

            case "marzo":
                ColumnaMes = 3;
                break;

            default:
                System.out.println("Mes Invalido");
               
                return;
        }

        for (int fila = 0; fila < comision.length; fila++) {
            ValorFila = Integer.parseInt(comision[fila][ColumnaMes]);

            if (ValorFila > MaxVenta) {
                MaxVenta = ValorFila;
                NombreMaxVent = comision[fila][0];
            } else if (ValorFila < MinVenta) {
                MinVenta = ValorFila;
                NombreMinVent = comision[fila][0];
            }

        }

        System.out.println(NombreMinVent + " tiene menor venta con " + MinVenta + " ventas en " + mes);
        System.out.println(NombreMaxVent + " tiene mayor venta con " + MaxVenta + " ventas en " + mes);

    }

    public static void MaxMinTotal() {
        int valorFila;
        int MinTotal = 4999;
        int MaxTotal = 0;
        String NombreMaxVent = "";
        String NombreMinVent = "";

        for (int fila = 0; fila < comision.length; fila++) {
            valorFila = Integer.parseInt(comision[fila][4]);

            if (valorFila > MaxTotal) {
                MaxTotal = valorFila;
                NombreMaxVent = comision[fila][0];
            } else if (valorFila < MinTotal) {
                MinTotal = valorFila;
                NombreMinVent = comision[fila][0];
            }
        }

        System.out.println("MEJOR VENTA - " + NombreMaxVent + " tiene un total de " + MaxTotal + " ventas.");
        System.out.println("MENOR VENTA - " + NombreMinVent + " tiene un total de " + MinTotal + " ventas.");
    }

   
    public static void main(String[] args) {
        Tabla();
        PromedioMes();
        imprimirDecorado(comision);
        CalculoTotalPorMes();
        VentasMaximasMes("enero");
        VentasMaximasMes("febrero");
        VentasMaximasMes("marzo");
        MaxMinTotal();
       
    }

}
  
