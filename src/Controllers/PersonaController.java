package Controllers;
import Models.Persona;
/**
 * Controlador para manejar la lógica de operaciones sobre arrays de Carross.
 * 
 * 
 * Generar los metdoos necesarions para ordenar un array de personas por edad en
 * orden descendente
 * y para la busqueda binaria de una persona por edad.
 * 
 */
public class PersonaController {
    public Persona[] edadSeleccion(Persona[] listaPersona){
        int indice;
        for (int i = 0; i < listaPersona.length-1; i++) {
            indice = i;
            for (int j = i+1; j < listaPersona.length; j++) {
                if(listaPersona[j].getEdad() > listaPersona[indice].getEdad()){
                    indice = j;
                }
            }
            Persona temp = listaPersona[i];
            listaPersona[i] = listaPersona[indice];
            listaPersona[indice] = temp;
        }
        return listaPersona;
    }

    public int busquedaEdad(Persona[] listPersonas, int edad){
        int inicio = 0;
        int fin = listPersonas.length-1;
        int medio;
        while(inicio <= fin){
            medio = inicio+(fin-inicio)/2;
            if(listPersonas[medio].getEdad() == edad){
                System.out.println("Persona encontrada en la posicion: "+medio
                +"; Datos: "+listPersonas[medio]);
                return medio;
            }
            if(listPersonas[medio].getEdad() > edad){
                inicio = medio+1;
            }else{
                fin = medio-1;
            }
        }
        System.out.println("La edad: "+edad+" ,no se necuentra en la lista");
        return -1;
    }

    public Persona[] nombreInsercion(Persona[] listaPersona){
        int j;
        for (int i = 1; i < listaPersona.length; i++) {
            Persona aux = listaPersona[i];
            j = i-1;
            while(j >=0 && listaPersona[j].getNombre().compareTo(aux.getNombre()) >0){
                listaPersona[j+1] = listaPersona[j];
                j--;
            }
            listaPersona[j+1] = aux;
        }
        return listaPersona;
    }

    public int busquedaNombre(Persona[] listPersonas, String nombre){
        int inicio = 0;
        int fin = listPersonas.length-1;
        int medio;
        while(inicio <= fin){
            medio = inicio+(fin-inicio)/2;
            int comparacion = listPersonas[medio].getNombre().compareTo(nombre);
            if(comparacion == 0){
                System.out.println("Persona encontrada en la posicion: "+medio
                +"; Datos: "+listPersonas[medio]);
                return medio;
            }
            if(comparacion < 0){
                inicio = medio+1;
            }else{
                fin = medio-1;
            }
        }
        System.out.println("El nombre: "+nombre+" ,no se necuentra en la lista.");
        return -1;
    }
}
