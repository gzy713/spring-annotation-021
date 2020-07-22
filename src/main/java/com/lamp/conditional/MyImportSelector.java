package com.lamp.conditional;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑 返回需要导入的组件
 */
public class MyImportSelector implements ImportSelector {
    /*
     * 返回值就是导入类的全类名
     * AnnotationMetadata 获取注解信息  当前标注 @import 类的注解信息
     * */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//所有和类有关的信息都能获取到
        //        importingClassMetadata.getAnnotatedMethods()
        return new String[]{"com.lamp.bean.Yellow"};

    }
}
