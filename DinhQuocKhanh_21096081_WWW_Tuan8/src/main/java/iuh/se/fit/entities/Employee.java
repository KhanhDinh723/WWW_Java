package iuh.se.fit.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    // Bỏ @Past để demo với ngày 2025 theo mock
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Email @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    private String phone;
    private String address;

    public Employee() {}
    public Employee(String firstName, String lastName, Gender gender,
                    LocalDate dateOfBirth, String email, String phone, String address) {
        this.firstName = firstName; this.lastName = lastName; this.gender = gender;
        this.dateOfBirth = dateOfBirth; this.email = email; this.phone = phone; this.address = address;
    }

    public enum Gender { male, female }

    // Getters/Setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getFirstName(){return firstName;} public void setFirstName(String v){this.firstName=v;}
    public String getLastName(){return lastName;} public void setLastName(String v){this.lastName=v;}
    public Gender getGender(){return gender;} public void setGender(Gender v){this.gender=v;}
    public LocalDate getDateOfBirth(){return dateOfBirth;} public void setDateOfBirth(LocalDate v){this.dateOfBirth=v;}
    public String getEmail(){return email;} public void setEmail(String v){this.email=v;}
    public String getPhone(){return phone;} public void setPhone(String v){this.phone=v;}
    public String getAddress(){return address;} public void setAddress(String v){this.address=v;}
}
