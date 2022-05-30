package com.argentinaprograma.portfolio.Repository;

import com.argentinaprograma.portfolio.Model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {

}
