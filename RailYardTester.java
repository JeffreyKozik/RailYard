import org.junit.*;
import static org.junit.Assert.*;

/*
/**
 * Test RailYard class
 * @author Jeffrey Kozik
 */
public class RailYardTester{
  
  /**
   * Test the cycleSort method that takes an array
   */
  @Test
  public void testCycleSortArray(){
    RailYard<Integer> r = new RailYard<Integer>(0); 
    Integer[] array0 = {3, 2, 1}; 
    Integer[] expectedArray0 = {3, 2, 1}; 
    r.cycleSort(array0);
    assertArrayEquals("Testing cycleSort's first for loop for 0 (no classification yards)", expectedArray0, array0);
    r = new RailYard<Integer>(2); 
    Integer[] array1 = {3, 2, 1};
    r.cycleSort(array1);
    Integer[] expectedArray1 = {2, 3, 1};
    assertArrayEquals("Testing cycleSort's first for loop for 1 (1 classification yard)", expectedArray1, array1);
    r = new RailYard<Integer>(2, 2, 2);
    Integer[] array2 = {3, 2, 1};
    r.cycleSort(array2);
    Integer[] expectedArray2 = {1, 2, 3};
    assertArrayEquals("Testing cycleSort's first for loop for many (3 classification yards)", expectedArray2, array2);
    Integer[] array3 = {}; 
    Integer[] expectedArray3 = {}; 
    r.cycleSort(array3);
    assertArrayEquals("Testing cycleSort's second for loop for 0 (0 cars)", expectedArray3, array3);
    Integer[] array4 = {1}; 
    Integer[] expectedArray4 = {1}; 
    r.cycleSort(array4);
    assertArrayEquals("Testing cycleSort's second for loop for 1 (1 car)", expectedArray4, array4);
    Integer[] array5 = {5, 2, 7, 3, 2, 5, 9, 9}; 
    Integer[] expectedArray5 = {2, 2, 3, 5, 5, 7, 9, 9}; 
    r.cycleSort(array5);
    assertArrayEquals("Testing cycleSort's second for loop for many (many cars)", expectedArray5, array5);
  }
  
  /**
   * Test the closestSort method that takes an array
   */
  @Test
  public void testClosestSortArray(){
    RailYard<Integer> r = new RailYard<Integer>(0); 
    Integer[] array0 = {3, 2, 1}; 
    Integer[] expectedArray0 = {3, 2, 1}; 
    r.closestSort(array0);
    assertArrayEquals("Testing cycleSort's first for loop for 0 (no classification yards)", expectedArray0, array0);
    r = new RailYard<Integer>(2); 
    Integer[] array1 = {3, 2, 1};
    r.closestSort(array1);
    Integer[] expectedArray1 = {2, 1, 3};
    assertArrayEquals("Testing cycleSort's first for loop for 1 (1 classification yard)", expectedArray1, array1);
    r = new RailYard<Integer>(2, 2, 2);
    Integer[] array2 = {3, 2, 1};
    r.closestSort(array2);
    Integer[] expectedArray2 = {1, 2, 3};
    assertArrayEquals("Testing cycleSort's first for loop for many (3 classification yards)", expectedArray2, array2);
    Integer[] array3 = {}; 
    Integer[] expectedArray3 = {}; 
    r.closestSort(array3);
    assertArrayEquals("Testing cycleSort's second for loop for 0 (0 cars)", expectedArray3, array3);
    Integer[] array4 = {1}; 
    Integer[] expectedArray4 = {1}; 
    r.closestSort(array4);
    assertArrayEquals("Testing cycleSort's second for loop for 1 (1 car)", expectedArray4, array4);
    Integer[] array5 = {5, 2, 7, 3, 2, 5, 9, 9}; 
    Integer[] expectedArray5 = {2, 2, 3, 5, 5, 7, 9, 9}; 
    r.closestSort(array5);
    assertArrayEquals("Testing cycleSort's second for loop for many (many cars)", expectedArray5, array5);
  }
  
  /**
   * Test a scenario in which closest sort works and cycle sort doesn't
   */
  @Test
  public void testClosestWorksCycleDoesnt(){
    RailYard<String> r = new RailYard<String>(2); 
    String[] array0 = {"elephant", "cat", "indigo", "dog", "llama"}; 
    String[] sortedArray = {"cat", "dog", "elephant", "indigo", "llama"}; 
    r.closestSort(array0);
    assertArrayEquals("Testing a scenario in which closest sort works and cycle sort doesn't", sortedArray, array0);
    String[] array1 = {"elephant", "cat", "indigo", "dog", "llama"}; 
    r.cycleSort(array1);
    assertNotEquals("Testing a scenario in which closest sort works and cycle sort doesn't", sortedArray, array1);
  }
  
  /**
   * Test a scenario in which cycle sort works and closest sort doesn't
   */
  @Test
  public void testCycleWorksClosestDoesnt(){
    RailYard<Integer> r = new RailYard<Integer>(2,3);
    Integer[] array0 = {5, 2, 7, 3, 2, 5, 9, 9}; 
    Integer[] sortedArray = {2, 2, 3, 5, 5, 7, 9, 9}; 
    r.cycleSort(array0);
    assertArrayEquals("Testing a scenario in which cycle sort works and closest sort doesn't: cycle sort works", sortedArray, array0);
    Integer[] array1 = {5, 2, 7, 3, 2, 5, 9, 9};
    r.closestSort(array1);
    assertNotEquals("Testing a scenario in which cycle sort works and closest sort doesn't: closest sort doesn't", sortedArray, array1);
  }

}
