package fit.iuh.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DienThoai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maDT")
	private int id;
	
	private String tenDT;
	private LocalDate ngaySX;
	private int soLuong;
	private String hinhAnh;
	
	@ManyToOne
	@JoinColumn(name = "maNCC")
	private NhaCungCap nhaCungCap;

	public DienThoai() {
		super();
	}

	public DienThoai(int id, String tenDT, LocalDate ngaySX, int soLuong, String hinhAnh, NhaCungCap nhaCungCap) {
		super();
		this.id = id;
		this.tenDT = tenDT;
		this.ngaySX = ngaySX;
		this.soLuong = soLuong;
		this.hinhAnh = hinhAnh;
		this.nhaCungCap = nhaCungCap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public LocalDate getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(LocalDate ngaySX) {
		this.ngaySX = ngaySX;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	
	
}
