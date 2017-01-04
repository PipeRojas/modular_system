-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-01-04 05:39:10.319

-- foreign keys
ALTER TABLE Modules_Dev_Doc
    DROP CONSTRAINT Modules_Dev_Doc_Documents;

ALTER TABLE Modules_Dev_Doc
    DROP CONSTRAINT Modules_Dev_Doc_Modules;

ALTER TABLE Modules_Start_Doc
    DROP CONSTRAINT Modules_Doc_Documents;

ALTER TABLE Modules_Start_Doc
    DROP CONSTRAINT Modules_Doc_Modules;

ALTER TABLE Modules_Submodules
    DROP CONSTRAINT Modules_Submodules_Modules1;

ALTER TABLE Modules_Submodules
    DROP CONSTRAINT Modules_Submodules_Modules2;

ALTER TABLE Modules
    DROP CONSTRAINT Modules_Users;

-- tables
DROP TABLE Documents;

DROP TABLE Modules;

DROP TABLE Modules_Dev_Doc;

DROP TABLE Modules_Start_Doc;

DROP TABLE Modules_Submodules;

DROP TABLE Users;

-- End of file.
