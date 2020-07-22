
package edu.pdx.cs410J.dp6;

        import org.junit.Test;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.util.stream.Collectors;


        import static org.junit.Assert.assertEquals;
        import static org.junit.Assert.assertTrue;
        import edu.pdx.cs410J.InvokeMainTestCase;

        import static org.hamcrest.CoreMatchers.*;
        import static org.hamcrest.MatcherAssert.assertThat;

/**
 * A unit test for code in the <code>Project2</code> class.  This is different
 * from <code>Project1IT</code> which is an integration test (and can handle the calls
 * to {@link System#exit(int)} and the like.
 */
public class Project2Test extends InvokeMainTestCase {
    /**
     *
     * @throws IOException
     */
    @Test
    public void readmeCanBeReadAsResource() throws IOException {
        try (
                InputStream readme = Project2.class.getResourceAsStream("README.txt")
        ) {
            assertThat(readme, not(nullValue()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(readme));
            String line = reader.readLine();
            assertThat(line, containsString("This program is a phonebill application which takes 5 arguments"));
        }
    }




    /**
     *
     * @param args
     * @return main method results
     */
    private MainMethodResult invokeMain(String... args)
    {
        return invokeMain(Project2.class, args);
    }


    @Test
    public void NoCommandLineArgs(){
        MainMethodResult result = invokeMain();
        assertThat(result.getExitCode(),equalTo(3));
        assertThat(result.getTextWrittenToStandardOut(),equalTo("No command line arguments"));
    }
    @Test
    public void TestTextDumper() {
        MainMethodResult result = invokeMain( "-textFile", "PhoneBillText", "david", "410-709-4866", "410-880-6960", "10/15/2019", "09:20", "10/15/2019", "09:55");
        System.out.println(result.getTextWrittenToStandardOut());
    }

    @Test
    public void TestTextParser(){
        MainMethodResult result = invokeMain("-textFile", "PhoneBillText");
         System.out.println(result.getTextWrittenToStandardOut());
    }

    @Test
    public void TestFromGrader(){
        System.out.println("NOW!");
        MainMethodResult result = invokeMain("-print", "Test8", "123-456-7890", "234-567-8901", "03/03/2015", "12:00", "05/04/2015", "16:00");
        System.out.println(result.getTextWrittenToStandardOut());
    }


    @Test
    public void TestPrintNoDataNoOtherArgs() {
        MainMethodResult result = invokeMain("-print");
        assertEquals(new Integer(3), result.getExitCode());
        assertThat(result.getTextWrittenToStandardOut(),equalTo("Missing command line arguments"));
    }
    /**
     * tests the regular command line input `
     */
    @Test
    public void testRegularCommandLineArguments(){
        MainMethodResult result = invokeMain("-print","david", "422-345-6579", "410-333-3456", "10/16/2019", "09:38", "10/16/2019", "09:42");
        assertThat(result.getExitCode(), equalTo(0));
        assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 422-345-6579 to 410-333-3456 from 10/16/2019 09:38 to 10/16/2019 09:42"));
    }



}
