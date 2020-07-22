package com.lamp;

import com.lamp.config.MainPostProcessConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTestPostProcess {

    @Test
    public void testPostProcess() {
        new AnnotationConfigApplicationContext(MainPostProcessConfig.class);

    }
}
