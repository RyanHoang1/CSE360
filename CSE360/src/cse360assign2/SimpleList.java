package cse360assign2;

/**
 * This program is a simple list program. It includes a method to add elements to the list, remove elements
 * from the list, return the amount of elements in the list, return the list as a string, and return the
 * index of a searched element
 * 
 * @author Ryan Hoang
 * Class ID: 224
 * ASU ID: 1214632640
 * Class/Session: CSE 360, Monday
 *
 */

public class SimpleList 
{
	int arraySize;
	int[] list;
	int count;
	
	/**
	 * constructor creates a list of size 10 and sets count to 0
	 */
	SimpleList() 
	{
		arraySize = 10;
		list = new int[arraySize];
		count = 0;
	}
	
	/**
	 * add method will add the parameter to the first index of the list. The rest of the list will shift to the right and the element
	 * at the last index will be removed. count will also be updated. If the list is full, then the list will increase in size by 50%.
	 * @param element to be added to list
	 */
	public void add(int addElement) 
	{
		if(count == list.length) 
		{
			arraySize = (int)(arraySize * 1.5);
			int[] tempArray = new int[arraySize];
			for(int listIterator = 0; listIterator < count; listIterator++) 
			{
				tempArray[listIterator] = list[listIterator];
			}
			list = tempArray;
		}
		for(int listIterator = arraySize - 1; listIterator > 0; listIterator--) 
		{
			list[listIterator] = list[listIterator - 1];
		}
		list[0] = addElement;
		count++;
	}
	
	/**
	 * remove method will remove the parameter from the list. The elements to the right of the index of the parameter will shift 
	 * to the left. the count will be updated. If the list has more than 25% empty spaces, then the list will be decreased by 
	 * 25% of its size.
	 * @param element to be removed from list
	 */
	public void remove(int removeElement) 
	{
		for(int listIterator = 0; listIterator < arraySize; listIterator++) 
		{
			if(list[listIterator] == removeElement) 
			{
				for(int adjust = listIterator; adjust < arraySize; adjust++) 
				{
					if(adjust == arraySize - 1) 
					{
						list[adjust] = 0;
					}
					else 
					{
						list[adjust] = list[adjust + 1];
					}
				}
				count--;
			}
		}
		if(count < (int)(arraySize * .75) && count >= 1) 
		{
			arraySize = (int)(arraySize * .75);
			int[] tempArray = new int[arraySize];
			for(int listIterator = 0; listIterator < count; listIterator++) 
			{
				tempArray[listIterator] = list[listIterator];
			}
			list = tempArray;
		}
	}
	
	/**
	 * count method returns the count of the number of elements inside the list.
	 * @return returns count
	 */
	public int count() 
	{
		return count;
	}
	
	/**
	 * toString method returns the elements of the list in a string with spaces
	 * @return returns list
	 */
	public String toString() 
	{
		String result = "";
		for(int listIterator = 0; listIterator < count; listIterator++) 
		{
			if(listIterator == count - 1) 
			{
				result += list[listIterator];
			}
			else 
			{
				result += list[listIterator] + " ";
			}
		}
		return result;
	}
	
	/**
	 * search method will return the index of the parameter element. If parameter element does
	 * not exist within the list, then -1 will be returned instead.
	 * @param element to be searched
	 * @return returns index of searched element
	 */
	public int search(int searchElement) 
	{
		int result = -1;
		for(int index = 0; index < arraySize; index++) 
		{
			if(list[index] == searchElement) 
			{
				result = index;
			}
		}
		return result;
	}
	
	/**
	 * appends the parameter to the end of the list. If the list is full, then the list if increased in size
	 * by 50%. Update count
	 * @param element to be appended to end of list
	 */
	public void append(int appendElement) 
	{
		if(count == list.length) 
		{
			arraySize = (int)(arraySize * 1.5);
			int[] tempArray = new int[arraySize];
			for(int listIterator = 0; listIterator < count; listIterator++) 
			{
				tempArray[listIterator] = list[listIterator];
			}
			list = tempArray;
		}
		list[arraySize - 1] = appendElement;
		count++;
	}
	
	/**
	 * Returns the first element in the list. Returns -1 if list is empty
	 * @return returns the first element in the list
	 */
	public int first() 
	{
		int result = -1;
		if(count != 0) 
		{
			result = list[0];
		}
		return result;
	}
	
	/**
	 * Returns the last element in the list. Returns -1 if list is empty
	 * @return returns the last element in the list
	 */
	public int last() 
	{
		int result = -1;
		if(count != 0) 
		{
			result = list[count - 1];
		}
		return result;
	}
	
	/**
	 * Returns the size of all possible locations in the list
	 */
	public int size() {
		return arraySize;
	}
}
