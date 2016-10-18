package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.PersonForm.SignUpValidation;
import hello.PersonForm.UpdateValidation;

@RestController
public class PersonController {

	@RequestMapping(value = "/createPerson", method = RequestMethod.POST)
	public ResponseEntity<PersonForm> createPerson(@Validated({ UpdateValidation.class, SignUpValidation.class }) @RequestBody PersonForm person,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(person, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<PersonForm>(person, HttpStatus.OK);
	}
}
