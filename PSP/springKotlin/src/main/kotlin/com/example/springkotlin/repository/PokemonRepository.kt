package com.example.springkotlin.repository

import com.example.springkotlin.domain.model.Pokemon
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Repository


@Repository
@Scope("singleton")
class PokemonRepository {

    final val _pokemons: MutableList<Pokemon> = mutableListOf<Pokemon>()

    init {

       _pokemons.add(Pokemon("charmandamas","anituga", listOf("creo que vuela","seguro que echa fuego"),"si le cortas las uñas te lo agradece con una barbacoa",0))

    }

    fun getAllPokemons() : List<Pokemon> = _pokemons

    fun addPokemon(pokemon:Pokemon) {
        pokemon.id = _pokemons.size
        _pokemons.add(pokemon)
    }

    fun getPokemonEnCategoria(categoria:String) = _pokemons.filter{pokemon -> pokemon.generacion == categoria}

    fun getCategorias() = _pokemons.map{pokemon -> pokemon.generacion}.distinct()
    fun getPokemon(id: Int): Pokemon = _pokemons[id]


}
