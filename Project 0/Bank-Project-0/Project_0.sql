DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS customers_to_accounts;
DROP TABLE IF EXISTS accounts;

CREATE TABLE bank_accounts
(
	account_id INT AUTO_INCREMENT,
	balance FLOAT,
	INDEX (account_id),
	CONSTRAINT bank_accounts_pk PRIMARY KEY (account_id)
);

CREATE TABLE accounts_customers
(
	junction_id INT AUTO_INCREMENT,
	customer_id INT NOT NULL,
	account_id	INT NOT NULL,
	INDEX (customer_id),
	INDEX(account_id),
	CONSTRAINT accounts_customers_pk PRIMARY KEY (junction_id),
	CONSTRAINT accounts_customers_fk FOREIGN KEY (account_id) REFERENCES bank_accounts(account_id)
);

CREATE TABLE bank_customers
(
	customer_id INT AUTO_INCREMENT,
	name 	VARCHAR(50),
	user_name	VARCHAR(50),
	password    VARCHAR(50),
	INDEX (customer_id),
	CONSTRAINT bank_customers_pk PRIMARY KEY (customer_id),
	CONSTRAINT bank_customers_fk FOREIGN KEY (customer_id) REFERENCES accounts_customers(customer_id)
);

INSERT INTO bank_accounts (account_id, balance) VALUES (100, 1000.00);
INSERT INTO accounts_customers (customer_id, account_id) VALUES (1, 100);
INSERT INTO bank_customers (customer_id, name, user_name,password) VALUES (1,'kidus','kid','kid')

select * from accounts_customers ac2 
select * FROM bank_accounts ba 
join accounts_customers ac on ac.account_id = ba.account_id 
JOIN bank_customers bc on bc.customer_id =ac.customer_id 
SELECT * FROM bank_customers bc 

select * from bank_accounts ba order by account_id DESC limit 1