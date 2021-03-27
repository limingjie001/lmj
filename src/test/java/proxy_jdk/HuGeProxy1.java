package proxy_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HuGeProxy1 {
    private HuGe huGe;

    public void setHuGe(HuGe huGe) {
        this.huGe = huGe;
    }

    public Star getProxy(){
        return (Star) Proxy.newProxyInstance(huGe.getClass().getClassLoader(), huGe.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                return method.invoke(huGe,args);
            }
        });
    }

}
