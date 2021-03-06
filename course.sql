-- phpMyAdmin SQL Dump
-- version 3.5.8.1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2013 年 12 月 29 日 19:39
-- 服务器版本: 5.5.32
-- PHP 版本: 5.3.27

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `coursesystem`
--

-- --------------------------------------------------------

--
-- 表的结构 `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `id` varchar(8) NOT NULL,
  `name` varchar(10) NOT NULL,
  `teacherID` varchar(8) NOT NULL,
  `campus` varchar(10) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  `place` varchar(10) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `period` varchar(255) DEFAULT NULL,
  `require` varchar(30) DEFAULT NULL,
  `facultyID` varchar(8) DEFAULT NULL,
  `credit` int(2) DEFAULT NULL,
  `module` varchar(10) DEFAULT NULL,
  `limit` int(3) NOT NULL,
  `specificInfo` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `facultyID` (`facultyID`),
  KEY `teacherID` (`teacherID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `course`
--

INSERT INTO `course` (`id`, `name`, `teacherID`, `campus`, `grade`, `place`, `time`, `period`, `require`, `facultyID`, `credit`, `module`, `limit`, `specificInfo`) VALUES
('', '国学通论', '2002004', '仙林', '大一上', '仙二 126', '星期二 3-4', '3-16', '无', '002', 2, '通识课', 2, '无\n'),
('c000101', '软件工程与计算', '2001003', '仙林', '大一下', '仙二304', '星期四 5-6&星期二 5-6', '1-17', '无', '001', 3, '必修课', -1, '无'),
('c000102', '数据结构与算法分析', '2001002', '仙林', '大二上', '仙二303', '星期三 5-6', '2-18', '无', '001', 3, '必修课', -1, '无'),
('c000104', '计算组织与结构', '2001004', '仙林', '大一下', '仙二305', '星期二 5-7', '1-17', '无', '001', 3, '必修课', -1, '无'),
('c000105', '软件构造', '2001001', '鼓楼', '大三上', '教201', '星期二 3-4', '1-17', '无', '001', 3, '必修课', -1, '无'),
('c000106', '离散数学', '2001001', '仙林', '大一上', '图书馆106', '星期二 5-7', '1-17', '无', '001', 1, '必修课', 3, '无'),
('c000107', '软件需求工程', '2001009', '鼓楼', '大三上', '教202', '星期五 3-4', '1-17', '无', '001', 3, '必修课', -1, '无\n'),
('c001301', '数学分析', '2013002', '仙林', '大一下', '仙二110', '星期二 1-4', '1-17', '无', '013', 5, '必修课', -1, '无'),
('c100101', 'c++高级程序设计', '2001007', '仙林', '大二上', '仙一303', '星期四 3-4', '1-17', '无', '001', 3, '选修课', 2, ''),
('c100102', '移动互联网', '2001003', '鼓楼', '大二下', '教205', '星期三 7-8', '1-17', '无', '001', 3, '选修课', 3, '无'),
('c100103', '多媒体技术', '2001004', '鼓楼', '大四上', '教106', '星期五 7-8', '1-17', '无', '001', 3, '选修课', 3, '无'),
('c100104', '数据库开发技术', '2001008', '鼓楼', '大三上', '教233', '星期五 1-3', '1-17', '无', '001', 3, '选修课', 3, '无'),
('c200201', '山水地质学与中国绘画', '2002001', '仙林', '上', '仙一319', '星期一 9-11', '1-2', '无', '002', 3, '通识课', 1, '无'),
('c200202', '歌剧经典赏析', '2002003', '仙林', '上', '仙一 108', '星期四 7-9', '1-17', '无', '002', 2, '通识课', 3, '无'),
('c200203', '走近电影大师', '2002002', '仙林', '大二上', '仙一 110', '星期三 1-2', '1-12', '无', '002', 2, '通识课', 2, '无'),
('c200204', '当代西方人文精神概论', '2002002', '仙林', '大一上', '仙一 220', '星期一 3-4', '2-11', '无', '002', 2, '通识课', 2, '无'),
('c200301', '变态心理学', '2003001', '仙林', '上', '仙一319', '星期一 9-10', '2-13', '无', '003', 2, '通识课', 2, '无'),
('c200302', '全球化进程中的反全球', '2003001', '仙林', '上', '仙二110', '星期三 9-10', '3-16', '无', '003', 2, '通识课', 3, '无'),
('c200402', '马克思主义', '2004001', '仙林', '上', '仙一319', '星期一 9-10', '1-2', '无', '004', 2, '通识课', 4, '无'),
('c201001', '诗与思：近代德语文学', '2010001', '仙林', '下', '仙一210', '星期一 6-9', '2-13', '无', '010', 2, '通识课', 3, '无'),
('c202001', '中华玉器鉴赏', '2020001', '仙林', '上', '仙二122', '星期四 7-8', '2-17', '无', '020', 2, '通识课', 3, '无'),
('c300201', '西方音乐', '2002002', '仙林', '下', '仙一319', '星期一 9-10', '2-9', '无', '002', 2, '公选课', 4, '无'),
('c300202', '油画绘画技法基础', '2002003', '仙林', '下', '仙二404', '星期二 5-6', '2-16', '无', '002', 3, '公选课', 5, '无'),
('c300203', '中医药文化', '2002001', '仙林', '大一上', '仙二 433', '星期二 1-2', '5-13', '无', '002', 2, '公选课', 2, '无'),
('c300301', '人与环境', '2003002', '仙林', '大一上', '仙二 120', '星期四 3-4', '3-9', '无', '003', 2, '公选课', 2, '无'),
('c300302', '海洋与人类社会', '2003001', '仙林', '大一上', '仙二 300', '星期五 2-4', '5-10', '无', '003', 2, '公选课', 3, '无'),
('c300303', '社会心理学', '2003001', '仙林', '大一上', '仙二 420', '星期二 1-2', '2-9', '无', '003', 2, '公选课', 3, '无'),
('c401901', '体育舞蹈', '2019001', '仙林', '大一上', '体育馆主馆', '星期四 3-4', '1-17', '无', '019', 1, '体育课', 2, '无'),
('c401902', '太极拳32式', '2019002', '仙林', '大一上', '体育馆武术馆', '星期三 1-2', '1-17', '无', '019', 1, '体育课', 2, '无'),
('c401903', '跆拳道', '2019003', '仙林', '下', '体育馆跆拳道馆', '星期二 5-6', '1-17', '无', '019', 1, '体育课', 3, '无');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
