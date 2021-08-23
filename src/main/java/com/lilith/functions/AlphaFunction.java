package com.lilith.functions;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

import java.util.Collection;
import java.util.List;

/**
 * @Author:JiaJingnan
 * @Date: 上午1:14 2021/8/24
 * 扩展函数组件开发，所在包名必须命名为functions
 */
public class AlphaFunction extends AbstractFunction {

    /**
     * 执行方法
     * @param sampleResult
     * @param sampler
     * @return
     * @throws InvalidVariableException
     */
    @Override
    public String execute(SampleResult sampleResult, Sampler sampler) throws InvalidVariableException {
        System.out.println("execute方法运行");
        return null;
    }

    /**
     * 设置参数方法,接收用户传递的参数
     * @param collection
     * @throws InvalidVariableException
     */
    @Override
    public void setParameters(Collection<CompoundVariable> collection) throws InvalidVariableException {

        System.out.println("setParameters run");
    }

    /**
     * 功能名称
     * @return
     */
    @Override
    public String getReferenceKey() {
        System.out.println("getReferenceKey");
        return "__alphaFunction";
    }

    /**
     * 功能描述，参数描述
     * @return
     */
    @Override
    public List<String> getArgumentDesc() {
        System.out.println("getArgumentDesc");
        return null;
    }
}
