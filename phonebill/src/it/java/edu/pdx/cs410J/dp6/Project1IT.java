package edu.pdx.cs410J.dp6;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests the functionality in the {@link Project1} main class.
 */
public class Project1IT extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link Project1} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain( Project1.class, args );
    }

  /**
   * Tests that invoking the main method with no arguments issues an error
   */
  @Test
  public void testNoCommandLineArguments() {

    MainMethodResult result = invokeMain();
    assertThat(result.getExitCode(), equalTo(3));
    assertThat(result.getTextWrittenToStandardOut(), containsString("No command line arguments"));
  }

    /**
     * Tests that invoking the main method with no arguments issues an error
     */
    @Test
    public void testMissingCommandLineArguments() {

        MainMethodResult result = invokeMain("Marley", "410-222-3333","420-230-3344","05/02/2020","05/02/2020","12:33","-print");
        assertThat(result.getExitCode(), equalTo(3));
        assertThat(result.getTextWrittenToStandardOut(), containsString("Missing command line arguments"));
    }

    /**
     * Tests that the -README command will cause the exit code of 2
     */
    @Test
    public void testReadmeCommand() {
        MainMethodResult result = invokeMain(Project1.class, "-README");
        assertThat(result.getExitCode(), equalTo(3));
    }

    /**
     * tests the format of the date input from command line
     */
    @Test
    public void wrongdateformat() {
        MainMethodResult result = invokeMain(Project1.class,"Marley", "410-222-3333","420-230-3344","5022020","12:10","05/02/2020","12:33","-print");
        assertThat(result.getTextWrittenToStandardOut(), containsString("Date format must follow mm/dd/yyyy"));
    }

    /**
     * test the format of the time input from the command line using assertthat and containsString
     */
    @Test
    public void wrongtimeformat() {
        MainMethodResult result = invokeMain(Project1.class,"Marley", "410-222-3333","420-230-3344","05/02/2020","123","05/02/2020","12:33","-print");
        assertThat(result.getTextWrittenToStandardOut(), containsString("Time format must be mm:hh (24 hour time)"));
    }




}