package com.ly.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author : Ly
 * @Date : 2022/4/30
 * @Description : 获取前段传递过来的参数，注入到对应Bean对象中。 简化了参数获取步骤
 */
public class WebUtils {

    /**
     * 将map数据注入到bean中
     * @param map 要注入的数据
     * @param bean 被注入的对象
     * @param <T> 泛型，不定
     * @return 返回后注入的bean对象
     * @throws InvocationTargetException 异常
     * @throws IllegalAccessException 异常
     */
    public static <T> T copyParamsToBean(Map map,  T bean) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.populate(bean,map);
        return bean;
    }
}
