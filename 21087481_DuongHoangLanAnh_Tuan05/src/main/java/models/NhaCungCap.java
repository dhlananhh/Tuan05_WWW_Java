package models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;


@Entity
@Table (name = "NhaCungCap")
public class NhaCungCap {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "maNhaCungCap")
	private int maNhaCungCap;
	
	@Column (name = "tenNhaCungCap")
	@NotNull (message = "Tên nhà cung cấp không được rỗng")
	@NotEmpty (message = "Tên nhà cung cấp không được để trống")
	@Size (max = 255, message = "Tên nhà cung cấp không được quá 255 ký tự")
	private String tenNhaCungCap;
	
	@Column (name = "diaChi")
	@NotNull (message = "Địa chỉ không được rỗng")
	@NotEmpty (message = "Địa chỉ không được để trống")
	@Size (max = 255, message = "Địa chỉ không được quá 255 ký tự")
	private String diaChi;
	
	@Column (name = "soDienThoai")
	@NotNull (message = "Số điện thoại không được rỗng")
	@NotEmpty (message = "Số điện thoại không được để trống")
	@Size (max = 50, message = "Số điện thoại không được quá 50 ký tự")
	private String soDienThoai;
	
	@OneToMany (mappedBy = "nhaCungCap")
	private List<DienThoai> danhSachDienThoai;
	
	
	public NhaCungCap() {
		
	}


	public NhaCungCap(int maNhaCungCap, String tenNhaCungCap, String diaChi, String soDienThoai) {
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}


	public NhaCungCap(String tenNhaCungCap, String diaChi, String soDienThoai) {
		super();
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}


	public int getMaNhaCungCap() {
		return maNhaCungCap;
	}


	public void setMaNhaCungCap(int maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}


	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}


	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getSoDienThoai() {
		return soDienThoai;
	}


	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	@Override
	public String toString() {
		return "NhaCungCap [maNhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", diaChi=" + diaChi
				+ ", soDienThoai=" + soDienThoai + "]";
	}
	
}
