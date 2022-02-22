package com.example.springkotlin.controller


import com.example.springkotlin.domain.model.Pokemon
import com.example.springkotlin.usecases.ServiceTest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/pokemon")
class RestPokemon(private val service : ServiceTest)
{

    @GetMapping
    fun get() : List<Pokemon> = service.getPokemons()

    @GetMapping("/{id}")
    fun getUnPokemon(@PathVariable id:Int) : Pokemon = service.getPokemon(id)

    @GetMapping("/filtro")
    fun getCategoriasPokemon(@RequestParam categoria:String) : List<Pokemon> = service.getPokemonsEnCategoria(categoria)


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun addPokemon(@RequestBody pokemon:Pokemon)  = service.addPokemon(pokemon)


    @GetMapping("categorias")
    fun getCategorias() : List<String> = service.getCategorias()


}
