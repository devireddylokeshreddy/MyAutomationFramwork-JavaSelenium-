package JavaBasic;

import Utilities.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.stream.Collectors;

public class StringProblems {
    WebDriver driver = DriverManager.getInstance().getDriver();
    @Test
    public void reverseAStringWithUsingTempVaraible() {
        String s = "internship at geeks for geeks";
        String temp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            temp += s.charAt(i);
        }
        System.out.println(temp);
    }

    @Test
    public void reverseAStringWithOutUsingTempVaraible() {
        String s = "lokesh";
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        System.out.println(str);
    }

    @Test
    public void reverseAStringWithOutUsingTempVaraibleAndStringBuilder() {
        String s = "lokesh";
        char[] c = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            c[start] ^= c[end];
            c[end] ^= c[start];
            c[start] ^= c[end];
            ++start;
            --end;
        }
        System.out.println(String.valueOf(c));
    }

    @Test
    public void reverseAStringPreservingSpaces() {
        String s = "internship at geeks for geeks";
        char[] c = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (c[start] == ' ') {
                start++;
            } else if (c[end] == ' ') {
                end--;
            } else {
//                char temp = c[start];
//                c[start] = c[end];
//                c[end] = temp;
//                start++;
//                end--;
                c[start] ^= c[end];
                c[end] ^= c[start];
                c[start] ^= c[end];
                start++;
                end--;
            }
        }
        System.out.println(String.valueOf(c));
    }

    @Test
    public void printDuplicateCharatersFromAString() throws IOException {
        String s = "malayalam";
        char[] c = s.toCharArray();
//        for (int i = 0; i < c.length-1; i++){
//            int count = 0;
//            for (int j = i+1; j < c.length; j++){
//                if(c[i] == c[j]){
//                    count++;
//                    c = ArrayUtils.remove(c, j);
//                }
//                if(count == 0){
//                    c = ArrayUtils.remove(c, i);
//                }
//            }
//        }
//        System.out.println(Arrays.toString(c));
        ArrayList<Character> charArray = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (c[i] == c[j]) {
                    count++;
                }
            }
            if (count > 1) {
                charArray.add(c[i]);
            }
        }
        List<Character> newList = charArray.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);
        driver.get("https://www.google.co.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement ele = driver.findElement(By.xpath("(//input[@aria-label='Google Search'])[2]"));
        File src = ele.getScreenshotAs(OutputType.FILE);
        File dest = new File("Screenshot.png");
        FileUtils.copyFile(src, dest);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.co.in/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.co.in/");
        driver.quit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        driver.getWindowHandle();
    }



}
