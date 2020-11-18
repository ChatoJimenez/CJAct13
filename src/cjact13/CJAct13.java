/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cjact13;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesgu
 */
public class CJAct13 {

    //Colores para el texto
    public static String red="\033[31m";   
    public static String b="\033[34m";  
    public static String r="\u001B[0m";
    //Declaración de la lista
    static List<String> lista = new ArrayList<>();
    
    public static void main(String[] args) {
        lista.add("Hola");
        lista.add("Onomatopeya");
        lista.add("Ave");
        lista.add("Herradura");
        lista.add("Caramelo");
        lista.add("Buscar");
        lista.add("Robot");
        lista.add("Monasterio");
        lista.add("Iguana");
        lista.add("Programa");
        
        System.out.println(red+"Lista sin ordenar:"+r);
        //Impresión de la lista por medio de expresión Lambda
        lista.forEach(value -> System.out.println(value));

        //Expresión Lambda (Alfabéticamente)
        lista.sort((String s1, String s2) -> s1.compareTo(s2));
        System.out.println(b+"\nExpresión Lambda - Orden Alfabético:"+r);
        lista.forEach(str -> System.out.println(str));
        
        
        
        //Expresión Lambda (Longitud)
        lista.sort((String o1, String o2) -> {
            int result;
            if (o1.length()>o2.length()){
                result = 1;
            } else if (o1.length()<o2.length()){
                result = -1;
            } else {
                result = 0;
            }
            return result;
        });
        System.out.println(b+"\nExpresión Lambda - Orden Por Longitud:"+r);
        lista.forEach(str -> System.out.println(str));

        //Referencias de la interfaz funcional con los métodos estáticos
        OrderList longitud = CJAct13::ordenarPorLong;
        OrderList alfabetico = CJAct13::ordenarAlf;
                
        //Método de Referencia (Alfabéticamente)
        alfabetico.order(lista);
        System.out.println(b+"\nMétodo de Referencia - Orden Alfabético:"+r);
        lista.forEach(str -> System.out.println(str));
        
        //Método de Referencia (Longitud)
        longitud.order(lista);
        System.out.println(b+"\nMétodo de Referencia - Orden Por Longitud:"+r);
        lista.forEach(str -> System.out.println(str));

        
        //Declaración de clase anónima
        AnonClass anon = new AnonClass(){
            @Override
            public void ordenarPorLong(List<String> lista){
                lista.sort((String o1, String o2) -> {
                int result;
                if (o1.length()>o2.length()){
                    result = 1;
                } else if (o1.length()<o2.length()){
                    result = -1;
                } else {
                    result = 0;
                }
                return result;
                });
            }
            @Override
            public void ordenarAlf(List<String>lista){
                lista.sort((String s1, String s2) -> s1.compareTo(s2));
            }
        };
                
        //Clase Anónima (Alfabéticamente)
        anon.ordenarAlf(lista);
        System.out.println(b+"\nClase Anónima - Orden Alfabético:"+r);
        lista.forEach(str -> System.out.println(str));
        
        //Clase Anónima (Longitud)
        anon.ordenarPorLong(lista);
        System.out.println(b+"\nClase Anónima - Orden Por Longitud:"+r);
        lista.forEach(str -> System.out.println(str));
    }
    
    public static void ordenarPorLong(List<String> lista){
        lista.sort((String o1, String o2) -> {
            int result;
            if (o1.length()>o2.length()){
                result = 1;
            } else if (o1.length()<o2.length()){
                result = -1;
            } else {
                result = 0;
            }
            return result;
        });
    }
    
    public static void ordenarAlf(List<String>lista){
        lista.sort((String s1, String s2) -> s1.compareTo(s2));
    }
    
    @FunctionalInterface
    interface OrderList {
        void order(List<String> lista);
    }
    
    
    interface AnonClass{
        public void ordenarPorLong(List<String> lista);
        public void ordenarAlf(List<String>lista);
    }
    
}
