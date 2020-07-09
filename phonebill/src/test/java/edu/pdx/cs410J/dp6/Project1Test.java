package edu.pdx.cs410J.dp6;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import static org.junit.Assert.assertTrue;
import edu.pdx.cs410J.InvokeMainTestCase;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * A unit test for code in the <code>Project1</code> class.  This is different
 * from <code>Project1IT</code> which is an integration test (and can handle the calls
 * to {@link System#exit(int)} and the like.
 */
public class Project1Test extends InvokeMainTestCase{
  /**
   *
   * @throws IOException
   */
  @Test
  public void readmeCanBeReadAsResource() throws IOException {
    try (
      InputStream readme = Project1.class.getResourceAsStream("README.txt")
    ) {
      assertThat(readme, not(nullValue()));
      BufferedReader reader = new BufferedReader(new InputStreamReader(readme));
      String line = reader.readLine();
      assertThat(line, containsString("This is a README file!"));
    }
  }

  /**
   *
   * @param args
   * @return main method results
   */
  private MainMethodResult invokeMain(String... args)
  {
    return invokeMain(Project1.class, args);
  }

  /**
   * tests the regular command line input `
   */
  @Test
  public void testRegularCommandLineArguments(){
    MainMethodResult result = invokeMain("david", "503-709-4866", "503-880-6960", "10/15/2015", "09:38", "10/15/2015", "09:42","-print");
    assertThat(result.getExitCode(), equalTo(0));
    assertThat(result.getTextWrittenToStandardOut(), containsString("Phone call from 503-709-4866 to 503-880-6960 from 10/15/2015 09:38 to 10/15/2015 09:42"));
  }



}
