package main;

import videoclub.dao.modelo.*;
import videoclub.servicios.ServiciosVideoclub;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamsVideoClub {
    ServiciosVideoclub sv = new ServiciosVideoclub();
    List<Socio> socios = sv.getTodosLosSocios();
    List<Producto> productos = sv.getTodosProductos();
    List<Pelicula> peliculas = sv.getTodasPeliculas();
    List<Videojuego> videojuegos = sv.getTodosVideoJuegos();

    public void numeroSociosSancionados() {
        System.out.println(socios.stream().filter(Socio::isSancionado).count());
    }

    public void mediaEdadDeSociosSancionados() {
        System.out.println(socios.stream()
            .filter(Socio::isSancionado)
            .mapToInt(Socio::getEdad).average().getAsDouble());


        socios.stream().sorted(Comparator.comparing(socio -> ((Socio)socio).getEdad()).reversed()).forEach(System.out::println);
        socios.stream().sorted(Comparator.comparingInt(Socio::getEdad).reversed()).forEach(System.out::println);
    }

    /**
     * DIFICIL
     **/
    public void listaDiezProductosMasAlquilados() {
        productos.stream().sorted(
                Comparator.comparing(producto -> ((Producto) producto).getEncuestas().size())
                        .reversed()).limit(10).forEach(System.out::println);
    }

    // numero de Peliculas Alquiladas, de Documentales y Videojuegos.
    public void numeroProductosAlquiladosPorTipo() {
        productos.stream();
        System.out.println(productos.stream().filter(producto -> !producto.getEncuestas().isEmpty())
                .collect(Collectors.groupingBy(
                        producto -> producto.getClass().getSimpleName()
                       , summingInt(producto -> producto.getEncuestas().size()))));
    }

    public void todosLosActoresDistintosDeTodasLasPeliculas() {
        peliculas.stream().flatMap(pelicula -> pelicula.getActores().stream())
                .distinct().sorted().forEach(System.out::println);
    }

    public void peliculaConMasActores() {
        System.out.println(peliculas.stream()
                .reduce((pelicula, pelicula2) ->
                        pelicula.getActores().size() >= pelicula2.getActores().size() ? pelicula : pelicula2).get());
    }


    //el listado de productos ordenados de mayor a menor según su valoración media.
    public void productoConSuValoracionMediaOrdenadosDeMayoraMenor() {
        productos.stream().sorted(
                Comparator.comparingDouble(producto -> ((Producto) producto).getEncuestas().stream()
                        .mapToDouble(Encuesta::getNota).average().orElse(0)).reversed())
                .forEach(System.out::println);
    }

    public void las10PeliculasMejorValoradas() {
        peliculas.stream().sorted(
                Comparator.comparingDouble(pelicula -> ((Pelicula) pelicula).getEncuestas().stream()
                        .mapToDouble(Encuesta::getNota).average().orElse(0))
                        .reversed()).limit(10).forEach(System.out::println);
    }

    public void los10VideoJuegosMejorValoradas() {
        videojuegos.stream().sorted(
                Comparator.comparingDouble(videojuego -> ((Videojuego) videojuego).getEncuestas().stream()
                        .mapToDouble(Encuesta::getNota).average().orElse(0))
                        .reversed()).limit(10).forEach(System.out::println);
    }


    // el numero de DVD y Videos que hay.
    public void numeroDocumentalesyPeliculasSegunSuFormato() {
        System.out.println(productos.stream().filter(producto -> producto instanceof Documental)
                .map(producto -> (Documental) producto)
                .collect(Collectors.groupingBy(producto -> producto.getClass().getSimpleName()
                        
                        ,groupingBy(Documental::getFormato, counting()))));
                        }

                        // conseguir un String con todos los faricantes distintos de videojuegos separados por ,
        public void todosLosFabricantesDistintosDeVideoJuegosEnUnSoloString () {
            System.out.println(videojuegos.stream().map(Videojuego::getFabricante).distinct()
                    .collect(Collectors.joining(",")));
        }
    }
