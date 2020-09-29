package com.kerwin.springframework.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: spring
 * @description: test
 * @author: tianyu
 * @create: 2020-09-27 21:08
 **/
public class MyTest {
	@Test
	public void test() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<List<Integer>> partition = Lists.partition(list, 2);
		partition.stream().flatMap(ids -> selectByIds(ids).stream());
	}

	private List<Integer> selectByIds(List<Integer> ids) {
		System.out.println("selectByIds ids:" + ids);
		return ids;
	}
}
