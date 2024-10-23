package com.encurtador.url.repository;

import com.encurtador.url.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UrlRepository extends JpaRepository<Url,String> {

    List<Url> findByExpiracaoBefore(LocalDateTime dataHora);

}
