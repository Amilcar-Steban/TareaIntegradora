package ui;
import model.*;
import java.util.*;
public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int Cantidad = Main.Pedircantidad();
        String[] arreglo1 = Main.listmaterials(Cantidad);
        int[] utilidadEntra = Main.utilidad(arreglo1);        
        double hCenter[] = Main.PricesHomeCenter(arreglo1, Cantidad);
        double fBarrio[] = Main.PricesFNeighborhood(arreglo1, Cantidad);
        double fCentro[] = Main.PricesFCenter(arreglo1, Cantidad);
        int Quantity[] = Main.quantityMaterials(arreglo1);
        double[] THC = Tintegradora.TotalHC(hCenter, Quantity);
        double[] TFB = Tintegradora.TotalFB(fBarrio, Quantity);
        double[] TFC = Tintegradora.TotalFC(fCentro, Quantity);
        double total = Tintegradora.ValorTotal(THC, TFB, TFC); //valor suma 3 tiendas
        int direction = Main.pedirdireccion();
        double vtotal = Tintegradora.DirectionU(direction, total);
        double valorFinal = Tintegradora.ValorFinal(vtotal);
        Main.mostrartotal(valorFinal);
        double[] Mvalor = Tintegradora.Mejorprecio(hCenter, fBarrio, fCentro, arreglo1);
        String[] lugar = Tintegradora.MejorLugar(hCenter, fBarrio, fCentro, arreglo1);
        Main.mostarMprecios(Mvalor, arreglo1, lugar);
        double totalMPrecios = Tintegradora.totalMPrecios(Mvalor);
        double vtotalMP = Tintegradora.DirectionU(direction, totalMPrecios);
        Main.MostrarMPrecios(vtotalMP);   
        Main.MListObraNegra(utilidadEntra, arreglo1);
        Main.MListObraBlanca(arreglo1, utilidadEntra);
        Main.MListPintura(arreglo1, utilidadEntra);
    }
    public static int Pedircantidad(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.print("Dijite la cantidad de materiles: ");
        int Cantidad = sc.nextInt();
    return Cantidad;
    }
    public static String[] listmaterials(int num){
        Scanner sc = new Scanner(System.in);
        String[] list = new String[num];
        System.out.println("---------------------------------");
        System.out.println("\nNOMBRE DE LOS MATERIALES");
        for(int i= 0; i<list.length; i++){
            System.out.print("material numero "+(i+1)+":");
            list[i] = sc.nextLine();
        }
    return list;
    }
    public static int[] utilidad(String arreglo1[]){
        Scanner sc = new Scanner(System.in);            
        int[] Outilidad = new int[arreglo1.length];
        System.out.println("--------------------------");
        System.out.println("UTILIDAD DE MATERIAL:");
        System.out.println("1. Obra negra");
        System.out.println("2. Obra blanca");
        System.out.println("3. Pintura");
        for (int i = 0; i < arreglo1.length; i++) {
            System.out.print("Utilidad de "+arreglo1[i]+": ");
            Outilidad[i] = sc.nextInt();
        }
    return Outilidad;
    }
    
    public static double[] PricesFCenter(String Arreglo[], int num){
        Scanner sc = new Scanner(System.in);
        double[] ferreteriaCentro = new double[Arreglo.length];
        System.out.println("---------------------------------------------");
        System.out.println("\nAHORA LOS VALORES EN FERRETERIA DEL CENTRO");
        for (int i = 0; i <num ; i++) {
            System.out.print("valor de "+Arreglo[i]+":");
            ferreteriaCentro[i] = sc.nextInt();
        }
        return ferreteriaCentro;
    }
    public static double[] PricesFNeighborhood(String Arreglo[], int num){
        Scanner sc = new Scanner(System.in);
        double[] ferreteriaBarrio = new double[num];
        System.out.println("----------------------------------------------");
        System.out.println("\nDIJITE LOS VALORES EN FERRETERIA DEL BARRIO");
        for (int i = 0; i <num ; i++) {
            System.out.print("valor de "+Arreglo[i]+":");
            ferreteriaBarrio[i] = sc.nextInt();
        }
        return ferreteriaBarrio;
    }
    public static double[] PricesHomeCenter( String Arreglo[], int num){
        Scanner sc = new Scanner(System.in);
        double[] homeCenter = new double[num];
        System.out.println("-----------------------------------------");
        System.out.println("\nAHORA DIJITE LOS VALORES DE HOMECENTER");
        for (int i = 0; i <num ; i++) {
            System.out.print("valor de "+Arreglo[i]+":");
            homeCenter[i] = sc.nextInt();
        }
    return homeCenter;
    }
    public static int[] quantityMaterials(String Arreglo[]){
        Scanner sc = new Scanner(System.in);
        int[] Quantity1 = new int[Arreglo.length];
        System.out.println("--------------------------------------------");
        System.out.println("\nAHORA DIJITE LA CANTIDAD DE CADA MATERIAL");
        for (int i = 0; i <Arreglo.length ; i++) {
            System.out.print("Cantidad de "+Arreglo[i]+":");
            Quantity1[i] = sc.nextInt();
        }
        return Quantity1;
    }
    public static int pedirdireccion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("ESCOJA SU DIRECCION");
        System.out.println("1.Norte");
        System.out.println("2.Centro");
        System.out.println("3.Sur");
        int direction = sc.nextInt();
    return direction;
    }
    public static void mostrartotal(double valorFinal){
        System.out.println("--------------");
        System.out.println("Valor Total: "+valorFinal);
    }
    public static void mostarMprecios(double Mvalor[], String arreglo1[], String lugar[]){
        System.out.print("-----------------");
        System.out.println("\nMEJORES PRECIOS");
        for (int i = 0; i <arreglo1.length; i++) {
            System.out.println("Mejor precio de "+arreglo1[i]+" en "+lugar[i]+": "+Mvalor[i]);
        }
    }
    public static void MostrarMPrecios(double vtotalMP){
            System.out.println("Total: "+ vtotalMP);
    }
    
    public static void MListObraNegra( int[] utilidadEntra, String[] arreglo1){
        System.out.println("----------------------------------");
        System.out.println("LISTA DE MATERIALES POR UTILIDAD");
        System.out.println("----------------------");
        System.out.println("OBRA NEGRA :");
        for (int i = 0; i < arreglo1.length; i++) {
            if (utilidadEntra[i] == 1){
                System.out.println("- "+arreglo1[i]);
            }
        }
    }
    public static void MListObraBlanca(String[] arreglo1, int[] utilidadEntra){
        System.out.println("----------------------");
        System.out.println("OBRA BLANCA");
        for (int i = 0; i <arreglo1.length; i++) {
            if (utilidadEntra[i] == 2){
                System.out.println("- "+arreglo1[i]);  
            }
        }
    }
    public static void MListPintura(String[] arreglo1, int[] utilidadEntra){
        System.out.println("----------------------");
        System.out.println("PINTURA");
        for (int i = 0; i <arreglo1.length; i++) {
            if (utilidadEntra[i] == 3){
                System.out.println("- "+arreglo1[i]);  
            }
        }
    }
}
