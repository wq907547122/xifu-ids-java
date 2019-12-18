package xifu.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xifu.com.cache.DevModelsCache;

/**
 * 版本信号点的模型
 * @auth wq on 2019/4/12 16:30
 **/
@RestController
@RequestMapping("versionSignal")
public class DevVersionSignalController {
    @Autowired
    private DevModelsCache devModelsCache;
}
