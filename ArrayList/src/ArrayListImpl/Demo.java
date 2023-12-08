package ArrayListImpl;

public class Demo {

	public static void main(String[] args)throws NegativeValueException,ArrayIndexOutOfBoundsException, EmptyArrayException  {
		// TODO Auto-generated method stub

		ArrayListImpl<String> arr=new ArrayListImpl<>();
		for(int i=0;i<16;i++) {
			Integer element=new Integer(i);
			arr.add(element.toString());	
		}
		arr.remove(15);
		System.out.println("Size: "+arr.size());
		System.out.println(arr);
		arr.set(4,"newValue");
		System.out.println(arr);
		System.out.println("Size: "+arr.size());
		arr.add(14,"addFunction");
		
		System.out.println(arr);
		System.out.println("Size: "+arr.size());
		System.out.println("Element removed: "+arr.remove(5));
		System.out.println(arr);
		System.out.println("Size: "+arr.size());
	
	}

}
