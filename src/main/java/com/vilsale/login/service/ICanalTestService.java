package com.vilsale.login.service;

import com.alibaba.fastjson.JSONArray;
import com.vilsale.login.entity.CanalTest;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AMK-SYZ
 * @since 2022-09-15
 */
public interface ICanalTestService extends IService<CanalTest> {

    void canalTestInsert(JSONArray data);

    void canalTestUpdate(JSONArray data);
}
