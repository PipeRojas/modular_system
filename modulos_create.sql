-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-01-15 00:08:42.741

-- tables
-- Table: Modules
CREATE TABLE Modules (
    name varchar(100)  NOT NULL,
    owner varchar(100)  NOT NULL,
    startDate timestamp  NOT NULL,
    textS varchar(100)  NULL,
    selectionS varchar(100)  NULL,
    frecuency boolean  NULL,
    estimatedDate timestamp  NULL,
    textD varchar(100)  NULL,
    selectionD varchar(100)  NULL,
    iteration boolean  NULL,
    finalDate timestamp  NULL,
    textE varchar(100)  NULL,
    selectionE varchar(100)  NULL,
    finalRemarks varchar(100)  NULL,
    CONSTRAINT Modules_pk PRIMARY KEY (name)
);

-- Table: Modules_Dev_Doc
CREATE TABLE Modules_Dev_Doc (
    Modules_name varchar(100)  NOT NULL,
    uri varchar(100)  NOT NULL,
    CONSTRAINT Modules_Dev_Doc_pk PRIMARY KEY (Modules_name,uri)
);

-- Table: Modules_Remarks
CREATE TABLE Modules_Remarks (
    Modules_name varchar(100)  NOT NULL,
    remark varchar(100)  NOT NULL,
    CONSTRAINT Modules_Remarks_pk PRIMARY KEY (Modules_name,remark)
);

-- Table: Modules_Start_Doc
CREATE TABLE Modules_Start_Doc (
    Modules_name varchar(100)  NOT NULL,
    uri varchar(100)  NOT NULL,
    CONSTRAINT Modules_Start_Doc_pk PRIMARY KEY (Modules_name,uri)
);

-- Table: Modules_Submodules
CREATE TABLE Modules_Submodules (
    Modules_name varchar(100)  NOT NULL,
    Modules_submodule varchar(100)  NOT NULL,
    CONSTRAINT Modules_Submodules_pk PRIMARY KEY (Modules_name,Modules_submodule)
);

-- Table: User_Authentication
CREATE TABLE User_Authentication (
   username varchar(100)  NOT NULL,
   password varchar(100)  NOT NULL,
   salt varchar(100)  NOT NULL,
   enabled boolean  NOT NULL,
   CONSTRAINT User_Authentication_pk PRIMARY KEY (username)
);

-- Table: User_Roles
CREATE TABLE User_Roles (
   id serial  NOT NULL,
   username varchar(100)  NOT NULL,
   role varchar(100)  NOT NULL,
   CONSTRAINT User_Roles_ak_1 UNIQUE (username, role) NOT DEFERRABLE  INITIALLY IMMEDIATE,
   CONSTRAINT User_Roles_pk PRIMARY KEY (id)
);

-- Table: Users
CREATE TABLE Users (
    name varchar(100)  NOT NULL,
    text varchar(100)  NOT NULL,
    selection varchar(100)  NOT NULL,
    CONSTRAINT Users_pk PRIMARY KEY (name)
);

-- foreign keys
-- Reference: Modules_Dev_Doc_Modules (table: Modules_Dev_Doc)
ALTER TABLE Modules_Dev_Doc ADD CONSTRAINT Modules_Dev_Doc_Modules
    FOREIGN KEY (Modules_name)
    REFERENCES Modules (name)
    ON DELETE  CASCADE 
    ON UPDATE  CASCADE 
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Modules_Doc_Modules (table: Modules_Start_Doc)
ALTER TABLE Modules_Start_Doc ADD CONSTRAINT Modules_Doc_Modules
    FOREIGN KEY (Modules_name)
    REFERENCES Modules (name)
    ON DELETE  CASCADE 
    ON UPDATE  CASCADE 
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Modules_Remarks_Modules (table: Modules_Remarks)
ALTER TABLE Modules_Remarks ADD CONSTRAINT Modules_Remarks_Modules
    FOREIGN KEY (Modules_name)
    REFERENCES Modules (name)
    ON DELETE  CASCADE 
    ON UPDATE  CASCADE 
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Modules_Submodules_Modules1 (table: Modules_Submodules)
ALTER TABLE Modules_Submodules ADD CONSTRAINT Modules_Submodules_Modules1
    FOREIGN KEY (Modules_name)
    REFERENCES Modules (name)
    ON DELETE  CASCADE 
    ON UPDATE  CASCADE 
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Modules_Submodules_Modules2 (table: Modules_Submodules)
ALTER TABLE Modules_Submodules ADD CONSTRAINT Modules_Submodules_Modules2
    FOREIGN KEY (Modules_submodule)
    REFERENCES Modules (name)
    ON DELETE  CASCADE  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Modules_Users (table: Modules)
ALTER TABLE Modules ADD CONSTRAINT Modules_Users
    FOREIGN KEY (owner)
    REFERENCES Users (name)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: User_Authentication_Users (table: User_Authentication)
ALTER TABLE User_Authentication ADD CONSTRAINT User_Authentication_Users
    FOREIGN KEY (username)
    REFERENCES Users (name)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: User_Roles_Users (table: User_Roles)
ALTER TABLE User_Roles ADD CONSTRAINT User_Roles_Users
    FOREIGN KEY (username)
    REFERENCES Users (name)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

