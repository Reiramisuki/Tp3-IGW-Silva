package ar.org.centro8.curso.java.web.test;
import ar.org.centro8.curso.java.web.entities.Cliente;
import ar.org.centro8.curso.java.web.enums.TipoDocumento;
import ar.org.centro8.curso.java.web.repositories.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.web.repositories.jdbc.ClienteRepository;
import ar.org.centro8.curso.java.web.connectors.Connector;

public class TestClienteRepository {
    public static void main(String[] args) {
        I_ClienteRepository cr = new ClienteRepository(Connector.getConnection());
        System.out.println("**************************************************\n");
        System.out.println("LISTADO COMPLETO CLIENTES:\n");
        cr.getAll().forEach(System.out::println);
        System.out.println("**************************************************\n");
        System.out.println("LISTADO COMPLETO CON INGRESO DE NUEVOS CLIENTES:\n");
        cr.save(null);
        cr.save(new Cliente("Jose", "Josafo", 20, "Medrano 279", "j@gmail.com", "4321-1234", TipoDocumento.DNI, "20202217"));
        cr.save(new Cliente("Maria", "Maricel", 30, "Medrano 279", "j@gmail.com", "4321-1234",TipoDocumento.LIBRETA_CIVICA, "20202218"));
        cr.save(new Cliente("Ramona", "Ramirez", 40, "Medrano 279", "j@gmail.com", "4321-1234",TipoDocumento.LIBRETA_ENROLAMIENTO, "20202219"));
        cr.save(new Cliente("Filomena", "Fernandez", 50, "Medrano 279", "j@gmail.com", "4321-1234",TipoDocumento.PASS, "20202220"));
        cr.save(null);
        cr.getAll().forEach(System.out::println);
        
        System.out.println("**************************************************\n");
        System.out.println("ACTUALIZACION DE CLIENTE:\n");
        Cliente cliente = cr.getById(2);
        if(cliente!=null && cliente.getId()!=0){
        cliente.setNombre("Filiberto");
        cr.update(cliente);}
        System.out.println(cr.getById(2));
        System.out.println("**************************************************\n");
        System.out.println("BUSQUEDA DE CLIENTE - NOMBRES CON: MA\n");
        cr.getLikeNombre("MA").forEach(System.out::println);
        
        System.out.println("**************************************************\n");
        System.out.println("BUSQUEDA DE CLIENTE - APELLIDOS CON: pe\n");
        cr.getLikeApellido("AR").forEach(System.out::println);
        
        System.out.println("**************************************************\n");
        System.out.println("BUSQUEDA DE CLIENTE - DOCUMENTOS CON: 333\n");
        cr.getLikeNumDocumento("203").forEach(System.out::println);
        
        System.out.println("**************************************************\n");
        System.out.println("BORRADO DE CLIENTE:");        
        cr.remove(cr.getById(54));
        System.out.println(cr.getById(54));
        
        System.out.println("**************************************************\n");

    }

}