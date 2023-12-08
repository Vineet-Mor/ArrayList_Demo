package ArrayListImpl;

/* This program offers a comprehensive exploration of ArrayList functions, 
    shedding light on the fundamental operations and the dynamic nature of 
    this data structure. It illuminates how an ArrayList dynamically adjusts
    its size as elements are added, providing insights into the seamless 
    management of data.
  
   Furthermore, this program exemplifies the principles of generic programming,
    making the code adaptable and reusable across diverse domains. By 
    implementing generics, it ensures flexibility and efficiency, enabling
    developers to apply the knowledge gained in various contexts.
    
    
    Implemented Methods:-
    ----------------------------------------------------------------
    To create object:
    1. ArrayListImpl<Object> variable=new ArrayList<>(array length);
    2. ArrayListImpl<Object> variable=new ArrayList<>();
    
    ----------------------------------------------------------------
    
    add(element)
    This method will allow user to add element at the last index of array.
    Return type: void
    
    ----------------------------------------------------------------
    
    remove(index)
    This method will allow the user to remove element at index passed as the argument to the method.
    This function will return the removed element.
    Return type: Object type
    ----------------------------------------------------------------
    
    size()
    This function will return the size of the array.
    The size here refers to the total elements present in the array.
    
    ----------------------------------------------------------------
    
    get(index)
    This function will allow the user to get the element present at index passed as the argument
    Return type: Object type
    
    ----------------------------------------------------------------
    
    set(index,element)
    This function will allow the user to set an element at index passed as the argument.
    Return type: void
    
    ----------------------------------------------------------------
    
    add(index,element)
    This function allows user to add an element at index and maintains the order of elements present in array 
    Return type: void
    
    -----------------------------------------------------------------
    
*/
public class ArrayListImpl<T> {            
	private Object[] arr;
	private int size;
	private int arrlength;

	//ArrayListImpl class Constructor that takes ArrayList length as input and define an array of given size
	 ArrayListImpl(int length) throws NegativeValueException{
		if(length<0) {
			throw new NegativeValueException("Array length can't be negative");
		}
		this.arr=new Object[length];
		this.size=0;
		arrlength=length;
	}
	
	 //ArrayListImpl class Constructor that has 10 predefined length of the ArrayList and define an array of the respective length
	 ArrayListImpl(){
			this.arr=new Object[10];
			this.size=0;
			arrlength=10;
		}
	
    //add(T) function takes an element of the defined T type and adds is to the end of the ArrayList
	public void add(T element) {
		if(this.size<this.arrlength) {
			arr[size]=element;
			this.size++;
		}
		else {
			arr=update();
			arr[size]=element;
			size++;
		}
	}
	
	

    //remove(int) function takes an index input and removes the element present at the index
	public T remove(int index)throws NegativeValueException, ArrayIndexOutOfBoundsException, EmptyArrayException {
		if(index<0) {
			throw new NegativeValueException("Value must be a positive number");
		}
		if(index>=size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if(size==0) {
			throw new EmptyArrayException("No values available to remove");
		}
		T retValue=(T)arr[index];
		arr[index]=arr[index+1];
		for(int i=index+1;i<size-1;i++) {
			arr[i]=arr[i+1];
		}
		arr[size-1]=null;
		size--;
		return retValue;
	}

	//size() method gives the size of the ArrayList i.e. number of elements present in the ArrayList
	public int size() {
		return this.size;
	}

	//get(int) method gives the element present at index passed as argument 
	public T get(int index) throws NegativeValueException, ArrayIndexOutOfBoundsException {
		if(index<0) {
			throw new NegativeValueException("Value must be a positive number");
		}
		if(index>=size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return (T)arr[index];
	}

    //set(int, T) method is the function of the ArrayList class that allows us to set the element of type T at passed index
	public void set(int index, T element)throws NegativeValueException, ArrayIndexOutOfBoundsException {
		if(index<0) {
			throw new NegativeValueException("Value must be a positive number");
		}
		if(index>=size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		arr[index]=element;
	}
	
	public void add(int index,T element) throws NegativeValueException {
		if(index<0) {
			throw new NegativeValueException("Value must be a positive number");
		}
		if(index>=size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if(this.size>=arrlength-1) {
			update();
		}
		if(index<size-1) {
			size++;
		for(int i=index;i<size;i++) {
			T temp=(T)arr[i];
			arr[i]=element;
			element=temp;
		}
		}
        else if(index==size-1) {
			add(element);
		}
	}
	
	/*This function plays a pivotal role within the program, and its significance lies in its access modifier, which restricts
	  its accessibility to within the class. It's this function that imbues the ArrayList with its dynamic nature, achieving 
	  this by systematically adjusting the array's length, expanding it by 1.5 times.
	  */
	private Object[] update() {
		arrlength=(int)(arrlength*1.5);
		Object[] newArr=new Object[arrlength];
		for(int i=0;i<size;i++) {
			newArr[i]=arr[i];
		}
		return newArr;
	}
	
	//toString method is common method for data structures to print the values of the data structure.
	public String toString() {
		String retString="";
		for(int i=0;i<size;i++) {
			retString+=arr[i].toString();
			retString+=" ";
		}
		return retString;
	}

}

/*
 * Defining NegativeValueException class that extends Exception class. The
 * object of this class is thrown when the value passes is less than 0.
 */
class NegativeValueException extends Exception {
	NegativeValueException(String msg){
		super(msg);
	}
	NegativeValueException(){
		
	}
}

/*
 * Defining EmptyArrayException class that extends Exception class. The
 * object of this class is thrown when user try to remove an element from
 * the array, but the array is empty.
 */
class EmptyArrayException extends Exception{
	EmptyArrayException(String msg){
		super(msg);
	}
	EmptyArrayException(){
		
	}
}