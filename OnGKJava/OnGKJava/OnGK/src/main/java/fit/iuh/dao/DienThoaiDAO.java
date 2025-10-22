package fit.iuh.dao;

import java.util.List;

import fit.iuh.models.DienThoai;

public interface DienThoaiDAO {
	public List<DienThoai> findAll();
	public DienThoai addDienThoai(DienThoai dt);
	public boolean remove(int maDT);
}
