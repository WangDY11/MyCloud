package com.wdy.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * @author wdy
 * @Description openFeign响应结果处理
 * @createTime 2022年03月15日
 */
@Component
public class FeignResponseUtil {

    public JSONObject getMessage(JSONObject jsonObject){
        JSONObject json = new JSONObject();
        if (jsonObject != null){
            json = jsonObject.containsKey("message") ? jsonObject.getJSONObject("message") : null;
        }
        return json;
    }

    public JSONArray getMessageArray(JSONObject jsonObject){
        JSONArray json = new JSONArray();
        if (jsonObject != null){
            json = jsonObject.containsKey("message") ? jsonObject.getJSONArray("message") : null;
        }
        return json;
    }

    public JSONObject getMessageArrayToFirst(JSONObject jsonObject){
        JSONObject json = new JSONObject();
        if (jsonObject != null){
            if (jsonObject.containsKey("message") && jsonObject.getJSONArray("message").size() == 0){
                return json;
            }
            json = jsonObject.containsKey("message") ? jsonObject.getJSONArray("message").getJSONObject(0) : null;
        }
        return json;
    }

    public JSONObject getData(JSONObject jsonObject){
        JSONObject json = new JSONObject();
        if (jsonObject != null){
            json = jsonObject.containsKey("data") ? jsonObject.getJSONObject("data") : null;
        }
        return json;
    }

    public JSONArray getDataArray(JSONObject jsonObject){
        JSONArray json = new JSONArray();
        if (jsonObject != null){
            json = jsonObject.containsKey("data") ? jsonObject.getJSONArray("data") : null;
        }
        return json;
    }

    public JSONObject getDataArrayToFirst(JSONObject jsonObject){
        JSONObject json = new JSONObject();
        if (jsonObject != null){
            json = jsonObject.containsKey("data") ? jsonObject.getJSONArray("data").getJSONObject(0) : null;
        }
        return json;
    }
}
