# Mini-applications
ZOHO Console Mini Applications


1.ATM Application

Classes - ATM.java,UserBean.java

ATM.java -  is a main file where all operations are coded
UserBean.java - is class for template for user behaviour and attributes

Two logins - Admin,User

Admin :
   Login :
      Username - adminkpr
      Password - kpr@1234
      
   Admin Page
   1. Addmoney - Admin add the money in terms of denominations
   2. Showmoney - Admin can view the atm balance and denominations

User :
   Predefined users created already and those users can login
   
   User page
   1.Amount Withdrawal - Withdraw the amount
   2.Balance Check - Check the available balance
   3.Amount Deposit - Deposit the amount in account
   4.Transaction Details - Previous transaction history
   5.Pin change - User can change the pin
   6.Mini Statement - User can view last three transactions
   7.Transfer amount - User can transfer amount to another user
       
       
    
2.Amazon Application

Classes - Main.java,Vendor.java,User.java,Order.java,Product.java

Main.java - is a main file where all operations are coded
Vendor.java - is class for template for Vendor(Merchant) behaviour and attributes
User.java - is class for template for User behaviour and attributes
Product.java - is class for template for Product details
Order.java - is class for template for Order details

Login - Admin,User,Vendor

Admin :
   Username - kpradmin
   Password - admin@123
   
   Admin Page :
        1.Vendor Appoval - Admin approve the vendor invitations
        2.Add Vendor - Admin add the vendor
        3.Remove Vendor - Remove the vendor
        4.View Vendor - View all the vendors
      
Vendor :
    1.New Vendor - Register through name,Password 
    !!!Alert - After registeration Vendor should note the Vendor Id, this id used for future login purpose
   
    2.Existing Vendor - Login through name,password,vendor id
    
    Vendor Page :
         1.Add Product - Vendor Add a product
         2.Remove Product - Vendor removed a product
         3.Review Product - Products review
         4.Edit Product - Product edit
         5.View products of other vendors - Other vendor projects
         6.Frequent customer - Vendor view frequent customer
         7.Most Saled Product - Vend view most saled product
         8.Sales Report - Vendor view product sales report
         
User :
    1.New user - Register through name,Password 
    !!!Alert - After registeration user should note the user Id, this id used for future login purpose
   
    2.Existing user - Login through name,password,user id
    
     User Page :
           1.Cart - User can view and edit cart
           2.Order - Order a product and after order note the purchase id for future access purpose
           3.Order History - Previous order history
           4.Wallet - User can view and edit the wallet
           5.Password change - Change the password
      
3.Train Booking Application
        
    Classes - Main.java,Usert.java,Booktr.java

Main.java - is a main file where all operations are coded
Usert.java - is a template for user behaviours and attributes
Booktr.java - is a template for Bookings


Login - Admin,User

Admin :
   Username - kpradmin
   Password - admin@123
   
   Admin Page :
      1.Available tickets - admin can view the available tickets
      2.Booked tickets - admin can view booked tickets
      3.Confirmed tickets - admin can confirmed tickets
      4.Add train - admin can add train
      
 User :
    1.New user - Register through name,Password 
    !!!Alert - After registeration user should note the user Id, this id used for future access purpose
   
    2.Existing user - Login through name,password,user id
    
     User Page :
         1.Book ticket - User book a ticket and user should note the bookid for future access purpose
         2.Ticket status - User can view ticket status
         3.Cancel ticket - User can cancel the ticket 
         
         
