package com.dtcc.projects;

import java.util.*;

public class PhoneBook {
    Map<String, List<String>> phoneBookMap;

    public PhoneBook(){
        this(new LinkedHashMap<String,List<String>>());
    }

    public PhoneBook(Map<String,List<String>> map){
        this.phoneBookMap=map;
    }

    public void add(String name,String phoneNumber){
        List<String> phoneNumberList=phoneBookMap.get(name);
       if(phoneNumberList!=null){
           phoneNumberList.add(phoneNumber);
       }
       else{
           phoneBookMap.put(name,Collections.singletonList(phoneNumber));
       }
    }

    public void addAll(String name, String[] pnumbers){
        if(!phoneBookMap.containsKey(name)) {
            phoneBookMap.put(name,Arrays.asList(pnumbers));
        }
    }

    public void remove(String name){
        if(phoneBookMap.containsKey(name))
            phoneBookMap.remove(name);
    }

    public boolean hasEntry(String name){
        return phoneBookMap.containsKey(name);
    }

    public List<String> lookup(String name){
      /*  List<String> sendList=new ArrayList<>();
        for(Map.Entry<String,List<String>> e: phoneBookMap.entrySet()){
            if(e.getKey().equalsIgnoreCase(name)){
                sendList= e.getValue();
            }
        }*/
        return phoneBookMap.get(name);
    }

    public String reverseLookup(String phoneNumber){
        String strName="";
        for(Map.Entry<String,List<String>> e: phoneBookMap.entrySet()) {
            if(e.getValue().contains(phoneNumber)){
                strName=e.getKey();
            }
        }
        return strName;
    }

    public List<String> getAllContactNames(){
        List<String> keyList=new ArrayList<>();
        if(phoneBookMap!=null){
            for(String s : phoneBookMap.keySet()){
                keyList.add(s);
            }
        }
          return keyList;
    }

}
