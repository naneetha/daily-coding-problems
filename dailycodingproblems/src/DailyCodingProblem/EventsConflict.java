package DailyCodingProblem;
import java.text.SimpleDateFormat;
import java.util.Date;
class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
         try{
          Date d1e1 = sdf.parse(event1[0]);
          Date d2e1 = sdf.parse(event1[1]);
          Date d1e2 = sdf.parse(event2[0]);
          Date d2e2 = sdf.parse(event2[1]);
          System.out.println(d1e2.before(d2e1) +"  "+ d1e2.equals(d2e1));
         if(  ((d1e2.after(d1e1)||d1e2.equals(d1e1) ) || (d1e2.before(d2e1))|| d1e2.equals(d2e1))
            && ((d2e2.after(d1e1)||d2e2.equals(d1e1)) || (d2e2.before(d2e1) || d2e2.equals(d2e1))))
         {
             return true;
         }
         }  
        catch(Exception e)
        {
            e.printStackTrace();
        }
         
        return false;
    }
}
