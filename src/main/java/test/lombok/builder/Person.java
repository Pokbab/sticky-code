package test.lombok.builder;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder(toBuilder = true)
public abstract class Person {

    private String name;
    private int age;

    // public abstract PersonBuilder<?, ?> toBuilder();

}
