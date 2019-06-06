package cpg.sr.security.repositorys;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cpg.sr.security.entitys.Users;

@Primary
@Repository("UserRepository")
public interface UserRepository extends CrudRepository<Users, String> {
	
}
