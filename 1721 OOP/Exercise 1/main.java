import java.util.Scanner;
import java.lang.Math;


class main{
    public static void main(String[] args){
        System.out.print("Enter weight in kg: \n");
        Scanner inp = new Scanner(System.in);
        double kg_weight = inp.nextDouble();

        int pounds = (int)Math.floor(kg_weight*2.205);

        
        // remainer of pounds
        double ounces = ((kg_weight*2.205) % 1) * 16;

        System.out.println("Weight in freedom units is " + pounds + "lb and " + Math.round(ounces) + "oz.");

                
        
    }
}