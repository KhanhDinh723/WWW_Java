package fit.iuh.dao;

import java.util.List;

import fit.iuh.models.NhanVien;

public interface NhanVienDAO {
	public List<NhanVien> findAll();
	public NhanVien themNV(NhanVien nv);
	public boolean xoaNhanVien(int maNV);
}
