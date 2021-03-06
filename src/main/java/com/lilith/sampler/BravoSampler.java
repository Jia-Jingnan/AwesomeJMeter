package com.lilith.sampler;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.net.URL;

/**
 * @Author:JiaJingnan
 * @Date: 下午3:18 2021/8/23
 */
public class BravoSampler implements JavaSamplerClient {


    // 定义属性 URLNAME，可以在图形化界面中显示的变量名称
    private static final String URLNAME = "URL";

    // 设置在GUI界面中显示的变量的值
    private static final String DEFAULTURL = "http://www.baidu.com";

    private String inputUrl;

    // 存储响应数据，展示在查看结果树中
    private String res;


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
        inputUrl = javaSamplerContext.getParameter(URLNAME,DEFAULTURL);
        System.out.println("用户输入url：" + inputUrl);

        System.out.println("Hello JMeter! runTest");
        SampleResult result = new SampleResult();
        res = "这是响应结果";
        result.setResponseData(res,null);
        // 告诉查看结果树访问是否成功
        result.setSuccessful(true);
        // 设置响应码
        result.setResponseCode("200");
        // 设置请求的名称
        // result.setSampleLabel("自定义Java请求");
        return result;
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
        System.out.println("getDefaultParameters");

        Arguments arguments = new Arguments();
        arguments.addArgument(URLNAME,DEFAULTURL);
        return arguments;
    }
}
