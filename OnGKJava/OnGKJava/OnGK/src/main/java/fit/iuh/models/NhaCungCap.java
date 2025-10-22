package fit.iuh.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NhaCungCap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maNCC")
	private int id;
	
	private String tenNCC;

	public NhaCungCap() {
		super();
	}

	public NhaCungCap(int id, String tenNCC) {
		super();
		this.id = id;
		this.tenNCC = tenNCC;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	
	
	
}
