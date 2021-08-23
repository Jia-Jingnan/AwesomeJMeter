package com.lilith.functions;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author:JiaJingnan
 * @Date: 上午1:14 2021/8/24
 * 扩展函数组件开发，所在包名必须命名为functions
 */
public class AlphaFunction extends AbstractFunction {


    // 声明变量接收用户输入
    private Object[] values;

    // 变量存储,存储第一个和第二个参数
    private CompoundVariable first, second;

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
        first = (CompoundVariable) values[0];
        second = (CompoundVariable) values[1];
        int count = new Integer(first.execute().trim()) + new Integer(second.execute().trim());
        System.out.println("相加和：" + count);
        return String.valueOf(count);
    }

    /**
     * 设置参数方法,接收用户传递的参数
     * @param collection
     * @throws InvalidVariableException
     */
    @Override
    public void setParameters(Collection<CompoundVariable> collection) throws InvalidVariableException {
        checkParameterCount(collection,2);
        values = collection.toArray();

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
        List desc = new ArrayList();
        desc.add("第一个数字");
        desc.add("第二个数字");
        return desc;
    }
}
