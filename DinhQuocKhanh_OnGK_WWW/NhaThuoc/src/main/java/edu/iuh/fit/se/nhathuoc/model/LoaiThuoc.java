package edu.iuh.fit.se.nhathuoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Khánh Đinh
 * Date:   9/30/2025
 * Time:   5:26 PM
 */
@Entity
@Table(name = "LOAITHUOC")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoaiThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MALOAI")
    private Long maLoai;

    @Column(name = "TENLOAI")
    private String tenLoai;
}
