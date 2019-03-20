-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 02, 2016 at 02:51 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `phuong_perfume`
--
CREATE DATABASE IF NOT EXISTS `phuong_perfume` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `phuong_perfume`;

-- --------------------------------------------------------

--
-- Table structure for table `binhchon`
--

CREATE TABLE IF NOT EXISTS `binhchon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `diem` int(11) NOT NULL,
  `id_sanpham` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_sanpham` (`id_sanpham`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `chitietdonhang`
--

CREATE TABLE IF NOT EXISTS `chitietdonhang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_donhang` int(11) NOT NULL,
  `id_sanpham` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_donhang` (`id_donhang`),
  KEY `id_sanpham` (`id_sanpham`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=34 ;

--
-- Dumping data for table `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `id_donhang`, `id_sanpham`, `soluong`) VALUES
(13, 13, 26, 1),
(14, 13, 2, 1),
(16, 13, 17, 1),
(18, 14, 4, 1),
(19, 14, 25, 2),
(21, 16, 29, 2),
(22, 16, 1, 1),
(26, 15, 1, 1),
(27, 15, 10, 2),
(28, 15, 18, 1),
(33, 19, 14, 2);

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

CREATE TABLE IF NOT EXISTS `donhang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_khachhang` int(11) NOT NULL,
  `ngaydathang` date NOT NULL,
  `tennguoinhanhang` varchar(200) NOT NULL,
  `dienthoainguoinhan` varchar(20) NOT NULL,
  `diachigiaohang` varchar(300) NOT NULL,
  `ghichu` text,
  `thanhtoan` tinyint(4) NOT NULL DEFAULT '0',
  `id_trangthai` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `id_khachhang` (`id_khachhang`),
  KEY `id_trangthai` (`id_trangthai`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `donhang`
--

INSERT INTO `donhang` (`id`, `id_khachhang`, `ngaydathang`, `tennguoinhanhang`, `dienthoainguoinhan`, `diachigiaohang`, `ghichu`, `thanhtoan`, `id_trangthai`) VALUES
(13, 3, '2016-01-19', 'Trần Tuấn Anh', '0913753951', '1 Nguyễn Thị Minh Khai Q.1', '', 0, 1),
(14, 5, '2016-01-20', 'Nguyễn Ngọc Tình', '0903753951', '227 Nguyễn Văn Cừ Quận 5', '', 1, 2),
(15, 5, '2016-01-22', 'Nguyễn Ngọc Thanh', '0903753951', '227 Nguyễn Văn Cừ Quận 5', 'Giao hÃ ng trong giá» hÃ nh chÃ­nh!', 0, 1),
(16, 4, '2016-01-19', 'Anh Đức', '0903258741', '227 Nguyễn Va7n Cừ', 'Giao hàng trong giờ hành chính', 0, 2),
(19, 4, '2016-01-22', 'Thùy Phương', '0989753951', '357 Lê Hồng Phong P.2 Quận 10', '', 0, 3);

-- --------------------------------------------------------

--
-- Table structure for table `loai`
--

CREATE TABLE IF NOT EXISTS `loai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenloai` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `loai`
--

INSERT INTO `loai` (`id`, `tenloai`) VALUES
(1, 'Nước hoa nữ'),
(2, 'Nước hoa nam'),
(3, 'Nước hoa trẻ em');

-- --------------------------------------------------------

--
-- Table structure for table `nguoidung`
--

CREATE TABLE IF NOT EXISTS `nguoidung` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `hoten` varchar(200) NOT NULL,
  `diachi` varchar(300) NOT NULL,
  `dtdd` varchar(20) NOT NULL,
  `id_vaitro` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `id_vaitro` (`id_vaitro`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `nguoidung`
--

INSERT INTO `nguoidung` (`id`, `email`, `password`, `hoten`, `diachi`, `dtdd`, `id_vaitro`) VALUES
(3, 'miendongthao@gmail.com', '123456789', 'Trần Tuấn Anh', '1 Nguyễn Thị Minh Khai Q.1 TP.HCM', '0913753123', 3),
(4, 'phuong13021982@yahoo.com', '123456789', 'Thùy Phương', '357 Lê Hồng Phong P.2 Quận 10', '0989753951', 2),
(5, 'thanhthanh@gmail.com', 'thanhthanh', 'Nguyễn Ngọc Thanh', '227 Nguyễn Văn Cừ Quận 5', '0989753951', 1),
(6, 'tailieuhoctap@alphatek.edu.vn', '123456789', 'Nguyễn Thị Thêm', '357 Lê Hồng Phong', '0989754123', 4),
(7, 'bichle@gmail.com', 'bichle', 'Nguyễn Thị Bích Lê', '1 Nguyễn Du Quận 1 TP.HCM', '0913654123', 1);

-- --------------------------------------------------------

--
-- Table structure for table `quangcao`
--

CREATE TABLE IF NOT EXISTS `quangcao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hinhanh` varchar(200) NOT NULL,
  `thongdiep` varchar(300) NOT NULL,
  `thongtinchitiet` text,
  `ngaydang` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `quangcao`
--

INSERT INTO `quangcao` (`id`, `hinhanh`, `thongdiep`, `thongtinchitiet`, `ngaydang`) VALUES
(1, 'slide_dior.png', 'Tặng mẫu thử 5ml', NULL, '2016-01-01'),
(2, 'slide_lancome.png', 'Đẳng cấp nước hoa', NULL, '2016-01-03'),
(3, 'slide_chanel.png', 'Tặng son sành điệu', NULL, '2016-01-10'),
(4, 'slide_d_b.png', 'Tặng phiếu Spa', NULL, '2016-01-07');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE IF NOT EXISTS `sanpham` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tensanpham` varchar(300) NOT NULL,
  `mota` text,
  `hinhanh` varchar(300) NOT NULL,
  `dongia` double NOT NULL,
  `dongiaKM` double DEFAULT NULL,
  `soluong` int(11) NOT NULL,
  `ngaytao` date NOT NULL,
  `hienthi` int(11) NOT NULL DEFAULT '1',
  `id_loai` int(11) NOT NULL,
  `id_thuonghieu` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_loai` (`id_loai`),
  KEY `id_thuonghieu` (`id_thuonghieu`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `mota`, `hinhanh`, `dongia`, `dongiaKM`, `soluong`, `ngaytao`, `hienthi`, `id_loai`, `id_thuonghieu`) VALUES
(1, 'Chanel Coco Mademoiselle EDP 100ml', 'Sau Coco, Coco Mademoiselle là một phiên bản bổ sung cho nét tính cách đầy tương phản của Gabrielle Chanel. Đó là biểu hiện cho nét nữ tính, một hương thơm sinh động, tươi mát và phức cảm dành cho những phụ nữ thanh lịch và quý phái.\r\n\r\nCoco Mademoiselle, một hương thơm phương Đông hiện đại, tươi mát, gợi cảm và trừu tượng, được tạo nên để đánh thức tinh thần độc lập của Coco Chanel.\r\n\r\nJacques Helleur, vị giám đốc đầy sáng tạo của Chanel, đã lựa chọn cho Coco Mademoiselle một thiết kế nhiều góc cạnh đã đi vào huyền thoại. Mạnh mẽ và cá tính, vỏ chai được làm trong suốt để lột tả được sự tinh khiết và tươi trẻ của loại nước hoa này.', 'Chanel-Coco-Mademoiselle-EDP-2.png', 3299000, 3299000, 10, '2016-01-04', 1, 1, 1),
(2, 'Chanel Coco Noir EDP 100ml', 'Là một “thành viên” mới trong đại gia đình nước hoa Chanel, Chanel Coco Noir Eau de Parfum gây ấn tượng mạnh ngay khi ra mắt bởi thiết kế vỏ chai sang trọng với tông màu đen huyền bí. Kế thừa tinh hoa đặc sắc từ những đàn anh đi trước, tuyệt phẩm này nổi bật bởi mùi hương mạnh mẽ nhưng không kém phần quyền rũ, thích hợp với những quý cô hiện đại, cá tính và yêu thích sự bí ẩn. Chanel Coco Noir Eau de Parfum mở đầu bằng vị thanh khiết của bưởi và cam bergamot, tiếp đến là hương nồng nàn của những đóa hồng rực rỡ và hoa thủy tiên kiêu kỳ và cuối cùng, sự hòa quyện của đậu Tonka, gỗ đàn hương, hoắc hương, xạ hương và vani để lại cảm giác lắng đọng pha lẫn chút lưu luyến khó quên.', 'Chanel-Coco-Noir-EDP-2.png', 3942000, 3942000, 15, '2016-01-05', 1, 1, 1),
(3, 'CHANEL NO.19 POUDRÉ POUR FEMME', 'Lấy trung tâm là hương thơm của hoa diên vĩ, Chanel No.19 Poudre được phát triển bằng cách thêm thắt các loại xạ hương mới mẻ do chính nhà sản xuất tìm ra. Nói đến hoa diên vĩ, nhà sản xuất đã nhận xét loại hoa này như là một thành phần nguyên liệu cực kì khó chiều.\r\nThứ nhất, nguyên liệu thô rất khó để thu thập , bởi vì chất lượng đầu ra của tinh dầu thành phẩm rất dễ bị ảnh hưởng, ngay cả độ ẩm của đất hoặc thời tiết đều khiến việc sản xuất bị ảnh hưởng. Thứ hai ,quá trình chiết xuất tinh dầu hoa diên vĩ cực kì tốn thời gian và nhân công lao động, có thể kéo dài đến hàng năm trời. Tuy nhiên, điều đặc biệt nhất của nhãn hàng Chanel là việc Chanel chưa bao giờ cam kết trong việc bảo đảm sự đồng nhất về chất lượng mùi hương.\r\nPhiên bản mới của Chanel No.19 được giới thiệu sẽ là mùi hương sử dụng các loại xạ hương được thu nhập theo phương pháp thủ công tối ưu nhất.', 'chanel-no_932g-40.-19-poudre_edp-700x700.png', 3842000, 3842000, 10, '2016-01-06', 1, 1, 1),
(4, 'CHANEL CHANCE EAU VIVE EDT', 'Chanel ra mắt nước hoa mới mang tên CHANCE EAU VIVE thuộc bộ sưu tập Chanel Chance vào ngày 12 tháng 6 năm 2015. Bộ sưu tập bắt đầu với hương thơm Chanel Chance vào năm 2003, tiếp theo là Chanel Chance Eau Fraiche vào năm 2007 và Chanel Chance Eau Tendre trong năm 2010.\r\n\r\nThiết kế giống như các phiên bản trước đó của bộ sưu tập và các dung tích sản xuất như 35ml, 50ml và 100ml Eau de toilette Fragrance lặp đi lặp lại dưới dạng cặn giống như các phiên bản trước đó của bộ sưu tập và sẽ có sẵn như là 50 và 100 ml Eau de Toilette.', '681345-Zoom_4is0-kf.png', 3385000, 3100000, 20, '2016-01-01', 1, 1, 1),
(5, 'Chanel Allure Homme Sport 100ml', 'Ra đời 5 năm sau sự thành công ngoạn mục trên toàn thế giới của Allure Homme, Allure Sport for Men mở ra thế giới của những người đàn ông, một thế giới của thể thao và tự do. Loại nước hoa này tự hào mang tới cho bạn một hương vị mới mà sự quyến rũ của nó có thể được ví với làn không khí tươi mát trên da thịt trần. Không phải ngẫu nhiên mà hình ảnh quảng cáo cho sản phẩm này là một chàng trai đang đua thuyền. Trẻ trung, bộ ngực vạm vỡ để trần, sự hấp dẫn tỏa ra ấm áp và tự nhiên.', 'Chanel-Allure-Homme-Sport_2.png', 2551000, 2251000, 18, '2016-01-02', 1, 2, 1),
(6, 'CHANEL ALLURE FOR WOMEN EDP', 'Đến với Allure EDP là đến với thế giới hương thơm vô cùng vô tận. Đầu tiên là hương thơm dịu nhẹ, thanh mát của cam bergamot, quýt, hoa sen, trái đào. Tiếp đến là hương giữa với sự ngọt ngào tràn đầy năng lượng của hương hoa nhài, hoa \r\ncam, hoa hồng kết hợp cùng hoa mẫu đơn. Cuối cùng, Allure EDP dẫn ta đến chốn du miên, miền thảo mộc ấm áp và quyến rũ bởi sự kết hợp tuyệt vời của Vani, gỗ tuyết tùng và cỏ vetiver. Tất cả quyện lại và tạo nên một bản nhạc hương thơm có sức hút bất tận. Allure EDP nước hoa của tình yêu, của cá tính, của khát khao...\r\nSẽ có nhiều dung tích cho các bạn chọn lựa tại như 100ml, 80ml, 70ml, 50ml, 30ml, 10ml, 5ml...', 'Chanel-Allure-For-Women-EDP-100ml_2.png', 3724000, 3500000, 30, '2016-01-03', 1, 1, 1),
(7, 'Lancome Tresor', 'Nước hoa Tresor là loại nước hoa thứ 12 trong vòng 28 năm của hãng Lancôme. Trước khi tung ra thị trường, nó được chỉnh sửa và thiết kế lại 7 lần. Nó đạt được sự thành công to lớn khắp toàn cầu vì nó đã mang lại sự tự tin và niềm vui cho người sử dụng bởi nó giúp ngưới ta cảm nhận được những nét riêng biệt độc đáo của mình mà không thể lầm lẫn với bất kỳ ai khác – loại nước hoa này đã tạo ra bước ngoặt trong ngành nước hoa vào những năm 90 của thế kỷ 20. Hương đầu có sự hiện diện của trái cây với đào chín mọng và hương thơm của quả mơ, tiếp ngay sau đó là hương hoa hồng nồng nàn. Irit mạnh mẽ, hoa vòi voi và hoa violet đã kích thích mùi gỗ đàn hương và xạ hương cùng khép lại mùi hương đặc biệt và kéo dài ấy. Kiểu chai này được thiết kế bởi Areka. Areka đã được yêu cầu tạo ra “kiểu chai vì hạnh phúc và niềm vui”, một vật thể tạo sự thoải mái khi đụng vào nó. Màu sắc của nó làm cho ta liên tưởng tới bầu trời mang sự nồng cháy của hoàng hôn', 'Lancome-Tresor_1.png', 2106000, 1790000, 15, '2016-01-07', 1, 1, 2),
(8, 'Lancome La Nuit Tresor', 'Hãng nước hoa Lancome đã cho ra mắt dòng nước hoa Lancome La Nuit Tresor vào tháng 2/2015. Mùi hương này được đánh giá như là một thứ tình dược mang hương thơm ngọt ngào của bánh kẹo.  Được tạo ra từ hai nhà sản xuất Christophe Raynaud và Amandine Marie, La Nuit Tresor thể hiện một góc tối ẩn khuất của hoa hồng bằng sự phối hợp giữa hương thơm hồng nhung và hoa phong lan Tahiti .Ngoài ra còn có sự xuất hiện của trầm hương thiên nhiên , cói, hoắc hương , kẹo giòn hương quả vải trong hỗn hợp mùi hương này. Thiết kế vỏ chai là hình ảnh viên kim cương được quấn quanh cổ bởi dải lụa satin màu đen tạo thành hình hoa hồng rất sang trọng và quý phái.', 'lancaame-traasor-la-nuit-edp-75ml-2-5fl-oz_(1)_7l72-w4.png', 3098000, 2063000, 20, '2016-01-06', 1, 1, 2),
(9, 'Lancôme Tresor In Love', 'Ra đời dựa trên những câu chuyện tình yêu lãng mạn, nước hoa Lancôme Tresor In Love chính là món quà hãng Lancôme mang đến cho các cặp đôi đang yêu và đã yêu, những tâm hồn lãng mạn tìm được sự đồng điệu.', 'Lancôme-Tresor-In-Lovel_2.png', 2006000, 1707000, 12, '2016-01-07', 1, 1, 2),
(10, 'Lancôme Tresor Midnight Rose', 'Mọi loại nước hoa của Lancôme đều có vẻ lãng mạn của riêng nó. Nước hoa nữ Tresor Midnight Rose là sự ấm áp, ngọt ngào nhưng huyền diệu với ý tưởng một bông hoa chỉ nở vào lúc nửa đêm.', 'Lancôme-Tresor-Midnight-Rose_2.png', 2224000, 1890000, 25, '2016-01-05', 1, 1, 2),
(11, 'Versace Eros For Men', 'Được giới thiệu lần đầu tại liên hoan phim Cannes 2012, Versace Eros lấy nguồn cảm hứng từ vị thần tình yêu trong thần thoại  thần thoại Hy Lạp, Eros là vị thần hy lạp của tình yêu, là trung tâm của các hương thơm., là sự kết hợp và thể hiện của niềm đam mê vô tận và ham muốn mãnh liệt. Đây là sự bổ sung mới nhất cho dòng Versace của nước hoa nam. ', 'Versace-Eros-For-Men_2.png', 1900000, 1615000, 10, '2016-01-04', 1, 2, 3),
(12, 'Versace Pour Homme', 'Mùi hương mới cho nam giới - Nước hoa Versace Pour Homme - là sự pha trộn các thành phần tinh chất có nguồn gốc Địa Trung Hải với hỗn hợp hương thơm hàng đầu rất phù hợp cho nam giới ngày nay: đó là những người đàn ông tri thức và tự tin, năng động, mạnh mẽ và đầy đam mê, sống hài hòa với thế giới tự nhiên.', 'Versace-Pour-Homme_2.png', 2100000, 1785000, 17, '2016-01-05', 1, 2, 3),
(13, 'Versace Bright Crystal Absolu', 'Versace Bright Crystal Absolu được mệnh danh là nước hoa của tình yêu nóng bỏng. Tiếp nối sự thành công của Bright Crystal, hãng thời trang danh tiếng thế giới đã cho tung ra một loại nước hoa mạnh hơn, nóng bỏng hơn, cuốn hút hơn vào năm 2013 nhằm thỏa mãn sự mong đợi của những khách hàng đáng yêu.', 'Versace-Bright-Crystal-Absolu_2.png', 1900000, 1615000, 25, '2016-01-03', 1, 1, 3),
(14, 'Versace Pour Femme', 'Hãng nước hoa Versace vừa cho ra đời một loại mới thật đơn giản với tên Versace (Versace Pour Femme hoặc Versace Femme) dành cho nữ. Được xếp vào loại với hương hoa cổ điển. Donatella Versace đã phát biểu rằng: “Tôi đã khởi nghiệp bằng việc sáng chế ra dòng cổ điển, và cho đến nay tôi vẫn rất tự tin vào phong cách này. Vì phong cách cổ điển thì luôn là cái cốt lõi của mọi xu hướng thời trang và chắng bao giờ lỗi thời cả. Tôi tự tin rằng với nước hoa Versace Femme cùng phong cách cổ điển truyền thống của Versace tôi vẫn có thể gặt hái thành công”.', 'Versace-Pour-Femme-EDP-1.png', 1562000, 1327000, 15, '2016-01-03', 1, 1, 3),
(15, 'Versace Versense', 'Kể từ khi giới thiệu lọ nước hoa Versace đầu tiên vào năm 1981, nhãn hiệu thời trang Ý này luôn bổ sung vào bộ sưu tập nước hoa của mình những sản phẩm mới để tất cả mọi người có thể khoác lên mình những phong cách mang dấu ấn của thời trang Versace: Sang trọng, mê đắm và đầy khoái lạc.\r\nNhư một bó hoa đẹp giữa vùng Địa Trung Hải, nước hoa Versace Versense mang đến cho người phụ nữ hương thơm tươi mới và tràn trề năng lượng, khơi gợi sức sống của mỗi người theo dấu ấn riêng của Versace.', 'Versace-Versense-EDT_xdfj-63.png', 1736000, 1475000, 15, '2016-01-01', 1, 1, 3),
(16, 'D&G Le fou 21 pour homme', 'Le Fou 21 là một loại nước hoa được thiết kế cho các cá nhân bất cẩn và tự phát, do đó được gọi là "tên hề". Thành phần của nó được làm bằng cam bergamot, quả bách thảo, gừng và dương xỉ.', 'D&G-Le-fou-21-pour-homme_38g8-9m.png', 3400000, 3076000, 22, '2016-01-11', 1, 2, 4),
(17, 'Dolce & Gabbana Dolce', 'Nước hoa Dolce & Gabbana Dolce được hãng D&G ra mắt vào năm 2014. Đây là chai nước hoa dành cho nữ mang mùi hương và cảm xúc độc đáo của hãng. Dolce đại diện cho hành trình của cảm xúc gợi cảm trên đảo Sicily kết hợp cùng cảm hứng thời trang phiêu linh của D&G.\r\nTheo như mô tả, đây là một hương thơm mềm mại, nữ tính của hoa trắng. Một sự kết hợp tươi mát giữa đu đủ, tinh dầu hoa cảm, hoa thủy tiên, xạ hương ở nồng độ Eau De Parfum.', 'Dolce-&-Gabbana-Dolce_2.png', 2038000, 1834000, 17, '2016-01-08', 1, 1, 4),
(18, 'DOLCE & GABBANA INTENSO POUR HOMME', 'Năm 2014. Dolce & Gabbana Intenso Pour Homme ra đời với tư cách là một phiên bản cải tiến mới của Dolce & Gabbana Pour Homme đã xuất hiện vào năm 2012. Intenso Pour Homme được biết đến là một hương thơm mang bản chất của gỗ thơm toát lên sự thanh lịch đại diện cho sự tươi mới, phong phú và ấm áp. Những làn hương hết sức bản năng và thuần khiết chứa đựng cảm xúc mãnh liệt; hương thơm là sức mạnh của một người đàn ông được xác định, với một trái tim mà là bắt nguồn từ truyền thống trong thế giới hiện đại. Gương mặt xuất hiện trong quảng cáo của sản phẩm này là nam diễn viên Colin Farrell.', '21740-29212-thickbox_qrpl-dd.png', 2060000, 1854000, 27, '2016-01-04', 1, 2, 4),
(19, 'Dolce & Gabbana Rose The One', 'Đỉnh cao về sự quý phái mà tao nhã,nước hoa  Rose The One là một tặng phẩm cho nữ hoàng trong thế giới của các loài hoa – hoa hồng. Sự quý phái và nữ tính ẩn chứa trong hương thảo dược đặc trưng, Rose The One là một phiên bản thảo dược hoa hồng của nước hoa Pour Femme.', 'Dolce-&-Gabbana-Rose-The-One_1_i20p-ns.png', 1900000, 1710000, 12, '2016-01-18', 1, 1, 4),
(20, 'Hypnotic Poison Eau Sensuelle', 'Hypnotic Poison Eau Sensuelle - một thành viên mới trong bộ sưu tập đầy màu sắc và hương thơm của nhãn hiệu Dior. Mùi hương này là sự kết hợp hài hòa giữa hương hoa phong lan với 1 vài điểm nhấn là hương ngọt ngào của vani tạo nên một mùi hương sinh động. Để tạo thêm ấn tượng, nhà thiết kế còn cho thêm vào những hương liệu từ nhiều loại hoa khác nhau  như hoa huệ, hoa hồng, cây nguyệt dạ hương. Hypnotic Poison Eau Sensuelle có khả năng giữ mùi rất lâu nhờ vào sự có mặt của gỗ đàn hương ở lớp hương cuối cùng. ', 'Dior-Hypnotic-Poison-Eau-Sensuelle-EDT-1.png', 3172000, 2854000, 22, '2016-01-11', 1, 1, 5),
(21, 'Dior Miss Dior Le Parfum', 'Hãng thời trang Dior đã quyết định tiếp tục làm đồ sộ thêm dòng sản phẩm Miss Dior với sản phẩm mới mang tên Dior Miss Dior Le Parfum. Được ra mắt vào tháng 9/2012, loại nước hoa này mang một hương thơm hết sức phong phú và đặc trưng. Mùi hương mà Le Parfum tạo ra gợi tả một nét đẹp tinh túy, gợi cảm, quyến rũ rất thích hợp với những đêm hẹn lãng mạn dành cho hai người.\r\nVới tông mùi phương Đông, nó như một món trang sức phản ánh vẻ đẹp phương Đông lung linh, huyền bí. Nữ diễn viên Natalie Portman được chọn là gương mặt đại diện cho sản phẩm này.', '3348901111300-900x900_a1xf-14.png', 2504000, 2783000, 10, '2016-01-09', 1, 1, 5),
(22, 'GIFTSET DIOR LES PARFUM DE L''AVENUE MONTAIGNE', 'Gift Set gồm 5 sản phẩm: Nước hoa nữ Dior Miss Dior Chérie EDP 7,5ml. Nước hoa nữ Dior Diorissimo EDT 7,5ml, Nước hoa nữ Dior Addict 2 EDT 7,5ml, Nước hoa nữ Dior Forever And Ever EDT 7,5ml, Nước hoa nữ Dior Hypnotic Poison Eau Sensuelle EDT 7,5ml', 'f3c8a0e8ccf814c224c7165fc66d8c2c_2_7mwl-lx.png', 2122000, 1909000, 17, '2016-01-10', 1, 1, 5),
(23, 'Dior Addict', 'Dior Addict làm thỏa mãn các giác quan bằng mùi hương lộng lẫy của hoa mai dương, sự khêu gợi của dạ hương, hương thơm ngạt ngào của rưọu whisky ngô vani kết hợp với gỗ đàn hương và đậu tonka.\r\nDior Addict gợi lên trong lòng người chọn nó cảm giác say mê. Gợi cảm, nhẹ nhàng, nữ tính, loại nước hoa này sẽ giúp bạn có cảm giác khỏe khoắn suốt ngày dài, rất thích hợp với những người phụ nữ hiện đại.', 'Dior_Addict.png', 3156000, 2840000, 12, '2016-01-14', 1, 1, 5),
(24, 'DISNEY DAFFY DUCK FOR KIDS', 'Loại nước hoa dành cho bé trai và bé gái trên 3 tuổi. Mùi hương đặc trưng: hoa cỏ. Phong cách: Năng động, tươi mát', 'KIDS-DAFFY-DUCK-EDT-100ML_2_9lo9-hd.png', 895000, 447000, 25, '2016-01-08', 1, 3, 6),
(25, 'DISNEY PRINCESS TANGLED RAPUNZEL FOR KIDS', 'Loại nước hoa dành cho bé gái trên 3 tuổi. Mùi hương đặc trưng: hoa cỏ. Phong cách: Năng động, tươi mát', 'KIDS-–-MY-PRINCESS-&-ME-Tim-100ML_1_5je8-25.png', 895000, 497000, 30, '2016-01-05', 1, 3, 6),
(26, 'DISNEY TINKERBELL FAIRIES FOR KIDS', 'Loại nước hoa dành cho bé gái trên 3 tuổi. Mùi hương đặc trưng: hoa cỏ. Phong cách: Năng động, tươi mát', '663350050752-Disney-Tinkerbell-Fairies-1_3rsp-mx.png', 895000, 447000, 18, '2016-01-08', 1, 3, 6),
(29, 'DISNEY MICKEY MOUSE FOR KIDS', 'Loại nước hoa dành cho bé trai trên 3 tuổi\nMùi hương đặc trưng: hoa cỏ\nPhong cách: Năng động, tươi mát', 'Mickey-Mouse-100ml_1.png', 895000, 447000, 20, '2016-01-15', 1, 3, 6),
(30, 'Dolce Vita EDT 100ML', 'Dolce Vita trong tiếng Ý có nghĩa là "cuộc sống thật ngọt ngào". Đúng như tên gọi của mình, loại nước hoa này mang hương hoa thơm ngát, đầy vui tươi và hạnh phúc. Là sự kết hợp giữa hương hoa với đào và mơ, Dolce Vita giúp bạn dễ dàng lựa chọn trang phục phù hợp với nó. Với mùi hương cuối là vani và gỗ đàn hương, nó sẽ khiến bạn luôn cảm thấy nhẹ nhàng.', 'Dior-Dolce-Vita.png', 2113000, 1901000, 10, '2016-01-29', 1, 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `thuonghieu`
--

CREATE TABLE IF NOT EXISTS `thuonghieu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenthuonghieu` varchar(300) NOT NULL,
  `hinhanh` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `thuonghieu`
--

INSERT INTO `thuonghieu` (`id`, `tenthuonghieu`, `hinhanh`) VALUES
(1, 'Chanel', 'coco.png'),
(2, 'Lancome', 'lancome.png'),
(3, 'Versace', 'versace.png'),
(4, 'Dolce & Gabbana', 'd_g.png'),
(5, 'Dior', 'dior.jpg'),
(6, 'Disney', 'disney.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `trangthaidonhang`
--

CREATE TABLE IF NOT EXISTS `trangthaidonhang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tentrangthai` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `trangthaidonhang`
--

INSERT INTO `trangthaidonhang` (`id`, `tentrangthai`) VALUES
(1, 'Nhận đơn hàng'),
(2, 'Đang giao hàng'),
(3, 'Đã giao hàng'),
(4, 'Hủy đơn hàng');

-- --------------------------------------------------------

--
-- Table structure for table `vaitro`
--

CREATE TABLE IF NOT EXISTS `vaitro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenvaitro` varchar(100) NOT NULL,
  `mota` text,
  PRIMARY KEY (`id`,`tenvaitro`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `vaitro`
--

INSERT INTO `vaitro` (`id`, `tenvaitro`, `mota`) VALUES
(1, 'Khách hàng', 'Đến tham quan và mua sắm'),
(2, 'Quản trị viên', 'Quản lý website'),
(3, 'Nhân viên', 'Quản lý đơn hàng'),
(4, 'Kế toán', 'Thống kê hàng hóa và đơn hàng');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `binhchon`
--
ALTER TABLE `binhchon`
  ADD CONSTRAINT `binhchon_ibfk_1` FOREIGN KEY (`id_sanpham`) REFERENCES `sanpham` (`id`);

--
-- Constraints for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD CONSTRAINT `chitietdonhang_ibfk_1` FOREIGN KEY (`id_donhang`) REFERENCES `donhang` (`id`),
  ADD CONSTRAINT `chitietdonhang_ibfk_2` FOREIGN KEY (`id_sanpham`) REFERENCES `sanpham` (`id`);

--
-- Constraints for table `donhang`
--
ALTER TABLE `donhang`
  ADD CONSTRAINT `donhang_ibfk_1` FOREIGN KEY (`id_khachhang`) REFERENCES `nguoidung` (`id`),
  ADD CONSTRAINT `donhang_ibfk_2` FOREIGN KEY (`id_trangthai`) REFERENCES `trangthaidonhang` (`id`);

--
-- Constraints for table `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD CONSTRAINT `nguoidung_ibfk_1` FOREIGN KEY (`id_vaitro`) REFERENCES `vaitro` (`id`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`id_loai`) REFERENCES `loai` (`id`),
  ADD CONSTRAINT `sanpham_ibfk_2` FOREIGN KEY (`id_thuonghieu`) REFERENCES `thuonghieu` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
