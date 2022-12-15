package model;

import java.util.Objects;

public class Candidate extends Person{
    private boolean haveHigherEducation;
    private int yearsOfExperience;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candidate candidate = (Candidate) o;
        return haveHigherEducation == candidate.haveHigherEducation && yearsOfExperience == candidate.yearsOfExperience;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), haveHigherEducation, yearsOfExperience);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "haveHigherEducation=" + haveHigherEducation +
                ", experience=" + yearsOfExperience +
                "} " + super.toString();
    }

    public static Builder builder(){
        return new Candidate().new Builder();
    }

    public boolean isHaveHigherEducation() {
        return haveHigherEducation;
    }

    public int getExperience() {
        return yearsOfExperience;
    }

    public class Builder{
        private Builder(){}

        public Builder name(String name){
            if(name.length()<4){
                throw new IllegalArgumentException("Name cannot be shorter than 4 symbols");
            }
            Candidate.this.setName(name);
            return this;
        }

        public Builder sex(String sex){
            if(!Objects.equals(sex, "m") && !"f".equals(sex)){
                throw new IllegalArgumentException("No such gender");
            }
            Candidate.this.setSex(sex);
            return this;
        }

        public Builder phone(String phone){
            if(!phone.matches("^\\d+")){
                throw new IllegalArgumentException("Invalid phone number");
            }
            Candidate.this.setPhone(phone);
            return this;
        }

        public Builder email(String email){
            if(!email.matches("^(.+)@(.+)$")){
                throw new IllegalArgumentException("Invalid email");
            }
            Candidate.this.setEmail(email);
            return this;
        }

        public Builder address(String address){
            if(address.length()>50){
                throw new IllegalArgumentException("Address cannot be longer than 50 symbols");
            }
            Candidate.this.setAddress(address);
            return this;
        }

        public Builder age(int age){
            if(age<18){
                throw new IllegalArgumentException("You must be elder than 18 to get a job offer");
            }
            Candidate.this.setAge(age);
            return this;
        }

        public Builder yearsOfExperience(int experience){
            if(experience<0){
                throw new IllegalArgumentException("Experience cannot be negative");
            }
            Candidate.this.yearsOfExperience =experience;
            return this;
        }

        public Builder haveHigherEducation(boolean haveEdu){
            Candidate.this.haveHigherEducation=haveEdu;
            return this;
        }

        public Candidate build(){
            return Candidate.this;
        }
    }
}
