
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection; 
import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Linked"}, {"Array"} });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private <E> MyList<E> makeList(E[] contents) {
		switch (this.listType) {
		case "Linked":
			return new LinkedGL<E>(contents);
		case "Array":
			return new ArrayGL<E>(contents);
		}
		return null;
	}

  // Don't change code above this line, it ensures the autograder works as
  // expected


  // This is a sample test; you can keep it, change it, or remove it as you like.
  // Note that it uses the method `assertArrayEquals`, which you should use to
  // test equality of arrays in this PA.
	@Test
	public void testSimpleToArray() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3};
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
		
		// Using the generic list to create a String list
		String[] string_input = {"a", "b", "c"};
		MyList<String> string_s = makeList(string_input);
		assertArrayEquals(string_input, string_s.toArray());
	}
	
	@Test
	public void testNullArray() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3, null, 5};
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
		
		// Using the generic list to create a String list
		String[] string_input = {"a", "b", "c", null, "e"};
		MyList<String> string_s = makeList(string_input);
		assertArrayEquals(string_input, string_s.toArray());
	}
	
	@Test
	public void testTransforms() {
		Integer[] int_input = {1, 2, 3};
		MyList<Integer> int_s = makeList(int_input);
		Integer[] output = {10, 20, 30};
		int_s.transformAll(new multiplyBy10());
		assertArrayEquals(output, int_s.toArray());
	}
	
	@Test
	public void testChooses() {
		Integer[] int_input = {1, 2, 3, 4, 5};
		MyList<Integer> int_s = makeList(int_input);
		Integer[] output = {2, 4};
		int_s.chooseAll(new evenNumChooser());
		assertArrayEquals(output, int_s.toArray());
	} 

	@Test
	public void testMultipleOps() {
		Integer[] int_input = {1, 2, 3, 4, 5};
		MyList<Integer> int_s = makeList(int_input);
		Integer[] output = {20, 40};
		int_s.chooseAll(new evenNumChooser());
		int_s.transformAll(new multiplyBy10());
		assertArrayEquals(output, int_s.toArray());
	} 
	
	@Test
	public void testNulls() {
		// Using the generic list to create an Integer list
		String[] int_input = {null, null, null, null};
		MyList<String> int_s = makeList(int_input);
		assertEquals(false, int_s.isEmpty());
	}
	
	@Test
	public void testEmptyArray() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {};
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
		
		// Using the generic list to create a String list
		String[] string_input = {};
		MyList<String> string_s = makeList(string_input);
		assertArrayEquals(string_input, string_s.toArray());
	}
	
	@Test
	public void testEmptyTransforms() {
		Integer[] int_input = {};
		MyList<Integer> int_s = makeList(int_input);
		Integer[] output = {};
		int_s.transformAll(new multiplyBy10());
		assertArrayEquals(output, int_s.toArray());
	}
	
	@Test
	public void sizeOfList() {
		Integer int_input[] = new Integer[10];
		int_input[0] = 10;
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
	}
}