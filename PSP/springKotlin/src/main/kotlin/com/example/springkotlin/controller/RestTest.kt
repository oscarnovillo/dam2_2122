package com.example.springkotlin.controller

import com.example.springkotlin.domain.Tienda
import com.example.springkotlin.usecases.ServiceTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/test")
class RestTest(private val service : ServiceTest)
{



    @GetMapping
    fun get() : List<Tienda> = service.getTiendas()


}
