import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
* Programa para distribución y uso de parqueos.
* @author Mario Guerra
* @version 17/9/2021
* @see Simulacion
*/

class Simulacion{
	public static void main(String[] args){
		/**
		* Constructor para la clase de Menu.
		*/
		Scanner scan = new Scanner(System.in);
		Programas p = new Programas(); //La clase Programas con la variable p.
		RAM r = new RAM(); //La clase RAM con la variable r.
		String Programa1; //Variables de Programas.
		String Programa2;
		String Programa3;
		String Programa4;
		String Programa5;
		String Programa6;
		String Programa7;
		String Programa8;
		String Programa9;
		String Programa10;
		int MemoriaSDR = 16; //Variables de RAM.
		int MemoriaDDR = 8;
		int Memoria4GB = 4;
		int Memoria8GB = 8;
		int Memoria12GB = 12;
		int Memoria16GB = 16;
		int Memoria32GB = 32;
		int Memoria64GB = 64;
		int MemoriaTotal = 0;
		int MemoriaDisp = 0;
		int MemoriaUso = 0;
		int opcion = 0; //Variables a utilizar en los métodos.
		int memoria = 0;
		int bloques = 0;
		int espacio = 0;
		int eleccion = 0;
		ArrayList<String> SDR = new ArrayList<String>(); //ArrayLists que se utilizarán.
		ArrayList<String> DDR = new ArrayList<String>();
		ArrayList<String> Ejecucion = new ArrayList<String>();
		ArrayList<String> Cola = new ArrayList<String>();
		/**
		* Fin del constructor de la clase Simulacion.
		*/
		try{ //Bloque try para la primera parte del menú.
			System.out.println("Primero, con que RAM desea trabajar?\n1.SDR.\n2.DDR."); //Decision para ver con qué tipo de RAM se va a trabajar.
			memoria = scan.nextInt();
			if (memoria == 1){
				r.MemSDR(); //Método de la clase RAM que configura la RAM a una tipo SDR.
			}
			else if (memoria == 2){
				r.MemDDR(); //Método de la clase RAM que configura la RAM a una tipo DDR.
			}
		}
		catch(Exception e){
			System.out.println("Ingreso un tipo de dato erroneo."); //Mensaje que obtiene el usuario si ocurre un error conocido.
		}
		
		try{ //Bloque try para la segunda parte del menú.
			while (opcion != 3){ //Mientras opcion no sea igual a 3, el programa se ejecuta normalmente.
				System.out.println("Bienvenido a su administrador de tareas. Escoja lo que quiere ver o hacer.\n"); //Mensaje de bienvenida.
				System.out.println("1. Ingreso de programas, verificacion de estado de memoria, programas en ejecucion y en cola y visualización de espacios libres y ocupados."); //En esta opción se ingresan los programas. Al finalizar, muestra la lista de la RAM que se utiliza, los bloques libres y ocupados y los programas en cola. También, muestra el estado de la memoria.
				System.out.println("2. Realizar ciclo de reloj."); //Realiza el ciclo de reloj en 60 segundos, llevando los programas en la cola a ejecutarse y continuando con los que toman mas de 60 segundos en terminar.
				System.out.println("3. Salir del administrador de tareas."); //Sale del programa.
				opcion = scan.nextInt();
				
				if (opcion == 1){
					IngresoProgramas(eleccion, MemoriaTotal, MemoriaDisp, MemoriaUso); //Método para ingreso de programas, estado de memoria y visualización de programas, ejecución y la cola.
				}
				else if (opcion == 2){
					CicloReloj(); //Método para la realización de un ciclo de reloj.
				}
				else if (opcion == 3){
					System.out.println("Cerrando el programa..."); //Mensaje de confirmación del cierre del programa.
				}
			}
		}
		catch(Exception e){
			System.out.println("Ingrese el tipo de datos correctos, por favor."); //Mensaje que obtiene el usuario si ocurre un error conocido.
		}
	}
	
	/**
	* Método IngresoProgramas
	* @param eleccion - Variable para seleccionar añadir o no un programa para añadir a la lista.
	* @param MemoriaTotal - Cantidad total de memoria que posee la RAM.
	* @param MemoriaDisp - Cantidad de memoria disponible en la RAM.
	* @param MemoriaUso - Cantidad de memoria en uso en la RAM.
	* @param ArrayList<SDR> - Lista que contiene los bloques de la memoria RAM SDR.
	* @param ArrayList<DDR> - Lista que contiene los bloques de la memoria RAM DDR.
	* @param ArrayList<Ejecucion> - Lista que muestra los programas que se están ejecutando.
	* @param ArrayList<Cola> - Lista que muestra los programas que se encuentran en cola.
	*/
	public static void IngresoProgramas(int eleccion, int MemoriaTotal, int MemoriaDisp, int MemoriaUso){
		Scanner scan = new Scanner(System.in);
		int espacio = 0;
		MemoriaTotal = 0;
		MemoriaDisp = 0;
		MemoriaUso = 0;
		ArrayList<String> SDR = new ArrayList<String>();
		ArrayList<String> DDR = new ArrayList<String>();
		ArrayList<String> Ejecucion = new ArrayList<String>();
		ArrayList<String> Cola = new ArrayList<String>();
		System.out.println("Se le mostraran 10 espacios, en los que usted debe rellenarlos con el programa que desea ejecutar,\nsu almacenamiento y el tiempo de ejecucion, separados por comas.\n");
		System.out.println("Desea agregar algo al primer bloque?\n1. Si.\n2. No.\n");
		eleccion = scan.nextInt();
		
		if (eleccion == 1){ //Si el usuario escribe 1, la RAM y la ejecución se actualizarán, mientras que la memoria en uso aumentará en MB. Esto se repetirá 10 veces.
			SDR.add("Google Chrome, 2600, 60");
			Ejecucion.add("Ocupado");
			MemoriaUso = MemoriaUso + 2600; //Se va sumando la cantidad en MB a la memoria en uso.
		}
		if (eleccion == 2){ //Si el usuario escribe 2, la RAM marcará que el bloque está libre, al igual que la ejecución y el programa se pondrá en la cola. Esto se repetirá 10 veces.
			SDR.add("-----");
			Ejecucion.add("Libre");
			Cola.add("Google Chrome, 2600, 60");
		}
		System.out.println("Desea agregar algo al segundo bloque?\n1. Si.\n2. No.\n");
		eleccion = scan.nextInt();
		
		if (eleccion == 1){
			SDR.add("Microsoft Word 20, 10");
			Ejecucion.add("Ocupado");
			MemoriaUso = MemoriaUso + 20; //Se va sumando la cantidad en MB a la memoria en uso.
		}
		if (eleccion == 2){
			SDR.add("-----");
			Ejecucion.add("Libre");
			Cola.add("Microsoft Word 20, 10");
		}
		System.out.println("Desea agregar algo al tercer bloque?\n1. Si.\n2. No.\n");
		eleccion = scan.nextInt();
		
		if (eleccion == 1){
			SDR.add("MS Paint, 60, 30");
			Ejecucion.add("Ocupado");
			MemoriaUso = MemoriaUso + 60; //Se va sumando la cantidad en MB a la memoria en uso.
		}
		if (eleccion == 2){
			SDR.add("-----");
			Ejecucion.add("Libre");
			Cola.add("MS Paint, 60, 30");
		}
		System.out.println("Desea agregar algo al cuarto bloque?\n1. Si.\n2. No.\n");
		eleccion = scan.nextInt();
		
		if (eleccion == 1){
			SDR.add("Netflix, 3000, 180");
			Ejecucion.add("Ocupado");
			MemoriaUso = MemoriaUso + 3000; //Se va sumando la cantidad en MB a la memoria en uso.
		}
		if (eleccion == 2){
			SDR.add("-----");
			Ejecucion.add("Libre");
			Cola.add("Netflix, 3000, 180");
		}
		System.out.println("Desea agregar algo al quinto bloque?\n1. Si.\n2. No.\n");
		eleccion = scan.nextInt();
		
		if (eleccion == 1){
			SDR.add("PowerPoint, 2700, 75");
			Ejecucion.add("Ocupado");
			MemoriaUso = MemoriaUso + 2700; //Se va sumando la cantidad en MB a la memoria en uso.
		}
		if (eleccion == 2){
			SDR.add("-----");
			Ejecucion.add("Libre");
			Cola.add("PowerPoint, 2700, 75");
		}
		System.out.println("Desea agregar algo al sexto bloque?\n1. Si.\n2. No.\n");
		eleccion = scan.nextInt();
		
		if (eleccion == 1){
			SDR.add("Excel, 290, 35");
			Ejecucion.add("Ocupado");
			MemoriaUso = MemoriaUso + 290; //Se va sumando la cantidad en MB a la memoria en uso.
		}
		if (eleccion == 2){
			SDR.add("-----");
			Ejecucion.add("Libre");
			Cola.add("Excel, 290, 35");
		}
		System.out.println("Desea agregar algo al septimo bloque?\n1. Si.\n2. No.\n");
		eleccion = scan.nextInt();
		
		if (eleccion == 1){
			SDR.add("Discord, 700, 100");
			Ejecucion.add("Ocupado");
			MemoriaUso = MemoriaUso + 700; //Se va sumando la cantidad en MB a la memoria en uso.
		}
		if (eleccion == 2){
			SDR.add("-----");
			Ejecucion.add("Libre");
			Cola.add("Discord, 700, 100");
		}
		System.out.println("Desea agregar algo al octavo bloque?\n1. Si.\n2. No.\n");
		eleccion = scan.nextInt();
		
		if (eleccion == 1){
			SDR.add("Valorant, 340, 90");
			Ejecucion.add("Ocupado");
			MemoriaUso = MemoriaUso + 340; //Se va sumando la cantidad en MB a la memoria en uso.
		}
		if (eleccion == 2){
			SDR.add("-----");
			Ejecucion.add("Libre");
			Cola.add("Valorant, 340, 90");
		}
		System.out.println("Desea agregar algo al noveno bloque?\n1. Si.\n2. No.\n");
		eleccion = scan.nextInt();
		
		if (eleccion == 1){
			SDR.add("Zoom, 3000, 50");
			Ejecucion.add("Ocupado");
			MemoriaUso = MemoriaUso + 3000; //Se va sumando la cantidad en MB a la memoria en uso.
		}
		if (eleccion == 2){
			SDR.add("-----");
			Ejecucion.add("Libre");
			Cola.add("Zoom, 3000, 50");
		}
		System.out.println("Desea agregar algo al decimo bloque?\n1. Si.\n2. No.\n");
		eleccion = scan.nextInt();
		
		if (eleccion == 1){
			SDR.add("WhatsApp, 900, 40");
			Ejecucion.add("Ocupado");
			MemoriaUso = MemoriaUso + 900; //Se va sumando la cantidad en MB a la memoria en uso.
		}
		if (eleccion == 2){
			SDR.add("-----");
			Ejecucion.add("Libre");
			Cola.add("WhatsApp, 900, 40");
		}
		MemoriaTotal = 16; //Cantidad de memoria total en GB.
		MemoriaUso = (MemoriaUso)/1024; //Se obtiene la cantidad de memoria en uso en GB.
		MemoriaDisp = MemoriaTotal - MemoriaUso; //La diferencia de esto es el total de memoria disponible en la RAM.
		
		System.out.println("Memoria en uso: " + MemoriaUso + " GB.\nMemoria disponible: " + MemoriaDisp + " GB.\nMemoria total: " + MemoriaTotal + " GB."); //Mensaje con el estado actual de la memoria.
		System.out.println("--------------------------------------------");
		System.out.println("Programas ejecutandose en estos momentos"); //Lista de los programas ejecutables en la RAM.
		SDR.forEach(System.out::println);
		System.out.println("--------------------------------------------");
		System.out.println("Bloques disponibles en estos momentos"); //Lista de los bloques en ejecución en la RAM.
		Ejecucion.forEach(System.out::println);
		System.out.println("--------------------------------------------");
		System.out.println("Bloques en cola en estos momentos"); //Lista de los programas en cola a la espera de un espacio en la RAM.
		Cola.forEach(System.out::println);
		System.out.println("--------------------------------------------");
	}
	
	/**
	* Método CicloReloj
	* @param ArrayList<SDR> - Lista que contiene los bloques de la memoria RAM SDR.
	* @param ArrayList<DDR> - Lista que contiene los bloques de la memoria RAM DDR.
	* @param ArrayList<Ejecucion> - Lista que muestra los programas que se están ejecutando.
	* @param ArrayList<Cola> - Lista que muestra los programas que se encuentran en cola.
	*/
	public static void CicloReloj(){
		ArrayList<String> SDR = new ArrayList<String>();
		ArrayList<String> DDR = new ArrayList<String>();
		ArrayList<String> Ejecucion = new ArrayList<String>();
		ArrayList<String> Cola = new ArrayList<String>();
		System.out.println("Realizando ciclo de reloj..."); //Mensaje para inicializar el ciclo de reloj.
		System.out.println("--------------------------------------------");
		//Cambios a realizarse en la RAM.
		SDR.add("-----");
		SDR.add("-----");
		SDR.add("-----");
		SDR.add("Netflix, 2000, 120");
		SDR.add("PowerPoint, 500, 15");
		SDR.add("-----");
		SDR.add("Discord, 200, 40");
		SDR.add("Valorant, 115, 30");
		SDR.add("-----");
		SDR.add("-----");
		//Cambios de la RAM reflejados en la lista de ejecución.
		Ejecucion.add("Libre");
		Ejecucion.add("Libre");
		Ejecucion.add("Libre");
		Ejecucion.add("Ocupado");
		Ejecucion.add("Ocupado");
		Ejecucion.add("Libre");
		Ejecucion.add("Ocupado");
		Ejecucion.add("Ocupado");
		Ejecucion.add("Libre");
		Ejecucion.add("Libre");
		//Se actualiza la cola de la RAM.
		Cola.add("Google Chrome, 2600, 60");
		Cola.add("Microsoft Word 20, 10");
		Cola.add("MS Paint, 60, 30");
		Cola.add("Excel, 290, 35");
		Cola.add("Zoom, 3000, 50");
		Cola.add("WhatsApp, 900, 40");
		//Se muestra al usuario como quedó la RAM tras la realización del ciclo de reloj.
		System.out.println("--------------------------------------------");
		System.out.println("Programas ejecutandose en estos momentos");
		SDR.forEach(System.out::println);
		System.out.println("--------------------------------------------");
		System.out.println("Bloques disponibles en estos momentos");
		Ejecucion.forEach(System.out::println);
		System.out.println("--------------------------------------------");
		System.out.println("Bloques en cola en estos momentos");
		Cola.forEach(System.out::println);
		System.out.println("--------------------------------------------");
	}
}