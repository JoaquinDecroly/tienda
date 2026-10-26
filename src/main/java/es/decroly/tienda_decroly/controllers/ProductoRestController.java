package es.decroly.tienda_decroly.controllers;

import es.decroly.tienda_decroly.domain.Producto;
import es.decroly.tienda_decroly.dto.InfoTiendaDto;
import es.decroly.tienda_decroly.services.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Productos", description = "Catalogo de productos")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    private final ProductoService productoService;

    @PostMapping()
    public Producto crear(@RequestBody Producto producto) {
        return productoService.crear(producto);
    }

    @GetMapping()
    public List<Producto> listar() {
        return productoService.listar();
    }

    @Operation(summary = "Consultar un producto por su id")
    @ApiResponse(responseCode = "200", description = "Producto encontrado")
    @ApiResponse(responseCode = "404",
            description = "No existe el producto",
            content = @Content(
                    schema = @Schema(implementation = ProblemDetail.class)))

    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }


    @PutMapping("/{id}")
    public Producto modificar(@PathVariable Long id,
                              @RequestBody Producto datos) {
        return productoService.modificar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        productoService.borrar(id);
    }
    @GetMapping("/info")
    public InfoTiendaDto info() {
        return productoService.info();
    }

}
