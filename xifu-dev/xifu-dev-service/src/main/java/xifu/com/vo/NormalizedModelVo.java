package xifu.com.vo;

import lombok.Data;
import xifu.com.pojo.devService.DevNormalizedModel;

import java.util.List;

/**
 * 归一化模型的信息
 * @auth wq on 2019/4/12 16:03
 **/
@Data
public class NormalizedModelVo {
    // 当前的归一化的信息
    private List<DevNormalizedModel> normalizedModelList;
    // 当前设备类型的版本号信息
    private List<String> modelVersionCodeList;
}
