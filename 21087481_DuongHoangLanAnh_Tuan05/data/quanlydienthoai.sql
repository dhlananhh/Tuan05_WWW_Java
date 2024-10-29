-- Tạo cơ sở dữ liệu
CREATE DATABASE IF NOT EXISTS quanlydienthoai;

-- Sử dụng cơ sở dữ liệu
USE quanlydienthoai;

-- Tạo bảng nhacungcap
CREATE TABLE IF NOT EXISTS nhacungcap (
  maNhaCungCap INT(11) NOT NULL AUTO_INCREMENT,
  tenNhaCungCap VARCHAR(255) NOT NULL,
  diaChi VARCHAR(255) NOT NULL,
  soDienThoai VARCHAR(50) NOT NULL,
  PRIMARY KEY (maNhaCungCap)
);

-- Tạo bảng dienthoai
CREATE TABLE IF NOT EXISTS dienthoai (
  maDienThoai INT(11) NOT NULL AUTO_INCREMENT,
  tenDienThoai VARCHAR(255) NOT NULL,
  namSanXuat INT(11) NOT NULL,
  cauHinh VARCHAR(255) NOT NULL,
  hinhAnh VARCHAR(255) DEFAULT NULL,
  maNhaCungCap INT(11) NOT NULL,
  PRIMARY KEY (maDienThoai),
  FOREIGN KEY (maNhaCungCap) REFERENCES nhacungcap(maNhaCungCap)
);


-- INSERT DATA
-- Table nhacungcap
INSERT INTO `nhacungcap` (`maNhaCungCap`, `tenNhaCungCap`, `diaChi`, `soDienThoai`) VALUES
	(1, 'Samsung', '129 Samsung-ro, Yeongtong-gu, Suwon, Seoul', '1800-4252997'),
	(2, 'Apple', 'Cupertino	One Apple Park Way ', '1-800-275-2273'),
	(3, 'Xiaomi', 'Xiaomi Office Building, 68 Qinghe Middle Street, Beijing, China', '86 010 60606666'),
	(4, 'Oppo', '18 Haibin Road, Wusha, Changan Town, Dongguan, China', '18001032777'),
	(5, 'Huawei', '	Huawei Base, Bantian, Longgang District, Shenzhen, China', '+852-800-931-122'),
	(6, 'Vivo', 'No.1 vivo Road, Changan Town, Dongguan City, Guangdong Province, China', '0769-38816888');


-- Table dienthoai
INSERT INTO `dienthoai` (`maDienThoai`, `tenDienThoai`, `namSanXuat`, `cauHinh`, `hinhAnh`, `maNhaCungCap`) VALUES
	(1, 'iPhone 15 Plus 512GB', 2023, 'Màn hình Công nghệ màn hình: OLED Độ phân giải: Super Retina XDR (1290 x 2796 Pixels) Màn hình rộng: 6.7" - Tần số quét 60 Hz Độ sáng tối đa: 2000 nits Mặt kính cảm ứng: Kính cường lực Ceramic Shield', 'ProductImage_6.png', 2),
	(2, 'Samsung Galaxy A55 5G 12GB/256GB', 2023, 'Màn hình Công nghệ màn hình: Super AMOLED', 'ProductImage_4.png', 1),
	(3, 'OPPO Reno11 F 5G 8GB/256GB', 2023, 'Bảo mật nâng cao: Mở khoá vân tay dưới màn hình Mở khoá khuôn mặt Tính năng đặc biệt: Ứng dụng kép (Nhân bản ứng dụng) Trợ lý ảo Google Assistant Thu nhỏ màn hình sử dụng một tay Thanh bên thông minh Mở rộng bộ nhớ RAM Khoá ứng dụng HDR10+ DCI-P3', 'ProductImage_11.png', 4),
	(4, 'vivo Y100 8GB/256GB', 2023, 'Công nghệ màn hình: AMOLED Độ phân giải: Full HD+ (1080 x 2400 Pixels) Màn hình rộng: 6.67" - Tần số quét 120 Hz Độ sáng tối đa: 1800 nits Mặt kính cảm ứng: Kính cường lực ', 'ProductImage_12.png', 6),
	(5, 'Samsung Galaxy Z Flip6 5G 12GB/256GB', 2023, 'Công nghệ màn hình: Chính: Dynamic AMOLED 2X, Phụ: Super AMOLED Độ phân giải: Chính: FHD+ (1080 x 2640 Pixels) x Phụ: HD+ (720 x 748 Pixels) Màn hình rộng: Chính 6.7" & Phụ 3.4" - Mặt kính cảm ứng: Kính cường lực Corning Gorilla Glass Victus 2', 'ProductImage_13.png', 1);

