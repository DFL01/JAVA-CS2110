package linklists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CListTest {

    @Test
    void testConstructor() {
        CList<Integer> c= new CList<>();
        assertEquals("[]", c.toString());
        assertEquals("[]", c.toStringR());
        assertEquals(0, c.size());
    }

    @Test
    public void testPrependAndToStringR() {
        CList<String> cl= new CList<>();
        cl.prepend("CS2110");
        assertEquals("[CS2110]", cl.toString());
        assertEquals("[CS2110]", cl.toStringR());
        assertEquals(1, cl.size());
        cl.prepend("CS1110");
        assertEquals("[CS1110, CS2110]", cl.toString());
        assertEquals("[CS2110, CS1110]", cl.toStringR());
        assertEquals(2, cl.size());

        CList<String> c2= new CList<>();
        c2.prepend("");
        c2.prepend("");
        assertEquals("[, ]", c2.toString());
        assertEquals("[, ]", c2.toStringR());
        assertEquals(2, c2.size());

    }

    @Test
    public void testPrepend() {
        CList<String> cl= new CList<>();
        cl.prepend("l");
        assertEquals("[l]", cl.toString());
        assertEquals("[l]", cl.toStringR());
        assertEquals(1, cl.size());
        cl.prepend("o");
        assertEquals("[o, l]", cl.toString());
        assertEquals("[l, o]", cl.toStringR());
        assertEquals(2, cl.size());
        cl.prepend("l");
        assertEquals("[l, o, l]", cl.toString());
        assertEquals("[l, o, l]", cl.toStringR());
        assertEquals(3, cl.size());

        CList<String> c2= new CList<>();
        c2.prepend("World");
        assertEquals("[World]", c2.toString());
        assertEquals("[World]", c2.toStringR());
        assertEquals(1, c2.size());
        c2.prepend("Hello");
        assertEquals("[Hello, World]", c2.toString());
        assertEquals("[World, Hello]", c2.toStringR());
        assertEquals(2, c2.size());
        c2.prepend(null);
        assertEquals("[null, Hello, World]", c2.toString());
        assertEquals("[World, Hello, null]", c2.toStringR());
        assertEquals(3, c2.size());
    }

    @Test
    public void testChangeHeadToNext() {
        CList<Integer> cl= new CList<>();
        cl.append(5);
        cl.append(3);
        cl.append(4);
        cl.append(6);
        cl.changeHeadToNext();
        assertEquals("[3, 4, 6, 5]", cl.toString());
        assertEquals("[5, 6, 4, 3]", cl.toStringR());
        assertEquals(4, cl.size());

        CList<String> c2= new CList<>();
        c2.append("egg");
        c2.changeHeadToNext();
        assertEquals("[egg]", c2.toString());
        assertEquals("[egg]", c2.toStringR());
        assertEquals(1, c2.size());

        CList<String> c3= new CList<>();
        c3.changeHeadToNext();
        assertEquals("[]", c3.toString());
        assertEquals("[]", c3.toStringR());
        assertEquals(0, c3.size());

    }

    @Test
    public void testAppend() {
        CList<Integer> cl= new CList<>();
        cl.append(5);
        assertEquals("[5]", cl.toString());
        assertEquals("[5]", cl.toStringR());
        assertEquals(1, cl.size());
        cl.append(3);
        assertEquals("[5, 3]", cl.toString());
        assertEquals("[3, 5]", cl.toStringR());
        assertEquals(2, cl.size());

        CList<String> c2= new CList<>();
        c2.append("Hello");
        assertEquals("[Hello]", c2.toString());
        assertEquals("[Hello]", c2.toStringR());
        assertEquals(1, c2.size());
        c2.append("World");
        assertEquals("[Hello, World]", c2.toString());
        assertEquals("[World, Hello]", c2.toStringR());
        assertEquals(2, c2.size());
        c2.append(null);
        assertEquals("[Hello, World, null]", c2.toString());
        assertEquals("[null, World, Hello]", c2.toStringR());
        assertEquals(3, c2.size());

    }

    @Test
    public void testgetNode() {
        CList<String> cl= new CList<>();
        cl.append("a");
        cl.append("b");
        cl.append("c");
        cl.append("d");
        cl.append("e");
        cl.append("f");
        cl.append("g");
        cl.append("h");
        cl.append("i");
        assertEquals("[a, b, c, d, e, f, g, h, i]", cl.toString());
        assertEquals("[i, h, g, f, e, d, c, b, a]", cl.toStringR());
        assertEquals(9, cl.size());

        assertEquals("f", cl.getNode(5).data());
        assertEquals("b", cl.getNode(1).data());
        assertEquals("e", cl.getNode(4).data());

        CList<Integer> c2= new CList<>();
        for (int i= 0; i < 15; i++ ) {
            c2.append(i);
        }
        for (int i= 0; i < 15; i++ ) {
            assertEquals(i, c2.getNode(i).data());
        }

    }

    @Test
    public void testRemove() {
        CList<Integer> cl= new CList<>();
        cl.append(1);
        cl.append(12);
        cl.append(5);
        cl.append(9);
        cl.append(2);
        cl.append(4);
        cl.append(7);
        cl.append(3);
        assertEquals("[1, 12, 5, 9, 2, 4, 7, 3]", cl.toString());
        assertEquals("[3, 7, 4, 2, 9, 5, 12, 1]", cl.toStringR());
        assertEquals(8, cl.size());
        cl.remove(cl.getNode(4));
        assertEquals("[1, 12, 5, 9, 4, 7, 3]", cl.toString());
        assertEquals("[3, 7, 4, 9, 5, 12, 1]", cl.toStringR());
        assertEquals(7, cl.size());

        CList<String> c2= new CList<>();
        c2.append("cap");
        assertEquals("[cap]", c2.toString());
        assertEquals("[cap]", c2.toStringR());
        assertEquals(1, c2.size());
        c2.remove(c2.getNode(0));
        assertEquals("[]", c2.toString());
        assertEquals("[]", c2.toStringR());
        assertEquals(0, c2.size());

        CList<Integer> c3= new CList<>();
        c3.append(19);
        c3.append(5);
        c3.append(25);
        c3.append(9);
        assertEquals("[19, 5, 25, 9]", c3.toString());
        assertEquals("[9, 25, 5, 19]", c3.toStringR());
        assertEquals(4, c3.size());
        c3.remove(c3.getNode(3));
        assertEquals("[19, 5, 25]", c3.toString());
        assertEquals("[25, 5, 19]", c3.toStringR());
        assertEquals(3, c3.size());

        CList<String> c4= new CList<>();
        c4.append("CS 1110");
        c4.append("CS 2110");
        c4.append("CS 3110");
        assertEquals("[CS 1110, CS 2110, CS 3110]", c4.toString());
        assertEquals("[CS 3110, CS 2110, CS 1110]", c4.toStringR());
        assertEquals(3, c4.size());
        c4.remove(c4.getNode(0));
        assertEquals("[CS 2110, CS 3110]", c4.toString());
        assertEquals("[CS 3110, CS 2110]", c4.toStringR());
        assertEquals(2, c4.size());

    }

    @Test
    public void testInsertBefore() {
        CList<Integer> cl= new CList<>();
        cl.append(1);
        cl.append(12);
        cl.append(5);
        cl.append(9);
        cl.append(2);
        cl.append(4);
        cl.append(7);
        cl.append(3);
        assertEquals("[1, 12, 5, 9, 2, 4, 7, 3]", cl.toString());
        assertEquals("[3, 7, 4, 2, 9, 5, 12, 1]", cl.toStringR());
        assertEquals(8, cl.size());
        cl.insertBefore(24, cl.getNode(2));
        assertEquals("[1, 12, 24, 5, 9, 2, 4, 7, 3]", cl.toString());
        assertEquals("[3, 7, 4, 2, 9, 5, 24, 12, 1]", cl.toStringR());
        assertEquals(9, cl.size());

        CList<Integer> c2= new CList<>();
        c2.append(4);
        assertEquals("[4]", c2.toString());
        assertEquals("[4]", c2.toStringR());
        assertEquals(1, c2.size());
        c2.insertBefore(2, c2.getNode(0));
        assertEquals("[2, 4]", c2.toString());
        assertEquals("[4, 2]", c2.toStringR());
        assertEquals(2, c2.size());

    }
}
