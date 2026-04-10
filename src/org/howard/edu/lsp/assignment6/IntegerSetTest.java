package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    @Test
    void testAdd() {
    IntegerSet set = new IntegerSet();
    set.add(1);
    assertTrue(set.contains(1));
}

@Test
void testAddDuplicate() {
    IntegerSet set = new IntegerSet();
    set.add(1);
    set.add(1);
    assertEquals(1, set.length());
}

@Test
void testRemove() {
    IntegerSet set = new IntegerSet();
    set.add(1);
    set.remove(1);
    assertFalse(set.contains(1));
}

@Test
void testRemoveMissing() {
    IntegerSet set = new IntegerSet();
    set.remove(5);
    assertTrue(set.isEmpty());
}

@Test
void testContains() {
    IntegerSet set = new IntegerSet();
    set.add(1);
    assertTrue(set.contains(1));
}

@Test
void testContainsNotPresent() {
    IntegerSet set = new IntegerSet();
    assertFalse(set.contains(10));
}

@Test
void testIsEmpty() {
    IntegerSet set = new IntegerSet();
    assertTrue(set.isEmpty());
    set.add(1);
    assertFalse(set.isEmpty());
}

@Test
void testEqualsSameElementsDifferentOrder() {
    IntegerSet a = new IntegerSet();
    IntegerSet b = new IntegerSet();

    a.add(1); a.add(2);
    b.add(2); b.add(1);

    assertTrue(a.equals(b));
}

@Test
void testEqualsMismatch() {
    IntegerSet a = new IntegerSet();
    IntegerSet b = new IntegerSet();

    a.add(1);
    b.add(2);

    assertFalse(a.equals(b));
}

@Test
void testLargest() {
    IntegerSet set = new IntegerSet();
    set.add(1); set.add(3);
    assertEquals(3, set.largest());
}

@Test
void testLargestException() {
    IntegerSet set = new IntegerSet();
    assertThrows(RuntimeException.class, set::largest);
}

@Test
void testSmallest() {
    IntegerSet set = new IntegerSet();
    set.add(1); set.add(3);
    assertEquals(1, set.smallest());
}

@Test
void testSmallestException() {
    IntegerSet set = new IntegerSet();
    assertThrows(RuntimeException.class, set::smallest);
}

@Test
void testUnion() {
    IntegerSet a = new IntegerSet();
    IntegerSet b = new IntegerSet();
    a.add(1); b.add(2);
    assertEquals("[1, 2]", a.union(b).toString());
}

@Test
void testUnionEmpty() {
    IntegerSet a = new IntegerSet();
    IntegerSet b = new IntegerSet();
    a.add(1);
    assertEquals("[1]", a.union(b).toString());
}

@Test
void testIntersect() {
    IntegerSet a = new IntegerSet();
    IntegerSet b = new IntegerSet();
    a.add(1); b.add(1);
    assertEquals("[1]", a.intersect(b).toString());
}

@Test
void testIntersectNone() {
    IntegerSet a = new IntegerSet();
    IntegerSet b = new IntegerSet();
    a.add(1); b.add(2);
    assertEquals("[]", a.intersect(b).toString());
}

@Test
void testDiff() {
    IntegerSet a = new IntegerSet();
    IntegerSet b = new IntegerSet();
    a.add(1); b.add(2);
    assertEquals("[1]", a.diff(b).toString());
}

@Test
void testDiffIdentical() {
    IntegerSet a = new IntegerSet();
    a.add(1);
    assertEquals("[]", a.diff(a).toString());
}

@Test
void testComplement() {
    IntegerSet a = new IntegerSet();
    IntegerSet b = new IntegerSet();
    a.add(1); b.add(2);
    assertEquals("[2]", a.complement(b).toString());
}

@Test
void testComplementDisjoint() {
    IntegerSet a = new IntegerSet();
    IntegerSet b = new IntegerSet();
    b.add(5);
    assertEquals("[5]", a.complement(b).toString());
}

@Test
void testToString() {
    IntegerSet set = new IntegerSet();
    set.add(3); set.add(1);
    assertEquals("[1, 3]", set.toString());
}

@Test
void testToStringEmpty() {
    IntegerSet set = new IntegerSet();
    assertEquals("[]", set.toString());
}
}