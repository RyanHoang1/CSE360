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
	int[] list;
	int count;
	
	/**
	 * constructor creates a list of size 10 and sets count to 0
	 */
	SimpleList() 
	{
		list = new int[10];
		count = 0;
	}
	
	/**
	 * add method will add the parameter to the first index of the list. The rest of the list will shift to the right and the element
	 * at the last index will be removed. count will also be updated
	 */
	public void add(int addElement) 
	{
		for(int listIterator = 9; listIterator > 0; listIterator--) 
		{
			list[listIterator] = list[listIterator - 1];
		}
		list[0] = addElement;
		if(count < 10) 
		{
			count++;
		}
	}
	
	/**
	 * remove method will remove the parameter from the list. The elements to the right of the index of the parameter will shift 
	 * to the left. the count will be updated
	 */
	public void remove(int removeElement) 
	{
		for(int listIterator = 0; listIterator < 10; listIterator++) 
		{
			if(list[listIterator] == removeElement) 
			{
				for(int adjust = listIterator; adjust < 10; adjust++) 
				{
					if(adjust == 9) 
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
	}
	
	/**
	 * count method returns the count of the number of elements inside the list.
	 */
	public int count() 
	{
		return count;
	}
	
	/**
	 * toString method returns the elements of the list in a string with spaces
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
	 */
	public int search(int searchElement) 
	{
		int result = -1;
		for(int index = 0; index < 10; index++) 
		{
			if(list[index] == searchElement) 
			{
				result = index;
			}
		}
		return result;
	}
}
