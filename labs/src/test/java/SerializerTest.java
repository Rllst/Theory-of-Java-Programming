
import model.Person;
import model.TestDataProvider;
import org.junit.Test;
import serializer.JsonSerializer;
import serializer.Serializer;
import serializer.TxtSerializer;
import serializer.XmlSerializer;

import static org.junit.Assert.*;

public class SerializerTest {
    @Test
    public void serializerTest(){
        testSerializer(new XmlSerializer(),"Person.xml");
        testSerializer(new JsonSerializer(),"Person.json");
        testSerializer(new TxtSerializer(),"Person.txt");
    }

    private void testSerializer(Serializer serializer,String path){
        Person person = TestDataProvider.getPerson();
        serializer.serialize(person,path);
        Person deserialized = serializer.deserialize(Person.class, path);
        assertEquals(person,deserialized);
    }
}
