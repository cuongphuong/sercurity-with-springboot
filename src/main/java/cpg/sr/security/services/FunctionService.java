package cpg.sr.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cpg.sr.security.entitys.Function;
import cpg.sr.security.repositorys.FunctionRepository;

@Service("functionService")
public class FunctionService {
	@Autowired
	private FunctionRepository funcRepos;

	public String getURLFunction(int funcID) {
		try {
			Optional<Function> funcOptinal = funcRepos.findById(funcID);
			Function func = null;
			if (funcOptinal.isPresent()) {
				func = funcOptinal.get();
			}

			if (func != null) {
				return func.getUrl();
			} else {
				return null;
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			return null;
		}
	}
}
