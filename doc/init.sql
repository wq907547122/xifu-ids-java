-- 初始化归一化模型的信息
delete FROM tb_dev_normalized_model;
-- 设备类型id的规划每一种设备的归一化id范围在100个数据之内  1  1 - 100,  101 - 200, 201 - 300, 301 - 400, 401 - 500
-- 组串式逆变器 id 1 - 100,少的先留着
INSERT INTO `tb_dev_normalized_model` (`id`, `name`, `column_name`, `dev_type_id`, `is_persist`, `order_num`, `description`) VALUES 
('1', '电网AB电压', 'ab_u', '1', '1', '1', '逆变器状态'),
('2', '电网BC电压', 'bc_u', '1', '1', '2', '电网AB电压'),
('3', '电网CA电压', 'ca_u', '1', '1', '3', '电网BC电压'),
('4', 'A相电压', 'a_u', '1', '1', '4', '电网CA电压'),
('5', 'B相电压', 'b_u', '1', '1', '5', 'A相电压'),
('6', 'C相电压', 'c_u', '1', '1', '6', 'B相电压'),
('7', '电网A相电流', 'a_i', '1', '1', '7', 'C相电压'),
('8', '电网B相电流', 'b_i', '1', '1', '8', '电网A相电流'),
('9', '电网C相电流', 'c_i', '1', '1', '9', '电网B相电流'),
('10', '逆变器状态', 'inverter_state', '1', '1', '10', '电网C相电流'),
('11', '逆变器转换效率(厂家)', 'conversion_efficiency', '1', '1', '11', '逆变器转换效率(厂家)'),
('12', '机内温度', 'temperature', '1', '1', '12', '机内温度'),
('13', '功率因数', 'power_factor', '1', '1', '13', '功率因数'),
('14', '电网频率', 'grid_frequency', '1', '1', '14', '电网频率'),
('15', '有功功率', 'active_power', '1', '1', '15', '有功功率'),
('16', '输出无功功率', 'reactive_power', '1', '1', '16', '输出无功功率'),
('17', '当日发电量', 'day_capacity', '1', '1', '17', '当日发电量'),
('18', 'MPPT输入总功率', 'mppt_power', '1', '1', '18', 'MPPT输入总功率'),
('19', 'PV1输入电压', 'pv1_u', '1', '1', '19', 'PV1输入电压'),
('20', 'PV2输入电压', 'pv2_u', '1', '1', '20', 'PV2输入电压'),
('21', 'PV3输入电压', 'pv3_u', '1', '1', '21', 'PV3输入电压'),
('22', 'PV4输入电压', 'pv4_u', '1', '1', '22', 'PV4输入电压'),
('23', 'PV5输入电压', 'pv5_u', '1', '1', '23', 'PV5输入电压'),
('24', 'PV6输入电压', 'pv6_u', '1', '1', '24', 'PV6输入电压'),
('25', 'PV7输入电压', 'pv7_u', '1', '1', '25', 'PV7输入电压'),
('26', 'PV8输入电压', 'pv8_u', '1', '1', '26', 'PV8输入电压'),
('27', 'PV9输入电压', 'pv9_u', '1', '1', '27', 'PV9输入电压'),
('28', 'PV10输入电压', 'pv10_u', '1', '1', '28', 'PV10输入电压'),
('29', 'PV11输入电压', 'pv11_u', '1', '1', '29', 'PV11输入电压'),
('30', 'PV12输入电压', 'pv12_u', '1', '1', '30', 'PV12输入电压'),
('31', 'PV13输入电压', 'pv13_u', '1', '1', '31', 'PV13输入电压'),
('32', 'PV14输入电压', 'pv14_u', '1', '1', '32', 'PV14输入电压'),
('33', 'PV19输入电压', 'pv19_u', '1', '1', '33', 'PV1输入电流'),
('34', 'PV15输入电压', 'pv15_u', '1', '1', '34', 'PV2输入电流'),
('35', 'PV16输入电压', 'pv16_u', '1', '1', '35', 'PV3输入电流'),
('36', 'PV17输入电压', 'pv17_u', '1', '1', '36', 'PV4输入电流'),
('37', 'PV18输入电压', 'pv18_u', '1', '1', '37', 'PV5输入电流'),
('38', 'PV24输入电压', 'pv24_u', '1', '1', '38', 'PV6输入电流'),
('39', 'PV20输入电压', 'pv20_u', '1', '1', '39', 'PV7输入电流'),
('40', 'PV21输入电压', 'pv21_u', '1', '1', '40', 'PV8输入电流'),
('41', 'PV22输入电压', 'pv22_u', '1', '1', '41', 'PV9输入电流'),
('42', 'PV23输入电压', 'pv23_u', '1', '1', '42', 'PV10输入电流'),
('43', 'PV1输入电流', 'pv1_i', '1', '1', '43', 'PV11输入电流'),
('44', 'PV2输入电流', 'pv2_i', '1', '1', '44', 'PV12输入电流'),
('45', 'PV3输入电流', 'pv3_i', '1', '1', '45', 'PV13输入电流'),
('46', 'PV4输入电流', 'pv4_i', '1', '1', '46', 'PV14输入电流'),
('47', 'PV5输入电流', 'pv5_i', '1', '1', '47', '累计发电量'),
('48', 'PV6输入电流', 'pv6_i', '1', '1', '48', '逆变器开机时间'),
('49', 'PV7输入电流', 'pv7_i', '1', '1', '49', '逆变器关机时间'),
('50', 'PV8输入电流', 'pv8_i', '1', '1', '50', '直流输入总电量'),
('51', 'PV9输入电流', 'pv9_i', '1', '1', '51', 'MPPT1直流累计发电量'),
('52', 'PV10输入电流', 'pv10_i', '1', '1', '52', 'MPPT2直流累计发电量'),
('53', 'PV11输入电流', 'pv11_i', '1', '1', '53', 'MPPT3直流累计发电量'),
('54', 'PV12输入电流', 'pv12_i', '1', '1', '54', 'MPPT4直流累计发电量'),
('55', 'PV13输入电流', 'pv13_i', '1', '1', '55', 'PV15输入电压'),
('56', 'PV14输入电流', 'pv14_i', '1', '1', '56', 'PV15输入电压'),
('57', 'PV15输入电流', 'pv15_i', '1', '1', '57', 'PV15输入电压'),
('58', 'PV16输入电流', 'pv16_i', '1', '1', '58', 'PV15输入电压'),
('59', 'PV17输入电流', 'pv17_i', '1', '1', '59', 'PV15输入电压'),
('60', 'PV18输入电流', 'pv18_i', '1', '1', '60', 'PV15输入电压'),
('61', 'PV19输入电流', 'pv19_i', '1', '1', '61', 'PV15输入电压'),
('62', 'PV20输入电流', 'pv20_i', '1', '1', '62', 'PV15输入电压'),
('63', 'PV21输入电流', 'pv21_i', '1', '1', '63', 'PV15输入电压'),
('64', 'PV22输入电流', 'pv22_i', '1', '1', '64', 'PV15输入电压'),
('65', 'PV23输入电流', 'pv23_i', '1', '1', '65', 'PV15输入电流'),
('66', 'PV24输入电流', 'pv24_i', '1', '1', '66', 'PV16输入电流'),
('67', '累计发电量', 'total_capacity', '1', '1', '67', 'PV17输入电流'),
('68', '逆变器开机时间', 'on_time', '1', '1', '68', 'PV18输入电流'),
('69', '逆变器关机时间', 'off_time', '1', '1', '69', 'PV19输入电流'),
('70', '直流输入总电量', 'mppt_total_cap', '1', '1', '70', 'PV20输入电流'),
('71', 'MPPT1直流累计发电量', 'mppt_1_cap', '1', '1', '71', 'PV21输入电流'),
('72', 'MPPT2直流累计发电量', 'mppt_2_cap', '1', '1', '72', 'PV22输入电流'),
('73', 'MPPT3直流累计发电量', 'mppt_3_cap', '1', '1', '73', 'PV23输入电流'),
('74', 'MPPT4直流累计发电量', 'mppt_4_cap', '1', '1', '74', 'PV24输入电流');

-- 箱变的归一化 101 - 200
INSERT INTO `tb_dev_normalized_model` (`id`, `name`, `column_name`, `dev_type_id`, `is_persist`, `order_num`, `description`) VALUES 
('101','电网AB线电压','ab_u','8','1','1','电网AB线电压'),
('102','电网BC线电压','bc_u','8','1','2','电网BC线电压'),
('103','电网CA线电压','ca_u','8','1','3','电网CA线电压'),
('104','A相电压（交流输出）','a_u','8','1','4','A相电压（交流输出）'),
('105','B相电压（交流输出）','b_u','8','1','5','B相电压（交流输出）'),
('106','C相电压（交流输出）','c_u','8','1','6','C相电压（交流输出）'),
('107','电网A相电流(IA)','a_i','8','1','7','电网A相电流(IA)'),
('108','电网B相电流(IB)','b_i','8','1','8','电网B相电流(IB)'),
('109','电网C相电流(IC)','c_i','8','1','9','电网C相电流(IC)'),
('110','有功功率','active_power','8','1','10','有功功率'),
('111','无功功率','reactive_power','8','1','11','无功功率'),
('112','功率因数','power_factor','8','1','12','功率因数'),
('113','电网频率','elec_freq','8','1','13','电网频率');