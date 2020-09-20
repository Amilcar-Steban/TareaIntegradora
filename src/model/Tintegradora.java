package model;

public class Tintegradora {
    private static final int ROUGH_CONSTRUCTION = 1300000;
    private static final int FINAL_CONSTRUCTION = 2600000;
    private static final int PAINTING = 980000;
    
    /**
     * method that calculate the total of each material
     * <b> Pre: </b> hCenter and Quantity must have a value and must be initialized<br>
     * <b> Pos: </b> returns a value total  <br>
     * @param hCenter != null
     * @param Quantity != null
     * @return ValorHC return a value total of price od material and quantity in a array
     */
    public static double[] TotalHC(double hCenter[],int Quantity[]){
    double[] ValorHC = new double[Quantity.length];
        for (int i = 0; i <ValorHC.length; i++) {
            ValorHC[i] = Quantity[i]*hCenter[i];
        }
    return ValorHC;
    }
    /**
     * method that calculate the total of each material
     * <b> Pre: </b> ValorFB and Quantity must have a value and must be initialized<br>
     * <b> Pos: </b> returns a value total  <br>
     * @param fBarrio
     * @param Quantity
     * @return ValorFB return a value total of price od material and quantity in a array
     */
    public static double[] TotalFB(double fBarrio[],int Quantity[]){
    double[] ValorFB = new double[Quantity.length];
        for (int i = 0; i <ValorFB.length; i++) {
            ValorFB[i] = Quantity[i]*fBarrio[i];
        }
    return ValorFB;
    }
    /**
     * method that calculate the total of each material
     * <b> Pre: </b> ValorFC and Quantity must have a value and must be initialized<br>
     * <b> Pos: </b> returns a value total  <br>
     * @param fCentro
     * @param Quantity
     * @return ValorFC return a value total of price od material and quantity in a array
     */
    public static double[] TotalFC(double fCentro[],int Quantity[]){
    double[] ValorFC = new double[Quantity.length];
        for (int i = 0; i <ValorFC.length; i++) {
            ValorFC[i] = Quantity[i]*fCentro[i];
        }
    return ValorFC;
    }
    /**
     * method that calculate the sum of alls the hardware store
     * <b> Pre: </b> THC, TFB, TFC, aux and total must have a value and must be initialized<br>
     * <b> Pos: </b> returns a value total of the work <br>
     * @param THC != null
     * @param TFB != null
     * @param TFC != null
     * @return a value total of the w
     */
    public static double ValorTotal(double[] THC, double[] TFB, double[] TFC){
        double total = 0;
        double aux = 0;
        for (int i = 0; i <THC.length; i++) {
            total = THC[i]+TFB[i]+TFC[i];
            aux = total+ aux;
        }
    return aux;
    }
    /**
     * method that sum the value total od hardware store with the addresses
     * <b> Pre: </b> direction, total and vtotal must have a value and must be initialized<br>
     * <b> Pos: </b> returns a value total of the work plus the address <br>
     * @param direction != null
     * @param total != null
     * @return vtotal return a total of work
     */
    public static double DirectionU(int direction, double total){
        double vtotal = 0;
        if (direction == 1){
            if(total<80000){
                vtotal = total + 120000; 
            }
            else if(total<300000){
                vtotal =total + 28000;
            }
            else if(total>=300000){
                vtotal= total;
            }
        }
        else if (direction == 2){
                if(total<80000){
                vtotal = total+ 50000;
                }
                else if(total>80000){
                    vtotal = total;
                }
            }
        else if(direction == 3){
                if(total<80000){
                vtotal = total+ 120000;
                }
                else if(total<300000){
                    vtotal = total + 55000;
                }
                else if(total>=300000){
                    vtotal = total;
                }
                }
    return vtotal;
    }
    /**
     * method that calculate the sum of constant, addresses and the hardware store
     * <b> Pre: </b> valorFinal and vtotal must be initialized<br>
     * <b> Pos: </b> returns a value total of the work with constant and address <br>
     * @param vtotal != null
     * @return valorFinal value total
     */
    public static double ValorFinal(double vtotal){
        double valorFinal = vtotal + ROUGH_CONSTRUCTION + FINAL_CONSTRUCTION + PAINTING;
        return valorFinal;
    }
    /**
     * method that calculate the best price of each material in each hardware store
     * <b> Pre: </b> hCenter, fBarrio, fCentro, Arreglo and Mvalor must be initialized<br>
     * <b> Pos: </b> return the best value of each material  <br>
     * @param hCenter != null
     * @param fBarrio != null
     * @param fCentro != null
     * @param Arreglo != null
     * @return Mvalor return the best price of a material specific
     */
    public static double[] Mejorprecio(double hCenter[], double fBarrio[], double fCentro[], String Arreglo[]){
        double[] Mvalor = new double[hCenter.length];
        for (int i = 0; i < hCenter.length; i++) {
            if(hCenter[i]<fCentro[i] && hCenter[i]<fBarrio[i]){
                Mvalor[i] = hCenter[i];
            }
            else if(fCentro[i]<hCenter[i] && fCentro[i]<fBarrio[i]){
                Mvalor[i] = fCentro[i];
            }
            else{
                Mvalor[i] = fBarrio[i];
            }
        }
    return Mvalor;
    }
    /**
     * method that calculate the best hardware store for each material 
     * <b> Pre: </b> hCenter, fBarrio, fCentro, Arreglo and lugar must be initialized<br>
     * <b> Pos: </b> return the best hardware for each material  <br>
     * @param hCenter != null
     * @param fBarrio != null
     * @param fCentro != null
     * @param Arreglo != null
     * @return lugar return a string of words 
     */
    public static String[] MejorLugar(double hCenter[], double fBarrio[], double fCentro[], String Arreglo[]){
        String[] lugar = new String[Arreglo.length];
        for (int i = 0; i < hCenter.length; i++) {
            if(hCenter[i]<fCentro[i] && hCenter[i]<fBarrio[i]){
                lugar[i] = "HomeCenter";
            }
            else if(fCentro[i]<hCenter[i] && fCentro[i]<fBarrio[i]){
                lugar[i] = "Ferreteria del Centro";
            }
            else{
                lugar[i] = "Ferreteria del Barrio";
            }
        }
    return lugar;
    }
    /**
     * method that calculate the value total of the best prices
     * <b> Pre: </b>  Mvalor, totalMPrecios and aux must be initialized<br>
     * <b> Pos: </b> return the total of best prices in a double  <br>
     * @param Mvalor != null and >0
     * @return totalMPrecios return a value total in a double
     */
    public static double totalMPrecios(double Mvalor[]){
        double totalMPrecios = 0;
        double aux = 0;
        for (int i = 0; i < Mvalor.length; i++) {
            aux = totalMPrecios + Mvalor[i];
            totalMPrecios = aux; 
        }
    return totalMPrecios;
    }
}