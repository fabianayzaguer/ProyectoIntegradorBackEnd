package BackEndC3.ClinicaOdontologica.controller;

import BackEndC3.ClinicaOdontologica.entity.Odontologo;
import BackEndC3.ClinicaOdontologica.entity.Paciente;
import BackEndC3.ClinicaOdontologica.exception.ResourceNotFoundException;
import BackEndC3.ClinicaOdontologica.service.OdontologoService;
import BackEndC3.ClinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller //<-- es controller pq vamos a usar una tecnologia de vista
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{id}") //--> nos permite buscar un paciente por id
    public ResponseEntity<Optional<Paciente>> buscarPacientePorId(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.buscarPorID(id));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodosLosPacientes(){
        return ResponseEntity.ok(pacienteService.buscarTodosLosPacientes());
    }

    @PostMapping //--> nos permite persistir los datos que vienen desde la vista
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @PutMapping
    public ResponseEntity<String> actualizarPaciente(@RequestBody Paciente paciente){

        Optional<Paciente> pacienteBuscado= pacienteService.buscarPorID(paciente.getId());
        if(pacienteBuscado.isPresent()){
            pacienteService.actualizarPaciente(paciente);
            return ResponseEntity.ok("paciente actualizado con exito");
        }else{
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorID(id);
        if(pacienteBuscado.isPresent()){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("paciente eliminado con exito");
        }else{
            throw new ResourceNotFoundException("Paciente no encontrado");
        }
    }

    @GetMapping("/buscar/{email}")
    public ResponseEntity<Optional<Paciente>> buscarPorEmail(@PathVariable String email){
        Optional<Paciente> pacienteBuscado= pacienteService.buscarPorEmail(email);
        if(pacienteBuscado.isPresent()){
            return ResponseEntity.ok(pacienteBuscado);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }


    //ahora vienen todos los metodos que nos permitan actuar como intermediarios.
//    @GetMapping
//    public String buscarPacientePorCorreo(Model model, @RequestParam("email") String email){
//
//        Paciente paciente= pacienteService.buscarPorEmail(email);
//        Integer matricula =paciente.getOdontologo().getMatricula();
//
//        model.addAttribute("nombre",paciente.getNombre());
//        model.addAttribute("apellido",paciente.getApellido());
//        model.addAttribute("matricula",matricula);
//
//        return "index";
//
//        //return pacienteService.buscarPorEmail(email);
//    }


}
