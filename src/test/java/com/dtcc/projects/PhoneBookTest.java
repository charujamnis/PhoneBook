package com.dtcc.projects;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class PhoneBookTest {

    PhoneBook phoneBook;
    @Before
    public void setup(){
        phoneBook=new PhoneBook();
    }

    @Test
    public void testAdd(){
        String name="Charu";
        String phoneNumber="123-123-1234";
        phoneBook.add(name,phoneNumber);
        Assert.assertTrue(phoneBook.phoneBookMap.containsKey(name));
        Assert.assertEquals(phoneNumber,phoneBook.phoneBookMap.get(name).get(0));
    }

    @Test
    public void tesAddAll(){
        String[] list= {"123-123-123","456-345-8934"};
        String name="Nitu";
        phoneBook.addAll(name,list);
        Assert.assertEquals(2,phoneBook.phoneBookMap.get(name).size());
        Assert.assertEquals(Arrays.asList(list),phoneBook.phoneBookMap.get(name));
    }

    @Test
    public void testRemoveKey(){
        String name="Sam";
        String phoneNumber="456-678-0987";
        phoneBook.add(name,phoneNumber);
        phoneBook.remove(name);
        Assert.assertEquals(false,phoneBook.phoneBookMap.containsKey(name));
    }

    @Test
    public void testHasEntry(){
        String[] list={"123-132-127","456-345-8934"};
        String name="Ramona";
        phoneBook.addAll(name,list);
        Assert.assertTrue(phoneBook.hasEntry(name));
    }

    @Test
    public void testLookup(){
        String[] list={"123-132-127","456-345-8934"};
        String name="Seher";
        phoneBook.addAll(name,list);
        List<String> nameList=phoneBook.lookup(name);
        Assert.assertEquals(Arrays.asList(list),nameList);
    }

    @Test
    public void testReverseLookup(){
        String actual="Rakhi";
        String phoneNumber="123-123-4564";
        phoneBook.add(actual,phoneNumber);
        String expected=phoneBook.reverseLookup(phoneNumber);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testGetAllContactNames(){
        Set<String> expectedSet=new HashSet<>();
        Set<String> actual=new HashSet<>();
        String name1="Seema";
        String phoneNumber="123-123-4564";

        String name2="Shreya";
        String[] strList={"123-132-127","456-345-8934"};

        actual.add(name1);
        actual.add(name2);

        phoneBook.add(name1,phoneNumber);
        phoneBook.addAll(name2,strList);
        expectedSet=phoneBook.getAllContactNames();
        Assert.assertEquals(actual,expectedSet);

    }

}
