package edu.iuh.fit.se.bookbe.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Author: Khánh Đinh
 * Date:   10/30/2025
 * Time:   11:00 AM
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "books", uniqueConstraints = @UniqueConstraint(columnNames = "isbn"))
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Size(min = 2, max = 100)
    private String title;
    @NotBlank
    @Size(min = 2, max = 60)
    private String author;
    @NotBlank
    @Size(min = 10, max = 17)
    @Pattern(regexp = "[0-9\\-]+", message = "ISBN only number and '-'")
    private String isbn;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal price;
    @NotNull
    @Min(0)
    private Integer stock;
    private LocalDate publishedDate;
}
