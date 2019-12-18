package xifu.com.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;
import xifu.com.cache.DevModelsCache;
import xifu.com.exception.ExceptionEnum;
import xifu.com.exception.XiFuException;
import xifu.com.mapper.DevModelVersionMapper;
import xifu.com.mapper.DevNormalizedInfoMapper;
import xifu.com.mapper.DevNormalizedModelMapper;
import xifu.com.pojo.devService.DevModelVersion;
import xifu.com.pojo.devService.DevNormalizedInfo;
import xifu.com.pojo.devService.DevNormalizedModel;
import xifu.com.pojo.devService.DevVersionSignal;
import xifu.com.vo.NormalizedCodeSignalVo;
import xifu.com.vo.NormalizedModelVo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 归一化模型的service层
 * @auth wq on 2019/4/12 16:01
 **/
@Slf4j
@Service
public class DevNormalizedModelService {
    @Autowired
    private DevNormalizedModelMapper devNormalizedModelMapper;
    @Autowired
    private DevModelVersionMapper devModelVersionMapper;
    @Autowired
    private DevNormalizedInfoMapper devNormalizedInfoMapper;
    @Autowired
    private DevModelsCache devModelsCache;

    /**
     * 根据设备类型查询归一化的模板信息列表和版本信息
     * @param devTypeId
     * @return
     */
    public NormalizedModelVo findNormalizedByDevTypeId(Integer devTypeId) {
        if (devTypeId == null) {
            log.error("查询归一化模板信息：设备类型错误");
            throw new XiFuException(ExceptionEnum.DEV_TYPE_ERROR);
        }
        NormalizedModelVo vo = new NormalizedModelVo();
        // 1.查询归一化的模板列表
        vo.setNormalizedModelList(getModelsByDevTypeId(devTypeId));
        // 2.根据设备类型查询当前导入的版本信息
        vo.setModelVersionCodeList(getModelVersionCodeListByDevTypeId(devTypeId));
        return vo;
    }
    // 查询归一化的模板信息
    private List<DevNormalizedModel> getModelsByDevTypeId(Integer devTypeId) {
        // 查询归一化
        Example example = new Example(DevNormalizedModel.class);
        example.createCriteria().andEqualTo("devTypeId", devTypeId);
        example.setOrderByClause(" order_num,id ASC");
        List<DevNormalizedModel> devNormalizedModels = devNormalizedModelMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(devNormalizedModels)) {
            log.error("查询归一化模板信息：设备类型错误,devTypeId = {}", devTypeId);
            throw new XiFuException(ExceptionEnum.DEV_TYPE_ERROR);
        }
        return devNormalizedModels;
    }
    // 根据设备类型获取版本信息
    private List<String> getModelVersionCodeListByDevTypeId(Integer devTypeId) {
        DevModelVersion model = new DevModelVersion();
        model.setDevTypeId(devTypeId);
        List<DevModelVersion> list = devModelVersionMapper.select(model);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.stream().map(v -> v.getModelVersionCode()).collect(Collectors.toList());
    }

    /**
     * 获取归一化的配置信息
     * @param modelVersionCode
     * @return
     */
    public NormalizedCodeSignalVo findAdapterDataByModelVersionCode(String modelVersionCode) {
        DevNormalizedInfo devNormalizedInfo = new DevNormalizedInfo();
        devNormalizedInfo.setModelVersionCode(modelVersionCode);
        List<DevNormalizedInfo> list = devNormalizedInfoMapper.select(devNormalizedInfo);
        List<DevVersionSignal> devVersionSignals = devModelsCache.getDevVersionSignalsByModelVersionCode(modelVersionCode);
        if (CollectionUtils.isEmpty(devVersionSignals)) {
            log.error("没有查询到当前版本的信号点, modelVersionCode = {}", modelVersionCode);
            throw new XiFuException(ExceptionEnum.DEV_MODEL_VERSION_SIGNAL_NOT_FOUND);
        }
        return new NormalizedCodeSignalVo(list, devVersionSignals);
    }

    /**
     * 保存一个设备版本信息的归一化适配信息
     * @param list
     */
    @Transactional
    public void saveModelVersionCodeAdapter(List<DevNormalizedInfo> list) {
        if (CollectionUtils.isEmpty(list)) {
            throw new XiFuException(ExceptionEnum.SAVE_NORMALIZED_PARAM_ERROR);
        }
        // 1.删除之前的配置
        DevNormalizedInfo delObj = new DevNormalizedInfo();
        delObj.setModelVersionCode(list.get(0).getModelVersionCode());
        this.devNormalizedInfoMapper.delete(delObj);
        // 2.新增
        int cont = this.devNormalizedInfoMapper.insertList(list);
        if (cont != list.size()) { // 如果新增的条数不一致，就认为是失败的
            throw new XiFuException(ExceptionEnum.SAVE_NORMALIZED_FALED);
        }
        // TODO 将归一化添加到缓存中
    }
}
