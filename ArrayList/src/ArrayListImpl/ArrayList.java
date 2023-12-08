package ArrayListImpl;

public interface ArrayList<T> {

	public void add(T element);
	public void remove(int index);
	public int size();
	public T get(int index);
	public void set(int index, T element);
}
