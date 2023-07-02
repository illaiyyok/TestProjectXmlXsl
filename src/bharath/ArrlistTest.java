package bharath;

import junit.framework.TestCase;

public class ArrlistTest extends TestCase {

	Arrlist val = new Arrlist();

	public void testAdd() {

		val.add(1);
		val.add(2);
		val.add(3);
		val.add(4);
		val.add(5);
		val.add(6);
		val.add(7);
		val.add(8);

		// System.out.println(val.toString());
		// System.out.println((val.indexOf(0)).);
		assertEquals(8, val.size());

		assertEquals(8, val.get(7));
		// assertEquals(4, val.get(3));

	}

	public void testClear() {
		val.clear();
		val.add(1);
		val.add(2);
		val.add(3);
		val.add(4);
		val.add(5);
		val.add(6);
		val.add(7);
		val.add(8);
		val.add(9);
		val.add(10);
		val.add(11);

		// System.out.println(val.toString());
		// System.out.println((val.indexOf(0)).);
		assertEquals(11, val.size());

		val.clear();

		assertEquals(0, val.size());
		// assertEquals(4, val.get(3));

	}

	public void testSize() {

		val.clear();
		val.add(1);
		val.add(2);
		val.add(3);
		val.add(4);
		val.add(5);
		val.add(6);
		val.add(7);
		val.add(8);

		assertEquals(8, val.size());
		// assertEquals(4, val.get(3));

	}

	public void testIsEmpty() {
		val.clear();
		val.add(1);
		val.add(2);
		val.add(3);
		val.add(4);
		val.add(5);
		val.add(6);
		val.add(7);
		val.add(8);

		assertEquals(8, val.size());
		assertEquals(false, val.isEmpty());
		val.clear();
		assertEquals(true, val.isEmpty());
		// assertEquals(4, val.get(3));

	}

	public void testcontains() {
		val.clear();
		val.add(1);
		val.add(2);
		val.add(3);
		val.add(4);
		val.add(5);
		val.add(6);
		val.add(7);
		val.add(8);

		assertEquals(8, val.size());
		assertSame(true, val.contains(5));
		assertSame(false, val.contains(50));
	}

	public void testset() {

		Arrlist val = new Arrlist();
		val.add(1);
		val.add(2);
		val.add(3);
		val.add(33);
		val.add(5);
		// val.set(3,33);
		val.set(3, 44);



		assertEquals(44, val.get(3));

	}

	public void testdelete() {
		val.clear();
		val.add(1);
		val.add(2);
		val.add(3);
		val.add(33);
		val.add(5);
		val.add(1);
		val.add(2);
		val.add(3);
		val.add(33);
		val.add(5);
		
		assertEquals(10, val.size());
		val.delete(1);
		assertEquals(9, val.size());
		assertEquals(3, val.get(1));
		
		
		
	}

}