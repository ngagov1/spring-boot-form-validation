package hello;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {

	interface SignUpValidation{}
	
	interface UpdateValidation{}
	
    @NotNull(groups={SignUpValidation.class})
    @Size(min=2, max=30, groups={SignUpValidation.class})
    private String name;

    @NotNull(groups={UpdateValidation.class})
    @Min(value=18, groups={UpdateValidation.class})
    private Integer age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
    }
}
