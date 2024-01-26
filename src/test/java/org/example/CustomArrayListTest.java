package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomArrayListTest {

    private CustomArrayList<String> testStringList;
    private CustomArrayList<Integer> testIntegerList;

    @BeforeEach
    void setUp() {
        testStringList = new CustomArrayList<>();
        testIntegerList = new CustomArrayList<>();
    }

    @AfterEach
    void tearDown() {
        testStringList = null;
        testIntegerList = null;
    }

    @Test
    void testGetSize() {
        assertThat(testStringList.getSize()).isEqualTo(0);
        testStringList.add("One");
        assertThat(testStringList.getSize()).isEqualTo(1);

        assertThat(testIntegerList.getSize()).isEqualTo(0);
        testIntegerList.add(1);
        assertThat(testIntegerList.getSize()).isEqualTo(1);
    }

    @Test
    void testToArray() {
        testStringList.add("One");
        testStringList.add("Two");
        Assertions.assertArrayEquals(testStringList.toArray(), new String[]{"One", "Two"});

        testIntegerList.add(1);
        testIntegerList.add(2);
        Assertions.assertArrayEquals(testIntegerList.toArray(), new Integer[]{1, 2});
    }

    @Test
    void testToString() {
        testStringList.add("One");
        assertThat(testStringList.toString()).isEqualTo("[One]");

        testIntegerList.add(1);
        assertThat(testIntegerList.toString()).isEqualTo("[1]");
    }

    @Test
    void testAdd() {
        assertThat(testStringList.add("One")).isTrue();
        assertThat(testStringList.getSize()).isEqualTo(1);
        assertThat(testStringList.toString()).isEqualTo("[One]");

        testIntegerList.add(1);
        assertThat(testIntegerList.getSize()).isEqualTo(1);
        assertThat(testIntegerList.toString()).isEqualTo("[1]");
    }

    @Test
    void testAddAll() {
        testStringList.add("One");
        var sourceStringList = new CustomArrayList<String>();
        sourceStringList.add("Two");
        sourceStringList.add("Three");
        assertThat(testStringList.addAll(sourceStringList)).isTrue();
        assertThat(testStringList.getSize()).isEqualTo(3);
        assertThat(testStringList.toString()).isEqualTo("[One, Two, Three]");

        testIntegerList.add(1);
        var sourceIntegerList = new CustomArrayList<Integer>();
        sourceIntegerList.add(2);
        sourceIntegerList.add(3);
        assertThat(testIntegerList.addAll(sourceIntegerList)).isTrue();
        assertThat(testIntegerList.getSize()).isEqualTo(3);
        assertThat(testIntegerList.toString()).isEqualTo("[1, 2, 3]");

    }

    @Test
    void testInsert() {
        testStringList.add("One");
        testStringList.add("Two");
        testStringList.add("Three");
        testStringList.insert(1, "Six");
        assertThat(testStringList.getSize()).isEqualTo(4);
        assertThat(testStringList.toString()).isEqualTo("[One, Six, Two, Three]");

        testIntegerList.add(1);
        testIntegerList.add(2);
        testIntegerList.add(3);
        testIntegerList.insert(2, 10);
        assertThat(testIntegerList.getSize()).isEqualTo(4);
        assertThat(testIntegerList.toString()).isEqualTo("[1, 2, 10, 3]");
    }

    @Test
    void testInsertByIndexOutOfBounds() {
        testStringList.add("One");
        assertThat(testStringList.getSize()).isEqualTo(1);
        boolean exceptionThrown = false;
        try {
            testStringList.insert(5, "Six");
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);

        testIntegerList.add(1);
        assertThat(testIntegerList.getSize()).isEqualTo(1);
        exceptionThrown = false;
        try {
            testIntegerList.insert(-2, 9);
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    void testGet() {
        testStringList.add("One");
        testStringList.add("Two");
        assertThat(testStringList.get(0)).isEqualTo("One");
        assertThat(testStringList.get(1)).isEqualTo("Two");

        testIntegerList.add(1);
        testIntegerList.add(2);
        assertThat(testIntegerList.get(0)).isEqualTo(1);
        assertThat(testIntegerList.get(1)).isEqualTo(2);
    }

    @Test
    void testGetByIndexOutOfBounds() {
        testStringList.add("One");
        assertThat(testStringList.getSize()).isEqualTo(1);
        boolean exceptionThrown = false;
        try {
            testStringList.get(5);
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);

        testIntegerList.add(1);
        assertThat(testIntegerList.getSize()).isEqualTo(1);
        exceptionThrown = false;
        try {
            testIntegerList.get(-2);
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    void testRemoveByIndex() {
        testStringList.add("One");
        testStringList.add("Two");
        assertThat(testStringList.getSize()).isEqualTo(2);
        testStringList.remove(0);
        assertThat(testStringList.toString()).doesNotContain("One");

        testIntegerList.add(1);
        testIntegerList.add(2);
        assertThat(testIntegerList.getSize()).isEqualTo(2);
        testIntegerList.remove(0);
        assertThat(testIntegerList.toString()).doesNotContain("1");
    }

    @Test
    void testRemoveByIndexOutOfBounds() {
        testStringList.add("One");
        assertThat(testStringList.getSize()).isEqualTo(1);
        boolean exceptionThrown = false;
        try {
            testStringList.remove(5);
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);

        testIntegerList.add(1);
        assertThat(testIntegerList.getSize()).isEqualTo(1);
        exceptionThrown = false;
        try {
            testIntegerList.remove(-2);
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    void testRemoveObj() {
        testStringList.add("One");
        testStringList.add("Two");
        assertThat(testStringList.remove("One")).isTrue();
        assertThat(testStringList.toString()).doesNotContain("One");
        assertThat(testStringList.remove("Six")).isFalse();

        testIntegerList.add(1);
        testIntegerList.add(2);
        assertThat(testIntegerList.remove(Integer.valueOf(1))).isTrue();
        assertThat(testIntegerList.toString()).doesNotContain("1");
        assertThat(testIntegerList.remove(Integer.valueOf(6))).isFalse();
    }

    @Test
    void testClear() {
        testStringList.add("One");
        testStringList.add("Two");
        testStringList.add("Three");
        assertThat(testStringList.getSize()).isEqualTo(3);
        testStringList.clear();
        assertThat(testStringList.getSize()).isEqualTo(0);

        testIntegerList.add(1);
        testIntegerList.add(2);
        testIntegerList.add(3);
        assertThat(testIntegerList.getSize()).isEqualTo(3);
        testIntegerList.clear();
        assertThat(testIntegerList.getSize()).isEqualTo(0);
    }
}

