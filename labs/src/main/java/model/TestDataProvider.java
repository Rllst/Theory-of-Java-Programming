package model;

import java.util.ArrayList;
import java.util.List;

public class TestDataProvider {
    public static List<Candidate> getCandidates(){
        Candidate candidate1= Candidate.builder()
                .name("Serhii Horoshkevych")
                .age(21)
                .sex("m")
                .phone("0661827048")
                .email("serega.goeoshkevych@gmail.com")
                .address("Chernivtsi, pivdenno kiltswva street")
                .haveHigherEducation(false)
                .yearsOfExperience(0)
                .build();
        Candidate candidate2= Candidate.builder()
                .name("Oksana Marchenko")
                .age(34)
                .sex("f")
                .phone("345463")
                .email("m.march@gmail.com")
                .address("Chernivtsi, holowna street")
                .haveHigherEducation(true)
                .yearsOfExperience(3)
                .build();
        Candidate candidate3= Candidate.builder()
                .name("Ivan Kalivan")
                .age(18)
                .sex("m")
                .phone("754392")
                .email("kalivan.ivan@gmail.com")
                .address("Chernivtsi, komarova street")
                .haveHigherEducation(false)
                .yearsOfExperience(8)
                .build();
        ArrayList<Candidate> result = new ArrayList<>();
        result.add(candidate1);
        result.add(candidate2);
        result.add(candidate3);
        return result;
    }

    public static Offer getOffer(){
        return Offer.builder()
                .description("Budivelnik na budivlu")
                .salary(3000.1f)
                .candidates(getCandidates())
                .build();
    }

    public static Person getPerson() {
        Person person = new Person();
        person.setName("John");
        person.setAge(20);
        person.setAddress("street");
        person.setEmail("sd@gmail.com");
        person.setPhone("043223214");
        person.setSex("m");
        return person;
    }
}
