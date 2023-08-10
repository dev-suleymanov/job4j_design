package ru.job4j.serialization;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private boolean status;
    @XmlAttribute
    private int time;
    private Resource resource;
    @XmlElementWrapper(name = "names")
    @XmlElement(name = "name")
    private String[] names;

    public User() { }
    public User(String name, boolean status, int time, Resource resource, String[] names) {
        this.name = name;
        this.status = status;
        this.time = time;
        this.resource = resource;
        this.names = names;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\''
                + ", status=" + status
                + ", time=" + time
                + ", resource=" + resource
                + ", names=" + Arrays.toString(names)
                + '}';
    }
}
