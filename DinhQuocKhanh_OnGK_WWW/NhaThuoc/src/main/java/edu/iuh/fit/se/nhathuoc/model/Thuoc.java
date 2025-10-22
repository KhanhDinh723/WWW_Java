package edu.iuh.fit.se.nhathuoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.MediaName;

/**
 * Author: Khánh Đinh
 * Date:   9/30/2025
 * Time:   5:26 PM
 */
@Entity
@Table(name = "THUOC")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Thuoc {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MATHUOC")
   private Long maThuoc;

    @Column(name = "TENTHUOC")
    private String tenThuoc;
    @Column(name = "GIA")
    private double gia;
    @Column(name = "NAMSX")
    private int namSX;

    @ManyToOne
    @JoinColumn(name = "MALOAI")
    private LoaiThuoc loaiThuoc;


}
