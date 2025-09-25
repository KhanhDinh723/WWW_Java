package iuh.fit.se.bai2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder

@Component
public class AddressAnotation {
    private String city = "Hanoi";
    private String state = "South";
    private String country = "Việt Nam";
}
