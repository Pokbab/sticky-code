package test.lib;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

public class LombokBuilderTest {

    @Test
    public void testBuilder() {

        Programmer actual = Programmer.builder()
            .build();

        System.out.println(actual);
        assertNotNull(actual);
    }

}

// @Getter
// @ToString
// @Builder
// // @SuperBuilder(toBuilder = true)
// abstract class Person {
//
//     private String name;
//     private int age;
//
//     // public abstract PersonBuilder<?, ?> toBuilder();
//
// }

@Getter
// @ToString(callSuper = true)
// @Builder(toBuilder = true)
@Builder
class Programmer {

    // @Builder.ObtainVia(method = "generate")
    private String level;
    // @Singular
    private List<String> skills;

    // public Programmer() {
    //
    // }

    private String generate() {
        return this.level + this.skills;
    }

}
