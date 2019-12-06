package com.bridgelabz.addressbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddressBookManagement
{
    public Object createAddressBook(String fileName) throws Exception {
        String filePath="/home/admin165/Desktop/Priya/AddressBook/src/main/resources/"+fileName+".json";
        File file=new File(filePath);

                if (file.createNewFile()) {
                    FileWriter fileWrite = new FileWriter(fileName);
                    String obj = "[]";
                    fileWrite.write(obj);
                    fileWrite.close();
                    return 1;
                }
                 else {
                    throw new Exception("AddressBook already exit");
                }
            }


    public Object openAddressBook(String fileName) throws Exception {
      String filePath="/home/admin165/Desktop/Priya/AddressBook/src/main/resources/"+fileName+".json";
      File folderPath= new File("/home/admin165/Desktop/Priya/AddressBook/src/main/resources");
      try{
      File[] fileList=folderPath.listFiles();
      boolean isFound=true;
      for(int i=0;i<fileList.length;i++){
          if(fileList[i].isFile()){
              if (fileList[i].compareTo(new File(filePath))==0) {
                  isFound = true;
              }
          }
      }
        if (isFound) {
            AddressBook obj = new AddressBook();
            obj.readPersonData(filePath);
            return 1;
        } else {
            throw new Exception("given name addressbook does not exist");
        }

    } catch (Exception e) {
        return e;
      }
    }
}


