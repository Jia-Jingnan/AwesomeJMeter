package com.lilith.sampler;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author:JiaJingnan
 * @Date: 下午3:18 2021/8/23
 */
public class CharlieSampler implements JavaSamplerClient {


    // 定义属性 URLNAME，可以在图形化界面中显示的变量名称
    private static final String URLNAME = "URL";

    // 设置在GUI界面中显示的变量的值
    private static final String DEFAULTURL = "http://www.baidu.com";

    private String inputUrl;

    // 存储响应数据，展示在查看结果树中
    private String data;


    /**
     * 初始化方法
     * @param javaSamplerContext
     */
    @Override
    public void setupTest(JavaSamplerContext javaSamplerContext) {
        inputUrl = javaSamplerContext.getParameter(URLNAME,DEFAULTURL);
        System.out.println("setUp Test");
    }

    /**
     * 实现具体功能逻辑的方法
     * @param javaSamplerContext
     * @return
     */
    @Override
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {

        // 定义返回结果
        SampleResult result = new SampleResult();
        StringBuffer stringBuffer = new StringBuffer();

        // 访问一个URL地址，相当于执行一个get请求
        try {
            URL url = new URL(inputUrl);
            URLConnection connection = url.openConnection();
            byte[] buffer = new byte[1024];

            result.sampleStart(); // 标记事务开始
            InputStream inputStream = connection.getInputStream();
            while ((inputStream.read(buffer)) != -1){
                data = new String(buffer, "UTF-8");
                stringBuffer.append(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        data = stringBuffer.toString();
        result.setResponseData(data,null);
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
