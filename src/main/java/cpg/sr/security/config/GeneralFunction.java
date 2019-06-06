package cpg.sr.security.config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cpg.sr.security.anotations.DefaultFunctionInfo;
import cpg.sr.security.anotations.DefaultModuleInfo;
import cpg.sr.security.commons.Utils;
import cpg.sr.security.entitys.Function;
import cpg.sr.security.entitys.Module;

@Configuration
public class GeneralFunction {

	@Bean("CPG_GeneralFunction")
	public void genaralFunction() {
		// declare
		Class<? extends Object>[] classes = Utils.getClassesInPackage("cpg.sr.controller");
		List<Module> lstModule = new ArrayList<Module>();
		List<Function> lstFunction = new ArrayList<Function>();

		for (Class<? extends Object> c : classes) {
			// Get module
			Annotation[] moduleAnotations = c.getAnnotations();
			Module module = new Module();
			for (Annotation annotationElement : moduleAnotations) {
				if (annotationElement instanceof RequestMapping) {
					RequestMapping anotationRequestModule = (RequestMapping) annotationElement;
					String moduleName[] = anotationRequestModule.value();
					module.setModuleLable(moduleName[0]);
				}

				if (annotationElement instanceof DefaultModuleInfo) {
					DefaultModuleInfo annotationInfoModule = (DefaultModuleInfo) annotationElement;
					String moduleName = annotationInfoModule.name();
					module.setModuleName(moduleName);
				}
			}
			// add module to list
			lstModule.add(module);

			// Get function of class
			Method[] methods = c.getMethods();
			for (Method method : methods) {
				Annotation[] methodAnnotation = method.getAnnotations();
				Function function = null;
				for (Annotation annotationElement : methodAnnotation) {
					if (annotationElement instanceof DefaultFunctionInfo) {
						
						DefaultFunctionInfo anotationRequestFunction = (DefaultFunctionInfo) annotationElement;
						function.setFunctionName(anotationRequestFunction.name());
						function.setIconType(anotationRequestFunction.icon());
						function.setEnable(anotationRequestFunction.enable());
					}

					if (function != null) {
						if (annotationElement instanceof GetMapping) {
							GetMapping anotationRequestFunction = (GetMapping) annotationElement;
							String name[] = anotationRequestFunction.value();
							function.setFunctionLable(name[0]);
						}

						if (annotationElement instanceof PostMapping) {
							PostMapping anotationRequestFunction = (PostMapping) annotationElement;
							String name[] = anotationRequestFunction.value();
							function.setFunctionLable(name[0]);
						}

						if (annotationElement instanceof PutMapping) {
							PutMapping anotationRequestFunction = (PutMapping) annotationElement;
							String name[] = anotationRequestFunction.value();
							function.setFunctionLable(name[0]);
						}

						if (annotationElement instanceof DeleteMapping) {
							DeleteMapping anotationRequestFunction = (DeleteMapping) annotationElement;
							String name[] = anotationRequestFunction.value();
							function.setFunctionLable(name[0]);
						}
					}
				}

				// add funtion
				if (function != null) {
					lstFunction.add(function);
				}
			}
		}
		System.err.println("Module General: " + lstModule.size());
		System.err.println("Function General: " + lstFunction.size());
	}

}
