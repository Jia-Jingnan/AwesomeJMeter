package com.lilith.sampler;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 * @Author:JiaJingnan
 * @Date: 下午3:18 2021/8/23
 */
public class BravoSampler implements JavaSamplerClient {


    /**
     * 初始化方法
     * @param javaSamplerContext
     */
    @Override
    public void setupTest(JavaSamplerContext javaSamplerContext) {
        System.out.println("setUp Test");
    }

    /**
     * 实现具体功能逻辑的方法
     * @param javaSamplerContext
     * @return
     */
    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {

        System.out.println("Hello JMeter! runTest");
        return null;
    }

    /**
     * 负责收尾工作的方法
     * @param javaSamplerContext
     */
    @Override
    public void teardownTest(JavaSamplerContext javaSamplerContext) {

        System.out.println("tearDown Test");
    }

    /**
     * 决定了JMeter中要现实哪些参数属性
     * @return
     */
    @Override
    public Arguments getDefaultParameters() {
        String name;
        int age;
        System.out.println("getDefaultParameters");
        return null;
    }
}
