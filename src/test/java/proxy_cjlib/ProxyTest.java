package proxy_cjlib;

import org.junit.jupiter.api.Test;

public class ProxyTest {
    @Test
    public void Test1(){
        Huge huge=new Huge();
        ProxyFactory proxyFactory = new ProxyFactory();
        Huge huge1 = (Huge) proxyFactory.creatProxy(huge);
        huge1.act("5555");

    }
}
