
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution, Exercise 43
 *  Copyright 2021 Mayank Goyal
 */

package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class CreateSiteStructure {

    public String author;
    public String websiteName;
    public char js;
    public char css;

    public CreateSiteStructure(){}

    public HashMap<String, Boolean> create()
    {
        String currentDir;
        Boolean isWebsiteCreated = false;

        // get the current directory so we can make website directory inside the current directory
        currentDir = System.getProperty("user.dir");

        // appending website name to current directory
        currentDir += "\\"+ websiteName;

        // creating a file object with the currentDir
        File website = new File(currentDir);

        // making the directory/folder for entered siteName
        isWebsiteCreated = website.mkdir();

        HashMap<String, Boolean> res = new HashMap<String, Boolean>();
        res.put(currentDir, isWebsiteCreated);
        return res;
    }

    public Boolean createCssDirectory(String currentDir) {
        boolean cssCreated = false;
        // checking if the user wants to create CSS folder or not
        if(css == 'y' || css == 'Y')
        {
            //create a directory using mkdir() method of File class
            File cssFolder = new File(currentDir +"\\css");
            cssCreated = cssFolder.mkdir();
        }
        return cssCreated;
    }

    public Boolean createJsDirectory(String currentDir) {
        boolean jsCreated = false;
        // checking if the user wants to create a JS directory or not
        if(js == 'y' || js == 'Y')
        {
            //create a directory using mkdir() method of File class
            File jsFolder = new File(currentDir +"\\js");
            jsCreated = jsFolder.mkdir();
        }
        return jsCreated;
    }

    public void createIndexPage(String currentDir) throws IOException {
        // create FileWriter object, so we can write to index.html
        FileWriter siteSkeleton = new FileWriter(new File(currentDir + "\\index.html"));

        // append the html required html tags to the file
        siteSkeleton.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");

        siteSkeleton.write("\t<meta author=\""+ author +"\">\n");

        siteSkeleton.write("\t<title>"+ websiteName +"</title>\n");

        siteSkeleton.write("</head>\n<body>\n\n</body>\n</html>");

        // close FileWriter object
        siteSkeleton.close();

        // print the message for creating the index.html
        System.out.println("Created " + currentDir +"\\index.html");
    }
}