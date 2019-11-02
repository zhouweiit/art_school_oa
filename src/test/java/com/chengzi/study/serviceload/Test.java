package com.chengzi.study.serviceload;
/**
 * META-INF下新建一个文件夹services，并在services下新建一个文件，以接口的全限定名为文件名，内容为实现类的全限定名
 一、使用场景
 一般使用接口的实现类都是静态new一个实现类赋值给接口引用，如下：

 HelloService service = new HelloImpl();

 如果需要动态的获取一个接口的实现类呢？全局扫描全部的Class，然后判断是否实现了某个接口？代价太大，一般不会这么做。
 一种合适的方式就是使用配置文件，把实现类名配置在某个地方，然后读取这个配置文件，获取实现类名。JDK给我们提供的TestServiceLoader 就是这种方式。

 */
public interface Test {

    void hello();

}
