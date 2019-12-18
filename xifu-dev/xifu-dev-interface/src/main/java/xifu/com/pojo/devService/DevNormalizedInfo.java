package xifu.com.pojo.devService;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 信号点模型适配表对应的实体对象
 * @auth wq on 2019/4/12 16:39
 **/
@Data
@Table(name = "tb_dev_normalized_info")
public class DevNormalizedInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    private Long signalId; // int(19) DEFAULT NULL COMMENT '设备的信号点的id',
    private String signalName; // varchar(64) DEFAULT NULL COMMENT '信号点名称',
    private String modelVersionCode; // varchar(32) DEFAULT '' COMMENT '点表版本，对应相同的版本信息配置的是相同的',
    private Integer signalAddress; // int(10) DEFAULT NULL COMMENT '信号点寄存器地址',
    private Long normalizedSignalId; // bigint(20) DEFAULT NULL COMMENT '归一化信号模型id',
    private Date createDate; // datetime DEFAULT NULL COMMENT '创建日期',
    private Date modifiedDate; // datetime DEFAULT NULL COMMENT '修改日期',
}
