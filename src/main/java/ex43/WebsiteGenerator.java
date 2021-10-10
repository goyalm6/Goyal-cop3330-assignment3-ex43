/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution, Exercise 43
 *  Copyright 2021 Mayank Goyal
 */

package ex43;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class WebsiteGenerator {

    public static void main(String[] args) throws IOException {
        CreateSiteStructure site = new CreateSiteStructure();
        site.js = 'N';
        site.css = 'N';
        // create a scanner object that takes input from user
        Scanner SC = new Scanner(System.in);

        // ask user for website name
        System.out.print("Site name: ");
        site.websiteName = SC.nextLine();

        // ask user for author name
        System.out.print("Author: ");
        site.author = SC.nextLine();

        // ask if user want JavaScript folder or not
        System.out.print("Do you want a folder for JavaScript? ");
        site.js = SC.next().charAt(0);

        // ask if user want CSS folder or not
        System.out.print("Do you want a folder for CSS? ");
        site.css = SC.next().charAt(0);

        HashMap<String, Boolean> res = site.create();
        String currentDirectory = res.keySet().iterator().next();
        Boolean isSiteCreated = res.get(currentDirectory);

        if(isSiteCreated)
        {
            System.out.println("Created " + currentDirectory);
            try
            {
                // if website directory does not exist then it will create the directory and
                // if it exists then create its sub folders and files
                site.createIndexPage(currentDirectory);
                createJs(site, currentDirectory);
                createCss(site, currentDirectory);
            }
            catch(IOException e)
            {
                // handle the exception if raised by the FileWriter
                System.out.println("index.html not created as required!!");
            }
        }
        else
        {
            // if website already exist or cannot be created then print not created message
            System.out.println("Website folder not created!!");
        }
        // close Scanner object
        SC.close();
    }

    private static void createJs(CreateSiteStructure site, String currentDirectory) {
        Boolean isJsCreated = site.createJsDirectory(currentDirectory);
        if(isJsCreated)
        {
            File jsFolder = new File(currentDirectory +"\\js");
            // if JS directory created then print the message
            System.out.println("Created " + jsFolder+"\\");
        }
        else
        {
            // else print not created message
            System.out.println("Js folder not created!!");
        }
    }

    private static void createCss(CreateSiteStructure site, String currentDirectory)
    {
        Boolean isCssCreated = site.createCssDirectory(currentDirectory);
        if(isCssCreated)
        {
            // if CSS directory created then print message
            File cssFolder = new File(currentDirectory +"\\css");
            System.out.println("Created " + cssFolder+"\\");
        }
        else
        {
            // else print not created message
            System.out.println("CSS folder not created!!");
        }
    }
}