##########################################################
##################### TEST YOUR SKILLS ####################
###########################################################

SELECT * FROM Kidus_DB.accounts_customers

SELECT * FROM Kidus_DB.accounts a 

SELECT * FROM Kidus_DB.address a 

SELECT * FROM Kidus_DB.customers c 

select * FROM accounts a 
JOIN accounts_customers ac on ac.account_id = a.account_id 
JOIN customers c on c.customer_id = ac.customer_id 
JOIN address ad on ad.address_id = c.address_id 


################################### -- TEST MY SKIL ------
#####################################################################################
####### Get a list of all customers with the last name "Smith".
SELECT * FROM customers c 
WHERE name LIKE '%Smith'
###### Get the total balance of all accounts held by the Smiths.

SELECT sum(a.balance) FROM accounts a 
JOIN accounts_customers ac on ac.account_id = a.account_id 
JOIN customers c on ac.customer_id = c.customer_id 
WHERE c.name LIKE '%Smith'
##### Get the name and address of any customer with less than $50 in an account. (No duplicates!)

SELECT c.name , ad.address, a.balance FROM accounts a 
JOIN accounts_customers ac on ac.account_id = a.account_id 
JOIN customers c on ac.customer_id = c.customer_id 
JOIN address ad on ad.address_id = c.address_id 
WHERE a.balance < 50 ;


###### Get a list of all the customers who live in Texas.
SELECT * FROM customers c 
JOIN address a on a.address_id = c.address_id 
WHERE a.state = 'TX';

# #### Add $100 gift to any accounts belonging to customers in New York

UPDATE accounts a 

JOIN accounts_customers ac on ac.account_id = a.account_id 
JOIN customers c on c.customer_id = ac.customer_id 
JOIN address ad on ad.address_id = c.address_id 
set a.balance=balance + 100
WHERE ad.state ='NY';

### --- Not sure for this I will be back ---# Transfer $199.99 from Jason Smith to Amanda Smith

UPDATE accounts a 
JOIN accounts_customers ac on ac.account_id = a.account_id 
JOIN customers c on c.customer_id = ac.customer_id 
SET a.balance=balance - 199.99
WHERE c.customer_id =1 
&& a.balance = balance + 199.99 WHERE c.customer_id = 2;

# Change Amanda Smith's last name to "Lastname"
update customers 
set name=REPLACE('Amanda Smith','Smith','Lastname')
WHERE customer_id =2;