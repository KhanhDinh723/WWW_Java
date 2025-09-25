package iuh.fit.se.bai1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {
    private String name;
    private int age;
    private List<Address> addresses;
    private List<String> emails;
}
