package org.example;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class HTTPServer {

    static HashMap<String, Method> components = new HashMap<String, Method>();

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        //1
        //Cargar los componentes anotados con @Component
        //Para el primer prototipo los leeré de la línea de comandos
        //Para la entrega final lo deben leer del disco


        Class c = Class.forName(args[0]);
        if (c.isAnnotationPresent(Component.class)) {
            //2
            //Almacenar todos lo métodos en una estructura <key,value>
            //la llave el path del web service y el valor son métodos
            //ojo, todos lo métodos son estatícos
            for (Method m : c.getMethods()) {
                if (m.isAnnotationPresent(GetMapping.class)) {
                    try {
                        System.out.println(m.getAnnotation(GetMapping.class).value());
                        components.put(m.getAnnotation(GetMapping.class).value(), m);

                    } catch (Throwable ex) {
                        ex.printStackTrace();

                    }
                }
            }
        }

        //3.
        //Si lla una ruta que está enlazada un componente
        //Ejecute el componente
        //No olvide los encabezados
        //implemente pasar parametros

        String pathGet = "/components/hello";
        Method m = components.get(pathGet.substring(11));
        if(m != null){
            System.out.println("Iniciando el Método");
            System.out.println(m.invoke(null));
        }

    }

}
