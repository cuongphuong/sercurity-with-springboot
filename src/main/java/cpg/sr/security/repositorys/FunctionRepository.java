package cpg.sr.security.repositorys;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cpg.sr.security.entitys.Function;

@Primary
@Repository("functionRepository")
public interface FunctionRepository extends CrudRepository<Function, Integer> {

}
