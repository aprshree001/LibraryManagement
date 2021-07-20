insert into library(LIBRARY_ID,LIBRARY_NAME) VALUES (1,'INDIAN LIBRARY');
insert into book (book_id,author_name,library_id,no_of_copies,publisher,title) 
	VALUES ('120','Aparna',1,3,'priyansh','bepositive');
insert into book (book_id,author_name,library_id,no_of_copies,publisher,title) 
	VALUES ('121','Srivastav',1,2,'priyansh','beinnovative');

insert into book (book_id,author_name,library_id,no_of_copies,publisher,title) 
	VALUES ('122','Abhinav',1,1,'priyansh','becourageous');

insert into user(user_id,first_name,last_name,email) 
	values ('1','amit','kumar','amitkumar@gmail.com');



insert into user(user_id,first_name,last_name,email) 
	values ('2','ankita','singh','aksinghgmail.com');


insert into limit_table (limit_id,limit_name,limit_value) values('1','MAX_BOOK_BORROW_LIMIT',2);

insert into limit_table (limit_id,limit_name,limit_value)  values('2','BOOK_COPIES_BORROW_LIMIT',1);
