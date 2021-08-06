package ar.org.centro8.curso.java.web.repositories.interfaces;
import ar.org.centro8.curso.java.web.entities.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_ClienteRepository {
    void save(Cliente cliente);
    void remove(Cliente cliente);
    void update(Cliente cliente);
    List<Cliente> getAll();
    default Cliente getById(int id) {
        return getAll()
                .stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElse(new Cliente());
    }

    default Cliente getByNumeroDocumento(String numeroDocumento) {
        return getAll()
                .stream()
                .filter(c -> c.getNumeroDocumento().equals(numeroDocumento))
                .findAny()
                .orElse(new Cliente());
    }

    default List<Cliente> getLikeApellido(String apellido) {
        if (apellido == null) {
            return new ArrayList();
        }
        return getAll()
                .stream()
                .filter(c -> c != null && c.getApellido() != null
                && c.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Cliente>getLikeNombre(String nombre){
        if(nombre==null) return new ArrayList<Cliente>();
        return getAll()
                .stream()
                .filter(a->a !=null && a.getNombre()!= null &&
                        a.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
     default List<Cliente>getLikeNumDocumento(String numeroDocumento){
        if(numeroDocumento==null) return new ArrayList<Cliente>();
        return getAll()
                .stream()
                .filter(a->a !=null && a.getNumeroDocumento()!= null &&
                        a.getNumeroDocumento().toLowerCase().contains(numeroDocumento.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Cliente> getLikeNumeroDocumento(String numeroDocumento) {
        if (numeroDocumento == null) {
            return new ArrayList();
        }
        return getAll()
                .stream()
                .filter(c -> c != null && c.getNumeroDocumento() != null
                && c.getNumeroDocumento().contains(numeroDocumento))
                .collect(Collectors.toList());
    }

    default List<Cliente> getLikeApellidoNumeroDocumento(String apellido, String numeroDocumento) {
        if (apellido == null || numeroDocumento == null) {
            return new ArrayList();
        }
        return getAll()
                .stream()
                .filter(c -> c.getApellido().toLowerCase().contains(apellido.toLowerCase())
                && c.getNumeroDocumento().contains(numeroDocumento))
                .collect(Collectors.toList());
}}