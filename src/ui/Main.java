package ui;
import model.*;
import java.util.*;
public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int QuantityM = Main.Pedircantidad();
        String[] arreglo1 = Main.listmaterials(QuantityM);
        int[] utilidadEntra = Main.utilidad(arreglo1);        
        double hCenter[] = Main.PricesHomeCenter(arreglo1, QuantityM);
        double fBarrio[] = Main.PricesFNeighborhood(arreglo1, QuantityM);
        double fCentro[] = Main.PricesFCenter(arreglo1, QuantityM);
        int Quantity[] = Main.quantityMaterials(arreglo1);
        double[] THC = Tintegradora.TotalHC(hCenter, Quantity);
        double[] TFB = Tintegradora.TotalFB(fBarrio, Quantity);
        double[] TFC = Tintegradora.TotalFC(fCentro, Quantity);
        double total = Tintegradora.ValorTotal(THC, TFB, TFC); //valor suma 3 tiendas
        int address = Main.pedirdireccion();
        double vtotal = Tintegradora.DirectionU(address, total);
        double valorFinal = Tintegradora.ValorFinal(vtotal);
        
        Main.mostrartotal(valorFinal);
        
        double[] Mvalor = Tintegradora.Mejorprecio(hCenter, fBarrio, fCentro, arreglo1);
        String[] lugar = Tintegradora.MejorLugar(hCenter, fBarrio, fCentro, arreglo1);
        
        Main.mostarMprecios(Mvalor, arreglo1, lugar);
        
        double totalMPrecios = Tintegradora.totalMPrecios(Mvalor);
        double vtotalMP = Tintegradora.DirectionU(address, totalMPrecios);
        
        Main.MostrarMPrecios(vtotalMP);   
        Main.MListObraNegra(utilidadEntra, arreglo1);
        Main.MListObraBlanca(arreglo1, utilidadEntra);
        Main.MListPintura(arreglo1, utilidadEntra);
    }
    /**
     * method to enter a quantity of materials
     * <b> pre: </b> 
     * <b> pos: </b> returns the quantity of materials <br> 
     * @return Quantity>0
     * @param: Quantity store quantity of materials. Quantity>0
     * */
    public static int Pedircantidad(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.print("Dijite la cantidad de materiles: ");
        int Quantity = sc.nextInt();
    return Quantity;
    }
    /**
     * method to say the names of each material
     * <b> Pre: </b> num must have a value and must be initialized<br>
     * <b> Pos: </b> returns a list of names <br>
     * @param num is a call to Quantity. num>0 and !=null
     * @return return a list of materials
     */
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
    /**
     * method to select the usefulness of materials
     * <b> Pre: </b> arreglo1 must be initialized  and must have a value<br>
     * <b> Pos: </b> returns an option as a number using a menu <br>
     * @param arreglo1 is the list of materials and !=null
     * @return Outilidad return a value. Outilidad>0, !=null and <3
     */
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
    /**
     * method where it receives values ​​for each material
     * <b> Pre: </b> Arreglo, ferreteriaCentro and num must be initialized and must have a value<br>
     * <b> Pos: </b> return a list of values for each material <br>
     * @param Arreglo material's list. != null
     * @param num>0 and != null
     * @return ferreteriaCentro the list of values
     */
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
    /**
     * method where it receives values ​​for each material
     * <b> Pre: </b> Arreglo, ferreteriaBarrio and num must be initialized and must have a value<br>
     * <b> Pos: </b> return a list of values for each material <br>
     * @param Arreglo material's list. !=null
     * @param num>0 and != null
     * @return ferreteriaBarrio the list of values
     */
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
    /**
     * method where it receives values ​​for each material
     * <b> Pre: </b> Arreglo, homeCenter and num must be initialized and must have a value <br>
     * <b> Pos: </b> return a list of values for each material <br>
     * @param Arreglo material's list. !=nul
     * @param num>0 and != null     
     * @return homeCenter the list of values
     */
    
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
    /**
     * method where the quantity of each material is said
     * <b> Pre: </b> Arreglo and Quantity1 must be initialized and must have a value<br>
     * <b> Pos: </b> return a list of values for each material <br>
     * @param Arreglo material's list. !=null
     * @return homeCenter the list of values
     */
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
    /**
     * method to select the address
     * <b> Pre: </b> address must be initialized  and must have a value<br>
     * <b> Pos: </b> returns an option as a number using a menu <br>
     * @return address return a value. address>0, !=null and <3
     */
    public static int pedirdireccion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("ESCOJA SU DIRECCION");
        System.out.println("1.Norte");
        System.out.println("2.Centro");
        System.out.println("3.Sur");
        int address = sc.nextInt();
    return address;
    }
    /**
     * method to show total cost of the work
     * <b> Pre: </b> valorFinal must be initialized and must have a value <br>
     * <b> Pos: </b> shows the cost of the work <br>
     * @param valorFinal != null
     */
    public static void mostrartotal(double valorFinal){
        System.out.println("--------------");
        System.out.println("Valor Total: "+valorFinal);
    }
    /**
     * method to show the best prices depending on the hardware store
     * <b> Pre: </b> Mvalor, arreglo1 and lugar must be initialized and must have a value<br>
     * <b> Pos: </b> save the lowest prices of each material <br>
     * @param Mvalor !=null
     * @param arreglo1 !=null
     * @param lugar  !=null
     */
    public static void mostarMprecios(double Mvalor[], String arreglo1[], String lugar[]){
        System.out.print("-----------------");
        System.out.println("\nMEJORES PRECIOS");
        for (int i = 0; i <arreglo1.length; i++) {
            System.out.println("Mejor precio de "+arreglo1[i]+" en "+lugar[i]+": "+Mvalor[i]);
        }
    }
    /**
     * method for show the best prices
     * <b> Pre: </b>  vtotalMP must be initialized and must have a value<br>
     * <b> Pos: </b> shows the total of the best prices including the value per address <br>
     * @param vtotalMP 
     */
    public static void MostrarMPrecios(double vtotalMP){
            System.out.println("Total: "+ vtotalMP);
    }
    /**
     * method showing materials classified by utility
     * <b> Pre: </b>  utilidadEntra and arreglo1 must be initialized and  must have a value<br>
     * <b> Pos: </b> displays materials in a list depending on their usefulness <br>
     * @param utilidadEntra != null
     * @param arreglo1 != null
     */
    public static void MListObraNegra( int[] utilidadEntra, String[] arreglo1){
        System.out.println("----------------------------------");
        System.out.println("LISTA DE MATERIALES POR UTILIDAD");
        System.out.println("----------------------");
        System.out.println("OBRA NEGRA:");
        for (int i = 0; i < arreglo1.length; i++) {
            if (utilidadEntra[i] == 1){
                System.out.println("- "+arreglo1[i]);
            }
        }
    }
    /**
     * method showing materials classified by utility
     * <b> Pre: </b>  utilidadEntra and arreglo1 must be initialized and  must have a value<br>
     * <b> Pos: </b> displays materials in a list depending on their usefulness <br>
     * @param arreglo1 != null
     * @param utilidadEntra  != null
     */
    public static void MListObraBlanca(String[] arreglo1, int[] utilidadEntra){
        System.out.println("----------------------");
        System.out.println("OBRA BLANCA:");
        for (int i = 0; i <arreglo1.length; i++) {
            if (utilidadEntra[i] == 2){
                System.out.println("- "+arreglo1[i]);  
            }
        }
    }
    /**
     * method showing materials classified by utility
     * <b> Pre: </b>  utilidadEntra and arreglo1 must be initialized and  must have a value<br>
     * <b> Pos: </b> displays materials in a list depending on their usefulness <br>
     * @param arreglo1 != null
     * @param utilidadEntra != null
     */
    public static void MListPintura(String[] arreglo1, int[] utilidadEntra){
        System.out.println("----------------------");
        System.out.println("PINTURA:");
        for (int i = 0; i <arreglo1.length; i++) {
            if (utilidadEntra[i] == 3){
                System.out.println("- "+arreglo1[i]);  
            }
        }
    }
}
