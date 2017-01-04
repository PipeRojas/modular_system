-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-01-04 05:39:10.319

-- tables
-- Table: Documents
CREATE TABLE Documents (
    name varchar(100)  NOT NULL,
    uri varchar(100)  NOT NULL,
    CONSTRAINT Documents_pk PRIMARY KEY (name)
);

-- Table: Modules
CREATE TABLE Modules (
    name varchar(100)  NOT NULL,
    owner varchar(100)  NOT NULL,
    startDate timestamp  NOT NULL,
    text1 varchar(100)  NOT NULL,
    selection1 varchar(100)  NOT NULL,
    estimatedDate timestamp  NOT NULL,
    text2 varchar(100)  NOT NULL,
    selection2 varchar(100)  NOT NULL,
    finalDate timestamp  NULL,
    iteration boolean  NULL,
    observations varchar(100)  NULL,
    CONSTRAINT Modules_pk PRIMARY KEY (name)
);

-- Table: Modules_Dev_Doc
CREATE TABLE Modules_Dev_Doc (
    Documents_name varchar(100)  NOT NULL,
    Modules_name varchar(100)  NOT NULL,
    CONSTRAINT Modules_Dev_Doc_pk PRIMARY KEY (Documents_name,Modules_name)
);

-- Table: Modules_Start_Doc
CREATE TABLE Modules_Start_Doc (
    Documents_name varchar(100)  NOT NULL,
    Modules_name varchar(100)  NOT NULL,
    CONSTRAINT Modules_Start_Doc_pk PRIMARY KEY (Documents_name,Modules_name)
);

-- Table: Modules_Submodules
CREATE TABLE Modules_Submodules (
    Modules_name varchar(100)  NOT NULL,
    Modules_submodule varchar(100)  NOT NULL,
    CONSTRAINT Modules_Submodules_pk PRIMARY KEY (Modules_name,Modules_submodule)
);

-- Table: Users
CREATE TABLE Users (
    name varchar(100)  NOT NULL,
    text varchar(100)  NOT NULL,
    selection varchar(100)  NOT NULL,
    CONSTRAINT Users_pk PRIMARY KEY (name)
);

-- foreign keys
-- Reference: Modules_Dev_Doc_Documents (table: Modules_Dev_Doc)
ALTER TABLE Modules_Dev_Doc ADD CONSTRAINT Modules_Dev_Doc_Documents
    FOREIGN KEY (Documents_name)
    REFERENCES Documents (name)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Modules_Dev_Doc_Modules (table: Modules_Dev_Doc)
ALTER TABLE Modules_Dev_Doc ADD CONSTRAINT Modules_Dev_Doc_Modules
    FOREIGN KEY (Modules_name)
    REFERENCES Modules (name)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Modules_Doc_Documents (table: Modules_Start_Doc)
ALTER TABLE Modules_Start_Doc ADD CONSTRAINT Modules_Doc_Documents
    FOREIGN KEY (Documents_name)
    REFERENCES Documents (name)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Modules_Doc_Modules (table: Modules_Start_Doc)
ALTER TABLE Modules_Start_Doc ADD CONSTRAINT Modules_Doc_Modules
    FOREIGN KEY (Modules_name)
    REFERENCES Modules (name)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Modules_Submodules_Modules1 (table: Modules_Submodules)
ALTER TABLE Modules_Submodules ADD CONSTRAINT Modules_Submodules_Modules1
    FOREIGN KEY (Modules_name)
    REFERENCES Modules (name)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Modules_Submodules_Modules2 (table: Modules_Submodules)
ALTER TABLE Modules_Submodules ADD CONSTRAINT Modules_Submodules_Modules2
    FOREIGN KEY (Modules_submodule)
    REFERENCES Modules (name)  
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

-- End of file.
