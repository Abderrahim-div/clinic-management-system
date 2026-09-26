package com.clinic.doctors;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    
    private String firstName;
    private String lastName;
    private String phone;
    private String specialty;
    private Boolean active;


    public Long getId(){
            return id;
    }
    public void setId(Long id){
            this.id = id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }

    public void setSpecialty(String specialty){
        this.specialty = specialty;
    }
    public String getSpecialty(){
        return specialty;
    }

    public void setActive(Boolean active){
        this.active = active;
    }
    public Boolean getActive(){
        return active;
    }
}
