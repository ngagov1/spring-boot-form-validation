package hello;

//import javax.validation.Validator;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import hello.PersonForm.SignUpValidation;
import hello.PersonForm.UpdateValidation;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

	//@Autowired
	//private Validator validator;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Validated({UpdateValidation.class, SignUpValidation.class}) PersonForm personForm, BindingResult bindingResult) {
		/*Set<ConstraintViolation<PersonForm>> errors = validator.validate(personForm, UpdateValidation.class, SignUpValidation.class);*/
		if (bindingResult.hasErrors()) {
			//for (ConstraintViolation<PersonForm> error : errors) {
			//	String propertyPath = error.getPropertyPath().toString();
			//	String message = error.getMessage();
			//	bindingResult.rejectValue(propertyPath, "", message);
			//}
			return "form";
		}

		return "redirect:/results";
	}
}
