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
         
        

4.Library Management System

    Classes - Mainlibrary.java,User.java,Bok.java,Trans.java
    
 Mainlibrary.java - is a main file where all operations are coded
 User.java - is a template for user behaviours and attributes
 Bok.jav - is a template for book behaviours and attributes
 Trans.java - is a template for book orderings
    
 Login - Admin,User
 
 Admin :
   Username - kpradmin
   Password - admin@123
   
   
   Admin Page :
          1.Add a book - admin can add book and note bookid for future access purpose
          2.Modify book - admin can modify book
          3.Delete book - admin can delete book
          4.Add user - admin can add book
          5.Review books - admin can review books
          6.Manage fine - Fine management
          7.Reports - All reports
          
 User :
      1.New user - Register through name,Password 
      !!!Alert - After registeration user should note the user Id, this id used for future access purpose
  
  
       User Page :
             1.Purchase books - user can purchase books
             2.View cart and edit cart - cart review
             3.Wallet - user can view and edit wallet
             4.Report - user orders and transactions
             
             
5.Splitwise Application

  Classes -  Main.java,Trans.java,Use.java
  
  Main.java - is a main file where all operations are coded
  Trans.java - is a template for all transactions
  Use.java - is a template for user behaviour and attributes
  
 Login - User
 
 User :
      1.New user - Register through name,Password 
      !!!Alert - After registeration user should note the user Id, this id used for future access purpose
  
  
      User Page :
              1.Send amount payment request to all - user can send payment request to others
              2.Check for payment request - user can check payment requests
              3.Wallet - user can view and edit wallet
              4.Previous payments and requests - user can view previous payments and requests
              5.Status of payment requests - updates of payments requests
              
              
              
6.Vehicle Rental System
 
    Classes - Main.java,Veh.java,User.java,Rent.java
    
Main.java - is a main file where all operations are coded
Veh.java - is a template for vehicle behaviour and attributes
User.java - is a template for user behaviour and attributes
Rent.java - is a template for all renting

Login - Admin,User

Admin :
   Username - kpradmin
   Password - admin@123
  
  
   Admin Page :
   
          1.Add a vehicle - admin can add a vehicle and 
          2.Modify vehicle - modification of vehicle
          3.Delete vehicle - vehicle deletion
          4.Review all vehicles - review of vehicles
          5.Search a vehicle - vehicle search
          6.Edit user wallet deposit - admin can edit user wallet
          7.Service the vehicles - vehicles services
          8.Vehicle return and fine regulation - Fine management
          9.Vechicles not rented at all - Not rented vehicles list
          
 User :
     1.New user - Register through name,Password 
      !!!Alert - After registeration user should note the user Id, this id used for future access purpose
      
      
      User Page :
      
             1.Rent a vehicle - vehicle rent
             2.Add a vehicle to cart - add vehicle to cart
             3.Remove a vehicle from cart - vehicle removal from cart
             4.View cart - cart view
             5.Wallet balance - User wallet balance  
             6.Previous rentals - user's previous rentals 
             7.Fines - user's fines
