--Users table
insert into Users (name,text,selection) 
	values ('user','test user text','test user selection');
insert into Users (name,text,selection) 
	values ('user2','test user2 text','test user2 selection');
insert into Users (name,text,selection) 
	values ('user11','test user11 text','test user11 selection');
insert into Users (name,text,selection) 
	values ('user12','test user12 text','test user12 selection');

--User_Roles
insert into User_Roles(username,role)
	values('user','ROLE_USER');
insert into User_Roles(username,role)
	values('user2','ROLE_USER');
insert into User_Roles(username,role)
	values('user11','ROLE_USER');
insert into User_Roles(username,role)
	values('user12','ROLE_USER');

--Users_Authentication
--123
--insert into User_Authentication (username,password,salt)
	--values ('user','202cb962ac59075b964b07152d234b70','');
insert into User_Authentication (username,password,salt,enabled)
	values ('user','123','',true);
--234
--insert into User_Authentication (username,password,salt)
	--values ('user2','289dff07669d7a23de0ef88d2f7129e7','');
insert into User_Authentication (username,password,salt,enabled)
	values ('user2','234','',true);
--1123
--insert into User_Authentication (username,password,salt)
	--values ('user11','2cfd4560539f887a5e420412b370b361','');
insert into User_Authentication (username,password,salt,enabled)
	values ('user11','1123','',true);
--2234
--insert into User_Authentication (username,password,salt)
	--values ('user12','202cb962ac59075b964b07152d234b70','');
insert into User_Authentication (username,password,salt,enabled)
	values ('user12','2234','',true);

--Modules table
insert into Modules (name,owner,startDate,textS,selectionS,frecuency,estimatedDate,textD,selectionD,iteration,finalDate,textE,selectionE,finalRemarks) 
	values ('module','user','2016-12-20','test text s','test selection s',true,'2016-12-21','test text d','test selection d',false,'2016-12-21','test text e','test selection e','');
insert into Modules (name,owner,startDate,textS,selectionS,frecuency,estimatedDate,textD,selectionD,iteration,finalDate,textE,selectionE,finalRemarks) 
	values ('module2','user2','2016-12-20','test text s2','test selection s2',false,'2016-12-21','test text d2','test selection d2',true,'2016-12-21','test text e2','test selection e2','');
insert into Modules (name,owner,startDate,textS,selectionS,frecuency,estimatedDate,textD,selectionD,iteration,finalDate,textE,selectionE,finalRemarks) 
	values ('sub-module11','user11','2016-12-20','test text s11','test selection s11',true,'2016-12-21','test text d11','test selection d11',false,'2016-12-21','test text e11','test selection e11','');
insert into Modules (name,owner,startDate,textS,selectionS,frecuency,estimatedDate,textD,selectionD,iteration,finalDate,textE,selectionE,finalRemarks) 
	values ('sub-module12','user12','2016-12-20','test text s12','test selection s12',true,'2016-12-21','test text d12','test selection d12',false,'2016-12-21','test text e12','test selection e12','');

--Modules_Remarks table
insert into Modules_Remarks (Modules_name,remark)
	values ('module','first main');
insert into Modules_Remarks (Modules_name,remark)
	values ('module2','second main');
insert into Modules_Remarks (Modules_name,remark)
	values ('sub-module11','first sub');
insert into Modules_Remarks (Modules_name,remark)
	values ('sub-module12','second sub');

--Modules_Start_Doc table
insert into Modules_Start_Doc (Modules_name,uri)
	values ('module','testfile.txt');

--Modules_Dev_Doc table
insert into Modules_Dev_Doc (Modules_name,uri)
	values ('module','testfile2.txt');

--Modules_Submodules table
insert into Modules_Submodules (Modules_name,Modules_submodule)
	values ('module','sub-module11');
insert into Modules_Submodules (Modules_name,Modules_submodule)
	values ('module','sub-module12');

-- End of file.

