package test.lib;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import lombok.SneakyThrows;

public class JacksonTest {

    private static final JavaPropsMapper PROPS_MAPPER = new JavaPropsMapper();

    @Test
    @SneakyThrows
    public void propertiesToJson() {
        Map<String, String> map = new HashMap<>();
        map.put("tooltip.1.title", "툴팁 제목 1");
        map.put("tooltip.1.contents", "툴팁 내용 1");
        map.put("tooltip.2.title", "툴팁 제목 2");
        map.put("tooltip.2.contents", "툴팁 내용 1");

        map.put("terms.1.title", "약관 제목 1");
        map.put("terms.1.contents", "약관 내용 1");
        map.put("terms.2.title", "약관 제목 2");
        map.put("terms.2.contents", "약관 내용 1");

        ObjectNode json = PROPS_MAPPER.readMapAs(map, ObjectNode.class);

        System.out.println(json);
    }

}
