package com.demo.utils;

import org.springframework.util.PropertyPlaceholderHelper;

import java.util.Map;

/**
 * 参数解析
 *
 * @author chenJun
 * @version 1.0
 * @date 2022/12/08
 */
public class ParamsResolverHelper {

    private static final String PLACE_HOLDER_PREFIX = "{{";
    private static final String PLACE_HOLDER_SUFFIX = "}}";
    private static final PropertyPlaceholderHelper HELPER = new PropertyPlaceholderHelper(PLACE_HOLDER_PREFIX, PLACE_HOLDER_SUFFIX);

    /**
     * 替换参数
     *
     * @param param
     * @param content
     * @return
     */
    public static String resolveParams(Map<String, Object> param, String content) {
        content = HELPER.replacePlaceholders(content, (key -> param.get(key) + ""));
        return content;
    }
}
