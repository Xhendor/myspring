package com.uabc.edu.appswbd.myspring.controller;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {

        return "HolaMundo";

    }
    @RequestMapping("/clase")
    @ResponseBody
    public String holaClase() {

        return "Suban la tarea";

    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/saludo")
    public String saludo(@RequestParam(
            value = "name",
            defaultValue = "Mundito") String name,
                         @RequestParam(value = "numero",
                                 defaultValue = "100")
                         int numero) {
        return "Numero:"+numero+"<br><b>Contador:</b><br>"+counter.incrementAndGet()
                + String.format(template, name);
    }

    @PostMapping("/saludo")
    public String saludoPost(@RequestParam(
            value = "name",
            defaultValue = "Mundito") String name,
                         @RequestParam(value = "numero"
                                 )
                                 int numero) {
        return "Numero:"+numero+"<br><b>Contador:</b><br>"+counter.incrementAndGet()
                + String.format(template, name);
    }

}
