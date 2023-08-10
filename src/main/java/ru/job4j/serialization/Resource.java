package ru.job4j.serialization;

import javax.xml.bind.annotation.*;
import java.util.Map;

@XmlRootElement(name = "resource")
public class Resource {
    @XmlElementWrapper(name = "elements")
    private Map<String, String> map;

    public Resource() {
    }

    public Resource(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Resource{"
                + "map=" + map
                + '}';
    }
}
