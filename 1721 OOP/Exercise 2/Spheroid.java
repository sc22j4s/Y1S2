import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Math;
import java.nio.file.AccessDeniedException;

class Spheroid{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter equatorial radius in km: ");
        double equatorial = input.nextDouble();
        System.out.print("Enter polar radius in km: ");
        double polar = input.nextDouble();

        
        double calc = 1 - (Math.pow(polar, 2) / Math.pow(equatorial,2));       
        double Eccentricity = Math.sqrt(calc);
        
        double ecc = (double)Math.sqrt(1 - (Math.pow(polar, 2) / Math.pow(equatorial, 2)));


        double vol = (4 * 3.14 * Math.pow(equatorial,2) * polar) / (3);
        //double ecc = Math.sqrt(6);

        System.out.printf("Eccentricity = %.2f\n", Eccentricity);

        System.out.printf("Volume = %g cubic km\n", vol);
        
        
    
    }
}