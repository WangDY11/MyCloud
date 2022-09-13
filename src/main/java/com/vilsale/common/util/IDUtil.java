package com.vilsale.common.util;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.stereotype.Component;

/**
 * @desc 分布式高效有序ID生产黑科技http://git.oschina.net/yu120/sequence
 * @date 2019/6/6
 * @author wjy
 */
@Component
public class IDUtil {

    /**
     * @desc 获取ID
     * @date 2019/6/6
     * @author wjy
     */
    public String getID() {
        return IdWorker.getIdStr();
    }

}
