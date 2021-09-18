import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
* Clase para los distintos tipos de RAM.
* @author Mario Guerra
* @version 17/09/2021
* @see RAM
*/

class RAM{
	/**
	* Constructor para la clase de RAM.
	*/
	Scanner scan = new Scanner(System.in);
	String Programa1; //Variables de la clase Programas.
	String Programa2;
	String Programa3;
	String Programa4;
	String Programa5;
	String Programa6;
	String Programa7;
	String Programa8;
	String Programa9;
	String Programa10;
	private int MemoriaSDR = 16; //Variables a utilizar en los métodos de la clase.
	private int MemoriaDDR = 8;
	private int Memoria4GB = 4;
	private int Memoria8GB = 8;
	private int Memoria12GB = 12;
	private int Memoria16GB = 16;
	private int Memoria32GB = 32;
	private int Memoria64GB = 64;
	private int bloques = 0;
	private int espacio = 0;
	ArrayList<String> SDR = new ArrayList<String>(); //ArrayLists a usar.
	ArrayList<String> DDR = new ArrayList<String>();
	/**
	* Fin del constructor para la clase de RAM.
	*/
	
	/**
	* Método MemSDR
	*/
	public void MemSDR(){
		Scanner scan = new Scanner(System.in);
		bloques = MemoriaSDR * MemoriaSDR; //Multiplicación para obtener el número de bloques.
		System.out.println("La cantidad de bloques de esta memoria es de " + bloques + " bloques."); //Mensaje que imprime la cantidad de bloques en la memoria de tipo SDR.
		SDR.add(Programa1); //Agrega las variables de los programas a la lista SDR.
		SDR.add(Programa2);
		SDR.add(Programa3);
		SDR.add(Programa4);
		SDR.add(Programa5);
		SDR.add(Programa6);
		SDR.add(Programa7);
		SDR.add(Programa8);
		SDR.add(Programa9);
		SDR.add(Programa10);
	}
	
	/**
	* Método MemDDR
	*/
	public void MemDDR(){
		try{ //Bloque try para encontrar excepciones en el método.
			Scanner scan = new Scanner(System.in);
			System.out.println("Elija la cantidad de memoria que quiere para su RAM.\n1.4GB.\n2.8GB.\n3.12GB.\n4.16GB.\n5.32GB.\n6.64GB.\n7.Quiero una SDR."); //Listado para adaptar la memoria DDR.
			espacio = scan.nextInt();
			
			if (espacio == 1){
				bloques = MemoriaDDR * Memoria4GB; //Multiplicación para obtener el número de bloques.
				System.out.println("La cantidad de bloques de esta memoria es de " + bloques + " bloques."); //Mensaje que imprime la cantidad de bloques en la memoria de tipo DDR de 4GB.
			}
			if (espacio == 2){
				bloques = MemoriaDDR * Memoria8GB; //Multiplicación para obtener el número de bloques.
				System.out.println("La cantidad de bloques de esta memoria es de " + bloques + " bloques."); //Mensaje que imprime la cantidad de bloques en la memoria de tipo DDR de 8GB.
			}
			if (espacio == 3){
				bloques = MemoriaDDR * Memoria12GB; //Multiplicación para obtener el número de bloques.
				System.out.println("La cantidad de bloques de esta memoria es de " + bloques + " bloques."); //Mensaje que imprime la cantidad de bloques en la memoria de tipo DDR de 12GB.
			}
			if (espacio == 4){
				bloques = MemoriaDDR * Memoria16GB; //Multiplicación para obtener el número de bloques.
				System.out.println("La cantidad de bloques de esta memoria es de " + bloques + " bloques."); //Mensaje que imprime la cantidad de bloques en la memoria de tipo DDR de 16GB.
			}
			if (espacio == 5){
				bloques = MemoriaDDR * Memoria32GB; //Multiplicación para obtener el número de bloques.
				System.out.println("La cantidad de bloques de esta memoria es de " + bloques + " bloques."); //Mensaje que imprime la cantidad de bloques en la memoria de tipo DDR de 32GB.
			}
			if (espacio == 6){
				bloques = MemoriaDDR * Memoria64GB; //Multiplicación para obtener el número de bloques.
				System.out.println("La cantidad de bloques de esta memoria es de " + bloques + " bloques."); //Mensaje que imprime la cantidad de bloques en la memoria de tipo DDR de 64GB.
			}
			if (espacio == 7){ //Por si se decide por usar una memoria de tipo SDR.
				bloques = MemoriaSDR * MemoriaSDR; //Multiplicación para obtener el número de bloques.
				System.out.println("La cantidad de bloques de esta memoria es de " + bloques + " bloques."); //Mensaje que imprime la cantidad de bloques en la memoria de tipo SDR.
			}
			DDR.add(Programa1); //Agrega los programas a ambas listas.
			DDR.add(Programa2);
			DDR.add(Programa3);
			DDR.add(Programa4);
			DDR.add(Programa5);
			DDR.add(Programa6);
			DDR.add(Programa7);
			DDR.add(Programa8);
			DDR.add(Programa9);
			DDR.add(Programa10);
			SDR.add(Programa1);
			SDR.add(Programa2);
			SDR.add(Programa3);
			SDR.add(Programa4);
			SDR.add(Programa5);
			SDR.add(Programa6);
			SDR.add(Programa7);
			SDR.add(Programa8);
			SDR.add(Programa9);
			SDR.add(Programa10);
		}
		catch(Exception e){
			System.out.println("Dato no permitido por el sistema, intente de nuevo."); //Mensaje que se muestra al usuario por si encuentra un error conocido.
		}
	}
}