package com.shark.example.service.test;

import com.shark.example.service.base.BaseService;
import com.shark.example.service.test.dio.TestInput;
import com.shark.example.service.test.dto.TestOutput;
import org.springframework.stereotype.Service;

@Service("TestService")
public class TestService extends BaseService<TestInput, TestOutput> {
    public TestOutput start(TestInput testInput) {
        TestOutput output = new TestOutput();
        output.setParameter(testInput.getParameter());
        return output;
    }
}
