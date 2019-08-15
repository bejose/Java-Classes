    
/**
 * Class that represent a Doubly Linked List 
 * using the two parameters to move the nodes
 * foward and backward according to the necessity.
 *
 * @author (Jose Bezerra)
 * @version (09/06/2019)
 */

import java.util.Scanner;

public class IntListTwo
{
    Scanner scan = new Scanner(System.in);
    private IntNodeTwo _head, _tail;

    /**
     * Constructor for objects of class IntListTwo
     */

    public IntListTwo()
    {
        _head = null;
        _tail = null;
    }

    /**
     * Constructor for objects of class IntListTwo
     * @param h an IntNodeTwo object representing the head
     * @param t an IntNodeTwo object representing the tail
     */

    public IntListTwo(IntNodeTwo h, IntNodeTwo t)
    {
        _head = h;
        _tail = t;
    }

    /**
     * Adds a node to the linked list in the appropriate place
     * @param num the number to create a node from and add to the list
     */
    public void addNumber(int num)
    {
        // empty list
        if (_head == null)
        {
            _head = new IntNodeTwo(num);
            _tail = _head;
        }
        // insert before first node
        else if (num <= _head.getNum())
        {                                         // next, prev
            IntNodeTwo newNum = new IntNodeTwo(num, _head, null);
            _head.setPrev(newNum);
            _head = newNum; // pointer _head points to the new added number
        }
        // insert after last node
        else if (num >= _tail.getNum())
        {                                        // next, prev
            IntNodeTwo newNum = new IntNodeTwo(num, null, _tail);
            _tail.setNext(newNum);
            _tail = newNum; // pointer _tail points to the new added number
        }
        // insert in the middle
        else
        {
            for(IntNodeTwo temp = _head; temp != null; temp = temp.getNext())
            {
                if (temp.getNum() < num) 
                {
                    continue;
                }
                
                IntNodeTwo newNum = new IntNodeTwo(num, temp, temp.getPrev());
                temp.getPrev().setNext(newNum);
                temp.setPrev(newNum);
            }
        }

    }

    /**
     * Removes a node from the linked list if the number exists
     * @param num the number to delete from the list
     */
    public void removeNumber(int num)
    {
        if(_head != null)
        {
            for(IntNodeTwo temp = _head; temp != null; temp = temp.getNext())
            {
                // only one node
                if (_head == _tail)
                {
                    _head = null;
                    _tail = null;
                    break;
                }
                // more than one node
                else if (temp.getNum() == num)
                {
                    // is the first node
                    if (temp == _head)
                    {
                        _head = temp.getNext();
                        _head.setPrev(null);
                        break;
                    }
                    // is the last node
                    else if (temp == _tail)
                    {
                        _tail = temp.getPrev();
                        _tail.setNext(null);
                        break;
                    }
                    // is in the middle
                    else 
                    {
                        temp.getPrev().setNext(temp.getNext());
                        temp.getNext().setPrev(temp.getPrev());
                        break;
                    }
                }
            }
        }
    }

    /**
     * Adds to the list allnumbers under given num
     * @param num the limit to add to the list
     */
    public void readToList()
    {
        int num = scan.nextInt();

        for (int counter = 0; counter < num && counter < 9999; counter++)
        {
            addNumber(counter);
        }
    }

    /**
     * Returns the list in order(head to tail)
     * @return a string containing the list
     */
    public String toString()
    {
        String list = "{";

        for(IntNodeTwo temp = _head; temp != null; temp = temp.getNext())
        {
            list = list + temp.getNum();
            if (temp.getNext() != null)
            {
                list = list + ", ";
            }
        }
        
        return list + "}";
    }

    /**
     * Returns the length of the list
     * @return a number containing the length of the list
     */

    public int length()
    {
        int counter = 0;
        
        for(IntNodeTwo temp = _head; temp != null; temp = temp.getNext())
        {
            counter++;
        }

        return counter;
    }

    /**
     * Returns the sum of the list values
     * @return a number containing the sum of the list values
     */
    public int sum()
    {
        int sum = 0;
        
        for(IntNodeTwo temp = _head; temp != null; temp = temp.getNext())
        {
            sum += temp.getNum();
        }
        
        return sum;
    }

    /**
     * Returns the length of the longest sub list that its values sum is even
     * @return a number containing the length of the longest sub list that its values sum is even
     */

    public int maxLength()
    {
        int subListLength = 0;
        int evenSum = 0;
        
        for(IntNodeTwo temp = _head; temp != null; temp = temp.getNext())
        {
            int tempSum = evenSum + temp.getNum();
            if (tempSum % 2 == 0) {
                evenSum = tempSum;
                subListLength++;
            }
        }
        
        return subListLength;
    }

    /**
     * Returns if there is a sub list whos average is the given number
     * @param num a number to check if there is an average of a sub array equal to it
     * @return true if there is a sub array whos average is num
     */
    public boolean isAverage(double num)
    {
        IntNodeTwo start = _head;
        int length = 0;
        int sum = 0;
        double average = 0.0;
        
        for(IntNodeTwo temp = start; temp != null; temp = temp.getNext())
        {
            length++;
            sum += temp.getNum();
            average = sum / length;
            
            // found
            if (average == num) {
                return true;
            }
            
            // if get to the end
            if (temp.getNext() == null) {
                // if starting from the end, break the loop
                if (start == temp) {
                    break;
                }
                // start again from the second node
                else {
                    start = start.getNext();
                    temp = start;
                    length = 0;
                    sum = 0;
                    average = 0.0;
                }
            }
        }
        // not found
        return false;
    }
}