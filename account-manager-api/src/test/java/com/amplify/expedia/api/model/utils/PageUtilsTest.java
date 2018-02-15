package com.amplify.expedia.api.model.utils;

import com.amplify.expedia.api.model.SearchPage;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Nicolas Scotta.
 */
public class PageUtilsTest {

  @Test
  public void testPaginationOnFirstPage() {
    List<Integer> list = Arrays
        .asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
    SearchPage page = new SearchPage(1, 5);
    List pageResults = PageUtils.page(list, page.getSize(), page.getOffset());

    Assert.assertEquals(5, pageResults.size());
    Assert.assertEquals(1, pageResults.stream().findFirst().get());
    Assert.assertEquals(5, pageResults.stream().reduce((first, second) -> second).get());
  }

  @Test
  public void testPaginationOnFirstPageWithPageZero() {
    List<Integer> list = Arrays
        .asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
    SearchPage page = new SearchPage(0, 5);
    List pageResults = PageUtils.page(list, page.getSize(), page.getOffset());

    Assert.assertEquals(5, pageResults.size());
    Assert.assertEquals(1, pageResults.stream().findFirst().get());
    Assert.assertEquals(5, pageResults.stream().reduce((first, second) -> second).get());
  }

  @Test
  public void testPaginationOnSecondPage() {
    List<Integer> list = Arrays
        .asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
    SearchPage page = new SearchPage(2, 5);
    List pageResults = PageUtils.page(list, page.getSize(), page.getOffset());

    Assert.assertEquals(5, pageResults.size());
    Assert.assertEquals(6, pageResults.stream().findFirst().get());
    Assert.assertEquals(10, pageResults.stream().reduce((first, second) -> second).get());
  }

  @Test
  public void testPaginationOnMiddlePage() {
    List<Integer> list = Arrays
        .asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
    SearchPage page = new SearchPage(4, 3);
    List pageResults = PageUtils.page(list, page.getSize(), page.getOffset());

    Assert.assertEquals(3, pageResults.size());
    Assert.assertEquals(10, pageResults.stream().findFirst().get());
    Assert.assertEquals(12, pageResults.stream().reduce((first, second) -> second).get());
  }

  @Test
  public void testPaginationWithSizeLessThanTo() {
    List<Integer> list = Arrays
        .asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
    SearchPage page = new SearchPage(4, 5);
    List pageResults = PageUtils.page(list, page.getSize(), page.getOffset());

    Assert.assertEquals(3, pageResults.size());
    Assert.assertEquals(16, pageResults.stream().findFirst().get());
    Assert.assertEquals(18, pageResults.stream().reduce((first, second) -> second).get());
  }

  @Test
  public void testPaginationWithSizeLessThanFrom() {
    List<Integer> list = Arrays
        .asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
    SearchPage page = new SearchPage(5, 5);
    List pageResults = PageUtils.page(list, page.getSize(), page.getOffset());

    Assert.assertTrue(pageResults.isEmpty());
  }
}
