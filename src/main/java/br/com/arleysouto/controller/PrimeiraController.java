package br.com.arleysouto.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraController")
public class PrimeiraController {
    
    @GetMapping("/primeiroMetodo/{id}")
    public String primeiroMetodo(@PathVariable() String id){
        return "O Parametro é " + id;
    }

    @GetMapping("/metodoComQueryParams")
    public String metodoComQueryParams(@RequestParam String id){
        return "O parametro com " + id;
    }

    @GetMapping("/metodoComQueryParams2")
    public String metodoComQueryParams2(@RequestParam Map<String, String> allParams){
        return "O parametro com " + allParams.entrySet();
    }

    @PostMapping("/metdoComBodyParams")
    public String metodoComBodyParams(@RequestBody Usuario usuario){
        return "metodoComBodyParams" + usuario.username();
    }

    record Usuario(String username){}

    @PostMapping("/metdoComHeaders")
    public String metdoComBodyHeaders(@RequestHeader("name") String name){
        return "metdoComBodyHeaders" + name;
    }

    @PostMapping("/metdoComListHeaders")
    public String metdoComListHeaders(@RequestHeader Map<String, String> headers){
        return "metdoComListHeaders" + headers.entrySet();
    }

    @GetMapping("/metodoResponseEntity")
    public ResponseEntity<Object> metodoResponseEntity(){
        return ResponseEntity.status(400).body("Mensagem de erro");

    }
}
