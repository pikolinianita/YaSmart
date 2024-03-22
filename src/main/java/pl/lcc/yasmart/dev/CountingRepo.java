package pl.lcc.yasmart.dev;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CountingRepo extends CrudRepository<Ct, Long> {

}


