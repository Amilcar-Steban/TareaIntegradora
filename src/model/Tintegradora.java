package model;

import java.util.Scanner;
public class Tintegradora {
    private static int ROUGH_CONSTRUCTION = 1300000;
    private static int FINAL_CONSTRUCTION = 2600000;
    private static int PAINTING = 980000;
    
    public static double[] TotalHC(double hCenter[],int Quantity[]){
    double[] ValorHC = new double[Quantity.length];
        for (int i = 0; i <ValorHC.length; i++) {
            ValorHC[i] = Quantity[i]*hCenter[i];
        }
    return ValorHC;
    }
    public static double[] TotalFB(double fBarrio[],int Quantity[]){
    double[] ValorFB = new double[Quantity.length];
        for (int i = 0; i <ValorFB.length; i++) {
            ValorFB[i] = Quantity[i]*fBarrio[i];
        }
    return ValorFB;
    }
    public static double[] TotalFC(double fCentro[],int Quantity[]){
    double[] ValorFC = new double[Quantity.length];
        for (int i = 0; i <ValorFC.length; i++) {
            ValorFC[i] = Quantity[i]*fCentro[i];
        }
    return ValorFC;
    }
    public static double ValorTotal(double[] THC, double[] TFB, double[] TFC){
        double total = 0;
        double aux = 0;
        for (int i = 0; i <THC.length; i++) {
            total = THC[i]+TFB[i]+TFC[i];
            aux = total+ aux;
        }
    return aux;
    }
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
    public static double ValorFinal(double vtotal){
        double valorFinal = vtotal + ROUGH_CONSTRUCTION + FINAL_CONSTRUCTION + PAINTING;
        return valorFinal;
    }
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