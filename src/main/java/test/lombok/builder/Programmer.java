package test.lombok.builder;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public class Programmer extends Person {

    @Builder.ObtainVia(method = "generate")
    private final String level;
    private List<String> skills;

    private String generate() {
        return super.getName() + " : " + super.getAge();
    }

}
