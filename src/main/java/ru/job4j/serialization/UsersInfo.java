package ru.job4j.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

public class UsersInfo {
    public static void main(String[] args) throws Exception {
        Resource resource = new Resource(Map.of(
                "Lord of the rings", "https://www.articles.com/lotr",
                "Harry potter", "https://www.articles.com/potter",
                "Hobbit", "https://www.articles.com/hobbit"
        ));
        User user = new User("Nebraska",
                true,
                2592000,
                resource,
                new String[]{"Maurice", "Caesar", "Nebraska"});
        JAXBContext context = JAXBContext.newInstance(User.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(user, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            User result = (User) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
