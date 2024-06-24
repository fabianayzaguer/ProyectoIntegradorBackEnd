package BackEndC3.ClinicaOdontologica;

import BackEndC3.ClinicaOdontologica.dao.BD;
import BackEndC3.ClinicaOdontologica.entity.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import BackEndC3.ClinicaOdontologica.service.OdontologoService;

public class OdontologoServiceTest {
    @Test
    public void guardarOdontologos(){
        BD.crearTablas();
        Odontologo odontologo1 = new Odontologo( 4,"Juan", "Perez", 12345678);
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.guardarOdontologo(odontologo1);
        Assertions.assertTrue(odontologo1.getId()==4);
    }
    @Test
    public void buscarTodosOdontologos(){
        BD.crearTablas();
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.buscarTodos();
        int cantidadOdontologos = odontologoService.buscarTodos().size();
        Assertions.assertEquals(2, cantidadOdontologos, "Se esperan 2 odontólogos en la lista.");
    }
    /*@Test
    public void guardarOdontologosEnLista(){
        Odontologo odontologo2 = new Odontologo( 5,"Maria", "Gomez", 87654321);
        Odontologo odontologo3 = new Odontologo( 6,"Pedro", "Gonzalez", 12348765);
        Odontologo odontologo4 = new Odontologo( 7,"Lucia", "Fernandez", 56781234);
        OdontologoService odontologoService = new OdontologoService();
        //odontologoService.guardarOdontologoEnLista(odontologo2);
       // odontologoService.guardarOdontologoEnLista(odontologo3);
       // odontologoService.guardarOdontologoEnLista(odontologo4);
        int cantidadOdontologos = odontologoService.buscarTodosEnLista().size();
        Assertions.assertEquals(3, cantidadOdontologos, "Se esperan 3 odontólogos en la lista.");
    }*/
    /*@Test
    public void buscarTodosOdontologosEnLista() {
        //sumar odontologos a lista
        Odontologo odontologo2 = new Odontologo(5, "Maria", "Gomez", 87654321);
        Odontologo odontologo3 = new Odontologo(6, "Pedro", "Gonzalez", 12348765);
        Odontologo odontologo4 = new Odontologo(7, "Lucia", "Fernandez", 56781234);
        OdontologoService odontologoService = null;
        odontologoService = new OdontologoService();

        odontologoService.guardarOdontologoEnLista(odontologo2);
        odontologoService.guardarOdontologoEnLista(odontologo3);
        odontologoService.guardarOdontologoEnLista(odontologo4);

        //buscar todos los odontologos en la lista


        odontologoService.buscarTodosEnLista();
        int cantidadOdontologos = odontologoService.buscarTodosEnLista().size();
        Assertions.assertEquals(3, cantidadOdontologos, "Se esperan 3 odontólogos en la lista.");
    }*/
}
