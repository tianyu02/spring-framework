package com.kerwin.springframework.beandefinition;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring
 * @description: BeanDefinitionTest
 * @author: tianyu
 * @create: 2020-09-28 10:07
 **/
public class BeanDefinitionTest
{
	@Test
	public void bdTest() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.refresh();
		Assert.assertNotNull("ctx is null", ctx);
	}
}
