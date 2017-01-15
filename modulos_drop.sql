-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-01-15 00:08:42.741

-- foreign keys
ALTER TABLE Modules_Dev_Doc
    DROP CONSTRAINT Modules_Dev_Doc_Modules;

ALTER TABLE Modules_Start_Doc
    DROP CONSTRAINT Modules_Doc_Modules;

ALTER TABLE Modules_Remarks
    DROP CONSTRAINT Modules_Remarks_Modules;

ALTER TABLE Modules_Submodules
    DROP CONSTRAINT Modules_Submodules_Modules1;

ALTER TABLE Modules_Submodules
    DROP CONSTRAINT Modules_Submodules_Modules2;

ALTER TABLE Modules
    DROP CONSTRAINT Modules_Users;

ALTER TABLE User_Authentication
    DROP CONSTRAINT User_Authentication_Users;

ALTER TABLE User_Roles
    DROP CONSTRAINT User_Roles_Users;

-- tables
DROP TABLE Modules;

DROP TABLE Modules_Dev_Doc;

DROP TABLE Modules_Remarks;

DROP TABLE Modules_Start_Doc;

DROP TABLE Modules_Submodules;

DROP TABLE User_Authentication;

DROP TABLE User_Roles;

DROP TABLE Users;

-- End of file.

