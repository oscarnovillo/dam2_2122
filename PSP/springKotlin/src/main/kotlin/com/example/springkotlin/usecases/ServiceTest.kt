package com.example.springkotlin.usecases


import com.example.springkotlin.domain.model.Pokemon
import com.example.springkotlin.repository.PokemonRepository
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class ServiceTest(val pokemonRepository: PokemonRepository) {


    fun getPokemons() : List<Pokemon> =  pokemonRepository.getAllPokemons()
    fun getCategorias(): List<String> = pokemonRepository.getCategorias()
    fun addPokemon(pokemon: Pokemon) = if (Random.nextBoolean()) pokemonRepository.addPokemon(pokemon) else throw Exception("ERROR")
    fun getPokemonsEnCategoria(categoria: String): List<Pokemon>  = pokemonRepository.getPokemonEnCategoria(categoria)
    fun getPokemon(id: Int): Pokemon = pokemonRepository.getPokemon(id)


}
