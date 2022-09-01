import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.io.EOFException;         
import java.io.ObjectInputStream;

public class fileMatch {
   
   private static ObjectOutputStream newMast;
   private static ObjectInputStream oldMas, TransRec;
      
  
  
   
   public fileMatch(){
      openFile();
      Match();
      closeFile();
   }
   
   public static void openFile(){
      try // open file
      {
         oldMas = new ObjectInputStream(          
            Files.newInputStream(Paths.get("oldmast.ser")));
       
         TransRec = new ObjectInputStream(          
            Files.newInputStream(Paths.get("trans.ser")));
       
         newMast = new ObjectOutputStream(
               new FileOutputStream("newMast.ser"));
  
      } 
      catch (IOException ioException)
      {
         System.err.println("Error gathering files.");
         System.exit(1);
      } 
   }
   
   public static void Match(){
      try{   
         while (true) // loop until there is an EOFException
         {
            Account record = (Account) oldMas.readObject();

            
         
            try{  
               while(true){   
                  Transaction tRecord = (Transaction) TransRec.readObject();
            
                  if(record.getAccount() == tRecord.getaccount()){
                     record.setBalance(record.getBalance() + tRecord.getbalance());
                  }  
              }
           }   
           catch(EOFException endOfFileException){
               newMast.writeObject(record);
            }
         
         }
      }
      catch (EOFException endOfFileException)
      {
         System.out.printf("%nEnd of Matching%n");
      }  

   }
  
  public static void closeFile(){
     try 
      {
         if (TransRec != null)
               TransRec.close();

         if (oldMas != null)
               oldMas.close();
         if (newMast != null)
               newMast.close();
      } 
      catch (IOException ioException)
      {
         System.err.println("Error closing file. Terminating.");
      } 
  
  }

}