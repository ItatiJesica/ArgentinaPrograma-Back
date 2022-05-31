import com.argentinaprograma.portfolio.DTO.NuevoUsuarioDto;
import com.argentinaprograma.portfolio.Model.Rol;
import com.argentinaprograma.portfolio.Model.Usuario;
import com.argentinaprograma.portfolio.Repository.UsuarioRepository;
import com.argentinaprograma.portfolio.Security.Enum.RolNombre;
import com.argentinaprograma.portfolio.Service.RolService;
import com.argentinaprograma.portfolio.Service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)


public class UserRepositoryTests {
    @Autowired
    UsuarioRepository repo;

    @Test
    public void TestCreateUser(){
        PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String rawPassword = "adminjesicab";
        String encodePassword= passwordEncoder.encode(rawPassword);
        Usuario newUser= new Usuario("admin", "administrador","itatibalmacedajesi@gmail.com",encodePassword);
        Usuario savedUser=repo.save(newUser);
        assertThat (savedUser).isNotNull();
        assertThat (savedUser.getId()).isGreaterThan(0);
    }
}
