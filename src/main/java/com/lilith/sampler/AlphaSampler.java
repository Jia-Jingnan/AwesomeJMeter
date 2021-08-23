package com.lilith.sampler;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 * @Author:JiaJingnan
 * @Date: 下午2:10 2021/8/23
 */
public class AlphaSampler extends AbstractJavaSamplerClient {


    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {

        System.out.println("Hello JMeter");
        return null;
    }
}
