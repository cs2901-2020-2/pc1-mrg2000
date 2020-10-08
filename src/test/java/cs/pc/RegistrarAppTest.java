package cs.pc;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;
import java.util.Hashtable;
import java.util.logging.Logger;


class RegistrarAppTest {
    static final Logger logger = Logger.getLogger(RegistrarAppTest.class.getName());

    @Test (invocationCount = 100, threadPoolSize = 100)
    public void testCase0(){
        generic(0);
    }

    @Test
    public void testCase2(){
        long begginTime = System.currentTimeMillis();
        long maxExecutionTime = 500;
        generic(1);
        long finalTime = System.currentTimeMillis();
        long executionTime = finalTime - begginTime;
        logger.info(String.valueOf(executionTime));
        Assert.assertTrue(executionTime < maxExecutionTime);
    }
    
    private void generic(int i){
        List<String> lines = readFile(i, "input");
        Boolean expectedValue = Boolean.parseBoolean(readOutput(i));
        String description = lines.get(0);  
        String link = lines.get(1);  
        
        RegistrApp app = new RegistrApp();
        Boolean descriptionVerify = app.validateDescription(description);
        Boolean linkVerify = app.validateLink(link);
        Assert.assertEquals(descriptionVerify, expectedValue);
        Assert.assertEquals(linkVerify, expectedValue);
    }

    private String readInput(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        return lines.get(0);
    }

    private String readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines.get(0);
    }

    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }
    
};