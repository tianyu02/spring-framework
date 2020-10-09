package com.kerwin.springframework.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.assertj.core.util.Sets;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;

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
		int i = 0;
		System.out.println(++i);
	}

	private List<Integer> selectByIds(List<Integer> ids) {
		System.out.println("selectByIds ids:" + ids);
		return ids;
	}

	@Test
	public void Ttest() {
		genericTest(Arrays.asList(new Boy(), new Girl(), 3, 4));
		BaseResult<String, String> baseResult = new BaseResult<>();
		baseResult.setKey("name");
		baseResult.setValue("tianyu");
		genericTest2(baseResult);


		List<Boy> boys = Lists.newArrayList();
		List<People> girls = Lists.newArrayList();
		genericTest3(boys, girls);

	}


	@Test
	public void functionTest () {
		Function<String, Set<String>> strToIntegerSetTransfer =
				s -> {Set<String> set = Sets.newHashSet();
					set.add(s);
					return set; };
		Set<String> strings = funTest(strToIntegerSetTransfer);
		System.out.println(strings);
	}

	@Test
	public void streamTest() {
		HashMap<Object, String> map = Maps.newHashMap();
		new ArrayList<>(map.values());
		HashMap<Object, String> map1 = null;
		try {
			map1 = Maps.newHashMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Set<String> funTest(Function<String, Set<String>> function) {
		return function.apply("kerwin");
	}

	public <T> void genericTest(List<T> param) {
		List<T> list = new ArrayList<>();
		list.add(param.get(0));
		list.add(param.get(1));
		System.out.println(param);
	}

	public <K, V> void genericTest2(BaseResult<K, V> param) {
	}

	public <K, V> void genericTest3(List<? extends People> k, List<? super Boy> v) {
		System.out.println(k);
		System.out.println(v);

	}




	public static class Annimal {

	}
	public abstract class People extends Annimal {
		void run() {
			System.out.println("run");
		}
	}

	public class Boy extends People {
		@Override
		void run() {
			System.out.println("run fast");
		}
	}

	public class Girl extends People {
		@Override
		void run() {
			System.out.println("run slow");
		}
	}

	public class Child extends Boy {

	}

	public static class BaseResult<K, V> {
		private K key;
		private V value;

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}
}


