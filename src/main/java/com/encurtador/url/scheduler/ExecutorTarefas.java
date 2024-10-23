package com.encurtador.url.scheduler;

import com.encurtador.url.model.Url;
import com.encurtador.url.repository.UrlRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class ExecutorTarefas {

    private UrlRepository repository;

    public ExecutorTarefas(UrlRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedDelay = 1,timeUnit = TimeUnit.MINUTES)
    public void executa(){
        log.info("Buscando url expiradas");
        List<Url> urlExpiradas = repository.findByExpiracaoBefore(LocalDateTime.now());
        for(Url url : urlExpiradas){
            log.info("url expirada {}",url.getLink());
            repository.delete(url);
        }
    }

}
