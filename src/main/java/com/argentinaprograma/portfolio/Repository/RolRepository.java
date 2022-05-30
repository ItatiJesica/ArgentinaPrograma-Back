package com.argentinaprograma.portfolio.Repository;

import com.argentinaprograma.portfolio.Model.Rol;
import com.argentinaprograma.portfolio.Security.Enum.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
