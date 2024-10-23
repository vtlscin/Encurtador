package com.encurtador.url.controller;

import com.encurtador.url.dto.UrlDto;
import com.encurtador.url.model.Url;
import com.encurtador.url.repository.UrlRepository;
import com.encurtador.url.util.Util;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@Slf4j
public class UrlController {

    private UrlRepository repository;

    public UrlController(UrlRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/shorten-url")
    public ResponseEntity<String> salvaLink(@RequestBody UrlDto dto, HttpServletRequest request){
        boolean entraLoop = true;
        String id = "";
        while(entraLoop){
            try {
                id = Util.criaIdCorrespondente();
                repository.save(new Url(id,dto.url(), LocalDateTime.now().plusMinutes(10)));
                entraLoop = false;
            }catch (Exception e){
                log.info("gerando um novo id");
            }
        }
        String urlEncurtada = request.getRequestURL().toString().replace("shorten-url",id);

        return ResponseEntity.ok(urlEncurtada);
    }

    @GetMapping("{id}")
    public ResponseEntity<Void> redirect(@PathVariable("id") String id){
        Optional<Url> url = repository.findById(id);
        if(url.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url.get().getLink()));

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }

}
