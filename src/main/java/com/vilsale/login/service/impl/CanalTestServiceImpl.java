package com.vilsale.login.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vilsale.login.entity.CanalTest;
import com.vilsale.login.entity.User;
import com.vilsale.login.mapper.CanalTestMapper;
import com.vilsale.login.service.ICanalTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.Vector;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AMK-SYZ
 * @since 2022-09-15
 */
@Service
public class CanalTestServiceImpl extends ServiceImpl<CanalTestMapper, CanalTest> implements ICanalTestService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void canalTestInsert(JSONArray jsonArray) {
        Vector<CanalTest> insert = new Vector<>();
        if (jsonArray == null || jsonArray.size() == 0){
            return;
        }

        for (Object datum : jsonArray) {
            JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(datum);
            User user = jsonObject1.toJavaObject(User.class);
            // 幂等性校验
            CanalTest canalTest = this.getById(user.getUserId());
            if (canalTest != null){
                continue;
            }
            CanalTest canal = new CanalTest();
            BeanUtils.copyProperties(user, canal);
            insert.add(canal);
        }

        if(insert != null && insert.size() > 0){
            this.saveBatch(insert);
        }


    }

    @Override
    public void canalTestUpdate(JSONArray jsonArray) {

        if (jsonArray == null || jsonArray.size() == 0) {
            return;
        }

        for (Object datum : jsonArray) {
            JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(datum);
            User user = jsonObject1.toJavaObject(User.class);
            CanalTest byId = this.getById(user.getUserId());
            CanalTest canal = new CanalTest();
            BeanUtils.copyProperties(user, canal);
            if (byId != null){
                // 更新
                this.updateById(canal);
            }else {
                // 插入
                this.save(canal);
            }
        }
    }
}
