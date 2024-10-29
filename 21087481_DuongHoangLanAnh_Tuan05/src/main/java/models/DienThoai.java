package models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;


@Entity
@Table (name = "DienThoai")
public class DienThoai {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "maDienThoai")
	private int maDienThoai;
	
	@Column (name = "tenDienThoai")
	@NotNull (message = "Tên điện thoại không được rỗng")
	@NotEmpty (message = "Tên điện thoại không được để trống")
	@Size (max = 255, message = "Tên điện thoại phải có độ dài không quá 255 ký tự")
	private String tenDienThoai;
	
	@Column (name = "namSanXuat")
	@NotNull (message = "Năm sản xuất không được rỗng")
	@NotEmpty (message = "Năm sản xuất không được để trống")
	@PastOrPresent (message = "Năm sản xuất phải nhỏ hơn hoặc bằng năm hiện tại")
	private int namSanXuat;
	
	@Column (name = "cauHinh")
	@NotNull (message = "Cấu hình không được rỗng")
	@NotEmpty (message = "Cấu hình không được để trống")
	@Size (max = 65535, message = "Cấu hình phải có độ dài không quá 65535 ký tự")
	private String cauHinh;
	
	@Column (name = "hinhAnh")
	@NotNull (message = "Hình ảnh không được rỗng")
	@NotEmpty (message = "Hình ảnh không được để trống")
	@Size (max = 255, message = "Hình ảnh phải có độ dài không quá 255 ký tự")
	private String hinhAnh;
	
	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name = "maNhaCungCap")
	private NhaCungCap nhaCungCap;
	
	
	public DienThoai() {

	}


	public DienThoai(int maDienThoai, String tenDienThoai, int namSanXuat, 
			String cauHinh, String hinhAnh, NhaCungCap nhaCungCap) {
		this.maDienThoai = maDienThoai;
		this.tenDienThoai = tenDienThoai;
		this.namSanXuat = namSanXuat;
		this.cauHinh = cauHinh;
		this.hinhAnh = hinhAnh;
		this.nhaCungCap = nhaCungCap;
	}


	public DienThoai (String tenDienThoai, int namSanXuat, String cauHinh, 
			String hinhAnh, NhaCungCap nhaCungCap) {
		this.tenDienThoai = tenDienThoai;
		this.namSanXuat = namSanXuat;
		this.cauHinh = cauHinh;
		this.hinhAnh = hinhAnh;
		this.nhaCungCap = nhaCungCap;
	}


	public int getMaDienThoai() {
		return maDienThoai;
	}


	public void setMaDienThoai(int maDienThoai) {
		this.maDienThoai = maDienThoai;
	}


	public String getTenDienThoai() {
		return tenDienThoai;
	}


	public void setTenDienThoai(String tenDienThoai) {
		this.tenDienThoai = tenDienThoai;
	}


	public int getNamSanXuat() {
		return namSanXuat;
	}


	public void setNamSanXuat(int namSanXuat) {
		this.namSanXuat = namSanXuat;
	}


	public String getCauHinh() {
		return cauHinh;
	}


	public void setCauHinh(String cauHinh) {
		this.cauHinh = cauHinh;
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


	@Override
	public String toString() {
		return "DienThoai [maDienThoai=" + maDienThoai + ", tenDienThoai=" + tenDienThoai + ", namSanXuat=" + namSanXuat
				+ ", cauHinh=" + cauHinh + ", hinhAnh=" + hinhAnh + ", nhaCungCap=" + nhaCungCap + "]";
	}
	
}
