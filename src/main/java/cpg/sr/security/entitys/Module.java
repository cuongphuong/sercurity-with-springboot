package cpg.sr.security.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * The persistent class for the Module database table.
 * 
 */
@Entity
@Table(name = "Modules")
@NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m")
public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ModuleID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int moduleID;

	@Column(name = "ModuleName")
	private String moduleName;

	@Column(name = "LableName", nullable = false)
	private String moduleLable;

	// bi-directional many-to-one association to Function
	@OneToMany(mappedBy = "module")
	@JsonIgnore
	private List<Function> functions;

	public Module() {
	}

	public String getModuleLable() {
		return moduleLable;
	}

	public void setModuleLable(String moduleLable) {
		this.moduleLable = moduleLable;
	}

	public int getModuleID() {
		return this.moduleID;
	}

	public void setModuleID(int moduleID) {
		this.moduleID = moduleID;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<Function> getFunctions() {
		return this.functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

	public Function addFunction(Function function) {
		getFunctions().add(function);
		function.setModule(this);

		return function;
	}

	public Function removeFunction(Function function) {
		getFunctions().remove(function);
		function.setModule(null);

		return function;
	}

	public Module(int moduleID) {
		super();
		this.moduleID = moduleID;
	}

	public Module(String moduleName, String moduleLable) {
		super();
		this.moduleName = moduleName;
		this.moduleLable = moduleLable;
	}

}