public class GenericMethods {
   
  /*********************************************************************
   * findMin uses an enhanced for loop and steps through the array to 
   * find the min value.
   ********************************************************************/  
  public static <T extends Comparable<T>> int findMin(T[] arr) {
    
    T min = arr[0];
    int index = 0;
 
    for (T new_arr : arr){
      if(min.compareTo(new_arr) == -1){
        index++;
      }
    }  
    return index;
  }
  
  
  /*********************************************************************
   * findMinRecursive contains a private method called findMinR which
   * recursively find the minimum value in an array.
   ********************************************************************/
  public static <T extends Comparable<T>> int findMinRecursive(T[] arr) {
    
    int a = 0;
    int b = a + 1;
    
    
    a = findMinR(arr, a, b);
    
    return a; // replace this
  }
  
    private static <T extends Comparable<T>> int findMinR(T[] arr, int a, int b){
      if(b < arr.length){  
        if(arr[a].compareTo(arr[b]) == -1){
          b++;
        }        
        else{
          a = b;
          b++;
        }
        findMinR(arr, a , b);
      } 
      return a;
  }
  
  
  /*********************************************************************
   * foo is the low value and bar is the high value. If the test is 
   * less that the value we are looking for foo is moved up. If the 
   * test is greater than the value then bar is moved down. If test 
   * equals the value then test is returned. When the value isn't found
   * the method is recalled with the updated foo/bar values. 
   ********************************************************************/
  public static <T extends Comparable<T>> int binarySearch(T[] arr, T x) {
    
    //low
    int foo = 0;
    //high
    int bar = arr.length -1;  
    
    
    return binaryR(arr, x, foo, bar);
  }
  
  
  
  private static <T extends Comparable<T>> int binaryR(T[] arr, T x,int foo, int bar){
    

    int test = (foo + bar) / 2;
    //Tests to make sure the low value doesn't pass the high. Preventing an infinite 
    //recursive call in the case that the value we search for doesn't exist.
    if(foo < bar){
      
      //if the test case is less than x then it will search the right half of the array.
      if(arr[test].compareTo(x) == -1){
        foo = test + 1;

      }

      //if the test case is greater than x then it will search the left half of the array.
      else if(arr[test].compareTo(x) == 1){
        bar = test - 1;

      }
      else        
        //when the value is found the current test value is returned.
        return test;
            
      //Recursive call
      test = binaryR(arr, x, foo, bar);      
    }
    else 
      test = -1;

    //return test
    return test;

  }
  
}







































