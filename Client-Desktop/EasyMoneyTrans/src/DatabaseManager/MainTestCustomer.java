/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseManager;

import data.DataCustomer;
import java.util.Random;

/**
 *
 * @author User
 */
public class MainTestCustomer {
    
    public static void main(String[] args) throws Exception {
        CustomerDAO c = new CustomerDAO();
        long AccNo = 123456789L;
        
        
//        fetching customer information using AccNo
                
        DataCustomer cust = new DataCustomer(c.getCustomer(AccNo));
        
        System.out.println(cust.toString());
        
//        
//        
////        checking if there is a customer in given AccNo
//        
//        System.out.println(c.isCustomerExist(AccNo));
//        
////        checking for Login
//        
//        System.out.println(c.isLoginCorrect(AccNo, 2011));
//        System.out.println("");
//        
//        
////        adding a customer
//
//        addCustomer(cust,c);
//        
//       
//        //adding 'N' number of recirds
//        
//        for(int i=0;i<1;i++)
//        {
//            addCustomer(cust,c);
//        }
//        
//        
//        c.isCustomerExist(AccNo);
//        
//        
//    }
//    
//   static public Customer generateCustomer()
//    {
//        Random r = new Random();
//        Customer cust = new Customer();
//        
//        do{
//            cust.Key = r.nextInt(9999);
//        }while(cust.Key < 1000);
//        
//        cust.Address = "some address";
//        cust.Name = "new name";
//        
//        
//        
//        do{
//            cust.MobileNo =  r.nextLong() / 1000000000;
//        }while(cust.MobileNo < 6000000000L);
//        
//        
//        cust.Amount = r.nextFloat() * r.nextInt(2000);
//        
//       
//        return cust;
//        
//    }
//   
//   static public void addCustomer(Customer cust,CustomerDAO c) throws Exception
//   {
//        
//        cust = generateCustomer();
//        
//        cust =  c.addCustomer(cust);
//        
//       if(cust != null)
//       {
//           System.out.println(cust.toString());
//       }
//       else{
//           System.out.println("cant added");
//       }
   }
}
