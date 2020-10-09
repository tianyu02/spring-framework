package com.kerwin.springframework.test;

import com.google.common.base.Optional;
import com.google.common.collect.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @program: spring
 * @description: guava use
 * @author: tianyu
 * @create: 2020-09-30 12:06
 **/
public class GuavaTest {
	@Test
	public void guavaTest() {
		List<Integer> list = ImmutableList.of(1, 2, 3);
		ListMultimap<Object, Object> multimap = MultimapBuilder.hashKeys().arrayListValues().build();
		multimap.put("name", "kerwin");
		multimap.put("name", "kerwin");
		Map<Object, Collection<Object>> objectCollectionMap = multimap.asMap();
		System.out.println(objectCollectionMap);

	}

	@Test
	public void multiSetTest() {
		HashMultiset<Integer> multiset = HashMultiset.create();
		HashSet<Object> objects = Sets.newHashSet();
		objects.add(1);
		objects.add(1);
		multiset.add(1);
		multiset.add(2);
		multiset.add(3);
		multiset.add(1);
		Assert.assertEquals(4, multiset.size());
		Assert.assertEquals(1, objects.size());
		int count = multiset.count(1);
		Assert.assertEquals(2, count);
		Set<Multiset.Entry<Integer>> entries = multiset.entrySet();
		entries.forEach(e -> {
			Integer element = e.getElement();
			System.out.println(element);
		});
		multiset.elementSet().forEach(System.out::println);
		multiset.removeIf(t -> {
			return t.equals(1);
		});
		Iterator<Integer> iterator = multiset.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

	@Test
	public void multiMapTest() {
		ListMultimap<String, String> multimap = MultimapBuilder.hashKeys(1).arrayListValues(0).build();
		multimap.put("name", "kerwin");
		multimap.put("age", "25");
		multimap.put("name", "zhusi");
//		List<Object> ageList = multimap.get("age");
//		System.out.println(ageList);
//		List<Object> nameList = multimap.get("name");
//		System.out.println(nameList);
//		boolean remove = multimap.remove("name", "kerwin");
//		System.out.println(multimap.get("name"));
//		multimap.removeAll("name");
//		System.out.println(multimap.get("name"));
//		multimap.put("name", "kerwin");
//		multimap.put("age", 25);
//		multimap.put("name", "zhusi");
//		Map<String, Collection<Object>> asMap = multimap.asMap();
//		List<Object> name = (List)asMap.get("name");
//		System.out.println(name);

		multimap.entries().forEach(stringObjectEntry -> {
			System.out.println(stringObjectEntry.getKey());
			System.out.println(stringObjectEntry.getValue());
		});
		Set<String> strings = multimap.keySet();
		multimap.values().forEach(e -> {
			System.out.println(e);
		});
		List<String> names = multimap.get("name");
		System.out.println(names);
	}

	@Test
	public void setsTest() {
		HashSet<Object> objects = Sets.newHashSet();
		objects.add("one");
		objects.add("two");

		HashSet<Object> objects1 = Sets.newHashSet();
		objects1.add("two");
		objects1.add("three");
		Set<Object> union = Sets.union(objects, objects1);
		System.out.println(union);
		Set<Object> intersection = Sets.intersection(objects, objects1);
		System.out.println(intersection);
		Sets.SetView<Object> difference = Sets.difference(objects1, objects);
		System.out.println(difference);
	}

	@Test
	public void optionalTest() {
		List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
		Optional<List<Integer>> of = Optional.of(list);
		list = null;
		Optional<List<Integer>> listOptional = Optional.fromNullable(list);
		boolean present = listOptional.isPresent();
		Assert.assertEquals(false, present);
//		List<Integer> list1 = listOptional.get();
		List<Integer> list2 = listOptional.orNull();
		System.out.println(list2);
	}
}
