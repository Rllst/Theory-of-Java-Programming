package model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Offer {
    private String description;
    private List<Candidate> candidates;
    private float salary;

    @Override
    public String toString() {
        return "Offer{" +
                "description='" + description + '\'' +
                ", candidates=" + candidates +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Float.compare(offer.salary, salary) == 0 && Objects.equals(description, offer.description) && Objects.equals(candidates, offer.candidates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, candidates, salary);
    }

    public static Builder builder(){
        return new Offer().new Builder();
    }

    public void sortCandidates(){
        Collections.sort(candidates);
    }

    public void deleteCandidatesWithoutHigherEducation(){
        this.candidates = candidates.stream()
                .filter(Candidate::isHaveHigherEducation)
                .collect(Collectors.toList());
    }

    public void addCandidate(Candidate candidate){
        this.candidates.add(candidate);
    }

    public String getDescription() {
        return description;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public class Builder{
        private Builder(){}

        public Builder description(String description){
            if(description.length()<10 || description.length()>100){
                throw new IllegalArgumentException("Description length must be between 10 and 100");
            }
            Offer.this.description=description;
            return this;
        }

        public Builder candidates(List<Candidate> candidates){
            if(candidates==null){
                throw new IllegalArgumentException("Candidate list cannot be null");
            }
            Offer.this.candidates=candidates;
            return this;
        }

        public Builder salary(float salary){
            if(salary<0){
                throw new IllegalArgumentException("Salary cannot be negative");
            }
            Offer.this.salary=salary;
            return this;
        }

        public Offer build(){
            return Offer.this;
        }
    }
}
