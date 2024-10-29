package dao;


import models.DienThoai;
import java.util.List;


public interface DienThoaiDAO {
	public DienThoai themDienThoai (DienThoai dt);
	public DienThoai capNhatDienThoai (DienThoai dt);
	public boolean xoaDienThoai (int ma);
	public DienThoai timDienThoaiTheoMa (int ma);
	public List<DienThoai> layDanhSachDienThoai();
}
