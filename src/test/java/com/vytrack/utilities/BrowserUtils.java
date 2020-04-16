package com.vytrack.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    public static List<String> getElementsText(List<WebElement> webElementList){

        List<String> stringList = new ArrayList<>();
        for(WebElement element : webElementList){
            stringList.add(element.getText());
        }

        return stringList;
    }
}
