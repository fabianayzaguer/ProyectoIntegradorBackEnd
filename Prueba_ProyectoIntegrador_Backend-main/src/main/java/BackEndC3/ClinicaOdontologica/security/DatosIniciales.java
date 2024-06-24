package BackEndC3.ClinicaOdontologica.security;

import BackEndC3.ClinicaOdontologica.entity.Usuario;
import BackEndC3.ClinicaOdontologica.entity.UsuarioRole;
import BackEndC3.ClinicaOdontologica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String passSinCifrar= "user";
        String passSinCifrar2= "admin";
        String passCifrado2=  passwordEncoder.encode(passSinCifrar2);
        String passCifrado=  passwordEncoder.encode(passSinCifrar);
        Usuario usuario= new Usuario("jorgito","jpereryradh","user@user.com",passCifrado, UsuarioRole.ROLE_USER);
        Usuario usuario2= new Usuario("admin","admin","admin@admin.com",passCifrado2, UsuarioRole.ROLE_ADMIN);
        usuarioRepository.save(usuario);
        usuarioRepository.save(usuario2);
    }

}
