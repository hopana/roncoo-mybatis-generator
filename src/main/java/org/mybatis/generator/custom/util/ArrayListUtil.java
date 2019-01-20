package org.mybatis.generator.custom.util;

import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 队列属性复制
 *
 * @param <T>
 * @author wujing
 */
public final class ArrayListUtil<T extends Serializable> {

    private ArrayListUtil() {
    }

    /**
     * @param source
     * @param clazz
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static <T> List<T> copy(List<?> source, Class<T> clazz) {
        if (source.size() == 0) {
            return Collections.emptyList();
        }
        List<T> res = new ArrayList<>(source.size());
        for (Object o : source) {
            T t = null;
            try {
                t = clazz.newInstance();
                BeanUtils.copyProperties(o, t);
            } catch (Exception e) {
                e.printStackTrace();
            }
            res.add(t);
        }
        return res;
    }

}
