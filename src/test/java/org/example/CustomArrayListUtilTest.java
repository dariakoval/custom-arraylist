package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CustomArrayListUtilTest {

    @Test
    void testSortStringList() {
        var testStringList = new CustomArrayList<String>();
        testStringList.add("Milk");
        testStringList.add("Water");
        testStringList.add("Cookies");
        testStringList.add("Avocado");
        var expected = "[Avocado, Cookies, Milk, Water]";
        var actual = CustomArrayListUtil.sort(testStringList);
        assertThat(actual.toString()).isEqualTo(expected);
    }

    @Test
    void testSortIntegerList() {
        var testIntegerList = new CustomArrayList<Integer>();
        testIntegerList.add(6);
        testIntegerList.add(28);
        testIntegerList.add(-50);
        testIntegerList.add(0);
        var expected = "[-50, 0, 6, 28]";
        var actual = CustomArrayListUtil.sort(testIntegerList);
        assertThat(actual.toString()).isEqualTo(expected);
    }
}
