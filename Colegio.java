package Clase6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Colegio {

    public static void main(String args[]) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        List<Profesor> listaProfesores = new ArrayList<>();
        List<Alumno> listaAlumnos = new ArrayList<>();
        List<Persona> listaPersonas = new ArrayList<>();

        Persona profe1 = new Profesor();
        Persona profe2 = new Profesor("Juan Perez",488,"Quimica",15000);

        listaPersonas.add(profe1);
        listaPersonas.add(profe2);

        Persona a1 = new Alumno("Ana Martinez",123456);
        Alumno a2 = new Alumno("Andres Gonzales",222, "Informatica");

        for (Persona profesor:listaPersonas){
            System.out.println(profesor);
        }


        listaAlumnos.add((Alumno) a1);
        listaAlumnos.add(a2);

        mostrarListaAlumnos(listaAlumnos);

        System.out.println("***** Lista de alumnos***");
        boolean encontrarNombre=false;

        //foreach para Alumnos
        for (Alumno alumno:listaAlumnos){
            if (alumno.getNombre().contains("Andres")){
                encontrarNombre=true;
            }
        }

        if (encontrarNombre == true){
            System.out.println("**** ENCONTRE EL NOMBRE BUSCADO **** ");
        } else {
            System.out.println("**** El nombre no esta en la lista!! ****");
        }



        System.out.println("Cuantos alumnos quiere ingresar?");
        int cantidad = input.nextInt();

        System.out.println("Ingrese " + cantidad +" alumnos");
        for (int i = 0 ; i < cantidad ; i++ ){

            Alumno alumnoNuevo = crearAlumno();
            listaAlumnos.add(alumnoNuevo);
            System.out.println("Se ha agregado a "+ alumnoNuevo.getNombre() + " al sistema");
        }

        mostrarListaAlumnos(listaAlumnos);

        boolean nroValido=false;
        int index=-1;
        while (nroValido == false) {
            System.out.println("Ingrese numero de estudiante a eliminar: ");
            int eliminar = input.nextInt();
            //validar si existe el numero a borrar
            for (Alumno estudiante : listaAlumnos) {
                if (estudiante.getNroEstudiante() == eliminar) {
                    nroValido = true;
                }
            }
            //si existe, hacer index = indice del estudiante con el numero a borrar, sino preguntar por numero de nuevo
            if (nroValido == true) {
                for (Alumno estudiante : listaAlumnos) {
                    if (estudiante.getNroEstudiante() == eliminar) {
                        System.out.println("Se proce a  eliminar a..."+estudiante.getNombre()+" con numero "+estudiante.getNroEstudiante());
                        index = listaAlumnos.indexOf(estudiante);
                    }
                }
            } else {
                System.out.println("El número " + eliminar + " no está en la lista!! los numeros disponibles son los siguientes");
                for (Alumno estudiante : listaAlumnos){
                    System.out.println(estudiante.getNombre()+" "+estudiante.getNroEstudiante());
                }
            }
        }

        listaAlumnos.remove(index);
        mostrarListaAlumnos(listaAlumnos);
    }



    //metodo mostrar lista de alumnos
    public static void mostrarListaAlumnos(List<Alumno> unaLista){
        for (Alumno estudiante : unaLista){
            System.out.println(estudiante);
        }
    }

    //metodo CrearAlumno
    public static Alumno crearAlumno() {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el nombre del alumno");
        String nombre = input.next();

        System.out.println("Ingrese el DNI del alumno");
        int dni = input.nextInt();

        System.out.println("Ingrese el curso del alumno");
        String curso = input.next();
        Alumno alumnoNuevo = new Alumno(nombre, dni, curso);

        return alumnoNuevo;
    }
}
