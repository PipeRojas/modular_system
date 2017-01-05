-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-01-05 02:41:34.906

-- tables
-- Table: Modules
CREATE TABLE Modules (
    name varchar(100)  NOT NULL,
    owner varchar(100)  NOT NULL,
    startDate timestamp  NOT NULL,
    textS varchar(100)  NOT NULL,
    selectionS varchar(100)  NOT NULL,
    estimatedDate timestamp  NOT NULL,
    textD varchar(100)  NOT NULL,
    selectionD varchar(100)  NOT NULL,
    iteration boolean  NOT NULL,
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

-- Reference: Modules_Remarks_Modules (table: Modules_Remarks)
ALTER TABLE Modules_Remarks ADD CONSTRAINT Modules_Remarks_Modules
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
