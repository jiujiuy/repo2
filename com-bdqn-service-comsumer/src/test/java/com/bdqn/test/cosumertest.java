package com.bdqn.test;


import com.bdqn.AppTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppTest.class)
public class cosumertest {

    @Autowired
    private RibbonLoadBalancerClient loadBalancerClient;

    @Test
    public void show(){
        for (int i = 0; i < 100; i++) {
            ServiceInstance instance = this.loadBalancerClient.choose("service-provider");
            System.out.println(instance.getHost() + ":" +instance.getPort());
        }
    }

}
