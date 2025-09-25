package iuh.fit.se.bai2.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor

@Component
public class EmployeeAnotation {
    private int id = 201;
    private String name = "Đặng Lê Hữu Tiến";

    @Autowired
    private Address address;
}
