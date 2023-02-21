package com.syrisa.quarkus;

import com.syrisa.quarkus.util.FizzBuzzExecutor;
import com.syrisa.quarkus.util.GreetingUtil;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class QuarkusApp implements QuarkusApplication {


    GreetingUtil greetingUtil;
    FizzBuzzExecutor fizzBuzzExecutor;

    public QuarkusApp(GreetingUtil greetingUtil,FizzBuzzExecutor fizzBuzzExecutor){
        super();
        this.greetingUtil = greetingUtil;
        this.fizzBuzzExecutor = fizzBuzzExecutor;
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println(this.greetingUtil.getGreetingName());
        fizzBuzzExecutor.execute();
        return 0;
    }
}
