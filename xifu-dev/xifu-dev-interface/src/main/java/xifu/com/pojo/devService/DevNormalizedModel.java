package xifu.com.pojo.devService;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 归一化模型的信息
 * @auth wq on 2019/4/12 15:55
 **/
@Data
@Table(name = "tb_dev_normalized_model")
public class DevNormalizedModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //  bigint(16) NOT NULL COMMENT '主键ID',
    private String name; // varchar(64) DEFAULT NULL COMMENT '归一化的名称',
    private String columnName; // varchar(64) DEFAULT NULL COMMENT '信号点字段名称，持久化表到字段名',
    private Integer devTypeId; // int(8) default null comment '设备类型',
    private Boolean isPersist; // smallint(1) default 0 comment '是否持久化, 1:对应的点会持久化， 0：不持久化. 即是否使用它来将数据添加到性能数据表中',
    private Integer orderNum; // int(3) DEFAULT NULL COMMENT '排序号',
    private String description; // varchar(256) DEFAULT NULL COMMENT '对列的说明和描述',
}
