package xifu.com.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import xifu.com.pojo.devService.DevNormalizedInfo;

/**
 * 适配归一化模型的版本配置信号点的mapper层
 * @auth wq on 2019/4/12 16:44
 **/
public interface DevNormalizedInfoMapper extends Mapper<DevNormalizedInfo>, MySqlMapper<DevNormalizedInfo>{
}
