package BackEndC3.ClinicaOdontologica.service;

import BackEndC3.ClinicaOdontologica.entity.Odontologo;
import BackEndC3.ClinicaOdontologica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;

    //metodos manuales
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoRepository.findAll();
    }

    public Optional<Odontologo> buscarOdontologoPorId(Long id){
        return odontologoRepository.findById(id);
    }

    public void eliminarOdontologo(Long id){
        odontologoRepository.deleteById(id);
    }

    public void actualizarOdontologo(Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }

    //public Odontologo guardarOdontologoEnLista(Odontologo odontologo){
       // return odontologoiDaoList.guardar(odontologo);
    //}
    //public List<Odontologo> buscarTodosEnLista(){return odontologoiDaoList.buscarTodos();
 //}
}
