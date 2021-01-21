<p align="center">
  <img width="250" height="280" src="Mockup/nsulogo.png">
</p>                                        









  <h1 align="center">Project Name: Shop Online</h1>
  <h2 align ="center">Course Number: CSE299<br>
  Section:03</br>
  Group:03</br>
  Semester: Fall 2020</br><br>
  Faculty Name: Shaikh Shawon Arefin Shimon</h2>
  <h3 align="center">Student Name: Md Abir Hossain<br>

  Student ID: 1731597042<br>
  Email: abir.hossain04@northsouth.edu <br><br>
  Date prepared: 21/01/2020</h3><br><br><br>










<h2> Project Name: Shop Online </h2><br>
<h3 id="table-of-contents">Table of contents</h3>

<ol>
  <a href="#introduction"><li>Introduction</li><br></a>
  <a href="#features"><li>Features</li><br></a>
  <a href="#Technology"><li>Technology</li><br></a>
  <a href="#Design"><li>Monetization</li></a><br>
  <a href="#conclusion"><li>Roadblocks</li></a><br>
   href="#conclusion"><li>Roadblocks</li></a><br><br>

</ol>
<br>


<h2 id="#introduction">1. Introduction</h2>
<h3>1.1 Project Idea:</h3>
<p>In this modern global economy e-commerce platforms are getting more and more popular. Because e-commerce offers better marketing opportunities, more convenient, reduces cost and can make anyone’s business global. Here store remains open all the time. Users can order anything anytime, and it also have maximum security of transaction. Through this platform anyone can easily keep in touch with their customers.

I tried to make an android application which will have all the functionalities of a modern e-commerce platform. Here users will find their various types of products such as clothing, shoes, watch, computer/laptop, jewelry, vehicle etc. They will make their own account in this app and from their account they will be able to order these
</p>

<h2 id="features">2. Features</h2>
This project has the following features -
<!--user regestration-->
<h3>2.1 User Registration:</h3>
  To access any platform users first have to register. Users must include userimage,username, firstname, lastname,email and password, phone number, address.
   <br>
   <br>
 <p align="center">
  <img width="200" height="420" src="images/userSignup.PNG"><br>
 </p>
 <!--vendor regestration-->
 If the user is a vendor then he/she have to give some aditional information. Vendor must include delivery fee,shop name. 
  <p align="center">
 <img width="200" height="420" src="images/sellerSignUp.PNG"><br>
 </p>

 <h3>2.2 Login :</h3>
  Clients and vendors will have to login by providing their email and password<br>
  <br>


  <p align="center">
 <img width="200" height="420" src="images/login.PNG"><br>

</p>
<h3>2.3 Forgot Password:</h3>
  Clients and vendors will be able to reset their passwords if they forgets their password<br>
  <br>

  <p align="center">
 <img width="200" height="420" src="images/forgotPass.PNG"><br>

</p>
<br>
<br>
  <h3>2.4 Currently the following functions are available for clients -</h3>
  <p>
    * Clients can see all the restaurants that are nearby them.<br>
      <p align="center">
 <img width="200" height="420" src="images/clientHomePage.PNG"><br>
</p>


* Clients can enter those restaurants and see the details of those restaurants and the food items that are available there <br>
 <p align="center">
<img width="200" height="420" src="images/shopDetails.PNG"><br>
</p>
 * Clients can search foods by name or by category <br>
<p align="center">
 <img width="200" height="420" src="images/searchFoodName.PNG"><br>
</p>
 <p align="center">
 <img width="200" height="420" src="images/searchFoodCat.PNG"><br>
</p>
 * Clients can can select those foods and add those foods to their cart</p> 
 <p align="center">
  <img width="200" height="420" src="images/addToCart.PNG"><br>
</p>  
<h3>2.5 Vendor Side:</h3>
There is also a vendor side in this app<br>
* Vendors will be able to see all the foods that are available when they logs in
<p align="center">
<img width="200" height="420" src="images/vendorHome.PNG"><br>
</p>
* Vendors will be able to add food items
<p align="center">
<img width="200" height="420" src="images/addFood.PNG"><br>
</p>
* Vendors will be search foods by category or name
<p align="center">
<img width="200" height="420" src="images/searchVCat.PNG"><br>
</p>
<p align="center">
<img width="200" height="420" src="images/searchVN.PNG"><br>
</p>
* Vendors will be search remove foods
<p align="center">
<img width="200" height="420" src="images/removeFood.PNG"><br>
</p>
 <h2 id="#data">3.Data Management</h2>
 <p>For Data management i have used both firebase and sqlite. In this app firebase was widely used.Firebase is Google's mobile platform that helps you quickly develop high-quality apps and grow your business. This apps login registration is done by firebase authentication.Realtime Database is Firebase's original database. It's an efficient, low-latency solution for mobile apps that require synced states across clients in realtime. I used firebase realtime database to keep the user data. And for storing the images i used firebase storage.Cloud Storage for Firebase is a powerful, simple, and cost-effective object storage service built for Google scale. Sqlite was used to store the cart items that user was storing in his app </p>



<h2 id="#Design">4. Design Pattern</h2>
<p>
No design pattern was followed for making this app. Firebase database is a noSql database and it stores data in tree format.</p>

<h2>5. Roadblocks</h2>
<p id="#Roadblocks">
There are some roadblocks i had to face while making this app. First roadblock was google map integration. Google map does not give right location while working in emulator. So all the users and vendors are registering with same location for now. But when in mobile device it gets fixed. Then i faced a problem with resting passwor. Because I made a mistake while checking if its a correct email format. I did not use navigation drawer which i wanted to do. But could not do it becuse android got updated and now navigation activity comes with fragment. In search option i also faced some problem. While i was writing food category names the food was not appearing then i found out that my adapter name was wrong and fixed it. But still it has a problem i could not change the hints of the search as i give input into the search bar. And the last problem i faced today is showing the cart dialog to the client. In the logcat it shows me that i did not set adapter for my cart dialog but in code i did set the adapter. The app is not yet in a complete as i couldn't finish the ordering process. </p>