package com.ymkz.listener;

import com.ymkz.beanDefinition.MyBeandefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

public class InstantiationCustomBeanDefinitionListener implements ApplicationListener<ApplicationPreparedEvent> {


    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        ConfigurableApplicationContext applicationContext = event.getApplicationContext();
        AbstractBeanDefinition abstractBeanDefinition = customBeanDefinitionTest();
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory)applicationContext.getBeanFactory();

//        BeanNameGenerator beanNameGenerator = (BeanNameGenerator)defaultListableBeanFactory.getBean(AnnotationConfigUtils.CONFIGURATION_BEAN_NAME_GENERATOR);
//        String beanName = beanNameGenerator.generateBeanName(abstractBeanDefinition, defaultListableBeanFactory);
//        System.out.println("custom bean name = " + beanName);
        defaultListableBeanFactory.registerBeanDefinition(abstractBeanDefinition.getBeanClass().getSimpleName(), abstractBeanDefinition);
    }


    public AbstractBeanDefinition customBeanDefinitionTest() {
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(MyBeandefinition.class)
                .setRole(BeanDefinition.ROLE_APPLICATION)
                .setScope(BeanDefinition.SCOPE_SINGLETON)
                .addPropertyValue("name", "fsx")
                .setLazyInit(false)
                //Spring5.0后提供的，可以自己书写函数，在里面做任意事情
                //bdf是个AbstractBeanDefinition
                .applyCustomizers((bdf) -> {
                    AbstractBeanDefinition abdf = (AbstractBeanDefinition) bdf;
                    abdf.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_NO);
                }).getRawBeanDefinition();

        // Generic bean: class [com.ymkz.beanDefinition.MyBeandefinition];
        // scope=singleton; abstract=false; lazyInit=false; autowireMode=0;
        // dependencyCheck=0; autowireCandidate=true; primary=false;
        // factoryBeanName=null; factoryMethodName=null; initMethodName=null;
        // destroyMethodName=null
        System.out.println(beanDefinition);

        return beanDefinition;
    }
}
