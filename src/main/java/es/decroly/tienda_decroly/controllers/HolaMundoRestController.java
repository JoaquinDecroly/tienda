package es.decroly.tienda_decroly.controllers;


    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class HolaMundoRestController {
        private final String nombre;
        private final String horario;

        public HolaMundoRestController(@Value("${tienda.nombre}") String nombre,
                                       @Value("${tienda.horario:Sin horario}") String horario) {
            this.nombre = nombre;
            this.horario = horario;
        }

        @GetMapping("/saludo")
        public String saludo() {
            return "Bienvenido a " + nombre + ". Horario: " + horario;
        }

        // Variable de ruta:  http://localhost:8080/hola/Ana

        @GetMapping("/saludo/{nombre}")
        public String saludoPersonalizado(@PathVariable String nombre) {
            return "Hola " + nombre + ", bienvenido/a a la Tienda Decroly";
        }

        // Parametro de consulta:  http://localhost:8080/buscar?texto=raton
        @GetMapping("/buscar")
        public String buscar(@RequestParam(defaultValue = "todo") String texto) {
            return "Buscando productos que contengan: " + texto;
        }

    }


