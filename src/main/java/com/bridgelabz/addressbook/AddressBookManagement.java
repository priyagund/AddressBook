package com.bridgelabz.addressbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddressBookManagement {
    public Object createAddressBook(String fileName) throws AddressBookException, IOException {
        String filePath = "/home/admin165/Desktop/Priya/AddressBook/src/main/resources/" + fileName + ".json";
        File file = new File(filePath);

        if (file.createNewFile()) {
            FileWriter fileWrite = new FileWriter(fileName);
            String obj = "[]";
            fileWrite.write(obj);
            fileWrite.close();
            return 1;
        } else {
            throw new AddressBookException(AddressBookException.ExceptionType.FILE_ALREADY_EXIST,"AddressBook already exit");
        }
    }


    public AddressBook openAddressBook(String fileName) throws AddressBookException, IOException {
        String filePath = "/home/admin165/Desktop/Priya/AddressBook/src/main/resources/"+fileName+".json";
        File folderPath = new File("/home/admin165/Desktop/Priya/AddressBook/src/main/resources");
            File[] fileList = folderPath.listFiles();
            boolean isFound = false;
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].isFile()) {
                    if (fileList[i].compareTo(new File(filePath)) == 0) {
                        isFound = true;
                        break;
                    }
                }
            }
            if (isFound) {
                AddressBook obj = new AddressBook();
                obj.readPersonData(fileName);
                return obj;
            } else {
                throw new AddressBookException(AddressBookException.ExceptionType.FILE_NOT_FOUND,"given name addressbook does not exist");
            }


    }


    public Object saveAddressBook(Object person) throws AddressBookException, IOException {
        if(person instanceof AddressBook){
           ((AddressBook) person).writeIntoJson(((AddressBook) person).getPersonList(),new File(((AddressBook) person).getFileName()));
                return 1;
        }
        else {
            throw new AddressBookException(AddressBookException.ExceptionType.FILE_NOT_FOUND,"Data not saved");
       }
        }


}






