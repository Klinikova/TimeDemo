/**
   Represents time in hours and minutes using
   the customary conventions.
*/

public class Time
{
   private int hours;         // Conventional hours
   private int minutes;       // Conventional minutes
   private boolean afternoon; // Flag for afternoon

   /**
      Constructs a customary time (12 hours, am or pm)
      from a military time ##:##
      @param militaryTime Time in the military
             format ##:##
   */

   public Time(String militaryTime)
   {
      // Check to make sure something was entered
      if (militaryTime == null)
      {
         System.out.println(militaryTime +
                            " is not a " +
                            "valid miliary time: militaryTime is null" );
      }
      // Check to make sure there are 5 characters
      else if (militaryTime.length() != 5) // CONDITION TO CHECK LENGTH OF STRING
      {
         System.out.println(militaryTime +
                            " is not a " +
                            "valid miliary time: militaryTime.length() != 5" );
      }
      else
      {
         // Check to make sure the colon is in
         // the correct spot
         char colon = militaryTime.charAt(2);
         char char1 = militaryTime.charAt(0);
         char char2 = militaryTime.charAt(1);
         char char4 = militaryTime.charAt(3);
         char char5 = militaryTime.charAt(4);
         
         String[] parts = militaryTime.split(":");
         String hoursString = parts[0]; 
         String minutesString = parts[1];
         
         this.hours = Integer.parseInt(hoursString);
         this.minutes = Integer.parseInt(minutesString);
        
         boolean isChar1Digit = Character.isDigit(char1);
         boolean isChar2Digit = Character.isDigit(char2);
         boolean isChar4Digit = Character.isDigit(char4);
         boolean isChar5Digit = Character.isDigit(char5);
         
         /**
         boolean isHoursNumeric = isNumeric(hoursString);
         boolean isMinutesNumeric = isNumeric(minutesString);
          else if (!isHoursNumeric && !isMinutesNumeric) // CONDITION TO CHECK FOR DIGIT)
         {
            System.out.println(militaryTime +
                               " is not a " +
                               "valid miliary time." );
         }
           
          **/ 
         
         if (colon != ':') //CONDITION TO CHECK COLON POSITION)
         {
            System.out.println(militaryTime +
                               " is not a " +
                               "valid miliary timecolon != ':'" );
         }
         // Check to make sure all other characters
         // are digits
         else if (!isChar1Digit) // CONDITION TO CHECK FOR DIGIT)
         {
            System.out.println(militaryTime +
                               " is not a " +
                               "valid miliary time !isChar1Digit");
         }
         else if (!isChar2Digit)// CONDITION TO CHECK FOR DIGIT)
         {
            System.out.println(militaryTime +
                               " is not a " +
                               "valid miliary time: !isChar2Digit" );
         }
         else if (!isChar4Digit)//CONDITION TO CHECK FOR DIGIT)
         {
            System.out.println(militaryTime +
                               " is not a " +
                               "valid miliary time." );
         }
         else if (!isChar5Digit)//CONDITION TO CHECK FOR DIGIT)
         {
            System.out.println(militaryTime +
                               " is not a " +
                               "valid miliary time." );
         }
         else
         {
            // SEPARATE THE STRING INTO THE HOURS
            // AND THE MINUTES, CONVERTING THEM TO
            // INTEGERS AND STORING INTO THE
            // INSTANCE VARIABLES

            // Validate hours and minutes are valid values
            if(hours > 23)
            {
               System.out.println(militaryTime +
                                  " is not a " +
                                  "valid miliary time." );
            }
            else if(minutes > 59)
            {
               System.out.println(militaryTime +
                                  " is not a " +
                                  "valid miliary time." );
            }
            // Convert military time to conventional time
            // for afternoon times
            else if (hours > 12)
            {
               hours = hours - 12;
               afternoon = true;
               System.out.println(this.toString());
            }
            // Account for midnight
            else if (hours == 0)
            {
               hours = 12;
               System.out.println(this.toString());
            }
            // Account for noon
            else if (hours == 12)
            {
               afternoon = true;
               System.out.println(this.toString());
            }
            // Morning times do not need converting
            else
            {
               System.out.println(this.toString());
            }
         }
      }
   }

   /**
      The toString method returns a conventional time.
      @return A conventional time with am or pm.
   */
   public String toString()
   {
      String am_pm;
      String zero = "";

      if (afternoon)
         am_pm = "PM";
      else
         am_pm = "AM";
      if (minutes < 10)
         zero = "0";

      return hours + ":" + zero + minutes + " " + am_pm;
   }
   
   public static boolean isNumeric(String str)
   {
       for (char c : str.toCharArray())
       {
           if (!Character.isDigit(c)) return false;
       }
       return true;
   }
   
}