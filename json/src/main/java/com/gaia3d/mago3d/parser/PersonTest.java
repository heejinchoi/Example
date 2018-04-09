package com.gaia3d.mago3d.parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test() {
		Person person = new Person("최희진", 26);
		
		System.out.println(person.toString());
		System.out.println(person);
		
	}

}
