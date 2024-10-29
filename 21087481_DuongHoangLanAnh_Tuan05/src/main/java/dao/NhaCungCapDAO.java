package dao;


import models.NhaCungCap;
import java.util.List;


public interface NhaCungCapDAO {
	public NhaCungCap themNhaCungCap(NhaCungCap ncc);
	public NhaCungCap capNhatNhaCungCap(NhaCungCap ncc);
	public boolean xoaNhaCungCap(int ma);
	public List<NhaCungCap> layDanhSachNhaCungCap();
	public NhaCungCap timNhaCungCapTheoMa(int ma);
	public NhaCungCap timNhaCungCapTheoTen (String ten);
	public NhaCungCap timNhaCungCapTheoDiaChi (String diaChi);
	public NhaCungCap timNhaCungCapTheoSDT (String sdt);
	public List<NhaCungCap> timKiemNhaCungCap(String keyword);
}
