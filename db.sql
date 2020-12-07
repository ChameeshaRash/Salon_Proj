DROP DATABASE SALON;
CREATE DATABASE SALON;
USE SALON;

create table LogIn(
                    logInID  int auto_increment primary key,
                    userName varchar(100) not null,
                    password varchar(400) not null,
                    salt     varchar(400) not null
);
CREATE TABLE TreatmentType(
                            TreatTypeID varchar(8),
                            TDescription varchar(20),
                            TPrice decimal(10,2),

                            CONSTRAINT PRIMARY KEY(TreatTypeID)
);
CREATE TABLE SkinType(
                       SkinTypeID varchar(8),
                       SDescription varchar(20),
                       Sprice decimal(10,2),
                       CONSTRAINT PRIMARY KEY(SkinTypeID)
);
CREATE TABLE HairType(
                       HairTypeID varchar(8),
                       HDescription varchar(20),
                       HPrice decimal(10,2),
                       CONSTRAINT PRIMARY KEY(HairTypeID)

);
CREATE TABLE ProductType(
                          ProductTypeID varchar(8),
                          PDescription varchar(20),
                          PPrice decimal(10,2),
                          CONSTRAINT PRIMARY KEY(ProductTypeID)

);




CREATE TABLE Appointment(
                          AppID varchar(8),
                          CustName varchar(20) not null,
                          TelNo varchar(15),
                          AppDate varchar(15),
                          AppTime varchar(15),
                          TreatTypeID varchar(8),
                          SkinTypeID varchar(8),
                          HairTypeID varchar(8),
                          ProductTypeID varchar(8),
                          HPrice decimal(10,2),
                          Sprice decimal(10,2),
                          PPrice decimal(10,2),
                          TPrice decimal(10,2),
                          CONSTRAINT PRIMARY KEY(AppID,TreatTypeID,SkinTypeID,HairTypeID,ProductTypeID ),
                          CONSTRAINT FOREIGN KEY(TreatTypeID) REFERENCES TreatmentType(TreatTypeID) ON UPDATE CASCADE ON DELETE CASCADE,
                          CONSTRAINT FOREIGN KEY(SkinTypeID) REFERENCES SkinType(SkinTypeID) ON UPDATE CASCADE ON DELETE CASCADE,
                          CONSTRAINT FOREIGN KEY(HairTypeID) REFERENCES HairType(HairTypeID) ON UPDATE CASCADE ON DELETE CASCADE,
                          CONSTRAINT FOREIGN KEY(ProductTypeID) REFERENCES ProductType(ProductTypeID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Treatment(
                        TreatmentID varchar(8),
                        PreCheTreatBefore varchar(10),
                        PreMedTreatBefore varchar(10),
                        AllergyTest varchar(10),
                        TreatDate varchar(10),
                        TreatTime varchar(10),
                        AppID varchar(8),
                        CONSTRAINT PRIMARY KEY (TreatmentID,AppID),
                        CONSTRAINT FOREIGN KEY(AppID) REFERENCES Appointment(AppID) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE Payment(
                      PayID varchar(8),
                      AppID varchar(8),
                      Totle decimal (10,2),
                      Amount decimal(10,2),
                      Balance decimal(10,2),
                      CONSTRAINT PRIMARY KEY(PayID,AppID),
                      CONSTRAINT FOREIGN KEY(AppID) REFERENCES Appointment(AppID) ON UPDATE CASCADE ON DELETE CASCADE


);

CREATE TABLE TreatementDetails(
                                TreatmentID varchar(8),
                                TreatTypeID varchar(8),
                                ProductTypeID varchar(8),
                                HairTypeID varchar(8),
                                SkinTypeID varchar(8),
                                constraint primary key(TreatmentID,TreatTypeID,ProductTypeID,HairTypeID,SkinTypeID),
                                CONSTRAINT FOREIGN KEY(TreatmentID) REFERENCES Treatment(TreatmentID) ON UPDATE CASCADE ON DELETE CASCADE,
                                CONSTRAINT FOREIGN KEY(TreatTypeID) REFERENCES TreatmentType(TreatTypeID) ON UPDATE CASCADE ON DELETE CASCADE,
                                CONSTRAINT FOREIGN KEY(ProductTypeID) REFERENCES ProductType(ProductTypeID) ON UPDATE CASCADE ON DELETE CASCADE,
                                CONSTRAINT FOREIGN KEY(HairTypeID) REFERENCES HairType(HairTypeID) ON UPDATE CASCADE ON DELETE CASCADE,
                                CONSTRAINT FOREIGN KEY(SkinTypeID) REFERENCES SkinType(SkinTypeID) ON UPDATE CASCADE ON DELETE CASCADE
);






