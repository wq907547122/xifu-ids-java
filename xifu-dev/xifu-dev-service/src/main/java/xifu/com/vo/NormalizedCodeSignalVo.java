package xifu.com.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xifu.com.pojo.devService.DevNormalizedInfo;
import xifu.com.pojo.devService.DevVersionSignal;

import java.util.List;

/**
 * 设备版本对应的归一化的信号点和配置了的版本归一化信息
 * @auth wq on 2019/4/12 16:36
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NormalizedCodeSignalVo {
    // 配置的归一化的信息
    private List<DevNormalizedInfo> devNormalizedInfos;
    // 版本的信号点
    private List<DevVersionSignal> devVersionSignals;
}
