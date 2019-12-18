package xifu.com.controller;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xifu.com.pojo.devService.DevNormalizedInfo;
import xifu.com.service.impl.DevNormalizedModelService;
import xifu.com.utils.JsonUtils;
import xifu.com.vo.NormalizedCodeSignalVo;
import xifu.com.vo.NormalizedModelVo;

import java.util.List;

/**
 * 点表归一化的controller层
 * @auth wq on 2019/4/12 16:05
 **/
@RestController
@RequestMapping("normalized")
public class DevNormalizedModelController {
    @Autowired
    private DevNormalizedModelService devNormalizedModelService;

    /**
     * 根据设备版本号查询当前版本的归一化信息和对应的版本列表
     * @param devTypeId
     * @return
     */
    @GetMapping("model/ph/{devTypeId}")
    public ResponseEntity<NormalizedModelVo> findNormalizedByDevTypeId(@PathVariable("devTypeId") Integer devTypeId) {
        return ResponseEntity.ok(devNormalizedModelService.findNormalizedByDevTypeId(devTypeId));
    }

    /**
     * 查询版本的信号点和已经配置好了的归一化
     * @param modelVersionCode
     * @return
     */
    @GetMapping("info/ph/{modelVersionCode}")
    public ResponseEntity<NormalizedCodeSignalVo> findAdapterDataByModelVersionCode
            (@PathVariable("modelVersionCode") String modelVersionCode) {
        return ResponseEntity.ok(devNormalizedModelService.findAdapterDataByModelVersionCode(modelVersionCode));
    }

    /**
     * 保存某一个版本的归一化配置信息
     * @param list
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveModelVersionCodeAdapter(@RequestParam("list") String list){
        List<DevNormalizedInfo> devNormalizedInfos = JsonUtils.jsonToList(list, DevNormalizedInfo.class);
        devNormalizedModelService.saveModelVersionCodeAdapter(devNormalizedInfos);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
