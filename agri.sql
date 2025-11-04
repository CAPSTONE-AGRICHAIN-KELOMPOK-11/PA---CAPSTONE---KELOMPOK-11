-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 04, 2025 at 12:51 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agrichain`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(10) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `no_telp` varchar(20) NOT NULL,
  `posisi` varchar(100) NOT NULL,
  `role` enum('admin') NOT NULL DEFAULT 'admin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama_lengkap`, `username`, `password`, `no_telp`, `posisi`, `role`) VALUES
('ADM01', 'Lutfi Dafa Purbaya', 'adminlutfi', 'iniadmin123', '081234567890', 'Kepala IT', 'admin'),
('ADM02', 'Nanda Pesona Putri', 'adminnanda', 'iniadmin456', '082345678901', 'Staff IT', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `distributor`
--

CREATE TABLE `distributor` (
  `id_distributor` varchar(10) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `no_telp` varchar(20) NOT NULL,
  `nama_usaha` varchar(100) NOT NULL,
  `wilayah_pasar` varchar(150) NOT NULL,
  `role` enum('distributor') NOT NULL DEFAULT 'distributor'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `distributor`
--

INSERT INTO `distributor` (`id_distributor`, `nama_lengkap`, `username`, `password`, `no_telp`, `nama_usaha`, `wilayah_pasar`, `role`) VALUES
('DIS01', 'Andi Prasetyo', 'andipras_88', 'andi123', '081234567801', 'AgroMaju Jaya', 'Bandung', 'distributor'),
('DIS02', 'Rina Kartika Putri', 'rinakartika99', 'rina2025', '081234567802', 'RinaFarm Supply', 'Jakarta', 'distributor'),
('DIS03', 'Dedi Firmansyah', 'dedi_firm', 'dedi456', '081234567803', 'TaniSentosa', 'Semarang', 'distributor'),
('DIS04', 'Siti Nurhaliza', 'sitinurhaliza', 'siti321', '081234567804', 'SumberMakmur', 'Surabaya', 'distributor'),
('DIS05', 'Agus Wahyudi', 'agus_wahyu07', 'agus555', '081234567805', 'AgusTani Group', 'Yogyakarta', 'distributor'),
('DIS06', 'Dewi Anggraini', 'dewianggraini12', 'dewi888', '081234567806', 'TaniBerkah', 'Bogor', 'distributor'),
('DIS07', 'Rizki Saputra', 'rizkis_07', 'rizki777', '081234567807', 'RizkiAgro', 'Medan', 'distributor'),
('DIS08', 'Lina Marlina', 'linamar_99', 'lina123', '081234567808', 'LinaAgroTani', 'Cirebon', 'distributor'),
('DIS09', 'Rafi Ahmad', 'rafiahmad23', 'rafi999', '081234567809', 'TaniJaya Abadi', 'Makassar', 'distributor'),
('DIS10', 'Rina Dewi Lestari', 'rinadewi98', 'dewi432', '081234567810', 'SuksesAgro', 'Solo', 'distributor'),
('DIS11', 'Yudi Hartono', 'yudihartono', 'yudi654', '081234567811', 'HartonoFarm', 'Tangerang', 'distributor'),
('DIS12', 'Mira Anggraini', 'miranggraini_08', 'mira123', '081234567812', 'BerkahTani Sejahtera', 'Padang', 'distributor'),
('DIS13', 'Bayu Pradana', 'bayu_pdn', 'bayu2024', '081234567813', 'PradanaAgro', 'Pontianak', 'distributor'),
('DIS14', 'Eka Sari Wulandari', 'ekasari_w', 'eka123', '081234567814', 'EkaAgro Lestari', 'Banjarmasin', 'distributor'),
('DIS15', 'Fajar Ramadhan', 'fajarramadhan', 'fajar333', '081234567815', 'TaniMitra', 'Malang', 'distributor'),
('DIS16', 'Ayu Fitriani', 'ayufitriani01', 'ayu2025', '081234567816', 'FitriAgro', 'Denpasar', 'distributor'),
('DIS17', 'Rahmat Hidayat', 'rahmat_hid', 'rahmat123', '081234567817', 'RahmatFarm', 'Palembang', 'distributor'),
('DIS18', 'Lukman Hakim', 'lukmanhakim89', 'lukman999', '081234567818', 'HakimAgro', 'Bandar Lampung', 'distributor'),
('DIS19', 'Nanda Salsabila', 'nandasalsa_10', 'nanda555', '081234567819', 'SalsabilaTani', 'Bengkulu', 'distributor'),
('DIS20', 'Fauzan Alamsyah', 'fauzanalam', 'fauzan123', '081234567820', 'FauzanTani', 'Aceh', 'distributor'),
('DIS21', 'Yuliana Pratiwi', 'yuliana88', 'yuli2025', '081234567821', 'PratiwiFarm', 'Manado', 'distributor'),
('DIS22', 'Taufik Ramli', 'taufikramli', 'taufik789', '081234567822', 'RamliAgro Mandiri', 'Samarinda', 'distributor'),
('DIS23', 'Mega Lestari Putri', 'mega_putri', 'mega123', '081234567823', 'MegaBerkah', 'Kupang', 'distributor'),
('DIS24', 'Iqbal Setiawan', 'iqbalset_99', 'iqbal456', '081234567824', 'SetiaAgro', 'Serang', 'distributor'),
('DIS25', 'Salsa Khairunnisa', 'salsakhairun', 'salsa888', '081234567825', 'KhairunFarm', 'Depok', 'distributor'),
('DIS26', 'Bagas Pramudya', 'bagaspram_77', 'bagas777', '081234567826', 'PramudyaAgro', 'Bekasi', 'distributor'),
('DIS27', 'Citra Ayuningtyas', 'citrayuning', 'citra555', '081234567827', 'CitraFarm', 'Cilacap', 'distributor'),
('DIS28', 'Robby Susanto', 'robbysus_90', 'robby123', '081234567828', 'RobbyAgro Sejahtera', 'Probolinggo', 'distributor'),
('DIS29', 'Farhan Rizqullah', 'farhan_rizq', 'farhan2024', '081234567829', 'RizqullahFarm', 'Pekanbaru', 'distributor'),
('DIS30', 'Intan Maharani', 'intanmaha_11', 'intan111', '081234567830', 'MaharaniAgro', 'Pontianak', 'distributor'),
('DIS31', 'Dimas Saputro', 'dimassaputro', 'dimas007', '081234567831', 'SaputroAgro', 'Batam', 'distributor'),
('DIS32', 'Tia Amelia Putri', 'tiaamelia', 'tia222', '081234567832', 'AmeliaTani', 'Medan', 'distributor'),
('DIS33', 'Novi Handayani', 'novi_hdy', 'novi333', '081234567833', 'HandayaniAgro', 'Bogor', 'distributor'),
('DIS34', 'Roni Kurniawan', 'ronikurnia', 'roni444', '081234567834', 'KurniaFarm', 'Jakarta', 'distributor'),
('DIS35', 'Anita Sari Dewi', 'anitasarid', 'anita555', '081234567835', 'SariDewiAgro', 'Semarang', 'distributor'),
('DIS36', 'Galih Prasetya', 'galihpras_99', 'galih999', '081234567836', 'PrasetyaAgro', 'Surabaya', 'distributor'),
('DIS37', 'Desi Anggraini', 'desiang_23', 'desi123', '081234567837', 'DesiFarm', 'Tangerang', 'distributor'),
('DIS38', 'Putra Hidayanto', 'putrahid_10', 'putra111', '081234567838', 'PutraAgro', 'Yogyakarta', 'distributor'),
('DIS39', 'Melati Kusuma', 'melatiksm', 'melati789', '081234567839', 'KusumaTani', 'Bali', 'distributor'),
('DIS40', 'Reza Aditya', 'rezaadit_24', 'reza123', '081234567840', 'AdityaAgro', 'Bandung', 'distributor'),
('DIS41', 'Dian Wulandari', 'dianwulan', 'dian444', '081234567841', 'WulanFarm', 'Cirebon', 'distributor'),
('DIS42', 'Erlangga Pradipta', 'erlanggap_88', 'erlangga88', '081234567842', 'PradiptaAgro', 'Solo', 'distributor'),
('DIS43', 'Nurul Fitriani', 'nurulfit_21', 'nurul123', '081234567843', 'FitrianiFarm', 'Makassar', 'distributor'),
('DIS44', 'Vina Oktaviani', 'vinaokta', 'vina321', '081234567844', 'OktavianiTani', 'Malang', 'distributor'),
('DIS45', 'Arif Budiman', 'arifbud_10', 'arif555', '081234567845', 'BudimanAgro', 'Palembang', 'distributor'),
('DIS46', 'Bella Kartini', 'bellakartini', 'bella222', '081234567846', 'KartiniFarm', 'Manado', 'distributor'),
('DIS47', 'Hendra Wijaya', 'hendrawij_12', 'hendra789', '081234567847', 'WijayaAgro', 'Padang', 'distributor'),
('DIS48', 'Tina Rahmawati', 'tinarahma', 'tina999', '081234567848', 'RahmaFarm', 'Serang', 'distributor'),
('DIS49', 'Zaki Firmansyah', 'zakifirm_45', 'zaki123', '081234567849', 'FirmansyahAgro', 'Banjarmasin', 'distributor'),
('DIS50', 'Dewi Oktarina', 'dewiokta77', 'dewi888', '081234567850', 'OktarinaAgro', 'Pontianak', 'distributor'),
('DIS51', 'Anwar Fauzi', 'anwarfz_01', 'anwar2024', '081234567851', 'FauziFarm', 'Bali', 'distributor'),
('DIS52', 'Sinta Lestari', 'sintalest_22', 'sinta555', '081234567852', 'LestariAgro', 'Yogyakarta', 'distributor'),
('DIS53', 'Rizal Hakim', 'rizalhakim', 'rizal999', '081234567853', 'HakimAgro', 'Depok', 'distributor'),
('DIS54', 'Mega Anggraeni', 'megaanggr_08', 'mega888', '081234567854', 'AnggraeniTani', 'Cilacap', 'distributor'),
('DIS55', 'Fikri Setiawan', 'fikriset_10', 'fikri321', '081234567855', 'SetiaFarm', 'Bekasi', 'distributor');

-- --------------------------------------------------------

--
-- Table structure for table `hasil_panen`
--

CREATE TABLE `hasil_panen` (
  `id_panen` varchar(10) NOT NULL,
  `jumlah_panen` int(11) NOT NULL,
  `stok_gudang` int(11) NOT NULL,
  `satuan` varchar(20) NOT NULL,
  `tanggal_panen` date NOT NULL,
  `id_petani` varchar(10) NOT NULL,
  `id_admin` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hasil_panen`
--

INSERT INTO `hasil_panen` (`id_panen`, `jumlah_panen`, `stok_gudang`, `satuan`, `tanggal_panen`, `id_petani`, `id_admin`) VALUES
('PAN01', 1520, 1300, 'kg', '2024-02-15', 'PET01', 'ADM02'),
('PAN02', 1780, 1550, 'kg', '2024-04-09', 'PET02', 'ADM02'),
('PAN03', 1650, 1400, 'kg', '2024-05-23', 'PET03', 'ADM02'),
('PAN04', 1890, 1650, 'kg', '2024-07-05', 'PET04', 'ADM01'),
('PAN05', 1370, 1150, 'kg', '2024-06-14', 'PET05', 'ADM02'),
('PAN06', 2300, 2000, 'kg', '2024-03-19', 'PET06', 'ADM02'),
('PAN07', 1500, 1270, 'kg', '2024-08-21', 'PET07', 'ADM02'),
('PAN08', 1720, 1450, 'kg', '2024-01-30', 'PET08', 'ADM02'),
('PAN09', 2480, 2180, 'kg', '2024-09-02', 'PET09', 'ADM02'),
('PAN10', 1340, 1100, 'kg', '2024-10-27', 'PET10', 'ADM01'),
('PAN11', 1820, 1550, 'kg', '2024-12-03', 'PET11', 'ADM02'),
('PAN12', 2210, 1900, 'kg', '2025-01-19', 'PET12', 'ADM02'),
('PAN13', 1760, 1520, 'kg', '2025-02-25', 'PET13', 'ADM02'),
('PAN14', 1440, 1210, 'kg', '2024-03-11', 'PET14', 'ADM02'),
('PAN15', 1870, 1630, 'kg', '2024-05-06', 'PET15', 'ADM02'),
('PAN16', 1620, 1390, 'kg', '2024-06-28', 'PET16', 'ADM01'),
('PAN17', 1730, 1490, 'kg', '2024-08-03', 'PET17', 'ADM02'),
('PAN18', 1910, 1660, 'kg', '2024-09-16', 'PET18', 'ADM02'),
('PAN19', 1450, 1210, 'kg', '2024-10-05', 'PET19', 'ADM02'),
('PAN20', 1680, 1420, 'kg', '2024-11-12', 'PET20', 'ADM02'),
('PAN21', 1340, 1100, 'kg', '2025-01-25', 'PET21', 'ADM02'),
('PAN22', 1270, 1050, 'kg', '2024-12-22', 'PET22', 'ADM02'),
('PAN23', 1510, 1290, 'kg', '2025-02-18', 'PET23', 'ADM01'),
('PAN24', 1850, 1590, 'kg', '2025-03-21', 'PET24', 'ADM02'),
('PAN25', 1950, 1720, 'kg', '2025-04-14', 'PET25', 'ADM02'),
('PAN26', 1460, 1230, 'kg', '2025-05-19', 'PET26', 'ADM02'),
('PAN27', 1580, 1330, 'kg', '2025-06-07', 'PET27', 'ADM02'),
('PAN28', 2440, 2160, 'kg', '2025-06-29', 'PET28', 'ADM02'),
('PAN29', 1380, 1150, 'kg', '2025-07-12', 'PET29', 'ADM02'),
('PAN30', 1890, 1660, 'kg', '2025-08-05', 'PET30', 'ADM01'),
('PAN31', 1600, 1380, 'kg', '2024-02-07', 'PET31', 'ADM02'),
('PAN32', 1330, 1090, 'kg', '2024-03-13', 'PET32', 'ADM02'),
('PAN33', 1720, 1470, 'kg', '2024-04-18', 'PET33', 'ADM02'),
('PAN34', 2150, 1860, 'kg', '2024-06-02', 'PET34', 'ADM02'),
('PAN35', 1560, 1320, 'kg', '2024-07-15', 'PET35', 'ADM02'),
('PAN36', 1410, 1170, 'kg', '2024-09-01', 'PET36', 'ADM02'),
('PAN37', 1840, 1600, 'kg', '2024-10-10', 'PET37', 'ADM02'),
('PAN38', 2350, 2070, 'kg', '2025-03-17', 'PET38', 'ADM02'),
('PAN39', 1460, 1220, 'kg', '2025-04-27', 'PET39', 'ADM02'),
('PAN40', 1680, 1430, 'kg', '2025-06-01', 'PET40', 'ADM02'),
('PAN41', 1800, 1550, 'kg', '2025-07-08', 'PET41', 'ADM02'),
('PAN42', 1940, 1700, 'kg', '2025-08-20', 'PET42', 'ADM02');

-- --------------------------------------------------------

--
-- Table structure for table `permintaan`
--

CREATE TABLE `permintaan` (
  `id_permintaan` varchar(10) NOT NULL,
  `jumlah_permintaan` int(11) NOT NULL,
  `id_panen` varchar(10) NOT NULL,
  `id_distributor` varchar(10) NOT NULL,
  `id_admin` varchar(10) NOT NULL,
  `status` enum('menunggu','disetujui','ditolak','dipenuhi') NOT NULL DEFAULT 'menunggu',
  `tanggal_permintaan` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `permintaan`
--

INSERT INTO `permintaan` (`id_permintaan`, `jumlah_permintaan`, `id_panen`, `id_distributor`, `id_admin`, `status`, `tanggal_permintaan`) VALUES
('PRM01', 1200, 'PAN01', 'DIS05', 'ADM01', 'menunggu', '2025-01-15 08:20:00'),
('PRM02', 1500, 'PAN02', 'DIS12', 'ADM02', 'disetujui', '2025-01-16 09:10:00'),
('PRM03', 900, 'PAN03', 'DIS03', 'ADM01', 'ditolak', '2025-01-18 10:25:00'),
('PRM04', 2000, 'PAN04', 'DIS07', 'ADM02', 'dipenuhi', '2025-01-20 08:00:00'),
('PRM05', 1100, 'PAN05', 'DIS09', 'ADM01', 'menunggu', '2025-01-22 07:50:00'),
('PRM06', 1350, 'PAN06', 'DIS18', 'ADM02', 'disetujui', '2025-01-25 10:40:00'),
('PRM07', 1600, 'PAN07', 'DIS25', 'ADM01', 'dipenuhi', '2025-01-26 09:30:00'),
('PRM08', 1700, 'PAN08', 'DIS20', 'ADM02', 'ditolak', '2025-01-27 11:15:00'),
('PRM09', 2100, 'PAN09', 'DIS02', 'ADM01', 'disetujui', '2025-01-28 14:00:00'),
('PRM10', 1900, 'PAN10', 'DIS10', 'ADM02', 'dipenuhi', '2025-01-29 08:45:00'),
('PRM11', 1200, 'PAN11', 'DIS22', 'ADM01', 'menunggu', '2025-02-01 09:00:00'),
('PRM12', 1750, 'PAN12', 'DIS04', 'ADM02', 'disetujui', '2025-02-02 08:30:00'),
('PRM13', 1450, 'PAN13', 'DIS06', 'ADM01', 'dipenuhi', '2025-02-03 07:45:00'),
('PRM14', 1250, 'PAN14', 'DIS08', 'ADM02', 'menunggu', '2025-02-04 10:10:00'),
('PRM15', 950, 'PAN15', 'DIS15', 'ADM01', 'ditolak', '2025-02-05 09:25:00'),
('PRM16', 2300, 'PAN16', 'DIS19', 'ADM02', 'dipenuhi', '2025-02-06 13:10:00'),
('PRM17', 1400, 'PAN17', 'DIS11', 'ADM01', 'disetujui', '2025-02-07 08:20:00'),
('PRM18', 1700, 'PAN18', 'DIS13', 'ADM02', 'menunggu', '2025-02-08 07:30:00'),
('PRM19', 2000, 'PAN19', 'DIS24', 'ADM01', 'dipenuhi', '2025-02-09 09:40:00'),
('PRM20', 1850, 'PAN20', 'DIS17', 'ADM02', 'disetujui', '2025-02-10 08:00:00'),
('PRM21', 1500, 'PAN21', 'DIS14', 'ADM01', 'menunggu', '2025-02-11 09:30:00'),
('PRM22', 1300, 'PAN22', 'DIS21', 'ADM02', 'ditolak', '2025-02-12 08:50:00'),
('PRM23', 2200, 'PAN23', 'DIS23', 'ADM01', 'dipenuhi', '2025-02-13 10:15:00'),
('PRM24', 900, 'PAN24', 'DIS01', 'ADM02', 'menunggu', '2025-02-14 11:40:00'),
('PRM25', 1450, 'PAN25', 'DIS16', 'ADM01', 'disetujui', '2025-02-15 08:10:00'),
('PRM26', 2000, 'PAN26', 'DIS26', 'ADM02', 'dipenuhi', '2025-02-16 10:00:00'),
('PRM27', 1650, 'PAN27', 'DIS27', 'ADM01', 'menunggu', '2025-02-17 09:30:00'),
('PRM28', 1750, 'PAN28', 'DIS28', 'ADM02', 'disetujui', '2025-02-18 08:40:00'),
('PRM29', 1800, 'PAN29', 'DIS29', 'ADM01', 'dipenuhi', '2025-02-19 07:45:00'),
('PRM30', 900, 'PAN30', 'DIS30', 'ADM02', 'ditolak', '2025-02-20 08:20:00'),
('PRM31', 1950, 'PAN31', 'DIS31', 'ADM01', 'disetujui', '2025-02-21 09:10:00'),
('PRM32', 2100, 'PAN32', 'DIS32', 'ADM02', 'dipenuhi', '2025-02-22 08:00:00'),
('PRM33', 1400, 'PAN33', 'DIS33', 'ADM01', 'menunggu', '2025-02-23 07:30:00'),
('PRM34', 1250, 'PAN34', 'DIS34', 'ADM02', 'disetujui', '2025-02-24 09:40:00'),
('PRM35', 1550, 'PAN35', 'DIS35', 'ADM01', 'dipenuhi', '2025-02-25 08:20:00'),
('PRM36', 1750, 'PAN36', 'DIS36', 'ADM02', 'menunggu', '2025-02-26 10:00:00'),
('PRM37', 1900, 'PAN37', 'DIS37', 'ADM01', 'disetujui', '2025-02-27 08:30:00'),
('PRM38', 1350, 'PAN38', 'DIS38', 'ADM02', 'ditolak', '2025-02-28 09:45:00'),
('PRM39', 1600, 'PAN39', 'DIS39', 'ADM01', 'dipenuhi', '2025-03-01 10:20:00'),
('PRM40', 1450, 'PAN40', 'DIS40', 'ADM02', 'disetujui', '2025-03-02 08:50:00'),
('PRM41', 2100, 'PAN41', 'DIS41', 'ADM01', 'menunggu', '2025-03-03 09:15:00'),
('PRM42', 1800, 'PAN42', 'DIS42', 'ADM02', 'dipenuhi', '2025-03-04 08:00:00'),
('PRM43', 2200, 'PAN05', 'DIS43', 'ADM01', 'disetujui', '2025-03-05 08:30:00'),
('PRM44', 1750, 'PAN09', 'DIS44', 'ADM02', 'dipenuhi', '2025-03-06 09:40:00'),
('PRM45', 1250, 'PAN13', 'DIS45', 'ADM01', 'ditolak', '2025-03-07 10:10:00'),
('PRM46', 1450, 'PAN17', 'DIS46', 'ADM02', 'menunggu', '2025-03-08 08:25:00'),
('PRM47', 2050, 'PAN21', 'DIS47', 'ADM01', 'disetujui', '2025-03-09 09:50:00'),
('PRM48', 1900, 'PAN25', 'DIS48', 'ADM02', 'dipenuhi', '2025-03-10 08:10:00'),
('PRM49', 1600, 'PAN29', 'DIS49', 'ADM01', 'disetujui', '2025-03-11 09:35:00'),
('PRM50', 1450, 'PAN33', 'DIS50', 'ADM02', 'menunggu', '2025-03-12 08:55:00'),
('PRM51', 1750, 'PAN37', 'DIS51', 'ADM01', 'dipenuhi', '2025-03-13 10:00:00'),
('PRM52', 1900, 'PAN40', 'DIS52', 'ADM02', 'disetujui', '2025-03-14 09:20:00'),
('PRM53', 2100, 'PAN42', 'DIS53', 'ADM01', 'dipenuhi', '2025-03-15 08:15:00');

-- --------------------------------------------------------

--
-- Table structure for table `petani`
--

CREATE TABLE `petani` (
  `id_petani` varchar(10) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `no_telp` varchar(20) NOT NULL,
  `nama_sawah` varchar(100) NOT NULL,
  `lokasi` varchar(150) NOT NULL,
  `luas_lahan` int(11) NOT NULL,
  `role` enum('petani') NOT NULL DEFAULT 'petani'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `petani`
--

INSERT INTO `petani` (`id_petani`, `nama_lengkap`, `username`, `password`, `no_telp`, `nama_sawah`, `lokasi`, `luas_lahan`, `role`) VALUES
('PET01', 'Budi Hartono', 'budi.hartono01', 'bhartono22', '081234567801', 'Sawah Padi Jaya', 'Jl. Melati No. 23, Kelurahan Sukamaju, Kecamatan Cibitung, Kabupaten Bekasi', 2500, 'petani'),
('PET02', 'Siti Aminah', 'siti.aminah88', 'sitix998', '081234567802', 'Sawah Harapan Makmur', 'Jl. Mawar No. 17, Kelurahan Sukasari, Kecamatan Cimahi, Kabupaten Bandung', 3100, 'petani'),
('PET03', 'Rudi Santoso', 'rudi.santoso07', 'rudi321', '081234567803', 'Sawah Tani Sejahtera', 'Jl. Pahlawan No. 5, Kelurahan Mulyasari, Kecamatan Karawang Barat, Kabupaten Karawang', 2900, 'petani'),
('PET04', 'Agus Prasetyo', 'agus.prasetyo12', 'agus456', '081234567804', 'Sawah Subur Abadi', 'Jl. Anggrek No. 9, Kelurahan Karangjati, Kecamatan Ciawi, Kabupaten Bogor', 1800, 'petani'),
('PET05', 'Dewi Lestari', 'dewi.lestari09', 'dwlestari22', '081234567890', 'Sawah Padi Asri', 'Jl. Merpati No. 4, Kelurahan Mekarjaya, Kecamatan Baleendah, Kabupaten Bandung', 2200, 'petani'),
('PET06', 'Andi Wijaya', 'andi.wijaya11', 'andipass', '081234567806', 'Sawah Sumber Rejeki', 'Jl. Raya Cendana No. 6, Kelurahan Sukamakmur, Kecamatan Jatinangor, Kabupaten Sumedang', 3300, 'petani'),
('PET07', 'Rina Marlina', 'rina.marlina03', 'rina432', '081234567807', 'Sawah Makmur Sentosa', 'Jl. Kenanga No. 10, Kelurahan Harapan, Kecamatan Cisarua, Kabupaten Bandung Barat', 2700, 'petani'),
('PET08', 'Eko Saputra', 'eko.saputra9', 'eko888', '081234567808', 'Sawah Lumbung Padi', 'Jl. Siliwangi No. 14, Kelurahan Sumberrejo, Kecamatan Cikampek, Kabupaten Karawang', 2100, 'petani'),
('PET09', 'Fitri Handayani', 'fitri.handayani77', 'fitri777', '081234567809', 'Sawah Tani Mandiri', 'Jl. Angsana No. 7, Kelurahan Tambakrejo, Kecamatan Purwakarta, Kabupaten Purwakarta', 3400, 'petani'),
('PET10', 'Yudi Kurniawan', 'yudi.kurniawan1', 'yudi123', '081234567810', 'Sawah Padi Subur', 'Jl. Cendrawasih No. 21, Kelurahan Sidomulyo, Kecamatan Majalaya, Kabupaten Bandung', 2800, 'petani'),
('PET11', 'Lina Agustina', 'lina.agustina02', 'lina234', '081234567811', 'Sawah Suka Makmur', 'Jl. Dahlia No. 8, Kelurahan Karangsari, Kecamatan Lembang, Kabupaten Bandung Barat', 2600, 'petani'),
('PET12', 'Bambang Setiawan', 'bambang.setiawan09', 'bambang12', '081234567812', 'Sawah Jaya Abadi', 'Jl. Mawar Putih No. 3, Kelurahan Sukahurip, Kecamatan Kadungora, Kabupaten Garut', 3000, 'petani'),
('PET13', 'Nur Aini', 'nur.aini8', 'nuraini45', '081234567813', 'Sawah Harapan Jaya', 'Jl. Raya Pasirjaya No. 11, Kelurahan Pasirjaya, Kecamatan Ciamis, Kabupaten Ciamis', 3200, 'petani'),
('PET14', 'Tono Suryana', 'tono.suryana07', 'tono654', '081234567814', 'Sawah Cinta Tani', 'Jl. Kenari No. 6, Kelurahan Mulyorejo, Kecamatan Tasikmalaya, Kabupaten Tasikmalaya', 1500, 'petani'),
('PET15', 'Citra Wulandari', 'citra.wulandari5', 'citra999', '081234567815', 'Sawah Maju Bersama', 'Jl. Flamboyan No. 25, Kelurahan Lembah Subur, Kecamatan Banjar, Kabupaten Banjar', 2400, 'petani'),
('PET16', 'Imam Subekti', 'imam.subekti01', 'imam000', '081234567816', 'Sawah Tani Lestari', 'Jl. Teratai No. 9, Kelurahan Sumber Agung, Kecamatan Ciparay, Kabupaten Bandung', 2100, 'petani'),
('PET17', 'Mega Putri Utami', 'mega.putri02', 'mega333', '081234567817', 'Sawah Rahayu', 'Jl. Anyelir No. 7, Kelurahan Sukaasih, Kecamatan Jatinangor, Kabupaten Sumedang', 2300, 'petani'),
('PET18', 'Anton Hidayat', 'anton.hidayat', 'anton555', '081234567818', 'Sawah Mulyo Makmur', 'Jl. Gading No. 14, Kelurahan Margamukti, Kecamatan Cicalengka, Kabupaten Bandung', 3100, 'petani'),
('PET19', 'Rahmawati Dwi Lestari', 'rahmawati.dwi', 'rahma234', '081234567819', 'Sawah Padi Permai', 'Jl. Cempaka No. 20, Kelurahan Sinarjaya, Kecamatan Cimahi Utara, Kabupaten Bandung', 2700, 'petani'),
('PET20', 'Yusuf Maulana', 'yusuf.maulana09', 'yusuf999', '081234567820', 'Sawah Subur Lestari', 'Jl. Kamboja No. 12, Kelurahan Tegallega, Kecamatan Sumedang Selatan, Kabupaten Sumedang', 2200, 'petani'),
('PET21', 'Putri Amelia', 'putri.amelia1', 'putri123', '081234567821', 'Sawah Berkah Jaya', 'Jl. Anggrek No. 10, Kelurahan Sukarame, Kecamatan Banjaran, Kabupaten Bandung', 2000, 'petani'),
('PET22', 'Ridwan Fauzi', 'ridwan.fauzi2', 'ridwan888', '081234567822', 'Sawah Padi Indah', 'Jl. Dahlia No. 4, Kelurahan Karanganyar, Kecamatan Majalengka, Kabupaten Majalengka', 1900, 'petani'),
('PET23', 'Nina Sulastri', 'nina.sulastri9', 'nina777', '081234567823', 'Sawah Mandiri Lestari', 'Jl. Cendana No. 15, Kelurahan Sukatani, Kecamatan Purwakarta, Kabupaten Purwakarta', 2300, 'petani'),
('PET24', 'Wawan Gunawan', 'wawan.gunawan', 'wawan654', '081234567824', 'Sawah Harapan Baru', 'Jl. Sawo No. 5, Kelurahan Sukaindah, Kecamatan Soreang, Kabupaten Bandung', 2600, 'petani'),
('PET25', 'Rizky Saputra', 'rizky.saputra2', 'rizky222', '081234567825', 'Sawah Gemah Ripah', 'Jl. Kenanga No. 7, Kelurahan Mulyaharja, Kecamatan Parongpong, Kabupaten Bandung Barat', 3000, 'petani'),
('PET26', 'Yanti Marlina', 'yanti.marlina07', 'yanti123', '081234567826', 'Sawah Subur Jaya', 'Jl. Melati No. 18, Kelurahan Sukamulya, Kecamatan Cianjur, Kabupaten Cianjur', 2800, 'petani'),
('PET27', 'Hendra Wijaya', 'hendra.wijaya9', 'hendra567', '081234567827', 'Sawah Tani Harapan', 'Jl. Padi No. 3, Kelurahan Sukamakmur, Kecamatan Jatinangor, Kabupaten Sumedang', 2400, 'petani'),
('PET28', 'Aulia Rahman', 'aulia.rahman02', 'aulia321', '081234567828', 'Sawah Mulyo Abadi', 'Jl. Srikaya No. 16, Kelurahan Karangjati, Kecamatan Cibatu, Kabupaten Garut', 2500, 'petani'),
('PET29', 'Lilis Suryani', 'lilis.suryani1', 'lilis999', '081234567829', 'Sawah Jaya Sentosa', 'Jl. Merdeka No. 9, Kelurahan Mekarsari, Kecamatan Cicalengka, Kabupaten Bandung', 3100, 'petani'),
('PET30', 'Deni Purnama', 'deni.purnama3', 'deni111', '081234567830', 'Sawah Suka Damai', 'Jl. Mawar No. 13, Kelurahan Sukamaju, Kecamatan Rancaekek, Kabupaten Bandung', 3400, 'petani'),
('PET31', 'Cahya Ramadhan Putra', 'cahya.putra', 'cahya234', '081234567831', 'Sawah Padi Mulya', 'Jl. Flamboyan No. 21, Kelurahan Harapan Baru, Kecamatan Cianjur, Kabupaten Cianjur', 2100, 'petani'),
('PET32', 'Selvi Anggraini', 'selvi.anggraini8', 'selvi345', '081234567832', 'Sawah Rahayu Makmur', 'Jl. Angsana No. 6, Kelurahan Margahayu, Kecamatan Garut Kota, Kabupaten Garut', 1800, 'petani'),
('PET33', 'Galih Pratama', 'galih.pratama5', 'galih567', '081234567833', 'Sawah Padi Sejahtera', 'Jl. Merpati No. 11, Kelurahan Mekarjaya, Kecamatan Baleendah, Kabupaten Bandung', 2700, 'petani'),
('PET34', 'Desi Natalia Putri', 'desi.putri7', 'desi890', '081234567834', 'Sawah Makmur Abadi', 'Jl. Nangka No. 8, Kelurahan Sukahaji, Kecamatan Cikampek, Kabupaten Karawang', 2000, 'petani'),
('PET35', 'Adi Firmansyah', 'adi.firmansyah', 'adi456', '081234567835', 'Sawah Lestari Jaya', 'Jl. Melur No. 3, Kelurahan Karanganyar, Kecamatan Majalaya, Kabupaten Bandung', 2900, 'petani'),
('PET36', 'Nurul Hidayah', 'nurul.hidayah3', 'nurul001', '081234567836', 'Sawah Suka Subur', 'Jl. Cempaka No. 14, Kelurahan Sidomulyo, Kecamatan Banjaran, Kabupaten Bandung', 2300, 'petani'),
('PET37', 'Taufik Rahman', 'taufik.rahman1', 'taufik555', '081234567837', 'Sawah Sejahtera Abadi', 'Jl. Merpati No. 10, Kelurahan Sukajadi, Kecamatan Bandung Kulon, Kabupaten Bandung', 3100, 'petani'),
('PET38', 'Rika Marlina Dewi', 'rika.dewi09', 'rika444', '081234567838', 'Sawah Berkah Makmur', 'Jl. Melati No. 9, Kelurahan Mekarsari, Kecamatan Garut Kota, Kabupaten Garut', 3300, 'petani'),
('PET39', 'Zulfikar Ali', 'zulfikar.ali5', 'zulfikar666', '081234567839', 'Sawah Harapan Sejahtera', 'Jl. Anggrek No. 8, Kelurahan Sukaasih, Kecamatan Ciawi, Kabupaten Bogor', 2400, 'petani'),
('PET40', 'Melati Anggun Sari', 'melati.sari3', 'melati999', '081234567840', 'Sawah Tani Berkah', 'Jl. Flamboyan No. 7, Kelurahan Sukatani, Kecamatan Soreang, Kabupaten Bandung', 2800, 'petani'),
('PET41', 'Agung Wibowo', 'agung.wibowo', 'agung123', '081234567841', 'Sawah Padi Lestari', 'Jl. Mawar No. 5, Kelurahan Karanganyar, Kecamatan Lembang, Kabupaten Bandung Barat', 3000, 'petani'),
('PET42', 'Lina Rosdiana Putri', 'lina.putri', 'lina222', '081234567842', 'Sawah Jaya Subur', 'Jl. Kamboja No. 15, Kelurahan Mekarjaya, Kecamatan Majalaya, Kabupaten Bandung', 2600, 'petani');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `distributor`
--
ALTER TABLE `distributor`
  ADD PRIMARY KEY (`id_distributor`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `hasil_panen`
--
ALTER TABLE `hasil_panen`
  ADD PRIMARY KEY (`id_panen`),
  ADD KEY `id_petani` (`id_petani`),
  ADD KEY `id_admin` (`id_admin`);

--
-- Indexes for table `permintaan`
--
ALTER TABLE `permintaan`
  ADD PRIMARY KEY (`id_permintaan`),
  ADD KEY `id_panen` (`id_panen`),
  ADD KEY `fk_admin_permintaan` (`id_admin`);

--
-- Indexes for table `petani`
--
ALTER TABLE `petani`
  ADD PRIMARY KEY (`id_petani`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hasil_panen`
--
ALTER TABLE `hasil_panen`
  ADD CONSTRAINT `hasil_panen_ibfk_1` FOREIGN KEY (`id_petani`) REFERENCES `petani` (`id_petani`),
  ADD CONSTRAINT `hasil_panen_ibfk_2` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`);

--
-- Constraints for table `permintaan`
--
ALTER TABLE `permintaan`
  ADD CONSTRAINT `fk_admin_permintaan` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`),
  ADD CONSTRAINT `permintaan_ibfk_1` FOREIGN KEY (`id_panen`) REFERENCES `hasil_panen` (`id_panen`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
