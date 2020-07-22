package com.lamp.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter  implements TypeFilter {
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        /*获取当前扫描类的 注解信息*/
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        /*
        * 获取当前扫描类的类信息
        * */
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        /*
        * 获取当前类的资源信息 比如路径
        * */
        Resource resource = metadataReader.getResource();

        /*获取当前扫描类的类名信息*/
        String className = classMetadata.getClassName();
        /*
        *  返回true  就能扫描成功
        * */
       // System.out.println(className);
//        if (className.contains("er")) {
//            return true;
//        }else {
//            return false;
//        }


        return  false;
    }
}
