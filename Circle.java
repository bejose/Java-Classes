import java.util.Scanner;
/*Program that calculates the areas and the perimeters 
 *of the excircle and the incivle of a given rectangle
 */
public class Circle
{
    public static void main (String [] args)
    {

        Scanner scan = new Scanner (System.in);
        System.out.println ("This program calculates the areas " + "and the perimeters of the excircle and the incircle "
            + "of a given rectangle");
        System.out.print("Please enter the two coordinates of the " + "left-upper point of the rectangle");
        int leftUpX = scan.nextInt();
        int leftUpY = scan.nextInt();
        System.out.print("Please enter the two coordinates of the " + "right-downer point of the rectangle");
        int rightDownX = scan.nextInt();
        int rightDownY = scan.nextInt();

        double inRadius = (leftUpY - rightDownY) / 2; //calculates the radius of the incircle
        double inArea = Math.PI * Math.pow( inRadius, 2 ); //calculates the area of the incircle
        double inPerimeter = 2 * Math.PI * inRadius; //calculates the perimeter of the incircle

        double exHypotenuse = Math.sqrt( Math.pow((leftUpX - rightDownX), 2) + Math.pow((leftUpY - rightDownY), 2) );
        double exRadius = exHypotenuse / 2; //and above calculates the radius of the excircle
        double exArea = Math.PI * Math.pow( exRadius, 2 ); //calculates the area of the excircle
        double exPerimeter = 2 * Math.PI * exRadius; //calculates the perimeter of the excircle

        System.out.println("Incircle: radius = " + inRadius + ", area = "+inArea+", perimeter = "+inPerimeter);
        System.out.println("Excircle: radius = " + exRadius + ", area = "+exArea+", perimeter = "+exPerimeter);

    }
}
